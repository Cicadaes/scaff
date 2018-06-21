<style lang="less">

@import '../../assets/styles/integrationIndex';
.integration {
    min-height: 800px;
    .success {
        color: #13CE66;
    }
    .transfer-footer {
        margin-left: 20px;
        padding: 6px 5px;
    }
    .tableDataForm {
        width: 100%;
        height: 600px;
        text-align: left;
        overflow: auto;
    }
    .el-table:before {
      height: 0;
    }
}

</style>

<template lang="html">

<div class="integration">
    <div style="position: absolute; top: 9px;">
        <el-button type="success" icon="plus" size="small" @click="handleAdd">新增</el-button>
    </div>
    <div class="plugOperation">
        <el-table :data="tableData" style="width: 100%">
            <el-table-column type="expand">
                <template scope="scope">
                    <el-table :data="tableData[scope.$index].items" border stripe>
                        <el-table-column v-for="th in items" :key="th.props" :label="th.label" :prop="th.props" :width="th.width">
                        </el-table-column>
                    </el-table>
                </template>
            </el-table-column>
            <el-table-column label="插件配置类型" prop="type">
                <template scope="scope">
                    {{map.get(scope.row.type.toString())}}
                </template>
            </el-table-column>
            <el-table-column label="插件名称" prop="pluginName">
            </el-table-column>
            <el-table-column label="插件类型" prop="pluginType">
                <template scope="scope">
                    <span v-if="scope.row.pluginType==1">
                      reader
                    </span>
                    <span v-else>
                      writer
                    </span>
                </template>
            </el-table-column>
            <el-table-column label="更新时间" prop="updateTime">
            </el-table-column>
            <el-table-column label="创建时间" prop="createTime">
            </el-table-column>
            <el-table-column prop="operate" label="	操作">
                <template scope="scope" class="operate">
                    <el-button size="small" type="primary" icon="edit" @click='handleEdit(scope.$index,scope.row)'>
                    </el-button>
                    <el-button size="small" type="danger" icon="delete" @click="handleDelete(scope.$index,scope.row)">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
    <el-dialog size="full" :visible.sync="dialogFormVisible" @close="handleClose">
        <template slot="title">{{clickType === 'edit' ? "编辑" : "新增"}}</template>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm task-form">
            <el-row>
                <el-col>
                    <el-form-item label="插件配置类型" :label-width="formLabelWidth" style="display:inline-block;" prop="type">
                        <el-select v-model="ruleForm.type" placeholder="请选择插件配置类型" :disabled="this.clickType===''?false:true">
                            <el-option v-for="item in types" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="插件类型" :label-width="formLabelWidth" style="display:inline-block;" prop="pluginType">
                        <el-select v-model="ruleForm.pluginType" placeholder="请选择插件类型" :disabled="this.clickType===''?false:true">
                            <el-option v-for="item in pluginTypes" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="插件名称" :label-width="formLabelWidth" style="display:inline-block;" prop="pluginName">
                        <el-select v-model="ruleForm.pluginName" placeholder="请选择插件名称" :disabled="this.clickType===''?false:true">
                            <el-option v-for="item in pluginNames" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row style="text-align:center;">
                <el-col :span="11">
                    <el-row>
                        <el-col :span="4">
                            <h4 style="margin: 10px 0px;">参数列表</h4>
                        </el-col>
                        <el-col :span="20">
                            <el-input style="margin: 0px 0px 10px 0px;" v-model="keyWord" @change="updateParameter" placeholder="搜索关键字:参数名称/展示名"></el-input>
                        </el-col>
                    </el-row>
                    <el-table class="tableDataForm" :data="tableDataFirst" @row-dblclick="dblclickAdd">
                        <el-table-column prop="name" label="参数名称" width="120">
                        </el-table-column>
                        <el-table-column prop="displayName" label="展示名" width="120">
                        </el-table-column>
                        <el-table-column prop="value" label="参考值" width="140">
                            <template scope="scope">
                                <el-tooltip class="item" effect="dark" :content="scope.row.value" placement="top-start">
                                    <span>{{scope.row.value}}</span>
                                </el-tooltip>
                            </template>
                        </el-table-column>
                        <el-table-column prop="desc" label="描述信息" min-width="120">
                            <template scope="scope">
                                <el-tooltip class="item" effect="dark" :content="scope.row.desc" placement="top-start">
                                    <span>{{scope.row.desc}}</span>
                                </el-tooltip>
                            </template>
                        </el-table-column>
                        <el-table-column prop="operate" label="操作" min-width="60">
                            <template scope="scope" class="operate">
                                <el-button size="small" type="primary" icon="plus" @click="add(scope.row, scope.$index)">
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-col>
                <el-col :span="1">
                    <div style="opacity:0;">
                        <div style="margin-top:200px;">
                            <el-button :plain="true" type="info" @click="">增加</el-button>
                        </div>
                        <div style="margin-top:30px;">
                            <el-button :plain="true" type="info">删除</el-button>
                        </div>
                    </div>
                </el-col>
                <el-col :span="11">
                    <h4 style="margin: 20px 0px 10px 0px;">参数列表</h4>
                    <el-table class="tableDataForm" :data="tableDataLast" @row-dblclick="dblclickDelete">
                        <el-table-column prop="name" label="参数名称" width="120">
                        </el-table-column>
                        <el-table-column prop="displayName" label="展示名" width="120">
                        </el-table-column>
                        <el-table-column prop="value" label="参考值" width="140">
                            <template scope="scope">
                                <input class="el-input__inner" type="text" name="" v-model="scope.row.value">
                            </template>
                        </el-table-column>
                        <el-table-column prop="desc" label="描述信息" min-width="120">
                            <template scope="scope">
                                <input class="el-input__inner" type="text" name="" v-model="scope.row.desc">
                            </template>
                        </el-table-column>
                        <el-table-column prop="operate" label="	操作" min-width="60">
                            <template scope="scope" class="operate">
                                <el-button size="small" type="danger" icon="delete" @click="handleDeleteTable(scope.$index, scope.row)">
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-col>
            </el-row>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="submitForm('ruleForm')">提 交</el-button>
        </div>
    </el-dialog>
    <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />

</div>

</template>

<script>

import Pagination from '../../components/Pagination';
import mixin from '../static/tableMixin'
export default {
    name: "PlugOperation",
    mixins: [mixin],
    data() {
        return {
            clickType: '',
            keyWord: '',
            dialogTableVisible: false,
            total: 0,
            currentPage: 1,
            pageSize: 20,
            map: [],
            types: [],
            pluginNames: [],
            pluginTypes: [{
                label: 'reader',
                value: '1'
            }, {
                label: 'writer',
                value: '2'
            }],
            mapplugType: [],
            dialogFormVisible: false,
            ruleForm: {
                pluginType: '',
                pluginName: '',
                type: '',
                items: []
            },
            rules: {
                pluginType: [{
                    required: true,
                    message: '请选择插件配置类型',
                    trigger: 'change'
                }],
                type: [{
                    required: true,
                    message: '请选择插件类型',
                    trigger: 'change'
                }],
                pluginName: [{
                    required: true,
                    message: '请选择插件名称',
                    trigger: 'change'
                }],
            },
            formLabelWidth: '120px',
            items: [{
                label: '序号',
                props: 'number',
                width: 80
            }, {
                label: '参数名称',
                props: 'name',
            }, {
                label: '展示名',
                props: 'displayName',
            }, {
                label: '参数值实例',
                props: 'value',
            }, {
                label: '描述信息',
                props: 'desc',
            }, {
                label: '更新时间',
                props: 'updateTime',
            }, {
                label: '创建时间',
                props: 'createTime',
            }],
            thNames: [{
                label: '插件配置类型',
                props: 'type'
            }, {
                label: '插件名称',
                props: 'pluginName'
            }, {
                label: '插件类型',
                props: 'pluginType',
            }, {
                label: '更新时间',
                props: 'updateTime',
            }, {
                label: '创建时间',
                props: 'createTime',
            }],
            tableData: [],

            tableDataFirst: [],
            tableDataLast: [],
        }
    },
    components: {
        Pagination
    },
    created() {
        this.getDictionary()
        this.plugType()
    },
    mounted() {
        this.getDataList()
    },
    watch: {
        'ruleForm.pluginType': function(to) {
            if (to != '') {
                if (this.clickType === '') {
                    this.ruleForm.pluginName = ''
                }
                this.getPlugName(to)
            }
        },
    },
    methods: {
        getDataList() {
                let _this = this
                let params = {
                    start: 0,
                    size: 20
                }
                _this.getList(params)
            },
            //获取列表
            getList(params) {
                let _this = this
                this.fetchData('/integration/item/query', params, 'get').then(response => {
                    if (response.isOk === true) {
                        _this.tableData = _this.getter(response.data) || []
                        _this.total = response.totalCount
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            getter(data) {
                data.forEach(function(item, index) {
                    let start = 1
                    item.items.forEach(function(_item, index) {
                        _item.number = start++
                    })
                })
                return data
            },
            //刷新弹窗左侧表格
            getParameter(params) {
                let _this = this
                this.fetchData('/integration/parameter/search', params, 'post').then(response => {
                    if (response.isOk === true) {
                        _this.tableDataFirst = response.data
                        var storage = window.localStorage
                        storage.setItem("tableDataFirst", JSON.stringify(response.data))
                    }

                }).catch(error => {

                });
            },
            //获取数据字典
            getDictionary() {
                let _this = this
                let params = {
                    type: "30"
                }
                this.fetchData('/integration/dict/type', params, 'post').then(response => {
                    if (response.isOk === true) {
                        let mapArray = []
                        let types = []
                        response.data.forEach(function(item, index) {
                            let arrIn = []
                            arrIn.push(item.value.toString())
                            arrIn.push(item.name)
                            mapArray.push(arrIn)
                            types[index] = {}
                            types[index].label = item.name;
                            types[index].value = item.value;
                        })
                        _this.types = types || []
                        const map = new Map(mapArray)
                        _this.map = map
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            //获取插件名称
            getPlugName(type) {
                let _this = this
                let params = {
                    type: type
                }
                this.fetchData('/integration/plugins/type', params, 'post').then(response => {
                    if (response.isOk === true) {
                        if (type == 1) {
                            let readerOptions = []
                            response.data.forEach(function(item, index) {
                                readerOptions[index] = {}
                                readerOptions[index].label = item.name;
                                readerOptions[index].value = item.name;
                            })
                            _this.pluginNames = readerOptions || []
                        } else {
                            let writer = []
                            response.data.forEach(function(item, index) {
                                writer[index] = {}
                                writer[index].label = item.name;
                                writer[index].value = item.name;
                            })
                            _this.pluginNames = writer || []
                        }
                    }

                }).catch(error => {

                });

            },
            //获取插件类型
            plugType() {
                let _this = this
                let params = {}
                this.fetchData('/integration/plugins/query', params, 'get').then(response => {
                    if (response.isOk === true) {
                        let mapArray = []
                        response.data.forEach(function(item, index) {
                            let arrIn = []
                            arrIn.push(item.value.toString())
                            arrIn.push(item.name)
                            mapArray.push(arrIn)
                        })
                        const map = new Map(mapArray)
                        _this.mapplugType = map
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            handleAdd() {
                this.clickType = ''
                this.updateParameter()
                this.dialogFormVisible = true
                this.tableDataLast = []
            },
            submitForm(formName) {
                let _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if (_this.clickType === '' && _this.ruleForm.items.length != 0) {
                            _this.validAdd()
                        } else {
                            if (this.ruleForm.items.length === 0) {
                                this.$message.error('请选择参数类型')
                                return
                            }
                            _this.validEdit()
                        }
                    } else {
                        return false;
                    }
                });
            },
            //关键字搜索
            updateParameter() {
                let _this = this
                let getParameterParams = {
                    search: "",
                }
                if (_this.keyWord != '') {
                    getParameterParams = {
                        search: _this.keyWord
                    }
                }
                this.getParameter(getParameterParams)
            },
            handleEdit(index, row) {
                this.clickType = 'edit'
                this.dialogFormVisible = true
                this.updateParameter()
                this.ruleForm = {
                    pluginType: row.pluginType.toString(),
                    pluginName: row.pluginName,
                    type: row.type.toString(),
                    items: row.items
                }
                this.tableDataLast = row.items
            },
            //验证成功（新增）
            validAdd() {
                let _this = this
                let params = _this.ruleForm
                this._fetchPost('/integration/item/add', params).then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: response.msg
                        });
                        _this.getDataList()
                        this.dialogFormVisible = false
                    } else {
                        this.$message.error(response.msg);
                    }
                }).catch(error => {});
            },
            //验证成功（编辑）
            validEdit() {
                let _this = this
                let params = _this.ruleForm
                this._fetchPost('/integration/item/edit', params).then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: response.msg
                        });
                        _this.getDataList()
                        this.dialogFormVisible = false
                    } else {
                        this.$message.error(response.msg);
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //删除表格单行数据（主页面）
            handleDelete(index, row) {
                let val = this.currentPage
                let _this = this
                this.$confirm('删除此条数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let params = {
                        type: row.type,
                        pluginType: row.pluginType,
                        pluginName: row.pluginName
                    }
                    this.fetchData('/integration/item/delete', params, 'post').then(response => {
                        if (response.isOk === true) {
                            this.$message({
                                type: 'success',
                                message: response.msg
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
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //弹窗关闭
            handleClose() {
                this.tableDataLast = []
                this.resetForm('ruleForm')
                this.ruleForm = {
                    pluginType: '',
                    pluginName: '',
                    type: '',
                    items: []
                }
                var storage = window.localStorage
                storage.removeItem("tableDataFirst");
                this.getDataList()
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                let params = {
                    start: (val - 1) * this.pageSize,
                    size: 20
                }
                this.getList(params)
            },
            //双击添加
            dblclickAdd(row, event) {
                this.addFunctionCombine(row)
            },
            //单击添加
            add(row, index) {
                this.addFunctionCombine(row)
            },
            addFunctionCombine(row) {
                let _this = this
                if (_this.tableDataLast.length === 0) {
                    _this.tableDataLast.push(row)
                } else {
                    let arr = []
                    _this.tableDataLast.forEach(function(item, index) {
                        arr.push(item.name)
                    })
                    arr.forEach(function(item, index) {
                        if (arr.indexOf(row.name) < 0) {
                            _this.tableDataLast.push(row)
                        }
                    })
                }
                _this.tableDataLast = Array.from(new Set(_this.tableDataLast))
                _this.ruleForm.items = _this.tableDataLast
                var storage = window.localStorage
                let result = JSON.parse(storage.getItem("tableDataFirst"))
                _this.tableDataFirst = result
            },
            //单击删除表单右侧表格单行数据
            handleDeleteTable(index, row) {
                this.tableDataLast.splice(index, 1);
            },
            //双击删除表单右侧表格单行数据
            dblclickDelete(row, event) {
                let arr = []
                this.tableDataLast.forEach(function(item, index) {
                    arr.push(item.name)
                })
                let index = 0;
                for (let i = 0; i < arr.length; i++) {
                    if (row.name === arr[i]) {
                        index = i
                    }
                }
                this.tableDataLast.splice(index, 1);
            },
    }
}

</script>
