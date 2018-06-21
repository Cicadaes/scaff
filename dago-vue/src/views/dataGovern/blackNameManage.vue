<template>
  <div class="data-type blackNameManage">
    <div style="position: absolute; top: 8px;">
        <el-button type="success" icon="plus" size="small" @click="handleAdd">新增</el-button>
    </div>
    <el-form :inline="true" label-width="80px" class="searchForm">
        <span class="label-search" style="margin-left:10px;">黑名单类型</span>
        <el-form-item prop="type">
          <el-select v-model="filterForm.sSearch.type" placeholder="请选择" clearable>
            <el-option v-for="item in blacklist_rule" :key="item.name" :label="item.value" :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <span class="label-search" style="margin-left:10px;">发现规则</span>
        <el-form-item prop="rule">
          <el-select v-model="filterForm.sSearch.rule" placeholder="请选择" clearable>
            <el-option v-for="item in blacklist_type" :key="item.name" :label="item.value" :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <span class="label-search" style="margin-left:10px;">协议类型</span>
        <el-form-item prop="protocol">
          <el-select v-model="filterForm.sSearch.protocol" placeholder="请选择" clearable>
            <el-option v-for="item in auth_type" :key="item.name" :label="item.value" :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <span class="label-search" style="margin-left:10px;">关系协议类型</span>
        <el-form-item prop="relationProtocol">
          <el-select v-model="filterForm.sSearch.relationProtocol" placeholder="请选择" clearable>
            <el-option v-for="item in auth_type" :key="item.name" :label="item.value" :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <span class="label-search" style="margin-left:10px;">协议值</span>
        <el-form-item prop="value">
          <el-input ref="valueFormat02" v-model.trim="filterForm.sSearch.value" placeholder="" style="width:120px;"></el-input>
        </el-form-item>
        <el-button type="primary" @click="search" style="margin-left:10px;height:36px;">搜索</el-button>
    </el-form>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column v-for="(conlumn, index) in tableColumn" :key="index" :prop="conlumn.props" :label="conlumn.label">

      </el-table-column>
      <el-table-column
      prop="operate"
      label="操作"
      width="180">
      <template scope="scope" class="operate">
        <!-- <el-button size="small" type="primary" icon="edit" @click="handleEdit">
        </el-button> -->
        <el-button size="small" type="danger" icon="delete" @click="handleDelete(scope.$index, scope.row)">
        </el-button>
      </template>
    </el-table-column>
    </el-table>
    <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />
    <!-- <model-black :clickForm="clickType" :showDialog="dialogVisible" @hideDialog="hideDialog"/> -->

    <!-- 新增-表单 -->
    <template>
      <div class="">
        <el-dialog :title="clickType==='add'?'新增':'编辑'" :visible.sync="dialogVisible" @close="handleClose">
          <div class="dialog">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="黑名单类型" prop="type">
                    <el-select v-model="ruleForm.type" placeholder="请选择黑名单类型">
                      <el-option v-for="item in blacklist_rule" :key="item.name" :label="item.value" :value="item.name">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="协议类型" prop="protocol">
                    <el-select v-model="ruleForm.protocol" placeholder="请选择协议类型">
                      <el-option v-for="item in auth_type" :key="item.name" :label="item.value" :value="item.name">
            </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                    <el-form-item label="协议值" prop="value">
                      <el-input v-model="ruleForm.value" ref="valueFormat01" style="max-width:210px;"></el-input>
                    </el-form-item>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="关系协议类型" prop="relationProtocol">
                    <el-select v-model="ruleForm.relationProtocol" placeholder="请选择关系协议类型">
                      <el-option v-for="item in auth_type" :key="item.name" :label="item.value" :value="item.name">
            </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
          <div slot="footer" class="dialog-footer">
              <el-button @click="cancel">取 消</el-button>
              <el-button type="primary" @click="submitForm('ruleForm')">确 定</el-button>
          </div>
        </el-dialog>
      </div>
    </template>

  </div>
</template>
<script>
import Pagination from '../../components/Pagination';
// import modelBlack from "./black/creatForm";
import mixin from '../static/tableMixin'
import Inputmask from "inputmask"
import axios from 'axios'
export default {
  mixins: [mixin],
  data() {
    var validateFormat = (rule, value, callback) => {
      if (value && value.split('_').length !== 1) {
        callback(new Error('输入格式错误'))
      } else {
        callback()
      }
    };
    return {
      //分页时的请求字段
      // params: {
      //   sSearch:"{}",
      //   iDisplayStart: 0,
      //   iDisplayLength: 20
      // },

      //新增时的请求字段
      ruleForm: {
        type:"",
        rule:"",
        value:"",
        protocol:"",
        relationProtocol:""
      },

      //查询时的请求字段
      filterForm: {
        "sSearch": {
          type:"",
          rule:"",
          value:"",
          protocol:"",
          relationProtocol:""
        },
        "iDisplayLength": 20      
      },

      currentPage: 1,//当前页码

      //黑名单类别
      blacklist_rule:[],

      //发现规则类别
      blacklist_type:[],

      //协议类型或关系协议类型
      auth_type:[],

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

      dialogVisible: false,
      clickType: 'add',
      pageSize: 20,
      total: 1,
      tableColumn: [
        {
          props: 'number',
          label: '序号',
        },
        {
          props: 'type',
          label: '黑名单类型',
        },
        {
          props: 'rule',
          label: '发现规则',
        },
        {
          props: 'protocol',
          label: '协议类型',
        },
        {
          props: 'value',
          label: '协议值',
        },
        {
          props: 'relationProtocol',
          label: '关系协议类型',
        },
        {
          props: 'foundTime',
          label: '发现时间',
        },
        {
          props: 'updateTime',
          label: '更新时间',
        },
      ],
      tableData: []
    }
  },
  components: {
    Pagination,
    // 'model-black':modelBlack
  },

  created () {
    
    //取到黑名单类别 
    this.getType("blacklist_rule")

    //取到发现规则类别 
    this.getType("blacklist_type")

    //取到协议类型或关系协议类型
    this.getType("auth_type")

    this.getDataList();  
  },

  mounted() {
    Inputmask({
      "mask": "**-**-**-**-**-**"
    }).mask(this.$refs.valueFormat02.$el.children[0])

  },

  watch: {
    'dialogVisible'(to) {
      if (to) {
        const _this = this
        setTimeout(function(){
          Inputmask({
            "mask": "**-**-**-**-**-**"
          }).mask(_this.$refs.valueFormat01.$el.children[0])
        },0)
      }
    }
  },

  methods: {
    //取到类别,并赋值给对应的类别数组
    getType(typeName) {
      let _this = this
      let params = typeName
      axios.get('/monitor/sysMonitor/dict/'+ params +'').then(res => {
        if(res.data.isOk === true) {
          _this[typeName] = res.data.data
          console.log(typeName, _this[typeName])
        } else {
          _this.$message.error(res.data.msg);
        }
      })
    },

    //请求后台数据
    getList(params) {    
      let _this = this;  
      this._fetchPost('/dataManage/govern/blacklist', params, "post").then(res => {
        if (res.isOk === true) {
          let start = (_this.currentPage - 1) * 20 + 1;
          _this.tableData = _this.getter(res.data, start) || [];
          //将type替换为中文名称
          let arr = _this.blacklist_rule
          console.log("黑名单类型",arr)
          
          // _this.tableData.forEach(item => {

          // })    
          _this.total = res.totalCount
          // console.log(_this.total)
          _this.currentTotal = _this.tableData.length
        }    
      }).catch(error => {});
    },

    //为数据增加序号
    getter(data, start) {
        data.forEach(function(item, index) {
            item.number = start++
                if (item.defaultField === null) {
                    item.defaultField = "null"
                }
        })
        return data;
    },

    cancel() {
      this.dialogVisible = false
    },

    handleAdd() {
      this.dialogVisible = true;
      this.clickType = 'add';
      this.ruleForm = {
        type:"",
        rule:"",
        value:"",
        protocol:"",
        relationProtocol:""
      }
    },

    submitForm(formName) {
        let _this = this
        this.$refs[formName].validate((valid) => {
            if (valid) {
                _this.validAdd()
            } else {
                return false;
            }
        });
    },

    validAdd() {
        let _this = this  
        let _params = {
          type:parseInt(this.ruleForm.type),
          rule:parseInt(this.ruleForm.rule),
          value:this.ruleForm.value,
          protocol:parseInt(this.ruleForm.protocol),
          relationProtocol:parseInt(this.ruleForm.relationProtocol)
        }
        // console.log(params)
        this._fetchPost('/dataManage/govern/addBlacklist', _params, 'post').then(response => {
            if (response.isOk === true) {
              this.$message({
                  type: 'success',
                  message: '新增成功!'
              });
              _this.getDataList()
                
            } else {
              _this.$message.error(response.msg);               
            }
            _this.dialogVisible = false
        }).catch(error => {
          _this.dialogVisible = false
          _this.$message.error('新增失败');
        });
    },

    getDataList() {
        let _this = this
        let params = {
          sSearch:"{}",
          iDisplayStart: 0,
          iDisplayLength: 20
        };
        _this.getList(params)
    },

    handleClose() {
        this.resetForm('ruleForm')
    },

    resetForm(formName) {
        this.$refs[formName].resetFields();
    },

    // hideDialog(off) {
    //   this.dialogVisible = off
    // },

    handleCurrentChange(val) {
        let _this = this
        this.currentPage = val;
        let params = {
            sSearch:"{}",
            iDisplayStart: (val - 1) * this.pageSize,
            iDisplayLength: 20
        }
        this.getList(params)
    },

    search() {
      // let params = this.filterForm;
      let params = {
        "sSearch": {
          type:parseInt(this.filterForm.sSearch.type),
          rule:parseInt(this.filterForm.sSearch.rule),
          value:this.filterForm.sSearch.value,
          protocol:parseInt(this.filterForm.sSearch.protocol),
          relationProtocol:parseInt(this.filterForm.sSearch.relationProtocol)
        },
        "iDisplayLength": 20      
      };
      let sSearch = JSON.stringify(params.sSearch);
      let _params = {
        "iDisplayLength": params.iDisplayLength,
        "sSearch": sSearch
      }
      this.getList(_params);
    },

    handleDelete(index, row) {
      let _this = this;
      let val = this.currentPage;
      // console.log(index, row.id) 
      this.$confirm('删除此条数据吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
      }).then(() => {
          axios.delete('/monitor/dataManage/govern/deleteBlacklist/'+ row.id +'')
          .then((res)=>{
            if (res.data.isOk) {
              console.log("删除了")
              _this.handleCurrentChange(val)
            } else {
              _this.$message.error(res.msg);
            }
          })
      }).catch(() => {
          this.$message({
              type: 'info',
              message: '已取消'
          });
      });     
      
    }

  }
}
</script>

<style lang="less" scoped>
@import '../../assets/styles/govern';
.blackNameManage {
  .label-search {
    font-size: 14px;
    color: #48576a;
    margin: 0px 8px 0px 0px;
    padding-top: 10px;
    white-space:nowrap;
  }
  .searchForm {
    display: flex;
    flex-wrap: nowrap;
    .el-select {
      width: 120px;
    }
  }
}

</style>
