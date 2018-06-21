<style lang='less'>

@import '../../assets/styles/integrationIndex';
.integration {
    min-width: 1000px;
    .uploadIcon {
        width: 100px;
    }
    .el-dialog {
        min-width: 520px;
    }
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
    <div class="header">
        <el-row>
            <el-col>
                <span class="performer">安装目录</span>
                <el-input v-model="path" placeholder="" style="width:420px;" @keydown.enter.native="comfirm"></el-input>
                <el-button type="primary" @click="comfirm" style="margin-left:10px;">确认</el-button>
                <span class="performer" style="margin-left:10px;">当前安装目录：
                    <el-tag type="success" style="padding:2px 8px 4px 8px; height:30px;" id="list">{{currentPath}}</el-tag>
                  </span>
                <el-button type="primary" @click="upLoad" style="margin-left:10px;">插件上传</el-button>
            </el-col>
        </el-row>
    </div>
    <el-table :data="tableData" border style="width: 100%">
        <el-table-column type="expand">
            <template scope="scope">
                <el-table :data="tableData[scope.$index].pluginsInfo" style="width: 100%">
                    <el-table-column type="expand">
                        <template scope="scoped">
                            <el-table :data="tableData[scope.$index].pluginsInfo[scoped.$index].items" style="width: 100%">
                                
                                <el-table-column v-for="(item, index) in items" :key="index" :label="item.label" :prop="item.props" :width="item.width">
                                    <template scope="scope">
                                        <span v-if="item.props === 'number'" class="">
                                          {{scope.$index + 1}}
                                        </span>
                                        <span v-else>
                                            <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="bottom-start">
                                                <span>{{scope.row[item.props]}}</span>
                                            </el-tooltip>
                                        </span>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </template>
                    </el-table-column>
                    <!-- 第二层 -->
                    <el-table-column v-for="(item, index) in pluginsInfo" :key="index" :label="item.label" :prop="item.props" :width="item.width">
                        <template scope="scope">
                            <span v-if="item.props === 'pluginType'">
                                <span v-if="scope.row[item.props]==='1'" style="color:#67C23A;">
                                    reader
                                </span>
                                <span v-else style="color:#E6A23C;">
                                    writer
                                </span>
                            </span>
                            <span v-else-if="item.props==='type'">
                                {{map.get(scope.row.type.toString())}}
                            </span>
                            <span v-else-if="item.props === 'className'">
                                <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                                    <span>{{scope.row[item.props]}}</span>
                                </el-tooltip>
                            </span>
                            <span v-else-if="item.props === 'description'">
                                <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                                    <span>{{scope.row[item.props]}}</span>
                                </el-tooltip>
                            </span>
                            <span v-else-if="item.props === 'info'">
                                <span class="detail" @click="checkInfo(scope.$index, scope.row)">查看</span>
                            </span>
                            <span v-else>{{scope.row[item.props]}}</span>
                        </template>
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
            </template>
        </el-table-column>
        <el-table-column v-for="(item, index) in thNames" :key="index" :label="item.label" :prop="item.props" :width="item.width">
            <template scope="scope">
                <span v-if="item.props === 'type'">
              <span v-if="scope.row[item.props]==='1'" style="color:#67C23A;">
                reader插件
              </span>
                <span v-else style="color:#E6A23C;">
                writer插件
              </span>
                </span>
                <span v-else-if="item.props === 'className'">
            <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                  <span>{{scope.row[item.props]}}</span>
                </el-tooltip>
                </span>
                <span v-else-if="item.props === 'description'">
            <el-tooltip class="item" effect="dark" :content="scope.row[item.props]" placement="top-start">
                  <span>{{scope.row[item.props]}}</span>
                </el-tooltip>
                </span>
                <span v-else-if="item.props === 'info'">
            <span class="detail" @click="checkInfo(scope.$index, scope.row)">查看</span>
                </span>
                <span v-else>{{scope.row[item.props]}}</span>
            </template>
        </el-table-column>
    </el-table>
    <el-dialog :visible.sync="details">
        <template slot="title"></template>
        <el-row>
            <el-col>
                <el-input type="textarea" v-model="content" :rows="16" readonly></el-input>
            </el-col>
        </el-row>
        <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="details = false">关 闭</el-button>
      </span>
    </el-dialog>
    <el-dialog title="插件上传" :visible.sync="showUpLoad" @close="handleClose">
        <el-row style="margin-top:10px;">
            <el-col :span="12" style="text-align:center;">
                <span class="performer">插件类型</span>
                <el-select v-model="plugType" placeholder="请选择" style="width:160px;">
                    <el-option v-for="item in filters" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="12" style="text-align:center;">
                <el-upload class="upload-demo" ref="upload" :name="fileName" :action="upLoadAction" :on-remove="handleRemove" :multiple="multiple" :on-change="handleChange" :file-list="fileList" :auto-upload="false">
                    <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
                    <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传zip文件</div>
                </el-upload>
            </el-col>
        </el-row>
        <el-row style="text-align:center;" v-show="uploading">
            <el-col>
                <img src="../../assets/uploading_2.gif" alt="上传中..." class="uploadIcon">
            </el-col>
        </el-row>
        <span slot="footer" class="dialog-footer">
        <el-button @click="showUpLoad = false">取 消</el-button>
      </span>
    </el-dialog>


    <el-dialog size="full" :visible.sync="dialogFormVisible" @close="handleCloses">
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
                        <el-table-column prop="number" label="序号" width="80">
                            <template scope="scope" class="">
                                <span class="" >{{scope.$index + 1}}</span>
                            </template>
                        </el-table-column>
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
    name: 'IntergrationPlug',
    mixins: [mixin],
    data() {
        return {
            keyWord: '',
            plugType: '',
            uploading: false,
            dialogFormVisible: false,
            multiple: false,
            map: [],
            types: [],
            pluginTypes: [{
                label: 'reader',
                value: '1'
            }, {
                label: 'writer',
                value: '2'
            }],
            pluginNames: [],
            mapplugType: [],
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
            upLoadData: {
                type: '',
                fileName: '',
            },
            fileName: '',
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            upLoadAction: '/monitor/integration/plugins/fileUpload',
            filters: [{
                label: 'reader插件',
                value: '1',
            }, {
                label: 'writer插件',
                value: '2'
            }],
            upLoadFile: null,
            fileList: [],
            content: '',
            showUpLoad: false,
            details: false,
            path: '/apps/ga-mass-dataetl/dataetl',
            currentPath: '无数据',
            currentPage: 1,
            pageSize: 20,
            clickType: '',
            taskManageForm: false,
            thNames: [{
                    label: '插件名称',
                    props: 'name'
                }, {
                    label: '插件类型',
                    props: 'type'
                }, {
                    label: '插件类',
                    props: 'className',
                }, {
                    label: '描述',
                    props: 'description',
                }, {
                    label: '开发人员',
                    props: 'developer',
                },
                //  {
                //     label: '配置详情',
                //     props: 'info',
                // }
            ],
            tableData: [],
            tableDataFirst: [],
            tableDataLast: [],
            pluginsInfo: [
                //   {
                //     label: '序号',
                //     props: 'number',
                //     width: 80
                // },
                {
                    label: '插件名称',
                    props: 'pluginName',
                }, {
                    label: '插件类型',
                    props: 'pluginType',
                }, {
                    label: '插件配置类型',
                    props: 'type',
                }, {
                    label: '更新时间',
                    props: 'updateTime',
                }, {
                    label: '创建时间',
                    props: 'createTime',
                }
            ],
            items: [
                  {
                    label: '序号',
                    props: 'number',
                    width: 80
                },
                {
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
                    width: 180
                }, {
                    label: '创建时间',
                    props: 'createTime',
                    width: 180
                }
            ],
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
            total: 1
        }
    },
    components: {
        Pagination
    },
    computed: {

    },
    watch: {
        'plugType': function(to) {
            this.upLoadData.type = to
        }
    },
    created() {
        this.getDataList()
        this.getDictionary()
        this.plugTypes()
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

                }
                _this.getList(params)
            },
            getList(params) {
                let _this = this
                this.fetchData('/integration/plugins/query', params, 'get').then(response => {
                    if (response.isOk === true) {
                        _this.tableData = response.data || []
                        _this.total = response.totalCount
                        _this.currentPath = response.data[0].path
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
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
            checkInfo(index, row) {
                this.details = true
                this.content = row.info
            },
            comfirm() {
                let _this = this
                let params = {
                    path: this.path
                }
                this.fetchData('/integration/plugins/add', params, 'post').then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: response.msg
                        });
                        _this.tableData = response.data || []
                        _this.total = response.totalCount
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            handleCurrentChange(val) {},
            upLoad() {
                this.fileList = []
                this.plugType = ''
                this.showUpLoad = true
            },
            handleClose() {
                this.plugType = ''
                this.fileList = []
            },
            submitUpload() {
                let _this = this
                let file = this.upLoadFile
                if (this.plugType === '') {
                    this.$message({
                        showClose: true,
                        message: '请选择插件类型',
                        type: 'warning'
                    });
                } else if (this.fileList.length === 0) {
                    this.$message({
                        showClose: true,
                        message: '请选择插件',
                        type: 'warning'
                    });
                } else {
                    this.uploading = true
                    let _this = this
                    let params = {
                        file: file,
                        type: this.plugType,
                        fileName: this.fileName,
                    }
                    _this.upLoadIntegration('/integration/plugins/fileUpload', params).then(response => {
                        if (response.isOk === true) {
                            this.$message({
                                showClose: true,
                                message: response.msg,
                                type: 'success'
                            });
                            this.showUpLoad = false
                            _this.uploading = false
                        } else {
                            _this.uploading = false
                            _this.fileList = []
                            _this.$message.error(response.msg)
                        }
                    }).catch(error => {
                        _this.$message.error(error)
                    });
                }
            },
            handleChange(file, fileList) {
                this.upLoadFile = file
                let str = file.name
                let lastName = str.substr(str.length - 4, str.length)
                let ret = lastName.split(".")[1]
                if (ret != 'zip') {
                    this.$message({
                        showClose: true,
                        message: '格式错误，只支持后缀名为.zip的文件',
                        type: 'error'
                    });
                    this.fileList = []
                } else {
                    this.fileList = []
                    this.fileList[0] = {
                        name: file.name,
                        url: file.url
                    }
                    this.upLoadData.type = this.plugType
                    this.upLoadData.fileName = file.name
                    this.fileName = file.name
                }
            },
            handleRemove(file, fileList) {
                this.fileList = []
            },
            handleAdd() {
                this.clickType = ''
                this.updateParameter()
                this.dialogFormVisible = true
                this.tableDataLast = []
            },
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
            handleCloses() {
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
            plugTypes() {
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
    }
}

</script>
