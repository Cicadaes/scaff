<template>
<div class="data-validator">
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
    <el-table-column type="expand">
      <template scope="scope">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item v-for="(descItem, descIndex) in descNames" :label="descItem.label" :key="descIndex" :prop="descItem.props">
            <span>{{scope.row[descItem.props]}}</span>
          </el-form-item>
        </el-form>
      </template>
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
      sortable="custom">

    </el-table-column>
    <el-table-column
      label="状态"
      prop="validator"
      sortable="custom">
      <template scope="scope">
        <i v-if="scope.row.validator === 0" class="el-icon-check" style="color: rgb(19, 206, 102);"></i>
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
  name: 'DataValidator',
  mixins: [mixin],
  data() {
    return {
      tab: 'data/valid',
      remark: '*错误率：错误总数/记录总数 * 100% \n*异常数据：错误率 >= 40%',
      descNames: [{
        label: 'MAC 错误总数',
        props: 'mac_error'
      }, {
        label: '电话错误总数',
        props: 'phone_error'
      }, {
        label: '证件错误总数',
        props: 'cert_error'
      }, {
        label: 'IMSEI错误总数',
        props: 'imsei_error'
      }, {
        label: '文件名错误总数',
        props: 'filename_error'
      }, {
        label: '文件错误总数',
        props: 'file_error'
      }, {
        label: 'IP错误总数',
        props: 'ip_error'
      }, {
        label: '经纬度错误总数',
        props: 'xypoint_error'
      }],
      thNames: [{
        label: '监控时间',
        props: 'stat_time',
        width: 180,
      }, {
        label: '文件总数',
        props: 'file_total'
      }, {
        label: '文件总大小',
        props: 'file_size_total'
      }, {
        label: '记录总数',
        props: 'record_total'
      }, {
        label: '错误总数',
        props: 'error_total'
      },{
        label: '错误率',
        props: 'validator_score'
      }],
      currentPage: 1,
    }
  },

}
</script>
