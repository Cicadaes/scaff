<style lang='less' scoped>

@import '../../assets/styles/integrationIndex';
body {
    overflow: auto !important;
}

.integration {
    overflow: hidden;
    .el-dialog__wrapper {}
    .el-dialog {
        top: 10% !important;
    }
}

.isActive {
    min-height: 800px;
    overflow: auto;
}

</style>

<template>

<div class="integration isActive">
    <div style="position: absolute; top: 9px;">
        <el-button type="success" icon="plus" size="small" @click="handleAdd">新增</el-button>
    </div>

    <el-form :inline="true" label-width="80px" style="margin-bottom: 20px">
        <span class="performer" style="margin-left:10px;">集成任务名</span>
        <!-- <el-input v-model.trim="searchParams.integrationName"  placeholder="" style="width:220px;" ></el-input> -->
        <el-select v-model="searchParams.integrationName" placeholder="请选择" style="width:300px;" clearable>
            <el-option v-for="item in taskMsg" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <el-button type="primary"  style="margin-left:10px;" @click="search">搜索</el-button>        
    </el-form>

    <el-table :data="tableData" border style="width: 100%">
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :width="item.width">
            <template scope="scope" class="operate">
                <span v-if="item.props === 'remarks'" @click="checkDetail(scope.$index, scope.row)" class="detail">
                    {{scope.row[item.props]}}
                </span>
                <span v-else-if="item.props === 'taskName'">
                    <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                        <span>{{scope.row[item.props]}}</span>
                    </el-tooltip>
                </span>
                <span v-else>{{scope.row[item.props]}}</span>
            </template>
        </el-table-column>
        <el-table-column prop="info" label="配置详情">
            <template scope="scope" class="operate">
                <span class="detail" @click="checkInfo(scope.$index, scope.row)">查看</span>
            </template>
        </el-table-column>
        
        <el-table-column prop="updateTime" label="更新时间">
            <template scope="scope" class="operate">
                <span class="detail" >
                    <el-tooltip class="item" effect="dark" :content="scope.row.updateTime" placement="top-start">
                        <span>{{scope.row.updateTime}}</span>
                    </el-tooltip>
                </span>
            </template>
        </el-table-column>

        <el-table-column prop="createTime" label="创建时间">
            <template scope="scope" class="operate">
                <span class="detail" >
                    <el-tooltip class="item" effect="dark" :content="scope.row.createTime" placement="top-start">
                        <span>{{scope.row.createTime}}</span>
                    </el-tooltip>
                </span>
            </template>
        </el-table-column>
        <el-table-column prop="operate" label="操作">
            <template scope="scope" class="operate">
                <el-button size="small" type="primary" icon="edit" @click='handleEdit(scope.$index, scope.row)'>
                </el-button>
                <el-button size="small" type="danger" icon="delete" @click="handleDelete(scope.$index, scope.row)">
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-dialog :visible.sync="details" :size="dialogSize">
        <template slot="title">{{checkType === 'remarks' ? "备注信息" : "配置详情"}}</template>
        <el-row>
            <el-col>
                <el-input v-if="this.checkType === 'info'" type="textarea" v-model="content" :rows="16" readonly></el-input>
                <span v-else>{{content}}</span>
            </el-col>
        </el-row>
        <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="details = false" style="margin-top:-30px;">关 闭</el-button>
      </span>
    </el-dialog>
    <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />
    <task-form :showForm="showForm" :editRow="editRow" :clickType="clickType"></task-form>
</div>

</template>

<script>

import Pagination from '../../components/Pagination';
import mixin from '../static/tableMixin'
import taskForm from './taskForm'
// import axios from 'axios'

export default {
    name: 'intergrationManage',
    mixins: [mixin],
    data() {
        return {
            taskMsg: [],
            showForm: false,
            dialogSize: 'small',
            checkType: '',
            editRow: {},
            details: false,
            currentPage: 1,
            visible: false,
            pageSize: 20,
            clickType: '',
            content: '备注信息',
            thNames: [{
                label: '集成任务名',
                props: 'integrationName'
            }, 
            // {
            //     label: '任务名称',
            //     props: 'taskName'
            // }, 
            {
                label: 'reader名称',
                props: 'readerName',
            }, {
                label: 'writer名称',
                props: 'writerName',
            }, {
                label: '备注 ( 可点击查看 )',
                props: 'remarks',
            }],
            tableData: [],
            total: 1,
            searchParams: {
                integrationName: ""
            }
        }
    },
    components: {
        Pagination,
        'task-form': taskForm
    },
    created() {
      this.getDataList(),
      this.getTaskMsg()
    },
    mounted() {
      let _this = this
        this.$root.$on("offTaskForm", function(isOFF) {
            this.showForm = isOFF
            this.clickType = ''
            this.getDataList()
        }.bind(this));
    },
    methods: {
        //获取集成任务名下拉选项
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

        //按集成任务名查询数据
        search() {
            console.log(this.searchParams)
            this.fetchData('/integration/tasks/queryNew', this.searchParams, 'get').then(res => {
                if(res.isOk) {
                    this.tableData = res.data || []
                    this.total = res.totalCount
                }else {
                    this.$message.error(res.msg)
                }
            })
        },

        getDataList() {
                let _this = this
                let params = {
                    start: 0,
                    size: 20
                }
                _this.getList(params)
            },
            getList(params) {
                let _this = this
                this.fetchData('/integration/tasks/queryNew', params, 'get').then(response => {
                    if (response.isOk === true) {
                        _this.tableData = response.data || []
                        _this.total = response.totalCount
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            handleAdd() {
                this.clickType = ''
                this.showForm = true
            },
            handleEdit(index, row) {
                this.clickType = 'edit'
                this.editRow = row
                this.showForm = true
            },
            //查看备注
            checkDetail(index, row) {
                this.dialogSize = "tiny"
                this.content = row.remarks
                this.checkType = 'remarks'
                this.details = true
            },
            //查看配置详情
            checkInfo(index, row) {
                let _this = this
                let params = {
                    taskId: row.taskId,
                    taskName: row.taskName
                }
                this.dialogSize = "small"
                this.checkType = 'info'
                this.details = true
                this.fetchData('/integration/tasks/info', params, 'post').then(response => {
                    if (response.isOk === true) {
                        _this.content = "taskName：" + response.data.taskName + "\n" + "info：" + response.data.info
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });


            },
            handleDelete(index, row) {
                let _this = this
                this.$confirm('删除此条数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let params = {
                        id: row.id,
                        taskName: row.taskName
                    }
                    this.fetchData('/integration/tasks/deleteNew', params, 'post').then(response => {
                        if (response.isOk === true) {
                            this.$message({
                                type: 'success',
                                message: '删除成功'
                            });
                            _this.handleCurrentChange()
                        } else {
                            this.$message.error(response.msg);
                        }
                    }).catch(error => {});
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                let start = (val - 1) * this.pageSize
                let params = {
                    start: start,
                    size: 20
                }
                this.getList(params)
            },
    }
}

</script>
