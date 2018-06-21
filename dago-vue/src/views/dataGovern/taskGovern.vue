<template>
  <div class="data-type taskGovern" style="min-height:700px;" v-loading="loading">
    <!-- <div class="data-type taskGovern" :style="{'min-height':minHeight}" v-show="active"> -->

    <div style="position: absolute; top: 8px;">
        <el-button type="success" icon="plus" size="small" @click="handleAdd">新增</el-button>
    </div>
    <el-form :inline="true" label-width="80px" class="searchForm">
        <el-form-item prop="blackNameType">
          <el-select v-model="filters.blackNameType" placeholder="请选择组件" style="width:210px;" clearable>
            <el-option label="1" value="shanghai"></el-option>
            <el-option label="2" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="blackNameType">
          <el-select v-model="filters.blackNameType" placeholder="请选择任务类型" style="width:210px;" clearable>
            <el-option label="1" value="shanghai"></el-option>
            <el-option label="2" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="blackNameType">
          <el-input v-model.trim="filters.blackNameType" placeholder="任务名称" style="width:210px;"></el-input>
        </el-form-item>
        <el-button type="primary" @click="search" style="margin-left:10px;height:36px;">搜索</el-button>
    </el-form>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column v-for="(conlumn, index) in tableColumn" :key="index" :prop="conlumn.prop" :label="conlumn.label">

      </el-table-column>
      <el-table-column
      prop="operate"
      label="操作"
      width="180">
      <template scope="scope" class="operate">
        <el-tooltip class="item" effect="dark" content="参数配置" placement="top-start">
          <el-button size="small" icon="setting" @click="configParam(scope.$index,scope.row)"></el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="修改" placement="top-start">
          <el-button size="small" type="primary" icon="edit" @click="handleEdit(scope.$index,scope.row)"></el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="删除" placement="top-start">
          <el-button size="small" type="danger" icon="delete" @click="handleDelete(scope.$index,scope.row)">
          </el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="启用" placement="top-start">
          <el-button size="small" type="" icon="caret-right" @click="start(scope.$index,scope.row)">
          </el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="立即执行" placement="top-start">
          <el-button size="small" type="success" icon="d-arrow-right" @click="execute(scope.$index,scope.row)">
          </el-button>
        </el-tooltip>
      </template>
    </el-table-column>
    </el-table>
    <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />
    <model-black :clickForm="clickType" :showDialog="dialogVisible" @hideDialog="hideDialog"/>
    <model-config :showConfig="configdialog" @hideDialog="hideDialog"/>
  </div>
</template>
<script>
import Pagination from '../../components/Pagination';
import modelBlack from "./black/taskCreatForm"
import modelConfig from "./black/configParam"
// import VueAxios from 'vue-axios';
import axios from 'axios';

export default {
  name: 'TaskGovern',
  data() {
    return {
      filters: {
        blackNameType: '',
      },
      clickType: '',
      dialogVisible: false,
      currentPage: 1,
      configdialog: false,
      configType: '',
      pageSize: 20,
      total: 1,
      loading: false,
      minHeight: 0,
      tableColumn: [
        {
          prop: 'no',
          label: '序号',
        },
        {
          prop: 'name',
          label: '任务名称',
        },
        {
          prop: 'rule',
          label: '组件名称',
        },
        {
          prop: 'rule',
          label: '任务类型',
        },
        {
          prop: 'rule',
          label: '是否重复',
        },
        {
          prop: 'rule',
          label: '调度策略',
        },
        {
          prop: 'rule',
          label: '备注',
        },
        {
          prop: 'rule',
          label: '更新时间',
        },
        {
          prop: 'rule',
          label: '创建时间',
        },
      ],
      tableData: [],
    }
  },
  components: {
    Pagination,
    'model-black': modelBlack,
    'model-config':modelConfig
  },
  created () {
    //页面打开时首次请求数据
    this.getDataList();
  },

  mounted() {
  // Inputmask({
  // "mask": "**-**-**-**-**-**"
  //   }).mask(this.$refs.macFormat.$el.children[1])
  const _this = this
  // this.minHeight = $('body').height() - $('.taskGovern').offset().top + 1200

  },
  methods: {
    getDataList() {
        let _this = this      
        _this.getList({})
    },

    getList(params) {
      axios({
        method: 'get',
        url: '/monitor/dataManage/govern/tasklist',
        data: JSON.stringify(params),
        headers: {
          'Content-Type': 'application/json',
          "Accept": "application/json"
        },
      }).then(res => {
        console.log("治理任务数据",res.data)
      })
    },


    handleAdd() {
      this.dialogVisible = true
      this.clickType = 'add'
    },
    handleEdit(index, row) {
      this.dialogVisible = true
      this.clickType = 'edit'
    },
    handleDelete(index, row) {

    },
    hideDialog(off) {
      this.dialogVisible = off
      this.configdialog = off
    },
    handleCurrentChange() {},
    search() {},
    configParam(index, row) {
      this.configdialog = true
    },
    start(index, row) {
      const _this = this
      this.loading = true
      setTimeout(function() {
        _this.loading = false
        _this.$message({
          message: '已启用',
          type: 'success'
        });
      },1000)
    },
    execute(index,row) {
        const h = this.$createElement;
        let taskName = row.name
        this.$msgbox({
          title: '执行任务',
          message: h('p', { style: 'text-align: center' }, [
            h('span', null, `立即执行任务${taskName}？`),
          ]),
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          beforeClose: (action, instance, done) => {
            if (action === 'confirm') {
              instance.confirmButtonLoading = true;
              instance.confirmButtonText = '执行中...';
              setTimeout(() => {
                done();
                setTimeout(() => {
                  instance.confirmButtonLoading = false;
                }, 500);
              }, 500);
            } else {
              done();
            }
          }
        }).then(action => {
          this.$message({
            type: 'success',
            message: '执行成功！'
          });
        });
      },

  }
}
</script>

<style lang="less" scoped>
@import '../../assets/styles/govern';
.taskGovern {
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
    .el-table__row .cell button{
      margin: 2px 0px 1px 0px;
      padding: 4px;
  }
}

</style>
