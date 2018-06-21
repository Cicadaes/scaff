<style lang='less'>

@import '../../assets/styles/taskIndex';

</style>

<template>

<div class="task-manage">
    <div class="header">
        <el-form :inline="true" label-width="80px">
            <el-row>
                <el-col>
                    <span class="performer" style="margin-left:0px;">执行器列表</span>
                    <el-button type="success" icon="plus" @click="handleAdd" size="small">新增执行器</el-button>
                    <span class="performer" style="margin-left:10px;">调度中心online：
                      <el-tag type="success">{{centerOnline}}</el-tag>
                    </span>
                </el-col>
            </el-row>
        </el-form>
    </div>
    <el-table :data="tableData" border style="width: 100%">
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :width="item.width" :sortable="item.sort">
            <template scope="scope">
                <span v-if="item.props === 'addressList'" @click="checkDetail(scope.$index, scope.row)" class="detail">
                    <el-tag v-if="scope.row[item.props] != null" type="success" style="margin-top:7px;">{{ scope.row.addressList }}</el-tag>
              </span>
                <span v-else>{{scope.row[item.props]}}</span>
            </template>
        </el-table-column>
        <el-table-column prop="operate" label="	操作">
            <template scope="scope" class="operate">
                <el-button size="small" type="primary" icon="edit" @click='handleEdit(scope.$index, scope.row)'>
                </el-button>
                <el-button size="small" type="danger" icon="delete" @click="handleDelete(scope.$index, scope.row)">
                </el-button>
            </template>
        </el-table-column>
    </el-table>

    <el-dialog :visible.sync="taskActuatorForm" @close="handleClose">
        <template slot="title">{{clickType === 'edit' ? "编辑" : "新增"}}</template>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-row>
                <el-col>
                    <el-form-item label="AppName" prop="appName">
                        <el-input v-model="ruleForm.appName" placeholder="AppName">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
                    <el-form-item label="名称" prop="groupTitle">
                        <el-input v-model="ruleForm.groupTitle" placeholder="请输入名称">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
                    <el-form-item label="排序" prop="groupOrder">
                        <el-input v-model="ruleForm.groupOrder" placeholder="请输入排序">
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

    <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />
</div>

</template>

<script>

import Pagination from '../../components/Pagination';
import mixin from '../static/tableMixin'
export default {
    name: 'TaskActuator',
    mixins: [mixin],
    data() {
        return {
            actuators: '',
            currentPage: 1,
            visible: false,
            pageSize: 20,
            centerOnline: '获取失败',
            clickType: '',
            taskActuatorForm: false,
            name: '',
            ruleForm: {
                groupId: '',
                appName: '',
                groupTitle: '',
                groupOrder: '',
            },
            rules: {
                appName: [{
                    required: true,
                    message: '请选择AppName',
                    trigger: 'change'
                }],
                groupTitle: [{
                    required: true,
                    message: '请输入名称',
                    trigger: 'change'
                }],
            },
            thNames: [{
                label: 'ID',
                props: 'groupId'
            }, {
                label: 'AppName',
                props: 'appName'
            }, {
                label: '名称',
                props: 'groupTitle'
            }, {
                label: '排序',
                props: 'groupOrder',
                sort: true
            }, {
                label: 'OnLine 机器',
                props: 'addressList'
            }, ],
            tableData: [],
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
            total: 2
        }
    },
    mounted() {
        this.getDataList()
        this.getOnline()
    },

    components: {
        Pagination
    },
    methods: {
        getDataList() {
                let _this = this
                let params = {
                    start: 0,
                    length: 20
                }
                _this.getList(params)
            },
            getList(params) {
                let _this = this
                this.fetchData('/taskSchedule/jobGroup/list', params, 'get').then(response => {
                    if (response.isOk === true) {
                        _this.tableData = response.data || []
                        _this.total = response.totalCount
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            getOnline() {
              let _this = this
                let params = {}
                this.fetchData('/taskSchedule/jobGroup/online', params, 'get').then(response => {
                    if (response.isOk === true) {
                        _this.centerOnline = response.data.online
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            cancel() {
                this.taskActuatorForm = false
            },
            submitForm(formName) {
                let _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if (_this.clickType === '') {
                            _this.validAdd()
                        } else {
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
            handleAdd() {
                this.clickType = ''
                this.taskActuatorForm = true
                this.ruleForm = {
                  appName: '',
                  groupTitle: '',
                  groupOrder: '',
                }
            },
            validAdd() {
                let _this = this
                let params = this.ruleForm
                this.fetchData('/taskSchedule/jobGroup/save', params, 'post').then(response => {
                    if (response.isOk === false) {
                        this.$message.error(response.msg);
                    } else {
                        this.$message({
                            type: 'success',
                            message: '新增成功!'
                        });
                        _this.getDataList()
                        this.taskActuatorForm = false
                    }
                }).catch(error => {});
            },
            handleEdit(index, row) {
                this.clickType = 'edit'
                this.taskActuatorForm = true
                this.ruleForm = {
                    groupId: row.groupId,
                    appName: row.appName,
                    groupTitle: row.groupTitle,
                    groupOrder: row.groupOrder,
                }
            },
            validEdit() {
              let _this = this
              let params = this.ruleForm
              this.fetchData('/taskSchedule/jobGroup/update', params, 'post').then(response => {
                  if (response.isOk === false) {
                      this.$message.error(response.msg);
                  } else {
                      this.$message({
                          type: 'success',
                          message: '修改成功!'
                      });
                      _this.getDataList()
                      this.taskActuatorForm = false
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
                        groupId: row.groupId
                    }
                    this.fetchData('/taskSchedule/jobGroup/remove', params, 'get').then(response => {
                      if (response.isOk === true) {
                          this.$message({
                              type: 'success',
                              message: response.msg
                          });
                          _this.getDataList()
                          this.taskActuatorForm = false
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
              let _this = this
              this.currentPage = val;
              let params = {
                start: (val - 1) * this.pageSize,
                length: 20
              }
              this.getList(params)
            },
            handleClose() {
                this.resetForm('ruleForm')
            }
    }
}

</script>
