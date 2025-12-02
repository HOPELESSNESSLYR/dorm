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
      <el-form-item label="工号" prop="jobnumber">
        <el-input
          v-model="queryParams.jobnumber"
          placeholder="请输入宿舍楼层号"
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
      <el-form-item label="宿舍房间号" prop="roomNumber">
        <el-input
          v-model="queryParams.roomNumber"
          placeholder="请输入宿舍房间号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
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
      <el-form-item label="锁定" prop="lockk">
        <el-input
          v-model="queryParams.lockk"
          placeholder="请输入锁定"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="入住天数" prop="days">
        <el-input
          v-model="queryParams.days"
          placeholder="请输入入住天数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入住/退宿" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择入住/退宿" clearable>
          <el-option
            v-for="dict in dict.type.in_out"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="个人热水费" prop="hotwaterFee">
        <el-input
          v-model="queryParams.hotwaterFee"
          placeholder="请输入个人热水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人冷水费" prop="coolwaterFee">
        <el-input
          v-model="queryParams.coolwaterFee"
          placeholder="请输入个人冷水费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人电费" prop="electricityFee">
        <el-input
          v-model="queryParams.electricityFee"
          placeholder="请输入个人电费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公共电费" prop="publicElectricity">
        <el-input
          v-model="queryParams.publicElectricity"
          placeholder="请输入公共电费"
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
      <el-form-item label="公共冷水费" prop="publicCoolwater">
        <el-input
          v-model="queryParams.publicCoolwater"
          placeholder="请输入公共冷水费"
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
          v-hasPermi="['fee:person:add']"
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
          v-hasPermi="['fee:person:edit']"
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
          v-hasPermi="['fee:person:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
        type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['fee:person:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fee:person:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          size="mini"
          :disabled="multiple"
          @click="handleLock"
        >锁定</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="personList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="锁定" align="center" prop="lockk" />
      <el-table-column label="个人费用ID" align="center" prop="feepersonId" />
      <el-table-column label="年份" align="center" prop="nian" />
      <el-table-column label="月份" align="center" prop="yue" />
      <el-table-column label="区域编号" align="center" prop="areaNumber" />
      <el-table-column label="宿舍楼编号" align="center" prop="floorNumber" />
      <el-table-column label="宿舍楼层号" align="center" prop="dormFloor" />
      <el-table-column label="宿舍房间号" align="center" prop="roomNumber" />
      <el-table-column label="工号" align="center" prop="jobnumber" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="入住天数" align="center" prop="days" />
      <el-table-column label="入住/退宿" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.in_out" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="个人热水费" align="center" prop="hotwaterFee" />
      <el-table-column label="个人冷水费" align="center" prop="coolwaterFee" />
      <el-table-column label="个人电费" align="center" prop="electricityFee" />
      <el-table-column label="公共电费" align="center" prop="publicElectricity" />
      <el-table-column label="公共热水费" align="center" prop="publicHotwater" />
      <el-table-column label="公共冷水费" align="center" prop="publicCoolwater" />
      <el-table-column label="合计" align="center" prop="feetotal" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fee:person:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fee:person:remove']"
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

    <!-- 添加或修改个人费用对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="锁定" prop="lockk">
          <el-input v-model="form.lockk" placeholder="请输入锁定" />
        </el-form-item>
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
        <el-form-item label="宿舍楼层号" prop="dormFloor">
          <el-input v-model="form.dormFloor" placeholder="请输入宿舍楼层号" />
        </el-form-item>
        <el-form-item label="宿舍房间号" prop="roomNumber">
          <el-input v-model="form.roomNumber" placeholder="请输入宿舍房间号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="入住天数" prop="days">
          <el-input v-model="form.days" placeholder="请输入入住天数" />
        </el-form-item>
        <el-form-item label="入住/退宿" prop="status">
          <el-select v-model="form.status" placeholder="请选择入住/退宿">
            <el-option
              v-for="dict in dict.type.in_out"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="个人热水费" prop="hotwaterFee">
          <el-input v-model="form.hotwaterFee" placeholder="请输入个人热水费" />
        </el-form-item>
        <el-form-item label="个人冷水费" prop="coolwaterFee">
          <el-input v-model="form.coolwaterFee" placeholder="请输入个人冷水费" />
        </el-form-item>
        <el-form-item label="个人电费" prop="electricityFee">
          <el-input v-model="form.electricityFee" placeholder="请输入个人电费" />
        </el-form-item>
        <el-form-item label="公共电费" prop="publicElectricity">
          <el-input v-model="form.publicElectricity" placeholder="请输入公共电费" />
        </el-form-item>
        <el-form-item label="公共热水费" prop="publicHotwater">
          <el-input v-model="form.publicHotwater" placeholder="请输入公共热水费" />
        </el-form-item>
        <el-form-item label="公共冷水费" prop="publicCoolwater">
          <el-input v-model="form.publicCoolwater" placeholder="请输入公共冷水费" />
        </el-form-item>
        <el-form-item label="合计" prop="feetotal">
          <el-input v-model="form.feetotal" placeholder="请输入合计" />
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
import { listPerson, getPerson, delPerson, addPerson, updatePerson ,lockPerson} from "@/api/fee/person";
import { getToken } from "@/utils/auth";
import { listRoom } from "@/api/fee/room";
import { listLivepeople } from "@/api/livepeople/livepeople";
import { listRoominfor} from "@/api/dorm/roominfor";
import { listFloor } from "@/api/fee/floor";

export default {
  name: "Person",
  dicts: ['in_out'],
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
      // 个人费用表格数据
      personList: [],
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
        url: process.env.VUE_APP_BASE_API + "/fee/person/importData"
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
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        name: null,
        days: null,
        status: null,
        hotwaterFee: null,
        coolwaterFee: null,
        electricityFee: null,
        publicElectricity: null,
        publicHotwater: null,
        publicCoolwater: null,
        feetotal: null,
        jobnumber:null,
        lockk: null
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
      },
      retreatdate:'',
      nianyue:'',
      outnianyue:'',
      tuisu:null
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询个人费用列表 */
    getList() {
      this.loading = true;
      listPerson(this.queryParams).then(async response1 => {
        // 入住天数更新
        const personList = response1.rows;
        for(let person of personList){
        if(person.lockk!="1"){
          // 查询人员入住、退宿日期
          const livepeopleQuery = {
            jobNumber: person.jobNumber,
            areaNumber: person.areaNumber,
            floorNumber: person.floorNumber,
            dormFloor: person.dormFloor,
            roomNumber: person.roomNumber,
            name: person.name
          };
          const livepeopleRes = await listLivepeople(livepeopleQuery);
          const livepeoples = livepeopleRes.rows || [];
          livepeoples.forEach(livepeople => {
            this.tuisu = null
            const indate = livepeople.livedate.split("-") // 入住日期
            if(livepeople.retreatdate == null || livepeople.retreatdate == " "){
            // if(livepeople.quitcheck != "X"){
            // if(livepeople.retreatdate == null ){
              this.retreatdate = "空"
            }else{
              this.retreatdate = "非空"
            }
            if(livepeople.quitcheck === "X"){
              this.tuisu = "退宿"
            }
            // console.log(livepeople.livedate)
            // console.log(livepeople.retreatdate)
            // console.log(livepeople.quitcheck === "X",livepeople.quitcheck == "X",this.tuisu == "退宿",this.tuisu === "退宿")

            if( (this.tuisu != "退宿"||this.tuisu == "退宿") &&
            this.retreatdate == "空" && person.nian == Number(indate[0]) && person.yue == Number(indate[1])  ){// 入住日期在当月，退宿日期不在当月或为空
              person.days = new Date(person.nian, person.yue, 0).getDate() - indate[2]; 
              // console.log("1")
            }else if (this.tuisu != "退宿" &&
            this.retreatdate == "非空" && person.nian == Number(indate[0]) && person.yue == Number(indate[1])  && (person.nian != Number(livepeople.retreatdate.split("-")[0]) || person.yue != Number(livepeople.retreatdate.split("-")[1])) ){
              person.days = new Date(person.nian, person.yue, 0).getDate() - indate[2]; 
              // console.log("1"+person.days)
            } 
            else if(this.tuisu == "退宿" && 
            this.retreatdate == "非空" && 
            person.nian == Number(indate[0]) && 
            person.yue == Number(indate[1])  && 
            person.nian == Number(livepeople.retreatdate.split("-")[0]) && 
            person.yue == Number(livepeople.retreatdate.split("-")[1]) && 
            indate[2] <= livepeople.retreatdate.split("-")[2]){    // 入住日期为当月，退宿日期在当月;入住日期在退宿日期前
              person.days = livepeople.retreatdate.split("-")[2] - indate[2]; 
              // console.log("2"+person.days)
            }else if(this.tuisu != "退宿" &&
            this.retreatdate == "非空" && person.nian == Number(indate[0]) && 
            person.yue == Number(indate[1])  && 
            person.nian == Number(livepeople.retreatdate.split("-")[0]) && 
            person.yue == Number(livepeople.retreatdate.split("-")[1]) && 
            indate[2] >= livepeople.retreatdate.split("-")[2]){    // 入住日期为当月，退宿日期在当月;入住日期在退宿日期后
              person.days = new Date(person.nian, person.yue, 0).getDate() - livepeople.retreatdate.split("-")[2] + indate[2]; 
              // console.log("3"+person.days)
            }
            else if( (this.tuisu == "退宿" &&
            this.retreatdate == "非空" && 
            (person.nian != Number(indate[0])|| person.yue != Number(indate[1]) ) && 
            (person.nian != Number(livepeople.retreatdate.split("-")[0]) || person.yue != Number(livepeople.retreatdate.split("-")[1]))&& 
            (livepeople.livedate == livepeople.retreatdate)) ||
            
            ( this.tuisu == "退宿" && this.retreatdate == "非空" && 
            (person.nian != Number(indate[0])|| person.yue != Number(indate[1]) ) && 
            (person.nian != Number(livepeople.retreatdate.split("-")[0]) || person.yue != Number(livepeople.retreatdate.split("-")[1]))&& 
            (livepeople.livedate < livepeople.retreatdate) &&
            (Number(livepeople.retreatdate.split("-")[0]) < person.nian || 
              (Number(livepeople.retreatdate.split("-")[0]) === person.nian && 
              Number(livepeople.retreatdate.split("-")[1]) < person.yue))  ) 
            ){ 
              person.days = 0; 
              // console.log("0"+person.days)
            }
            // else if(this.tuisu != "退宿" &&
            // this.retreatdate == "空" && 
            // (person.nian != Number(indate[0])|| person.yue != Number(indate[1]) ) ){ //入住日期不在当月，退宿日期不在当月或为空
            //   person.days = new Date(person.nian, person.yue, 0).getDate(); //自然天数
            //   console.log("4"+"-1-"+person.days)
            // }else if(this.tuisu != "退宿" &&
            // this.retreatdate == "非空" && (person.nian != Number(indate[0])|| person.yue != Number(indate[1]) )  && (person.nian != Number(livepeople.retreatdate.split("-")[0]) || person.yue != Number(livepeople.retreatdate.split("-")[1])) &&  (livepeople.livedate > livepeople.retreatdate || livepeople.livedate == livepeople.retreatdate)){ //入住日期不在当月，退宿日期不在当月或为空
            //   person.days = new Date(person.nian, person.yue, 0).getDate(); //自然天数
            //   console.log("4"+person.days)
            // }
            else if(
            this.retreatdate == "非空" && (person.nian != Number(indate[0])|| person.yue != Number(indate[1]) )  && (person.nian == Number(livepeople.retreatdate.split("-")[0]) && person.yue == Number(livepeople.retreatdate.split("-")[1])) ){     // 入住日期不在当月，退宿日期在当月
              person.days = livepeople.retreatdate.split("-")[2];
              // console.log("5"+person.days)
            }else{
              person.days = new Date(person.nian, person.yue, 0).getDate(); //自然天数
              // console.log("自然 "+person.days)
            }
          });

          // 查询宿舍人的总天数 
          const personsDaysQuery = {
            nian: person.nian,
            yue: person.yue,
            areaNumber: person.areaNumber,
            personNumber: person.floorNumber,
            dormFloor: person.dormFloor,
            roomNumber: person.roomNumber
          };
          const personsDaysRes = await listPerson(personsDaysQuery);
          const dayss = personsDaysRes.rows || [];
          let personsdays = 0;
          dayss.forEach(day => {
            personsdays += day.days || 0;
          });
          
          // 查询楼层人的总天数 
          const floorsDaysQuery = {
            nian: person.nian,
            yue: person.yue,
            areaNumber: person.areaNumber,
            personNumber: person.floorNumber,
            dormFloor: person.dormFloor
          };
          const floorDaysRes = await listPerson(floorsDaysQuery);
          const daysss = floorDaysRes.rows || [];
          let floordays = 0;
          daysss.forEach(day => {
            floordays += day.days || 0;
          });
          // console.log("2 floordays"+floordays)


          // 计算费用 
          const roomQuery = {
            nian: person.nian,
            yue: person.yue,
            areaNumber: person.areaNumber,
            personNumber: person.floorNumber,
            dormFloor: person.dormFloor,
            roomNumber: person.roomNumber
          };
          const roomRes = await listRoom(roomQuery);
          const rooms = roomRes.rows || [];
          if(rooms == []){
            alert("错误：找不到"+person.roomNumber+person.yue+"月"+"的房间费用！")
          }
          let hotwaterFee = 0, coolwaterFee = 0, electricityFee = 0;
          rooms.forEach(room => {
              hotwaterFee = room.hotwaterFee || 0;
              coolwaterFee = room.coolwaterFee || 0;
              electricityFee = room.electricityFee || 0;
          });
          if((personsdays || person.days) == 0){
            person.hotwaterFee = 0 
            person.coolwaterFee =  0
            person.electricityFee =  0
          }else{
            person.hotwaterFee = hotwaterFee / personsdays * person.days;
            person.coolwaterFee = coolwaterFee / personsdays * person.days;
            person.electricityFee = electricityFee / personsdays * person.days;
          }
          // person.hotwaterFee =  Number.isFinite(hotwaterFee / personsdays * person.days) ? hotwaterFee / personsdays * person.days : 0 ;
          // person.coolwaterFee = Number.isFinite(coolwaterFee / personsdays * person.days) ? coolwaterFee / personsdays * person.days : 0 ;
          // person.electricityFee = Number.isFinite(electricityFee / personsdays * person.days) ? electricityFee / personsdays * person.days : 0
          // console.log("3"+person.electricityFee)


          // 计算公共费用 
          const floorQuery = {
            nian: person.nian,
            yue: person.yue,
            areaNumber: person.areaNumber,
            dormFloor: person.dormFloor,
            floorNumber: person.floorNumber
          };
          const floorRes = await listFloor(floorQuery);
          const floors = floorRes.rows || [];
          if(floors == []){
            alert("错误：找不到"+person.name+person.yue+"月"+"的楼层费用！")
          }
          let photwaterFee = 0, pcoolwaterFee = 0, pelectricityFee = 0;
          floors.forEach(floor => {
            photwaterFee = floor.floorHotwaterFee || 0;
            pcoolwaterFee = floor.floorCoolwaterFee || 0;
            pelectricityFee = floor.floorElectricityFee || 0;
          });
          person.publicHotwater = photwaterFee / floordays * person.days;
          person.publicCoolwater = pcoolwaterFee / floordays * person.days;
          person.publicElectricity = pelectricityFee / floordays * person.days;
          // console.log("4"+person.publicElectricity)

          // 合计
          if(person.publicHotwater== null && person.publicCoolwater== null && person.publicElectricity == null && person.hotwaterFee== null && person.coolwaterFee== null && person.electricityFee== null ){
            person.feetotal = 0;
          }else{
            person.feetotal = (person.publicHotwater + person.publicCoolwater + person.publicElectricity +person.hotwaterFee +person.coolwaterFee+person.electricityFee).toFixed(1)
            // Number.isFinite(person.feetotal) ? person.feetotal : 0
          }
          // console.log(""+person.publicHotwater + person.publicCoolwater + person.publicElectricity )
          // console.log("---"+person.hotwaterFee+person.coolwaterFee+person.electricityFee )

          // console.log("---"+person.feetotal)

          await updatePerson(person);
        }
        if(person.feetotal == NaN){
          alert("错误：找不到"+person.name+person.yue+"月"+"的入住信息！")
        }
        }
        // 重新获取最新数据
        listPerson(this.queryParams).then(response => {
          this.personList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      });
    },
    comFee(){

    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        feepersonId: null,
        nian: null,
        yue: null,
        areaNumber: null,
        floorNumber: null,
        dormFloor: null,
        roomNumber: null,
        jobnumber: null,
        name: null,
        days: null,
        status: null,
        hotwaterFee: null,
        coolwaterFee: null,
        electricityFee: null,
        publicElectricity: null,
        publicHotwater: null,
        publicCoolwater: null,
        feetotal: null,
        lockk: null
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
      this.ids = selection.map(item => item.feepersonId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加个人费用";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const feepersonId = row.feepersonId || this.ids
      getPerson(feepersonId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改个人费用";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.feepersonId != null) {
            updatePerson(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPerson(this.form).then(response => {
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
      const feepersonIds = row.feepersonId || this.ids;
      this.$modal.confirm('是否确认删除个人费用编号为"' + feepersonIds + '"的数据项？').then(function() {
        return delPerson(feepersonIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('fee/person/export', {
        ...this.queryParams
      }, `person_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "流动导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('fee/person/importTemplate', {
      }, `个人费用_模板_${new Date().getTime()}.xlsx`)
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
  getCurrentDateFormatted() {
    const now = new Date();
    // 使用toLocaleDateString格式化日期
    const formattedDate = now.toLocaleDateString(); // 输出格式取决于浏览器和系统设置
    // 或者手动构建格式化的日期字符串
    const year = now.getFullYear();
    const month = String(now.getMonth() + 1).padStart(2, '0'); // 月份是从0开始的
    const day = String(now.getDate()).padStart(2, '0');
    const formattedDateManual = `${year}-${month}-${day}`;
    // console.log(formattedDateManual); // 输出例如 "2023-04-01"
    return formattedDateManual;
  },
  handleLock(row) {
      // this.reset();
      const feepersonIds = row.feepersonId || this.ids
      console.log(JSON.stringify( feepersonIds)+typeof(feepersonIds))
      this.$modal.confirm('是否确认锁定个人费用编号为"' + feepersonIds + '"的数据项？').then(function() {
        return lockPerson(feepersonIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("已锁定");
      }).catch(() => {});
    },
  }
};
</script>
