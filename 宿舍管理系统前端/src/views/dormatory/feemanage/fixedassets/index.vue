<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
      <el-form-item label="宿舍固定资产编码" prop="dormPropertyNumber">
        <el-input
          v-model="queryParams.dormPropertyNumber"
          placeholder="请输入宿舍固定资产编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宿舍固定资产描述" prop="dormPropertyDescription">
        <el-input
          v-model="queryParams.dormPropertyDescription"
          placeholder="请输入宿舍固定资产描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宿舍固定资产备注" prop="dormPropertyRemarks">
        <el-input
          v-model="queryParams.dormPropertyRemarks"
          placeholder="请输入宿舍固定资产备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总数量" prop="totalnumber">
        <el-input
          v-model="queryParams.totalnumber"
          placeholder="请输入总数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物品单价" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入物品单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="赔偿单价" prop="compensationPrice">
        <el-input
          v-model="queryParams.compensationPrice"
          placeholder="请输入赔偿单价"
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
          v-hasPermi="['feemanage:fixedassets:add']"
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
          v-hasPermi="['feemanage:fixedassets:edit']"
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
          v-hasPermi="['feemanage:fixedassets:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['feemanage:fixedassets:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['feemanage:fixedassets:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="fixedassetsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="区域编号" align="center" prop="areaNumber">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dorm_areaNumber" :value="scope.row.areaNumber"/>
        </template>
      </el-table-column>
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="宿舍固定资产编码" align="center" prop="dormPropertyNumber" />
      <el-table-column label="宿舍固定资产描述" align="center" prop="dormPropertyDescription" />
      <el-table-column label="宿舍固定资产备注" align="center" prop="dormPropertyRemarks" />
      <el-table-column label="总数量" align="center" prop="totalnumber" />
      <el-table-column label="物品单价" align="center" prop="price" />
      <el-table-column label="赔偿单价" align="center" prop="compensationPrice" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['feemanage:fixedassets:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['feemanage:fixedassets:remove']"
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

    <!-- 添加或修改宿舍固定资产对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="宿舍固定资产编码" prop="dormPropertyNumber">
          <el-input v-model="form.dormPropertyNumber" placeholder="请输入宿舍固定资产编码" />
        </el-form-item>
        <el-form-item label="宿舍固定资产描述" prop="dormPropertyDescription">
          <el-input v-model="form.dormPropertyDescription" placeholder="请输入宿舍固定资产描述" />
        </el-form-item>
        <el-form-item label="宿舍固定资产备注" prop="dormPropertyRemarks">
          <el-input v-model="form.dormPropertyRemarks" placeholder="请输入宿舍固定资产备注" />
        </el-form-item>
        <el-form-item label="总数量" prop="totalnumber">
          <el-input v-model="form.totalnumber" placeholder="请输入总数量" />
        </el-form-item>
        <el-form-item label="物品单价" prop="price">
          <el-input v-model="form.price" placeholder="请输入物品单价" />
        </el-form-item>
        <el-form-item label="赔偿单价" prop="compensationPrice">
          <el-input v-model="form.compensationPrice" placeholder="请输入赔偿单价" />
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
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的宿舍固定资产数据
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
import { listFixedassets, getFixedassets, delFixedassets, addFixedassets, updateFixedassets } from "@/api/feemanage/fixedassets";
import {getToken} from "@/utils/auth";

export default {
  name: "Fixedassets",
  dicts: ['dorm_areaNumber'],
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
      // 宿舍固定资产表格数据
      fixedassetsList: [],
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
        dormPropertyNumber: null,
        dormPropertyDescription: null,
        dormPropertyRemarks: null,
        totalnumber: null,
        price: null,
        compensationPrice: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
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
        dormPropertyNumber: [
          { required: true, message: "宿舍固定资产编码不能为空", trigger: "blur" }
        ],
        dormPropertyDescription: [
          { required: true, message: "宿舍固定资产描述不能为空", trigger: "blur" }
        ],
        totalnumber: [
          { required: true, message: "总数量不能为空", trigger: "blur" }
        ],
        price: [
          { required: true, message: "物品单价不能为空", trigger: "blur" }
        ],
        compensationPrice: [
          { required: true, message: "赔偿单价不能为空", trigger: "blur" }
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
        url: process.env.VUE_APP_BASE_API + "/feemanage/fixedassets/importData"
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询宿舍固定资产列表 */
    getList() {
      this.loading = true;
      listFixedassets(this.queryParams).then(response => {
        this.fixedassetsList = response.rows;
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
        dormPropertyNumber: null,
        dormPropertyDescription: null,
        dormPropertyRemarks: null,
        totalnumber: null,
        price: null,
        compensationPrice: null
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
      this.title = "添加宿舍固定资产";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFixedassets(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改宿舍固定资产";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFixedassets(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFixedassets(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除宿舍固定资产编号为"' + ids + '"的数据项？').then(function() {
        return delFixedassets(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('feemanage/fixedassets/export', {
        ...this.queryParams
      }, `fixedassets_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "宿舍固定资产导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('feemanage/fixedassets/importTemplate', {
      }, `宿舍固定资产信息_模板_${new Date().getTime()}.xlsx`)
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
