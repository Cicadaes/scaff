<template>
  <transition appear appear-active-class="animated fadeInUp">
  <div class="app-table">
    <el-table
      ref="table"
      border
      v-loading.body="loading"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @cell-mouse-enter="handleMouseEnter"
      @cell-mouse-leave="handleMouseLeave"
      @filter-change="handleFilterChange"
      :row-class-name="tableRowClassName"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="index"
        width="55">
      </el-table-column>
      <!-- <el-table-column
        type="selection"
        width="55">
      </el-table-column> -->
      <el-table-column
        v-for="(item, index) in thNames"
        :key="index"
        :label="item.label"
        :prop="item.props"
        :width="item.width"
        :type="item.type"
        :filters="item.filters"
        :filter-method="filterMethod">
        <template scope="scope">
          <span v-if="!item.meta">{{scope.row[item.props]}}</span>
          <i v-for="meta in item.meta" v-if="scope.row[item.props] === meta.option && !scope.row['score']" :class="meta.icon" :style="meta.style"></i>
          <el-form v-if="item.type === 'expand'" label-position="left" inline class="demo-table-expand">
            {{scope.row[item.props]}}
            <el-form-item v-if="!item.desc" v-for="(descItem, descIndex) in descNames" :label="descItem.label" :key="descIndex" :prop="descItem.props">
              <span>{{scope.row[descItem.props]}}</span>
            </el-form-item>
            <span v-else>{{scope.row[item.props]}}</span>
          </el-form>
        </template>
      </el-table-column>
    </el-table>

    <div class="block" v-if="!hiddenPaginate">
      <pre class="error">{{remark}}</pre>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size=20
        layout="total, prev, pager, next"
        :total="total">
      </el-pagination>
    </div>
  </div>
  </transition>
</template>
<script>
  export default {
    name: 'Table',
    props: {
      hiddenPaginate: {
        type: Boolean,
        default: false
      },
      thNames: {
        type:  Array,
        default: null
      },
      descNames: {
        type: Array,
        default: null
      },
      tableData: {
        type: Array,
        default: []
      },
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
        rowsLength: null,
        rows: {}
      }
    },
    watch: {
      tableData(to, from) {
        this.rowsLength = null,
        this.rows = {}
        // let elements = document.getElementsByClassName('el-checkbox__input');
        let cellElements = document.getElementsByClassName('cell highlight');
        for (var i = 0; i < cellElements.length; i++) {
          cellElements[i].className = 'cell'
        }
        // for (var i = 0; i < elements.length; i++) {
        //   elements[i].className = 'el-checkbox__input'
        // }
      }
    },
    computed: {
      rowColumns() {
        if(this.rowsLength === null){
          return this.total;
        }else{
          return this.rowsLength;
        }
      },


      loading() {
        return this.$store.state.listData.isFetching
      }
    },

    methods: {
      handleClick(){

      },
      handleMouseEnter(row, column, cell, event) {
        const el = this.$el;
        const rows = el.querySelectorAll('tbody > tr');
        for (var i = 0; i < rows.length; i++) {
          rows[i].className = rows[i].className.replace('hover-row','');
        }
      },
      handleMouseLeave(row, column, cell, event) {

      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      tableRowClassName(row, index) {
        if (row.status === 0 || row.status === '0') {
          return 'positive-row';
        } else {
          return 'danger-row';
        }
        return '';
      },

      handleCurrentChange(val) {
        this.currentPage = val;
        this.$emit('current-change', val)
      },
      handleFilterChange(filterValues){
        if (!filterValues[Object.keys(filterValues)] || filterValues[Object.keys(filterValues)].length === 0) {
          this.rowsLength = this.total
        }
      },
      filterMethod(value, row) {
        let index = value.split('-')[0];
        let val = value.split('-')[1];
        let val1 = value.split('-')[2] === undefined ? '0' : value.split('-')[2];
        if(row[index] === val || row[index] === val1) {
          this.rows[row.codeId] = row;
          this.rowsLength = Object.keys(this.rows).length;
          return row[index] === val || row[index] === val1;
        }else{
          delete this.rows[row.codeId];
          this.rowsLength = Object.keys(this.rows).length;
        }
      }
    }
  }
</script>
<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 20%;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
  .el-table .danger-row {
    background: #f5c9c9;

  }

  .el-table .positive-row {
    background: #e2f0e4;
  }

  .danger-row .el-progress-bar__outer{
    background-color: #ff4949;
  }
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
  .tag{
    height: 70%;
    line-height: 25px;
    position: absolute;
    top: 15%;
    bottom: 15%;
    font-size: 15px;
  }
</style>
