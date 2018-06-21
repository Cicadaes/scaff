<template>
  <div class="data-stable">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="数据整体情况" name="1">
        <div class="statistics"  v-if="activeName === '1'">
          <div class="statistics-body">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span>对接数据种类</span>
              </div>
              <types-statistic />
            </el-card>
          </div>
          <div class="statistics-body">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span>对接数据厂商</span>
              </div>
              <company-statistic />
            </el-card>
          </div>
          <div class="statistics-body">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span>核心数据资产</span>
              </div>
              <core-statistic />
            </el-card>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="数据通道情况" name="2">
        <div class="statistics statistics-2" v-if="activeName === '2'">
          <div class="statistics-body">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span>文件无效性</span>
              </div>
              <validator-statistic />
            </el-card>
          </div>
          <div class="statistics-body">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span>文件及时性</span>
              </div>
              <delay-statistic />
            </el-card>
          </div>
          <div class="statistics-body">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span>文件稳定性</span>
              </div>
              <stable-statistic />
            </el-card>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="数据质量情况" name="3">
        <div class="statistics" v-if="activeName === '3'">
          <div class="statistics-body">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span>数据身份关系趋势</span>
              </div>
              <quality-statistic />
            </el-card>
          </div>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import ValidatorStatistic from './statistic/validator';
import StableStatistic from './statistic/stable';
import DelayStatistic from './statistic/delay';
import CoreStatistic from './statistic/core';
import TypesStatistic from './statistic/types';
import CompanyStatistic from './statistic/companys';
import QualityStatistic from './statistic/quality';

  export default {
    name: 'DataStatistics',
    components: {
      ValidatorStatistic,
      StableStatistic,
      DelayStatistic,
      CoreStatistic,
      TypesStatistic,
      CompanyStatistic,
      QualityStatistic
    },
    data() {
      return {
        activeName: '1'
      }
    },
    methods: {
      handleClick(tab, event) {
      }
    }
  }
</script>
<style lang='less'>
.el-card__header {
  padding: 10px 20px;
  font-size: 13px;
  color: #1f2d3d;
  line-height: 1.7em;
}
.el-tabs--card{
  .el-tabs__content{
    border: 1px solid #d1dbe5;
    border-radius: 0 0 5px 5px;
    margin-top: -15px;
    border-top: 0;
    padding: 15px;
  }
}
.statistics{
  display: flex;
  flex-flow: row wrap;
  justify-content: flex-start;
  margin-left: -10px;
  margin-right: -10px;

  .statistics-body{
    min-width: 40%;
    flex: 1;
    padding: 5px 10.5px;
    .el-tabs__content{
      border: none;
      margin-top: 0;
      border-top: 0;
      padding: 0;
    }
  }
}
.statistics-2{
  flex-flow: column;
}

</style>
