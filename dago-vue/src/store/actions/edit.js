import { fetchServiceData } from './api';
import types from '../mutation-types';

export const updateData = ({ commit, dispatch }, { tab, params }) => {
  commit(types.operateData, { tab, id: params.id });
  fetchServiceData(tab, params).then((response) => {
    if(response.isOk || response.isOk === 'true'){
      commit(types.operateDataSuccess, { tab, id: params.id });
    }else{
      commit(types.operateDataFailure, { error, tab, id: params.id });
    }
  }).catch((error) => {
    commit(types.operateDataFailure, { error, tab, id: params.id });
  });
};
