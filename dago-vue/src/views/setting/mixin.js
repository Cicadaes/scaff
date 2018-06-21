import Pagination from '../../components/Pagination';
import { mapGetters, mapActions } from 'vuex';
export default {
  components: {
    Pagination
  },
  computed: {
    ...mapGetters({
      tableData: 'listitems',
      total: 'listTotal'
    }),
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
  watch: {
    updateStatus(to, from) {
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
  methods: {
    ...mapActions([
      'fetchDataIfNeeded',
      'refreshList',
      'updateData'
    ]),
    tableRowClassName(row, index) {
      row.isOpen = (row.status === 1 || row.status === '1') ? true : false;
      if (row.status === 1 || row.status === '1') {
        return 'positive-row';
      } else {
        return 'danger-row';
      }
      return '';
    },
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

    handleNew() {
      this.dialogVisible = true;
      this.clickType = 'new';
    },

  }
}
