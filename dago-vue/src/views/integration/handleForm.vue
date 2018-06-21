<style lang="less">

@import '../../assets/styles/integrationIndex';
// @import '../../assets/jsoneditor/dist/jsoneditor.css';
.Form {
    padding: 20px;
    overflow: hidden;
    position: absolute;
    top: 60px;
    background: #fff;
    z-index: 9999;
    min-width: 1100px;
    margin-top: -15px;
    margin-left:-16px;
    width: 99.6%;
    box-sizing: border-box;
}

.footer {
    float: right;
}

H5 {
    margin: 0px 0px 20px 0px;
}

.off {
    float: right;
    color: #909BA6;
    cursor: pointer;
}

.formTitle {
    margin: 0px 0px 20px 0px;
}

</style>

<template>

<div class="Form animated zoomIn" v-show="showForm">
    <div class="off" @click="cancel">
        <i class="el-icon-close"></i>
    </div>
    <div class="formTitle">{{this.clickType==='edit'? '编辑': '新增'}}</div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <H5>集成配置</H5>
        <el-row v-show="taskNameShow">
            <el-form-item label="任务名称" prop="taskName">
                <el-input v-model="ruleForm.taskName" placeholder="请输入任务名称" readonly></el-input>
            </el-form-item>
        </el-row>
        <el-row>
            <el-row>
                <el-col>
                    <el-form-item label="集成任务名" prop="integrationName">
                        <el-input v-model="ruleForm.integrationName" placeholder=""></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="reader插件" prop="readerName">
                        <el-select v-model="ruleForm.readerName" placeholder="请选择" style="width:400px;">
                            <el-option v-for="item in readerOptions" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="writer插件" prop="writerName">
                        <el-select v-model="ruleForm.writerName" placeholder="请选择" style="width:400px;">
                            <el-option v-for="item in writerOptions" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="reader配置信息" prop="readerInfo">
                        <div id="readerJsonEditor" style="width: 400px; height: 400px;"></div>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="writer配置信息" prop="writerInfo">
                        <div id="writerJsonEditor" style="width: 400px; height: 400px;"></div>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-row>
        <el-row style="margin:10px 0px 10px 10px;">
            <H5 v-show="selectTimeType.type">调度配置</H5>
            <div class="">
                <el-col :span="6" v-show="selectTimeType.type">
                    <el-form-item label="调度类型" prop="timeType">
                        <el-select v-model="timeType" placeholder="请选择" style="max-width:160px;" clearable>
                            <el-option v-for="item in timeTypes" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="6" v-show="selectTimeType.minutes">
                    <span>每</span>
                    <el-select v-model="minute" placeholder="请选择" style="max-width:100px;">
                        <el-option v-for="minute in 59" :key="minute" :label="minute" :value="minute">
                            {{minute}}
                        </el-option>
                    </el-select>
                    <span>分钟执行一次</span>
                </el-col>
                <el-col :span="6" v-show="selectTimeType.hours">
                    <span>每</span>
                    <el-select v-model="hour" placeholder="请选择" style="width:100px;">
                        <el-option v-for="hour in 23" :key="hour" :label="hour" :value="hour">
                            {{hour}}
                        </el-option>
                    </el-select>
                    <span>小时执行一次</span>
                </el-col>
                <el-col :span="6" v-show="selectTimeType.days">
                    <span>每天</span>
                    <el-time-picker v-model="day" :picker-options="{
                selectableRange: '00:00:00 - 23:59:59'
              }" placeholder="任意时间点" @change="changeTime">
                    </el-time-picker>
                    <span>开始执行</span>
                </el-col>
            </div>
            <el-col :span="12" style="margin-left:-10px;">
                <el-form-item label="备注" prop="remarks">
                    <el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="ruleForm.remarks">
                    </el-input>
                </el-form-item>
            </el-col>
        </el-row>
    </el-form>
    <div slot="footer" class="footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submitForm('ruleForm')">确 定</el-button>
    </div>
</div>
</template>
<script>
// import { JSONEditor } from '../../assets/jsoneditor/dist/jsoneditor.js'
import mixin from '../static/tableMixin'
export default {
    name: 'intergrationForm',
    mixins: [mixin],
    data() {
        return {
            taskNameShow: false,
            timeType: '0',
            minute: '',
            hour: '',
            day: new Date(2016, 9, 10, 18, 40),
            date: '',
            formClickType: '',
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
            readerOptions: [],
            writerOptions: [],
            ruleForm: {
                integrationName: '',
                taskName: '',
                readerName: '',
                readerInfo: '',
                writerName: '',
                writerInfo: '',
                remarks: '',
            },
            rules: {
                integrationName: [{
                    required: true,
                    message: '请输入集成源',
                    trigger: 'change'
                }],
                readerName: [{
                    required: true,
                    message: '请选择reader',
                    trigger: 'change'
                }],
                writerName: [{
                    required: true,
                    message: '请选择writer',
                    trigger: 'change'
                }],
            },
            getReaderJson: {},
            getWriterJson: {},
        }
    },
    props: {
        showForm: Boolean,
        clickType: String,
        editRow: Object,
    },
    created() {
        this.getReaderName()
        this.getWriterName()
    },
    mounted() {
      let _this = this
        this.handleReaderJson()
        this.handleWriterJson()
        $(document).keyup(function(event){
        switch(event.keyCode) {
        case 27:
        _this.cancel()
       return;
      }
     });
    },
    watch: {
        'clickType': function(to) {
            if (to === 'edit') {
                this.taskNameShow = true
                this.selectTimeType.minutes = false
                this.selectTimeType.type = false
                this.selectTimeType.hours = false
                this.selectTimeType.days = false
                this.formClickType = to
                this.handleEditRowProps()
            } else {
                this.taskNameShow = false
                this.selectTimeType.minutes = true
                this.selectTimeType.type = true
                this.ruleForm = {
                    integrationName: '',
                    taskName: '',
                    readerName: '',
                    readerInfo: '',
                    writerName: '',
                    writerInfo: '',
                    remarks: '',
                }
                let containerReader = document.getElementById("readerJsonEditor")
                containerReader.innerHTML = ''
                let containerWriter = document.getElementById("writerJsonEditor")
                containerWriter.innerHTML = ''
                this.handleReaderJson()
                this.handleWriterJson()
            }
        },
        'ruleForm.readerName': function() {
            this.readerConfirm()
        },
        'ruleForm.writerName': function() {
            this.writerConfirm()
        },
        'timeType': function(to) {
            switch (to) {
                case '0':
                    this.selectTimeType.minutes = true
                    this.selectTimeType.hours = false
                    this.selectTimeType.days = false
                    break;
                case '1':
                    this.selectTimeType.minutes = false
                    this.selectTimeType.hours = true
                    this.selectTimeType.days = false
                    break;
                case '2':
                    this.selectTimeType.minutes = false
                    this.selectTimeType.hours = false
                    this.selectTimeType.days = true
                    break;
                case '':
                    this.selectTimeType.minutes = false
                    this.selectTimeType.hours = false
                    this.selectTimeType.days = false
                    break;
                default:

            }
        }
    },
    methods: {
        handleEditRowProps() {
                this.ruleForm = this.editRow
            },
            handleReaderJson(readerJson = {}) {
                let container = document.getElementById("readerJsonEditor");
                let options = {};
                let editor = new JSONEditor(container, options);
                this.getReaderJson = editor
                let json = readerJson
                editor.set(json);
            },
            handleWriterJson(writerJson = {}) {
                let container = document.getElementById("writerJsonEditor");
                let options = {};
                let editor = new JSONEditor(container, options);
                this.getWriterJson = editor
                let json = writerJson
                editor.set(json);
            },
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

                });
            },
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

                });
            },
            readerConfirm() {
                let _this = this
                let params = {
                    type: 1,
                    name: this.ruleForm.readerName
                }
                if (this.clickType===''&&params.name!='') {
                  _this.getReaderInfo(params)
                }
                if (this.clickType==='edit') {
                  _this.getReaderInfo(params)
                }
            },
            writerConfirm() {
                let _this = this
                let params = {
                    type: 2,
                    name: this.ruleForm.writerName
                }
                if (this.clickType===''&&params.name!='') {
                  _this.getWriterInfo(params)
                }
                if (this.clickType) {
                  _this.getWriterInfo(params)
                }
            },
            getReaderInfo(params) {
                let _this = this
                this.fetchData('/integration/plugins/info', params, 'post').then(response => {
                    if (response.isOk === true) {
                        let readerJson = JSON.parse(response.data.info)
                        if (this.formClickType === 'edit') {
                            readerJson = JSON.parse(_this.editRow.readerInfo)
                        }
                        let container = document.getElementById("readerJsonEditor");
                        container.innerHTML = ''
                        _this.handleReaderJson(readerJson)
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            getWriterInfo(params) {
                let _this = this
                this.fetchData('/integration/plugins/info', params, 'post').then(response => {
                    if (response.isOk === true) {
                        let writerJson = JSON.parse(response.data.info)
                        if (this.formClickType === 'edit') {
                            writerJson = JSON.parse(_this.editRow.writerInfo)
                            setTimeout(function() {
                              _this.formClickType = ''
                            },300)
                        }
                        let container = document.getElementById("writerJsonEditor");
                        container.innerHTML = ''
                        _this.handleWriterJson(writerJson)
                    } else {
                        this.$message.error(response.msg)
                    }
                }).catch(error => {

                });
            },
            changeTime(date) {
                this.date = date
            },
            submitForm(formName) {
                let _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.ruleForm.readerInfo = _this.getReaderJson.get()
                        this.ruleForm.writerInfo = _this.getWriterJson.get()
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
                this.ruleForm.readerInfo = JSON.stringify(this.ruleForm.readerInfo)
                this.ruleForm.writerInfo = JSON.stringify(this.ruleForm.writerInfo)
                let params = this.ruleForm
                this.fetchData('/integration/tasks/add', params, 'post').then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: '新增成功!'
                        });
                        this.cancel()
                        this.taskManageForm = false
                    } else {
                        this.cancel()
                        this.$message.error(response.msg);
                    }
                }).catch(error => {});
            },
            validEdit() {
                let _this = this
                let params = this.ruleForm
                this.fetchData('/integration/tasks/edit', params, 'post').then(response => {
                    if (response.isOk === true) {
                        this.$message({
                            type: 'success',
                            message: '修改成功!'
                        });
                        _this.taskManageForm = false
                        this.cancel()
                    } else {
                        this.cancel()
                        _this.$message.error(response.msg);
                    }
                }).catch(error => {});
            },
            cancel() {
              this.ruleForm.readerName =''
              this.ruleForm.writerName = ''
              let containerReader = document.getElementById("readerJsonEditor")
              containerReader.innerHTML = ''
              let containerWriter = document.getElementById("writerJsonEditor")
              containerWriter.innerHTML = ''
                this.$root.$emit("offForm", false);
            }
    }
}

</script>
