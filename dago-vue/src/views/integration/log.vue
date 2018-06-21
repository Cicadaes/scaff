<style lang='less'>

@import '../../assets/styles/integrationIndex';
body {
    overflow: inherit !important;
}

.integration {
    min-width: 1100px;
    .currentTotal {
        color: #48576a;
        font-size: 13px;
        text-align: right;
        white-space: nowrap;
        padding-right: 10px;
        margin: 10px 0px -10px 0px;
    }
    .success {
        color: #13CE66;
    }
    .fault {
        color: #FF4949;
    }
}

</style>

<template>

<div class="integration">
    <div class="header">
        <el-row>
            <el-col>
                <span class="performer">集成任务名</span>
                <el-select v-model="filters.integrationName" placeholder="请选择" style="width:300px;" clearable>
                    <el-option v-for="item in taskMsg" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
                <el-date-picker v-model="filters.startTimeS" format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="请选择开始时间" align="left" @change="timeStart">
                </el-date-picker>
                <el-date-picker v-model="filters.startTimeE" format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="请选择结束时间" align="left" @change="timeEnd">
                </el-date-picker>
                <el-button type="primary" @click="search" style="margin-left:4px;">搜索</el-button>
            </el-col>
        </el-row>
    </div>
    <el-table :data="tableData" border style="width: 100%" @sort-change="sortChange">
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :sortable="item.sort" :width="item.width">
            <template scope="scope" class="demo-autocomplete">
                <span v-if="item.props === 'status'">
                <span v-if ="scope.row[item.props] === 50" class="fault">
                  终止
                </span>
                <span v-else-if="scope.row[item.props] === 60" class="fault">
                失败
                </span>
                <span v-else class="success">
                成功
              </span>
                </span>
                <span v-else-if="item.props === 'errorMsg'" @click="checkDetail(scope.$index, scope.row)" class="detail">
                  {{scope.row[item.props]}}
                </span>
                <span v-else-if="item.props === 'jobName'">
                  <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                        <span>{{scope.row[item.props]}}</span>
                        </el-tooltip>
                </span>
                <span v-else>{{scope.row[item.props]}}</span>
            </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" sortable="custom" width="180">
            <template scope="scope" class="">
                <span>{{scope.row.createTime}}</span>
            </template>
        </el-table-column>
    </el-table>
    <el-dialog :visible.sync="details" size="tiny" title="错误信息">
        <span>{{content}}</span>
        <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="details = false">关 闭</el-button>
      </span>
    </el-dialog>
    <p class="currentTotal">当前页 <span>{{currentTotal}}</span> 条</p>
    <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />
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
            taskMsg: [],
            currentTotal: 0,
            actuators: '',
            currentPage: 1,
            visible: false,
            pageSize: 20,
            clickType: '',
            details: false,
            filters: {
                start: 0,
                size: 20,
                integrationName: '',
                order: '',
                orderBy: 'create_time',
                startTimeS: '',
                startTimeE: '',
            },
            content: '配置项信息',
            taskManageForm: false,
            tableData: [],
            total: 1,
            thNames: [{
                label: '序号',
                props: 'number',
                width: 80
            }, {
                label: '集成任务名',
                props: 'integrationName',
            }, {
                label: '总记录数',
                props: 'totalNum'
            }, {
                label: '失败记录数',
                props: 'errorNum',
            }, {
                label: '开始时间',
                props: 'startTime',
                width: 180
            }, {
                label: '结束时间',
                props: 'endTime',
                width: 180
            }, {
                label: '调度耗时',
                props: 'totalCosts',
            }, {
                label: '运行结果',
                props: 'status',
            }, {
                label: '错误信息',
                props: 'errorMsg'
            }],
        }
    },

    components: {
        Pagination
    },
    watch: {
        'filters.integrationName': function(to) {
            let params = {
                start: 0,
                size: 20,
                integrationName: to
            }
            this.getList(params)
        }
    },
    beforeMount() {
        this.getDataList()
        this.getTaskMsg()
    },
    mounted() {

    },
    methods: {
        getTaskMsg() {
                let _this = this
                let params = {
                    start: 0,
                    size: 20
                }
                this.fetchData('/integration/tasks/queryNew', params, 'get').then(response => {
                    if (response.isOk === true) {
                        let taskMsg = []
                        response.data.forEach(function(item, index) {
                            taskMsg[index] = {}
                            taskMsg[index].label = item.integrationName;
                            taskMsg[index].value = item.integrationName;
                        })
                        _this.taskMsg = taskMsg || []
                    } else {
                        this.$message.error(response.msg)
                    }

                }).catch(error => {

                });

            },
            getDataList() {
                let _this = this
                let params = {
                    start: 0,
                    size: 20,
                    order: 'DESC',
                    orderBy: 'create_time',
                    integrationName: '',
                    startTimeS: '',
                    startTimeE: '',
                }
                _this.getList(params)
            },
            getList(params) {
                let _this = this
                this.fetchData('/integration/logs/query', params, 'get').then(response => {
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
            timeStart(date) {
                let time = date;
                if (time != '' && time != null) {
                    this.filters.startTimeS = time
                }
            },
            timeEnd(date) {
                let time = date;
                if (time != '' && time != null) {
                    this.filters.startTimeE = time
                }
            },
            search() {
                this.currentPage = 1
                let params = this.filters
                this.getList(params)
            },
            checkDetail(index, row) {
                this.content = row.errorMsg
                this.details = true
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.filters.start = (val - 1) * this.pageSize
                let params = this.filters
                this.getList(params)
            },
            sortChange({
                column, prop, order
            }) {
                this.filters['order'] = order === 'ascending' ? 'ASC' : 'DESC';
                this.currentPage = 1;
                let params = this.filters
                this.getList(params)
            }
    }
}

</script>
