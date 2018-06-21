<template>
  <div class="run">
    <div class="select-button" @click="switchTaskRunning">
        <el-button v-for="item in btns" :key="item">{{item}}</el-button>
        <!-- <el-button>TIMER</el-button>
        <el-button>ETL</el-button>
        <el-button>STREAMING</el-button>
        <el-button>全部</el-button> -->
        <el-button>全部</el-button>
    </div>
  <div id="axis-core" ref="core" style="width: 100%; min-height: 300px;">
</div>
  </div>
</template>

<script>
import { theme } from './echartsTheme/macarons.js'
import mixin from '../../static/tableMixin'
export default {
    name: 'RunStatistic',
    mixins: [mixin],
    data() {
        let _this = this;
        return {
            allData: [],
            axisChart: null,
            btns: [],
            series_arr: [],
            options: {
                // color: ['#3398DB'],
                color: ['#3E98C5'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    data: ['执行成功', '执行失败', '正在执行'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }],
                yAxis: [{
                    type: 'value'
                }],
                series: [
                // {
                //     name: 'ES',
                //     type: 'bar',
                //     stack: '总量',
                //     data: [120, 132, 101]
                // }, 
                // {
                //     name: 'TIMER',
                //     type: 'bar',
                //     stack: '总量',
                //     data: [220, 182, 191]
                // }, 
                // {
                //     name: 'STREAMING',
                //     type: 'bar',
                //     stack: '总量',
                //     data: [150, 232, 201]
                // }, 
                // {
                //     name: 'ETL',
                //     type: 'bar',
                //     stack: '总量',
                //     data: [150, 232, 201]
                // }
                ]
            }
        }
    },

    created () {
        this.getList({});
        this.allData = this.series_arr;
    },

    methods: {
        //获取后台数据
        getList(params) {
            this.fetchData('/dataManage/profile/monitorModule', params, 'get').then(res => {
                if (res.isOk) {
                    // console.log(res.data);
                    let btns_arr = [];
                    res.data[0].modules.forEach(item => {
                        btns_arr.push(item.moduleName.toUpperCase())
                    })
                    this.btns = btns_arr;

                    //生成series数据
                    btns_arr.forEach(item => {
                        let name = item.toLowerCase();
                        let obj = this.mergeData(res.data, name);
                        this.series_arr.push(obj);
                    })
                    // console.log(this.series_objs)  
                    this.options.series = this.series_arr;     
                    console.log(this.options.series)        
                } else {
                    this.$message.error(res.msg)
                }
            }).then(() => {
                this.axisChart = this.$echarts.init(this.$refs.core,'macarons')
                this.axisChart.setOption(this.options);
            }).catch(error => {

            });
        },

        //合并同name的数据
        mergeData(data, name) {
            let obj = {};
            let arr = [];
            data.forEach(item => {
                item.modules.forEach(module => {
                    if (module.moduleName === name) {
                        arr.push(module.total)
                    }
                })
            })
            obj.name = name.toUpperCase();
            obj.type = "bar";
            obj.stack = "总量";
            obj.data = arr;
            return obj;
        },


        //过滤同name的数据
        filterData(key) {
            let nowData = [];
            let keys = this.btns.concat(['全部']);
            if ((keys.indexOf(key) < 0) || !key) {
                return;
            }
            if (key === "全部") {
                return this.allData;
            } 
            this.allData.forEach(item => {
                if (item.name === key) {
                    nowData.push(item);
                }
            })
            return nowData;

        },


        //切换任务运行监控
        switchTaskRunning(e) {
            if (e.target.className === "select-button") {
                return;
            }
            let nowKey = e.target.innerText;  
            let filterData = this.filterData(nowKey);
            // console.log(this.filterData(nowKey));
            this.options.series = filterData;
            // console.log(this.options.series);
            // console.log(this.allData);
            // console.log(this.options);
            this.axisChart.clear();
            this.axisChart.setOption(this.options);
        }
    }
}

</script>
<style lang="less">
.run {
  .select-button{
    display: flex;
    justify-content: center;
  }
}
</style>
