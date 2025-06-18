<template>
  <div>
    <el-button type="success" @click="readIDCard">自动读取身份证</el-button>
    <el-dialog title="读取身份证信息" :visible.sync="showDialog" width="500px" append-to-body :before-close="closeDialog">
      <el-form :model="IDCardForm" ref="IDCardForm" :rules="rules" label-width="150px">
        <el-form-item label="姓名:" prop="name">
          <el-input v-model="IDCardForm.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item label="证件号码:" prop="idCardNumber">
          <el-input v-model="IDCardForm.idCardNumber" placeholder="请输入证件号码"></el-input>
        </el-form-item>
        <el-form-item label="性别:" prop="sex">
          <el-input v-model="IDCardForm.sex" placeholder="请输入性别"></el-input>
        </el-form-item>
        <el-form-item label="身份证照片：" prop="sfzImage">
          <img v-if="IDCardForm.sfzImage==null" src="../../../../src/assets/images/personnel.jpg" height="100px" width="100px" />
          <img v-else :src="IDCardForm.sfzImage" height="100px" width="100px" />
        </el-form-item>
        <el-form-item label="民族:" prop="nation">
          <el-input v-model="IDCardForm.nation" placeholder="请输入民族"></el-input>
        </el-form-item>
        <el-form-item label="出生日期:" prop="birthday">
          <el-input v-model="IDCardForm.birthday" placeholder="请输入出生日期"></el-input>
        </el-form-item>
        <el-form-item label="身份证有效起日期:" prop="sfzyxqrq">
          <el-input v-model="IDCardForm.sfzyxqrq" placeholder="请输入身份证有效起日期"></el-input>
        </el-form-item>
        <el-form-item label="身份证有效起日期:" prop="sfzyxzrq">
          <el-input v-model="IDCardForm.sfzyxzrq" placeholder="请输入身份证有效起日期"></el-input>
        </el-form-item>
        <!--检测是否装有插件-->
        <object id="CertCtl" classid="clsid:A66F5373-0A8A-4C42-814B-38A87B331D40" ref="CertCtl" type="application/cert-reader" width="0" height="0">
          <p style="color:#FF0000;">控件未安装或不可用，请检查安装后在使用！</p>
        </object>
      </el-form>
      <el-row :gutter="20" class="mb8">
        <el-col :span="8">
          <el-button type="success" icon="el-icon-plus" size="mini" @click="connect">连接</el-button>
        </el-col>
        <!-- <el-col :span="8">
          <el-button type="warning" icon="el-icon-download" size="mini" @click="readCert">读卡</el-button>
        </el-col> -->
        <el-col :span="8">
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="disconnect()">断开</el-button>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancelForm">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 对话框的显隐
      showDialog: false,
      CertCtl: '',
      // 查询参数
      IDCardForm: {
        name: "", // 姓名
        idCardNumber: "", // 身份证号码
        sex: "", // 性别
        nation: "", // 民族
        birthday: "", // 出生日期
        sfzyxqrq: "", //身份证有效起日期
        sfzyxzrq: "", // 身份证有效止日期
        sfzImage: null // 身份证照片
      },
      // 表单参数
      // IDCardForm: {},
      rules: {},
      timer: ""
    }
  },
  methods: {
    // 重置表单
    reset() {
      this.IDCardForm = {
        name: "", // 姓名
        idCardNumber: "", // 身份证号码
        sex: "", // 性别
        nation: "", // 民族
        birthday: "", // 出生日期
        sfzyxqrq: "", //身份证有效起日期
        sfzyxzrq: "", // 身份证有效止日期
        sfzImage: null // 身份证照片
      }
      // this.resetForm("IDCardForm")
    },
    // 读取身份证按钮
    readIDCard() {
      this.showDialog = true
    },
    // 对话框的右上角那个叉叉
    closeDialog() {
      this.showDialog = false;
      clearInterval(this.timer)
    },
    // 对话框的确定按钮
    submitForm() {
      this.showDialog = false
    },
    // 对话框的取消按钮
    cancelForm() {
      this.showDialog = false;
      // 清除定时器
      clearInterval(this.timer);
    },
    // 连接读卡器
    connect() {
      this.reset();
      try {
        const result = CertCtl.connect();
        let resultObj = JSON.parse(result);
        this.IDCardForm.sfzImage = null
        // 判断状态是否连接成功
        if (resultObj.resultFlag == "0") {
          this.$message.warning("连接成功")
        }
      } catch (e) {

      }
      // 设置定时器 每三秒调用一次方法，就是每三秒读卡读取一次
      this.timer = setInterval(this.readCertAuto, 3000);
    },
    // 读卡
    readCertAuto() {
      this.reset()
      const result = CertCtl.readCert();
      let resultObj = JSON.parse(result);
      console.log("2222", resultObj);
      this.IDCardForm.name = resultObj.resultContent.partyName;
      this.IDCardForm.idCardNumber = resultObj.resultContent.certNumber;
      this.IDCardForm.sex = resultObj.resultContent.gender;
      this.IDCardForm.nation = resultObj.resultContent.nation;
      this.IDCardForm.birthday = resultObj.resultContent.bornDay;
      this.IDCardForm.sfzyxqrq = resultObj.resultContent.effDate;
      this.IDCardForm.sfzyxzrq = resultObj.resultContent.expDate;
      this.IDCardForm.sfzImage = "data:image/jpeg;base64," + resultObj.resultContent.identityPic;
    },
    // 断开连接
    disconnect() {
      // this.reset();
      try {
        const result = CertCtl.disconnect();
        let resultObj = JSON.parse(result);
        this.IDCardForm.sfzImage = null;
        if (resultObj.resultFlag == "1") {
          this.$message.warning("连接已断开")
        }
        clearInterval(this.timer);
      } catch (e) {}
    }
  },
  destroyed() {
    clearInterval(this.timer)
  }
}
</script>

<style>
</style>


