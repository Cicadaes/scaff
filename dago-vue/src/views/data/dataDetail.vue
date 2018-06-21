<template>
  <div class="business-detail">

    <div class="detail-container">
      <el-collapse value="1">
        <el-collapse-item v-if="data[0]" :title="data[0].company.name" name="1">
          <div class="panel">
            <div v-for="(item, index) in items" :key="item" class="card" >
              <transition appear appear-active-class="animated fadeInUp">
                <svg width="126" height="126">
                  <circle cx="63" cy="63" r="50" stroke-width="6" stroke="rgb(229, 233, 242)" fill="none"></circle>
                  <circle cx="63" cy="63" r="50" stroke-width="6" :stroke="item.strokeColor" fill="none" transform="matrix(0,-1,1,0,0,126)" :stroke-dasharray="item.strokeDasharray"></circle>
                  <text :fill="item.strokeColor" x="55" y="67" text-anchor="middle" dy=".1em" dx=".5em">{{item.score}}</text>
                </svg>
              </transition>
              <transition appear appear-active-class="animated zoomIn">
                <el-tooltip placement="right-end">
                  <div slot="content">
                    <table style="max-width: 350px;">
                      <tbody>
                        <tr v-if="item.error_total >= 0" valign="top"><td width=80>错误总数：</td><td>{{item.error_total}}</td></tr>
                        <tr v-if="item.file_total >=0" valign="top"><td>文件总数：</td><td>{{item.file_total}}</td></tr>
                        <tr v-if="item.file_transfer_delay >=0" valign="top"><td>文件延迟传输总数：</td><td>{{item.file_transfer_delay}}</td></tr>
                        <tr v-if="item.file_parse_delay >=0" valign="top"><td>文件解析延迟总数：</td><td>{{item.file_parse_delay}}</td></tr>
                        <tr v-if="item.record_total >=0" valign="top"><td>记录总数：</td><td>{{item.record_total}}</td></tr>
                        <tr v-if="item.pre_one_record_total >=0" valign="top"><td>预计记录总数：</td><td>{{item.pre_one_record_total}}</td></tr>
                      </tbody>
                    </table>
                  </div>
                  <el-tag :type="item.stroke" style="cursor: pointer;">{{item.name}}</el-tag>
                </el-tooltip>
              </transition>
            </div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex';
  export default {
    name: 'BusinessDetail',
    data() {
      let _this = this;
      return {
        factory_code: this.$route.query.factory_code,
        items: [],
        dateTime: [this.moment(this.$route.query.dateTime).format('YYYY-MM-DD HH:mm:ss'), this.moment(this.$route.query.dateTime).add(1, 'hour').format('YYYY-MM-DD HH:mm:ss')],
      }
    },
    computed: {
      ...mapGetters({
        data: 'listitems'
      })
    },
    watch: {
      data(to, from) {
        if (to[0]) {
          this.items = [{
            score: to[0].validator_score,
            strokeDasharray: Number(to[0].validator_score) * 314 + " 1069",
            status: to[0].validator,
            name: '有效性分值',
            record_total: to[0].record_total,
            error_total: to[0].error_total,
            strokeColor: to[0].validator === 0 ? 'rgb(19, 206, 102)' : '#ff4949',
            stroke: to[0].validator === 0 ? 'success' : 'danger'
          }, {
            score: to[0].delay_score,
            strokeDasharray: Number(to[0].delay_score) * 314 + " 1069",
            status: to[0].delay,
            name: '准时性分值',
            file_total: to[0].file_total,
            file_transfer_delay: to[0].file_transfer_delay,
            file_parse_delay: to[0].file_parse_delay,
            strokeColor: to[0].delay === 0 ? 'rgb(19, 206, 102)' : '#ff4949',
            stroke: to[0].delay === 0 ? 'success' : 'danger'
          }, {
            score: to[0].stable_score,
            strokeDasharray: Number(to[0].stable_score) * 314 + " 1069",
            status: to[0].stable,
            name: '稳定性分值',
            record_total: to[0].record_total,
            pre_one_record_total: to[0].pre_one_record_total,
            strokeColor: to[0].stable === 0 ? 'rgb(19, 206, 102)' : '#ff4949',
            stroke: to[0].stable === 0 ? 'success' : 'danger'
          }]
        }

      }
    },
    beforeMount() {
      this.getItem()
    },
    methods: {
      ...mapActions([
        'fetchDataIfNeeded',
        'refreshList'
      ]),

      getItem() {
        const tab = this.$route.meta.tab;
        let sSearch = {
          stat_time_b: this.dateTime[0],
          stat_time_e: this.dateTime[1],
          company_id: this.factory_code
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
      handleChange() {

      },
    }

  }
</script>
<style lang='less'>@import '../../assets/styles/service';</style>
