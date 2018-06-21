<template>
<div>
  <dashboard :dateTime="dateTime" />
  <div class="service-validator">
    <el-table class="animated fadeInUp" :data="tableData" style="width: 100%" :row-class-name="tableRowClassName">
      <el-table-column label="组件名称">
        <template scope="scope">
          <router-link :to="scope.row.link"><el-tag class="tag" :type="scope.row.status === 0 ? 'success' : 'danger'">{{scope.row.module.name}}</el-tag></router-link>
        </template>
      </el-table-column>
      <el-table-column label="状态">
        <template scope="scope">
          <el-progress :text-inside="true" :stroke-width="18" :percentage="Number((scope.row.score * 100).toFixed(0))" status="success"></el-progress>
        </template>
      </el-table-column>
    </el-table>
  </div>
</div>
</template>

<script>
import Dashboard from './dashboard';
import {
  mapGetters,
  mapActions
} from 'vuex'
export default {
  name: 'ServiceIndex',
  components: {
    Dashboard
  },

  data() {
    return {
      tab: 'home/outline',
      currentPage: 1,
      dateTime: this.moment().subtract(1, 'hour').set({'minute': 0, 'second': 0}).format('YYYY-MM-DD HH:mm:ss'),
      filters: {
        startTime: this.moment().subtract(1, 'hour').set({'minute': 0, 'second': 0}).format('YYYY-MM-DD HH:mm:ss'),
        endTime: this.moment().set({'minute': 0, 'second': 0}).format('YYYY-MM-DD HH:mm:ss')
      }
    }
  },
  computed: {
    ...mapGetters({
      tableData: 'listitems',
    }),

  },

  beforeMount() {
    const {
      tab,
      filters
    } = this;
    let sSearch = {
      stat_time_b: filters.startTime,
      stat_time_e: filters.endTime,
    }

    const params = {
      sSearch: JSON.stringify(sSearch),
      iDisplayStart: 0,
      iDisplayLength: this.$pageSize,
      iSortCol_0: 'create_time',
      sSortDir_0: 'DESC'
    };
    //页面重新加载时需要重置
    this.refreshList({
      tab
    });
    this.fetchDataIfNeeded({
      tab,
      params
    });
  },
  methods: {
    ...mapActions([
      'fetchDataIfNeeded',
      'refreshList'
    ]),
    tableRowClassName(row, index) {
      if (row.status === 0 || row.status === '0') {
        return 'positive-row';
      } else {
        return 'danger-row';
      }
      return '';
    },

    handleCurrentChange(val) {
      this.currentPage = val;
    },

  }
}
</script>
<style lang="less">
@import '../../assets/styles/service';
</style>
