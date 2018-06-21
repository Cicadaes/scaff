<template>
  <div class="setting-manager">
    <!-- <div style=" top: 10px;">
      <el-button type="success" icon="plus" size="small" @click="handleNew">新增</el-button>
    </div> -->
    <div>
      <el-row>
        <el-col>
          <el-form :inline="true" label-width="80px" :model="filters" >
            <el-form-item label="字典类别">
              <!-- <el-input v-model="filters.type" @change="handleChange"></el-input> -->
              <el-select v-model="filters.type" @change="handleChange" placeholder="请选择" clearable>
                <el-option v-for="item in allDict" :key="item" :label="item" :value="item">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="字典编码">
              <el-input v-model="filters.name" @change="handleChange"></el-input>
            </el-form-item>
            <el-form-item style="float:right;">
              <el-button style="position:relative;right:-8px;" type="success" icon="plus" @click="handleNew">新增</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>

    </div>
    <el-table
    :data="tableData"
    border
    style="width: 100%"
    @sort-change="sortChange">
      <el-table-column
        type="index"
        width="70">
      </el-table-column>
      <el-table-column
        v-for="(item, index) in thNames"
        :key="index"
        :label="item.label"
        :prop="item.props"
        :width="item.width">

      </el-table-column>
      <el-table-column
        label="更新时间"
        prop="updateTime"
        width="180"
        sortable="custom">

      </el-table-column>

      <el-table-column label="操作" width="100">
        <template scope="scope">
          <el-button
            size="small"
            type="primary"
            icon="edit"
            @click="handleEdit(scope.$index, scope.row)"></el-button>

        </template>
      </el-table-column>
    </el-table>
    <Pagination :page="currentPage" :total="total"  @current-change="handleCurrentChange" />
    <el-dialog :modal="false" :visible.sync="dialogVisible" @close="handleClose">
      <template slot="title">{{clickType === 'edit' ? "编辑" : "新增"}}</template>
      <el-form :inline="true" :model="form" ref="form" :rules="rules">
        <el-form-item label="字典编码" prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="字典的值" prop="value">
          <el-input v-model="form.value"></el-input>
        </el-form-item>
        <el-form-item label="字典类别" prop="type">
          <el-input v-model="form.type"></el-input>
        </el-form-item>
        <el-form-item label="描述信息" style="padding-left: 10px;">
          <el-input type="textarea" v-model="form.desc"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm" :loading="loading">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import Pagination from '../../components/Pagination';
import { mapGetters, mapActions, mapState } from 'vuex'
import axios from 'axios'

  export default {
    name: 'DictsSetting',
    components: {
      Pagination
    },
    data() {
      return {
        //所有字典类别
        allDict:[],
        tab: this.$route.meta.tab,
        currentPage: 1,
        dialogVisible: false,
        clickType: 'new',
        form: {
          name: '',
          type: '',
          value: '',
          desc: ''
        },
        rules: {
          name: [
             { required: true, message: '请输入字典编码', trigger: 'blur' },
          ],
          type: [
            { required: true, message: '请输入字典类别', trigger: 'blur' },
          ],
          value: [
            { required: true, message: '请输入字典值', trigger: 'blur' },
          ]
        },
        filters: {
          type: '',
          name: '',
          sortProp: 'updateTime',
          order: 'DESC'
        },
        thNames: [{
          label: '字典类别',
          props: 'type'
        }, {
          label: '字典编码',
          width: 120,
          props: 'name',
        }, {
          label: '字典值',
          props: 'value'
        }, {
          label: '描述信息',
          props: 'desc'
        }],
      }
    },
    computed: {
      ...mapState({
        loading: state => state.itemData['dict/insert'].isFetching,
        updateStatus: state => state.itemData['dict/update'].isOk,
        insertStatus: state => state.itemData['dict/insert'].isOk,
      }),

      ...mapGetters({
        tableData: 'listitems',
        total: 'listTotal'
      }),
    },
    watch: {
      updateStatus(to, from) {
        console.log(to);
        if(!to) {
          this.$message.error('更新数据失败，请联系管理员');
        }
      },
      insertStatus(to, from) {
        if(!to) {
          this.$message.error('新增数据失败，请联系管理员');
        }
      }
    },

    created () {
      this.getAllDict();
    },

    beforeMount() {
      let sSearch = {}
      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: 0,
        iDisplayLength: this.$pageSize,
        iSortCol_0: 'updateTime',
        sSortDir_0: 'DESC'
      };
      this.fetchInit(params);
    },
    methods: {
      //得到所有字典类别
      getAllDict() {
        axios.get("/monitor/sysMonitor/dict/queryDictType").then(res => {
          if(res.data.isOk){
            res.data.data.forEach(item => {
              this.allDict.push(item.type)
            })
          }else{
            this.$message.error(res.data.msg);
          }
          // console.log("所有字典",this.allDict)
        })
      },

      ...mapActions([
        'fetchDataIfNeeded',
        'refreshList',
        'updateData'
      ]),

      fetchInit(params) {
        const {
          tab,
        } = this;
        this.refreshList({
          tab
        });
        this.fetchDataIfNeeded({
          tab,
          params
        });
      },
      handleChange(value) {
        let sSearch = {
          name: this.filters.name,
          type: this.filters.type
        }
        const params = {
          sSearch: JSON.stringify(sSearch),
          iDisplayStart: 0,
          iDisplayLength: this.$pageSize,
          iSortCol_0: 'updateTime',
          sSortDir_0: 'DESC'
        };
        this.fetchInit(params);
      },
      handleCurrentChange(val) {
        this.currentPage = val;
        let sSearch = {
          type: this.filters.type,
          name: this.filters.name
        }
        const params = {
          sSearch: JSON.stringify(sSearch),
          iDisplayStart: (val - 1) * this.$pageSize,
          iDisplayLength: this.$pageSize,
          iSortCol_0: this.filters.sortProp,
          sSortDir_0: this.filters.order
        };
        this.fetchInit(params);

      },
      sortChange({ column, prop, order }) {
        this.filters['sortProp'] = prop;
        this.filters['order'] = order === 'ascending' ? 'ASC' : 'DESC';
        let sSearch = {
          type: this.filters.type,
          name: this.filters.name
        }
        const params = {
          sSearch: JSON.stringify(sSearch),
          iDisplayStart: 0,
          iDisplayLength: this.$pageSize,
          iSortCol_0: this.filters.sortProp,
          sSortDir_0: this.filters.order
        };
        this.fetchInit(params);
        this.currentPage = 1;
      },
      handleNew() {
        this.dialogVisible = true;
        this.clickType = 'new';
      },
      handleEdit(index, row) {
        this.dialogVisible = true;
        this.clickType = 'edit';
        this.form = {
          id: row.id,
          name: row.name,
          value: row.value,
          type: row.type,
          desc: row.desc
        }
      },
      submitForm() {
        this.$refs['form'].validate((valid) => {
          if (!valid) {
            return false;
          }else{
            this.dialogVisible = false;
            let params = {
              name: this.form.name,
              value: this.form.value,
              type: this.form.type,
              desc: this.form.desc
            }
            if (this.clickType === 'edit') {
              params.id = this.form.id
              this.updateData({
                tab: 'dict/update',
                params
              });
            }else{
              this.updateData({
                tab: 'dict/insert',
                params
              });
            }
            setTimeout(() => {
              let sSearch = {}
              const params = {
                sSearch: JSON.stringify(sSearch),
                iDisplayStart: 0,
                iDisplayLength: this.$pageSize,
                iSortCol_0: 'updateTime',
                sSortDir_0: 'DESC'
              };
              this.fetchInit(params);

            }, 500)
          }
        });
      },
      handleClose() {
        this.form = {
          name: '',
          type: '',
          value: '',
          desc: ''
        }
      }
    },

  }
</script>
