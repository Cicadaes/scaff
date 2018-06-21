<template>
    <div class="data-type" style="min-width:890px;">
        <div class="machine-type">
            <el-form :inline="true" label-width="80px">
                <span style="margin-right:6px;">设备类型</span>
                <el-select v-model="value" clearable placeholder="请选择" @change="changeValue">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
                <el-form-item label="日期选择">
                    <div>
                        <el-date-picker v-model="time_start" type="date" placeholder="起始日期" @change="start">
                        </el-date-picker>
                        <el-form-item label="至" label-width="25px" style="margin-left:6px;">
                            <el-date-picker v-model="time_end" type="date" format="yyyy-MM-dd" placeholder="结束日期" @change="end">
                            </el-date-picker>
                        </el-form-item>
                    </div>
                </el-form-item>
                <el-button type="primary" @click="check">查询</el-button>
            </el-form>
        </div>
        <el-table :data="tableData" border style="width: 100%">
            <el-table-column prop="device_type" label="设备类型">
            </el-table-column>
            <el-table-column prop="field_type" label="统计的字段">
            </el-table-column>
            <el-table-column prop="field_value" label="字段取值">
            </el-table-column>
            <el-table-column prop="total" label="字段类型总数">
            </el-table-column>
            <el-table-column prop="percent" label="占比">
            </el-table-column>
            <el-table-column prop="data_type" label="数据类型">
            </el-table-column>
            <el-table-column prop="stat_time" label="统计日期">
            </el-table-column>
        </el-table>
        <Pagination :pageSize="pageSize" :page="currentPage" :total="total" @current-change="handleCurrentChange" />
    </div>
</template>
<script>
import Pagination from '../../components/Pagination';
import { mapGetters, mapActions, mapState } from 'vuex'
export default {
    name: 'count',
    data() {
        return {
            value: '',
            time_start: '',
            time_end: '',
            currentPage: 1,
            pageSize: 20,
            iDisplayLength: 20,
            tab: 'data/govern/list'
        }
    },
    components: {
        Pagination
    },
    computed: {
        ...mapGetters({
            tableData: 'listitems',
            total: 'listTotal',
            options: 'dataGovern'
        }),
    },
    methods: {
        ...mapActions([
            'fetchDataIfNeeded',
            'refreshList'
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
        changeValue(value) {
            this.value = value;
        },
        start(date) {
            this.time_start = date;
        },
        end(date) {
            this.time_end = date;
        },
        check() {
            let sSearch = {
                device_type: this.value,
                stat_time_b: this.time_start,
                stat_time_e: this.time_end,
            }
            const params = {
                sSearch: JSON.stringify(sSearch),
                iDisplayStart: 0,
                iDisplayLength: this.pageSize
            }
            this.fetchInit(params);
            this.currentPage = 1;
        },
        handleCurrentChange(val) {
            this.currentPage = val;
            let sSearch = {
                device_type: this.value,
                stat_time_b: this.time_start,
                stat_time_e: this.time_end,
            }
            const params = {
                sSearch: JSON.stringify(sSearch),
                iDisplayStart: (val - 1) * this.pageSize,
                iDisplayLength: this.pageSize,
            };
            this.fetchInit(params);
        }
    }
}
</script>
<style lang='less'>
@import '../../assets/styles/govern';
</style>
