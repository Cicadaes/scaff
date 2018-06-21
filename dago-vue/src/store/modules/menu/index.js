import lazyLoading from './lazyLoading.js'
import types from '../../mutation-types';
import * as menuActions from '../../actions/menu';

const state = {
  isMini: false,
  items: [
    {
      name: '数据集成',
      path: '/integration',
      meta: {
        auth: true,
        icon: 'el-icon-share',
        link: 'integration/index.vue'
      },
      component: lazyLoading('integration', true),
      children: [
      // {
      //   name: '集成配置',
      //   path: '/integration/manage',
      //   meta: {
      //     auth: true,
      //     tab: ''
      //   },
      //   component: lazyLoading('integration/manage', false),
      // },
      // {
      //   name: '测试',
      //   path: '/integration/test',
      //   meta: {
      //     auth: true,
      //     tab: ''
      //   },
      //   component: lazyLoading('integration/test', false),
      // },
      {
        name: '集成配置',
        path: '/integration/taskManage',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('integration/taskManage', false),
      },
      {
        name: '集成日志',
        path: '/integration/log',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('integration/log', false),
      },
      {
        name: '插件管理',
        path: '/integration/plug',
        meta: {
          auth: true,
          icon: 'el-icon-view',
          tab: '',
          filter: true
        },
        component: lazyLoading('integration/plug', false),
      },
    ]
  },
  // {
  //   name: '开发管理',
  //   path: '/management',
  //   level: true,
  //   meta: {
  //     auth: true,
  //     icon: 'el-icon-upload',
  //     link: 'management/index.vue'
  //   },
  //   component: lazyLoading('management', true),
  //
  //
  //   children: [
  //
  //     {
  //       name: '插件配置',
  //       path: '/integration/plugOperation',
  //       meta: {
  //         auth: true,
  //         icon: 'el-icon-view',
  //         tab: '',
  //         filter: true
  //       },
  //       component: lazyLoading('integration/plugOperation', false),
  //     },
  //   ]
  //
  //
  // },
    {
      name: '数据治理',
      path: '/dataGovern',
      meta: {
        auth: true,
        icon: 'el-icon-menu',
        link: 'dataGovern/index.vue'
      },
      component: lazyLoading('dataGovern', true),
      children: [
      {
        name: '数据概况',
        path: '/dataGovern/govern',
        meta: {
          auth: true,
          icon: 'el-icon-view',
          tab: 'data/govern/list',
          filter: true
        },
        component: lazyLoading('dataGovern/govern', false),
      },
      {
        name: '数据标准',
        path: '/dataGovern/benchmark',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/benchmark', false),
      },
      {
        name: '元数据集',
        path: '/dataGovern/metaData',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/metaData', false),
      },
      {
        name: '黑名单管理',
        path: '/dataGovern/blackNameManage',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/blackNameManage', false),
      },
      {
        name: '治理任务',
        path: '/dataGovern/taskGovern',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/taskGovern', false),
      },
      {
        name: '数据统计',
        path: '/dataGovern/count',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/count', false),
      },
      {
        name: '通用数据',
        path: '/dataGovern/currency',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/currency', false),
      },
      {
        name: '核查标准',
        path: '/dataGovern/check',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/check', false),
      },
      {
        name: '核查记录',
        path: '/dataGovern/checkLog',
        meta: {
          auth: true,
          tab: ''
        },
        component: lazyLoading('dataGovern/checkLog', false),
      },
]
    },
  {
    name: '任务调度',
    path: '/taskScheduling',
    meta: {
      auth: true,
      icon: 'el-icon-date',
      link: '/taskScheduling/index.vue'
    },
    component: lazyLoading('taskScheduling', true),
    children: [
    {
      name: '调度管理',
      path: '/taskScheduling/manage',
      meta: {
        auth: true,
        icon: 'el-icon-view',
        filter: true,
        tab: ''
      },
      component: lazyLoading('taskScheduling/manage', false),
    },
    {
      name: '调度日志',
      path: '/taskScheduling/log',
      meta: {
        auth: true,
        tab: ''
      },
      component: lazyLoading('taskScheduling/log', false),
    },
    {
      name: '执行器管理',
      path: '/taskScheduling/actuator',
      meta: {
        auth: true,
        tab: ''
      },
      component: lazyLoading('taskScheduling/actuator', false),
    },
  ]
},
{
  name: '集中配置',
  path: '/centralizedAllocation',
  meta: {
    auth: true,
    icon: 'el-icon-information',
    link: 'centralizedAllocation/index.vue'
  },
  component: lazyLoading('centralizedAllocation', true),
  children: [
  {
    name: '通用配置',
    path: '/centralizedAllocation/currency',
    meta: {
      auth: true,
      icon: 'el-icon-view',
      tab: '',
      filter: true
    },
    component: lazyLoading('centralizedAllocation/currency', false),
  },
  {
    name: '组件配置',
    path: '/centralizedAllocation/component',
    meta: {
      auth: true,
      tab: ''
    },
    component: lazyLoading('centralizedAllocation/component', false),
  }
]
},
{
  name: '系统监控',
  path: '/systemMonitor',
  meta: {
    auth: true,
    icon: 'el-icon-view',
    link: 'systemMonitor/index.vue'
  },
  component: lazyLoading('systemMonitor', true),
  children: [{
    name: '整体概况',
    path: '/service',
    meta: {
      auth: true,
      tab: 'home/outline'
    },
    component: lazyLoading('service', true),
  },{
      name: '服务监控',
      path: '/serve',
      meta: {
        auth: true,
        icon: 'el-icon-upload',
        tab: 'service/list'
      },
      component: lazyLoading('serve', true)
    },
    {
      name: '系统监控',
      path: '/platform',
      level: true,
      meta: {
        auth: true,
        icon: '',
        link: 'platform/index.vue'
      },
      component: lazyLoading('platform', true),
      children: [{
        name: '机器信息',
        path: '/platform/machine-info',
        meta: {
          auth: true,
          tab: 'platform/list'
        },
        component: lazyLoading('platform/machineInfo', false),
      },{
        name: '机器监控',
        path: '/platform/machine-monitor',
        meta: {
          auth: true,
          tab: 'platform/alldata'
        },
        component: lazyLoading('platform/machineMonitor', false),
      }]
    },
    {
        name: '数据监控',
        path: '/data',
        level: true,
        meta: {
          auth: true,
          icon: '',
          link: 'data/index.vue'
        },
        component: lazyLoading('data', true),
        children: [
          {
            name: '数据汇总情况',
            path: '/data/statistics',
            meta: {
              auth: true,
              icon: '',
              tab: 'data/company/list',
              filter: false
            },
            component: lazyLoading('data/statistics', false),
          },
            {
              name: '数据有效监控',
              path: '/data/validator',
              meta: {
                auth: true,
                icon: '',
                tab: 'data/valid',
                filter: true
              },
              component: lazyLoading('data/validator', false),
            },
            {
              name: '文件延时监控',
              path: '/data/delay',
              meta: {
                auth: true,
                icon: '',
                tab: 'data/filedelay',
                filter: true
              },
              component: lazyLoading('data/delay', false),
            },
            {
              name: '数据稳定监控',
              path: '/data/stable',
              meta: {
                auth: true,
                icon: '',
                tab: 'data/stable',
                filter: true
              },
              component: lazyLoading('data/stable', false),
            },

            ]
          },
          {
              name: '监控配置',
              path: '/systemMonitor/configure',
              meta: {
                auth: true,
                tab: ''
              },
              component: lazyLoading('systemMonitor/configure', false)
            }
  ]
},
{
  name: '系统设置',
  path: '/setting',
  meta: {
    auth: true,
    icon: 'el-icon-setting',
    link: 'setting/index.vue'
  },
  component: lazyLoading('setting', true),
  children: [
    {
      name: '组件基础配置',
      path: '/setting/business',
      meta: {
        auth: true,
      },
      component: lazyLoading('setting/moduleIndex', false),
      redirect: '/setting/business-modules',
      children: [{
        name: '组件类型',
        path: '/setting/business-modules',
        meta: {
          auth: true,
          tab: 'businessModule/list'
        },
        component: lazyLoading('setting/business', false),
      },
      {
        name: '组件数据',
        path: '/setting/modules',
        meta: {
          auth: true,
          tab: 'module/list'
        },
        component: lazyLoading('setting/modules', false),
      }]
    },
    {
      name: '参数管理',
      path: '/integration/parameter',
      meta: {
        auth: true,
        icon: 'el-icon-view',
        tab: '',
        filter: true
      },
      component: lazyLoading('integration/parameter', false),
    },
    {
      name: '数据字典管理',
      path: '/setting/dicts',
      meta: {
        auth: true,
      },
      component: lazyLoading('setting/dictsIndex', false),
      redirect: '/setting/dicts-base',
      children: [{
        name: '基础字典',
        path: '/setting/dicts-base',
        meta: {
          auth: true,
          tab: 'dict/listpage'
        },
        component: lazyLoading('setting/dicts', false),
      },{
        name: '插件字典',
        path: '/setting/dicts-plug',
        meta: {
          auth: true,
        },
        component: lazyLoading('setting/dictionary', false),
      }]
    },
    // {
    //   name: '数据字典管理',
    //   path: '/setting/dicts',
    //   meta: {
    //     auth: true,
    //     link: 'dictionary/dictsIndex'
    //   },
    //   // redirect: '/setting/dicts',
    //   component: lazyLoading('dictionary/dictsIndex', false),
    //   children: [{
    //         name: '基础字典',
    //         path: '/setting/dicts',
    //         meta: {
    //           auth: true,
    //           tab: 'dict/listpage'
    //         },
    //         component: lazyLoading('setting/dicts', false)
    //       },
    //       {
    //         name: '插件字典',
    //         path: '/setting/dictionary',
    //         meta: {
    //           auth: true,
    //         },
    //         component: lazyLoading('setting/dictionary', false),
    //       },]
    //
    //
    // },
    // {
    //   name: '基础字典',
    //   path: '/setting/dicts',
    //   meta: {
    //     auth: true,
    //     tab: 'dict/listpage'
    //   },
    //   component: lazyLoading('setting/dicts', false)
    // },
    // {
    //   name: '插件字典',
    //   path: '/integration/dictionary',
    //   meta: {
    //     auth: true,
    //     icon: 'el-icon-view',
    //     tab: '',
    //     filter: true
    //   },
    //   component: lazyLoading('integration/dictionary', false),
    // },



    {
      name: '报警信息配置',
      path: '/setting/alarm',
      meta: {
        auth: true,
      },
      component: lazyLoading('setting/alarmIndex', false),
      redirect: '/setting/alarm-records',
      children: [{
        name: '报警记录',
        path: '/setting/alarm-records',
        meta: {
          auth: true,
          tab: 'businessAlarm/list'
        },
        component: lazyLoading('setting/alarm', false),
      },{
        name: '报警标准',
        path: '/setting/alarm-standard',
        meta: {
          auth: true,
          tab: 'businessAlarm/query'
        },
        component: lazyLoading('setting/alarmStandard', false),
      }]
    }
  ]
},
  ]
}
const actions = menuActions;
const mutations = {
  [types.changeSider] (state) {
    state.isMini = !state.isMini;
  },
}

export default {
  state,
  mutations,
  actions
}
