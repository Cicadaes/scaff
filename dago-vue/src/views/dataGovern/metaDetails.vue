<template>
  <div class="metaDetails">
    <el-dialog size="full" title="数据详情" :visible.sync="dialogVisible">
      <el-tabs v-model="activeName2" type="card" @tab-click="handleClick">
      <el-tab-pane label="基本信息" name="1">
        <el-row>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.database" readonly>
              <template slot="prepend">数据库名</template>
            </el-input>
          </el-col>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.tableName" readonly>
              <template slot="prepend">表名</template>
            </el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.location" readonly>
              <template slot="prepend">存储位置</template>
            </el-input>
          </el-col>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.owner" readonly>
              <template slot="prepend">创建者</template>
            </el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.fileTotal" readonly>
              <template slot="prepend">文件总数</template>
            </el-input>
          </el-col>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.placeSize" readonly>
              <template slot="prepend">空间大小</template>
            </el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.compress" readonly>
              <template slot="prepend">压缩情况</template>
            </el-input>
          </el-col>
          <el-col :span="6" style="margin:10px 20px;">
            <el-input placeholder="" v-model="dataAll.createTime" readonly>
              <template slot="prepend">创建时间</template>
            </el-input>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="字段描述" name="2">
        <el-table
          :data="tableData"
          style="width: 100%">
          <el-table-column v-for="(conlumn, index) in tableColumn" :key="index" :prop="conlumn.prop" :label="conlumn.label">

          </el-table-column>
        </el-table>
        <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />

      </el-tab-pane>
    </el-tabs>
  </el-dialog>
  </div>
</template>

<script>
import Pagination from '../../components/Pagination';

export default {
  name: 'metaDetails',
  data() {
    return{
      currentPage: 1,
      pageSize: 20,
      total: 1,
      dataAll: {},
      tableColumn: [
        {
          prop: 'number',
          label: '序号',
        },
        {
          prop: 'columnName',
          label: '名称',
        },
        {
          prop: 'columnType',
          label: '类型',
        },
        {
          prop: 'remark',
          label: '描述',
        },
      ],
      tableData: [
        {
          no: 1,
          name: '业务',
          type: '类型',
          describe: '2018-12-12',
      }
    ],
      activeName2: '1',

      dialogVisible: false
    }
  },
  components: {
    Pagination,
  },
  props: {
    showDialog: {
      type: Boolean,
      default: false
    },
    details: {
      type: Object,
      default: {}
    },
  },
  watch: {
    showDialog(to) {
      this.dialogVisible = to
    },
    dialogVisible(to) {
      if (to === false) {
        this.dataAll = {}
        this.tableData = []
        this.hideDialog()
      }
    },
    details(to) {
      this.dataAll = to.data.basicMap
      let start = (this.currentPage - 1) * 20 + 1
      this.tableData = this.getter(to.data.columns, start)
    }
  },
  methods: {
    getter(data, start) {
        data.forEach(function(item, index) {
            item.number = start++
        })
        return data
    },
    handleClose() {},
    hideDialog() {
      this.$emit('hideDialog', false)
    },
    handleClick() {},
    handleCurrentChange() {}
  }
}
</script>
