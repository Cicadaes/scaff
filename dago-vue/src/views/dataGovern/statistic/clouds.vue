<style lang="less">
  @import '../../../assets/styles/clouds';
  #cloud {
    max-height: 400px;
  }
</style>

<template>

<div class="cloud" style="width: 100%; min-height: 300px;">
    <el-row>
      <el-col :span="6">
        <div class="cloud-title">
          <ul id="cloud">
            <li v-for="(item, index) in navList" @click="selectDataType(item.catagoryCode)">
              <span :style="{color:color[index]}"><i class="el-icon-star-off"></i></span>
              <span>{{item.catagoryName}}</span>
              <span style="float:right;">({{item.typeTotal}})</span>
          </li>
          </ul>
        </div>
      </el-col>
      <el-col :span="18">
          <div id="type" style="min-height: 300px;">
              <el-button :style="{background:item.type}" v-for="item in audits" class="data-audit animated fadeInLeft" round :type="item.type" :key="item.data_type">
                  <p style="font-size:14px;">{{item.typeName}}</p>
                  <p>总量{{item.total>100000000?(item.total/100000000).toFixed(2)+'亿':(item.total/10000).toFixed(2)+'万'}}</p>
                  <p>增量{{item.increment>100000000?(item.increment/100000000).toFixed(2)+'亿':(item.increment/10000).toFixed(2)+'万'}}</p>
              </el-button>
          </div>
      </el-col>
    </el-row>
</div>

</template>

<script>

import mixin from '../../static/tableMixin'
export default {
    name: 'CloudStatistic',
    mixins: [mixin],
    data() {
        return {
            color:['#24caa4', '#02dccf', '#ef7460', '#5f95d7', '#02dccf', '#06beec','#dc8e76','#42c5b9','#ec6794','#78c7c0','#459ca7','#e2af63'],
            filters: {
                sSearch: {
                    data_type: '',
                    stat_time_b: '',
                    stat_time_e: '',
                },
                start: 0,
                length: 20
            },
            map: [],
            database: '',
            mapFactory: [],
            mapCenter: [],
            currentTotal: 0,
            title: '',
            pageSize: 20,
            currentPage: 1,
            total: 0,
            auditsTotal: '',
            societysTotal: '',
            tableData: [],
            navList: [],
            thNames: [{
                label: '序号',
                props: 'number',
                width: 80
            }, {
                label: '接入厂商',
                props: 'companyName',
            }, {
                label: '接入中心',
                props: 'centerName',
            }, {
                label: '总量',
                props: 'record_count',
            }, {
                label: '统计日期',
                props: 'stat_date',
            }, ],
            audits: [],
            societys: [],
        }
    },
    created() {
        this.getNavList()
    },
    mounted() {

    },
    methods: {
      getNavList() {
        let _this = this
        this.fetchData('/dataManage/govern/queryCatagoryType', {}, 'get').then(response => {
            if (response.isOk === true) {
              let arr = []
              response.data.forEach(function(item ,index) {
                let obj = {}
                obj.catagoryName = item.catagoryName
                obj.catagoryCode = item.catagoryCode
                obj.typeTotal = item.typeTotal
                arr.push(obj)
              })
              _this.navList = arr
            } else {
                this.$message.error(response.msg)
            }
        }).then(() =>{
          $("#cloud li").click(function() {
            $(this).addClass('tabActive').siblings().removeClass('tabActive')
          }).get(0).click()
        }).catch(error => {

        });
      },
      getList(params) {
        const _this = this
        this.fetchData('/dataManage/profile/cloud', params, 'get').then(response => {
            if (response.isOk === true) {
              if (response.data!=null) {
                let audits = []
                response.data.forEach(function(item, index) {
                    audits[index] = {}
                    audits[index].typeName = item.typeName;
                    audits[index].total = item.total;
                    audits[index].increment = item.increment;
                    audits[index].type = _this.randomColor()
                })
                _this.auditsTotal = response.totalCount
                _this.audits = audits || []
                this.tltleList.forEach(function(item, index) {
                    item.type = _this.randomColor()
                })
              }
            } else {
                this.$message.error(response.msg)
            }
        }).catch(error => {

        });
      },

        getter(data) {
            let _this = this
            data.forEach(function(item, index) {
                item.companyName = _this.mapFactory.get(item.company_id)
                item.centerName = _this.mapCenter.get(item.center_code)
            })
            return data
        },
            getDictType() {
                let _this = this
                let params = {}
                    //获取小类
                this.fetchData('/sysMonitor/dict/sys_source_sub_type', params, 'get').then(response => {
                    if (response.isOk === true) {
                        let mapArray = []
                        response.data.forEach(function(item, index) {
                            let arrIn = []
                            arrIn.push(item.name.toString())
                            arrIn.push(item.value)
                            mapArray.push(arrIn)
                        })
                        const map = new Map(mapArray)
                        this.map = map
                    } else {
                        this.$message.error(response.msg)
                    }

                }).catch(error => {
                    this.$message.error(error)
                });

                //获取厂商
                this.fetchData('/sysMonitor/dict/center', params, 'get').then(response => {
                    if (response.isOk === true) {
                        let mapArray = []
                        response.data.forEach(function(item, index) {
                            let arrIn = []
                            arrIn.push(item.code.toString())
                            arrIn.push(item.name)
                            mapArray.push(arrIn)
                        })
                        const map = new Map(mapArray)
                        this.mapCenter = map
                    } else {
                        this.$message.error(response.msg)
                    }

                }).catch(error => {
                    this.$message.error(error)
                });

                //获取小类
                this.fetchData('/sysMonitor/dict/factory', params, 'get').then(response => {
                    if (response.isOk === true) {
                        let mapArray = []
                        response.data.forEach(function(item, index) {
                            let arrIn = []
                            arrIn.push(item.code.toString())
                            arrIn.push(item.name)
                            mapArray.push(arrIn)
                        })
                        const map = new Map(mapArray)
                        this.mapFactory = map
                    } else {
                        this.$message.error(response.msg)
                    }

                }).catch(error => {
                    this.$message.error(error)
                });
            },
            getAudits() {
                let _this = this
                let params = {}
                this.fetchData('/dataManage/profile/audit', params, 'get').then(response => {
                    if (response.isOk === true) {
                      if (response.data!=null) {
                        let audits = []
                        response.data.forEach(function(item, index) {
                            audits[index] = {}
                            audits[index].data_type = item.data_type;
                            audits[index].history_total = item.history_total;
                            audits[index].yesterday_total = item.yesterday_total;
                            audits[index].type = _this.randomColor()
                        })
                        _this.auditsTotal = response.totalCount
                        _this.audits = audits || []
                        this.tltleList.forEach(function(item, index) {
                            item.type = _this.randomColor()
                        })
                      }
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });

            },
            randomColor: function() {
                var color = ['#24caa4', '#02dccf', '#ef7460', '#5f95d7', '#02dccf', '#06beec','#dc8e76','#42c5b9','#ec6794','#78c7c0','#459ca7','#e2af63']
                let index = Math.floor(Math.random() * color.length)
                return color[index]
            },
            handleCurrentChange(val) {
                let _this = this
                this.currentPage = val;
                this.filters.start = (val - 1) * this.pageSize
                let params = this.filters
                this.getList(params)
            },
            handleClose() {
                this.tableData = []
                this.filters.sSearch.data_type = ''
            },
            selectDataType(data){
            this.currentPage = 1
            let param = {
                  start: 0,
                  size: 20,
                  catagoryCode: data
            }
            this.getList(param)
          },
    }
}

</script>
