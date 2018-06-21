<template>
  <div class="setting-manager">
    <div style="position: absolute; right: 20px;">
      <el-button type="success" icon="plus" size="small" @click="handleNew">新增</el-button>
    </div>
    <div>
      <el-form :inline="true" label-width="80px" :model="filters" >
        <el-form-item label="组件编码">
          <el-input v-model="filters.module_code" @change="handleFilterChange"></el-input>
        </el-form-item>
        <el-form-item label="组件名称">
          <el-input v-model="filters.module_name" @change="handleFilterChange"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <el-table
    :data="tableData"
    border
    :row-class-name="tableRowClassName"
    style="width: 100%"
    @sort-change="sortChange">
      <el-table-column
        type="index"
        width="70">
      </el-table-column>
      <el-table-column
        v-for="(item, index) in thNames"
        :key="index"
        sortable="custom"
        :label="item.label"
        :prop="item.props"
        :width="item.width">

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
      <el-form :inline="true" :model="form" ref="form" :rules="rules">
        <el-form-item label="组件编码" prop="module_code">
          <el-input v-model.number="form.module_code"></el-input>
        </el-form-item>
        <el-form-item label="组件名称" prop="module_name">
          <el-input v-model="form.module_name"></el-input>
        </el-form-item>
        <el-form-item label="标准进程" prop="instance_num" required>
          <el-input-number v-model="form.instance_num" :min="1" :max="100"></el-input-number>
        </el-form-item>
        <el-form-item label="是否启用" required style="margin-left: 10px;">
          <el-switch on-text="启用" off-text="禁用" on-color="#13ce66" off-color="#ff4949" v-model="form.isOpen"></el-switch>
        </el-form-item>
        <br />
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
  name: 'SettingBusiness',
  mixins: [mixin],

  data() {
    return {
      tab: this.$route.meta.tab,
      currentPage: 1,
      dialogVisible: false,
      clickType: 'new',
      form: {
        module_code: '',
        module_name: '',
        remark: '',
        instance_num: 1,
        isOpen: true,
      },
      rules: {
        module_code: [
          { type: 'number', required: true, message: '请输入组件编码', trigger: 'blur' }
        ],
        module_name: [
          { required: true, message: '请输入组件名称', trigger: 'blur' }
        ],
      },
      filters: {
        module_code: '',
        module_name: '',
      },
      thNames: [{
        label: '组件编码',
        props: 'module_code',
      }, {
        label: '组件名称',
        props: 'module_name',
      }, {
        label: '标准进程数',
        props: 'instance_num'
      }, {
        label: '创建时间',
        props: 'create_time',
        width: '180',
      }, {
        label: '更新时间',
        props: 'update_time',
        width: '180',
      },{
        label: '备注信息',
        props: 'remark'
      }],
    }
  },
  computed: {
    ...mapState({
      loading: state => state.itemData['businessModule/save'].isFetching,
      updateStatus: state => state.itemData['businessModule/update'].isOk,
      insertStatus: state => state.itemData['businessModule/save'].isOk,
    }),
  },
  methods: {
    handleFilterChange(value) {
      let sSearch = {
        module_code: this.filters.module_code,
        module_name: this.filters.module_name
      }
      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: 0,
        iDisplayLength: this.$pageSize,
        iSortCol_0: 'create_time',
        sSortDir_0: 'DESC'
      };
      this.fetchInit(params);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      let sSearch = {
        module_code: this.filters.module_code,
        module_name: this.filters.module_name
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
      if(filters.business_name !== undefined) {
        this.filters['module_name'] = filters.module_name[0];
      }

      let sSearch = {
        module_code: this.filters.module_code,
        module_name: this.filters.module_name
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
        module_name: this.filters.module_name
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
        module_name: row.module_name,
        instance_num: row.instance_num,
        remark: row.remark,
        isOpen: row.status === 1 ? true : false,
        index: index
      }
    },
    submitForm() {
      this.$refs['form'].validate((valid) => {
        if (!valid) {
          return false;
        }else{
          this.dialogVisible = false;
          const params = {
            status: this.form.isOpen ? 1 : 0,
            module_code: this.form.module_code,
            module_name: this.form.module_name,
            instance_num: this.form.instance_num,
            remark: this.form.remark
          }
          if (this.clickType === 'edit') {
            params.id = this.form.id
            this.updateData({
              tab: 'businessModule/update',
              params
            });
          }else{
            this.updateData({
              tab: 'businessModule/save',
              params
            });
          }
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
      });



    },
    handleChange(index, row) {
      const params = {
        status: row.isOpen ? 1 : 0,
        module_code: row.module_code,
        module_name: row.module_name,
        remark: row.remark,
        id: row.id
      }
      row.status = row.isOpen ? 1 : 0;
      this.updateData({
        tab: 'businessModule/update',
        params
      });
    },
    handleClose() {
      this.form = {
        module_code: '',
        module_name: '',
        instance_num: 1,
        remark: '',
        isOpen: true,
      }
    }

  }

}
</script>
