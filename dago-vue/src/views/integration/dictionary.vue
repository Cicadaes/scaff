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
                <span class="performer">字典类型</span>
                <el-select v-model="filters.type" placeholder="请选择" style="width:300px;" clearable>
                    <el-option v-for="item in dictionaryType" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
                <el-button style="float:right;" type="success" icon="plus" @click="handleAdd">新增</el-button>
            </el-col>
        </el-row>
    </div>
    <el-table :data="tableData" border style="width: 100%" @sort-change="">
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :sortable="item.sort" :width="item.width">
          <template scope="scope" class="operate">
              <span v-if="item.props === 'type'">
                {{map.get(scope.row[item.props].toString())}}
              </span>
              <span v-else>{{scope.row[item.props]}}</span>
          </template>
        </el-table-column>
        <el-table-column prop="operate" label="	操作" width="180">
            <template scope="scope" class="operate">
                <el-button size="small" type="primary" icon="edit" @click='handleEdit(scope.$index,scope.row)'>
                </el-button>
                <el-button size="small" type="danger" icon="delete" @click="handleDelete(scope.$index, scope.row)">
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <p class="currentTotal">当前页 <span>{{currentTotal}}</span> 条</p>
    <el-dialog :visible.sync="dialogFormVisible" @close="handleClose">
        <template slot="title">
            {{clickType === 'edit'? '修改参数信息' : '新增字典信息'}}
        </template>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="字典编码" prop="name">
                        <el-input v-model="ruleForm.name" placeholder="请输入字典编码">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="字典值" prop="value">
                        <el-input v-model="ruleForm.value" placeholder="请输入字典值">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="参数类型" prop="type">
                        <el-select v-model="ruleForm.type" clearable placeholder="请选择" style="width:100%;">
                            <el-option v-for="item in dictionaryType" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="描述信息" prop="desc">
                        <el-input type="textarea" placeholder="请输入描述信息" v-model="ruleForm.desc">
                            <template slot="prepend">描述信息</template>
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
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
    name: 'Dictionary',
    mixins: [mixin],
    data() {
        return {
            map: [],
            dialogFormVisible: false,
            clickType: "",
            dictionaryType: [],
            currentTotal: 0,
            actuators: '',
            currentPage: 1,
            visible: false,
            pageSize: 20,
            clickType: '',
            details: false,
            ruleForm: {
                id: '',
                name: '',
                value: '',
                type: '',
                desc: '',
            },
            rules: {
                name: [{
                    required: true,
                    message: '请输入参数名称',
                    trigger: 'change'
                }],
                value: [{
                    required: true,
                    message: '请输入参数值实例',
                    trigger: 'change'
                }],
                type: [{
                    required: true,
                    message: '请选择参数类型',
                    trigger: 'change'
                }],
            },
            filters: {
                start: 0,
                size: 20,
                type: '',
            },
            content: '配置项信息',
            taskManageForm: false,
            tableData: [],
            total: 1,
            thNames: [{
                label: '序号',
                props: 'number',
                width: 120
            }, {
                label: '词典类别',
                props: 'type'
            }, {
                label: '字典编码',
                props: 'name',

            }, {
                label: '字典值',
                props: 'value',

            }, {
                label: '描述信息',
                props: 'desc',
            }, {
                label: '更新时间',
                props: 'updateTime',
                width: 180
            }, {
                label: '创建时间',
                props: 'createTime',
                width: 180
            }, ],
        }
    },

    components: {
        Pagination
    },
    watch: {
      'filters.type': function (to){
        let params = {
          start: 0,
          size: 20,
          type: to
        }
          this.getList(params)
      }
    },
    created() {
      this.getDictionary()
    },
    mounted() {
      this.getDataList()
    },
    methods: {
      getDictionary() {
        let _this = this
        let params = {
          type: ""
        }
        this.fetchData('/integration/dict/type', params, 'post').then(response => {
            if (response.isOk === true) {
              let mapArray = []
              response.data.forEach(function(item, index) {
                  let arrIn = []
                  arrIn.push(item.type.toString())
                  arrIn.push(item.name)
                  mapArray.push(arrIn)
              })
              const map = new Map(mapArray)
              _this.map = map
              _this.dictionaryType = _this.D_getter(response.data) || []
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
                    type: '',
                }
                _this.getList(params)
            },
            getList(params) {
                let _this = this
                this.fetchData('/integration/dict/query', params, 'get').then(response => {
                    if (response.isOk === true) {
                        let start = (_this.currentPage - 1) * 20 + 1
                        _this.tableData = _this.getter(response.data, start) || []
                        _this.total = response.totalCount
                        _this.currentTotal = _this.tableData.length
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            D_getter(data) {
                data.forEach(function(item,index) {
                    item.label = item.name
                    item.value = item.type.toString()
                })
                return data
            },
            getter(data, start) {
                data.forEach(function(item, index) {
                    item.number = start++
                        if (item.defaultField === null) {
                            item.defaultField = "null"
                        }
                })
                return data
            },
            handleAdd() {
                this.clickType = ''
                this.dialogFormVisible = true
                this.ruleForm = {
                    name: '',
                    value: '',
                    type: '',
                    desc: '',
                }
            },
            cancel() {
                this.dialogFormVisible = false
            },
            handleEdit(index,row) {
                this.dialogFormVisible = true
                this.clickType = 'edit'
                this.ruleForm = {
                  id: row.id,
                  name: row.name,
                  value: row.value,
                  type: row.type.toString(),
                  desc: row.desc
                }
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            handleClose() {
                this.resetForm('ruleForm')
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
            validAdd() {
              let _this = this
              let params = this.ruleForm
              this.fetchData('/integration/dict/add', params, 'post').then(response => {
                  if (response.isOk === true) {
                    this.$message({
                        type: 'success',
                        message: response.msg
                    });
                    _this.dialogFormVisible = false
                    _this.getDataList()
                  } else {
                      this.$message.error(response.msg)
                      _this.dialogFormVisible = false

                  }
              }).catch(error => {
                  this.$message.error(error)
              });
            },
            validEdit() {
              let _this = this
              let params = this.ruleForm
              this.fetchData('/integration/dict/edit', params, 'post').then(response => {
                  if (response.isOk === true) {
                    this.$message({
                        type: 'success',
                        message: response.msg
                    });
                    _this.dialogFormVisible = false
                    _this.getDataList()
                  } else {
                      _this.dialogFormVisible = false
                      this.$message.error(response.msg)
                  }
              }).catch(error => {
                  this.$message.error(error)
              });
            },
            handleDelete(index, row) {
                let val = this.currentPage
                let _this = this
                this.$confirm('删除此条数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let params = {
                        id: row.id
                    }
                    this.fetchData('/integration/dict/delete', params, 'post').then(response => {
                        if (response.isOk === true) {
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                            _this.handleCurrentChange(val)
                            _this.dialogFormVisible = false
                        } else {
                            this.$message.error(response.msg);
                        }
                    }).catch(error => {});
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                let params = {
                    type: this.filters.type,
                    start: (val - 1) * this.pageSize,
                    size: 20
                  }
                this.getList(params)
            },
    }
}

</script>
