<style lang='less' scoped>
@import '../../assets/styles/govern';
.statistics {
  margin:0px 5px;
}
</style>

<template>

<div class="data-stable">
            <div class="statistics">
                <div class="statistics-clouds">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>数据云图</span>
                        </div>
                        <cloud-statistic />
                    </el-card>
                </div>
            </div>
            <div class="statistics">
              <div class="statistics-body">
                  <el-card class="box-card">
                      <div slot="header" class="clearfix">
                          <span>数据质量报告</span>
                      </div>
                      <report-statistic />
                  </el-card>
              </div>
            </div>
              <div class="statistics">
              <div class="statistics-body">
                  <el-card class="box-card">
                      <div slot="header" class="clearfix">
                          <span>任务运行监控</span>
                      </div>
                      <run-statistic />
                  </el-card>
              </div>
            </div>
</div>

</template>

<script>

import CoreStatistic from './statistic/core';
import ReportStatistic from './statistic/report';
import CloudStatistic from './statistic/clouds';
import RunStatistic from './statistic/run';

export default {
    name: 'DataStatistics',
    components: {
        CoreStatistic,
        ReportStatistic,
        CloudStatistic,
        RunStatistic
    }
}

</script>
