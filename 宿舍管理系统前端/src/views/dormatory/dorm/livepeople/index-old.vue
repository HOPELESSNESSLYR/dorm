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
      <el-form-item label="入住位置" prop="checkInaddress">
        <el-input
          v-model="queryParams.checkInaddress"
          placeholder="请输入入住位置"
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
      <el-form-item label="雇佣状态" prop="guyongstatus">
        <el-select v-model="queryParams.guyongstatus" placeholder="请选择雇佣状态" clearable>
          <el-option
            v-for="dict in dict.type.dorm_guyongstatus"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="离职日期">
        <el-date-picker
          v-model="daterangeOutjobdate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
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
      <el-form-item label="职级" prop="level">
        <el-input
          v-model="queryParams.level"
          placeholder="请输入职级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="班次" prop="classes">
        <el-input
          v-model="queryParams.classes"
          placeholder="请输入班次"
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
      <el-form-item label="原因" prop="reason">
        <el-input
          v-model="queryParams.reason"
          placeholder="请输入原因"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否已入住" prop="livecheck">
        <el-input
          v-model="queryParams.livecheck"
          placeholder="请输入是否已入住"
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
      <el-form-item label="是否已退宿" prop="quitcheck">
        <el-input
          v-model="queryParams.quitcheck"
          placeholder="请输入是否已退宿"
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
      <el-form-item label="是否调宿" prop="tuneIncheck">
        <el-input
          v-model="queryParams.tuneIncheck"
          placeholder="请输入是否调宿"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="调宿日期" prop="tuneIndate">
        <el-date-picker clearable
          v-model="queryParams.tuneIndate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择调宿日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否重复入住" prop="repetitioncheck">
        <el-input
          v-model="queryParams.repetitioncheck"
          placeholder="请输入是否重复入住"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否入黑名单" prop="blacklistcheck">
        <el-input
          v-model="queryParams.blacklistcheck"
          placeholder="请输入是否入黑名单"
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
      <el-form-item label="柜子号" prop="wardrobe">
        <el-input
          v-model="queryParams.wardrobe"
          placeholder="请输入柜子号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否免水电" prop="freecheck">
        <el-input
          v-model="queryParams.freecheck"
          placeholder="请输入是否免水电"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="免水电天数" prop="freedays">
        <el-input
          v-model="queryParams.freedays"
          placeholder="请输入免水电天数"
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
      <el-form-item label="住宿费用" prop="cost">
        <el-input
          v-model="queryParams.cost"
          placeholder="请输入住宿费用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否临时" prop="temporary">
        <el-input
          v-model="queryParams.temporary"
          placeholder="请输入是否临时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="领用物品" prop="usearticle">
        <el-input
          v-model="queryParams.usearticle"
          placeholder="请输入领用物品"
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
          v-hasPermi="['livepeople:livepeople:add']"
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
          v-hasPermi="['livepeople:livepeople:edit']"
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
          v-hasPermi="['livepeople:livepeople:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['livepeople:livepeople:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['livepeople:livepeople:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="livepeopleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="入住位置" align="center" prop="checkInaddress" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="身份证号" align="center" prop="idnumber" />
      <el-table-column label="工号" align="center" prop="jobnumber" />
      <el-table-column label="性别" align="center" prop="sex">
        <template slot-scope="scope">
          <span v-if="scope.row.sex=='0'">{{"女"}}</span>
          <span v-if="scope.row.sex=='1'">{{"男"}}</span>
        </template>
      </el-table-column>
      <el-table-column label="雇佣状态" align="center" prop="guyongstatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dorm_guyongstatus" :value="scope.row.guyongstatus"/>
        </template>
      </el-table-column>
      <el-table-column label="离职日期" align="center" prop="outjobdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.outjobdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="一级部门" align="center" prop="department1" />
      <el-table-column label="二级部门" align="center" prop="department2" />
      <el-table-column label="三级部门" align="center" prop="department3" />
      <el-table-column label="岗位" align="center" prop="job" />
      <el-table-column label="籍贯" align="center" prop="location" />
      <el-table-column label="户籍地址" align="center" prop="address" />
      <el-table-column label="职级" align="center" prop="level" />
      <el-table-column label="班次" align="center" prop="classes" />
      <el-table-column label="联系方式" align="center" prop="phone" />
      <el-table-column label="紧急联系人" align="center" prop="emergencycontact" />
      <el-table-column label="与紧急联系人关系" align="center" prop="relationship" />
      <el-table-column label="紧急联系人联系方式" align="center" prop="emergencyphone" />
      <el-table-column label="原因" align="center" prop="reason" />
      <el-table-column label="是否已入住" align="center" prop="livecheck" />
      <el-table-column label="入住日期" align="center" prop="livedate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.livedate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否已退宿" align="center" prop="quitcheck" />
      <el-table-column label="退宿类型" align="center" prop="retreattype" />
      <el-table-column label="退宿日期" align="center" prop="retreatdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.retreatdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否调宿" align="center" prop="tuneIncheck" />
      <el-table-column label="调宿日期" align="center" prop="tuneIndate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.tuneIndate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否重复入住" align="center" prop="repetitioncheck" />
      <el-table-column label="是否入黑名单" align="center" prop="blacklistcheck" />
      <el-table-column label="床位号" align="center" prop="bednumber" />
      <el-table-column label="柜子号" align="center" prop="wardrobe" />
      <el-table-column label="是否免水电" align="center" prop="freecheck" />
      <el-table-column label="免水电天数" align="center" prop="freedays" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="住宿费用" align="center" prop="cost" />
      <el-table-column label="是否临时" align="center" prop="temporary" />
      <el-table-column label="领用物品" align="center" prop="usearticle" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['livepeople:livepeople:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['livepeople:livepeople:remove']"
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

    <!-- 添加或修改人员信息对话框 -->
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
        <el-form-item label="入住位置" prop="checkInaddress">
          <el-input v-model="form.checkInaddress" placeholder="请输入入住位置" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idnumber">
          <el-input v-model="form.idnumber" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="工号" prop="jobnumber">
          <el-input v-model="form.jobnumber" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="雇佣状态">
          <el-radio-group v-model="form.guyongstatus">
            <el-radio
              v-for="dict in dict.type.dorm_guyongstatus"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="离职日期" prop="outjobdate">
          <el-date-picker clearable
                          v-model="form.outjobdate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择离职日期">
          </el-date-picker>
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
        <el-form-item label="籍贯" prop="location">
          <el-input v-model="form.location" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="户籍地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入户籍地址" />
        </el-form-item>
        <el-form-item label="职级" prop="level">
          <el-input v-model="form.level" placeholder="请输入职级" />
        </el-form-item>
        <el-form-item label="班次" prop="classes">
          <el-input v-model="form.classes" placeholder="请输入班次" />
        </el-form-item>
        <el-form-item label="联系方式" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入联系方式" />
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
        <el-form-item label="原因" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入原因" />
        </el-form-item>
        <el-form-item label="是否已入住" prop="livecheck">
          <el-input v-model="form.livecheck" placeholder="请输入是否已入住" />
        </el-form-item>
        <el-form-item label="入住日期" prop="livedate">
          <el-date-picker clearable
            v-model="form.livedate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入住日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否已退宿" prop="quitcheck">
          <el-input v-model="form.quitcheck" placeholder="请输入是否已退宿" />
        </el-form-item>
        <el-form-item label="退宿日期" prop="retreatdate">
          <el-date-picker clearable
            v-model="form.retreatdate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择退宿日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否调宿" prop="tuneIncheck">
          <el-input v-model="form.tuneIncheck" placeholder="请输入是否调宿" />
        </el-form-item>
        <el-form-item label="调宿日期" prop="tuneIndate">
          <el-date-picker clearable
            v-model="form.tuneIndate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择调宿日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否重复入住" prop="repetitioncheck">
          <el-input v-model="form.repetitioncheck" placeholder="请输入是否重复入住" />
        </el-form-item>
        <el-form-item label="是否入黑名单" prop="blacklistcheck">
          <el-input v-model="form.blacklistcheck" placeholder="请输入是否入黑名单" />
        </el-form-item>
        <el-form-item label="床位号" prop="bednumber">
          <el-input v-model="form.bednumber" placeholder="请输入床位号" />
        </el-form-item>
        <el-form-item label="柜子号" prop="wardrobe">
          <el-input v-model="form.wardrobe" placeholder="请输入柜子号" />
        </el-form-item>
        <el-form-item label="是否免水电" prop="freecheck">
          <el-input v-model="form.freecheck" placeholder="请输入是否免水电" />
        </el-form-item>
        <el-form-item label="免水电天数" prop="freedays">
          <el-input v-model="form.freedays" placeholder="请输入免水电天数" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="住宿费用" prop="cost">
          <el-input v-model="form.cost" placeholder="请输入住宿费用" />
        </el-form-item>
        <el-form-item label="是否临时" prop="temporary">
          <el-input v-model="form.temporary" placeholder="请输入是否临时" />
        </el-form-item>
        <el-form-item label="领用物品" prop="usearticle">
          <el-input v-model="form.usearticle" placeholder="请输入领用物品" />
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
import { listLivepeople, getLivepeople, delLivepeople, addLivepeople, updateLivepeople } from "@/api/livepeople/livepeople";
import {getToken} from "@/utils/auth";

export default {
  name: "Livepeople",
  dicts: ['dorm_guyongstatus'],
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
      // 人员信息表格数据
      livepeopleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      daterangeOutjobdate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        areaNumber: null,
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        checkInaddress: null,
        name: null,
        idnumber: null,
        jobnumber: null,
        sex: null,
        guyongstatus: null,
        outjobdate: null,
        department1: null,
        department2: null,
        department3: null,
        job: null,
        location: null,
        address: null,
        level: null,
        classes: null,
        phone: null,
        emergencycontact: null,
        relationship: null,
        emergencyphone: null,
        reason: null,
        livecheck: null,
        livedate: null,
        quitcheck: null,
        retreattype: null,
        retreatdate: null,
        tuneIncheck: null,
        tuneIndate: null,
        repetitioncheck: null,
        blacklistcheck: null,
        bednumber: null,
        wardrobe: null,
        freecheck: null,
        freedays: null,
        remarks: null,
        cost: null,
        temporary: null,
        usearticle: null
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
        checkInaddress: [
          { required: true, message: "入住位置不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        idnumber: [
          { required: true, message: "身份证号不能为空", trigger: "blur" }
        ],
        jobnumber: [
          { required: true, message: "工号不能为空", trigger: "blur" }
        ],
        sex: [
          { required: true, message: "性别不能为空", trigger: "change" }
        ],
        guyongstatus: [
          { required: true, message: "雇佣状态不能为空", trigger: "blur" }
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
        location: [
          { required: true, message: "籍贯不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "户籍地址不能为空", trigger: "blur" }
        ],
        phone: [
          { required: true, message: "联系方式不能为空", trigger: "blur" }
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
        reason: [
          { required: true, message: "原因不能为空", trigger: "blur" }
        ],
        livedate: [
          { required: true, message: "入住日期不能为空", trigger: "blur" }
        ],
        bednumber: [
          { required: true, message: "床位号不能为空", trigger: "blur" }
        ],
        wardrobe: [
          { required: true, message: "柜子号不能为空", trigger: "blur" }
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
        url: process.env.VUE_APP_BASE_API + "/livepeople/livepeople/importData"
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询人员信息列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeOutjobdate && '' != this.daterangeOutjobdate) {
        this.queryParams.params["beginOutjobdate"] = this.daterangeOutjobdate[0];
        this.queryParams.params["endOutjobdate"] = this.daterangeOutjobdate[1];
      }
      listLivepeople(this.queryParams).then(response => {
        this.livepeopleList = response.rows;
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
        checkInaddress: null,
        name: null,
        idnumber: null,
        jobnumber: null,
        sex: null,
        guyongstatus: null,
        outjobdate: null,
        department1: null,
        department2: null,
        department3: null,
        job: null,
        location: null,
        address: null,
        level: null,
        classes: null,
        phone: null,
        emergencycontact: null,
        relationship: null,
        emergencyphone: null,
        reason: null,
        livecheck: null,
        livedate: null,
        quitcheck: null,
        retreattype: null,
        retreatdate: null,
        tuneIncheck: null,
        tuneIndate: null,
        repetitioncheck: null,
        blacklistcheck: null,
        bednumber: null,
        wardrobe: null,
        freecheck: null,
        freedays: null,
        remarks: null,
        cost: null,
        temporary: null,
        usearticle: null

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
      this.daterangeOutjobdate = [];
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
      this.title = "添加人员信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLivepeople(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人员信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLivepeople(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLivepeople(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除人员信息编号为"' + ids + '"的数据项？').then(function() {
        return delLivepeople(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('livepeople/livepeople/export', {
        ...this.queryParams
      }, `livepeople_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "流动导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('livepeople/livepeople/importTemplate', {
      }, `住客信息_模板_${new Date().getTime()}.xlsx`)
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
