<style lang='less'>

@import '../../assets/styles/taskIndex';

</style>

<template>

<div class="task-manage" style="min-width:748px;">
    <div class="header">
        <el-form :inline="true" label-width="80px">
            <el-row>
                <el-col>
                    <span class="performer" style="margin-left:0px;">执行器</span>
                    <el-select v-model="filters.group" clearable placeholder="请选择" @change="">
                        <el-option v-for="item in actuatorName" :key="item.value" :label="item.label" :value="item.value">
                        </el-option>
                    </el-select>
                    <span class="performer" style="margin-left:10px;">jobHandler</span>
                    <el-input v-model.trim="filters.handler" placeholder="" style="width:220px;" @keydown.enter.native="search"></el-input>
                    <el-button type="primary" @click="" style="margin-left:10px;" @click="search">搜索</el-button>
                    <el-button type="success" icon="plus" @click="handleAdd">新增</el-button>
                </el-col>
            </el-row>
        </el-form>
    </div>
    <el-table :data="tableData" border style="width: 100%">
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :width="item.width">
        </el-table-column>
        <el-table-column label="状态" prop="status" width="180">
            <template scope="scope">
                <el-switch v-model="scope.row.jobStatus" :width="94" on-text="NORMAL" off-text="PAUSED" on-color="#13ce66" off-color="#ff4949" @change="handleChange(scope.$index, scope.row)">
                </el-switch>

            </template>
        </el-table-column>
        <el-table-column prop="operate" label="	操作">
            <template scope="scope" class="operate">
                <el-tooltip class="item" effect="dark" content="执行" placement="top">
                    <el-button size="small" type="success" icon="d-arrow-right" @click="run(scope.$index, scope.row)">
                    </el-button>
                </el-tooltip>
                <el-tooltip class="item" effect="dark" content="日志" placement="top">
                  <router-link :to="{ path: '/taskScheduling/log', query: { jobId: targetId }}">
                    <el-button size="small" icon="document" @click="getJobId(scope.$index, scope.row)">
                    </el-button>
                  </router-link>
                </el-tooltip>
                <el-button size="small" type="primary" icon="edit" @click='handleEdit(scope.$index, scope.row)'>
                </el-button>

                <el-button size="small" type="danger" icon="delete" @click="handleDelete(scope.$index, scope.row)">
                </el-button>
                </el-button>
            </template>
        </el-table-column>
    </el-table>

    <el-dialog :visible.sync="taskManageForm" @close="handleClose">
        <template slot="title">{{clickType === 'edit' ? "编辑" : "新增"}}</template>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm task-form">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="执行器" prop="groupId">
                        <el-select v-model="ruleForm.groupId" placeholder="请选择执行器" :disabled="editAllow">
                            <el-option v-for="item in actuatorName" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="任务描述" prop="jobDesc">
                        <el-input v-model="ruleForm.jobDesc" placeholder="请输入任务描述">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="路由策略" prop="jobRoute">
                        <el-select v-model="ruleForm.jobRoute" placeholder="请选择路由策略">
                            <el-option v-for="item in routes" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="jobCron" prop="jobCron">
                        <el-input v-model="ruleForm.jobCron" placeholder="请输入jobCron">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="jobHandler" prop="jobHandler">
                        <el-input v-model="ruleForm.jobHandler" placeholder="jobHandler" :disabled="editAllow">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="执行参数" prop="jobParam">
                        <el-input v-model="ruleForm.jobParam" placeholder="请输入执行参数">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="阻塞处理" prop="jobBlock">
                        <el-select v-model="ruleForm.jobBlock" placeholder="阻塞处理策略">
                            <el-option v-for="item in blocks" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="失败处理" prop="jobFail">
                        <el-select v-model="ruleForm.jobFail" placeholder="失败处理策略">
                            <el-option v-for="item in fails" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="报警邮件" prop="jobMail">
                        <el-input v-model="ruleForm.jobMail" placeholder="请输入报警邮件">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="负责人" prop="jobAuthor">
                        <el-input v-model="ruleForm.jobAuthor" placeholder="负责人">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="cancel">取 消</el-button>
            <el-button type="primary" @click="submitForm('ruleForm')">确 定</el-button>
        </div>
    </el-dialog>

    <Pagination :page="currentPage" :total="total" @current-change="handleCurrentChange" />
</div>

</template>

<script>

import Pagination from '../../components/Pagination';
import mixin from '../static/tableMixin'
export default {
    name: 'TaskManage',
    mixins: [mixin],
    data() {
        return {
            actuators: '',
            currentPage: 1,
            visible: false,
            clickType: '',
            editAllow: true,
            jobId: '',
            taskManageForm: false,
            pageSize: 20,
            targetId: '',
            jobHandler: '',
            filters: {
              start:0,
              length: 20,
              group: '',
              handler: '',
            },
            ruleForm: {
                groupId: '',
                jobDesc: '',
                jobCron: '',
                jobRoute: '',
                jobHandler: '',
                jobParam: '',
                jobBlock: '',
                jobFail: '',
                jobMail: '',
                jobAuthor: '',
            },
            rules: {
                groupId: [{
                    required: true,
                    message: '请选择执行器',
                    trigger: 'change'
                }],
                jobDesc: [{
                    required: true,
                    message: '请输入描述内容',
                    trigger: 'change'
                }],
                jobRoute: [{
                    required: true,
                    message: '请输入路由策略',
                    trigger: 'change'
                }],
                jobCron: [{
                    required: true,
                    message: '请输入jobCron',
                    trigger: 'change'
                }, ],
                jobHandler: [{
                    required: true,
                    message: '请输入jobHandler',
                    trigger: 'change'
                }],
                jobBlock: [{
                    required: true,
                    message: '请选择阻塞处理策略',
                    trigger: 'change'
                }],
                jobFail: [{
                    required: true,
                    message: '请选择失败处理策略',
                    trigger: 'change'
                }],
                jobAuthor: [{
                    required: true,
                    message: '请输入负责人',
                    trigger: 'change'
                }],
            },
            thNames: [{
                label: '任务Key',
                props: 'jobKey'
            }, {
                label: '描述',
                props: 'jobDesc'
            }, {
                label: 'Cron',
                props: 'jobCron',
            }, {
                label: 'jobHandler',
                props: 'jobHandler',
            }, {
                label: '负责人',
                props: 'jobAuthor'
            }],
            tableData: [],
            actuatorName: [],
            jobDescs: [],
            routes: [],
            blocks: [],
            fails: [],
            total: 1
        }
    },
    components: {
        Pagination
    },
    mounted() {
        this.getDataList()
        this.getActuator()
        this.getRoute()
        this.getBlock()
        this.getFail()
    },
    methods: {
            getDataList() {
                    let _this = this
                    let params = {
                        start: 0,
                        length:20
                    }
                    _this.getList(params)
                },
                getList(params) {
                    let _this = this
                    this.fetchData('/taskSchedule/jobInfo/list', params, 'get').then(response => {
                        if (response.isOk === true) {
                            _this.tableData = _this.getter(response.data) || []
                            _this.total = response.totalCount
                        } else {
                            this.$message.error(response.msg)
                        }
                    }).catch(error => {

                    });
                },
            search() {
                this.currentPage = 1
                let params = this.filters
                this.getList(params)
            },
            getter(data) {
                data.forEach(function(item, index) {
                    if (item.jobStatus === 'NORMAL') {
                        item.jobStatus = true
                    } else {
                        item.jobStatus = false
                    }
                })
                return data
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
            getRoute() {
                let _this = this
                let params = {}
                this.fetchData('/taskSchedule/jobCommon/route', params, 'get').then(response => {
                    let routes = []
                    response.data.forEach(function(item, index) {
                        routes[index] = {}
                        routes[index].label = item.title;
                        routes[index].value = item.value;
                    })
                    _this.routes = routes || []
                }).catch(error => {});
            },
            getBlock() {
                let _this = this
                let params = {}
                this.fetchData('/taskSchedule/jobCommon/block', params, 'get').then(response => {
                    let blocks = []
                    response.data.forEach(function(item, index) {
                        blocks[index] = {}
                        blocks[index].label = item.title;
                        blocks[index].value = item.value;
                    })
                    _this.blocks = blocks || []
                }).catch(error => {});
            },
            getJobId(index, row) {
              this.targetId = row.jobId
            },
            getFail() {
                let _this = this
                let params = {}
                this.fetchData('/taskSchedule/jobCommon/fail', params, 'get').then(response => {
                    let fails = []
                    response.data.forEach(function(item, index) {
                        fails[index] = {}
                        fails[index].label = item.title;
                        fails[index].value = item.value;
                    })
                    _this.fails = fails || []
                }).catch(error => {});
            },
            submitForm(formName) {
                let _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if (_this.clickType === '') {
                            _this.validAdd()
                        }
                        else {
                            _this.validEdit()
                        }
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            cancel() {
                this.taskManageForm = false
            },
            handleAdd() {
                this.clickType = ''
                this.editAllow = false
                this.taskManageForm = true
            },
            validAdd() {
                let _this = this
                let params = this.ruleForm
                this.fetchData('/taskSchedule/jobInfo/add', params, 'post').then(response => {
                    if (response.isOk === false) {
                        this.$message.error(response.msg);
                    } else {
                        this.$message({
                            type: 'success',
                            message: '新增成功!'
                        });
                        _this.getDataList()
                        this.taskManageForm = false
                    }
                }).catch(error => {});
            },
            handleEdit(index, row) {
              let _this = this
              this.jobId = row.jobId
                this.clickType = 'edit'
                this.editAllow = true
                this.taskManageForm = true
                let params = {
                        jobId: row.jobId
                    }
                    this.fetchData('/taskSchedule/jobInfo/get', params, 'get').then(response => {
                        if (response.isOk === true) {
                          _this.ruleForm = response.data
                        }
                    }).catch(error => {
                    });

            },
            validEdit() {
              let _this = this
              this.ruleForm.jobId = this.jobId
              let params = this.ruleForm
              this.fetchData('/taskSchedule/jobInfo/reschedule', params, 'post').then(response => {
                  if (response.isOk === true) {
                    this.$message({
                        type: 'success',
                        message: '修改成功!'
                    });
                    _this.taskManageForm = false
                    _this.handleCurrentChange(_this.currentPage)
                  } else {
                    _this.$message.error(response.msg);
                  }
              }).catch(error => {});
            },
            handleDelete(index, row) {
                let _this = this
                this.$confirm('删除此条数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let params = {
                        jobId: row.jobId
                    }
                    this.fetchData('/taskSchedule/jobInfo/remove', params, 'get').then(response => {
                      if (response.isOk === true) {
                          this.$message({
                              type: 'success',
                              message: response.msg
                          });
                          _this.handleCurrentChange(_this.currentPage)
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
            handleChange(index, row) {
                let _this = this
                let params = {
                    jobId: row.jobId
                }

                if (row.jobStatus === false) {
                    this.fetchData('/taskSchedule/jobInfo/pause', params, 'get').then(response => {
                        if (response.isOk === true) {
                            this.$message({
                                type: 'success',
                                message: '已暂停！'
                            });
                        }
                    }).catch(error => {});
                } else {
                    this.fetchData('/taskSchedule/jobInfo/resume', params, 'get').then(response => {
                        if (response.isOk === true) {
                            this.$message({
                                type: 'success',
                                message: '已恢复'
                            });
                        }
                    }).catch(error => {});
                }




            },
            handleCurrentChange(val) {
              let _this = this
              this.currentPage = val;
              this.filters.start = (val - 1) * this.pageSize
              let params = this.filters
              this.getList(params)
            },
            handleClose() {
                this.resetForm('ruleForm')
            },
            run(index, row) {
                let _this = this
                const h = this.$createElement;
                this.$msgbox({
                    title: '消息提示',
                    message: h('p', null, [
                        h('span', null, '需要执行此命令吗？ '),
                    ]),
                    showCancelButton: true,
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    beforeClose: (action, instance, done) => {
                        if (action === 'confirm') {
                            instance.confirmButtonLoading = true;
                            instance.confirmButtonText = '执行中...';
                            let params = {
                                jobId: row.jobId
                            }
                            _this.fetchData('/taskSchedule/jobInfo/trigger', params, 'get').then(response => {
                                if (response.isOk === true) {
                                    done()
                                    instance.confirmButtonLoading = false;
                                }
                            }).catch(error => {});
                        } else {
                            done();
                        }
                    }
                }).then(action => {
                    this.$message({
                        type: 'success',
                        message: '执行成功 '
                    });
                });
            },
    }
}

</script>
