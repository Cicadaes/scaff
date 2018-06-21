<template>
  <div class="data-running">
    <table-component
    :tableData="tableData"
    :thNames="thNames"
    :page="currentPage"
    :total="tableData.length"
    @current-change="handleCurrentChange"
    >
    </table-component>
  </div>
</template>

<script>
import TableComponent from '../../components/Table';
import { mapGetters, mapActions } from 'vuex'

  export default {
    name: 'DataRunning',
    components: {
      TableComponent
    },
    data() {
      return {
        thNames: [{
          label: 'IP',
          props: 'ip',
          fixed: 'left'
        },{
          label: '组件名称',
          props: 'name'
        },{
          label: '启动时间',
          props: 'startTime',
          isdate: true

        },{
          label: '错误总数',
          props: 'errorTotal'
        },{
          label: '日期时间',
          props: 'dateTime',
          isdate: true

        },{
          label: 'mysql连接错误数',
          props: 'mysqlConError'
        },{
          label: 'mysql错误数',
          props: 'mysqlError'
        },{
          label: 'Kafka连接错误数',
          props: 'kafkaConError'
        },{
          label: 'Kafka入库错误数',
          props: 'kafkaError'
        },{
          label: '处理状态',
          props: 'status',
          width: '100',
          fixed: 'right',
          meta: [{
            option: '0',
            icon: 'el-icon-check',
            style: 'color: #13ce66'
          },{
            option: '1',
            icon: 'el-icon-close',
            style: 'color: #ff4949'
          },{
            option: '2',
            icon: 'el-icon-close',
            style: 'color: #ff4949'
          }]
        }],
        currentPage: 1,
      }
    },
    computed: {
      ...mapGetters({
        tableData: 'listitems',
      }),

    },
    beforeMount() {
      const tab = 'running';
      //页面重新加载时需要重置
      // this.refreshList({ tab });
      // this.fetchDataIfNeeded({tab});
    },
    methods: {
      ...mapActions([
        'fetchDataIfNeeded',
        'refreshList'
      ]),
      handleCurrentChange(val){
        this.currentPage = val;
      }
    }
  }
</script>
