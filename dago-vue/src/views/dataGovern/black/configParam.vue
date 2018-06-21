<template>
  <div class="configParam">
    <el-dialog title="参数配置" :visible.sync="configVisible">
      <el-row>
        <el-col style="text-align:right;">
          <el-button type="success" icon="plus" size="small" style="margin-bottom:20px;" @click="addParam">新增参数</el-button>
        </el-col>
      </el-row>
      <div class="cutLine" v-for="(item,index) in params">
        <el-row>
          <el-col style="text-align:right;">
            <el-button type="danger" size="small" class="deleteParam" @click="deleteParam(index)">删除</el-button>
          </el-col>
        </el-row>
          <el-row>
            <el-col class="param-flex" :span="12">
                <span class="label-search" style="margin-left:10px;">参数名</span>
                  <el-input class="input-warp" v-model="item.data"></el-input>
            </el-col>
            <el-col class="param-flex" :span="12">
              <span class="label-search" style="margin-left:10px;">参数值</span>
              <el-input class="input-warp" v-model="item.data"></el-input>
            </el-col>
          </el-row>
        <el-row>
          <el-col class="param-flex" :span="12">
            <span class="label-search" style="margin-left:10px;">展示名</span>
            <el-input class="input-warp" v-model="item.data"></el-input>
          </el-col>
          <el-col class="param-flex" :span="12">
            <span class="label-search" style="margin-left:10px;">实例</span>
            <el-input class="input-warp" v-model="item.data"></el-input>
          </el-col>
        </el-row>
      <el-row>
        <el-col class="param-flex" :span="12">
          <span class="label-search" style="margin-left:10px;">备注</span>
          <el-input class="input-warp" v-model="item.data"></el-input>
        </el-col>
        <el-col class="param-flex" :span="12">
          <span class="label-search" style="margin-left:10px;">排序</span>
          <el-input class="input-warp" v-model="item.data"></el-input>
        </el-col>
      </el-row>
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
  name:'ConfigParam',
  data() {
    return {
      clickType: 'add',
      params: [
        {
          data: 1,
        },
      ],
      ruleForm: {
          region: '',
      },
      rules: {

      },
      configVisible: false
    }
  },
  props: {
    showConfig: {
      type: Boolean,
      default: false
    },
    clickForm: {
      type: String,
      default: 'add'
    },
  },
  watch: {
    'showConfig'(to) {
      this.configVisible = to
    },
    'ruleForm.mac'() {

    },
    'configVisible'(to) {
      if (to) {
      }
      if (to === false) {
        this.params = [
                {
                  data: 1,
                }
              ]
        this.hideDialog()
      }
    },
  },
  mounted() {

  },
  methods: {
    hideDialog() {
      this.$emit('hideDialog', false)
    },
    cancel() {
      this.configVisible = false
      this.hideDialog()
    },
    addParam() {
      let param = {
        data: 1
      }
      this.params.push(param)
    },
    deleteParam(index) {
      this.params.splice(index, index);
    }
  }
}
</script>

<style lang="less" scoped>
.configParam {
  .el-dialog__wrapper {
    overflow: auto !important;
  }
  .cutLine {
    border-top:1px solid #20a0ff;
  }
  .deleteParam {
    margin-top: 10px;
  }
  .input-warp {
    float: right;
    padding-right: 50px;
    max-width:210px;
  }
  .param-flex {
    margin:10px 0;
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-between;
        .label-search {
        font-size: 14px;
        color: #48576a;
        margin: 0px 8px 0px 0px;
        padding-top: 10px;
        white-space:nowrap;
    }
  }


}
</style>
