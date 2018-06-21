<template>
  <div class="data-delay">
    <el-table
    :data="tableData"
    border
    style="width: 100%"
    @sort-change="sortChange"
    :row-class-name="tableRowClassName"
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
        prop="delay"
        sortable="custom">
        <template scope="scope">
          <i v-if="scope.row.delay === 0" class="el-icon-check" style="color: rgb(19, 206, 102);"></i>
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
    name: 'DataDelay',
    mixins: [mixin],
    data() {
      return {
        tab: 'data/filedelay',
        remark: '*延迟率：文件传输延迟总数/文件总数 * 100% \n*异常数据：延迟率 >= 40%',
        currentPage: 1,
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
          label: '文件传输延迟总数',
          props: 'file_transfer_delay'
        },{
          label: '文件解析延迟总数',
          props: 'file_parse_delay'
        },{
          label: '延迟率',
          props: 'delay_score'
        }]
      }
    },
  }
</script>
