<template>
<div>
  <el-collapse value="1" class="filter-collapse">
    <el-collapse-item name="1">
      <template slot="title">
        当前搜索监控时间为:  <b>{{dateTime}}</b>
          <el-tag v-if="errors > 0" type="danger" class="pound-info"><i class="el-icon-information"></i>  异常：{{errors}}</el-tag>
      </template>
      <div class="data-outline">
        <el-table class="animated fadeInUp" :data="tableData" style="width: 100%" :row-class-name="tableRowClassName">
          <el-table-column label="厂商代码">
            <template scope="scope">
              <router-link :to="scope.row.link"><el-tag class="tag" :type="scope.row.status === 0 ? 'success' : 'danger'">{{scope.row.factory.name}}</el-tag></router-link>
            </template>
          </el-table-column>
          <el-table-column label="状态">
            <template scope="scope">
              <el-progress :text-inside="true" :stroke-width="18" :percentage="Number((scope.row.score * 100).toFixed(0))" status="success"></el-progress>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-collapse-item>

  </el-collapse>
</div>
</template>

<script>
import {
  mapGetters,
  mapActions
} from 'vuex'
export default {
  name: 'DataOutline',

  data() {
    return {
      tab: 'data/company/list',
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
      errors: 'listError',
    }),

  },
  watch: {

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
    this.fetchInit(params);
  },
  methods: {
    ...mapActions([
      'fetchDataIfNeeded',
      'refreshList'
    ]),
    fetchInit(params) {
      const {
        tab
      } = this;
      this.refreshList({
        tab
      });
      this.fetchDataIfNeeded({
        tab,
        params
      });
    },

    tableRowClassName(row, index) {
      if (row.status === 0 || row.status === '0') {
        return 'positive-row';
      } else {
        return 'danger-row';
      }
      return '';
    },
  }
}
</script>
<style lang="less">@import '../../assets/styles/data';</style>
