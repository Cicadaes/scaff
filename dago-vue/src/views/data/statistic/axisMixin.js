export default {
  data() {
    return {
      activeName: 'first',
      companyOptions: {
          color: ['#3398DB'],
          tooltip : {
              trigger: 'axis',
              axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                  type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
              }
          },
          grid: {
              left: '3%',
              right: '4%',
              top: '3%',
              bottom: '3%',
              containLabel: true
          },
          xAxis : [
              {
                  type : 'category',
                  data : ['任子行', '迈外迪', '华氏', '德泰', '和昌', '深信服', '随行宝', '迪普', '志勤', '百米',
                   '中新', '盛世光明', '星辰文化', '新浩艺'],
                  axisTick: {
                      alignWithLabel: true
                  }
              }
          ],
          yAxis : [
              {
                  type : 'value'
              }
          ],
          series : [
              {
                  name:'直接访问',
                  type:'bar',
                  barWidth: '60%',
                  data:[0.9, 0.89, 0.8, 0.75, 0.7, 0.65, 0.6, 0.55, 0.5, 0.45, 0.4, 0.35, 0.3, 0.25]
              }
          ]
      },
      centerOptions: {
          color: ['#3398DB'],
          tooltip : {
              trigger: 'axis',
              axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                  type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
              }
          },
          grid: {
              left: '3%',
              right: '4%',
              top: '3%',
              bottom: '3%',
              containLabel: true
          },
          xAxis : [
              {
                  type : 'category',
                  data : ['南山分局', '罗湖分局', '福田分局', '宝安分局', '盐田分局', '大鹏分局', '公交分局',
                  '龙岗分局', '机场分局', '光明分局', '龙华分局'],
                  axisTick: {
                      alignWithLabel: true
                  }
              }
          ],
          yAxis : [
              {
                  type : 'value'
              }
          ],
          series : [
              {
                  name:'直接访问',
                  type:'bar',
                  barWidth: '60%',
                  data:[0.9, 0.89, 0.8, 0.75, 0.7, 0.65, 0.6, 0.55, 0.5, 0.45, 0.4]
              }
          ]
      }
    };
  },

  mounted() {
    this.$refs.center.style.width = this.$refs.company.parentNode.offsetWidth + "px";
    this.$refs.center.style.height = '300px';
    this.$refs.company.style.width = this.$refs.company.parentNode.offsetWidth+ "px";
    this.$refs.company.style.height = '300px';
    let axisChart = this.$echarts.init(this.$refs.company);
    axisChart.setOption(this.companyOptions);
  },
  methods: {
    handleClick(tab, event) {
      if(this.activeName === 'first'){
        let axisChart = this.$echarts.init(this.$refs.company);
        axisChart.setOption(this.companyOptions);
      }else{
        let axisChart2 = this.$echarts.init(this.$refs.center);
        axisChart2.setOption(this.centerOptions);
      }
    }
  }
}
