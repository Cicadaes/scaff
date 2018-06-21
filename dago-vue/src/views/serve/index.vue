<template>
  <div class="service-validator">
    <el-table
      :data="tableData"
      style="width: 100%"
      class="animated fadeInUp"
      :expand-row-keys="expandRowKey"
      :row-key="rowKey"
      :row-class-name="tableRowClassName">
      <el-table-column type="expand">
        <template scope="scope">
          <el-table :data="scope.row.info" border stripe>
            <el-table-column
              v-for="th in descNames"
              :key="th.props"
              :label="th.label"
              :prop="th.props">
            </el-table-column>
          </el-table>
        </template>
      </el-table-column>
      <el-table-column
        label="组件名称"
        prop="moduleName">
        <template scope="scope">
          {{scope.row.moduleName}}
        </template>
      </el-table-column>
      <el-table-column label="应有进程个数" prop="instanceNum" width="120">
        <template scope="scope">
          <el-tag class="tag" :type="scope.row.status === 1 ? 'success' : 'danger'">{{scope.row.instanceNum}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        label="状态"
        width='100'
        prop="status">
        <template scope="scope">
          <i v-if="scope.row.status === 1" class="el-icon-check" style="color: rgb(19, 206, 102);"></i>
          <i v-else class="el-icon-close" style="color: rgb(255, 73, 73);"></i>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="100">
        <template scope="scope">
          <el-button size="small" @click="refreshInfo(scope.$index, scope.row)"><icon name="refresh"></icon></el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  import {
    mapGetters,
    mapActions
  } from 'vuex';
  export default {
    name: 'ServeIndex',
    data() {
      return {
        tab: this.$route.meta.tab,
        currentPage: 1,
        row: null,
        expandRowKey: new Array,
        descNames: [{
          label: '服务名',
          props: 'serviceName'
        }, {
          label: 'IP 地址',
          props: 'ip'
        }, {
          label: '主机名',
          props: 'hostName'
        }, {
          label: '安装位置',
          props: 'appDir'
        }, {
          label: '版本号',
          props: 'version'
        },{
          label: '启动时间',
          props: 'startTime',
          sortable: true,
        }],
      }
    },
    computed: {
      ...mapGetters({
        tableData: 'listitems',
        total: 'listTotal'
      }),
      updateRow() {
        return this.$store.state.listData['service/detail'].items
      }
    },
    watch: {
      updateRow(to, from) {
        for (var i = 0; i < this.tableData.length; i++) {
          if(this.tableData[i].moduleName === to.moduleName){
            this.tableData[i] = to;
            this.row.status = to.status;
            this.row.instanceNum = to.instanceNum;
            this.row.info = to.info;
            this.expandRowKey = [];
            this.expandRowKey.push(to.moduleName)
          }
        }
      }
    },
    beforeMount() {
      this.fetchInit();
    },
    methods: {
      ...mapActions([
        'fetchDataIfNeeded',
        'refreshList'
      ]),

      fetchInit() {
        const {
          tab,
        } = this;
        this.refreshList({
          tab
        });
        this.fetchDataIfNeeded({
          tab,
          method: 'get'
        });
      },
      tableRowClassName(row, index) {
        if (row.status === 1) {
          return 'positive-row';
        } else {
          return 'danger-row';
        }
        return '';
      },
      rowKey(row) {
        return row.moduleName;
      },
      refreshInfo(index, row) {
        const tab = 'service/detail'
        this.row = row;
        this.refreshList({tab});
        this.fetchDataIfNeeded({
          tab,
          params: {
            moduleName: row.moduleName
          },
          method: 'get'
        });
      }

    }
  }
</script>
<style lang='less'>
.el-table .danger-row {
  background: #f5c9c9;

}

.el-table .positive-row {
  background: #e2f0e4;
}

.danger-row .el-progress-bar__outer{
  background-color: #ff4949;
}
</style>
