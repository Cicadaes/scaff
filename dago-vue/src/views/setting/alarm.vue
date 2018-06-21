<template>
  <div class="setting-manager">
    <el-table
    :data="tableData"
    border
    :row-class-name="tableRowClassName"
    style="width: 100%">
      <el-table-column
        type="index"
        width="70">
      </el-table-column>
      <el-table-column label="报警类型" prop="type" width="150">
        <template scope="scope">Monitor短信报警</template>
      </el-table-column>
      <el-table-column
        v-for="(item, index) in thNames"
        :key="index"
        :label="item.label"
        :prop="item.props"
        :width="item.width">
      </el-table-column>
      <el-table-column prop="status" label="发送状态" width="80">
        <template scope="scope">
          {{ translate(scope.row.status) }}
        </template>
      </el-table-column>
    </el-table>
    <Pagination :page="currentPage" :total="total"  @current-change="handleCurrentChange" />
  </div>
</template>
<script>
import Pagination from '../../components/Pagination';
import { mapGetters, mapActions } from 'vuex';
export default {
  name: 'SettingAlarm',
  components: {
    Pagination
  },
  computed: {
    ...mapGetters({
      tableData: 'listitems',
      total: 'listTotal'
    }),
  },

  data() {
    return {
      tab: this.$route.meta.tab,
      currentPage: 1,
      thNames: [{
        label: '短信发送号码',
        props: 'phone',
        width: 150
      }, {
        label: '短信内容',
        props: 'content',
      }, {
        label: '发送结果',
        props: 'result',
        width: 80
      }, {
        label: '发送时间',
        props: 'createTime',
        width: '180',
      }],
    }
  },
  beforeMount() {
    let sSearch = {
      createTime_b: this.moment().format('YYYY-MM-DD 00:00:00'),
      createTime_e: this.moment().format('YYYY-MM-DD HH:mm:ss')
    }
    const params = {
      sSearch: JSON.stringify(sSearch),
      iDisplayStart: 0,
      iDisplayLength: this.$pageSize,
      iSortCol_0: 'createTime',
      sSortDir_0: 'DESC'
    };
    this.fetchInit(params);
  },
  methods: {
    ...mapActions([
      'fetchDataIfNeeded',
      'refreshList',
      'updateData'
    ]),
    tableRowClassName(row, index) {
      if (row.status === 1) {
        return 'positive-row';
      }
      if(row.status === 2) {
        return 'danger-row';
      }
      return '';
    },
    fetchInit(params) {
      const {
        tab,
      } = this;
      this.refreshList({
        tab
      });
      this.fetchDataIfNeeded({
        tab,
        params
      });
    },
    translate(status) {
      if(status === 0){
        return '未发送'
      }
      if(status === 1){
        return '已发送'
      }else{
        return '失败'
      }
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      let sSearch = {
        createTime_b: this.moment().format('YYYY-MM-DD 00:00:00'),
        createTime_e: this.moment().format('YYYY-MM-DD HH:mm:ss')
      }
      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: (val - 1) * this.$pageSize,
        iDisplayLength: this.$pageSize,
        iSortCol_0: 'createTime',
        sSortDir_0: 'DESC'
      };
      this.fetchInit(params);

    },
  }
}
</script>
