<template>
  <div id="cloud" style="width: 100%; height: 300px;"></div>
</template>
<script>
import '../../../assets/js/jqcloud';
export default {
  name: 'ComapnyStatistic',
  data() {
    return {
      options: [
          {text: "华氏", weight: 12},
          {text: "和昌", weight: 9},
          {text: "迪普", weight: 6},
          {text: "志勤", weight: 7},
          {text: "中新", weight: 5},
          {text: "任子行", weight: 18},
          {text: "迈外迪", weight: 11},
          {text: "德泰", weight: 12},
          {text: "深信服", weight: 14},
          {text: "盛世光明", weight: 13},
          {text: "星辰文化", weight: 12},
          {text: "新浩艺", weight: 8},
      ]
    }
  },
  mounted() {
    $("#cloud").jQCloud(this.options);
  }
}
</script>
<style>
@import "../../../assets/styles/jqcloud.css";
</style>
