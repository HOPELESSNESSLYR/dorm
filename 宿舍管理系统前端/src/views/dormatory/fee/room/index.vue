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
      <el-form-item label="宿舍房间号" prop="roomNumber">
        <el-input
          v-model="queryParams.roomNumber"
          placeholder="请输入宿舍房间号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="员工宿舍/公共区域" prop="isPublicArea">
        <el-select v-model="queryParams.isPublicArea" placeholder="请选择员工宿舍/公共区域" clearable>
          <el-option
            v-for="dict in dict.type.room_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="热水表号" prop="hotwatersn">
        <el-input
          v-model="queryParams.hotwatersn"
          placeholder="请输入热水表号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="热水上月表底" prop="hotwaterTotalLastmonth">
        <el-input
          v-model="queryParams.hotwaterTotalLastmonth"
          placeholder="请输入热水上月表底"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="热水本月表底" prop="hotwaterTotal">
        <el-input
          v-model="queryParams.hotwaterTotal"
          placeholder="请输入热水本月表底"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="热水用水" prop="hotwater">
        <el-input
          v-model="queryParams.hotwater"
          placeholder="请输入热水用水"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="热水费" prop="hotwaterFee">
        <el-input
          v-model="queryParams.hotwaterFee"
          placeholder="请输入热水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冷水表号" prop="coolwatersn">
        <el-input
          v-model="queryParams.coolwatersn"
          placeholder="请输入冷水表号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冷水上月表底" prop="coolwaterTotalLastmonth">
        <el-input
          v-model="queryParams.coolwaterTotalLastmonth"
          placeholder="请输入冷水上月表底"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冷水本月表底" prop="coolwaterTotal">
        <el-input
          v-model="queryParams.coolwaterTotal"
          placeholder="请输入冷水本月表底"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冷水用水" prop="coolwater">
        <el-input
          v-model="queryParams.coolwater"
          placeholder="请输入冷水用水"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冷水费" prop="coolwaterFee">
        <el-input
          v-model="queryParams.coolwaterFee"
          placeholder="请输入冷水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电表号" prop="electricitysn">
        <el-input
          v-model="queryParams.electricitysn"
          placeholder="请输入电表号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电表上月表底" prop="electricityTotalLastmonth">
        <el-input
          v-model="queryParams.electricityTotalLastmonth"
          placeholder="请输入电表上月表底"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电表本月表底" prop="electricityTotal">
        <el-input
          v-model="queryParams.electricityTotal"
          placeholder="请输入电表本月表底"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电表用量" prop="electricity">
        <el-input
          v-model="queryParams.electricity"
          placeholder="请输入电表用量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电费" prop="electricityFee">
        <el-input
          v-model="queryParams.electricityFee"
          placeholder="请输入电费"
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
          v-hasPermi="['fee:room:add']"
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
          v-hasPermi="['fee:room:edit']"
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
          v-hasPermi="['fee:room:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
        type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['fee:room:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fee:room:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="selection.length < 2"
          @click="handleUpdates"
          v-hasPermi="['fee:room:edits']"
        >批量修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="selection.length < 2"
          @click="handleUpdates2"
          v-hasPermi="['fee:room:edits2']"
        >批量计算</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roomList" @selection-change="handleSelectionChange"  :max-height="maxHeight">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="房间费用ID" align="center" prop="roomfeeId" />
      <el-table-column label="年份" align="center" prop="nian" />
      <el-table-column label="月份" align="center" prop="yue" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼名称" align="center" prop="floorName" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="员工宿舍/公共区域" align="center" prop="isPublicArea">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.room_type" :value="scope.row.isPublicArea"/>
        </template>
      </el-table-column>
      <el-table-column label="日期段开始" align="center" prop="startdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="日期段结束" align="center" prop="enddate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.enddate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="热水表号" align="center" prop="hotwatersn" />
      <el-table-column label="热水上月表底" align="center" prop="hotwaterTotalLastmonth" />
      <el-table-column label="热水本月表底" align="center" prop="hotwaterTotal" />
      <el-table-column label="热水用水" align="center" prop="hotwater" />
      <el-table-column label="热水费" align="center" prop="hotwaterFee" />
      <el-table-column label="冷水表号" align="center" prop="coolwatersn" />
      <el-table-column label="冷水上月表底" align="center" prop="coolwaterTotalLastmonth" />
      <el-table-column label="冷水本月表底" align="center" prop="coolwaterTotal" />
      <el-table-column label="冷水用水" align="center" prop="coolwater" />
      <el-table-column label="冷水费" align="center" prop="coolwaterFee" />
      <el-table-column label="电表号" align="center" prop="electricitysn" />
      <el-table-column label="电表上月表底" align="center" prop="electricityTotalLastmonth" />
      <el-table-column label="电表本月表底" align="center" prop="electricityTotal" />
      <el-table-column label="电表用量" align="center" prop="electricity" />
      <el-table-column label="电费" align="center" prop="electricityFee" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fee:room:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fee:room:remove']"
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

    <!-- 添加或修改房间费用对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <template v-if="title === '批量修改房间信息'">
          <el-form-item label="日期段开始" prop="startdate">
            <el-date-picker clearable
              v-model="form.startdate"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="请选择日期段开始">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="日期段结束" prop="enddate">
            <el-date-picker clearable
              v-model="form.enddate"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="请选择日期段结束">
            </el-date-picker>
          </el-form-item>
        </template>
        <template v-else>
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
        <el-form-item label="宿舍房间号" prop="roomNumber">
          <el-input v-model="form.roomNumber" placeholder="请输入宿舍房间号" />
        </el-form-item>
        <el-form-item label="员工宿舍/公共区域" prop="isPublicArea">
          <el-select v-model="form.isPublicArea" placeholder="请选择员工宿舍/公共区域">
            <el-option
              v-for="dict in dict.type.room_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="日期段开始" prop="startdate">
          <el-date-picker clearable
            v-model="form.startdate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择日期段开始">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="日期段结束" prop="enddate">
          <el-date-picker clearable
            v-model="form.enddate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择日期段结束">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="热水表号" prop="hotwatersn">
          <el-input v-model="form.hotwatersn" placeholder="请输入热水表号" />
        </el-form-item>
        <el-form-item label="热水上月表底" prop="hotwaterTotalLastmonth">
          <el-input v-model="form.hotwaterTotalLastmonth" placeholder="请输入热水上月表底" />
        </el-form-item>
        <el-form-item label="热水本月表底" prop="hotwaterTotal">
          <el-input v-model="form.hotwaterTotal" placeholder="请输入热水本月表底" />
        </el-form-item>
        <el-form-item label="热水用水" prop="hotwater">
          <el-input v-model="form.hotwater" placeholder="请输入热水用水" />
        </el-form-item>
        <el-form-item label="热水费" prop="hotwaterFee">
          <el-input v-model="form.hotwaterFee" placeholder="请输入热水费" />
        </el-form-item>
        <el-form-item label="冷水表号" prop="coolwatersn">
          <el-input v-model="form.coolwatersn" placeholder="请输入冷水表号" />
        </el-form-item>
        <el-form-item label="冷水上月表底" prop="coolwaterTotalLastmonth">
          <el-input v-model="form.coolwaterTotalLastmonth" placeholder="请输入冷水上月表底" />
        </el-form-item>
        <el-form-item label="冷水本月表底" prop="coolwaterTotal">
          <el-input v-model="form.coolwaterTotal" placeholder="请输入冷水本月表底" />
        </el-form-item>
        <el-form-item label="冷水用水" prop="coolwater">
          <el-input v-model="form.coolwater" placeholder="请输入冷水用水" />
        </el-form-item>
        <el-form-item label="冷水费" prop="coolwaterFee">
          <el-input v-model="form.coolwaterFee" placeholder="请输入冷水费" />
        </el-form-item>
        <el-form-item label="电表号" prop="electricitysn">
          <el-input v-model="form.electricitysn" placeholder="请输入电表号" />
        </el-form-item>
        <el-form-item label="电表上月表底" prop="electricityTotalLastmonth">
          <el-input v-model="form.electricityTotalLastmonth" placeholder="请输入电表上月表底" />
        </el-form-item>
        <el-form-item label="电表本月表底" prop="electricityTotal">
          <el-input v-model="form.electricityTotal" placeholder="请输入电表本月表底" />
        </el-form-item>
        <el-form-item label="电表用量" prop="electricity">
          <el-input v-model="form.electricity" placeholder="请输入电表用量" />
        </el-form-item>
        <el-form-item label="电费" prop="electricityFee">
          <el-input v-model="form.electricityFee" placeholder="请输入电费" />
        </el-form-item>
      </template>
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
import { listRoom, getRoom, delRoom, addRoom, updateRoom , getelec,getcool,gethot,batchUpdateRoom} from "@/api/fee/room";
import { getToken } from "@/utils/auth";
import { listConfig } from "@/api/fee/config";

export default {
  name: "Room",
  dicts: ['room_type'],
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
      // 房间费用表格数据
      roomList: [],
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
        url: process.env.VUE_APP_BASE_API + "/fee/room/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        roomfeeId:null,
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
      tableData:{
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
      selection: [],
      //
      authorization:"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6ImYwMTk2MWMzNzY3Yjg4MmQ5YzBkMDgyNzM3NmVmN2VjIiwiYWN0aXZpdGkiOmZhbHNlLCJzY29wZSI6WyJPUEVOQVBJIl0sImlkIjo3ODYwOTksImxhbmRsb3JkSWQiOjc4NjA5OSwiZXhwIjoxNzYwMjUxNjA3LCJqdGkiOiJhMDJhOWZhYS1hM2VmLTQ4YjgtYjJmMS1lZTYyOTJjOWVmNjAiLCJjbGllbnRfaWQiOiJPUEVOQVBJIn0.PNu_A-o61YTi3p_3QIReay15Ma0FnJIcqNxEt5vSEHI",
      // 新增用户名和密码
      username: "13515881762",
      password: "yangjing10118",
      form1:{},
      form2:{}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getZhihuifangdongToken() {
      return new Promise((resolve, reject) => {
        var request = require('request');
        var options = {
          method: 'GET',
          url: `https://api.zhihuifangdong.net/open/api/getToken/${this.username}/${this.password}/YE0lkOfSuf8YUSj5DNTukQ==`,
        };
        request(options, (error, response) => {
          if (error) {
            this.$modal.msgError("智慧房东token获取失败");
            console.error('getZhihuifangdongToken request error:', error);
            return reject(error);
          }

          console.log('getZhihuifangdongToken response body:', response.body);
          
          let resBody;
          try {
            resBody = JSON.parse(response.body);
          } catch(e) {
            this.$modal.msgError("解析智慧房东token响应失败");
            console.error('Failed to parse getZhihuifangdongToken response:', e);
            return reject("解析智慧房东token响应失败");
          }

          const isSuccess = resBody.code === 200 || resBody.code === 0 || resBody.success === true || (resBody.msg && resBody.msg.includes('成功'));
          let token = null;

          if (isSuccess) {
            if (typeof resBody.data === 'string' && resBody.data.length > 20) { // Heuristic for token
              token = resBody.data;
            }else{
              console.log("resBody.data != 'string'")
            }
          }

          if (token) {
            this.authorization = token;
            // this.$modal.msgSuccess("智慧房东token已更新");
            resolve(this.authorization);
          } else {
            console.error("无token", resBody);
            // this.$modal.msgError("智慧房东token获取失败: " + (resBody.msg || resBody.message || '未知错误'));
            reject("智慧房东token获取失败");
          }
        });
      });
    },
    getTableData(){
      return new Promise(resolve =>{
        if (this.title === "批量修改房间信息") {
          this.form = this.form1;
        }
        let that=this;
        var request = require('request');

        // 包装每个 request 为 Promise
        const getElectricity = new Promise((res, rej) => {
         if(this.form.electricitysn !='' && this.form.electricitysn !=null && this.form.electricitysn !=undefined){ 
          var options = {
            method: 'GET',
            url: 'https://api.zhihuifangdong.net/open/api/meterAnalyze?' + "meterSn=" + this.form.electricitysn + "&startTime=" + this.form.startdate + "&endTime=" + this.form.enddate,
            headers: {
              "Authorization": this.authorization
            }
          };
          request(options, function (error, response) {
            if (error) return rej(error);
            const body = JSON.parse(response.body);
            console.log(body)
            if (body.message === '无效token' || body.message === 'token已过期'|| body.success==false) {
              return that.getZhihuifangdongToken()
                .then(newAuth => {
                  options.headers.Authorization = newAuth;
                  return request(options, (err, resp) => {
                    if (err) return rej(err);
                    const newBody = JSON.parse(resp.body);
                    that.form.electricity = Number((newBody.data.meterElectricity).slice(0, -1));
                    res();
                  });
                })
                .catch(rej);
            }
            that.form.electricity = Number((body.data.meterElectricity).slice(0, -1));
            res();
          });
         }else{
          res()
         }
        }); 
     
        const getCoolWater = new Promise((res, rej) => {
         if(this.form.coolwatersn !='' && this.form.coolwatersn !=null && this.form.coolwatersn !=undefined){
          var options1 = {
            method: 'get',
            url: 'https://api.zhihuifangdong.net/open/api/waterAnalyze?' + "waterSn=" + this.form.coolwatersn + "&startTime=" + this.form.startdate + "&endTime=" + this.form.enddate,
            headers: {
              "Authorization": this.authorization
            }
          };
          request(options1, function (error, response) {
            if(error) return rej(error);
            const body = JSON.parse(response.body);
            if(body.message === "无效token"){
              return that.getZhihuifangdongToken()
                .then(newAuth => {
                  options1.headers.Authorization = newAuth;
                  return request(options1, (err, resp) => {
                    if (err) return rej(err);
                    const newBody = JSON.parse(resp.body);
                    that.form.coolwater = Number(newBody.data.waterConsumption).toFixed(2);
                    res();
                  });
                })
                .catch(rej);
            }else{ 
              if (body.data) {
                that.form.coolwater = Number(body.data.waterConsumption).toFixed(2);
              }
              res();
            }
          });
         }else{
          res()
         }
        });
    
        const getHotWater = new Promise((res, rej) => {
         if(this.form.hotwatersn !='' && this.form.hotwatersn !=null && this.form.hotwatersn !=undefined){
          var options2 = {
            method: 'get',
            url: 'https://api.zhihuifangdong.net/open/api/waterAnalyze?' + "waterSn=" + this.form.hotwatersn + "&startTime=" + this.form.startdate + "&endTime=" + this.form.enddate,
            headers: {
              "Authorization": this.authorization
            }
          };
          request(options2, function (error, response) {
            if (error) return rej(error);
            const body = JSON.parse(response.body);
            if (body.message === '无效token') {
              return that.getZhihuifangdongToken()
                .then(newAuth => {
                  options2.headers.Authorization = newAuth;
                  return request(options2, (err, resp) => {
                    if (err) return rej(err);
                    const newBody = JSON.parse(resp.body);
                    that.form.hotwater = Number(newBody.data.waterConsumption).toFixed(2);
                    res();
                  });
                })
                .catch(rej);
            }
            that.form.hotwater = Number(body.data.waterConsumption).toFixed(2);
            res();
          });
         }else{
          res()
         }
        });
      

        // 等待所有请求完成
        Promise.all([getElectricity, getCoolWater, getHotWater]).then(() => {
          // 计算费用
          listConfig(that.tableData).then(res => {
          for(let i=0;i<res.total;i++){
            if(that.form.areaNumber == "1400"){
              if(res.rows[i].nian==that.form.nian && res.rows[i].yue==that.form.yue &&res.rows[i].areaNumber==that.form.areaNumber && res.rows[i].dormFloor==that.form.dormFloor ){
                // that.form.electricityFee = Number(res.rows[i].electricityPrice * that.form.electricity).toFixed(2)
                // that.form.hotwaterFee = Number(res.rows[i].hotwaterPrice * that.form.hotwater).toFixed(2)
                // that.form.coolwaterFee = Number(res.rows[i].coolwaterPrice * that.form.coolwater).toFixed(2)
                // that.$set(that.form,"electricityFee",Number(res.rows[i].electricityPrice * that.form.electricity).toFixed(2));
                // that.$set(that.form,"hotwaterFee", Number(res.rows[i].hotwaterPrice * that.form.hotwater).toFixed(2));
                // that.$set(that.form,"coolwaterFee", Number(res.rows[i].coolwaterPrice * that.form.coolwater).toFixed(2));

                //2位小数 第三位舍去.toFixed(2) .slice(0, result.indexOf('.') + 2)    Math.floor((res.rows[i].coolwaterPrice * that.form.coolwater) * 100) / 100
                if(this.form.electricitysn !='' && this.form.electricitysn !=null && this.form.electricitysn !=undefined){ 
                  that.form.electricityFee = Math.floor((res.rows[i].electricityPrice * that.form.electricity) * 100) / 100
                }
                if(this.form.coolwatersn !='' && this.form.coolwatersn !=null && this.form.coolwatersn !=undefined){
                  that.form.hotwaterFee = Math.floor((res.rows[i].hotwaterPrice * that.form.hotwater) * 100) / 100
                }
                if(this.form.hotwatersn !='' && this.form.hotwatersn !=null && this.form.hotwatersn !=undefined){
                  that.form.coolwaterFee = Math.floor((res.rows[i].coolwaterPrice * that.form.coolwater) * 100) / 100
                }
              }
            }else{
              if(res.rows[i].nian==that.form.nian && res.rows[i].yue==that.form.yue &&res.rows[i].areaNumber==that.form.areaNumber ){
                // that.form.electricityFee = Number((res.rows[i].electricityPrice * that.form.electricity).toFixed(2))
                // that.form.hotwaterFee = Number((res.rows[i].hotwaterPrice * that.form.hotwater).toFixed(2))
                // that.form.coolwaterFee = Number((res.rows[i].coolwaterPrice * that.form.coolwater).toFixed(2))
                //2位小数 第三位舍去 .slice(0, result.indexOf('.') + 2)    Math.floor((res.rows[i].coolwaterPrice * that.form.coolwater) * 100) / 100
                if(this.form.electricitysn !='' && this.form.electricitysn !=null && this.form.electricitysn !=undefined){ 
                  that.form.electricityFee = Math.floor((res.rows[i].electricityPrice * that.form.electricity) * 100) / 100
                }
                if(this.form.coolwatersn !='' && this.form.coolwatersn !=null && this.form.coolwatersn !=undefined){
                  that.form.hotwaterFee = Math.floor((res.rows[i].hotwaterPrice * that.form.hotwater) * 100) / 100
                }
                if(this.form.hotwatersn !='' && this.form.hotwatersn !=null && this.form.hotwatersn !=undefined){
                  that.form.coolwaterFee = Math.floor((res.rows[i].coolwaterPrice * that.form.coolwater) * 100) / 100
                }
                // console.log("3")
              }
            }

          }
          resolve();
          });
        })
        .catch(err => {
          reject(err);
        });

      })
    },
    /** 查询房间费用列表 */
    getList() {
      this.loading = true;
      listRoom(this.queryParams).then(response => {
        this.roomList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      //底部滚动条
      this.$nextTick=(()=>{
          this.maxHeight=window.innerHeight-280
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
        roomfeeId: null,
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
      // this.selection.push(selection[0])
      this.selection = selection
      this.ids = selection.map(item => item.roomfeeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加房间费用";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const roomfeeId = row.roomfeeId || this.ids
      getRoom(roomfeeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改房间费用";
      });
    },
    /** 批量修改 */
    handleUpdates() {
      this.reset();
      if (this.ids.length < 2) {
        this.$modal.msgError("请至少选择两个房间进行批量修改");
        return;
      }
      this.open = true;
      this.title = "批量修改房间信息";
      // 不需要获取单个房间信息，因为是批量修改
      this.form = {
        startdate: null,
        enddate: null
      };
    },
    // 批量计算
    async handleUpdates2() {
      this.reset();
      if (this.ids.length < 2) {
        this.$modal.msgError("请至少选择两个房间进行批量计算");
        return;
      }
      this.title = "批量计算房间信息";
      console.log(this.selection)
      for(const form of this.selection) {
        if(form.areaNumber == "333"){
          form.electricity = form.electricityTotal-form.electricityTotalLastmonth
        }
        if(form.areaNumber == "1585"){
          form.electricity = form.electricityTotal-form.electricityTotalLastmonth
          form.coolwater = form.coolwaterTotal-form.coolwaterTotalLastmonth;
          form.hotwater = form.hotwaterTotal-form.hotwaterTotalLastmonth;
        }
        await listConfig(this.tableData).then(res => {
          for(let i=0;i<res.total;i++){
          if(res.rows[i].areaNumber=="333" && res.rows[i].nian==form.nian && res.rows[i].yue==form.yue &&res.rows[i].areaNumber==form.areaNumber ){
            form.electricityFee = Math.floor((res.rows[i].electricityPrice * form.electricity) * 100) / 100;
          }
          if(res.rows[i].areaNumber=="1585" && res.rows[i].nian==form.nian && res.rows[i].yue==form.yue &&res.rows[i].areaNumber==form.areaNumber ){
            form.electricityFee = Math.floor((res.rows[i].electricityPrice * form.electricity) * 100) / 100;
            form.hotwaterFee = Math.floor((res.rows[i].hotwaterPrice * form.hotwater) * 100) / 100
            form.coolwaterFee = Math.floor((res.rows[i].coolwaterPrice * form.coolwater) * 100) / 100
           }
          }
        });
        this.form2 = form;
        await updateRoom(this.form2);
      }
        this.$modal.msgSuccess("计算成功");
        this.open = false;
        this.getList();
    },
    /** 提交按钮 */
    async submitForm() {
      if (this.title === "批量修改房间信息") {

            console.log(this.selection)
            for(const form of this.selection) {
              form.startdate = this.form.startdate,
              form.enddate = this.form.enddate
              this.form1 = form;
              await this.getTableData();
              await updateRoom(this.form1);
            }
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
              
            // 批量修改
            // const updateData = {
            //   ids: this.ids,
            //   startdate: this.form.startdate,
            //   enddate: this.form.enddate
            // };
            // batchUpdateRoom(updateData).then(response => {
            //   this.$modal.msgSuccess("批量修改成功");
            //   this.open = false;
            //   this.getList();
            // });
          } else if(this.form.roomfeeId != null && this.title != "批量修改房间信息") {
// 0916需求 
            if(this.form.areaNumber=="1585"||this.form.areaNumber=="333"){
              if(this.form.areaNumber == "333"){
                this.form.electricity = this.form.electricityTotal-this.form.electricityTotalLastmonth;
              }else{
                this.form.electricity = this.form.electricityTotal-this.form.electricityTotalLastmonth;
                this.form.coolwater = this.form.coolwaterTotal-this.form.coolwaterTotalLastmonth;
                this.form.hotwater = this.form.hotwaterTotal-this.form.hotwaterTotalLastmonth;
              }
              
              listConfig(this.tableData).then(res => {
                for(let i=0;i<res.total;i++){
                if(res.rows[i].areaNumber=="333" && res.rows[i].nian==this.form.nian && res.rows[i].yue==this.form.yue &&res.rows[i].areaNumber==this.form.areaNumber ){
                  this.form.electricityFee = Math.floor((res.rows[i].electricityPrice * this.form.electricity) * 100) / 100;
                }
                if(res.rows[i].areaNumber=="1585" && res.rows[i].nian==this.form.nian && res.rows[i].yue==this.form.yue &&res.rows[i].areaNumber==this.form.areaNumber ){
                  this.form.electricityFee = Math.floor((res.rows[i].electricityPrice * this.form.electricity) * 100) / 100;
                  this.form.hotwaterFee = Math.floor((res.rows[i].hotwaterPrice * this.form.hotwater) * 100) / 100
                  this.form.coolwaterFee = Math.floor((res.rows[i].coolwaterPrice * this.form.coolwater) * 100) / 100
                }

                }
              }); 
      
              updateRoom(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            }else{
            await this.getTableData();
            //计算费用
            // listConfig(this.tableData).then(res => {
            //   // console.log(JSON.stringify(res.rows))
            //   for(let i=0;i<res.total;i++){
            //     if(this.form.areaNumber == "1400"){
            //       if(res.rows[i].nian==this.form.nian && res.rows[i].yue==this.form.yue &&res.rows[i].areaNumber==this.form.areaNumber && res.rows[i].dormFloor==this.form.dormFloor ){
            //         //2位小数 第三位舍去 .slice(0, result.indexOf('.') + 2)
            //         this.form.electricityFee = Number((res.rows[i].electricityPrice * this.form.electricity).slice(0, (res.rows[i].electricityPrice * this.form.electricity).indexOf('.') + 2))
            //         this.form.hotwaterFee = Number((res.rows[i].hotwaterPrice * this.form.hotwater).slice(0, (res.rows[i].hotwaterPrice * this.form.hotwater).indexOf('.') + 2))
            //         this.form.coolwaterFee = Number((res.rows[i].coolwaterPrice * this.form.coolwater).slice(0, (res.rows[i].coolwaterPrice * this.form.coolwater).indexOf('.') + 2))
            //       }
            //     }else{
            //       if(res.rows[i].nian==this.form.nian && res.rows[i].yue==this.form.yue &&res.rows[i].areaNumber==this.form.areaNumber ){
            //         //2位小数 第三位舍去 .slice(0, result.indexOf('.') + 2)    Math.floor((res.rows[i].coolwaterPrice * this.form.coolwater) * 100) / 100
            //         this.form.electricityFee = Math.floor((res.rows[i].electricityPrice * this.form.electricity) * 100) / 100
            //         this.form.hotwaterFee = Math.floor((res.rows[i].hotwaterPrice * this.form.hotwater) * 100) / 100
            //         this.form.coolwaterFee = Math.floor((res.rows[i].coolwaterPrice * this.form.coolwater) * 100) / 100
            //         console.log("3")
            //       }
            //     }
            //   }
            // });
            this.form.startdate = String( this.form.startdate)
            this.form.enddate = String( this.form.enddate)

            updateRoom(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
            }
          } else {
            addRoom(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }

    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const roomfeeIds = row.roomfeeId || this.ids;
      this.$modal.confirm('是否确认删除房间费用编号为"' + roomfeeIds + '"的数据项？').then(function() {
        return delRoom(roomfeeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('fee/room/export', {
        ...this.queryParams
      }, `room_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "流动导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('fee/room/importTemplate', {
      }, `房间费用_模板_${new Date().getTime()}.xlsx`)
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
