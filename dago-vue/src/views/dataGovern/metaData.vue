<style lang="less">
@import '../../assets/styles/govern';
@import '../../assets/styles/clouds';
.box{
  display: block;
}
.tab-title {
  width: 100% !important;
}
.metaTable {
  flex-grow: 5;
  margin-left: 10px;
}
.metaData {
  .cloud {
    .cloud-title {
      ul {
        .tabActive {
           background: linear-gradient(#20a0ff,#fff ,#20a0ff);
        }
        li:hover {
           background: linear-gradient(#20a0ff,#fff ,#20a0ff);
        }
      }
    }
  }
  .dataAll div {
    margin:4px 0px;
    display: flex;
    flex-wrap: nowrap;
  }
  .label{
    vertical-align: middle;
    float: left;
    font-size: 14px;
    color: #48576a;
    line-height: 1;
    padding: 11px 12px 11px 0;
    box-sizing: border-box;
    width: 90px;
    line-height: 20px;
  }
}
</style>
<template>
  <div class="metaData">
  <div class="data-type cloud box">
    <el-row>
      <el-col :span="4">
        <div class="cloud-title tab-title">
            <ul id="meta">
                <li v-for="(item, index) in navList" @click="selectDataType(item.database)">
                  <span>{{item.databaseName}}</span>
                  <span style="float:right;">({{item.tableTotal}})</span>
              </li>
            </ul>
        </div>
      </el-col>
      <el-col :span="20">
        <div class="metaTable">
          <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
          <el-tab-pane label="数据集" name="1">
            <el-table
              :data="tableData"
              v-loading="loading"
              style="width: 100%">
              <el-table-column v-for="(conlumn, index) in tableColumn" :key="index" :prop="conlumn.prop" :label="conlumn.label" :width="conlumn.width">
                <template scope="scope">
                  <el-tooltip class="item" effect="dark" :content="scope.row[conlumn.prop]" placement="bottom-start">
                    <span>{{scope.row[conlumn.prop]}}</span>
                  </el-tooltip>
                </template>
              </el-table-column>
              <el-table-column
              prop="operate"
              label="操作"
              width="180">
              <template scope="scope" class="operate">
                  <el-button size="small" type="primary" @click="getDetails(scope.row)">
                    详情
                  </el-button>
              </template>
            </el-table-column>
            </el-table>
            <Pagination :pageSize="pageSize" :page="currentPage" :total="totalCount" @current-change="handleCurrentChange" />
          </el-tab-pane>
          <el-tab-pane label="数据概况" name="2">
            <el-row class="dataAll" v-loading="loading">
                <div>
                  <span class="label">数据库名</span>
                    <el-input v-model="dataAll.database" placeholder="" style="width:300px;" readonly></el-input>
                </div>
                <div>
                  <span class="label">数据库地址</span>
                    <el-input v-model="dataAll.location" placeholder="" style="width:300px;" readonly></el-input>
                </div>
                <div>
                  <span class="label">备注</span>
                    <el-input v-model="dataAll.remark" placeholder="" style="width:300px;" readonly></el-input>
                </div>
            </el-row>
          </el-tab-pane>
        </el-tabs>
        </div>
      </el-col>
    </el-row>
  </div>
  <meta-details :showDialog="dialogVisible" @hideDialog="hideDialog" :details="details"/>
  </div>
</template>

<script>
import Pagination from '../../components/Pagination';
import metaDetails from './metaDetails'
import mixin from '../static/tableMixin'

export default {
  name: 'mataData',
  mixins: [mixin],
  data() {
    return {
      database: '',
      loading: false,
      currentPage: 1,
      dialogVisible: false,
      pageSize: 20,
      totalCount: 1,
      activeName: '1',
      details: {},
      dataAll: {
        database:'',
        location: '',
        remark: '',
      },
      navList: [],
      tableColumn: [
        {
          prop: 'number',
          label: '序号',
          width: 80
        },
        {
          prop: 'tableName',
          label: '表名称',
        },
        {
          prop: 'tableType',
          label: '表类型',
        },
        {
          prop: 'fileTotal',
          label: '文件总数',
        },
        {
          prop: 'placeSize',
          label: '空间大小',
        },
        {
          prop: 'updateTime',
          label: '更新时间',
          width: 180
        },
        {
          prop: 'owner',
          label: '创建人',
        },
        {
          prop: 'remark',
          label: '说明'
        }
      ],
      tableData: []
    }
  },
  components: {
    Pagination,
    metaDetails
  },
  created() {
    this.getNavList()
  },
  mounted() {

  },
  methods: {
    getList(params) {
      this.fetchData('/dataManage/govern/metadata', params, 'get').then(response => {
          if (response.isOk === true) {
            let start = (this.currentPage - 1) * 20 + 1
              this.tableData = this.getter(response.data.records, start) || []
              this.dataAll = response.data.basic
              this.loading = false
              this.totalCount = response.totalCount
          } else {
              this.$message.error(response.msg)
          }
      }).catch(error => {

      });
    },
    getNavList() {
      let _this = this
      this.fetchData('/dataManage/govern/metadataDatabases', {}, 'get').then(response => {
          if (response.isOk === true) {
            _this.navList = response.data || []
          } else {
              this.$message.error(response.msg)
          }
      }).then(() =>{
        $("#meta li").click(function() {
          $(this).addClass('tabActive').siblings().removeClass('tabActive')
        }).get(0).click()
      }).catch(error => {

      });
    },
    handleClick(tab, event) {
        console.log(tab, event);
      },
      handleCurrentChange(val) {
        this.currentPage = val
        let param = {
            start: (val - 1) * this.pageSize,
            size: 20,
            database: this.database
          }
        this.getList(param)
      },
      hideDialog(off) {
        this.dialogVisible = off
      },
      selectDataType(data){
      this.currentPage = 1
      this.tableData = []
      this.database = data
      this.loading = true
      let param = {
            start: 0,
            size: 20,
            database: data
      }
      this.getList(param)
    },
    getDetails(row) {
      let params = {
        database: this.database,
        tableName: row.tableName
      }
      this._fetchPost('/dataManage/govern/metadataDetail', params, 'post').then(response => {
          if (response.isOk === true) {
            this.details = response
            this.dialogVisible = true
          } else {
            this.dialogVisible = false
            this.$message.error('无相关数据详情！')
          }
      }).catch(error => {

      });
    }
  }
}
</script>
