<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="区域编号" prop="areaNumber">
        <el-input v-model="queryParams.areaNumber" placeholder="请输入区域编号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="区域名称" prop="areaName">
        <el-select v-model="queryParams.areaName" placeholder="请选择区域名称" clearable>
          <el-option v-for="dict in dict.type.dorm_area" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="宿舍楼编号" prop="floorNumber">
        <el-input v-model="queryParams.floorNumber" placeholder="请输入宿舍楼编号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="宿舍楼名称" prop="floorName">
        <el-input v-model="queryParams.floorName" placeholder="请输入宿舍楼名称" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="宿舍楼位置" prop="floorLocation">
        <el-input v-model="queryParams.floorLocation" placeholder="请输入宿舍楼位置" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="宿舍楼层号" prop="dormFloor">
        <el-input v-model="queryParams.dormFloor" placeholder="请输入宿舍楼层号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="宿舍房间号" prop="roomNumber">
        <el-input v-model="queryParams.roomNumber" placeholder="请输入宿舍房间号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="房间号前缀" prop="roomPrefix">
        <el-input v-model="queryParams.roomPrefix" placeholder="请输入房间号前缀" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="房间性别" prop="roomSex">
        <el-select v-model="queryParams.roomSex" placeholder="请选择房间性别" clearable>
          <el-option v-for="dict in dict.type.dorm_sex" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="宿舍可住人数" prop="livenumber">
        <el-select v-model="queryParams.livenumber" placeholder="请选择宿舍可住人数" clearable>
          <el-option v-for="dict in dict.type.dorm_people_count" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="宿舍实际人数" prop="peoplenumber">
        <el-select v-model="queryParams.peoplenumber" placeholder="请选择宿舍实际人数" clearable>
          <el-option v-for="dict in dict.type.dorm_people_count" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="宿舍剩余可住" prop="remainnumber">
        <el-select v-model="queryParams.remainnumber" placeholder="请选择宿舍剩余可住" clearable>
          <el-option v-for="dict in dict.type.dorm_people_count" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="柜子数量" prop="cabinetNumber">
        <el-input v-model="queryParams.cabinetNumber" placeholder="请输入柜子数量" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="宿舍人员信息卡" prop="roomCard">
        <el-input v-model="queryParams.roomCard" placeholder="请输入宿舍人员信息卡" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="是否临时" prop="temporary">
        <el-input v-model="queryParams.temporary" placeholder="请输入是否" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="楼栋号" prop="cavenumber">
        <el-input v-model="queryParams.cavenumber" placeholder="请输入楼栋号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="住宿费用" prop="cost">
        <el-input v-model="queryParams.cost" placeholder="请输入住宿费用" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="住宿费用承担人" prop="costman">
        <el-input v-model="queryParams.costman" placeholder="请输入住宿费用承担人" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['dorm:roominfor:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['dorm:roominfor:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['dorm:roominfor:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="info" plain icon="el-icon-upload2" size="mini" @click="handleImport"
          v-hasPermi="['dorm:roominfor:import']">导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['dorm:roominfor:export']">导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="selection.length < 2" @click="handleUpdates"
          v-hasPermi="['dorm:roominfor:edits']">批量修改</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>
    <!-- -------------------------------------------------------------------------------------------------------------------- -->
    <div class="table-container">
    <el-row :gutter="24" >
      <div v-for="(item, index) in roominforList" :key="index" style="text-align: center;">
        <el-col :span="4" style="margin-bottom: 10px;">
          <el-card class="box-card">
            <div slot="header" v-if="item.remainnumber == 0" class="noremain">
              <span class="word">{{ item.areaName }}</span>
              <el-checkbox v-model="item.checked" @change="handleSelectionChange([item])" />
            </div>
            <div slot="header" v-else-if="item.livenumber == item.remainnumber" class="empty">
              <span class="word">{{ item.areaName }}</span>
              <el-checkbox v-model="item.checked" @change="handleSelectionChange([item])" />
            </div>
            <div slot="header" v-else class="normal">
              <span class="word">{{ item.areaName }}</span>
              <el-checkbox v-model="item.checked" @change="handleSelectionChange([item])" />
            </div>
            <div body-style="font-size: 16px;">
              <router-link
                :to="'/dormatory/dorm/DormBed/dictDormBed/index/' + item.areaNumber + ',' + item.floorNumber + ',' + item.dormFloor + ',' + item.roomNumber">
                <p>{{ item.floorName }}{{ item.roomNumber }}</p>
                <p>{{item.roomSex==0?"女":男}}     {{ item.roomType }}人间</p>
                <p>剩余床位 {{ item.remainnumber }}</p>
              </router-link>
              <el-row :gutter="24">
                <el-col :gutter="12">
                  <el-button size="small" type="text" icon="el-icon-edit" @click="onOpenrz(item)"
                    v-hasPermi="['dorm:roominfor:edit']">入住</el-button>
                  <el-button size="small" type="text" icon="el-icon-edit" @click="onOpents(item)"
                    v-hasPermi="['dorm:roominfor:edit']">退宿</el-button>
                </el-col>
                <el-col  :gutter="12">
                  <el-button size="small" type="text" icon="el-icon-edit" @click="onOpendh(item)"
                    v-hasPermi="['dorm:roominfor:edit']">调换</el-button>
                  <el-button size="small" type="text" icon="el-icon-edit" @click="onOpenqjcc(item)"
                    v-hasPermi="['dorm:roominfor:edit']">请假出差</el-button>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </el-col>
      </div>
    </el-row>
    </div>

    <div class="fixed-bottom">
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      :pageSizes.sync="queryParams.pageSizes" @pagination="getList" />
    </div>

    <!-- 添加或修改房间信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body v-dialogDrag>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <template v-if="title === '批量修改房间信息'">
          <el-form-item label="房间性别" prop="roomSex">
            <el-select v-model="form.roomSex" placeholder="请选择房间性别">
              <el-option v-for="dict in dict.type.dorm_sex" :key="dict.value" :label="dict.label"
                :value="dict.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="房间类型" prop="roomType">
            <el-select v-model="form.roomType" placeholder="请选择房间类型">
              <el-option v-for="dict in dict.type.dorm_type" :key="dict.value" :label="dict.label"
                :value="dict.value">
              </el-option>
            </el-select>
            <!-- <el-input v-model="form.roomType" placeholder="请输入宿舍类型" /> -->
          </el-form-item>
        </template>
        <template v-else>
          <el-form-item label="区域编号" prop="areaNumber">
            <el-input v-model="form.areaNumber" placeholder="请输入区域编号" />
          </el-form-item>
          <el-form-item label="区域名称" prop="areaName">
            <el-select v-model="form.areaName" placeholder="请选择区域名称">
              <el-option v-for="dict in dict.type.dorm_area" :key="dict.value" :label="dict.label"
                :value="dict.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="宿舍楼编号" prop="floorNumber">
            <el-input v-model="form.floorNumber" placeholder="请输入宿舍楼编号" />
          </el-form-item>
          <el-form-item label="宿舍楼名称" prop="floorName">
            <el-input v-model="form.floorName" placeholder="请输入宿舍楼名称" />
          </el-form-item>
          <el-form-item label="宿舍楼位置" prop="floorLocation">
            <el-input v-model="form.floorLocation" placeholder="请输入宿舍楼位置" />
          </el-form-item>
          <el-form-item label="宿舍楼层号" prop="dormFloor">
            <el-input v-model="form.dormFloor" placeholder="请输入宿舍楼层号" />
          </el-form-item>
          <el-form-item label="宿舍房间号" prop="roomNumber">
            <el-input v-model="form.roomNumber" placeholder="请输入宿舍房间号" />
          </el-form-item>
          <el-form-item label="房间号前缀" prop="roomPrefix">
            <el-input v-model="form.roomPrefix" placeholder="请输入房间号前缀" />
          </el-form-item>
          <el-form-item label="房间性别" prop="roomSex">
            <el-select v-model="form.roomSex" placeholder="请选择房间性别">
              <el-option v-for="dict in dict.type.dorm_sex" :key="dict.value" :label="dict.label"
                :value="parseInt(dict.value)"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="宿舍可住人数" prop="livenumber">
            <el-select v-model="form.livenumber" placeholder="请选择宿舍可住人数">
              <el-option v-for="dict in dict.type.dorm_people_count" :key="dict.value" :label="dict.label"
                :value="parseInt(dict.value)"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="宿舍实际人数" prop="peoplenumber">
            <el-select v-model="form.peoplenumber" placeholder="请选择宿舍实际人数">
              <el-option v-for="dict in dict.type.dorm_people_count" :key="dict.value" :label="dict.label"
                :value="parseInt(dict.value)"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="宿舍剩余可住" prop="remainnumber">
            <el-select v-model="form.remainnumber" placeholder="请选择宿舍剩余可住">
              <el-option v-for="dict in dict.type.dorm_people_count" :key="dict.value" :label="dict.label"
                :value="parseInt(dict.value)"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="柜子数量" prop="cabinetNumber">
            <el-input v-model="form.cabinetNumber" placeholder="请输入柜子数量" />
          </el-form-item>
          <el-form-item label="宿舍固定资产信息" prop="roomProperty">
            <el-input v-model="form.roomProperty" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="宿舍人员信息" prop="roomPeople">
            <el-input v-model="form.roomPeople" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="宿舍人员信息卡" prop="roomCard">
            <el-input v-model="form.roomCard" placeholder="请输入宿舍人员信息卡" />
          </el-form-item>
          <el-form-item label="是否临时" prop="temporary">
            <el-input v-model="form.temporary" placeholder="请输入是否临时0：临时，1：非临时" />
          </el-form-item>
          <el-form-item label="楼栋号" prop="cavenumber">
            <el-input v-model="form.cavenumber" placeholder="请输入楼栋号" />
          </el-form-item>
          <el-form-item label="住宿费用" prop="cost">
            <el-input v-model="form.cost" placeholder="请输入住宿费用" />
          </el-form-item>
          <el-form-item label="住宿费用承担人" prop="costman">
            <el-input v-model="form.costman" placeholder="请输入住宿费用承担人" />
          </el-form-item>
          <el-form-item label="宿舍类型" prop="roomType">
            <el-input v-model="form.roomType" placeholder="请输入宿舍类型" />
          </el-form-item>
          <el-form-item label="房间状态" prop="roomStatus">
            <el-input v-model="form.roomStatus" placeholder="请输入房间状态" />
          </el-form-item>
        </template>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


    <el-dialog v-bind="$attrs" v-on="$listeners" @close="onCloserz" title="入住信息登记" :visible.sync="isVisible">
      <el-row :gutter="15">
        <el-form ref="elForm" :model="formData" :rules="rulesrz" size="medium" label-width="100px">
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="姓名" prop="name">
                  <el-select v-model="formData.name" placeholder="请选择姓名" filterable clearable :style="{ width: '100%' }"
                    @click="getonlivepeople" @change="getonlivepeopleinfo($event)">
                    <el-option v-for="(item, index) in nameOptions" :key="index" :label="item.label" :value="item.value"
                      :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="身份证号" prop="IDnumber">
                  <el-input v-model="formData.IDnumber" placeholder="请输入身份证号" readonly clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="性别" prop="sex">
                  <el-input v-model="formData.sex" placeholder="请输入性别" readonly clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!--<el-col :span="12">
              <el-row :gutter="15">
                <el-col :span="24">
                  <el-form-item label="联系方式" prop="phone">
                    <el-input v-model="formData.phone" placeholder="请输入手机号"  clearable
                              :style="{width: '100%'}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-col>-->
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="区域名称" prop="areaName">
                  <el-input v-model="formData.areaName" placeholder="请输入区域名称" readonly clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="宿舍楼名称" prop="floorName">
                  <el-input v-model="formData.floorName" placeholder="请输入宿舍楼名称" readonly clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="房间号" prop="roomNumber">
                  <el-input v-model="formData.roomNumber" placeholder="请输入房间号" readonly clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="床位号" prop="bed">
                  <el-select v-model="formData.bed" placeholder="请选择床位" filterable clearable :style="{ width: '100%' }">
                    <el-option v-for="(item, index) in bedOptions" :key="index" :label="item.label" :value="item.value"
                      :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="柜子号" prop="roomNumber">
                  <el-input v-model="formData.wardrobe" placeholder="请输入柜子号" clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="钥匙数" prop="roomNumber">
                  <el-input v-model="formData.keynumber" placeholder="请输入钥匙数" clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-form>
      </el-row>
      <div slot="footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="handleConfirm" v-hasPermi="['dorm:roominfor:ruzhuconfirm']">确定</el-button>
      </div>
    </el-dialog>
    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload ref="upload" :limit="1" accept=".xlsx, .xls" :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport" :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false" drag>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的房间数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
            @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog v-bind="$attrs" v-on="$listeners" @close="onClose2" title="调换申请单" :visible.sync="isVisible2">
      <el-row :gutter="15">
        <el-form ref="elForm2" :model="formData2" :rules="rules2" size="medium" label-width="100px">
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="调换人姓名" prop="name1">
                  <el-select v-model="formData2.name1" placeholder="请输入调换人姓名" clearable filterable
                    :style="{ width: '100%' }" @change="getlivepeopleinfo($event)">
                    <el-option v-for="(item, index) in name1Options2" :key="index" :label="item.label" :value="item.value"
                      :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!--<el-col :span="12">
              <el-row :gutter="15">
                <el-col :span="24">
                  <el-form-item label="被调人姓名" prop="name2">
                    <el-select v-model="formData2.name2" placeholder="请输入被调人姓名" clearable filterable
                               :style="{width: '100%'}" @change="getlivepeopleinfo2($event)">
                      <el-option v-for="(item, index) in name2Options2" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-col>-->
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="身份证号" prop="IDnumber1">
                  <el-input v-model="formData2.IDnumber1" placeholder="请输入身份证号" readonly clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!--<el-col :span="12">
              <el-row :gutter="15">
                <el-col :span="24">
                  <el-form-item label="身份证号" prop="IDnumber2">
                    <el-input v-model="formData2.IDnumber2" placeholder="请输入身份证号" readonly clearable
                              :style="{width: '100%'}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-col>-->
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="区域编号" prop="areaNumber1">
                  <el-select v-model="formData2.areaNumber1" placeholder="请输入区域编号" clearable :style="{ width: '100%' }">
                    <el-option v-for="dict in dict.type.dorm_areaNumber" :key="dict.value" :label="dict.label"
                      :value="dict.value"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="宿舍楼" prop="floorName1">
                  <el-select v-model="formData2.floorName1" placeholder="请输入宿舍楼" clearable :style="{ width: '100%' }">
                    <el-option v-for="(item, index) in floorName1Options2" :key="index" :label="item.label"
                      :value="item.value" :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!--<el-col :span="12">
              <el-row :gutter="15">
                <el-col :span="24">
                  <el-form-item label="宿舍楼" prop="floorName2">
                    <el-select v-model="formData2.floorName2" placeholder="请输入宿舍楼" clearable
                               :style="{width: '100%'}">
                      <el-option v-for="(item, index) in floorName2Options2" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-col>-->
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="楼层" prop="dormFloor1">
                  <el-select v-model="formData2.dormFloor1" placeholder="请选择楼层" clearable :style="{ width: '100%' }">
                    <el-option v-for="(item, index) in dormFloor1Options2" :key="index" :label="item.label"
                      :value="item.value" :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!--<el-col :span="12">
              <el-row :gutter="15">
                <el-col :span="24">
                  <el-form-item label="楼层" prop="dormFloor2">
                    <el-select v-model="formData2.dormFloor2" placeholder="请选择楼层" clearable
                               :style="{width: '100%'}">
                      <el-option v-for="(item, index) in dormFloor2Options2" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-col>-->
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="房间号" prop="room1">
                  <el-select v-model="formData2.room1" placeholder="请选择房间号" filterable clearable
                    :style="{ width: '100%' }">
                    <el-option v-for="(item, index) in room1Options2" :key="index" :label="item.label" :value="item.value"
                      :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!--<el-col :span="12">
              <el-row :gutter="15">
                <el-col :span="24">
                  <el-form-item label="房间号" prop="room2">
                    <el-select v-model="formData2.room2" placeholder="请选择房间号" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in room2Options2" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-col>-->
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="床位号" prop="bed1">
                  <el-select v-model="formData2.bed1" placeholder="请选择床位号" clearable :style="{ width: '100%' }"
                    @focus="getkongbedinfo3">
                    <el-option v-for="(item, index) in bed1Options2" :key="index" :label="item.label" :value="item.value"
                      :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!--<el-col :span="12">
              <el-row :gutter="15">
                <el-col :span="24">
                  <el-form-item label="床位号" prop="bed2">
                    <el-select v-model="formData2.bed2" placeholder="请选择床位号" clearable :style="{width: '100%'}">
                      <el-option v-for="(item, index) in bed2Options2" :key="index" :label="item.label"
                                 :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-col>-->
          <el-col :span="24">
            <el-form-item label="原因" prop="reason">
              <el-input v-model="formData2.reason" placeholder="请输入原因" clearable :style="{ width: '100%' }"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remarks">
              <el-input v-model="formData2.remarks" placeholder="请输入备注" clearable :style="{ width: '100%' }"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <!--              <el-row :gutter="14">-->
            <el-col :span="24">
              <el-form-item label="入住天数" prop="roomNumber">
                <el-input v-model="formData2.currentMonthLiveDays" readonly clearable
                  :style="{ width: '100%' }"></el-input>
              </el-form-item>
            </el-col>
            <!--              </el-row>-->
          </el-col>
        </el-form>
      </el-row>
      <div slot="footer">
        <el-button @click="close2">取消</el-button>
        <el-button type="primary" @click="handleConfirm2" v-hasPermi="['dorm:roominfor:diaohuanconfirm']">确定调换</el-button>
      </div>
    </el-dialog>
    <el-dialog v-bind="$attrs" v-on="$listeners" @close="onClose3" title="退宿申请单" :visible.sync="isVisible3">
      <el-row :gutter="15">
        <el-form ref="elForm3" :model="formData3" :rules="rules3" size="medium" label-width="100px">
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="房间号" prop="roomNumber">
                  <el-input v-model="formData3.roomNumber" placeholder="请输入房间号" clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="姓名" prop="name">
                  <el-select v-model="formData3.name" placeholder="请输入姓名" clearable filterable :style="{ width: '100%' }"
                    @change="getlivepeopleinfo3($event)">
                    <el-option v-for="(item, index) in nameOptions2" :key="index" :label="item.label" :value="item.value"
                      :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="身份证号" prop="IDnumber">
                  <el-input v-model="formData3.IDnumber" placeholder="请输入身份证号" clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="性别" prop="sex">
                  <el-select v-model="formData3.sex" placeholder="请选择性别" clearable :style="{ width: '100%' }">
                    <el-option v-for="dict in dict.type.dorm_sex" :key="dict.value" :label="dict.label"
                      :value="dict.value"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="联系方式" prop="phone">
                  <el-input v-model="formData3.phone" placeholder="请输入手机号" clearable :style="{ width: '100%' }">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="床位号" prop="bedNumber">
                  <el-select v-model="formData3.bedNumber" placeholder="请选择床位号" clearable :style="{ width: '100%' }">
                    <el-option v-for="dict in dict.type.bed_Number" :key="dict.value" :label="dict.label"
                      :value="dict.value"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="14">
              <el-col :span="24">
                <el-form-item label="入住天数" prop="roomNumber">
                  <el-input v-model="formData3.currentMonthLiveDays" readonly clearable
                    :style="{ width: '100%' }"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="24">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="未归还物品详情" prop="articleDescription">
                  <el-checkbox-group v-model="formData3.articleDescription">
                    <el-checkbox v-for="(item, index) in formData3.articleDescriptionOptions" :key="index"
                      :label="item.label" :disabled="item.disabled" :value="item.value"></el-checkbox>
                  </el-checkbox-group>
                  <!--<el-input v-model="formData3.articleDescription" type="textarea" placeholder="请输入物品详情"
                            :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}" clearable></el-input>-->
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remarks">
              <el-input v-model="formData3.remarks" placeholder="请输入备注" clearable :style="{ width: '100%' }">
              </el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <div slot="footer">
        <el-button @click="close3">取消</el-button>
        <el-button type="primary" @click="handleConfirm3">确定</el-button>
      </div>
    </el-dialog>
    <el-dialog v-bind="$attrs" v-on="$listeners" @close="onClose4" title="请假出差申请单" :visible.sync="isVisible4">
      <el-row :gutter="15">
        <el-form ref="elForm4" :model="formData4" :rules="rules4" size="medium" label-width="100px">
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="区域编号" prop="areaNumber">
                  <el-input v-model="formData4.areaName" placeholder="请输入区域编号" clearable :style="{ width: '100%' }">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="宿舍楼" prop="floorName">
                  <el-input v-model="formData4.floorName" placeholder="请输入宿舍楼" clearable :style="{ width: '100%' }">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="楼层" prop="dormFloor">
                  <el-input v-model="formData4.dormFloor" placeholder="请选择楼层" clearable :style="{ width: '100%' }">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="房间号" prop="room">
                  <el-input v-model="formData4.room" placeholder="请选择房间号" filterable clearable :style="{ width: '100%' }">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="姓名" prop="name">
                  <el-select v-model="formData4.name" placeholder="请选择姓名" clearable :style="{ width: '100%' }"
                    @change="getlivepeopleinfo4($event)">
                    <el-option v-for="(item, index) in nameOptions4" :key="index" :label="item.label" :value="item.value"
                      :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="手机号" prop="phone">
                  <el-input v-model="formData4.phone" placeholder="请输入手机号" :maxlength="11" show-word-limit clearable
                    prefix-icon='el-icon-mobile' :style="{ width: '100%' }" disabled></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="部门" prop="department">
                  <el-input v-model="formData4.department" placeholder="请输入部门" clearable :style="{ width: '100%' }"
                    disabled></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="工号" prop="jobNumber">
                  <el-input v-model="formData4.jobNumber" placeholder="请输入工号" clearable :style="{ width: '100%' }"
                    disabled></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="8">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="起始日期" prop="startdate">
                  <el-date-picker v-model="formData4.startdate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                    :style="{ width: '100%' }" placeholder="请选择起始日期" @change="setday($event)" clearable></el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="8">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="结束日期" prop="enddate">
                  <el-date-picker v-model="formData4.enddate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                    :style="{ width: '100%' }" placeholder="请选择结束日期" @change="getday($event)" clearable></el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="8">
            <el-row :gutter="15">
              <el-col :span="24">
                <el-form-item label="共多少天" prop="day">
                  <el-input v-model="formData4.day" placeholder="请输入共多少天" clearable :style="{ width: '100%' }" disabled>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="24">
            <el-form-item label="原因说明" prop="reason">
              <el-input v-model="formData4.reason" placeholder="请输入原因说明" clearable :style="{ width: '100%' }">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remarks">
              <el-input v-model="formData4.remarks" placeholder="请输入备注" clearable :style="{ width: '100%' }">
              </el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <div slot="footer">
        <el-button @click="close4">取消</el-button>
        <el-button type="primary" @click="handleConfirm4">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listRoominfor,
  getRoominfor,
  delRoominfor,
  addRoominfor,
  updateRoominfor,
  ruzhuConfirm,
  getkongbed,
  getFloorName,
  getFloor,
  getRoomNumber,
  getlivingpeople,
  getLivepeople2,
  getarticleDescription, qingjiachuchaiConfirm, tuisuConfirm, diaohuanConfirm,
  batchUpdateRoominfor
} from "@/api/dorm/roominfor";
import { getOnlivepeople, listOnlivepeople } from "@/api/dorm/onlivepeople";
import { getToken } from "@/utils/auth";
import { getlistLivepeople, getLivepeople, listLivepeople } from "@/api/livepeople/livepeople";

export default {
  name: "Roominfor",
  inject: ['reload'],
  dicts: ['dorm_area', 'dorm_people_count', 'sys_user_sex', 'dorm_areaNumber', 'bed_Number', 'dorm_sex', 'dorm_type'],
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
      // 房间信息表格数据
      roominforList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageSizes: [24, 48, 72, 96],
        pageNum: 1,
        pageSize: 24,
        areaNumber: null,
        areaName: null,
        floorNumber: null,
        floorName: null,
        floorLocation: null,
        dormFloor: null,
        roomNumber: null,
        roomPrefix: null,
        roomSex: null,
        livenumber: null,
        peoplenumber: null,
        remainnumber: null,
        roomType: null,
        roomStatus: null,
        cabinetNumber: null,
        roomProperty: null,
        roomPeople: null,
        roomCard: null,
        temporary: null,
        cavenumber: null,
        cost: null,
        costman: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      formData: {
        name: undefined,
        IDnumber: undefined,
        sex: undefined,
        phone: undefined,
        area: undefined,
        floor: undefined,
        room: undefined,
        bf: undefined,
        bed: undefined,
        areaName: undefined,
        floorName: undefined,
        roomNumber: undefined,
        wardrobe: undefined,
        keynumber: 2,
        currentMonthLiveDays: undefined
      },
      nameOptions: [{
        "label": "",
        "value": ""
      }],
      bedOptions: [{
        "label": "",
        "value": ""
      }],
      areaOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      floorOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      roomOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      rulesrz: {
        name: [{
          required: true,
          message: '请选择姓名',
          trigger: 'change'
        }],
        IDnumber: [{
          required: true,
          message: '请输入身份证号',
          trigger: 'blur'
        }],
        sex: [{
          required: true,
          message: '请输入性别',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '请输入区域',
          trigger: 'change'
        }],
        floor: [{
          required: true,
          message: '请选择楼层',
          trigger: 'change'
        }],
        room: [{
          required: true,
          message: '请选择房间号',
          trigger: 'change'
        }],
        bed: [{
          required: true,
          message: '请选择床位号',
          trigger: 'change'
        }],
        wardrobe: [{
          required: true,
          message: '请选择柜子号',
          trigger: 'change'
        }],
        keynumber: [{
          required: true,
          message: '请选择钥匙数',
          trigger: 'change'
        }],
        /*phone: [{
          required: true,
          message: '请输入手机号',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],*/
      },
      isVisible: false,
      isVisible2: false,
      queryParamsrz: {
        pageNum: 1,
        pageSize: 999999999,
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
        flag: null
      },
      ID: [],
      rowid: null,
      rowobj: null,
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
        url: process.env.VUE_APP_BASE_API + "/dorm/roominfor/importData"
      },
      formData2: {
        name1: undefined,
        IDnumber1: undefined,
        floorName1: undefined,
        dormFloor1: undefined,
        room1: undefined,
        bed1: undefined,
        name2: undefined,
        IDnumber2: undefined,
        floorName2: undefined,
        dormFloor2: undefined,
        room2: undefined,
        bed2: undefined,
        remarks: undefined,
        areaNumber1: undefined,
        reason: undefined,
        currentMonthLiveDays: undefined
      },
      rules2: {
        areaNumber1: [{
          required: true,
          message: '请输入区域编码',
          trigger: 'change'
        }],
        name1: [{
          required: true,
          message: '请输入调换人姓名',
          trigger: 'change'
        }],
        // name2: [{
        //   required: true,
        //   message: '请输入被调人姓名',
        //   trigger: 'change'
        // }],
        IDnumber1: [{
          required: true,
          message: '请输入身份证号',
          trigger: 'blur'
        }],
        // IDnumber2: [{
        //   required: true,
        //   message: '请输入身份证号',
        //   trigger: 'blur'
        // }],
        floorName1: [{
          required: true,
          message: '请输入宿舍楼',
          trigger: 'change'
        }],
        // floorName2: [{
        //   required: true,
        //   message: '请输入宿舍楼',
        //   trigger: 'change'
        // }],
        dormFloor1: [{
          required: true,
          message: '请选择楼层',
          trigger: 'change'
        }],
        // dormFloor2: [{
        //   required: true,
        //   message: '请选择楼层',
        //   trigger: 'change'
        // }],
        room1: [{
          required: true,
          message: '请选择房间号',
          trigger: 'change'
        }],
        // room2: [{
        //   required: true,
        //   message: '请选择房间号',
        //   trigger: 'change'
        // }],
        bed1: [{
          required: true,
          message: '请选择床位号',
          trigger: 'change'
        }],
        // bed2: [{
        //   required: true,
        //   message: '请选择床位号',
        //   trigger: 'change'
        // }],
        remarks: [{
          required: true,
          message: '请输入备注',
          trigger: 'blur'
        }],
        reason: [{
          required: true,
          message: '请输入原因说明',
          trigger: 'blur'
        }],
      },
      name1Options2: [{
        "label": "选项一",
        "value": 1
      }],
      name2Options2: [{
        "label": "选项一",
        "value": 1
      }],
      floorName1Options2: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      floorName2Options2: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      dormFloor1Options2: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      dormFloor2Options2: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      room1Options2: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      room2Options2: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      bed1Options2: [{
        "label": "1",
        "value": "1"
      }, {
        "label": "2",
        "value": "2"
      }, {
        "label": "3",
        "value": "3"
      }, {
        "label": "4",
        "value": "4"
      }, {
        "label": "5",
        "value": "5"
      }, {
        "label": "6",
        "value": "6"
      }, {
        "label": "7",
        "value": "7"
      }, {
        "label": "8",
        "value": "8"
      }],
      bed2Options2: [{
        "label": "1",
        "value": "1"
      }, {
        "label": "2",
        "value": "2"
      }, {
        "label": "3",
        "value": "3"
      }, {
        "label": "4",
        "value": "4"
      }, {
        "label": "5",
        "value": "5"
      }, {
        "label": "6",
        "value": "6"
      }, {
        "label": "7",
        "value": "7"
      }, {
        "label": "8",
        "value": "8"
      }],
      // 查询参数
      queryParamsdh: {
        pageNum: 1,
        pageSize: 99999999,
        areaNumber: null,
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        checkInaddress: null,
        name: null,
        jobnumber: null,
        sex: null,
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
      formData3: {
        roomNumber: undefined,
        name: undefined,
        IDnumber: undefined,
        sex: undefined,
        phone: undefined,
        bedNumber: undefined,
        articleDescription: "",
        remarks: undefined,
        rowid: undefined,
        articleDescriptionOptions: {
          label: "",
          disabled: false,
        }
      },
      rules3: {
        roomNumber: [{
          required: true,
          message: '请输入房间号',
          trigger: 'blur'
        }],
        name: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        IDnumber: [{
          required: true,
          message: '请输入身份证号',
          trigger: 'blur'
        }],
        sex: [{
          required: true,
          message: '请选择性别',
          trigger: 'change'
        }],
        phone: [{
          required: true,
          message: '请输入手机号',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|6|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        bedNumber: [{
          required: true,
          message: '请选择床位号',
          trigger: 'change'
        }],
        /*articleDescription: [{
          required: true,
          message: '请输入物品详情',
          trigger: 'blur'
        }],*/
        remarks: [{
          required: true,
          message: '请输入备注',
          trigger: 'blur'
        }],
      },
      sexOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      bedNumberOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      isVisible3: false,
      isVisible4: false,
      nameOptions2: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      formData4: {
        areaName: undefined,
        floorName: undefined,
        dormFloor: undefined,
        room: undefined,
        name: undefined,
        phone: '',
        department: undefined,
        jobNumber: undefined,
        startdate: null,
        enddate: null,
        day: undefined,
        reason: undefined,
        remarks: '',
        rowid: undefined,
        IDnumber: '',
      },
      rules4: {
        name: [{
          required: true,
          message: '请选择姓名',
          trigger: 'change'
        }],
        phone: [{
          required: true,
          message: '请输入手机号',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|6|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        department: [{
          required: true,
          message: '请输入部门',
          trigger: 'blur'
        }],
        jobNumber: [{
          required: true,
          message: '请输入工号',
          trigger: 'blur'
        }],
        startdate: [{
          required: true,
          message: '请选择起始日期',
          trigger: 'change'
        }],
        enddate: [{
          required: true,
          message: '请选择结束日期',
          trigger: 'change'
        }],
        day: [{
          required: true,
          message: '请输入共多少天',
          trigger: 'blur'
        }],
        reason: [{
          required: true,
          message: '请输入原因说明',
          trigger: 'blur'
        }],
        remarks: [],
      },
      nameOptions4: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      backgroundColor1: "red",
      backgroundColor2: "white",
      backgroundColor3: "blue",
      fontColor1: "white",
      selection: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询房间信息列表 */
    getList() {
      this.loading = true;
      listRoominfor(this.queryParams).then(response => {
        //console.log(JSON.stringify(response));
        this.roominforList = response.rows;
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
        areaName: null,
        floorNumber: null,
        floorName: null,
        floorLocation: null,
        dormFloor: null,
        roomNumber: null,
        roomPrefix: null,
        roomSex: null,
        livenumber: null,
        peoplenumber: null,
        remainnumber: null,
        roomType: null,
        roomStatus: 0,
        cabinetNumber: null,
        roomProperty: null,
        roomPeople: null,
        roomCard: null,
        temporary: null,
        cavenumber: null,
        cost: null,
        costman: null
      };
      this.resetForm("form");
    },
    resetrz() {
      this.form = {
        name: undefined,
        IDnumber: undefined,
        sex: undefined,
        phone: undefined,
        area: undefined,
        floor: undefined,
        room: undefined,
        bf: undefined,
      };
      this.resetForm("form");
    },
    resetdh() {
      this.formdata2 = [];
      this.resetForm("formdata2");
    },
    resetts() {
      this.formdata3 = [];
      this.resetForm("formdata3");
    },
    resetqjcc() {
      this.formData4 = [];
      this.resetForm("formdata4");
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
      this.selection.push(selection[0])
      this.ids = this.selection.map(item => item.id)
      this.single = this.selection.length !== 1
      this.multiple = !this.selection.length
    },

    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加房间信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      this.rowid = row.id;
      getRoominfor(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改房间信息";
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
        roomSex: null,
        roomType: null
      };
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.title === "批量修改房间信息") {
            // 批量修改
            const updateData = {
              ids: this.ids,
              roomSex: this.form.roomSex,
              roomType: this.form.roomType
            };
            batchUpdateRoominfor(updateData).then(response => {
              this.$modal.msgSuccess("批量修改成功");
              this.open = false;
              this.getList();
            });
          } else if (this.form.id != null) {
            // 单个修改
            updateRoominfor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            // 新增
            addRoominfor(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除房间信息编号为"' + ids + '"的数据项？').then(function () {
        return delRoominfor(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dorm/roominfor/export', {
        ...this.queryParams
      }, `roominfor_${new Date().getTime()}.xlsx`)
    },

    onCloserz() {
      this.$refs['elForm'].resetFields()
    },
    close() {
      this.$emit('update:visible', false)
      this.isVisible = false;
      this.resetrz();
    },
    onOpenrz(row) {
      this.isVisible = true;
      this.resetrz();
      const id = row.id || this.ids;
      this.rowid = row.id;
      this.rowobj = row;
      this.formData.areaName = row.areaName;
      this.formData.floorName = row.floorName;
      this.formData.roomNumber = row.roomNumber;
      this.getonlivepeople();
      this.getkongbedinfo();
    },
    onOpendh(row) {
      this.isVisible2 = true;
      this.resetdh();
      const id = row.id || this.ids;
      this.rowid = row.id;
      this.rowobj = row;
      this.getlivepeople();
      this.getfloorName();
      this.getfloor();
      this.getroomNumber();
      this.getkongbedinfo2();
    },
    onOpents(row) {
      this.isVisible3 = true;
      this.resetts();
      const id = row.id || this.ids;
      this.rowid = row.id;
      this.rowobj = row;
      this.formData3.roomNumber = row.roomNumber;
      this.formData3.articleDescriptionOptions = [];
      this.formData3.articleDescription = [];
      getlivingpeople(row).then(response => {
        //console.log(JSON.stringify(response));
        this.nameOptions2 = [{ label: "", value: "" }];
        for (var i = 0; i < response.length; i++) {
          this.nameOptions2.push({
            label: response[i].name,
            value: response[i].idNumber
          });
        }
      })
    },
    onOpenqjcc(row) {
      this.isVisible4 = true;
      //this.resetqjcc();
      const id = row.id || this.ids;
      this.rowid = row.id;
      this.rowobj = row;
      //console.log(JSON.stringify(row));
      this.formData4.areaName = row.areaName;
      this.formData4.dormFloor = row.dormFloor;
      this.formData4.floorName = row.floorName;
      this.formData4.room = row.roomNumber;
      getlivingpeople(row).then(response => {
        //console.log(JSON.stringify(response));
        this.nameOptions4 = [{ label: "", value: "" }];
        for (var i = 0; i < response.length; i++) {
          this.nameOptions4.push({
            label: response[i].name,
            value: response[i].idNumber
          });
        }
      })
    },
    getkongbedinfo() {
      this.bedOptions = [{ label: "", value: "" }];
      getkongbed(this.rowobj).then(response => {
        //console.log(JSON.stringify(response.data));
        for (var i = 0; i < response.data.length; i++) {
          this.bedOptions.push({
            label: response.data[i].bednumber,
            value: response.data[i].bednumber
          })
        }
      })
    },
    getkongbedinfo2() {
      this.bed1Options2 = [{ label: "", value: "" }];
      getkongbed(this.rowobj).then(response => {
        //console.log(JSON.stringify(response.data));
        for (var i = 0; i < response.data.length; i++) {
          this.bed1Options2.push({
            label: response.data[i].bednumber,
            value: response.data[i].bednumber
          })
        }
      })
    },
    getkongbedinfo3() {
      this.bed1Options2 = [{ label: "", value: "" }];
      this.rowobj = {
        areaNumber: this.formData2.areaNumber1,
        floorNumber: this.formData2.floorName1,
        dormFloor: this.formData2.dormFloor1,
        roomNumber: this.formData2.room1
      }
      getkongbed(this.rowobj).then(response => {
        //console.log(JSON.stringify(response.data));
        for (var i = 0; i < response.data.length; i++) {
          this.bed1Options2.push({
            label: response.data[i].bednumber,
            value: response.data[i].bednumber
          })
        }
      })
    },
    getonlivepeople() {
      this.ID = [];
      this.nameOptions = [{ label: "", value: "" }];
      listOnlivepeople(this.queryParamsrz).then(response => {
        //console.log(JSON.stringify(response));
        for (var i = 0; i < response.rows.length; i++) {
          if (response.rows[i].flag == "0") {
            this.ID.push(response.rows[i].id);
            this.nameOptions.push({
              label: response.rows[i].name,
              value: response.rows[i].id
            });
          };
        };
      });
    },
    getlivepeople() {
      this.name1Options2 = [{ label: "", value: "" }];
      this.name2Options2 = [{ label: "", value: "" }];
      getlistLivepeople().then(response => {
        //console.log(JSON.stringify(response));
        for (var i = 0; i < response.rows.length; i++) {
          this.ID.push(response.rows[i].id);
          this.name1Options2.push({
            label: response.rows[i].name,
            value: response.rows[i].id
          });
          this.name2Options2.push({
            label: response.rows[i].name,
            value: response.rows[i].id
          });
        };
      });
    },
    getonlivepeopleinfo(value) {
      //console.log(value);
      getOnlivepeople(value).then(response => {
        //console.log(JSON.stringify(response.data));
        this.formData.IDnumber = response.data.idnumber;
        this.formData.sex = response.data.sex;
        this.formData.phone = response.data.phone;
      })
    },
    getlivepeopleinfo(value) {
      //console.log(value);
      this.formData2.currentMonthLiveDays = undefined;
      getLivepeople(value).then(response => {
        //console.log(JSON.stringify(response.data));
        this.formData2.name1 = response.data.name;
        this.formData2.IDnumber1 = response.data.idnumber;
        this.formData2.dormFloor1 = response.data.dormFloor;
        this.formData2.floorName1 = response.data.floorNumber;
        this.formData2.room1 = response.data.roomNumber;
        this.formData2.bed1 = response.data.bednumber;
        this.formData2.areaNumber1 = response.data.areaNumber;
        var ruzhudate = response.data.livedate;
        var now = (new Date()).getDate();
        var month = (new Date()).toISOString().substring(0, 7);
        //如果是当月，取相减天数
        if ((new Date(ruzhudate)).toISOString().substring(0, 7) == month) {
          this.formData2.currentMonthLiveDays = now - (new Date(ruzhudate)).getDate();
        } else {
          this.formData2.currentMonthLiveDays = now;
        }

      })
    },
    getlivepeopleinfo2(value) {
      //console.log(value);
      getLivepeople(value).then(response => {
        //console.log(JSON.stringify(response.data));
        this.formData2.IDnumber2 = response.data.idnumber;
        this.formData2.dormFloor2 = response.data.dormFloor;
        this.formData2.floorName2 = response.data.floorNumber;
        this.formData2.room2 = response.data.roomNumber;
        this.formData2.bed2 = response.data.bednumber;
      })
    },
    getlivepeopleinfo3(value) {
      //console.log(value);
      this.formData3.currentMonthLiveDays = undefined;
      getLivepeople2(value).then(response => {
        //console.log(JSON.stringify(response));
        this.formData3.name = response.data.name;
        this.formData3.IDnumber = response.data.idnumber;
        this.formData3.sex = response.data.sex == 1 ? "1" : "0";
        this.formData3.phone = response.data.phone;
        this.formData3.bedNumber = response.data.bednumber;
        var ruzhudate = response.data.livedate;
        var now = (new Date()).getDate();
        var month = (new Date()).toISOString().substring(0, 7);
        //如果是当月，取相减天数
        if ((new Date(ruzhudate)).toISOString().substring(0, 7) == month) {
          this.formData3.currentMonthLiveDays = now - (new Date(ruzhudate)).getDate();
        } else {
          this.formData3.currentMonthLiveDays = now;
        }
        this.getArticleDescription(value);
      })
    },
    getlivepeopleinfo4(value) {
      //console.log(value);
      getLivepeople2(value).then(response => {
        console.log(JSON.stringify(response));
        this.formData4.name = response.data.name;
        this.formData4.phone = response.data.phone;
        this.formData4.department = response.data.department3;
        this.formData4.jobNumber = response.data.jobnumber;
        this.formData4.IDnumber = response.data.idnumber;

      })
    },
    getArticleDescription(value) {
      // getarticleDescription(value).then(response => {
      //   //console.log(JSON.stringify(response.data));
      //   var articleDescription = "";
      //   for(var i=0; i<response.data.length; i++){
      //     articleDescription = articleDescription + "申请物品：" + response.data[i].articleDescription + ":"+response.data[i].requstQuantity +"个"
      //     + " 退还物品：" + response.data[i].returnDescription + ":" + response.data[i].returnQuantity + "个";
      //   }
      //   if(response.data.length==0){
      //     articleDescription = "无";
      //   }
      //   //console.log("物品详情："+articleDescription);
      //   this.formData3.articleDescription = articleDescription;
      // })
      getarticleDescription(value).then(response => {
        this.formData3.articleDescription = [];
        this.formData3.articleDescriptionOptions = [];
        for (var i = 0; i < response.data.length; i++) {
          //this.formData3.articleDescription.push(response.data[i].returnDescription + ":" + (response.data[i].requstQuantity-response.data[i].returnQuantity) + "个");
          this.formData3.articleDescriptionOptions.push({
            label: "ID:" + response.data[i].id + ":" + response.data[i].returnDescription + ":" + (response.data[i].requstQuantity - response.data[i].returnQuantity) + "个",
            disabled: false,
            value: response.data[i].id
          })
        }
      })
    },
    handleConfirm() { //入住
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        var data = {
          name: this.formData.name,
          IDnumber: this.formData.IDnumber,
          sex: this.formData.sex,
          phone: this.formData.phone,
          rowid: this.rowid,
          bednumber: this.formData.bed,
          wardrobe: this.formData.wardrobe,
          keynumber: this.formData.keynumber,
        };
        ruzhuConfirm(data).then(response => {
          console.log(JSON.stringify(response));
          alert(response.msg);
          this.isVisible = false;
          this.getList();
        })
        this.close()
      })
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "房间导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('dorm/roominfor/importTemplate', {
      }, `房间信息_模板_${new Date().getTime()}.xlsx`)
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
    onClose2() {
      this.$refs['elForm2'].resetFields()
    },
    close2() {
      this.$emit('update:visible', false)
      this.isVisible2 = false;
    },
    handleConfirm2() { //调换
      this.$refs['elForm2'].validate(valid => {
        if (!valid) return
        var data = this.formData2;
        //console.log(JSON.stringify(data));
        diaohuanConfirm(data).then(response => {
          //console.log(JSON.stringify(response));
          alert(response.msg);
          this.isVisible2 = false;
          this.getList();
        })
        this.close()
      })
    },
    getfloorName() {
      getFloorName().then(response => {
        //console.log(JSON.stringify(response));
        this.floorName1Options2 = [{ label: "", value: "" }];
        for (var i = 0; i < response.length; i++) {
          this.floorName1Options2.push({
            label: response[i].floor_name,
            value: response[i].floor_number
          });
        }
      })
    },
    getfloor() {
      getFloor().then(response => {
        //console.log(JSON.stringify(response));
        this.dormFloor1Options2 = [{ label: "", value: null }];
        for (var i = 0; i < response.length; i++) {
          this.dormFloor1Options2.push({
            label: response[i].toString(),
            value: response[i]
          });
        }
      })
    },
    getroomNumber() {
      getRoomNumber().then(response => {
        //console.log(JSON.stringify(response));
        this.room1Options2 = [{ label: "", value: "" }];
        for (var i = 0; i < response.length; i++) {
          this.room1Options2.push({
            label: response[i],
            value: response[i]
          });
        }
      })
    },
    onClose3() {
      this.$refs['elForm3'].resetFields()
    },
    close3() {
      this.$emit('update:visible', false);
      this.isVisible3 = false;
    },
    handleConfirm3() { //退宿
      this.$refs['elForm3'].validate(valid => {
        if (!valid) return
        var data = this.formData3;
        data.rowid = this.rowid;
        //console.log(JSON.stringify(data));
        tuisuConfirm(data).then(response => {
          //console.log(JSON.stringify(response));
          alert(response.msg);
          this.isVisible3 = false;
          this.getList();
        })
        this.close()
      })
    },
    onClose4() {
      this.$refs['elForm4'].resetFields()
    },
    close4() {
      this.$emit('update:visible', false);
      this.isVisible4 = false;
    },
    handleConfirm4() { //请假出差
      this.$refs['elForm4'].validate(valid => {
        if (!valid)
        var data = this.formData4;
        data.rowid = this.rowid;
        console.log(JSON.stringify(data));
        qingjiachuchaiConfirm(data).then(response => {
          console.log(JSON.stringify(response));
          alert(response.msg);
          this.isVisible4 = false;
          this.getList();
        })
        this.close()
      })
    },
    setday(value) {

    },
    getday(value) {
      var time1 = Date.parse(this.formData4.startdate);
      var time2 = Date.parse(value);
      var time3 = (time2 - time1) / (1000 * 60 * 60 * 24) + 1;
      if (time3 > 0) {
        this.formData4.day = time3.toString();
      } else {
        alert("结束时间应大于开始时间！");
      }

    },
  }
};
</script>
<style>
.el-card__header {
  padding: 0px;
}

.noremain {
  background-color: red;
  color: white;
  line-height: 40px;
}

.empty {
  background-color: white;
  color: black;
  line-height: 40px;
}

.normal {
  background-color: blue;
  color: white;
  line-height: 40px;
}

.word {
  vertical-align: middle;
}

.el-checkbox__inner {
  left: 50px;
}


.app-container {
  height: 100%;
  display: flex;
  flex-direction: column;
  position: relative;
  padding-bottom: 50px;
}

.table-container {
  flex: 1;
  overflow: auto;
  position: relative;
}

.el-table {
  width: 100% !important;
}

.el-table__body-wrapper {
  overflow-x: auto !important;
}

.fixed-bottom {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: #fff;
  padding: 0 17px 17px 0;
  box-shadow: 0 -2px 8px rgba(0, 0, 0, 0.1);
  z-index: 1000;
}

</style>
