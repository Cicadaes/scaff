<template>
  <div class="business-detail">

    <div class="detail-container">
      <el-collapse value="1">
        <el-collapse-item :title="items[0] ? items[0].module.name : ''" name="1">
          <div v-for="(item, index) in items" :key="item" class="categories" :class="{'categories-active': isActive(item)}" @click="handleClick(item, $event)" style="cursor:pointer;">
            <icon name="circle" :style="{color: itemColor(item.score)}" style="position: relative;top: 2px;right: 5px;"></icon>

            <transition appear appear-active-class="animated zoomIn">
              <el-tooltip placement="right-end">
                <div slot="content">
                  <table style="max-width: 350px;">
                    <tbody>
                      <tr valign="top"><td width=80>日志类型：</td><td>{{item.log.type}}</td></tr>
                      <tr valign="top"><td>日志代码：</td><td>{{item.log.name}}</td></tr>
                      <tr valign="top"><td>监控时间：</td><td>{{item.stat_time}}</td></tr>
                      <tr valign="top"><td>错误总数：</td><td>{{item.fail_total}}</td></tr>
                      <tr valign="top"><td>ip：</td><td>{{item.ip}}</td></tr>
                      <tr valign="top"><td>日志总数：</td><td>{{item.log_num}}</td></tr>
                      <tr valign="top"><td>日志内容：</td><td><p>
                        {{item.log_info}}
                      </p></td></tr>
                    </tbody>
                  </table>
                </div>
                <el-tag ref="item-tag" class="item-tag" :type="item.stroke" style="cursor: pointer;">{{item.business.name}}</el-tag>
              </el-tooltip>
            </transition>
          </div>

        </el-collapse-item>

      </el-collapse>
      <el-collapse value="1">
        <el-collapse-item name="1">
          <template slot="title">
            <strong class="primary">{{currentClick ?　currentClick.business.name : ''}} </strong>详情
          </template>
          <el-table
          :data="loglist"
          border
          style="width: 100%">
          <el-table-column
              v-for="(item, index) in thNames"
              :key="index"
              :label="item.label"
              :prop="item.props"
              :width="item.width"
              sortable>

            </el-table-column>

          </el-table>
          <Pagination :page="currentPage" :total="logTotal"  @current-change="handleCurrentChange" />
        </el-collapse-item>
      </el-collapse>
    </div>

  </div>
</template>
<script>
import Pagination from '../../components/Pagination';
import { mapGetters, mapActions, mapState } from 'vuex';
  export default {
    name: 'BusinessDetail',
    components: {
      Pagination
    },
    data() {
      let _this = this;
      return {
        currentClick: null,
        currentPage: 1,
        moduleCode: this.$route.query.moduleCode,
        dateTime: [this.moment(this.$route.query.dateTime).format('YYYY-MM-DD HH:mm:ss'), this.moment(this.$route.query.dateTime).add(1, 'hour').format('YYYY-MM-DD HH:mm:ss')],
        thNames: [{
          label: 'IP',
          props: 'ip',
          width: 130,
        },{
          label: '监控时间',
          props: 'create_time',
          width: 180,
        },{
          label: '日志类型',
          props: 'log.type',
          width: 120,
        }, {
          label: '日志代码',
          props: 'log.name',
          width: 120,
        }, {
          label: '日志详情',
          props: 'log_info'
        }]
      }
    },
    computed: {
      ...mapGetters({
        items: 'listitems',
        loglist: 'loglist',
      }),
      ...mapState({
        logTotal: state => state.listData['home/loglist'].total
      })
    },
    watch: {
      items(to, value) {
        this.currentClick = to[0];
        if (to.length > 0) {
          this.getLogList(to[0].business_code)
        }
      }
    },
    beforeMount() {
      this.getItem();
    },

    methods: {
      ...mapActions([
        'fetchDataIfNeeded',
        'refreshList'
      ]),
      itemColor(score){
        return score === 1 ? '#1ab394' : '#EF5352'
      },

      getItem() {
        const tab = this.$route.meta.tab;
        let sSearch = {
          stat_time_b: this.dateTime[0],
          stat_time_e: this.dateTime[1],
          module_code: this.moduleCode
        }

        const params = {
          sSearch: JSON.stringify(sSearch),
          iDisplayStart: 0,
          iDisplayLength: 50,
          iSortCol_0: 'create_time',
          sSortDir_0: 'DESC'
        };

        this.refreshList({
          tab
        });
        this.fetchDataIfNeeded({
          tab,
          params
        });
      },
      getLogList(business_code) {
        let tab = 'home/loglist';
        let sSearch = {
          create_time_b: this.dateTime[0],
          create_time_e: this.dateTime[1],
          module_code: this.moduleCode,
          business_code: business_code
        }

        const params = {
          sSearch: JSON.stringify(sSearch),
          iDisplayStart: (this.currentPage - 1) * this.$pageSize,
          iDisplayLength: this.$pageSize,
          iSortCol_0: 'create_time',
          sSortDir_0: 'DESC'
        };

        this.refreshList({
          tab
        });
        this.fetchDataIfNeeded({
          tab,
          params
        });
      },
      isActive(item) {
        if(item && item.hasOwnProperty('codeId') && this.currentClick){
          if(item.codeId === this.currentClick.codeId){
            return true;
          }
          return false;
        }
        return false;
      },
      handleClick(item, e) {
        this.currentClick = item;
        this.getLogList(item.business_code)
      },
      handleCurrentChange(val) {
        this.currentPage = val;
        this.getLogList(this.currentClick.business_code);
      },
    }

  }
</script>
<style lang='less'>
@import '../../assets/styles/service';
.primary{
  background-color: rgba(32,160,255,.1) !important;
  border-color: rgba(32,160,255,.2) !important;
  color: #20a0ff !important;
}
</style>
