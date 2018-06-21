<template>
<el-collapse v-model="activeName" accordion class="filter-collapse">
  <el-collapse-item name="1">
    <template slot="title">
        搜索 Search <strong><i class="header-icon el-icon-search"></i></strong>
          当前搜索监控时间为:  <b>{{moment(filterForm.dateTime).format('YYYY-MM-DD')}}</b>
          <el-tag v-if="errors > 0" type="danger" class="pound-info"><i class="el-icon-information"></i>  异常：{{errors}}</el-tag>
        <el-button @click="handleClick" type="primary" icon="search" style="float:right; margin-top: 8px; margin-right: 15px;" size="small">搜索</el-button>
        <el-button @click="resetForm" style="float:right; margin-top: 8px; margin-right: 10px;" size="small">重置</el-button>
    </template>
    <el-form :inline="true" :model="filterForm" ref="filterForm" label-width="100px" class="filterForm">
      <!-- <el-form-item label="组件/业务" prop="moduleCode">
        <el-cascader
          :options="moduleBusiness"
          :props="{value: 'code', label: 'name', children: 'children'}"
          v-model="filterForm.moduleCode"
          filterable placeholder="请选择"
          change-on-select
        >
        </el-cascader>

      </el-form-item> -->
      <el-form-item label="组件名称" prop="moduleCode">
        <el-select v-model="filterForm.moduleCode" clearable filterable placeholder="请选择">
          <el-option
            v-for="(item, index) in moduleOptions"
            :key="index"
            :label="item.name"
            :value="item.code">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="业务类型" prop="businessCode">
        <el-select v-model="filterForm.businessCode" clearable filterable placeholder="请选择">
          <el-option
            v-for="(item, index) in businessOptions"
            :key="index"
            :label="item.name"
            :value="item.code">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="日志类型" prop="logType">
        <el-select v-model="filterForm.logType" clearable filterable placeholder="请选择">
          <el-option
            v-for="(item, index) in logTypeOptions"
            :key="index"
            :label="item.name"
            :value="item.code">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="日志代码" prop="logCode">
        <el-select v-model="filterForm.logCode" clearable filterable placeholder="请选择">
          <el-option
            v-for="(item, index) in logOptions"
            :key="index"
            :label="item.name"
            :value="item.code">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="监控时间">
        <el-form-item prop="dateTime">
          <el-date-picker type="date" placeholder="选择日期" v-model="filterForm.dateTime" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-form-item>
    </el-form>
  </el-collapse-item>
</el-collapse accordion>
</template>
<script>
import {
  mapGetters
} from 'vuex';
export default {
  name: 'ServiceFilter',
  data() {
    return {
      activeName: '1',
      filterForm: {
        moduleCode: '',
        dateTime: this.moment().subtract(1, 'days'),
        businessCode: '',
        logType: '',
        logCode: '',
      },
    };
  },
  computed: {
    ...mapGetters({
      moduleOptions: 'module',
      businessOptions: 'businessType',
      logTypeOptions: 'logType',
      logOptions: 'log',
      datas: 'listitems',
      moduleBusiness: 'moduleBusiness',
      errors: 'listError',
    })
  },
  watch: {
    $route(to, from) {
      this.$refs['filterForm'].resetFields();
    },
    datas(to, from) {
      if (to.length === 0) {
        this.activeName = '1'
      } else {
        this.activeName = '0'
      }
    }
  },
  methods: {
    handleClick(e) {
      e.stopPropagation();
      this.$emit('filter-change', this.filterForm)
    },
    resetForm(e) {
      e.stopPropagation();
      this.$refs['filterForm'].resetFields();
      this.$emit('filter-change', this.filterForm)
    },

  }
}
</script>
