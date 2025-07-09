<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="年份月份" prop="nianyue">
        <el-date-picker clearable
          v-model="queryParams.nianyue"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择年份月份">
        </el-date-picker>
        <el-date-picker
          v-model="queryParams.nianyue"
          type="month"
          value-format="yyyy-MM"
          placeholder="选择月">
        </el-date-picker>
      </el-form-item> -->
      <el-form-item label="年份" prop="nian">
        <el-input
          v-model="queryParams.nian"
          placeholder="请输入年份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="月份" prop="yue">
        <el-input
          v-model="queryParams.yue"
          placeholder="请输入月份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区域编号" prop="areaNumber">
        <el-input
          v-model="queryParams.areaNumber"
          placeholder="请输入区域编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="电费单价" prop="electricityPrice">
        <el-input
          v-model="queryParams.electricityPrice"
          placeholder="请输入电费单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="热水费单价" prop="hotwaterPrice">
        <el-input
          v-model="queryParams.hotwaterPrice"
          placeholder="请输入热水费单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冷水费单价" prop="coolwaterPrice">
        <el-input
          v-model="queryParams.coolwaterPrice"
          placeholder="请输入冷水费单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共电费单价" prop="publicElectricityPrice">
        <el-input
          v-model="queryParams.publicElectricityPrice"
          placeholder="请输入公共电费单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共热水费单价" prop="publicHotwaterPrice">
        <el-input
          v-model="queryParams.publicHotwaterPrice"
          placeholder="请输入公共热水费单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共冷水费单价" prop="publicCoolwaterPrice">
        <el-input
          v-model="queryParams.publicCoolwaterPrice"
          placeholder="请输入公共冷水费单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共洗衣机费" prop="publicWashingPrice">
        <el-input
          v-model="queryParams.publicWashingPrice"
          placeholder="请输入公共洗衣机费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
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
          v-hasPermi="['fee:config:add']"
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
          v-hasPermi="['fee:config:edit']"
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
          v-hasPermi="['fee:config:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
        type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['fee:config:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fee:config:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="configList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="费用配置ID" align="center" prop="congifId" />
      <!-- <el-table-column label="年份月份" align="center" prop="nianyue" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.nianyue, '{y}-{m}') }}</span>
        </template>
      </el-table-column> -->
      <el-table-column label="年份" align="center" prop="nian" />
      <el-table-column label="月份" align="center" prop="yue" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="楼层号" align="center" prop="dormFloor" />
      <el-table-column label="电费单价" align="center" prop="electricityPrice" />
      <el-table-column label="热水费单价" align="center" prop="hotwaterPrice" />
      <el-table-column label="冷水费单价" align="center" prop="coolwaterPrice" />
      <el-table-column label="公共电费单价" align="center" prop="publicElectricityPrice" />
      <el-table-column label="公共热水费单价" align="center" prop="publicHotwaterPrice" />
      <el-table-column label="公共冷水费单价" align="center" prop="publicCoolwaterPrice" />
      <el-table-column label="公共洗衣机费" align="center" prop="publicWashingPrice" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fee:config:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fee:config:remove']"
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

    <!-- 添加或修改费用配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="年份" prop="nian">
          <el-input v-model="form.nian" placeholder="请输入年份" />
        </el-form-item>
        <el-form-item label="月份" prop="yue">
          <el-input v-model="form.yue" placeholder="请输入月份" />
        </el-form-item>
        <el-form-item label="区域编号" prop="areaNumber">
          <el-input v-model="form.areaNumber" placeholder="请输入区域编号" />
        </el-form-item>
        <el-form-item label="楼层号" prop="dormFloor">
          <el-input v-model="form.dormFloor" placeholder="请输入宿舍楼层号" />
        </el-form-item>
        <el-form-item label="电费单价" prop="electricityPrice">
          <el-input v-model="form.electricityPrice" placeholder="请输入电费单价" />
        </el-form-item>
        <el-form-item label="热水费单价" prop="hotwaterPrice">
          <el-input v-model="form.hotwaterPrice" placeholder="请输入热水费单价" />
        </el-form-item>
        <el-form-item label="冷水费单价" prop="coolwaterPrice">
          <el-input v-model="form.coolwaterPrice" placeholder="请输入冷水费单价" />
        </el-form-item>
        <el-form-item label="公共电费单价" prop="publicElectricityPrice">
          <el-input v-model="form.publicElectricityPrice" placeholder="请输入公共电费单价" />
        </el-form-item>
        <el-form-item label="公共热水费单价" prop="publicHotwaterPrice">
          <el-input v-model="form.publicHotwaterPrice" placeholder="请输入公共热水费单价" />
        </el-form-item>
        <el-form-item label="公共冷水费单价" prop="publicCoolwaterPrice">
          <el-input v-model="form.publicCoolwaterPrice" placeholder="请输入公共冷水费单价" />
        </el-form-item>
        <el-form-item label="公共洗衣机费" prop="publicWashingPrice">
          <el-input v-model="form.publicWashingPrice" placeholder="请输入公共洗衣机费" />
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
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的住客数据
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
import { listConfig, getConfig, delConfig, addConfig, updateConfig } from "@/api/fee/config";
import { getToken } from "@/utils/auth";

export default {
  name: "Config",
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
      // 费用配置表格数据
      configList: [],
      // 弹出层标题
      title: "",
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
        url: process.env.VUE_APP_BASE_API + "/fee/config/importData"
      },
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nian: null,
        yue: null,
        areaNumber: null,
        dormFloor:null,
        electricityPrice: null,
        hotwaterPrice: null,
        coolwaterPrice: null,
        publicElectricityPrice: null,
        publicHotwaterPrice: null,
        publicCoolwaterPrice: null,
        publicWashingPrice: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        areaNumber: [
          { required: true, message: "区域编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询费用配置列表 */
    getList() {
      this.loading = true;
      listConfig(this.queryParams).then(response => {
        this.configList = response.rows;
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
        congifId: null,
        // nianyue: null,
        nian: null,
        yue: null,
        areaNumber: null,
        dormFloor:null,
        electricityPrice: null,
        hotwaterPrice: null,
        coolwaterPrice: null,
        publicElectricityPrice: null,
        publicHotwaterPrice: null,
        publicCoolwaterPrice: null,
        publicWashingPrice: null
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
      this.ids = selection.map(item => item.congifId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加费用配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const congifId = row.congifId || this.ids
      getConfig(congifId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改费用配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.congifId != null) {
            updateConfig(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addConfig(this.form).then(response => {
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
      const congifIds = row.congifId || this.ids;
      this.$modal.confirm('是否确认删除费用配置编号为"' + congifIds + '"的数据项？').then(function() {
        return delConfig(congifIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('fee/config/export', {
        ...this.queryParams
      }, `config_${new Date().getTime()}.xlsx`)
    },

    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "流动导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('fee/config/importTemplate', {
      }, `费用配置_模板_${new Date().getTime()}.xlsx`)
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
