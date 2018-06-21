<template>
  <div class="setting-manager">
    <div style="float: right; margin-bottom: 25px;">
      <el-button type="success" icon="plus" size="small" @click="handleNew">新增</el-button>
    </div>
    <el-table
    :data="tableData"
    border
    style="width: 100%"
    @sort-change="sortChange"
    :row-class-name="tableRowClassName"
    @filter-change="filterChange">
      <el-table-column
        type="index"
        width="70">
      </el-table-column>
      <el-table-column width="180" label="组件名称" prop="module.name" :filters="modules" column-key="module_code"></el-table-column>
      <el-table-column label="业务名称" prop="business.name" :filters="businesstypes" column-key="business_code"></el-table-column>
      <el-table-column
        v-for="(item, index) in thNames"
        :key="index"
        :label="item.label"
        :prop="item.props"
        :width="item.width"
        sortable="custom"
        :type="item.type">

      </el-table-column>
      <el-table-column
        label="状态"
        prop="status"
        width="120"
        sortable="custom">
        <template scope="scope">
          <el-switch
            v-model="scope.row.isOpen"
            on-text="启用"
            off-text="禁用"
            on-color="#13ce66"
            off-color="#ff4949"
            @change="handleChange(scope.$index, scope.row)">
          </el-switch>

        </template>
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
      <el-form :inline="true" :model="form" ref="form" :rules="rule">
        <el-form-item label="组件名称" prop="module.code">
          <el-select v-model="form.module.code" filterable placeholder="请选择">
            <el-option
              v-for="item in modules"
              :key="item.value"
              :label="item.text"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="业务名称"  prop="business.code">
          <el-select v-model="form.business.code" filterable placeholder="请选择">
            <el-option
              v-for="item in businesstypes"
              :key="item.value"
              :label="item.text"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="监控类型"  prop="monitorType.code">
          <el-select v-model="form.monitorType.code" filterable placeholder="请选择">
            <el-option
              v-for="item in monitortypes"
              :key="item.value"
              :label="item.text"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否启用" required>
          <el-switch on-text="启用" off-text="禁用" on-color="#13ce66" off-color="#ff4949" v-model="form.isOpen"></el-switch>
        </el-form-item>
        <el-form-item label="备注信息" style="padding-left: 10px;">
          <el-input type="textarea" v-model="form.remark"></el-input>
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
import { mapState } from 'vuex';

import mixin from './mixin';
  export default {
    name: 'ModulesSetting',
    mixins: [mixin],
    data() {
      return {
        tab: this.$route.meta.tab,
        currentPage: 1,
        dialogVisible: false,
        clickType: 'new',
        form: {
          module_code: '',
          business_code: '',
          module: {
            code: '',
            name: ''
          },
          business: {
            code: '',
            name: ''
          },
          remark: '',
          isOpen: true,
          monitor_type: '',
          monitorType: {
            code: '',
            name: ''
          }
        },
        rule: {
          'module.code': [
            { type: 'number', required: true, message: '请选择组件名称', trigger: 'change' }
          ],
          'business.code': [
            { required: true, message: '请选择业务名称', trigger: 'change' }
          ],
          'monitorType.code': [
            { type: 'number', required: true, message: '请选择监控类型', trigger: 'change' }
          ]
        },
        filters: {
          module_code: '',
          business_code: '',
        },
        thNames: [{
          label: '监控类型',
          width: 120,
          props: 'monitorType.name',
        }, {
          label: '备注信息',
          props: 'remark'
        }],
      }
    },
    computed: {
      modules() {
        return this.$store.getters.moduleFilters
      },
      module() {
        return this.$store.getters.module
      },
      businesstypes() {
        return this.$store.getters.businessTypeFilters
      },
      businessType() {
        return this.$store.getters.businessType
      },
      monitortypes() {
        return this.$store.getters.monitorFilters
      },
      monitorType() {
        return this.$store.getters.monitorType
      },
      ...mapState({
        loading: state => state.itemData['module/insert'].isFetching,
        updateStatus: state => state.itemData['module/update'].isOk,
        insertStatus: state => state.itemData['module/insert'].isOk,
      }),

    },
    methods: {

      handleCurrentChange(val) {
        this.currentPage = val;
        let sSearch = {
          module_code: this.filters.module_code,
          business_code: this.filters.business_code
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
      filterChange(filters) {
        if (filters.module_code !== undefined) {
          this.filters['module_code'] = filters.module_code[0];
        }
        if(filters.business_code !== undefined) {
          this.filters['business_code'] = filters.business_code[0];
        }

        let sSearch = {
          module_code: this.filters.module_code,
          business_code: this.filters.business_code
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

      sortChange({ column, prop, order }) {
        this.filters['sortProp'] = prop;
        this.filters['order'] = order === 'ascending' ? 'ASC' : 'DESC';
        let sSearch = {
          module_code: this.filters.module_code,
          business_code: this.filters.business_code
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

      handleEdit(index, row) {
        this.dialogVisible = true;
        this.clickType = 'edit';
        this.form = {
          id: row.id,
          module_code: row.module_code,
          module: {
            code: row.module.code,
            name: row.module.name
          },
          business_code: String(row.business_code),
          business: {
            code: String(row.business_code),
            name: row.business.name
          },
          remark: row.remark,
          isOpen: row.status === 1 ? true : false,
          monitor_type: row.monitor_type,
          monitorType: {
            code: row.monitorType.code,
            name: row.monitorType.name
          },
          index: index
        }
      },
      submitForm() {
        this.$refs['form'].validate((valid) => {
          console.log(valid);
          if (!valid) {
            return false;
          }else{
            this.dialogVisible = false;
            if (this.clickType === 'edit') {
              let index = this.form.index;
              this.tableData[index].status = this.form.isOpen ? 1 : 0;
              this.tableData[index].module_code = this.form.module_code;
              this.tableData[index].module = {
                code: this.form.module.code,
                name: this.module[this.form.module.code]
              };
              this.tableData[index].business_code = this.form.business_code;
              this.tableData[index].business = {
                code: this.form.business.code,
                name: this.businessType[this.form.business.code]
              };
              this.tableData[index].monitor_type = this.form.monitor_type;
              this.tableData[index].monitorType = {
                code: this.form.monitorType.code,
                name: this.monitorType[this.form.monitorType.code]
              };
              this.tableData[index].remark = this.form.remark;
              const params = {
                status: this.form.isOpen ? 1 : 0,
                module_code: this.form.module.code,
                business_code: this.form.business.code,
                monitor_type: this.form.monitorType.code,
                id: this.tableData[index].id,
                remark: this.form.remark
              }
              this.updateData({
                tab: 'module/update',
                params
              });
            }else{
              const params = {
                status: this.form.isOpen ? 1 : 0,
                module_code: this.form.module.code,
                business_code: this.form.business.code,
                monitor_type: this.form.monitorType.code,
                remark: this.form.remark
              }
              this.updateData({
                tab: 'module/insert',
                params
              });
              setTimeout(() => {
                let sSearch = {}
                const params = {
                  sSearch: JSON.stringify(sSearch),
                  iDisplayStart: 0,
                  iDisplayLength: this.$pageSize,
                  iSortCol_0: 'create_time',
                  sSortDir_0: 'DESC'
                };
                this.fetchInit(params);
              }, 500)
            }
          }
        });



      },
      handleChange(index, row) {
        const params = {
          status: row.isOpen ? 1 : 0,
          module_code: row.module_code,
          business_code: row.business_code,
          monitor_type: row.monitor_type,
          remark: row.remark,
          id: row.id
        }
        row.status = row.isOpen ? 1 : 0;
        this.updateData({
          tab: 'module/update',
          params
        });
      },
      handleClose() {
        this.form = {
          module_code: '',
          business_code: '',
          module: {
            code: '',
            name: ''
          },
          business: {
            code: '',
            name: ''
          },
          remark: '',
          isOpen: true,
          monitor_type: '',
          monitorType: {
            code: '',
            name: ''
          }
        }
      }

    }
  }
</script>
