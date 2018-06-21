<style lang='less'>

@import '../../assets/styles/taskLog';
.success {
    color: #13CE66;
}

.fault {
    color: #FF4949;
}

body {
    overflow: inherit !important;
}

.task-manage {
    min-width: 1100px;
    .header {
        .header-select {
            display: inline-block;
        }
    }
}

</style>

<template>

<div class="task-manage">
    <div class="header">
        <div class="header-select">
            <span class="performer" style="margin-left:0px;">执行器</span>
            <el-select v-model="filters.groupId" clearable placeholder="请选择" @change="">
                <el-option v-for="item in actuatorName" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
            </el-select>
        </div>
        <div class="header-select">
            <span class="performer" style="margin-left:20px;">任务</span>
            <el-select v-model="filters.jobId" clearable placeholder="请选择" v-show="showJobId">
                <el-option v-for="item in taskDescribe" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
            </el-select>
        </div>
        <div class="header-select">
            <span class="performer" style="margin-left:20px;">状态</span>
            <el-select v-model="filters.status" clearable placeholder="请选择">
                <el-option v-for="item in status" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
            </el-select>
        </div>
        <div class="header-select">
            <el-date-picker v-model="filters.startTime" format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="请选择开始时间" align="left" @change="timeStart">
            </el-date-picker>
            <el-date-picker v-model="filters.endTime" format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="请选择结束时间" align="left" @change="timeEnd">
            </el-date-picker>
            <el-button type="primary" @click="serch" style="margin-left:4px;">搜索</el-button>
            <el-button type="success" @click="cleanLog" style="margin-left:4px;">清理日志</el-button>
        </div>
    </div>
    <el-table :data="tableData" border style="width: 100%">
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :width="item.width">
            <template scope="scope">
                <span v-if="item.props === 'triggerMsg'" @click="checkDetail(scope.$index, scope.row)" class="detail">
                  查看
              </span>
                <span v-else-if="item.props === 'executorParam'">
                  <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                        <span>{{scope.row[item.props]}}</span>
                        </el-tooltip>
                </span>
                <span v-else-if="item.props === 'triggerCode'">
                <span v-if="scope.row[item.props]==='200'" class="success">
                  成功
                </span>
                <span v-else class="fault">
                  失败
                </span>
                </span>

                <span v-else-if="item.props === 'handleCode'">
                <span v-if="scope.row[item.props]==='200'" class="success">
                  成功
                </span>
                <span v-if="scope.row[item.props]==='500'" class="fault">
                  失败
                </span>
                </span>
                <span v-else-if="item.props === 'handleMsg'" @click="checkRemark(scope.$index, scope.row)">
                  <span v-if="scope.row[item.props] !='' && scope.row[item.props] != null " class="detail">
                    查看
                  </span>
                </span>
                <span v-else>{{scope.row[item.props]}}</span>
            </template>
        </el-table-column>
        <el-table-column prop="operate" label="	操作">
            <template scope="scope" class="operate">
                <el-tooltip v-if="scope.row.status==='3'" class="item" effect="dark" content="终止" placement="top">
                    <el-button size="small" type="danger" @click="stop(scope.$index,scope.row)">
                        <i class="el-icon-circle-cross"></i>
                    </el-button>
                </el-tooltip>
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-dialog :visible.sync="details" size="tiny">
        <template slot="title">{{checkType === '执行备注' ? "执行备注" : "调度备注"}}</template>
        <span v-html="content"></span>
        <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="details = false">关 闭</el-button>
      </span>
    </el-dialog>
    <el-dialog title="清理日志" :visible.sync="clean" size="tiny">
        <el-row style="text-align:center;">
            <el-col :span="8">
                <el-button @click="lastWeeken">前一周</el-button>
            </el-col>
            <el-col :span="8">
                <el-button type="primary" @click="lastMonth">前一个月</el-button>
            </el-col>
            <el-col :span="8">
                <el-button type="success" @click="lastThreeMonth">前三个月</el-button>
            </el-col>
        </el-row>
        <span slot="footer" class="dialog-footer">
      </span>
    </el-dialog>
    <p class="currentTotal">当前页 <span>{{currentTotal}}</span> 条</p>
    <Pagination :page="currentPage" :total="total" @current-change="handleCurrentChange" />
</div>

</template>

<script>

import Pagination from '../../components/Pagination';
import mixin from '../static/tableMixin'

export default {
    name: 'TaskLog',
    mixins: [mixin],
    data() {
        return {
            showJobId: true,
            currentTotal: 0,
            currentPage: 1,
            checkType: '',
            visible: false,
            details: false,
            clean: false,
            content: '',
            clickType: '',
            manyTimes: true,
            pageSize: 20,
            describe: '',
            filters: {
                start: 0,
                length: 20,
                groupId: '',
                jobId: '',
                status: '',
                startTime: '',
                endTime: '',
            },
            thNames: [{
                label: '序号',
                props: 'number',
                width: 80
            }, {
                label: '执行器地址',
                props: 'executorAddress',
                width: 180
            }, {
                label: 'JobHandler',
                props: 'executorHandler',
                width: 180
            }, {
                label: '任务参数',
                props: 'executorParam',
                width: 320
            }, {
                label: '调度时间',
                width: 180,
                props: 'triggerTime'
            }, {
                label: '调度结果',
                props: 'triggerCode',
            }, {
                label: '调度备注',
                props: 'triggerMsg',
            }, {
                label: '执行时间',
                props: 'handleTime',
                width: 180
            }, {
                label: '执行结果',
                props: 'handleCode',
            }, {
                label: '执行备注',
                props: 'handleMsg'
            }, ],
            tableData: [],
            actuatorName: [],
            taskDescribe: [],
            status: [],
            options: [{
                value: '1',
                label: '执行器1'
            }, {
                value: '2',
                label: '执行器2'
            }, {
                value: '3',
                label: '执行器3'
            }],
            decribeOptions: [{
                value: '1',
                label: '描述1'
            }, {
                value: '2',
                label: '描述2'
            }],
            total: 1,
        }
    },

    components: {
        Pagination
    },
    created() {
        this.checkQuery()
        this.getActuator()
        this.getLogStatus()
        this.getLissAll()
    },
    mounted() {
        if (this.$route.query.jobId) {
            this.filters.jobId = this.$route.query.jobId.toString()
        }
    },
    methods: {
        checkQuery() {
                let jobId = this.$route.query.jobId
                if (jobId) {
                    let params = {
                        jobId: jobId,
                        start: 0,
                        length: 20
                    }
                    this.getList(params)
                } else {
                    this.getDataList()
                }
            },
            getDataList() {
                let params = {
                    start: 0,
                    length: 20
                }
                this.getList(params)
            },
            getList(params) {
                let _this = this
                this.fetchData('/taskSchedule/jobLog/list', params, 'post').then(response => {
                    if (response.isOk === true) {
                        let start = (_this.currentPage - 1) * 20 + 1
                        response.data.forEach(function(item, index) {
                            item.number = start++
                        })
                        _this.tableData = response.data || []
                        _this.total = response.totalCount
                        _this.currentTotal = _this.tableData.length
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            getLissAll() {
                let _this = this
                let params = {
                    start: 0,
                    length: 20
                }
                this.fetchData('/taskSchedule/jobInfo/listAll', params, 'get').then(response => {
                    let taskDescribe = []
                    response.data.forEach(function(item, index) {
                        taskDescribe[index] = {}
                        taskDescribe[index].label = item.jobDesc;
                        taskDescribe[index].value = item.jobId;
                    })
                    _this.taskDescribe = taskDescribe || []
                }).catch(error => {

                });
            },
            getTime(time) {
                let _this = this
                let timeValue = this.moment().subtract(time, 'days').format('YYYY-MM-DD 00:00:00')
                let params = {
                    clearTime: timeValue
                }
                this.fetchData('/taskSchedule/jobLog/clear', params, 'post').then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: '清除成功！'
                        });
                        _this.clean = false
                        _this.checkQuery()
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            lastWeeken() {
                this.getTime(7)
            },
            lastMonth() {
                this.getTime(30)
            },
            lastThreeMonth() {
                this.getTime(90)
            },
            getLogStatus() {
                let _this = this
                let params = {
                    start: 0,
                    length: 20
                }
                this.fetchData('/taskSchedule/jobLog/status', params, 'get').then(response => {
                    let status = []
                    response.data.forEach(function(item, index) {
                        status[index] = {}
                        status[index].label = item.title;
                        status[index].value = item.value;
                    })
                    _this.status = status || []
                }).catch(error => {

                });
            },
            getActuator() {
                let _this = this
                let params = {}
                this.fetchData('/taskSchedule/jobCommon/group', params, 'get').then(response => {
                    let actuatorName = []
                    response.data.forEach(function(item, index) {
                        actuatorName[index] = {}
                        actuatorName[index].label = item.title;
                        actuatorName[index].value = item.id;
                    })
                    _this.actuatorName = actuatorName || []
                }).catch(error => {

                });
            },
            //时间处理
            timeStart(date) {
                let time = date;
                if (time != '' && time != null) {
                    this.filters.startTime = time
                }
            },
            timeEnd(date) {
                let time = date;
                if (time != '' && time != null) {
                    this.filters.endTime = time
                }
            },
            serch() {
                this.currentPage = 1
                let params = this.filters
                this.getList(params)
            },
            checkDetail(index, row) {
                this.checkType = '调度备注'
                this.details = true;
                this.content = row.triggerMsg
            },
            checkRemark(index, row) {
                this.checkType = '执行备注'
                this.details = true
                this.content = row.handleMsg
            },
            cleanLog() {
                this.clean = true
            },
            handleCurrentChange(val) {
                let _this = this
                this.currentPage = val;
                this.filters.start = (val - 1) * this.pageSize
                let params = this.filters
                this.getList(params)
            },
            stop(index, row) {
                let _this = this
                this.$confirm('确定终止这个进程吗?', '提示', {
                    confirmButtonText: '是的',
                    cancelButtonText: '否',
                    type: 'warning'
                }).then(() => {
                    let params = {
                        logId: row.logId
                    }
                    this.fetchData('/taskSchedule/jobLog/kill', params, 'get').then(response => {
                        if (response.isOk === true) {
                            this.$message({
                                type: 'success',
                                message: '已成功终止！'
                            });
                            _this.handleCurrentChange(_this.currentPage)
                        } else {
                            this.$message.error(response.msg);
                        }
                    }).catch(error => {});
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消！'
                    });
                });
            },
    }
}

</script>
