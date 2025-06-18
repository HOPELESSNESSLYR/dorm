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
      <el-form-item label="工号" prop="jobnumber">
        <el-input
          v-model="queryParams.jobnumber"
          placeholder="请输入工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idnnumber">
        <el-input
          v-model="queryParams.idnnumber"
          placeholder="请输入身份证号"
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
      <el-form-item label="领用物品编码" prop="articleNumber">
        <el-input
          v-model="queryParams.articleNumber"
          placeholder="请输入领用物品编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="领用物品描述" prop="articleDescription">
        <el-input
          v-model="queryParams.articleDescription"
          placeholder="请输入领用物品描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="领用物品数量" prop="requstQuantity">
        <el-input
          v-model="queryParams.requstQuantity"
          placeholder="请输入领用物品数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退还物品编码" prop="returnNumber">
        <el-input
          v-model="queryParams.returnNumber"
          placeholder="请输入退还物品编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退还物品描述" prop="returnDescription">
        <el-input
          v-model="queryParams.returnDescription"
          placeholder="请输入退还物品描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退还物品数量" prop="returnQuantity">
        <el-input
          v-model="queryParams.returnQuantity"
          placeholder="请输入退还物品数量"
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
          v-hasPermi="['dorm:article:add']"
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
          v-hasPermi="['dorm:article:edit']"
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
          v-hasPermi="['dorm:article:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['dorm:article:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dorm:article:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <div class="table-container">
    <el-table v-loading="loading" :data="articleList" @selection-change="handleSelectionChange"  :max-height="maxHeight">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="工号" align="center" prop="jobnumber" />
      <el-table-column label="身份证号" align="center" prop="idnnumber" />
      <el-table-column label="床位号" align="center" prop="bednumber" />
      <el-table-column label="领用物品编码" align="center" prop="articleNumber" />
      <el-table-column label="领用物品描述" align="center" prop="articleDescription" />
      <el-table-column label="领用物品数量" align="center" prop="requstQuantity" />
      <el-table-column label="退还物品编码" align="center" prop="returnNumber" />
      <el-table-column label="退还物品描述" align="center" prop="returnDescription" />
      <el-table-column label="退还物品数量" align="center" prop="returnQuantity" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dorm:article:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dorm:article:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    </div>

    <div class="fixed-bottom">
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    </div>

    <!-- 添加或修改个人物品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="区域编号" prop="areaNumber">
          <el-input v-model="form.areaNumber" placeholder="请输入区域编号" />
        </el-form-item>
        <el-form-item label="宿舍楼编号" prop="floorNumber">
          <el-input v-model="form.floorNumber" placeholder="请输入宿舍楼编号" />
        </el-form-item>
        <el-form-item label="宿舍房间号" prop="roomNumber">
          <el-input v-model="form.roomNumber" placeholder="请输入宿舍房间号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="工号" prop="jobnumber">
          <el-input v-model="form.jobnumber" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idnnumber">
          <el-input v-model="form.idnnumber" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="床位号" prop="bednumber">
          <el-input v-model="form.bednumber" placeholder="请输入床位号" />
        </el-form-item>
        <el-form-item label="领用物品编码" prop="articleNumber">
          <el-input v-model="form.articleNumber" placeholder="请输入领用物品编码" />
        </el-form-item>
        <el-form-item label="领用物品描述" prop="articleDescription">
          <el-input v-model="form.articleDescription" placeholder="请输入领用物品描述" />
        </el-form-item>
        <el-form-item label="领用物品数量" prop="requstQuantity">
          <el-input v-model="form.requstQuantity" placeholder="请输入领用物品数量" />
        </el-form-item>
        <el-form-item label="退还物品编码" prop="returnNumber">
          <el-input v-model="form.returnNumber" placeholder="请输入退还物品编码" />
        </el-form-item>
        <el-form-item label="退还物品描述" prop="returnDescription">
          <el-input v-model="form.returnDescription" placeholder="请输入退还物品描述" />
        </el-form-item>
        <el-form-item label="退还物品数量" prop="returnQuantity">
          <el-input v-model="form.returnQuantity" placeholder="请输入退还物品数量" />
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
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的个人物品数据
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
import { listArticle, getArticle, delArticle, addArticle, updateArticle } from "@/api/dorm/article";
import {getToken} from "@/utils/auth";

export default {
  name: "Article",
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
      // 个人物品表格数据
      articleList: [],
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
        roomNumber: null,
        name: null,
        jobnumber: null,
        idnnumber: null,
        bednumber: null,
        articleNumber: null,
        articleDescription: null,
        requstQuantity: null,
        returnNumber: null,
        returnDescription: null,
        returnQuantity: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        areaNumber: [
          { required: true, message: "区域编号不能为空", trigger: "blur" }
        ],
        floorNumber: [
          { required: true, message: "宿舍楼编号不能为空", trigger: "blur" }
        ],
        roomNumber: [
          { required: true, message: "宿舍房间号不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        jobnumber: [
          { required: true, message: "工号不能为空", trigger: "blur" }
        ],
        idnnumber: [
          { required: true, message: "身份证号不能为空", trigger: "blur" }
        ],
        bednumber: [
          { required: true, message: "床位号不能为空", trigger: "blur" }
        ],
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
        url: process.env.VUE_APP_BASE_API + "/dorm/article/importData"
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询个人物品列表 */
    getList() {
      this.loading = true;
      listArticle(this.queryParams).then(response => {
        this.articleList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      //底部滚动条
      this.$nextTick=(()=>{
        this.maxHeight=window.innerHeight-220
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
        areaNumber: null,
        floorNumber: null,
        roomNumber: null,
        name: null,
        jobnumber: null,
        idnnumber: null,
        bednumber: null,
        articleNumber: null,
        articleDescription: null,
        requstQuantity: null,
        returnNumber: null,
        returnDescription: null,
        returnQuantity: null,
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
      this.title = "添加个人物品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getArticle(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改个人物品";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateArticle(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArticle(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除个人物品编号为"' + ids + '"的数据项？').then(function() {
        return delArticle(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dorm/article/export', {
        ...this.queryParams
      }, `article_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "个人物品导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('dorm/article/importTemplate', {
      }, `个人物品信息_模板_${new Date().getTime()}.xlsx`)
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
<style>
.app-container {
  height: 100%;
  display: flex;
  flex-direction: column;
  position: relative;
  padding-bottom: 50px;
}

.search-form {
  flex-shrink: 0;
}

.table-container {
  flex: 1;
  overflow: auto;
  position: relative;
}
.fixed-bottom {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: #fff;
  padding: 10px 0;
  box-shadow: 0 -2px 8px rgba(0, 0, 0, 0.1);
  z-index: 1000;
}
.el-table {
  width: 100% !important;
}

.el-table__body-wrapper {
  overflow-x: auto !important;
}


/* 调整表格底部边距，防止被固定底部遮挡 */
.el-table__body-wrapper {
  margin-bottom: 50px;
}
</style>