<template>
  <div class="container">
    <div class="left-section">
      <div class="top-box">
        <div class="box-title">上方内容区域</div>
        <div class="box-content">
          <!-- 这是一个位于左侧上方的div盒子，包含示例文本内容。您可以在这里放置任何需要展示的信息、图片或其他媒体元素。 -->
          <br>
          一、入住与退宿
          <br>
          一、入住与退宿
          <br>
          一、入住与退宿
          <br><br>
          一、入住与退宿
          一、入住与退宿
          <br><br>
          一、入住与退宿
          一、入住与退宿<br><br>
          一、入住与退宿
          一、入住与退宿<br><br>
          一、入住与退宿
          一、入住与退宿
        </div>
      </div>
      <div class="bottom-box">
        <div class="box-title">优秀寝室展示栏</div>
        <!-- <div class="box-content">
                    这是一个位于左侧下方的div盒子，与上方盒子垂直排列。这种布局适合展示相关内容的不同部分。
                </div> -->
        <el-carousel :interval="4000" type="card" height="230px">
          <el-carousel-item v-for="item in imgList" :key="item.id">
            <h3 class="medium">
              <img :src="item.idView" height="400px" width="100%" />
            </h3>
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>

    <div class="right-section">
      <div class="right-title">流动情况</div>
      <div class="right-content">
        <div class="tu_one">
          <div class="fangkuai green">
            <span class="fk_content">新入住人数</span>
            <span class="fk_val">{{ kbList.length > 0 ? kbList[0].checkin : 0 }}人</span>
          </div>
          <div class="fangkuai blue">
            <span class="fk_content">退宿人数</span>
            <span class="fk_val">{{ kbList.length > 0 ? kbList[0].checkout : 0 }}人</span>
          </div>
          <div class="fangkuai orange">
            <span class="fk_content">调宿人数</span>
            <span class="fk_val">{{ kbList.length > 0 ? kbList[0].changed : 0 }}人</span>
          </div>
        </div>

        <div class="line" id="my_line_chart"></div>
        <div class="linetext">
          <div class="legend-item">
            <div class="color-block green"></div>
            <span>新入住</span>
          </div>
          <div class="legend-item">
            <div class="color-block blue"></div>
            <span>退宿</span>
          </div>
          <div class="legend-item">
            <div class="color-block orange"></div>
            <span>调宿</span>
          </div>
        </div>

        <div class="tu">
          <div class="rzl">
            <span>入住率：</span>
            {{ rzl }}
            <!-- {{ kbList.length > 0 ? kbList[4].changed : 0 }} -->
            <span>%</span>
          </div>
          <div class="pie" id="my_pie_chart"></div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import echarts from 'echarts'
import { listLivepeople, getLivepeople, delLivepeople, addLivepeople, printLivepeople, updateLivepeople } from "@/api/livepeople/livepeople";
import { getToken } from "@/utils/auth";
import { listKanban, getKanban, delKanban, addKanban, updateKanban } from "@/api/kanban/kanban";
import moment from 'moment'
import { listRoominfor } from "@/api/dorm/roominfor";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.1",
      imgList: [
        { id: 0, idView: require('../assets/images/宿舍.png') },
        { id: 1, idView: require('../assets/images/宿舍2.jpeg') },
        { id: 2, idView: require('../assets/images/宿舍3.jpeg') },
        { id: 3, idView: require('../assets/images/宿舍4.jpg') },
        { id: 4, idView: require('../assets/images/宿舍5.jpg') }
      ],


      // 查询参数
      query: {
        kbid: null,
        checkin: null,
        checkout: null,
        changed: null
      },
      kbList: [],


      pieChart: null, // 饼图
      pie_checkin: 0,
      pie_null: 0,
      opinion: ['已住人数', '空床位'],
      rzl: 0,
      lineChart: null, // 折线图
      line1: {
        ss: 0,
        s: 0,
        b: 0,
      },
      line2: {
        ss: 0,
        s: 0,
        b: 0,
      },
      line3: {
        ss: 0,
        s: 0,
        b: 0,
      },

      currentTime: '',
      config: {
        time: '00:00:00',
        interval: 1,
        autoStart: true
      },
      timeOutTimer: null,
      intervalTimer: null,
      dataChart: null,
      nextExecutionTime: '',
      loading: false,
      isTimerRunning: false,
    };
  },
  created() {
    this.getList();
    this.fetchData()  //测试卡片
  },
  mounted() {
    this.pieChart = echarts.init(document.getElementById("my_pie_chart"));
    this.lineChart = echarts.init(document.getElementById("my_line_chart"));
    // this.init();

    // this.startTimer()// 启动定时器
  },
  beforeDestroy() {
    this.clearTimers()
  },

  methods: {
    // 计算到次日0点的时间差
    getTimeToMidnight() {
      const now = moment()
      const tomorrow = moment().add(1, 'days').startOf('day')
      return tomorrow.diff(now)
    },

    // 启动定时器
    startTimer() {
      this.clearTimers()
      this.isTimerRunning = true
      this.setTimedTask()
    },

    // 设置定时任务
    setTimedTask() {
      const downCount = this.getTimeToMidnight()

      this.timeOutTimer = setTimeout(() => {
        this.executeTask()
        this.setIntervalTimer()
      }, 60000)

      this.nextExecutionTime = moment().add(1, 'days').startOf('day').format('YYYY-MM-DD HH:mm:ss')
    },
    // 执行定时任务
    executeTask() {
      console.log('定时任务执行: 获取后台数据')
      this.fetchData()
      this.nextExecutionTime = moment().add(1, 'days').startOf('day').format('YYYY-MM-DD HH:mm:ss')
    },
    // 设置间隔定时器
    setIntervalTimer() {
      const intervalTime = this.config.interval * 24 * 60 * 60 * 1000
      this.intervalTimer = setInterval(() => {
        this.executeTask()
      }, intervalTime)
    },
    // 获取后台数据 、更新看板表数据
    async fetchData() {
      this.loading = true
      try {
        const queryParams1 = {
          pageNum: 1,
          pageSize: 9999,
          livecheck: 'X',
          livedate: moment().subtract(1, 'days').format('YYYY-MM-DD'),
        };
        const queryParams2 = {
          pageNum: 1,
          pageSize: 9999,
          quitcheck: 'X',
          retreatdate: moment().subtract(1, 'days').format('YYYY-MM-DD'),

        };
        const queryParams3 = {
          pageNum: 1,
          pageSize: 9999,
          tuneIncheck: 'X',
          tuneIndate: moment().subtract(1, 'days').format('YYYY-MM-DD'),
        };
        const zline1 = {
          pageNum: 1,
          pageSize: 9999,
          livecheck: 'X',
          livedate: moment().format('YYYY-MM'),
        };
        const zline2 = {
          pageNum: 1,
          pageSize: 9999,
          livecheck: 'X',
          livedate: moment().subtract(1, 'months').format('YYYY-MM'),
        };
        const zline3 = {
          pageNum: 1,
          pageSize: 9999,
          livecheck: 'X',
          livedate: moment().subtract(2, 'months').format('YYYY-MM'),
        };
        const tline1 = {
          pageNum: 1,
          pageSize: 9999,
          quitcheck: 'X',
          retreatdate: moment().format('YYYY-MM'),

        };
        const tline2 = {
          pageNum: 1,
          pageSize: 9999,
          quitcheck: 'X',
          retreatdate: moment().subtract(1, 'months').format('YYYY-MM'),

        };
        const tline3 = {
          pageNum: 1,
          pageSize: 9999,
          quitcheck: 'X',
          retreatdate: moment().subtract(2, 'months').format('YYYY-MM'),

        };
        const hline1 = {
          pageNum: 1,
          pageSize: 9999,
          tuneIncheck: 'X',
          tuneIndate: moment().format('YYYY-MM'),
        };
        const hline2 = {
          pageNum: 1,
          pageSize: 9999,
          tuneIncheck: 'X',
          tuneIndate: moment().subtract(1, 'months').format('YYYY-MM'),
        };
        const hline3 = {
          pageNum: 1,
          pageSize: 9999,
          tuneIncheck: 'X',
          tuneIndate: moment().subtract(2, 'months').format('YYYY-MM'),
        };

        const pie1 = {
          pageNum: 1,
          pageSize: 999,
          livenumber: 1,
        };
        const pie2 = {
          pageNum: 1,
          pageSize: 999,
          livenumber: 2,
        };
        const pie3 = {
          pageNum: 1,
          pageSize: 999,
          livenumber: 3,
        };
        const pie4 = {
          pageNum: 1,
          pageSize: 999,
          livenumber: 4,
        };
        const pie6 = {
          pageNum: 1,
          pageSize: 999,
          livenumber: 6,
        };
        const pie8 = {
          pageNum: 1,
          pageSize: 999,
          livenumber: 8,
        };

        const pie1null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber: 1,
        };
        const pie2null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber: 2,
        };
        const pie3null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber: 3,
        };
        const pie4null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber: 4,
        };
        const pie5null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber: 5,
        };
        const pie6null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber:6,
        };
        const pie7null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber: 7,
        };
        const pie8null = {
          pageNum: 1,
          pageSize: 999,
          remainnumber: 8,
        };

        // 并发获取
        const [livepeopleList1, livepeopleList2, livepeopleList3,
          tline11, tline22, tline33,
          zline11, zline22, zline33,
          hline11, hline22, hline33,
          pie1r,pie2r,pie3r,pie4r,pie6r,pie8r,
          pie1n,pie2n,pie3n,pie4n,pie5n,pie6n,pie7n,pie8n,] = await Promise.all([
            listLivepeople(queryParams1),
            listLivepeople(queryParams2),
            listLivepeople(queryParams3),

            listLivepeople(zline1),
            listLivepeople(zline2),
            listLivepeople(zline3),
            listLivepeople(tline1),
            listLivepeople(tline2),
            listLivepeople(tline3),
            listLivepeople(hline1),
            listLivepeople(hline2),
            listLivepeople(hline3),


            listRoominfor(pie1),
            listRoominfor(pie2),
            listRoominfor(pie3),
            listRoominfor(pie4),
            listRoominfor(pie6),
            listRoominfor(pie8),

            listRoominfor(pie1null),
            listRoominfor(pie2null),
            listRoominfor(pie3null),
            listRoominfor(pie4null),
            listRoominfor(pie5null),
            listRoominfor(pie6null),
            listRoominfor(pie7null),
            listRoominfor(pie8null),

          ]);

        const rz = livepeopleList1.total;
        const ts = livepeopleList2.total;
        const hs = livepeopleList3.total;

        // const queryy = { };
        // queryy.kbid = 1;
        // queryy.checkin = rz;
        // queryy.checkout = ts;
        // queryy.changed = hs;
        // updateKanban(queryy);

        this.line1.ss = zline33.total;
        this.line1.s = zline22.total;
        this.line1.b = zline11.total;
        // const queryss = { };
        // queryss.kbid = 2;
        // queryss.checkin = zline33.total;
        // queryss.checkout = tline33.total;
        // queryss.changed = hline33.total;
        // updateKanban(queryss);

        this.line2.ss = tline33.total;
        this.line2.s = tline22.total;
        this.line2.b = tline11.total;
        // const querys = { };
        // querys.kbid = 3;
        // querys.checkin = zline22.total;
        // querys.checkout = tline22.total;
        // querys.changed = hline22.total;
        // updateKanban(querys);

        this.line3.ss = hline33.total;
        this.line3.s = hline22.total;
        this.line3.b = hline11.total;
        // const queryb = { };
        // queryb.kbid = 4;
        // queryb.checkin = zline11.total;
        // queryb.checkout = tline11.total;
        // queryb.changed = hline11.total;
        // updateKanban(queryb);

        const pie_total = pie1r.total+ 2*pie2r.total+ 3*pie3r.total+ 4*pie4r.total+ 6*pie6r.total+ 8*pie8r.total ;
        this.pie_null = pie1n.total+ pie2n.total+ pie3n.total +pie4n.total +pie5n.total+ pie6n.total+ pie7n.total+ pie8n.total;
        this.pie_checkin = pie_total - this.pie_null;
        this.rzl = Math.round( (this.pie_checkin / pie_total)*100 );
        // const piequery = { };
        // piequery.kbid = 5;
        // piequery.checkin = this.pie_checkin;
        // piequery.checkout = this.pie_null;
        // piequery.changed = this.rzl;
        // updateKanban(piequery);

        // console.log(this.rzl, typeof (this.rzl))
        this.getList()
      } catch (error) {
        console.error('获取数据失败:', error)
        alert('获取数据失败，请检查网络连接')
      } finally {
        this.loading = false
        // 在数据获取完成后调用
      this.$nextTick(() => {
        this.init();
      });

      }
    },
    // 停止定时器
    stopTimer() {
      this.clearTimers()
      this.isTimerRunning = false
      this.nextExecutionTime = ''
    },
    // 清除所有定时器
    clearTimers() {
      if (this.timeOutTimer) {
        clearTimeout(this.timeOutTimer)
        this.timeOutTimer = null
      }
      if (this.intervalTimer) {
        clearInterval(this.intervalTimer)
        this.intervalTimer = null
      }
    },

    getList() {
      listKanban(this.query).then(response => {
        this.kbList = response.rows;
      });

        // this.init();

    },
    init() {
      this.pieChart.setOption({
        // title: {
        //   text: "饼图"
        // },
      tooltip: {
        trigger: 'item'
      },
        series: [
          {
            // name: "访问来源",
            type: "pie",
            radius: "70%", // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
            data: [
              { value: this.pie_checkin, name: '已住人数' },
              { value: this.pie_null, name: '空床位' },
              // { value: this.kbList[4].checkin, name: '已住人数' },
              // { value: this.kbList[4].checkout, name: '空床位' },
            ],
          }
        ]
      });

      this.lineChart.setOption({
        tooltip: { trigger: 'item' },
        title: {
          text: "流动趋势"
        },
        grid: {
          left: "40px",
          right: "10px",
          bottom: "20px"
        },
        xAxis: {
          show: true,
          data: ["上上个月", "上个月", "本月"],
          splitLine: {
            show: false
          },
          axisTick: {
            show: false,
            length: 20 // 竖线的长度
          }
        },
        yAxis: {
          splitLine: {
            show: true
          },
          axisTick: {
            show: false
          },
          axisLabel: {
            show: true,
            interval: "auto",
            // formatter: "{value}%"
          }
        },
        series: [
          {
            name: '新入住人员',
            type: 'line',
            data: [
              { value: this.line1.ss },
              { value: this.line1.s },
              { value: this.line1.b }
              // { value: this.kbList[1].checkin },
              // { value: this.kbList[2].checkin },
              // { value: this.kbList[3].checkin }
            ],
            itemStyle: {
              color: '#4fa473'
            },
            label: {
              show: true,
              position: 'top'
            }
          },
          {
            name: '退宿人员',
            type: 'line',
            data: [
              { value: this.line2.ss },
              { value: this.line2.s },
              { value: this.line2.b }
              // { value: this.kbList[1].checkout },
              // { value: this.kbList[2].checkout },
              // { value: this.kbList[3].checkout }
            ],
            itemStyle: {
              color: '#8284f9'
            },
            label: {
              show: true,
              position: 'top'
            }
          },
          {
            name: '调宿人员',
            type: 'line',
            data: [
              { value: this.line3.ss },
              { value: this.line3.s },
              { value: this.line3.b }
              // { value: this.kbList[1].changed },
              // { value: this.kbList[2].changed },
              // { value: this.kbList[3].changed }
            ],
            itemStyle: {
              color: '#ff7d26'
            },
            label: {
              show: true,
              position: 'top'
            }
          },
        ]
      });
    },

  }
}
</script>

<style scoped lang="scss">
* {
  // margin: 0;
  // padding: 0;
  box-sizing: border-box;
}

.container {
  display: flex;
  width: 100%;
  margin: 20px auto;
  gap: 20px;
  padding: 0 20px;
}

.left-section {
  flex: 2;
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.right-section {
  flex: 3;
  // background: linear-gradient(135deg, #b6c3ff 0%, #cdb2e8 100%);
  background-color: #fff;
  border-radius: 12px;
  padding: 30px;
  color: #333;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.top-box,
.bottom-box {
  background: white;
  border-radius: 10px;
  padding: 25px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
  border: 1px solid #eaeaea;
  transition: all 0.3s ease;
}

// .top-box:hover, .bottom-box:hover {
//     transform: translateY(-5px);
//     box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
// }

.box-title {
  font-size: 1.2em;
  font-weight: 600;
  margin-bottom: 10px;
  color: #333;
}

.box-content {
  color: #666;
  line-height: 1.6;
}

.right-title {
  font-size: 1em;
  margin-bottom: 15px;
  font-weight: 600;
}

.right-content {
  line-height: 1.7;

  // opacity: 0.9; 
  .tu_one {
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-between;

    .fangkuai {
      height: auto;
      width: auto;
      align-items: center;
      text-align: center;
      color: white;
      padding: 5px 30px;

      .fk_content {
        width: auto;
        margin: 0 80px 0 20px;
      }

      .fk_val {
        width: auto;
        margin: 0 20px 0 20px;
      }

      .stat-card {
        display: flex;
        align-items: center;
        padding: 5px 15px;
        border-radius: 4px;
        color: white;
        font-size: 14px;
      }

      .stat-name {
        margin-right: 15px;
      }
    }
  }

  .tu {
    // height: 300px;
    padding: 20px 0px;
    // border: 1px solid #ccc;
    width: 100%;
    display: flex;
    justify-content: space-between;

    .rzl {
      flex: 1;
      height: 230px;
      // background-color: #ffc5c5;
      padding: 20px 20px;
      font-weight: 600;
      font-size: 30px;
      text-align: center;
    }

    .pie {
      flex: 3;
      height: 230px;
    }
  }

  .line {
    // width: 250px;
    height: 300px;
    padding: 20px 20px;
    // border: 1px solid #ccc;
    background-color: #fff;
  }

  /* 外层容器：Flexbox布局 + 水平排列 */
  .linetext {
    display: flex;
    justify-content: space-between;
    /* 子元素水平分散排列 */
    align-items: center;
    /* 垂直居中对齐 */
    padding: 0px 80px;
    margin: 0px 20px 30px 20px;
  }

  /* 每个“方块+文字”的容器 */
  .legend-item {
    display: flex;
    align-items: center;
    /* 方块与文字垂直居中 */
    gap: 5px;
    font-size: 14 !important;
    /* 方块与文字之间的间距 */
  }

  .color-block {
    width: 100px;
    height: 3px;
    border-radius: 2px;
  }

  .green {
    background-color: #4fa473;
  }

  .blue {
    background-color: #8284f9;
  }

  .orange {
    background-color: #ff7d26;
  }

}

@media (max-width: 768px) {
  .container {
    flex-direction: column;
  }

  .left-section {
    margin-bottom: 20px;
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
</style>