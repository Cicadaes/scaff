<style lang='less' scoped>

body {
    overflow: inherit !important;
}

@import '../../assets/styles/govern';
.box {
  display: flex;
  flex-wrap: nowrap;
 }
 .tree {
   width:300px;
   margin-right: 10px;
 }
.currentTotal {
    color: #48576a;
    font-size: 13px;
    text-align: right;
    white-space: nowrap;
    padding-right: 10px;
    margin: 10px 0px -10px 0px;
}

.my-autocomplete {
    li {
        line-height: normal;
        padding: 7px;
        .name {
            text-overflow: ellipsis;
            overflow: hidden;
        }
        .addr {
            font-size: 12px;
            color: #b4b4b4;
        }
        .highlighted .addr {
            color: #ddd;
        }
    }
}

.clear-rule {
    cursor: pointer;
    position: absolute;
    margin-left: -20px;
    margin-top: 12px;
}

.success {
    color: #13CE66;
}

.fault {
    color: #FF4949;
}

</style>

<template>

<div class="data-type">
    <div style="position: absolute; top: 8px;">
        <el-button type="success" icon="plus" size="small" @click="handleAdd">新增</el-button>
    </div>
    <div class="machine-type">
        <el-form :inline="true" label-width="80px">
            <span class="performer" style="margin-left:10px;">字段英文名</span>
            <el-input v-model.trim="filters.sSearch.enField" placeholder="" style="width:220px;" @change="EnSearch"></el-input>
            <el-button type="primary" @click="search" style="margin-left:10px;">搜索</el-button>
            <span class="performer" style="margin-left:10px;color:#13ce66;">当前选择：{{location.main}}&nbsp;&nbsp;->&nbsp;&nbsp;{{location.sub}}</span>
        </el-form>
    </div>
    <div class="box">
    <div class="tree">
      <el-tree
        :data="data"
        :props="defaultProps"
        highlight-current
        accordion
        @node-click="handleNodeClick">
      </el-tree>
    </div>
    <el-table :data="tableData" border class="benchmark-table">
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :min-width="item.minWidth" :width="item.width">
            <template scope="scope" class="demo-autocomplete">
                <span v-if="item.props === 'isNull'">
            <span v-if ="scope.row[item.props] === 0" class="fault">
                不允许
              </span>
                <span v-else class="success">
                允许
              </span>
                </span>
                <span v-else-if="item.props === 'fieldDesc'">
            <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                  <span>{{scope.row[item.props]}}</span>
                </el-tooltip>
                </span>
                <span v-else-if="item.props === 'mainType'">
                  {{mainMap.get(scope.row[item.props].toString())}}
                </span>
                <span v-else-if="item.props === 'subType'">
                  {{subMap.get(scope.row[item.props].toString())}}
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
    </div>
    <el-dialog :visible.sync="dialogFormVisible" @close="handleClose">
        <template slot="title">
            {{clickType === 'edit'? '标准编辑' : '新增标准'}}
        </template>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-row>
              <el-col :span="12">
                <el-form-item label="序号" prop="sortNum">
                    <el-input v-model="ruleForm.sortNum" placeholder="请输入序号" type="number" min="0">
                    </el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                    <el-form-item label="字段长度" prop="fieldLength">
                          <el-select v-model="ruleForm.fieldLength" placeholder="请选择字段长度" clearable>
                            <el-option v-for="item in fieldLength_arr" :label="item" :value="item"></el-option>
                          </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="字段中文名" prop="zhField">
                        <el-input v-model="ruleForm.zhField" placeholder="请输入字段中文名称">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="字段英文名" prop="enField">
                        <el-input v-model="ruleForm.enField" placeholder="请输入字段英文名称">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="字段类型" prop="fieldType">
                          <el-select v-model="ruleForm.fieldType" placeholder="请选择字段类型" clearable>
                            <el-option v-for="item in fieldType_arr" :label="item" :value="item"></el-option>
                          </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="允许为空" prop="isNull">
                        <el-radio class="radio" v-model="ruleForm.isNull" label="0">否</el-radio>
                        <el-radio class="radio" v-model="ruleForm.isNull" label="1">是</el-radio>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="默认值" prop="defaultField">
                        <el-input v-model="ruleForm.defaultField" placeholder="请输入默认值">
                        </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="校验规则" prop="validateRule">
                        <el-input v-model="ruleForm.validateRule" placeholder="请输入校验规则">
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
              <el-col>
                  <el-form-item label="备注" prop="fieldDesc">
                      <el-input type="textarea" placeholder="请输入约束条件/说明" v-model="ruleForm.fieldDesc">
                          <template slot="prepend">备注</template>
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
    <p class="currentTotal">当前页 <span>{{currentTotal}}</span> 条</p>
    <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />
</div>

</template>

<script>

import Pagination from '../../components/Pagination';
import mixin from '../static/tableMixin'
export default {
    name: 'Benchmark',
    mixins: [mixin],
    data() {
        return {
              fieldType_arr: ["VARCHAR","LONG","INT","BIGINT","CHAR","TEXT","DATATIME"],
              fieldLength_arr: [64, 128, 256],
              data: [{
              label: '一级 1',
              children: [{
                label: '二级 1-1',
                value: '1-1',
              }]
            }],
            location: {
              main: '',
              sub: '',
            },
            defaultProps: {
                children: 'children',
                label: 'label',
                value: 'value'
              },
            currentTotal: 0,
            filters: {
                "sSearch": {
                    enField: '',
                    mainType: '',
                    subType: '',
                },
                iDisplayStart: 0,
                iDisplayLength: 20
            },
            dialogFormVisible: false,
            ruleForm: {
                id: '',
                zhField: '',
                enField: '',
                fieldType: '',
                isNull: '1',
                defaultField: '',
                validateRule: '',
                fieldDesc: '',
                sortNum: '',
                fieldLength: ''
            },
            rules: {
              sortNum: [{
                  required: true,
                  message: '请输入序号',
                  trigger: 'change'
              }],
                zhField: [{
                    required: true,
                    message: '请选择中文字段名称',
                    trigger: 'change'
                }],
                enField: [{
                    required: true,
                    message: '请选择英文字段名称',
                    trigger: 'change'
                }],
                fieldType: [{
                    required: true,
                    message: '请输入字段类型',
                    trigger: 'change'
                }],
                isNull: [{
                    required: true,
                    message: '',
                    trigger: 'change'
                }],
            },
            clickType: '',
            formLabelWidth: '120px',
            currentPage: 1,
            visible: false,
            pageSize: 20,
            clickType: '',
            editAllow: true,
            iDisplayLength: 20,
            manyTimes: true,
            formLabelWidth: '120px',
            jobJandler: '',
            thNames: [{
                label: '序号',
                props: 'number',
                width: 80
            }, {
                label: '字段中文名',
                props: 'zhField',
                width: 180
            }, {
                label: '字段英文名',
                props: 'enField',
                width: 160
            }, {
                label: '字段类型',
                props: 'fieldType',
                width: 120
            }, {
                label: '字段长度',
                props: 'fieldLength',
                width: 120
            }, {
                label: '允许为空',
                props: 'isNull',
                width: 100,
            }, {
                label: '默认值',
                props: 'defaultField',
                width: 120
            }, {
                label: '校验规则',
                props: 'validateRule',
                minWidth: 200
            }, {
                label: '备注',
                props: 'fieldDesc',
                width: 140,
            }],
            tableData: [],
            mainMap: [],
            subMap: [],
            total: 1
        }
    },
    watch: {

    },
    components: {
        Pagination
    },
    computed: {

    },
    created(){
      this.getTrees()
    },
    mounted() {
        // this.getDataList()
    },
    methods: {
        getTrees() {
            const _this = this
            this.fetchData('/dataManage/govern/queryCatagoryType', {}, 'get').then(response => {
                if (response.isOk === true) {
                console.log(response);
                let navList = []
                response.data.forEach(function(item, index){
                    let obj = {}
                    obj.label = item.catagoryName
                    obj.value = item.catagoryCode
                    let childList = []
                    item.data.forEach(function(_item, _index){
                    let child = {}
                    child.label = _item.typeName
                    child.value = _item.typeCode
                    childList.push(child)
                    })
                    obj.children = childList
                    navList.push(obj)
                    _this.data = navList
                })
                } else {
                    this.$message.error(response.msg)
                }
            }).then(() => {
            let tree = $(".el-tree")
            let node = tree.children(".el-tree-node:first-child")
            node.get(0).click()
            //默认展开
            node.children(".el-tree-node__children").children(".el-tree-node:first-child").get(0).click()
            }).catch(error => {
            this.$message.error(error)
            });
        },
        getDataList() {
            let _this = this
            let params = {
                sSearch: {
                    mainType: "",
                    subType: "",
                },
                iDisplayStart: 0,
                iDisplayLength: 20
            }
            _this.getList(params)
        },
        getList(params) {
            let _this = this
            this.fetchData('/dataManage/standard/list', params, 'post').then(response => {
                if (response.isOk === true) {
                    let start = (_this.currentPage - 1) * 20 + 1
                    _this.tableData = _this.getter(response.data, start) || []
                    _this.total = response.totalCount
                    _this.currentTotal = _this.tableData.length
                } else {
                    this.$message.error(response.msg)
                }
            }).catch(error => {

            });
        },
        getter(data, start) {
            data.forEach(function(item, index) {
                item.number = start++
                    if (item.defaultField === null) {
                        item.defaultField = "null"
                    }
            })
            console.log("getter后的数据", data);
            return data;
        },

        //根据英文字段名搜索数据
        search() {
            this.currentPage = 1;
            let params = this.filters;
            // if (!this.filters.sSearch.enField || /[\u4e00-\u9fa5]/.test(this.filters.sSearch.enField)) {
            //     this.$confirm('请输入字段英文名', '提示', {
            //         confirmButtonText: '确定', 
            //         showCancelButton: false,               
            //         type: 'warning'
            //     });
            //     return;
            // }
            this.getList(params)
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
        handleClose() {
            this.resetForm('ruleForm')
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        handleAdd() {
            let _this = this
            this.clickType = ''
            this.dialogFormVisible = true
            this.ruleForm = {
                id: '',
                mainType: '',
                subType: '',
                zhField: '',
                enField: '',
                fieldType: '',
                isNull: '0',
                defaultField: '',
                validateRule: '',
                fieldDesc: '',
                fieldLength: ''
            }
        },
        validAdd() {
            let _this = this
            this.ruleForm.isNull = parseInt(this.ruleForm.isNull)
            let params = this.ruleForm
            this.fetchData('/dataManage/standard/save', params, 'post').then(response => {
                if (response.isOk === false) {
                    this.$message.error(response.msg);
                } else {
                    this.$message({
                        type: 'success',
                        message: '新增成功!'
                    });
                    _this.getDataList()
                    this.dialogFormVisible = false
                }
            }).catch(error => {});
        },
        catchType(val, array) {
            let result = ''
            array.forEach(function(item, index) {
                if (parseInt(item.value) === val) {
                    result = item.label
                }
            })
            return result
        },
        handleEdit(index, row) {
            let _this = this
            this.clickType = 'edit'
            this.dialogFormVisible = true
            this.ruleForm = {
                id: row.id,
                zhField: row.zhField,
                enField: row.enField,
                fieldType: row.fieldType,
                isNull: row.isNull.toString(),
                defaultField: row.defaultField,
                validateRule: row.validateRule,
                fieldDesc: row.fieldDesc,
            }
        },
        validEdit() {
            let _this = this
            this.ruleForm.mainType = this.mainId
            this.ruleForm.subType = this.subId
            let params = this.ruleForm
            this.fetchData('/dataManage/standard/update', params, 'post').then(response => {
                if (response.isOk === false) {
                    this.$message.error(response.msg);
                } else {
                    this.$message({
                        type: 'success',
                        message: '修改成功!'
                    });
                    _this.getDataList()
                    this.dialogFormVisible = false
                }
            }).catch(error => {});
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
                this.fetchData('/dataManage/standard/delete', params, 'post').then(response => {
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
        cancel() {
            this.dialogFormVisible = false
        },
        handleCurrentChange(val) {
            let _this = this
            this.currentPage = val;
            let params = {
                "sSearch": {
                    mainType: this.filters.sSearch.mainType,
                    subType: this.filters.sSearch.subType,
                },
                iDisplayStart: (val - 1) * this.pageSize,
                iDisplayLength: 20
            }
            this.getList(params)
        },
        handleNodeClick(data) {
            this.currentPage = 1;
            if (data.children) {
            //如果点击的是一级菜单，能获取mainType，获取不到subType，同时将tableData置为空
            this.filters.sSearch.mainType = data.value
            this.filters.sSearch.subType = ''
            this.location.main = data.label
            this.location.sub = ''
            this.tableData = []
            }
            else {
            //如果点击的是二级菜单，能获取subType，同时组装请求参数去请求页面
            this.filters.sSearch.subType = data.value
            this.location.sub = data.label
            let params = {
                "sSearch": {
                    mainType: this.filters.sSearch.mainType,
                    subType: this.filters.sSearch.subType,
                },
                iDisplayStart: 0,
                iDisplayLength: 20
            }
            this.getList(params)
            }
        },
        //边输入边查询
        EnSearch() {
           this.search(); 
        }
    }
}

</script>
