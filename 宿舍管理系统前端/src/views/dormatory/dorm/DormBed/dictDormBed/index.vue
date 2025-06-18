<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="区域编号" prop="areaNumber">
        <el-input
          v-model="queryParams.areaNumber"
          placeholder="请输入区域编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
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
      <el-form-item label="工号" prop="jobnumber">
        <el-input
          v-model="queryParams.jobnumber"
          placeholder="请输入工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="一级部门" prop="department1">
        <el-input
          v-model="queryParams.department1"
          placeholder="请输入一级部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二级部门" prop="department2">
        <el-input
          v-model="queryParams.department2"
          placeholder="请输入二级部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="三级部门" prop="department3">
        <el-input
          v-model="queryParams.department3"
          placeholder="请输入三级部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="岗位" prop="job">
        <el-input
          v-model="queryParams.job"
          placeholder="请输入岗位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系方式" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入联系方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="床位是否住人" prop="checkInwhether">
        <el-input
          v-model="queryParams.checkInwhether"
          placeholder="请输入床位是否住人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="床位号" prop="bednumber">
        <el-input
          v-model="queryParams.bednumber"
          placeholder="请输入床位号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
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
          v-hasPermi="['DormBed:bed:add']"
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
          v-hasPermi="['DormBed:bed:edit']"
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
          v-hasPermi="['DormBed:bed:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['DormBed:bed:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['DormBed:bed:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-close"
          plain
          size="mini"
          @click="close()"
        >返回</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="bedList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="sex">
        <template slot-scope="scope">
          <span v-if="scope.row.sex=='0'">{{"女"}}</span>
          <span v-if="scope.row.sex=='1'">{{"男"}}</span>
        </template>
      </el-table-column>
      <el-table-column label="身份证号" align="center" prop="idnumber" />
      <el-table-column label="工号" align="center" prop="jobnumber" />
      <el-table-column label="一级部门" align="center" prop="department1" />
      <el-table-column label="二级部门" align="center" prop="department2" />
      <el-table-column label="三级部门" align="center" prop="department3" />
      <el-table-column label="岗位" align="center" prop="job" />
      <el-table-column label="联系方式" align="center" prop="phone" />
      <el-table-column label="床位状态" align="center" prop="bedstatus" />
      <el-table-column label="床位是否住人" align="center" prop="checkInwhether" />
      <el-table-column label="床位号" align="center" prop="bednumber" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['DormBed:bed:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['DormBed:bed:remove']"
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

    <!-- 添加或修改床位信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body v-dialogDrag>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="区域编号" prop="areaNumber">
          <el-input v-model="form.areaNumber" placeholder="请输入区域编号" />
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
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-input v-model="form.sex" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idnumber">
          <el-input v-model="form.idnumber" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="工号" prop="jobnumber">
          <el-input v-model="form.jobnumber" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="一级部门" prop="department1">
          <el-input v-model="form.department1" placeholder="请输入一级部门" />
        </el-form-item>
        <el-form-item label="二级部门" prop="department2">
          <el-input v-model="form.department2" placeholder="请输入二级部门" />
        </el-form-item>
        <el-form-item label="三级部门" prop="department3">
          <el-input v-model="form.department3" placeholder="请输入三级部门" />
        </el-form-item>
        <el-form-item label="岗位" prop="job">
          <el-input v-model="form.job" placeholder="请输入岗位" />
        </el-form-item>
        <el-form-item label="联系方式" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="床位是否住人" prop="checkInwhether">
          <el-input v-model="form.checkInwhether" placeholder="请输入床位是否住人" />
        </el-form-item>
        <el-form-item label="床位号" prop="bednumber">
          <el-input v-model="form.bednumber" placeholder="请输入床位号" />
        </el-form-item>
        <el-form-item label="床位状态" prop="bedstatus">
          <el-input v-model="form.bedstatus" placeholder="请输入床位状态" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
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
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的床位数据
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
import {listBed, getBed, delBed, addBed, updateBed, listBed2} from "@/api/DormBed/bed";
import {getToken} from "@/utils/auth";

export default {
  name: "Bed",
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
      // 床位信息表格数据
      bedList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        areaNumber: null,
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        name: null,
        sex: null,
        idnumber: null,
        jobnumber: null,
        department1: null,
        department2: null,
        department3: null,
        job: null,
        phone: null,
        bedstatus: null,
        checkInwhether: null,
        bednumber: null,
        remarks: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
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
        url: process.env.VUE_APP_BASE_API + "/DormBed/bed/importData"
      },
    };
  },
  created() {
    console.info(this.$route.params);
    //alert(this.$route.params);
    this.getList(this.$route.params && this.$route.params.dormbed);
  },
  methods: {
    /** 查询床位信息列表 */
    getList(value) {
      this.loading = true;
      listBed2(value).then(response => {
        this.bedList = response.rows;
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
        areaNumber: null,
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        name: null,
        sex: null,
        idnumber: null,
        jobnumber: null,
        department1: null,
        department2: null,
        department3: null,
        job: null,
        phone: null,
        bedstatus: 0,
        checkInwhether: null,
        bednumber: null,
        remarks: null
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
      this.title = "添加床位信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBed(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改床位信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBed(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBed(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除床位信息编号为"' + ids + '"的数据项？').then(function() {
        return delBed(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('DormBed/bed/export', {
        ...this.queryParams
      }, `bed_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "床位导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('DormBed/bed/importTemplate', {
      }, `床位信息_模板_${new Date().getTime()}.xlsx`)
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
    },
    /** 关闭按钮 */
    close() {
      const obj = { path: "/dormatory/dorm/roominfor" };
      this.$tab.closeOpenPage(obj);
    },
  }
};
</script>
