import Pagination from '../../components/Pagination';
import { mapGetters, mapActions } from 'vuex'
let mixin = {
  components: {
    Pagination
  },
  props: {
    filters: {
      type: Object,
      default: {}
    }
  },
  computed: {
    params() {
      return this.filters;
    },
    factories() {
      return this.$store.getters.factoryFilters
    },
    centers() {
      return this.$store.getters.centerFilters
    },
    datatypes() {
      return this.$store.getters.datatypeFilters
    },
    ...mapGetters({
      tableData: 'listitems',
      total: 'listTotal'

    }),
  },
  watch: {
    params(to, from){
      let sSearch = {
        stat_time_b: to.dateTime[0],
        stat_time_e: to.dateTime[1],
        company_id: to['company_id'] || '',
        center_code: to['center_code'] || '',
        data_type: to['data_type'] || '',
      }

      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: 0,
        iDisplayLength: this.$pageSize,
        iSortCol_0: to.sortProp,
        sSortDir_0: to.order
      };
      if (this.currentPage === 1) {
        this.fetchInit(params);
      }else{
        this.currentPage = 1;
      }
    }
  },
  beforeMount() {
    const {
      filters
    } = this;
    let sSearch = {
      stat_time_b: filters.dateTime[0],
      stat_time_e: filters.dateTime[1],
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
  methods: {
    ...mapActions([
      'fetchDataIfNeeded',
      'refreshList'
    ]),
    tableRowClassName(row, index) {
      if (row.validator === 0 || row.delay === 0 || row.stable === 0) {
        return '';
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
    handleCurrentChange(val) {
      this.currentPage = val;
      const {
        filters
      } = this;
      let sSearch = {
        stat_time_b: filters.dateTime[0],
        stat_time_e: filters.dateTime[1],
        company_id: this.filters['company_id'] || '',
        center_code: this.filters['center_code'] || '',
        data_type: this.filters['data_type'] || '',
      }
      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: this.$pageSize * (Number(val) - 1),
        iDisplayLength: this.$pageSize,
        iSortCol_0: this.filters.sortProp,
        sSortDir_0: this.filters.order
      };
      this.fetchInit(params);

    },

    filterChange(filters) {
      if (filters.company_id !== undefined) {
        this.filters['company_id'] = filters.company_id[0];
      }
      if(filters.center_code !== undefined) {
        this.filters['center_code'] = filters.center_code[0];
      }
      if(filters.data_type !== undefined) {
        this.filters['data_type'] = filters.data_type[0];
      }
      let sSearch = {
        stat_time_b: this.filters.dateTime[0],
        stat_time_e: this.filters.dateTime[1],
        company_id: this.filters['company_id'] || '',
        center_code: this.filters['center_code'] || '',
        data_type: this.filters['data_type'] || '',
      }
      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: 0,
        iDisplayLength: this.$pageSize,
        iSortCol_0: this.filters.sortProp,
        sSortDir_0: this.filters.order
      };

      if (this.currentPage === 1) {
        this.fetchInit(params);
      }else{
        this.currentPage = 1;
      }
    },

    sortChange({ column, prop, order }) {
      this.filters['sortProp'] = prop;
      this.filters['order'] = order === 'ascending' ? 'ASC' : 'DESC';
      let sSearch = {
        stat_time_b: this.filters.dateTime[0],
        stat_time_e: this.filters.dateTime[1],
        company_id: this.filters['company_id'] || '',
        center_code: this.filters['center_code'] || '',
        data_type: this.filters['data_type'] || '',
      }

      const params = {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: 0,
        iDisplayLength: this.$pageSize,
        iSortCol_0: this.filters.sortProp,
        sSortDir_0: this.filters.order
      };

      if (this.currentPage === 1) {
        this.fetchInit(params);
      }else{
        this.currentPage = 1;
      }
    },
  }
}
export default mixin;
