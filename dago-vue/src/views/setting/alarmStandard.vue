<template>
  <div class="setting-manager">
    <el-form label-position="left" ref="form" :model="form" label-width="120px" style="width: 80%;">
      <el-form-item label="报警联系人" style="display: inline-block;">
        <el-input v-model="form.alarm_name" style="width: 30%">
          <template slot="prepend">姓名</template>
        </el-input>
        <el-input v-model="form.alarm_phone" style="width: 30%">
          <template slot="prepend">电话</template>
        </el-input>
        <el-input v-model="form.alarm_email" style="width: 30%">
          <template slot="prepend">邮件</template>
        </el-input>
      </el-form-item>
      <el-form-item label="报警维度">
        <el-radio-group v-model="form.alarm_dimension">
          <el-radio :label="1">厂商</el-radio>
          <el-radio :label="2">接入中心</el-radio>
          <el-radio :label="3">数据类型</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="报警时长">
        <el-button icon="plus" @click="addAlarmDuration"></el-button>
      </el-form-item>
      <el-form-item
        label=""
        v-for="(info, index) in form.dataTypes"
        :key="index"
      >
        <el-select v-model="info.data_type" clearable filterable placeholder="请选择数据类型" style="width: 250px;">
          <el-option
            v-for="item in datatypes"
            :key="item.value"
            :label="item.text"
            :value="item.value">
          </el-option>
        </el-select>
        <el-input v-model.number="info.time_period" style="width: 100px">
          <template slot="append">小时</template>
        </el-input>
        <el-button type="danger" icon="minus" @click.prevent="removeAlarmDuration(info)"></el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit" :loading="loading">保存</el-button>
        <el-button @click="onCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { mapState, mapActions } from 'vuex';
  export default {
    name: 'SettingAlarmStandard',
    data() {
      return {
        tab: this.$route.meta.tab,
        form: {
          alarm_name: '',
          alarm_email: '',
          alarm_phone: '',
          alarm_dimension: 1,
          dataTypes: [{
            data_type: '',
            time_period: 2
          }]
        }
      }
    },
    computed: {
      ...mapState({
        data: state => state.listData['businessAlarm/query'].items,
        loading: state => state.itemData['businessAlarm/update'].isFetching,
        updateStatus: state => state.itemData['businessAlarm/update'].isOk
      }),
      datatypes() {
        return this.$store.getters.datatypeFilters
      },
    },
    watch: {
      loading(to) {
        if(!to && this.updateStatus){
          this.$message({
            showClose: false,
            message: '更新数据成功！',
            type: 'success'
          });

        }
      },
      updateStatus(to, from) {
        if(!to) {
          this.$message.error('更新数据失败，请联系管理员');
        }
      },
      data(to){
        if(!(to instanceof Array)){
          this.form = {
            ...to
          };
        }
      }
    },
    beforeMount(){
      const {
        tab,
      } = this;
      this.refreshList({
        tab
      });
      this.fetchDataIfNeeded({
        tab,
      });
    },
    methods: {
      ...mapActions([
        'fetchDataIfNeeded',
        'refreshList',
        'updateData'
      ]),
      onCancel() {
        const {
          tab,
        } = this;
        this.refreshList({
          tab
        });
        this.fetchDataIfNeeded({
          tab,
        });
      },
      onSubmit() {
        let params = {
          id: this.form.id,
          alarm_name: this.form.alarm_name,
          alarm_phone: this.form.alarm_phone,
          alarm_email: this.form.alarm_email,
          alarm_dimension: this.form.alarm_dimension
        };
        for (var i = 0; i < this.form.dataTypes.length; i++) {
          params['dataTypes['+i+'].data_type'] = this.form.dataTypes[i].data_type;
          params['dataTypes['+i+'].time_period'] = this.form.dataTypes[i].time_period;
        }

        this.updateData({
          tab: 'businessAlarm/update',
          params
        });
      },
      removeAlarmDuration(item) {
        var index = this.form.dataTypes.indexOf(item)
        if (index !== -1) {
          this.form.dataTypes.splice(index, 1)
        }
      },

      addAlarmDuration() {
        this.form.dataTypes.unshift({
          data_type: '',
          time_period: 2,
        });
      }
    }
  }
</script>
