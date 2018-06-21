import { fetchServiceData } from './api';
import types from '../mutation-types';

export const refreshList = ({ commit }, { tab }) => {
  commit(types.refreshData, { tab });
};
export const receiveList = ({ commit }, { response, tab }) => {
  commit(types.receiveDataSuccess, {
    list: response.data,
    tab,
    total: response.totalCount,
    errorTotal: response.errorTotal
  });
};
export const fetchData = ({ commit, dispatch }, { tab, params, method }) => {
  commit(types.requestData, { tab });
  fetchServiceData(tab, params, method).then((response) => {
    if(response.isOk || response.isOk === 'true'){
      dispatch('receiveList', { response, tab });
    }else{
      commit(types.receiveDataFailure, { error, tab });
    }
  }).catch((error) => {
    commit(types.receiveDataFailure, { error, tab });
  });
};

const shouldFetchList = (state, tab) => {
  if (state[tab].items.length === 0) {
    return true;
  }
  if (!state[tab].isFetching) {
    return true;
  }
  return state[tab].didInvalidate;
};

export const fetchDataIfNeeded = ({ dispatch, state }, { tab, params, method }) => {
  if (shouldFetchList(state, tab)) {
    dispatch('fetchData', { tab, params, method });
  }
};
