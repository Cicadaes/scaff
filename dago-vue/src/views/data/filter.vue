<template>
<el-collapse v-model="activeName" accordion class="filter-collapse">
  <el-collapse-item name="1">
      <template slot="title">
        搜索 Search  <strong><i class="header-icon el-icon-search"></i></strong>
          当前搜索监控时间为:  <b>{{moment(filterForm.dateTime[0]).format('YYYY-MM-DD HH:mm:ss')}}~{{moment(filterForm.dateTime[1]).format('YYYY-MM-DD HH:mm:ss')}}</b>
            <el-tag v-if="errors > 0" type="danger" class="pound-info"><i class="el-icon-information"></i>  异常：{{errors}}</el-tag>
        <el-button @click="handleClick" type="primary" icon="search" style="float:right; margin-top: 8px; margin-right: 15px;" size="small">搜索</el-button>
        <el-button @click="resetForm" style="float:right; margin-top: 8px; margin-right: 10px;" size="small">重置</el-button>
      </template>
      <el-form :inline="true" :model="filterForm" ref="filterForm" label-width="100px" class="filterForm">

        <el-form-item label="监控时间">
          <el-form-item prop="dateTime">
            <el-date-picker
              v-model="filterForm.dateTime"
              type="daterange"
              align="right"
              placeholder="选择监控时间范围"
              :picker-options="pickerOptions">
            </el-date-picker>
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
  name: 'DataFilter',
  data() {
    const _this = this;
    return {
      activeName: '1',
      filterForm: {
        dateTime: [this.moment().format('YYYY-MM-DD 00:00:00'), this.moment().add(1, 'days').format('YYYY-MM-DD HH:mm:ss')],
      },
      pickerOptions: {
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            const end = _this.moment().add(1, 'days').format('YYYY-MM-DD');
            const start = _this.moment().format('YYYY-MM-DD');
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const end = _this.moment().format('YYYY-MM-DD');
            const start = _this.moment().subtract(1, 'days').format('YYYY-MM-DD');
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '一周',
          onClick(picker) {
            const end = _this.moment().add(1, 'days').format('YYYY-MM-DD');
            const start = _this.moment().subtract(7, 'days').format('YYYY-MM-DD');
            picker.$emit('pick', [start, end]);
          }
        }]
      },
    };
  },
  computed: {
    ...mapGetters({
      datas: 'listitems',
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
