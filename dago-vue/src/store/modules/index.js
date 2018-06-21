import menu from './menu';
import types from '../mutation-types';
import * as listActions from '../actions/list';
import * as operateActions from '../actions/edit';
const initStatus = {
  isFetching: false,
  didInvalidate: false,
  items: [],
  error: null,
  total: 0,
  errorTotal: 0,
  isEmpty: false
}
const state = {
  'home/outline': initStatus,
  'home/detail': initStatus,
  'home/loglist': initStatus,
  'data/company/list': initStatus,
  'data/company/detail': initStatus,
  'data/valid': initStatus,
  'data/filedelay': initStatus,
  running: initStatus,
  'data/stable': initStatus,
  'data/govern/list': initStatus,
  business: initStatus,
  'dict/factory': initStatus,
  'dict/input_data_type': initStatus,
  'dict/center': initStatus,
  'dict/business_type': initStatus,
  'dict/log_type': initStatus,
  'dict/log_code': initStatus,
  'dict/business_alarm_type': initStatus,
  'dict/dataGovern': initStatus,
  'module/list': initStatus,
  'dict/listpage': initStatus,
  'service/list': initStatus,
  'service/detail': initStatus,
  'businessModule/list': initStatus,
  'businessModules': initStatus,
  'businessAlarm/list': initStatus,
  'businessAlarm/query': initStatus,
  'platform/list':initStatus,
  'platform/alldata': initStatus,
};
const initOperateState = {
  isFetching: false,
  error: null,
  isOk: true,
  id: null
}
const operateState = {
  'module/update': initOperateState,
  'module/insert': initOperateState,
  'dict/insert': initOperateState,
  'dict/update': initOperateState,
  'platform/save': initOperateState,
  'platform/update': initOperateState,
  'platform/delete': initOperateState,
  'businessModule/update': initOperateState,
  'businessModule/save': initOperateState,
  'businessAlarm/update': initOperateState,
}

const actions = listActions;
const mutations = {
  [types.refreshData] (state, { tab }) {
    state[tab] = {
      ...state[tab],
      didInvalidate: true,
    }
  },
  [types.requestData] (state, { tab }) {
    state[tab] = {
      ...state[tab],
      isFetching: true,
      didInvalidate: false,
    }
  },
  [types.receiveDataSuccess] (state, { list, tab, total, errorTotal }) {
    let empty = (total === 0);
    state[tab] = {
      ...state[tab],
      isFetching: false,
      didInvalidate: false,
      items: list,
      isEmpty: empty,
      total: total,
      errorTotal: errorTotal
    }
  },
  [types.receiveDataFailure] (state, { error, tab }) {
    state[tab] = {
      ...state[tab],
      isFetching: false,
      didInvalidate: false,
      error: error
    }
  }
};
const operateMutations = {
  [types.operateData] (state, { tab, id }) {
    state[tab].isFetching = true;
    state[tab].id = id;
    state[tab].isOk = true;
  },
  [types.operateDataSuccess] (state, { tab, id }) {
    state[tab].isOk = true;
    state[tab].isFetching = false;
    state[tab].id = id;
  },
  [types.operateDataFailure] (state, { error, tab, id }) {
    state[tab].isOk = false;
    state[tab].id = id;
    state[tab].error = id;
    state[tab].isFetching = false;
  }
}
const listData = {
  state,
  actions,
  mutations
}
const itemData = {
  state: operateState,
  actions: operateActions,
  mutations: operateMutations
}
export default {
  menu,
  listData,
  itemData
}
