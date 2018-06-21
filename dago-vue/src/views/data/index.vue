<template>
  <div>
    <div class="el-collapse-item info-collapse"  v-if="$route.meta.filter">
      <div class="el-collapse-item__header"><i class="el-collapse-item__header__arrow el-icon-arrow-right"></i>
        当前数据监控时间为:  <b style="color: #20a0ff">{{filters.dateTime[0]}}~{{filters.dateTime[1]}}</b>
          <el-tag v-if="errors > 0" type="danger" class="pound-info"><i class="el-icon-information"></i>  异常：{{errors}}</el-tag>
          <div style="float:right;margin-right: 20px;">
            <el-button @click="handleClick" type="default" size="small" id="today">今天</el-button>
            <el-button @click="handleClick" type="primary" size="small" id="three_day">三天内</el-button>
            <el-button @click="handleClick" type="success" size="small" id="week">一周内</el-button>
          </div>
      </div>
    </div>
    <router-view :filters="filters"></router-view>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import DataFilter from './filter';

export default {
  name: 'DataIndex',
  components: {
    DataFilter
  },
  data() {
    return {
      filters: {
        dateTime: [this.moment().format('YYYY-MM-DD 00:00:00'), this.moment().format('YYYY-MM-DD HH:mm:ss')],
        company_id: '',
        center_code: '',
        data_type: '',
        sortProp: 'create_time',
        order: 'DESC'
      }
    }
  },
  computed: {
    ...mapGetters({
      errors: 'listError',
    })
  },
  watch: {
    $route(to, from){
      this.filters = { ...this.filters, dateTime: [this.moment().format('YYYY-MM-DD 00:00:00'), this.moment().format('YYYY-MM-DD HH:mm:ss')] };
    }
  },
  methods: {
    handleClick(e) {
      if (e.currentTarget.id === 'today') {
        this.filters = { ...this.filters, dateTime: [this.moment().format('YYYY-MM-DD 00:00:00'), this.moment().format('YYYY-MM-DD HH:mm:ss')] };
      }else if(e.currentTarget.id === 'three_day') {
        this.filters = { ...this.filters, dateTime: [this.moment().subtract(3, 'days').format('YYYY-MM-DD 00:00:00'), this.moment().format('YYYY-MM-DD HH:mm:ss')] };
      }else{
        this.filters = { ...this.filters, dateTime: [this.moment().subtract(7, 'days').format('YYYY-MM-DD 00:00:00'), this.moment().format('YYYY-MM-DD HH:mm:ss')] };
      }
    }
  }
}
</script>
<style lang='less'>
@import '../../assets/styles/data';
</style>
