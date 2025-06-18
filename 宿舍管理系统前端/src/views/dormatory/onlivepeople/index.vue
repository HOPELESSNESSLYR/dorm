<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.people_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="民族" prop="native1">
        <el-input
          v-model="queryParams.native1"
          placeholder="请输入民族"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生日期" prop="birthday">
        <el-date-picker clearable
                        v-model="queryParams.birthday"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="居住地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入居住地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公民身份证号" prop="idnumber">
        <el-input
          v-model="queryParams.idnumber"
          placeholder="请输入公民身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签发机关" prop="company">
        <el-input
          v-model="queryParams.company"
          placeholder="请输入签发机关"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="有效起始日期" prop="begindate">
        <el-date-picker clearable
                        v-model="queryParams.begindate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择有效起始日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="有效截止日期" prop="enddate">
        <el-input
          v-model="queryParams.enddate"
          placeholder="请输入有效截止日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话号码" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入电话号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建录入时间" prop="createdAt">
        <el-date-picker clearable
                        v-model="queryParams.createdAt"
                        type="datetime"
                        value-format="yyyy-MM-dd HH:mm:ss"
                        placeholder="请选择创建录入时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否入住标识" prop="flag">
        <el-input
          v-model="queryParams.flag"
          placeholder="请输入是否入住标识"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="远程地址" prop="remotepath">
        <el-input
          v-model="queryParams.remotepath"
          placeholder="请输入远程地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['dorm:onlivepeople:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['dorm:onlivepeople:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['dorm:onlivepeople:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dorm:onlivepeople:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="onlivepeopleList" @selection-change="handleSelectionChange"  :max-height="maxHeight">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="sex" />
      <el-table-column label="民族" align="center" prop="native1" />
      <el-table-column label="出生日期" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="居住地址" align="center" prop="address" />
      <el-table-column label="公民身份证号" align="center" prop="idnumber" />
      <el-table-column label="签发机关" align="center" prop="company" />
      <el-table-column label="有效起始日期" align="center" prop="begindate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.begindate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="有效截止日期" align="center" prop="enddate" />
      <el-table-column label="电话号码" align="center" prop="phone" />
      <el-table-column label="创建录入时间" align="center" prop="createdAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdAt, '{y}-{m}-{d} {h}:{m}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否入住标识" align="center" prop="flag" />
      <el-table-column label="头像" align="center" prop="remotepath" >
        <template slot-scope="scope">
          <image-preview :src="'http://10.10.10.203:8080/prod-api/profile'+scope.row.remotepath" style="width:70px;height:100px;"/>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dorm:onlivepeople:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dorm:onlivepeople:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改登记入住人员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.people_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="民族" prop="native1">
          <el-input v-model="form.native1" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker clearable
                          v-model="form.birthday"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="居住地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入居住地址" />
        </el-form-item>
        <el-form-item label="公民身份证号" prop="idnumber">
          <el-input v-model="form.idnumber" placeholder="请输入公民身份证号" />
        </el-form-item>
        <el-form-item label="签发机关" prop="company">
          <el-input v-model="form.company" placeholder="请输入签发机关" />
        </el-form-item>
        <el-form-item label="有效起始日期" prop="begindate">
          <el-date-picker clearable
                          v-model="form.begindate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择有效起始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效截止日期" prop="enddate">
          <el-input v-model="form.enddate" placeholder="请输入有效截止日期" />
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话号码" />
        </el-form-item>
        <el-form-item label="创建录入时间" prop="createdAt">
          <el-date-picker clearable
                          v-model="form.createdAt"
                          type="datetime"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="请选择创建录入时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否入住标识" prop="flag">
          <el-input v-model="form.flag" placeholder="请输入是否入住标识 0未入住 1已入住" />
        </el-form-item>
        <el-form-item label="远程地址" prop="remotepath">
          <el-input v-model="form.remotepath" placeholder="请输入远程地址" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOnlivepeople, getOnlivepeople, delOnlivepeople, addOnlivepeople, updateOnlivepeople } from "@/api/dorm/onlivepeople";

export default {
  name: "Onlivepeople",
  dicts: ['checkout_status', 'people_sex'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: false,
      // 总条数
      total: 0,
      // 登记入住人员表格数据
      onlivepeopleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        sex: null,
        native1: null,
        birthday: null,
        address: null,
        idnumber: null,
        company: null,
        begindate: null,
        enddate: null,
        phone: null,
        createdAt: null,
        flag: null,
        remotepath: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询登记入住人员列表 */
    getList() {
      this.loading = true;
      listOnlivepeople(this.queryParams).then(response => {
        this.onlivepeopleList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      //底部滚动条
      this.$nextTick=(()=>{
        this.maxHeight=window.innerHeight-260
      })
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        sex: null,
        native1: null,
        birthday: null,
        address: null,
        idnumber: null,
        company: null,
        begindate: null,
        enddate: null,
        phone: null,
        createdAt: null,
        flag: null,
        remotepath: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加登记入住人员";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOnlivepeople(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改登记入住人员";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOnlivepeople(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOnlivepeople(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除登记入住人员编号为"' + ids + '"的数据项？').then(function() {
        return delOnlivepeople(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dorm/onlivepeople/export', {
        ...this.queryParams
      }, `onlivepeople_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
