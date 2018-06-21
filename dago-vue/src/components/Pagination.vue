<template>
  <div class="block">
    <pre class="error">{{remark}}</pre>
    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="$pageSize"
      layout="total, prev, pager, next"
      :total="total">
    </el-pagination>
  </div>
</template>
<script>
  export default {
    name: 'Pagination',
    props: {
      total: {
        type: Number,
        default: 0
      },
      page: {
        type: Number,
        default: 1
      },
      remark: {
        type: String,
        default: ''
      }
    },
    data() {
      return {
        currentPage: this.page,
      }
    },
    watch: {
      page(to) {
        this.currentPage = to;
      }
    },
    methods: {
      handleCurrentChange(val) {
        this.currentPage = val;
        this.$emit('current-change', val)
      },
    }
  }
</script>
<style>
.block {
  position: relative;
  margin: 20px 0 0;
  text-align: right;
}
.error{
  position: absolute;
  top: 0;
  left: 0;
  color: #ff4949;
  text-align: left;
}
</style>
