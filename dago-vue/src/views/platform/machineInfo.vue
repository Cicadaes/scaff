<template>
  <div class="platform">
    <div style="position: absolute; top: 10px;">
      <el-button type="success" icon="plus" size="small" @click="handleNew">新增</el-button>
    </div>
    <div>
      <el-form :inline="true" label-width="80px" :model="filters" >
        <el-form-item label="机器名">
          <el-input v-model.trim="filters.name" @change="handleChange"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <el-table
    :data="tableData"
    border
    stripe
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
        <template scope="scope">
          <span v-if="item.type === 'password'">******</span>
          <span v-else>{{scope.row[item.props]}}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="更新时间"
        prop="update_time"
        width="180"
        sortable="custom">

      </el-table-column>
      <el-table-column
        label="创建时间"
        prop="create_time"
        width="180">

      </el-table-column>

      <el-table-column label="操作" width="120">
        <template scope="scope">
          <el-button
            size="small"
            type="primary"
            icon="edit"
            @click="handleEdit(scope.$index, scope.row)">
          </el-button>
          <el-button
            size="small"
            type="danger"
            icon="delete"
            @click="handleDelete(scope.$index,scope.row)">
          </el-button>

        </template>
      </el-table-column>
    </el-table>
    <Pagination :page="currentPage" :total="total"  @current-change="handleCurrentChange" />
    <el-dialog :modal="false" :visible.sync="dialogVisible" @close="handleClose">
      <template slot="title">{{clickType === 'edit' ? "编辑" : "新增"}}</template>
      <el-form :inline="true" :model="form" ref="form" :rules="rules" label-width="80px">
        <el-form-item label="业务类型" prop="machine_type">
          <el-input v-model="form.machine_type"></el-input>
        </el-form-item>
        <el-form-item label="机器名" prop="machine_name">
          <el-input v-model="form.machine_name"></el-input>
        </el-form-item>
          <el-form-item label="IP地址" prop="machine_ip">
          <el-input v-model="form.machine_ip"></el-input>
        </el-form-item>
        <el-form-item label="端口号" prop="machine_port">
        <el-input v-model="form.machine_port"></el-input>
      </el-form-item>
        <el-form-item label="用户名" prop="machine_username">
          <el-input v-model="form.machine_username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="machine_pass">
          <el-input v-model="form.machine_pass" type="password"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" style="margin-right:30px;">
        <el-button @click="dialogVisible = false" style="margin:0 0 10px 0;">取 消</el-button>
        <el-button type="primary" @click="submitForm" style="margin:0 0 10px 0;" :loading="loading">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import Pagination from '../../components/Pagination';
import { mapGetters, mapActions, mapState } from 'vuex'

  export default {
    name: 'PlatformMachineInfo',
    components: {
      Pagination
    },
    data() {
      return {
        tab: this.$route.meta.tab,
        currentPage: 1,
        dialogVisible: false,
        clickType: 'new',
        form: {
          machine_id:'',
          machine_name: '',
          machine_type:'',
          machine_ip: '',
          machine_port: '',
          machine_username: '',
          machine_pass: ''
        },
        row: null,
        rules: {
          machine_name: [
             { required: true, message: '请输入机器名', trigger: 'blur' },
          ],
          machine_type: [
             { required: true, message: '请输入机器类型', trigger: 'blur' },
          ],
          machine_ip: [
            { required: true, message: '请输入IP', trigger: 'blur' },
            { pattern: /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/, message: '请输入正确的ip地址',trigger: 'blur,change'}
          ],
          machine_port: [
            { required: true, message: '请输入端口号', trigger: 'blur' },
            { pattern: /^([0-9]|[1-9]\d{1,3}|[1-5]\d{4}|6[0-5]{2}[0-3][0-5])$/, message: '请输入正确的端口号',trigger: 'blur,change'}
          ],
          machine_username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
          ],
          machine_pass: [
            { pattern: /^.{6,20}$/, message: '请输入4-25个字符的密码',trigger: 'blur,change'}
          ]
        },
        filters: {
          name: '',
          sortProp: 'update_time',
          order: 'DESC'
        },
        thNames: [{
          label: '业务类型',
          props: 'machine_type'
        },{
          label: '机器名',
          props: 'machine_name'
        },{
          label: 'IP地址',
          props: 'machine_ip',
          width:"160"
        },{
          label: '端口号',
          props: 'machine_port',
        },{
          label: '用户名',
          props: 'machine_username'
        },{
          label: '密码',
          props: 'machine_pass',
          type: 'password'
        }],
        params:{

        }
      }
    },
    computed: {
      ...mapState({
        loading: state => state.itemData['platform/save'].isFetching,
        updateStatus: state => state.itemData['platform/update'].isOk,
        insertStatus: state => state.itemData['platform/save'].isOk,
        saveLoading: state => state.itemData['platform/save'].isFetching,
      }),

      ...mapGetters({
        tableData: 'listitems',
        total: 'listTotal'
      }),
    },
    watch: {
      updateStatus(to, from) {
        if(!to) {
          this.$message.error('更新数据失败，请联系管理员');
        }
      },
      insertStatus(to, from) {
        if(!to) {
          this.$message.error('修改数据失败，请联系管理员');
        }
      },

      deleteStatus(to, from) {
        if(!to) {
          this.$message.error('删除数据失败，请联系管理员')
        }
      },
      saveLoading(to, from){
        if(!to && this.insertStatus){
          this.$message({
           message: '操作成功',
           type: 'success'
          });
          let sSearch = {}
          const params = {
            sSearch: JSON.stringify(sSearch),
            iDisplayStart: 0,
            iDisplayLength: this.$pageSize,
            iSortCol_0: 'update_time',
            sSortDir_0: 'DESC'
          };
          this.fetchInit(params);
        }
      }
    },
    beforeMount() {
      let sSearch = {}
      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: 0,
        iDisplayLength: this.$pageSize,
        iSortCol_0: 'create_time',
        sSortDir_0: 'DESC'
      };
      this.fetchInit(params);

    },

    methods: {
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
      handleCurrentChange(val) {
        this.currentPage = val;
        let sSearch = {
          machine_name: this.filters.name
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
      handleChange() {
        let sSearch = {
          machine_name: this.filters.name
        }
        const params = {
          sSearch: JSON.stringify(sSearch),
          iDisplayStart: 0,
          iDisplayLength: this.$pageSize,
          iSortCol_0: 'update_time',
          sSortDir_0: 'DESC'
        };
        this.fetchInit(params);
      },
      sortChange({ column, prop, order }) {
        this.filters['sortProp'] = prop;
        this.filters['order'] = order === 'ascending' ? 'ASC' : 'DESC';
        let sSearch = {
          machine_name: this.filters.name
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
          machine_id: row.id,
          machine_name: row.machine_name,
          machine_type:row.machine_type,
          machine_ip: row.machine_ip,
          machine_port: row.machine_port.toString(),
          machine_username: row.machine_username,
          machine_pass: row.machine_password
        }
        this.row = row
      },
     handleDelete(index, row) {
       let params = {
         id:row.id
       }
       this.deleteWarn(params)
     },
     deleteWarn(params) {
       this.$confirm('此操作将永久删除该列表, 是否继续?', '提示', {
         confirmButtonText: '确定',
         cancelButtonText: '取消',
         type: 'warning'
       }).then(() => {
          this.updateData({
            tab: 'platform/delete',
            params
          });
         this.$message({
           type: 'success',
           message: '删除成功!'
         });
       }).catch(() => {
         this.$message({
           type: 'info',
           message: '已取消删除'
         });
       });
      },
     submitForm() {
         this.$refs['form'].validate((valid) => {
           if (!valid) {
             return false;
           }else{
             let vm = this;
             let params = {
               id:this.form.machine_id,
               machine_name: this.form.machine_name,
               machine_type:this.form.machine_type,
               machine_ip: this.form.machine_ip,
               machine_port: parseInt(this.form.machine_port),
               machine_username: this.form.machine_username,
               machine_password:this.form.machine_pass
             }
             this.params = params
             if(this.clickType === 'new'){
                   this.updateData({
                     tab: 'platform/save',
                     params
                   });
           }else{
                params.id = this.form.machine_id
                this.updateData({
                  tab: 'platform/update',
                  params
                });
           }
           this.dialogVisible = false;
           setTimeout(() => {
             let sSearch = {}
             const params = {
               sSearch: JSON.stringify(sSearch),
               iDisplayStart: 0,
               iDisplayLength: this.$pageSize,
               iSortCol_0: 'update_time',
               sSortDir_0: 'DESC'
             };
             this.fetchInit(params);
             this.dialogVisible = false;
           }, 500)
           }
         });
      },
      handleClose() {
        this.form = {
          machine_name: '',
          machine_ip: '',
          machine_username: '',
          machine_pass: '',
          machine_type:''
        }
      }
    },
  }
</script>
