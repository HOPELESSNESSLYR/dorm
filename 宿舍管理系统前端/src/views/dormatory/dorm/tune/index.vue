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
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
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
      <el-form-item label="籍贯" prop="location">
        <el-input
          v-model="queryParams.location"
          placeholder="请输入籍贯"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="户籍地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入户籍地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请日期" prop="applyDate">
        <el-date-picker clearable
          v-model="queryParams.applyDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择申请日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="床位号" prop="bednumber">
        <el-input
          v-model="queryParams.bednumber"
          placeholder="请输入床位号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="柜子号" prop="wardrobe">
        <el-input
          v-model="queryParams.wardrobe"
          placeholder="请输入柜子号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请原因" prop="reason">
        <el-input
          v-model="queryParams.reason"
          placeholder="请输入申请原因"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入住日期" prop="livedate">
        <el-date-picker clearable
          v-model="queryParams.livedate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入住日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结束日期" prop="enddate">
        <el-date-picker clearable
                        v-model="queryParams.enddate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="请假天数" prop="leaveoffday">
        <el-input
          v-model="queryParams.leaveoffday"
          placeholder="请输入请假天数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退宿日期" prop="retreatdate">
        <el-date-picker clearable
          v-model="queryParams.retreatdate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择退宿日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="紧急联系人" prop="emergencycontact">
        <el-input
          v-model="queryParams.emergencycontact"
          placeholder="请输入紧急联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="与紧急联系人关系" prop="relationship">
        <el-input
          v-model="queryParams.relationship"
          placeholder="请输入与紧急联系人关系"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系人联系方式" prop="emergencyphone">
        <el-input
          v-model="queryParams.emergencyphone"
          placeholder="请输入紧急联系人联系方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="变更房号" prop="changenumber">
        <el-input
          v-model="queryParams.changenumber"
          placeholder="请输入变更房号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="变更床位" prop="changebed">
        <el-input
          v-model="queryParams.changebed"
          placeholder="请输入变更床位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="变更日期" prop="changedate">
        <el-date-picker clearable
          v-model="queryParams.changedate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择变更日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总务专员" prop="generalCommissioner">
        <el-input
          v-model="queryParams.generalCommissioner"
          placeholder="请输入总务专员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宿管员" prop="adminname">
        <el-input
          v-model="queryParams.adminname"
          placeholder="请输入宿管员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请人" prop="applyname">
        <el-input
          v-model="queryParams.applyname"
          placeholder="请输入申请人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否更新" prop="hcmupdate">
        <el-input
          v-model="queryParams.hcmupdate"
          placeholder="请输入是否更新"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入住天数" prop="liveddays">
        <el-input
          v-model="queryParams.liveddays"
          placeholder="请输入入住天数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当月入住天数" prop="currentMonthLiveDays">
        <el-input
          v-model="queryParams.currentMonthLiveDays"
          placeholder="请输入当月入住天数"
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
          v-hasPermi="['dorm:tune:add']"
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
          v-hasPermi="['dorm:tune:edit']"
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
          v-hasPermi="['dorm:tune:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['dorm:tune:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dorm:tune:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tuneList" @selection-change="handleSelectionChange"  :max-height="maxHeight">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="身份证号" align="center" prop="idnumber" />
      <el-table-column label="工号" align="center" prop="jobnumber" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="一级部门" align="center" prop="department1" />
      <el-table-column label="二级部门" align="center" prop="department2" />
      <el-table-column label="三级部门" align="center" prop="department3" />
      <el-table-column label="岗位" align="center" prop="job" />
      <el-table-column label="性别" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dorm_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="联系方式" align="center" prop="phone" />
      <el-table-column label="籍贯" align="center" prop="location" />
      <el-table-column label="户籍地址" align="center" prop="address" />
      <el-table-column label="类别0:退宿:1:入住2:调宿" align="center" prop="type" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dorm_operator_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="申请日期" align="center" prop="applyDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.applyDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="床位号" align="center" prop="bednumber" />
      <el-table-column label="柜子号" align="center" prop="wardrobe" />
      <el-table-column label="申请原因" align="center" prop="reason" />
      <el-table-column label="入住日期" align="center" prop="livedate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.livedate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="当月入住天数" align="center" prop="currentMonthLiveDays" />
      <el-table-column label="退宿日期" align="center" prop="retreatdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.retreatdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="退宿类型" align="center" prop="retreattype" />
      <el-table-column label="紧急联系人" align="center" prop="emergencycontact" />
      <el-table-column label="与紧急联系人关系" align="center" prop="relationship" />
      <el-table-column label="紧急联系人联系方式" align="center" prop="emergencyphone" />
      <el-table-column label="变更房号" align="center" prop="changenumber" />
      <el-table-column label="变更床位" align="center" prop="changebed" />
      <el-table-column label="变更日期" align="center" prop="changedate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.changedate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="总务专员" align="center" prop="generalCommissioner" />
      <el-table-column label="宿管员" align="center" prop="adminname" />
      <el-table-column label="申请人" align="center" prop="applyname" />
      <el-table-column label="是否更新" align="center" prop="hcmupdate" />
      <el-table-column label="入住天数" align="center" prop="liveddays" />
      <el-table-column label="结束日期" align="center" prop="enddate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.enddate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="请假天数" align="center" prop="leaveoffday" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dorm:tune:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dorm:tune:remove']"
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

    <!-- 添加或修改入住调宿退宿申请对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
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
        <el-form-item label="身份证号" prop="idnumber">
          <el-input v-model="form.idnumber" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="工号" prop="jobnumber">
          <el-input v-model="form.jobnumber" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
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
        <el-form-item label="籍贯" prop="location">
          <el-input v-model="form.location" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="户籍地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入户籍地址" />
        </el-form-item>
        <el-form-item label="申请日期" prop="applyDate">
          <el-date-picker clearable
            v-model="form.applyDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择申请日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="床位号" prop="bednumber">
          <el-input v-model="form.bednumber" placeholder="请输入床位号" />
        </el-form-item>
        <el-form-item label="柜子号" prop="wardrobe">
          <el-input v-model="form.wardrobe" placeholder="请输入柜子号" />
        </el-form-item>
        <el-form-item label="申请原因" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入申请原因" />
        </el-form-item>
        <el-form-item label="入住日期" prop="livedate">
          <el-date-picker clearable
            v-model="form.livedate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入住日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="退宿日期" prop="retreatdate">
          <el-date-picker clearable
            v-model="form.retreatdate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择退宿日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="紧急联系人" prop="emergencycontact">
          <el-input v-model="form.emergencycontact" placeholder="请输入紧急联系人" />
        </el-form-item>
        <el-form-item label="与紧急联系人关系" prop="relationship">
          <el-input v-model="form.relationship" placeholder="请输入与紧急联系人关系" />
        </el-form-item>
        <el-form-item label="紧急联系人联系方式" prop="emergencyphone">
          <el-input v-model="form.emergencyphone" placeholder="请输入紧急联系人联系方式" />
        </el-form-item>
        <el-form-item label="变更房号" prop="changenumber">
          <el-input v-model="form.changenumber" placeholder="请输入变更房号" />
        </el-form-item>
        <el-form-item label="变更床位" prop="changebed">
          <el-input v-model="form.changebed" placeholder="请输入变更床位" />
        </el-form-item>
        <el-form-item label="变更日期" prop="changedate">
          <el-date-picker clearable
            v-model="form.changedate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择变更日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="总务专员" prop="generalCommissioner">
          <el-input v-model="form.generalCommissioner" placeholder="请输入总务专员" />
        </el-form-item>
        <el-form-item label="宿管员" prop="adminname">
          <el-input v-model="form.adminname" placeholder="请输入宿管员" />
        </el-form-item>
        <el-form-item label="申请人" prop="applyname">
          <el-input v-model="form.applyname" placeholder="请输入申请人" />
        </el-form-item>
        <el-form-item label="是否更新" prop="hcmupdate">
          <el-input v-model="form.hcmupdate" placeholder="请输入是否更新" />
        </el-form-item>
        <el-form-item label="入住天数" prop="liveddays">
          <el-input v-model="form.liveddays" placeholder="请输入入住天数" />
        </el-form-item>
        <el-form-item label="当月入住天数" prop="currentMonthLiveDays">
          <el-input v-model="form.currentMonthLiveDays" placeholder="请输入当月入住天数" />
        </el-form-item>
        <el-form-item label="结束日期" prop="enddate">
          <el-date-picker clearable
                          v-model="form.enddate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="请假天数" prop="leaveoffday">
          <el-input v-model="form.leaveoffday" placeholder="请输入请假天数" />
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
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的流水数据
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
import { listTune, getTune, delTune, addTune, updateTune } from "@/api/dorm/tune";
import {getToken} from "@/utils/auth";

export default {
  name: "Tune",
  dicts: ['dorm_sex','dorm_operator_type'],
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
      // 入住调宿退宿申请表格数据
      tuneList: [],
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
        idnumber: null,
        jobnumber: null,
        name: null,
        department1: null,
        department2: null,
        department3: null,
        job: null,
        sex: null,
        phone: null,
        location: null,
        address: null,
        type: null,
        applyDate: null,
        bednumber: null,
        wardrobe: null,
        reason: null,
        livedate: null,
        retreatdate: null,
        retreattype: null,
        emergencycontact: null,
        relationship: null,
        emergencyphone: null,
        changenumber: null,
        changebed: null,
        changedate: null,
        remarks: null,
        generalCommissioner: null,
        adminname: null,
        applyname: null,
        hcmupdate: null,
        liveddays: null,
        enddate: null,
        leaveoffday: null,
        currentMonthLiveDays: null,
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
        dormFloor: [
          { required: true, message: "宿舍楼层号不能为空", trigger: "blur" }
        ],
        roomNumber: [
          { required: true, message: "宿舍房间号不能为空", trigger: "blur" }
        ],
        idnumber: [
          { required: true, message: "身份证号不能为空", trigger: "blur" }
        ],
        jobnumber: [
          { required: true, message: "工号不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        department1: [
          { required: true, message: "一级部门不能为空", trigger: "blur" }
        ],
        department2: [
          { required: true, message: "二级部门不能为空", trigger: "blur" }
        ],
        department3: [
          { required: true, message: "三级部门不能为空", trigger: "blur" }
        ],
        job: [
          { required: true, message: "岗位不能为空", trigger: "blur" }
        ],
        sex: [
          { required: true, message: "性别不能为空", trigger: "change" }
        ],
        phone: [
          { required: true, message: "联系方式不能为空", trigger: "blur" }
        ],
        location: [
          { required: true, message: "籍贯不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "户籍地址不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "类别0:退宿:1:入住2:调宿不能为空", trigger: "change" }
        ],
        applyDate: [
          { required: true, message: "申请日期不能为空", trigger: "blur" }
        ],
        bednumber: [
          { required: true, message: "床位号不能为空", trigger: "blur" }
        ],
        reason: [
          { required: true, message: "申请原因不能为空", trigger: "blur" }
        ],
        livedate: [
          { required: true, message: "入住日期不能为空", trigger: "blur" }
        ],
        retreatdate: [
          { required: true, message: "退宿日期不能为空", trigger: "blur" }
        ],
        emergencycontact: [
          { required: true, message: "紧急联系人不能为空", trigger: "blur" }
        ],
        relationship: [
          { required: true, message: "与紧急联系人关系不能为空", trigger: "blur" }
        ],
        emergencyphone: [
          { required: true, message: "紧急联系人联系方式不能为空", trigger: "blur" }
        ],
        hcmupdate: [
          { required: true, message: "是否更新不能为空", trigger: "blur" }
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
        url: process.env.VUE_APP_BASE_API + "/dorm/tune/importData"
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询入住调宿退宿申请列表 */
    getList() {
      this.loading = true;
      listTune(this.queryParams).then(response => {
        this.tuneList = response.rows;
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
        dormFloor: null,
        roomNumber: null,
        idnumber: null,
        jobnumber: null,
        name: null,
        department1: null,
        department2: null,
        department3: null,
        job: null,
        sex: null,
        phone: null,
        location: null,
        address: null,
        type: null,
        applyDate: null,
        bednumber: null,
        wardrobe: null,
        reason: null,
        livedate: null,
        retreatdate: null,
        retreattype: null,
        emergencycontact: null,
        relationship: null,
        emergencyphone: null,
        changenumber: null,
        changebed: null,
        changedate: null,
        remarks: null,
        generalCommissioner: null,
        adminname: null,
        applyname: null,
        hcmupdate: null,
        liveddays: null,
        enddate: null,
        leaveoffday: null,
        currentMonthLiveDays: null,
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
      this.title = "添加入住调宿退宿申请";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTune(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改入住调宿退宿申请";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTune(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTune(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除入住调宿退宿申请编号为"' + ids + '"的数据项？').then(function() {
        return delTune(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dorm/tune/export', {
        ...this.queryParams
      }, `tune_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "流动导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('dorm/tune/importTemplate', {
      }, `流动信息_模板_${new Date().getTime()}.xlsx`)
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
