<template>
  <div class="app-container home">
    <el-carousel :interval="4000" type="card" height="400px">
      <el-carousel-item v-for="item in imgList" :key="item.id">
        <h3 class="medium">
          <img :src="item.idView" height="400px" width="100%"/>
        </h3>
      </el-carousel-item>
    </el-carousel>

    <div class="nav" id="container">
      <!--<div class="box">
        <div class="box-img">
          <img src="../assets/images/area-1.png" />
        </div>
      </div>
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/bed-1.png" />
        </div>
      </div>
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/dor-1.png" />
        </div>
      </div>
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/floors-1.png" />
        </div>
      </div>
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/goods-1.png" />
        </div>
      </div>
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/in-1.png" />
        </div>
      </div>
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/init-1.png" />
        </div>
      </div>-->
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/list-1.png" @click="goto('/dormatory/dorm/roominfor')"/>
        </div>
      </div>
      <div class="box">
        <div class="box-img">
          <img src="../assets/images/record-1.png" @click="goto('/dormatory/report/main1')"/>
        </div>
      </div>
      <!--身份证阅读器-->
      <!--<div class="box">
        <div class="box-img">
          <img src="../assets/images/47241-true222.jpg" @click="goto('/dormatory/dorm/usercert/test')"/>
        </div>
      </div>-->
    </div>

    <!--<img src="../assets/images/宿舍.png" width="1750" height="900" />-->
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.1",
      imgList: [
        {id:0,idView:require('../assets/images/宿舍.png')},
        {id:1,idView:require('../assets/images/宿舍2.jpeg')},
        {id:2,idView:require('../assets/images/宿舍3.jpeg')},
        {id:3,idView:require('../assets/images/宿舍4.jpg')}
      ]
    };
  },
  created() {
    var oParent=document.getElementById("container");
    const CheckLoading=(child)=>{
      const aContent=getChilds(child);
      const lastTop=aContent[aContent.length-1].offsetTop;
      const scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
      const pageHeight=document.documentElement.clientHeight||document.body.clientHeight;

      if(scrollTop+pageHeight>lastTop){
        return true;
      }
    }
    const imgLocation=(child)=>{
      //ES6
      //将父级下所有符合条件的子元素全部取出
      const aContent=getChilds(child);//获取子元素数组
      const imgWidth=aContent[0].offsetWidth;//获取图片外边框宽度
      const imgnum=~~(document.documentElement.clientWidth/imgWidth);//~~位运算，获取一行图片数量
      oParent.style.cssText='width:'+imgWidth*imgnum+'px;margin:0 auto;';
      //计算图片的高度
      const heightArr=[];
      [].map.call(aContent,(current,index)=>{
        if(index<5){//超出第一行的图片
          heightArr.push(current.offsetHeight);/*将图片高度存入数组*/
        }
        else{
          //得到图片的最小高度
          //es6方法：
          //const minHeight=Math.min(...heightArr);
          const minHeight=getMin(heightArr);
          //得到最小高度图片的序列号
          const minIndex=getMinIndex(minHeight,heightArr);
          //reduce方法取最小值
          /*var arr=[2,1,3,0];
          var min=arr.reduce((a,b,index,arr)=>{undefined
              if(a.val>=b){undefined
                  a.val=b;
                  a.index=index;
              }
              return a;
          },{val:arr[0],index:0},)
          console.log(min);*/
          //布局图片
          current.style.position='absolute';
          current.style.top=minHeight+'px';
          current.style.left=aContent[minIndex].offsetLeft+'px';
          heightArr[minIndex]=heightArr[minIndex]+current.offsetHeight;//更新最小的高度
        }
      });
      console.log(heightArr);

    }
    //将父级下所有符合条件的子元素全部取出
    const getChilds=(child)=>{
      const childArr=[];
      const tagsAll= oParent;

      [].map.call(tagsAll,(current)=>{
        if(current.className===child){
          childArr.push(current);
        }
      });
      return childArr;
    }
    window.addEventListener('load',()=>{
      imgLocation('box');
      const imgData=[{'src':'../assets/images/area-1.png'},{'src':'../assets/images/bed-1.png'},{'src':'../assets/images/dor-1.png'},{'src':'../assets/images/floors-1.png'},{'src':'../assets/images/goods-1.png'},{'src':'../assets/images/in-1.png'},{'src':'../assets/images/init-1.png'},{'src':'../assets/images/list-1.png'},{'src':'../assets/images/out-1.png'},{'src':'../assets/images/record-1.png'}];
      this.addEventListener('scroll',()=>{/*滚动条滚动事件*/
        if(CheckLoading('box')){
          //console.log("加载页面....");
          imgData.map((current)=>{
            const oDiv=document.createElement('div');
            oDiv.className='box';
            oParent.appendChild(oDiv);
            const boxImg=document.createElement('div');
            boxImg.className='box-img';
            oDiv.appendChild(boxImg);
            const img=new Image();
            img.src='images/'+current.src;
            boxImg.appendChild(img);
          })
          imgLocation('box');
        };
      })

    });

    //得到图片的最小高度
    const getMin=(arr)=>{
      const arrlength=arr.length;
      for(var i=0,ret=arr[0];i<arrlength;i++){
        ret=Math.min(ret,arr[i]);/*比较并返回最小值*/
      }
      return ret;
    };
    //得到最小高度图片的序列号
    const getMinIndex=(minHeight,heightArr)=>{
      for(var i in heightArr){
        if(heightArr[i]==minHeight){
          return i;
        }
      }
    }
    /*
    瀑布流的实现思路
       1.布局：
           1.1 实现图片的列数和浏览器挂钩
           1.2 让图片居中

       2.根据每一列最小的高度来计算的
           （哪一列你的高度最小，把后面要加载的数据放在最小那一列高度的下面）
           2.1 计算图片的最小高度
                前5个元素是不需要做最高计算（一行5张图片的情况）

       3.判断滚动条滚动到底部怎么加载
           滚动高度+页面高度>加载最后一张图片距离浏览器顶部的高度
    */
  },
  methods: {
    goto: function(url){
      router.push({path:url});
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
  /*走马灯卡片式*/
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  *{
  margin:0;
    padding:0;
  }
  .nav{
    /*display:flex;弹性盒模型*/
  }
  .box{
  float:left;
  }
  .box-img{
  width:200px;
  }
  .box-img img{
  width:200px;
  }
}
</style>

