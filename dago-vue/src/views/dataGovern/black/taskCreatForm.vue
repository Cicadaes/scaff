<template>
  <div class="taskCreatForm">
    <el-dialog :title="clickType==='add'?'新增':'编辑'" :visible.sync="dialogVisible">
      <div class="dialog">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-row>
            <el-col>
              <el-form-item label="任务名称" prop="mac">
                <el-input style="max-width:546px;" v-model="ruleForm.region"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="组件名称" prop="region">
                <el-select v-model="ruleForm.region" placeholder="请选择组件名称">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="任务类型" prop="region">
                <el-select v-model="ruleForm.region" placeholder="请选择任务类型">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="是否复用" prop="region">
                    <el-switch
                      v-model="ruleForm.region"
                      on-color="#13ce66"
                      off-color="#ff4949"
                      on-text="是"
                      off-text="否"
                      on-value="1"
                      off-value="0">
                    </el-switch>
                </el-form-item>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否启用" prop="region">
                  <el-switch
                    v-model="ruleForm.region"
                    on-color="#13ce66"
                    off-color="#ff4949"
                    on-text="开启"
                    off-text="关闭"
                    on-value="1"
                    off-value="0">
                  </el-switch>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="创建者" prop="mac">
                <el-input style="max-width:210px;" v-model="ruleForm.region"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="备注" prop="mac">
                <el-input style="max-width:210px;" v-model="ruleForm.region"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <p style="margin:10px 0px;">调度配置</p>
          <el-row>
            <el-col :span="12">

              <el-form-item label="调度模式" prop="timeType">
                  <el-select v-model="timeType" placeholder="请选择调度模式" clearable>
                      <el-option v-for="item in timeTypes" :key="item.value" :label="item.label" :value="item.value">
                      </el-option>
                  </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12" class="timeSelectTion" v-if="selectTimeType.minutes">
              <el-form-item label="每">
                <div>
                    <el-select v-model="minute" placeholder="请选择" style="max-width:100px;">
                        <el-option v-for="minute in 59" :key="minute" :label="minute" :value="minute">
                            {{minute}}
                        </el-option>
                    </el-select>
                    <span style="margin-left:10px;">分钟执行一次</span>
                </div>
              </el-form-item>
            </el-col>

            <el-col :span="12" v-if="selectTimeType.hours">
            <el-form-item label="每">
                <div>
                    <el-select v-model="hour" placeholder="请选择" style="width:100px;">
                        <el-option v-for="hour in 23" :key="hour" :label="hour" :value="hour">
                            {{hour}}
                        </el-option>
                    </el-select>
                    <span style="margin-left:10px;">小时执行一次</span>
                </div>
          </el-form-item>
        </el-col>

        <el-col :span="12" v-if="selectTimeType.days">
          <el-form-item label="开始执行">
            <div>
                <el-time-picker v-model="day" :picker-options="{
                  selectableRange: '00:00:00 - 23:59:59'
                }" placeholder="任意时间点" @change="changeTime">
                </el-time-picker>
            </div>
          </el-form-item>
        </el-col>
          </el-row>
        </el-form>
      </div>
      <div slot="footer" class="dialog-footer">
          <el-button @click="cancel">取 消</el-button>
          <el-button type="primary">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'TaskCreatForm',
  data() {
    var validateFormat = (rule, value, callback) => {
    if (value && value.split('_').length !== 1) {
      callback(new Error('输入格式错误'))
    } else {
      callback()
    }
  }
    return {
      date: '',
      timeType: '',
      hour: '',
      minute: '',
      day: '',
      timeTypes: [{
          value: '0',
          label: '按分钟'
      }, {
          value: '1',
          label: '按小时',
      }, {
          value: '2',
          label: '按每天'
      }],
      clickType: 'add',
      ruleForm: {
        taskMode: '',
        region: '',
        mac: '',
      },
      rules: {
        region: [
          {
            required: true,
            message: '请选择XXXX',
            trigger: 'change' }
        ],
      },
      selectTimeType: {
          type: '',
          minutes: false,
          hours: false,
          days: false,
      },
      dialogVisible: false
    }
  },
  props: {
    showDialog: {
      type: Boolean,
      default: false
    },
    clickForm: {
      type: String,
      default: 'add'
    },
  },
  watch: {
    'showDialog'(to) {
      this.dialogVisible = to
    },
    'ruleForm.mac'() {

    },
    'dialogVisible'(to) {
      if (to) {
      }
      if (to === false) {
        this.hideDialog()
      }
    },
    'clickForm'(to) {
      this.clickType = to
    },
    'timeType'(to) {
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
  mounted() {

  },
  methods: {
    hideDialog() {
      this.resetForm('ruleForm')
      this.ruleForm = {
        taskMode: '',
        region: '',
        mac: '',
      }
      this.selectTimeType = {
          type: '',
          minutes: false,
          hours: false,
          days: false,
      }
      this.timeType = ''
      this.hour = ''
      this.minute = ''
      this.day = ''
      this.$emit('hideDialog', false)
    },
    cancel() {
      this.dialogVisible = false
      this.hideDialog()
    },
    changeTime(date) {
        this.date = date
    },
    resetForm(formName) {
        this.$refs[formName].resetFields();
    },
  }
}
</script>

<style lang="less" scoped>
.el-dialog__wrapper {
  overflow:visible !important;
}
.taskCreatForm {
  .timeSelectTion {
    display: flex;
    flex-wrap: nowrap;
    justify-content: flex-start;
  }
}

</style>
