<style lang="less">

@import '../../assets/styles/integrationIndex';
@import '../../assets/styles/TaskForm';
.TaskForm {
  .el-dialog__wrapper {
    top:650px !important;
    overflow: hidden;
  }
}
</style>

<template lang="html">

<!-- 变量说明 -->
<!--
  readerTableData -> reader弹窗底部表格
  writerTableData -> writer弹窗底部表格
  readerPlugList -> reader下拉框的数据
  writerPlugList  -> writer下拉框的数据
  handleReaderData -> reader批量处理
  handleWriterData -> writer批量处理
  -->
<div class="TaskForm animated fadeIn" v-show="showForm">
    <div class="off" @click="cancel">
        <i class="el-icon-close"></i>
    </div>
    <div class="data-stable check-standard">
        <h4>{{this.clickType===''?'新增':'编辑'}}</h4>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-row v-show="this.clickType === ''?false:true">
                <el-form-item label="任务名称" prop="taskName">
                    <el-input v-model="ruleForm.taskName" readonly></el-input>
                </el-form-item>
            </el-row>
            <el-row>
                <el-form-item label="集成任务名" prop="integrationName">
                    <el-input v-model="ruleForm.integrationName"></el-input>
                </el-form-item>
            </el-row>
            <el-row>
                <el-form-item label="备注" prop="remarks">
                    <el-input v-model="ruleForm.remarks"></el-input>
                </el-form-item>
            </el-row>
            <div v-show="this.clickType === ''?true:false">
                <el-row>
                    <el-col :span="8" v-show="selectTimeType.type">
                        <el-form-item label="调度模式" prop="timeType">
                            <el-select v-model="timeType" placeholder="请选择调度模式" style="min-width:240px;" clearable>
                                <el-option v-for="item in timeTypes" :key="item.value" :label="item.label" :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="16" v-show="selectTimeType.minutes"z>
                        <div style="padding-left:140px;">
                            <span>每</span>
                            <el-select v-model="minute" placeholder="请选择" style="max-width:100px;">
                                <el-option v-for="minute in 59" :key="minute" :label="minute" :value="minute">
                                    {{minute}}
                                </el-option>
                            </el-select>
                            <span>分钟执行一次</span>
                        </div>
                    </el-col>
                    <el-col :span="16" v-show="selectTimeType.hours">
                        <div style="padding-left:140px;">
                            <span>每</span>
                            <el-select v-model="hour" placeholder="请选择" style="width:100px;">
                                <el-option v-for="hour in 23" :key="hour" :label="hour" :value="hour">
                                    {{hour}}
                                </el-option>
                            </el-select>
                            <span>小时执行一次</span>
                        </div>
                    </el-col>
                    <el-col :span="16" v-show="selectTimeType.days">
                        <div style="padding-left:140px;">
                            <span>每天</span>
                            <el-time-picker v-model="day" :picker-options="{
                    selectableRange: '00:00:00 - 23:59:59'
                  }" placeholder="任意时间点" @change="changeTime">
                            </el-time-picker>
                            <span>开始执行</span>
                        </div>
                    </el-col>
                </el-row>
            </div>
            <div style="text-align:right;">
                <el-button @click="submitForm('ruleForm')" type="primary" style="margin:10px 0px 0px 0px;">提 交</el-button>
            </div>
            <el-tabs class="check-standard" v-model="activeName" type="card" @tab-click="handleClick">
                <el-tab-pane label="reader插件设置" name="reader">
                    <div>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="选择插件" prop="readerName">
                                    <el-select v-model="ruleForm.readerName" placeholder="请选择reader插件" style="width:240px;">
                                        <el-option v-for="item in readerOptions" :key="item.value" :label="item.label" :value="item.value">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="选择配置" prop="readerType">
                                    <el-select v-model="ruleForm.readerType" placeholder="请选择配置类型" style="width:240px;">
                                        <el-option v-for="item in readerTypes" :key="item.value" :label="item.label" :value="item.value">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-form-item v-for="(item,index) in readerPlugList" :key="index" :label="item.displayName" prop="">
                              <template scope="scope">
                                <span v-if="item.name==='encoding'">
                                  <el-select v-model="item.value" placeholder="请选择配置类型" style="width:240px;">
                                      <el-option v-for="_item in dataType" :key="_item.value" :label="_item.label" :value="_item.value">
                                      </el-option>
                                  </el-select>
                                </span>
                                <span v-else>
                                  <el-input v-model="item.value" style="width:240px;"></el-input>
                                </span>
                                <span style="margin-left:30px;">例子：{{item.example}} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   备注: {{item.desc}}</span>

                              </template>
                            </el-form-item>
                        </el-row>
                        <h5>数据核查表</h5>
                        <el-row>
                            <el-col>
                                <div style="text-align:right;">
                                    <el-button @click="" type="primary" size="small" style="margin:10px 0px;" @click="readExample">读取样例</el-button>
                                </div>
                            </el-col>
                        </el-row>
                        <div class="">
                            <el-table :data="baseData" border style="width: 100%">
                              <el-table-column v-for="item in baseNames"
                              :key="item.value"
                              :label="item.label"
                              :prop="item.props"
                              :width="item.width">
                              </el-table-column>
                            </el-table>
                        </div>

                        <h5></h5>
                        <h5>新增数据表</h5>
                        <div style="text-align:right;">
                          <span class="el-form-item__label" style="float:none;">数据类型：</span>
                          <el-select v-model="valueB" clearable placeholder="请选择大类">
                            <el-option
                              v-for="item in typeB"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value">
                            </el-option>
                            </el-select>
                            <el-select v-model="valueS" clearable placeholder="请选择小类">
                              <el-option
                                v-for="item in typeS"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                              </el-option>
                              </el-select>
                            <el-button @click="" type="default" style="margin:10px 0px;" @click="confirmExample">抽取字段配置</el-button>
                            <!-- <el-button type="primary" @click="adWriterName" style="margin:10px 0px;">数据字段名<i class="el-icon-plus"></i></el-button> -->
                            <el-button @click="tableDataAdd" type="success" style="margin:10px 0px;">新增行<i class="el-icon-plus"></i></el-button>
                        </div>
                        <el-table :data="readerTableData" border style="width: 100%">
                            <el-table-column v-for="item in thNames" :key="item.value" :label="item.label" :prop="item.props" :sortable="item.sort" :width="item.width">
                                <template scope="scope" class="operate">
                                    <span v-if="item.props === 'name'">
                                      <input class="el-input__inner" type="text" name="" v-model="scope.row.name">
                                  </span>
                                    <span v-else-if="item.props === 'index'">
                                    <input class="el-input__inner" type="text" name="" v-model="scope.row.index">
                                  </span>
                                  <span v-else-if="item.props === 'defaultValue'">
                                    <input class="el-input__inner" type="text" name="" v-model="scope.row.defaultValue">
                                  </span>
                                    <span v-else-if="item.props === 'changeType'" class="detail">
                                  <el-select v-model="scope.row.changeType" placeholder="选择类型" clearable>
                                     <el-option
                                       v-for="item in options"
                                       :key="item.value"
                                       :label="item.label"
                                       :value="item.value">
                                     </el-option>
                                   </el-select>
                                </span>
                                <!-- 输入框和选项切换 -->
                                <span v-else-if="item.props === 'writerName'">
                                <!-- <input class="el-input__inner" type="text" name="" v-model="scope.row.writerName"> -->
                                <el-select v-model="scope.row.writerName" placeholder="请选择" clearable>
                                   <el-option
                                     v-for="(item, index) in enFields"
                                     :key="index"
                                     :label="item.label"
                                     :value="item.value">
                                   </el-option>
                                 </el-select>

                                </span>
                                    <span v-else>{{scope.row[item.props]}}</span>
                                </template>
                            </el-table-column>
                            <el-table-column prop="operate" label="	操作" width="120">
                                <template scope="scope" class="operate">
                                    <el-button size="small" type="danger" icon="delete" @click="deleteReader(scope.$index, scope.row)">
                                    </el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="writer插件设置" name="writer">
                    <div>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="选择插件" prop="writerName">
                                    <el-select v-model="ruleForm.writerName" placeholder="请选择writer插件" style="width:240px;">
                                        <el-option v-for="item in writerOptions" :key="item.value" :label="item.label" :value="item.value">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="选择配置" prop="writerType">
                                    <el-select v-model="ruleForm.writerType" placeholder="请选择配置类型" style="width:240px;">
                                        <el-option v-for="item in writerTypes" :key="item.value" :label="item.label" :value="item.value">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-form-item v-for="(item,index) in writerPlugList" :key="index" :label="item.displayName" prop="">
                                <el-input v-model="item.value" placeholder="" style="width:240px;"></el-input>
                                <span style="margin-left:30px;">例子：{{item.example}} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   备注: {{item.desc}}</span>
                            </el-form-item>
                        </el-row>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </el-form>
    </div>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      size="small">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
</div>

</template>

<script>

import mixin from '../static/tableMixin'

export default {
    name: 'TaskForm',
    mixins: [mixin],
    data() {
        return {
            dataType: [
              {
                  value: 'iso-8859-1',
                  label: 'iso-8859-1'
              },
              {
                  value: 'GBK',
                  label: 'GBK'
              },
              {
                  value: 'UniCode',
                  label: 'UniCode'
              },
              {
                  value: 'UTF-8',
                  label: 'UTF-8'
              },
              {
                  value: 'ANSI',
                  label: 'ANSI'
              }
            ],
            dialogVisible: false,
            baseData: [],
            baseNames: [
              {
                props: 'index',
                label: '字段索引',
              },
              {
                props: 'name',
                label: '源字段名',
              },
              {
                props: 'value1',
                label: '记录一',
              },
              {
                props: 'value2',
                label: '记录二',
              },
              {
                  props: 'value3',
                  label: '记录三',
              }
          ],
            handleReaderData: '',
            handleWriterData: '',
            readerTypes: [],
            writerTypes: [],
            readerPlugList: [],
            writerPlugList: [],
            timeType: '',
            minute: '',
            hour: '',
            day: new Date(2016, 9, 10, 18, 40),
            date: '',
            readerClickType: '',
            writerClickType: '',
            selectTimeType: {
                type: true,
                minutes: true,
                hours: false,
                days: false,
            },
            timeTypes: [{
                value: '0',
                label: '按分钟'
            }, {
                value: '1',
                label: '按小时',
            }, {
                value: '2',
                label: '按天'
            }],
            ruleForm: {
                taskName: '',
                time: '',
                timeType: '',
                readerType: '',
                writerType: '',
                integrationName: '',
                readerName: '',
                writerName: '',
                remarks: '',
            },
            rules: {
                integrationName: [{
                    required: true,
                    message: '请输入集成任务名',
                    trigger: 'change'
                }],
                readerName: [{
                    required: true,
                    message: '请选择reader插件',
                    trigger: 'change'
                }],
                writerName: [{
                    required: true,
                    message: '请选择writer插件',
                    trigger: 'change'
                }],
                readerType: [{
                    required: true,
                    message: '请选择reader配置类型',
                    trigger: 'change'
                }],
                writerType: [{
                    required: true,
                    message: '请选择writer配置类型',
                    trigger: 'change'
                }],
            },
            readerOptions: [],
            writerOptions: [],
            activeName: 'reader',
            options: [],
            enFields: [],
            thNames: [{
                label: '序号',
                props: 'number',
                width: 80
                },{
                    label: '字段索引',
                    props: 'index',
                },{
                    label: '源字段名',
                    props: 'name',
                },{
                    label: '默认值',
                    props: 'defaultValue',
                },{
                    label: '转换类型',
                    props: 'changeType',
                },{
                    label: '目标字段名',
                    props: 'writerName',
                  }],
            readerTableData: [],
            typeB: [],
            typeS: [],
            valueB: '',
            valueS: ''
        };
    },
    props: {
        showForm: Boolean,
        clickType: String,
        editRow: Object,
    },
    watch: {
        //加序号
        'readerTableData': function(to) {
            to.forEach(function(item, index) {
                item.number = index + 1
            })
        },
        'clickType': function(to) {
            if (to === 'edit') {
                this.selectTimeType.minutes = false
                this.selectTimeType.type = false
                this.selectTimeType.hours = false
                this.selectTimeType.days = false
                    //保证执行顺序
                this.readerClickType = to
                this.writerClickType = to
                this.handleEditRowProps()
            } else {
                //新增时表单重置
                this.selectTimeType.minutes = true
                this.selectTimeType.type = true
                this.ruleForm = {
                    time: '',
                    timeType: '',
                    readerType: '',
                    writerType: '',
                    integrationName: '',
                    readerName: '',
                    writerName: '',
                    remarks: '',
                }
                this.timeType = ''
                this.readerTableData = []
                this.writerTableData = []
                this.readerPlugList = []
                this.writerPlugList = []
                this.handleReaderData = ''
                this.handleWriterData = ''
            }
        },
        'ruleForm.readerName': function(to) {
            if (this.ruleForm.readerName != '' && to != undefined) {
                this.checkPlugReader()
            }
        },
        'ruleForm.readerType': function(to) {
            if (this.ruleForm.readerType != '' && to != undefined) {
                this._checkPlugReader()
            }

        },
        'ruleForm.writerName': function(to) {
            if (this.ruleForm.writerName != '' && to != undefined) {
                this.checkPlugWriter()
            }

        },
        'ruleForm.writerType': function(to) {
            if (this.ruleForm.writerType != '' && to != undefined) {
                this._checkPlugWriter()
            }

        },
        'timeType': function(to) {
            switch (to) {
                case '0':
                    this.selectTimeType = {
                        type: true,
                        minutes: true,
                        hours: false,
                        days: false,
                    }
                    break;
                case '1':
                    this.selectTimeType = {
                        type: true,
                        minutes: false,
                        hours: true,
                        days: false,
                    }
                    break;
                case '2':
                    this.selectTimeType = {
                        type: true,
                        minutes: false,
                        hours: false,
                        days: true,
                    }
                    break;
                case '':
                    this.selectTimeType = {
                        type: true,
                        minutes: false,
                        hours: false,
                        days: false,
                    }
                    break;
                default:

            }
        }
    },
    created() {
        this._getDictionary()
        this.getDictionary()
        this.getReaderName()
        this.getWriterName()
        this.SgetDictType()
        this.BgetDictType()
    },
    mounted() {
        let _this = this
        $(".check-standard").css({
            minHeight: $(window).height() - 160
        })
        $(".el-tabs__content").css({
            minHeight: $(window).height() - 260
        })
        $(document).keyup(function(event) {
            switch (event.keyCode) {
                case 27:
                    _this.cancel()
                    return;
            }
        })
    },
    methods: {
        handleEditRowProps() {
                let _this = this
                this.ruleForm = this.editRow
                this.readerPlugList = this.editRow.reader.parameter
                this.readerTableData = this.editRow.reader.columns
                this.writerPlugList = this.editRow.writer.parameter
                this.writerTableData = this.editRow.writer.columns
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
                        if (_this.readerPlugList.length === 0) {
                            _this.activeName = 'reader'
                        }
                        if (_this.writerPlugList.length === 0) {
                            _this.activeName = 'writer'
                        }
                        return false;
                    }
                });
            },
            //验证通过（新增）
            validAdd() {
                let _this = this
                let timeType = this.timeType
                let time = ''
                switch (timeType) {
                    case '0':
                        time = this.minute
                        break;
                    case '1':
                        time = this.hour
                        break;
                    case '2':
                        time = this.date
                        break;
                    default:

                }
                this.ruleForm.time = time
                this.ruleForm.timeType = timeType
                let params = {
                    "integrationName": this.ruleForm.integrationName,
                    "readerName": this.ruleForm.readerName,
                    "writerName": this.ruleForm.writerName,
                    "readerType": this.ruleForm.readerType,
                    "writerType": this.ruleForm.writerType,
                    "remarks": this.ruleForm.remarks,
                    "timeType": this.ruleForm.timeType,
                    "time": this.ruleForm.time,
                    "reader": {
                        "parameter": this.readerPlugList,
                        "columns": this.readerTableData
                    },
                    "writer": {
                        "parameter": this.writerPlugList,
                    }
                }
                this._fetchPost('/integration/tasks/addNew', params).then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: response.msg
                        });
                        _this.cancel()
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //验证通过（编辑）
            validEdit() {
                let _this = this
                let params = {
                    "id": this.ruleForm.id,
                    "taskId": this.ruleForm.taskId,
                    "taskName": this.ruleForm.taskName,
                    "integrationName": this.ruleForm.integrationName,
                    "readerName": this.ruleForm.readerName,
                    "writerName": this.ruleForm.writerName,
                    "readerType": this.ruleForm.readerType,
                    "writerType": this.ruleForm.writerType,
                    "remarks": this.ruleForm.remarks,

                    "reader": {
                        "parameter": this.readerPlugList,
                        "columns": this.readerTableData
                    },
                    "writer": {
                        "parameter": this.writerPlugList,
                    }
                }
                this._fetchPost('/integration/tasks/editNew', params).then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: response.msg
                        });
                        _this.cancel()
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //获取转换类型
            _getDictionary() {
                let _this = this
                let params = {
                    type: "40"
                }
                this.fetchData('/integration/dict/type', params, 'post').then(response => {
                    if (response.isOk === true) {
                        let types = []
                        response.data.forEach(function(item, index) {
                            types[index] = {}
                            types[index].label = item.name;
                            types[index].value = item.value;
                        })
                        _this.options = types || []

                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //根据大小类获取目标字段名
            getTypeName(params) {
              let _this = this

              this.fetchData('/dataManage/standard/queryAll', params, 'post').then(response => {
                let enFields = []
                  if (response.isOk === true) {
                    response.data.forEach(function(item, index) {
                      enFields[index] = {}
                      enFields[index].label = item.enField;
                      enFields[index].value = item.enField;
                    })
                    _this.enFields = enFields || []
                  } else {
                      this.$message.error(response.msg)
                  }
              }).catch(error => {

              });
            },
            //获取reader插件配置类型
            _checkPlugReader() {
                let _this = this
                let params = {
                    type: this.ruleForm.readerType,
                    pluginType: 1,
                    pluginName: this.ruleForm.readerName
                }
                this.fetchData('/integration/item/queryPluginItem', params, 'post').then(response => {
                    if (response.isOk === true) {
                        if (response.data.length === 0) {
                            this.$message({
                                showClose: true,
                                message: '未查询到相关数据'
                            });
                            this.readerPlugList = []
                        } else {
                            if (_this.readerClickType === 'edit') {
                                _this.readerPlugList = _this.editRow.reader.parameter
                                setTimeout(function() {
                                    _this.readerClickType = ''
                                }, 300)
                            } else {
                                _this.readerPlugList = response.data
                            }
                        }
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //获取reader插件选择列表
            checkPlugReader() {
                let _this = this
                let params = {
                    pluginType: 1,
                    pluginName: this.ruleForm.readerName
                }
                this.fetchData('/integration/dict/queryByPlugin', params, 'post').then(response => {
                    if (response.isOk === true) {
                        if (response.data.length === 0) {
                            this.$message({
                                showClose: true,
                                message: '未查询到相关数据'
                            });
                            _this.ruleForm.readerType = ''
                            _this.readerPlugList = []
                        } else {
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
                            if (_this.readerClickType === 'edit') {
                                _this.ruleForm.readerType = _this.editRow.readerType
                            } else {
                                _this.ruleForm.readerType = ''
                                _this.readerPlugList = []
                                _this.readerTypes = types || []
                            }
                            const map = new Map(mapArray)
                            _this.map = map
                        }

                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //获取writer插件配置类型
            _checkPlugWriter() {
                let _this = this
                let params = {
                    type: this.ruleForm.writerType,
                    pluginType: 2,
                    pluginName: this.ruleForm.writerName
                }
                this.fetchData('/integration/item/queryPluginItem', params, 'post').then(response => {
                    if (response.isOk === true) {
                        if (response.data.length === 0) {
                            this.$message({
                                showClose: true,
                                message: '未查询到相关数据'
                            });
                            this.writerPlugList = []
                        } else {
                            if (_this.writerClickType === 'edit') {
                                _this.writerPlugList = _this.editRow.writer.parameter
                                setTimeout(function() {
                                    _this.writerClickType = ''
                                }, 300)
                            } else {
                                _this.writerPlugList = response.data
                            }
                        }
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                        this.$message.error(error)
                });
            },
            //获取writer插件选择列表
            checkPlugWriter() {
                let _this = this
                let params = {
                    pluginType: 2,
                    pluginName: this.ruleForm.writerName
                }
                this.fetchData('/integration/dict/queryByPlugin', params, 'post').then(response => {
                    if (response.isOk === true) {
                        if (response.data.length === 0) {
                            this.$message({
                                showClose: true,
                                message: '未查询到相关数据'
                            });
                            _this.ruleForm.writerType = ''
                            _this.writerPlugList = []
                        } else {
                            let types = []
                            response.data.forEach(function(item, index) {
                                types[index] = {}
                                types[index].label = item.name;
                                types[index].value = item.value;
                            })
                            if (_this.writerClickType === 'edit') {
                                _this.ruleForm.writerType = _this.editRow.writerType
                            } else {
                                _this.ruleForm.writerType = ''
                                _this.writerPlugList = []
                            }
                            _this.writerTypes = types || []
                        }
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                        this.$message.error(error)
                });
            },

            //获取配置类型
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
                        _this.readerTypes = types || []
                        _this.writerTypes = types || []
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //获取reader插件名称列表
            getReaderName() {
                let _this = this
                let params = {
                    type: 1
                }
                this.fetchData('/integration/plugins/type', params, 'post').then(response => {
                    let readerOptions = []
                    response.data.forEach(function(item, index) {
                        readerOptions[index] = {}
                        readerOptions[index].label = item.name;
                        readerOptions[index].value = item.name;
                    })
                    _this.readerOptions = readerOptions || []
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            //获取writer插件名称列表
            getWriterName() {
                let _this = this
                let params = {
                    type: 2
                }
                this.fetchData('/integration/plugins/type', params, 'post').then(response => {
                    let writer = []
                    response.data.forEach(function(item, index) {
                        writer[index] = {}
                        writer[index].label = item.name;
                        writer[index].value = item.name;
                    })
                    _this.writerOptions = writer || []
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //表单表格reader新增
            tableDataAdd() {
              const _this = this
              let valueB = this.valueB
              let valueS = this.valueS
              if(valueB==='' || valueS===''){
                _this.$message({
                message: '请先选择大小类',
                type: 'warning'
              });
              return
              }
              else {
                let i = this.readerTableData.length + 1;
                let newData = {
                    number: i++,
                    name: '',
                    index: '',
                    defaultValue: '',
                    changeType: '',
                    writerName: '',
                }
                this.readerTableData.push(newData)
              }
              let params = {
                      mainType: this.valueB,
                      subType: this.valueS,
              }
              this.getTypeName(params)
            },
            //element时间格式处理
            changeTime(date) {
                this.date = date
            },
            //表单关闭表单重置
            cancel() {
                this.resetForm('ruleForm')
                this.ruleForm = {
                    time: '',
                    timeType: '',
                    readerType: '',
                    writerType: '',
                    integrationName: '',
                    readerName: '',
                    writerName: '',
                    remarks: '',
                }
                this.timeType = ''
                this.readerTableData = []
                this.readerPlugList = []
                this.writerPlugList = []
                this.baseData = [],
                this.handleReaderData = ''
                this.handleWriterData = ''
                this.activeName = 'reader'
                this.$root.$emit("offTaskForm", false);
            },

            handleClick(tab, event) {
                console.log(tab, event);
            },
            //表单reader表格删除单行
            deleteReader(index, row) {
                this.readerTableData.splice(index, 1);
            },
            readExample() {
              let _this = this
              let params = {
                readerName: this.ruleForm.readerName,
                readerType: this.ruleForm.readerType
              }
              this.readerPlugList.forEach(function (item,index) {
                  params[item.name] = item.value
              })
              this._fetchPost('/integration/tasks/readerExample', params, 'post').then(response => {
                if(response.isOk === true){
                  response.data.forEach(function(item,index) {
                    if(item.name==null){
                      item.name = 'null'
                    }
                  })
                  _this.$message({
                      type: 'success',
                      message: response.msg
                  });
                  _this.baseData = response.data;
                }
                else {
                  _this.$message({
                      type: 'info',
                      message: response.msg
                  });
                }
              }).catch(error => {
                this.$message.error(error)
              });
            },
            confirmExample() {
              let _this = this
              if(_this.valueB !='' && _this.valueS!=''){
                this.$confirm('此操作将清空当前表格数据, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    _this.readerTableData = []
                    let i = this.readerTableData.length + 1;
                    _this.baseData.forEach(function(item, index) {
                      let newData = {
                          number: i++,
                          name: item.name,
                          index: item.index,
                          defaultValue: '',
                          changeType: '',
                          writerName: '',
                      }
                      _this.readerTableData.push(newData)
                    })
                    let params = {
                            mainType: this.valueB,
                            subType: this.valueS,
                    }
                    this.getTypeName(params)
                }).catch(() => {
                    _this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
              }
              else {
                _this.$message({
                message: '请先选择大小类',
                type: 'warning'
              });
              }
            },
            BgetDictType() {
                let _this = this
                let params = {
                    dictType: "collection_system_source"
                }
                this.fetchData('/sysMonitor/dict/collection_system_source', params, 'get').then(response => {
                    let rankOneOptions = []
                    response.data.forEach(function(item, index) {
                        rankOneOptions[index] = {}
                        rankOneOptions[index].label = item.value;
                        rankOneOptions[index].value = item.name;
                    })
                    _this.typeB = rankOneOptions || []
                }).catch(error => {
                    this.$message.error(error)
                });
            },
            SgetDictType() {
                let _this = this
                let params = {
                    dictType: "sys_source_sub_type"
                }
                this.fetchData('/sysMonitor/dict/sys_source_sub_type', params, 'get').then(response => {
                    let rankTwoOptions = []
                    response.data.forEach(function(item, index) {
                        rankTwoOptions[index] = {}
                        rankTwoOptions[index].label = item.value;
                        rankTwoOptions[index].value = item.name;
                    })
                    _this.typeS = rankTwoOptions || []
                }).catch(error => {
                   this.$message.error(error)
                });
            },
            adWriterName() {
              this.dialogVisible = true
            },
    }
};

</script>
