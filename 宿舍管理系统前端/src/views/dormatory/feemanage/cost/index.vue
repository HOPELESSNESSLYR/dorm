<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="日期" prop="costDate">
        <el-date-picker clearable
          v-model="queryParams.costDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="区域编号" prop="areaNumber">
        <el-select v-model="queryParams.areaNumber" placeholder="请选择区域编号" clearable>
          <el-option
            v-for="dict in dict.type.dorm_areaNumber"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="宿舍楼编号" prop="floorNumber">
        <el-input
          v-model="queryParams.floorNumber"
          placeholder="请输入宿舍楼编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宿舍楼层号" prop="dormFloor">
        <el-input
          v-model="queryParams.dormFloor"
          placeholder="请输入宿舍楼层号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宿舍房间号" prop="roomNumber">
        <el-input
          v-model="queryParams.roomNumber"
          placeholder="请输入宿舍房间号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工号" prop="jobnumber">
        <el-input
          v-model="queryParams.jobnumber"
          placeholder="请输入工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idnumber">
        <el-input
          v-model="queryParams.idnumber"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="本月人天数" prop="monthDayall">
        <el-input
          v-model="queryParams.monthDayall"
          placeholder="请输入本月人天数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人热水费" prop="personHotwater">
        <el-input
          v-model="queryParams.personHotwater"
          placeholder="请输入个人热水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人冷水费" prop="personColdwater">
        <el-input
          v-model="queryParams.personColdwater"
          placeholder="请输入个人冷水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人电费" prop="personElectric">
        <el-input
          v-model="queryParams.personElectric"
          placeholder="请输入个人电费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共热水费" prop="publicHotwater">
        <el-input
          v-model="queryParams.publicHotwater"
          placeholder="请输入公共热水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共冷水费" prop="publicColdwater">
        <el-input
          v-model="queryParams.publicColdwater"
          placeholder="请输入公共冷水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共电费" prop="publicElectric">
        <el-input
          v-model="queryParams.publicElectric"
          placeholder="请输入公共电费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总费用" prop="costall">
        <el-input
          v-model="queryParams.costall"
          placeholder="请输入总费用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类别" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类别" clearable>
          <el-option
            v-for="dict in dict.type.dorm_person_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['feemanage:cost:add']"
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
          v-hasPermi="['feemanage:cost:edit']"
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
          v-hasPermi="['feemanage:cost:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['feemanage:cost:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['feemanage:cost:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="costList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="日期" align="center" prop="costDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.costDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="区域编号" align="center" prop="areaNumber">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dorm_areaNumber" :value="scope.row.areaNumber"/>
        </template>
      </el-table-column>
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="工号" align="center" prop="jobnumber" />
      <el-table-column label="身份证号" align="center" prop="idnumber" />
      <el-table-column label="本月人天数" align="center" prop="monthDayall" />
      <el-table-column label="个人热水费" align="center" prop="personHotwater" />
      <el-table-column label="个人冷水费" align="center" prop="personColdwater" />
      <el-table-column label="个人电费" align="center" prop="personElectric" />
      <el-table-column label="公共热水费" align="center" prop="publicHotwater" />
      <el-table-column label="公共冷水费" align="center" prop="publicColdwater" />
      <el-table-column label="公共电费" align="center" prop="publicElectric" />
      <el-table-column label="总费用" align="center" prop="costall" />
      <el-table-column label="类别" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dorm_person_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['feemanage:cost:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['feemanage:cost:remove']"
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

    <!-- 添加或修改个人费用明细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="日期" prop="costDate">
          <el-date-picker clearable
            v-model="form.costDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="区域编号" prop="areaNumber">
          <el-select v-model="form.areaNumber" placeholder="请选择区域编号">
            <el-option
              v-for="dict in dict.type.dorm_areaNumber"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="宿舍楼编号" prop="floorNumber">
          <el-input v-model="form.floorNumber" placeholder="请输入宿舍楼编号" />
        </el-form-item>
        <el-form-item label="宿舍楼层号" prop="dormFloor">
          <el-input v-model="form.dormFloor" placeholder="请输入宿舍楼层号" />
        </el-form-item>
        <el-form-item label="宿舍房间号" prop="roomNumber">
          <el-input v-model="form.roomNumber" placeholder="请输入宿舍房间号" />
        </el-form-item>
        <el-form-item label="工号" prop="jobnumber">
          <el-input v-model="form.jobnumber" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idnumber">
          <el-input v-model="form.idnumber" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="本月人天数" prop="monthDayall">
          <el-input v-model="form.monthDayall" placeholder="请输入本月人天数" />
        </el-form-item>
        <el-form-item label="个人热水费" prop="personHotwater">
          <el-input v-model="form.personHotwater" placeholder="请输入个人热水费" />
        </el-form-item>
        <el-form-item label="个人冷水费" prop="personColdwater">
          <el-input v-model="form.personColdwater" placeholder="请输入个人冷水费" />
        </el-form-item>
        <el-form-item label="个人电费" prop="personElectric">
          <el-input v-model="form.personElectric" placeholder="请输入个人电费" />
        </el-form-item>
        <el-form-item label="公共热水费" prop="publicHotwater">
          <el-input v-model="form.publicHotwater" placeholder="请输入公共热水费" />
        </el-form-item>
        <el-form-item label="公共冷水费" prop="publicColdwater">
          <el-input v-model="form.publicColdwater" placeholder="请输入公共冷水费" />
        </el-form-item>
        <el-form-item label="公共电费" prop="publicElectric">
          <el-input v-model="form.publicElectric" placeholder="请输入公共电费" />
        </el-form-item>
        <el-form-item label="总费用" prop="costall">
          <el-input v-model="form.costall" placeholder="请输入总费用" />
        </el-form-item>
        <el-form-item label="类别" prop="type">
          <el-select v-model="form.type" placeholder="请选择类别">
            <el-option
              v-for="dict in dict.type.dorm_person_type"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的个人费用数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;" @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCost, getCost, delCost, addCost, updateCost } from "@/api/feemanage/cost";
import {getToken} from "@/utils/auth";

export default {
  name: "Cost",
  dicts: ['dorm_person_type', 'dorm_areaNumber'],
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
      showSearch: true,
      // 总条数
      total: 0,
      // 个人费用明细表格数据
      costList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        costDate: null,
        areaNumber: null,
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        jobnumber: null,
        idnumber: null,
        monthDayall: null,
        personHotwater: null,
        personColdwater: null,
        personElectric: null,
        publicHotwater: null,
        publicColdwater: null,
        publicElectric: null,
        costall: null,
        type: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        costDate: [
          { required: true, message: "日期不能为空", trigger: "blur" }
        ],
        areaNumber: [
          { required: true, message: "区域编号不能为空", trigger: "change" }
        ],
        floorNumber: [
          { required: true, message: "宿舍楼编号不能为空", trigger: "blur" }
        ],
        dormFloor: [
          { required: true, message: "宿舍楼层号不能为空", trigger: "blur" }
        ],
        roomNumber: [
          { required: true, message: "宿舍房间号不能为空", trigger: "blur" }
        ],
        personHotwater: [
          { required: true, message: "个人热水费不能为空", trigger: "blur" }
        ],
        personColdwater: [
          { required: true, message: "个人冷水费不能为空", trigger: "blur" }
        ],
        personElectric: [
          { required: true, message: "个人电费不能为空", trigger: "blur" }
        ],
        publicHotwater: [
          { required: true, message: "公共热水费不能为空", trigger: "blur" }
        ],
        publicColdwater: [
          { required: true, message: "公共冷水费不能为空", trigger: "blur" }
        ],
        publicElectric: [
          { required: true, message: "公共电费不能为空", trigger: "blur" }
        ],
        costall: [
          { required: true, message: "总费用不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "类别不能为空", trigger: "change" }
        ]
      },
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/feemanage/cost/importData"
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询个人费用明细列表 */
    getList() {
      this.loading = true;
      listCost(this.queryParams).then(response => {
        this.costList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
        costDate: null,
        areaNumber: null,
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        jobnumber: null,
        idnumber: null,
        monthDayall: null,
        personHotwater: null,
        personColdwater: null,
        personElectric: null,
        publicHotwater: null,
        publicColdwater: null,
        publicElectric: null,
        costall: null,
        type: null
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
      this.title = "添加个人费用明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCost(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改个人费用明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCost(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCost(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除个人费用明细编号为"' + ids + '"的数据项？').then(function() {
        return delCost(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('feemanage/cost/export', {
        ...this.queryParams
      }, `cost_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "个人费用导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('feemanage/cost/importTemplate', {
      }, `个人费用信息_模板_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
