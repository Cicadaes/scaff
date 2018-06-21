<template>
  <div class="data-stable">
    <el-table
    :data="tableData"
    border
    style="width: 100%"
    :row-class-name="tableRowClassName"
    @sort-change="sortChange"
    @filter-change="filterChange">
      <el-table-column
        type="index"
        width="70">
      </el-table-column>
      <el-table-column label="厂商名称" prop="company.name" :filters="factories" column-key="company_id"></el-table-column>
      <el-table-column label="接入中心" prop="center.name" :filters="centers" column-key="center_code"></el-table-column>
      <el-table-column label="数据类型" prop="datatype.name" :filters="datatypes" column-key="data_type"></el-table-column>
      <el-table-column
        v-for="(item, index) in thNames"
        :key="index"
        :label="item.label"
        :prop="item.props"
        :width="item.width"
        sortable="custom"
        :type="item.type">

      </el-table-column>
      <el-table-column
        label="状态"
        prop="stable"
        sortable="custom">
        <template scope="scope">
          <i v-if="scope.row.stable === 0" class="el-icon-check" style="color: rgb(19, 206, 102);"></i>
          <i v-else class="el-icon-close" style="color: rgb(255, 73, 73);"></i>
        </template>
      </el-table-column>
    </el-table>
    <Pagination :remark="remark" :page="currentPage" :total="total"  @current-change="handleCurrentChange" />
  </div>
</template>

<script>

import mixin from './tableMixin';

  export default {
    name: 'DataStable',
    mixins: [mixin],
    data() {
      return {
        remark: '*稳定性：记录总数/预计记录总数 * 100% \n*记录总数大于预计记录数，稳定性为100% \n*异常数据：稳定性 < 60%',
        tab: 'data/stable',
        thNames: [{
          label: '监控时间',
          props: 'stat_time',
          width: 180,
        },{
          label: '文件总数',
          props: 'file_total'
        },{
          label: '文件总大小',
          props: 'file_size_total'
        },{
          label: '记录总数',
          props: 'record_total'
        },{
          label: '预计文件总数',
          props: 'pre_one_file_total'
        },{
          label: '预计文件总大小',
          props: 'pre_one_file_size_total'
        },{
          label: '预计记录总数',
          props: 'pre_one_record_total'
        },{
          label: '稳定性',
          props: 'stable_score'
        }],
        currentPage: 1,
      }
    },


  }
</script>
