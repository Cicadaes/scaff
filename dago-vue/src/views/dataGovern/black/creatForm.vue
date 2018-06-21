<template>
  <div class="">
    <el-dialog :title="clickType==='add'?'新增':'编辑'" :visible.sync="dialogVisible">
      <div class="dialog">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-row>
            <el-col :span="12">
              <el-form-item label="黑名单类型" prop="type">
                <el-select v-model="ruleForm.type" placeholder="请选择黑名单类型">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="协议类型" prop="protocol">
                <el-select v-model="ruleForm.protocol" placeholder="请选择协议类型">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
                <el-form-item label="协议值" prop="value">
                  <el-input v-model="ruleForm.value" ref="macFormat" style="max-width:210px;"></el-input>
                </el-form-item>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="关系协议类型" prop="relationProtocol">
                <el-select v-model="ruleForm.relationProtocol" placeholder="请选择关系协议类型">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
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
import Inputmask from "inputmask"
export default {
  data() {
    var validateFormat = (rule, value, callback) => {
    if (value && value.split('_').length !== 1) {
      callback(new Error('输入格式错误'))
    } else {
      callback()
    }
  }
    return {
      clickType: 'add',
      ruleForm: {
        type: '',
        protocol: '',
        value: '',
        relationProtocol: ''
      },
      rules: {
        type: [
          {
            required: true,
            message: '请选择黑名单类型',
            trigger: 'change' }
        ],
        value: [
          {
            required: true,
            message: '请输入协议值',
            trigger: 'change'
          },
          {
            validator: validateFormat,
            trigger: 'blur'
          },
        ],
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
        const _this = this
        setTimeout(function(){
          Inputmask({
            "mask": "**-**-**-**-**-**"
          }).mask(_this.$refs.macFormat.$el.children[0])
        },0)
      }
      if (to === false) {
        this.hideDialog()
      }
    },
    'clickForm'(to) {
      this.clickType = to
    }
  },
  mounted() {

  },
  methods: {
    //

    
    hideDialog() {
      this.$emit('hideDialog', false)
    },
    cancel() {
      this.dialogVisible = false
      this.hideDialog()
    }
  }
}
</script>

<style lang="less">

</style>
