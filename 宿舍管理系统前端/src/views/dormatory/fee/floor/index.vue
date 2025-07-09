<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
      <!-- <el-form-item label="宿舍楼编号" prop="floorNumber">
        <el-input
          v-model="queryParams.floorNumber"
          placeholder="请输入宿舍楼编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宿舍楼名称" prop="floorName">
        <el-input
          v-model="queryParams.floorName"
          placeholder="请输入宿舍楼名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="宿舍楼层号" prop="dormFloor">
        <el-input
          v-model="queryParams.dormFloor"
          placeholder="请输入宿舍楼层号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="楼层热水费" prop="floorHotwaterFee">
        <el-input
          v-model="queryParams.floorHotwaterFee"
          placeholder="请输入楼层热水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="楼层冷水费" prop="floorCoolwaterFee">
        <el-input
          v-model="queryParams.floorCoolwaterFee"
          placeholder="请输入楼层冷水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="楼层电费" prop="floorElectricityFee">
        <el-input
          v-model="queryParams.floorElectricityFee"
          placeholder="请输入楼层电费"
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
          v-hasPermi="['fee:floor:add']"
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
          v-hasPermi="['fee:floor:edit']"
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
          v-hasPermi="['fee:floor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
        type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['fee:floor:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fee:floor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="floorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="楼层费用ID" align="center" prop="floorfeeId" />
      <el-table-column label="年份" align="center" prop="nian" />
      <el-table-column label="月份" align="center" prop="yue" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼名称" align="center" prop="floorName" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="楼层公共热水费" align="center" prop="floorHotwaterFee" />
      <el-table-column label="楼层公共冷水费" align="center" prop="floorCoolwaterFee" />
      <el-table-column label="楼层公共电费" align="center" prop="floorElectricityFee" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fee:floor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fee:floor:remove']"
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

    <!-- 添加或修改楼层费用对话框 -->
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
        <el-form-item label="宿舍楼编号" prop="floorNumber">
          <el-input v-model="form.floorNumber" placeholder="请输入宿舍楼编号" />
        </el-form-item>
        <el-form-item label="宿舍楼名称" prop="floorName">
          <el-input v-model="form.floorName" placeholder="请输入宿舍楼名称" />
        </el-form-item>
        <el-form-item label="宿舍楼层号" prop="dormFloor">
          <el-input v-model="form.dormFloor" placeholder="请输入宿舍楼层号" />
        </el-form-item>
        <el-form-item label="楼层热水费" prop="floorHotwaterFee">
          <el-input v-model="form.floorHotwaterFee" placeholder="请输入楼层热水费" />
        </el-form-item>
        <el-form-item label="楼层冷水费" prop="floorCoolwaterFee">
          <el-input v-model="form.floorCoolwaterFee" placeholder="请输入楼层冷水费" />
        </el-form-item>
        <el-form-item label="楼层电费" prop="floorElectricityFee">
          <el-input v-model="form.floorElectricityFee" placeholder="请输入楼层电费" />
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
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的数据
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
import { listFloor, getFloor, delFloor, addFloor, updateFloor } from "@/api/fee/floor";
import { getToken } from "@/utils/auth";
import { listRoom, getRoom, delRoom, addRoom, updateRoom , getelec,getcool,gethot} from "@/api/fee/room";

export default {
  name: "Floor",
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
      // 楼层费用表格数据
      floorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
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
        url: process.env.VUE_APP_BASE_API + "/fee/floor/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nian: null,
        yue: null,
        areaNumber: null,
        floorNumber: null,
        floorName: null,
        dormFloor: null,
        floorHotwaterFee: null,
        floorCoolwaterFee: null,
        floorElectricityFee: null
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
        floorName: [
          { required: true, message: "宿舍楼名称不能为空", trigger: "blur" }
        ],
        dormFloor: [
          { required: true, message: "宿舍楼层号不能为空", trigger: "blur" }
        ],
      },
      tableData: {
        nian: null,
        yue: null,
        areaNumber: null,
        floorNumber: null,
        floorName: null,
        dormFloor: null,
        roomNumber: null,
        isPublicArea: null,
        startdate: null,
        enddate: null,
        hotwatersn: null,
        hotwaterTotalLastmonth: null,
        hotwaterTotal: null,
        hotwater: null,
        hotwaterFee: null,
        coolwatersn: null,
        coolwaterTotalLastmonth: null,
        coolwaterTotal: null,
        coolwater: null,
        coolwaterFee: null,
        electricitysn: null,
        electricityTotalLastmonth: null,
        electricityTotal: null,
        electricity: null,
        electricityFee: null
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询楼层费用列表 */
    getList() {
      this.loading = true;
      listFloor(this.queryParams).then(async response2 => {
        const floorList = response2.rows;
        // 遍历每条楼层数据
        for (let floor of floorList) {
          // 构造查询条件
          const roomQuery = {
            nian: floor.nian,
            yue: floor.yue,
            areaNumber: floor.areaNumber,
            floorNumber: floor.floorNumber,
            dormFloor: floor.dormFloor,
            isPublicArea: "公共区域"
          };
          // 查询该楼层所有房间
          const roomRes = await listRoom(roomQuery);
          const rooms = roomRes.rows || [];
          // 计算公共区域费用
          let hotwaterFee = 0, coolwaterFee = 0, electricityFee = 0;
          rooms.forEach(room => {
            // if (room.isPublicArea == 1) {
              hotwaterFee += Number(room.hotwaterFee) || 0;
              coolwaterFee += Number(room.coolwaterFee) || 0;
              electricityFee += Number(room.electricityFee) || 0;
            // }
          });
          // 更新楼层费用
          floor.floorHotwaterFee = hotwaterFee;
          floor.floorCoolwaterFee = coolwaterFee;
          floor.floorElectricityFee = electricityFee;
          // 同步更新到数据库
          await updateFloor(floor);
        }
        // 重新获取最新数据
        listFloor(this.queryParams).then(response => {
          this.floorList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
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
        floorfeeId: null,
        nian: null,
        yue: null,
        areaNumber: null,
        floorNumber: null,
        floorName: null,
        dormFloor: null,
        floorHotwaterFee: null,
        floorCoolwaterFee: null,
        floorElectricityFee: null
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
      this.ids = selection.map(item => item.floorfeeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加楼层费用";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const floorfeeId = row.floorfeeId || this.ids
      getFloor(floorfeeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改楼层费用";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.floorfeeId != null) {
            updateFloor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFloor(this.form).then(response => {
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
      const floorfeeIds = row.floorfeeId || this.ids;
      this.$modal.confirm('是否确认删除楼层费用编号为"' + floorfeeIds + '"的数据项？').then(function() {
        return delFloor(floorfeeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('fee/floor/export', {
        ...this.queryParams
      }, `floor_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "流动导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('fee/floor/importTemplate', {
      }, `楼层费用_模板_${new Date().getTime()}.xlsx`)
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
