<style lang='less'>

@import '../../assets/styles/data';
.check-standard {
    .el-select .el-input {
        width: 150px;
    }
}

</style>

<template>

<div class="data-stable check-standard">
    <el-tabs class="check-standard" v-model="activeName2" type="card" @tab-click="handleClick">
        <el-tab-pane label="人工自助" name="self-help">
            <div>
                <el-input placeholder="请输入Mysql查询语句" v-model="select">
                    <el-select v-model="selectd" slot="prepend" placeholder="黑名单查询" clearable>
                        <el-option label="Mysql1" value="SELECT * FROM tb_stu WHERE name = '王小虎'"></el-option>
                        <el-option label="Mysql2" value="SELECT * FROM tb_stu WHERE sex = '男'"></el-option>
                        <el-option label="Mysql3" value="SELECT * from tb_stu WHERE age = '18'"></el-option>
                    </el-select>
                    <el-button slot="append" icon="search" @click="inquire"></el-button>
                </el-input>
                <div v-show="dataTable" style="margin-top:10px;" class="animated fadeIn">
                    <el-table :data="tableData" style="width: 100%">
                        <el-table-column prop="name" label="name" width="180">
                        </el-table-column>
                        <el-table-column prop="sex" label="sex" width="180">
                        </el-table-column>
                        <el-table-column prop="age" label="age">
                        </el-table-column>
                        <el-table-column prop="oprate" label="操作">
                          <template scope="scope" class="operate">
                            <el-tooltip class="item" effect="dark" content="执行" placement="top">
                                <el-button size="small" type="success" icon="d-arrow-right" @click="">
                                </el-button>
                            </el-tooltip>
                              <el-button size="small" type="danger" icon="delete" @click="">
                              </el-button>
                          </template>
                        </el-table-column>
                    </el-table>
                </div>
            </div>
        </el-tab-pane>
        <el-tab-pane label="自动调度" name="automatic">自动调度</el-tab-pane>
    </el-tabs>
</div>

</template>

<script>

export default {
    name: 'Checkstandard',
    data() {
        return {
            activeName2: 'self-help',
            input3: '',
            input4: '',
            input5: '',
            select: '',
            selectd: '',
            dataTable: false,
            tableData: [{
                name: '王小虎',
                sex: '男',
                age: '18',
            }, {
              name: '王小虎',
              sex: '男',
              age: '18',
            }, {
              name: '王小虎',
              sex: '男',
              age: '18',
            }, {
              name: '王小虎',
              sex: '男',
              age: '18',
            }]
        };
    },
    watch:{
      'selectd': function (to) {
        this.select = to
        this.dataTable = false
      }
    },
    mounted() {
        $(".check-standard").css({
            minHeight: $(window).height() - 160
        })
        $(".el-tabs__content").css({
            minHeight: $(window).height() - 260
        })
    },
    methods: {
        handleClick(tab, event) {
                console.log(tab, event);
            },
            inquire() {
                if (this.select != '') {
                    this.dataTable = true
                }
            }
    }
};

</script>
