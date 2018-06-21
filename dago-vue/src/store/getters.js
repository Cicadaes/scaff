import moment from 'moment';
moment.locale('zh-CN');

const menuitems = state => state.menu.items;

const factory = state => {
    let obj = {};
    state.listData['dict/factory'].items.forEach(item => {
        obj[item.code] = item.name;
    });
    return obj;
}
const factoryFilters = state => {
    let items = [];
    state.listData['dict/factory'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.name;
        items[index].value = item.code;
    })
    return items;
}
const datatype = state => {
    let obj = {};
    state.listData['dict/input_data_type'].items.forEach(item => {
        obj[item.name] = item.value;
    });
    return obj;
}
const datatypeFilters = state => {
    let items = [];
    state.listData['dict/input_data_type'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.value;
        items[index].value = item.name;
    })
    return items;
}
const center = state => {
    let obj = {};
    state.listData['dict/center'].items.forEach(item => {
        obj[item.code] = item.name;
    });
    return obj;
}
const centerFilters = state => {
    let items = [];
    state.listData['dict/center'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.name;
        items[index].value = item.code;
    })
    return items;
}
const module = state => {
    let obj = {};
    state.listData['businessModules'].items.forEach(item => {
        obj[item.module_code] = item.module_name;
    });
    return obj;
}
const alarmType = state => {
    let obj = {};
    state.listData['dict/business_alarm_type'].items.forEach(item => {
        obj[item.name] = item.value;
    });
    return obj;
}
const alarmTypeFilters = state => {
    let items = [];
    state.listData['dict/business_alarm_type'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.value;
        items[index].value = item.name;
    })
    return items;
}
const monitorType = state => {
    let obj = {
        0: '实时统计',
        1: '定时统计',
        2: '分时统计'
    }
    return obj;
}
const monitorFilters = state => {
    let items = [{
        text: '实时统计',
        value: 0
    }, {
        text: '定时统计',
        value: 1
    }, {
        text: '分时统计',
        value: 2
    }]
    return items;
}
const moduleFilters = state => {
    let items = [];
    state.listData['businessModules'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.module_name;
        items[index].value = item.module_code;
    })
    return items;
}

const businessType = state => {
    let obj = {};
    state.listData['dict/business_type'].items.forEach(item => {
        obj[item.name] = item.value;
    });
    return obj;
}
const businessTypeFilters = state => {
    let items = [];
    state.listData['dict/business_type'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.value;
        items[index].value = item.name;
    })
    return items;
}

const logType = state => {
    let obj = {};
    state.listData['dict/log_type'].items.forEach(item => {
        obj[item.name] = item.value;
    });
    return obj;
}
const logTypeFilters = state => {
    let items = [];
    state.listData['dict/log_type'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.value;
        items[index].value = item.name;
    })
    return items;
}
const log = state => {
    let obj = {};
    state.listData['dict/log_code'].items.forEach(item => {
        obj[item.name] = item.value;
    });
    return obj;
}
const logFilters = state => {
    let items = [];
    state.listData['dict/log_code'].items.forEach(function(item, index) {
        items[index] = {}
        items[index].text = item.value;
        items[index].value = item.name;
    })
    return items;
}
Array.prototype.removeRepeatAttr=function(){
    var tmp={},b=[],a=this;
    for(var i=0;i<a.length;i++){
        if(!tmp[a[i].value]){
          if(a[i].value != undefined){
            b.push(a[i]);
            tmp[a[i].value]=!0;
          }
        }
    };
    return b;
}
const dataGovern = state => {
    let items = [];
    state.listData['dict/dataGovern'].items.forEach(function(item, index){
        items[index] = {}
        if(item.desc !=''){
            items[index].value = item.name;
            items[index].label = item.desc;
        }
    })
    return items.removeRepeatAttr();
}

function searchItem(array, value) {
    return array.filter(function(item, index) {
        return String(item['code']) === String(value)
    })[0];
}

function formatPercent(error, total) {
    if (error === '0') {
        return '0%';
    }
    let _total = total === '0' ? error : total;
    return ((error / _total) * 100).toFixed(0) + '%';
}

function numberToIp(number) {
    let ip = "";
    if (number <= 0) {
        return ip;
    }
    let ip3 = (number << 0) >>> 24;
    let ip2 = (number << 8) >>> 24;
    let ip1 = (number << 16) >>> 24;
    let ip0 = (number << 24) >>> 24

    ip += ip3 + "." + ip2 + "." + ip1 + "." + ip0;

    return ip;
}

function dataType(number) {
    let data_type = '';
    switch (number) {
        case 0:
            data_type = '围栏';
            break;
        case 1:
            data_type = '虚拟身份轨迹'
            break;
        case 2:
            data_type = '上网日志';
            break;
        case 3:
            data_type = '终端上下线';
            break;
        case 4:
            data_type = '开卡数据';
            break;
        default:
            break;
    }
    return data_type;
}

function fieldType(number) {
    let field_type = '';
    switch (number) {
        case 0:
            field_type = 'type';
            break;
        case 1:
            field_type = 'COLLECT_SCENE'
            break;
        case 2:
            field_type = 'ACCOUNT_MODE';
            break;
        case 3:
            field_type = 'TER_TYPE';
            break;
        case 4:
            field_type = 'AUTH_STYLE';
            break;
        case 5:
            field_type = 'NET_SITUATION';
            break;
        case 6:
            field_type = 'CARD_STYLE';
            break;
        default:
            break;
    }
    return field_type;
}

function deviceType(number){
    let device_type = '';
    switch (number) {
        case "10,11,12":
            device_type = '围栏';
            break;
        case "00,01":
            device_type = 'AP'
            break;
        // case 3:
        //     device_type = 'PON';
        //     break;
        // case 4:
        //     device_type = 'H系列';
        //     break;
        // case 5:
        //     device_type = 'GW系列';
        //     break;
        default:
            break;
    }
    return device_type;
}

const listitems = (state) => {
    if (state.route.meta.tab && state.listData[state.route.meta.tab].items instanceof Array) {
        let factories = factory(state);
        let datatypes = datatype(state);
        let centers = center(state);
        let businesstypes = businessType(state);
        let modules = module(state);
        let monitortypes = monitorType(state);
        let logtypes = logType(state);
        let dataGoverns = dataGovern(state);
        let logcodes = log(state);
        let alarms = alarmType(state);
        let obj = [];
        state.listData[state.route.meta.tab].items.forEach(function(item, index) {
            obj[index] = { ...item };
            obj[index].codeId = index;
            switch (state.route.meta.tab) {
                case 'home/outline':
                    obj[index].link = '/service/detail?moduleCode=' + item.module_code + '&dateTime=' + item.stat_time;
                    break;
                case 'data/company/list':
                    obj[index].link = '/data/detail?factory_code=' + item.factory_code + '&dateTime=' + item.stat_time;
                    break;
                case 'home/detail':
                    obj[index].log = {
                        name: logcodes[obj[index].log_code] || obj[index].log_code,
                        type: logtypes[obj[index].log_type] || obj[index].log_type,
                    }
                    break;
                case 'data/valid':
                    obj[index].validator_score = (item.validator_score * 100).toFixed(0) + '%';
                    break;
                case 'data/stable':
                    obj[index].stable_score = (item.stable_score * 100).toFixed(0) + '%';
                    break;
                case 'data/filedelay':
                    obj[index].delay_score = (item.delay_score * 100).toFixed(0) + '%';
                    break;
                default:
                    break;
            }
            if (obj[index].data_type !== undefined) {
                obj[index].data_type = dataType(obj[index].data_type)
            }
            if (obj[index].device_type !== undefined) {
                obj[index].device_type = deviceType(obj[index].device_type)
            }

            if (obj[index].field_type !== undefined) {
                obj[index].field_type = fieldType(obj[index].field_type)
            }
            if (obj[index].score !== undefined || obj[index].validator_score) {
                if (item.status === 0) {
                    obj[index].strokeColor = 'rgb(19, 206, 102)';
                    obj[index].stroke = 'success';
                }
                if (item.status === 1) {
                    obj[index].strokeColor = '#f7ba2a';
                    obj[index].stroke = 'warning';
                }
                if (item.status === 2) {
                    obj[index].strokeColor = '#ff4949';
                    obj[index].stroke = 'danger';
                }
                if (obj[index].score !== undefined) {
                    obj[index].strokeDasharray = Number(obj[index].score) * 314 + " 1069";
                }

            }
            if (obj[index].ip) {
                obj[index].ip = numberToIp(item.ip);
            }
            if (obj[index].machine_ip) {
                obj[index].machine_ip = numberToIp(item.machine_ip);
            }
            if (item.company_id) {
                obj[index].company = {
                    code: obj[index].company_id,
                    name: factories[obj[index].company_id] || obj[index].company_id
                }
            }
            if (item.factory_code) {
                obj[index].factory = {
                    code: obj[index].factory_code,
                    name: factories[obj[index].factory_code] || obj[index].factory_code,
                }
            }
            if (item.alarm_type) {
                obj[index].alarmType = {
                    code: obj[index].alarm_type,
                    name: alarms[obj[index].alarm_type] || obj[index].alarm_type,
                }
            }
            if (item.center_code) {
                obj[index].center = {
                    code: obj[index].center_code,
                    name: centers[obj[index].center_code] || obj[index].center_code
                }
            }
            if (item.data_type) {
                obj[index].datatype = {
                    code: obj[index].data_type,
                    name: datatypes[obj[index].data_type] || obj[index].data_type
                }
            }
            if (item.module_code) {
                obj[index].module = {
                    code: obj[index].module_code,
                    name: modules[obj[index].module_code] || obj[index].module_code,
                }
            }
            if (item.monitor_type !== undefined) {
                obj[index].monitorType = {
                    code: obj[index].monitor_type,
                    name: monitortypes[obj[index].monitor_type] || obj[index].monitor_type
                }
            }
            if (item.business_code) {
                obj[index].business = {
                    code: obj[index].business_code,
                    name: businesstypes[obj[index].business_code] || obj[index].business_code
                }
            }
        });
        return obj;
    }
    return []
};
const loglist = state => {
    let obj = [];
    let businesstypes = businessType(state);
    let modules = module(state);
    let logtypes = logType(state);
    let logcodes = log(state);
    state.listData['home/loglist'].items.forEach((item, index) => {
        obj[index] = { ...item };
        obj[index].log = {
            name: logcodes[obj[index].log_code] || obj[index].log_code,
            type: logtypes[obj[index].log_type] || obj[index].log_type,
        }
        obj[index].ip = numberToIp(item.ip);
        obj[index].module = {
            code: obj[index].module_code,
            name: modules[obj[index].module_code] || obj[index].module_code,
        }
        obj[index].business = {
            code: obj[index].business_code,
            name: businesstypes[obj[index].business_code] || obj[index].business_code
        }
    })
    return obj;
}
const listTotal = state => {
    let total = 0;
    if (state.route.meta.tab && state.listData[state.route.meta.tab].items instanceof Array) {
        total = state.listData[state.route.meta.tab].total
    }
    return total;
}
const listError = state => {
    let errors = [];
    if (state.route.meta.tab && state.listData[state.route.meta.tab].items instanceof Array) {
        if (state.listData[state.route.meta.tab].errorTotal > 0) {
            return state.listData[state.route.meta.tab].errorTotal;
        }
        errors = state.listData[state.route.meta.tab].items.filter((item, index) => {
            return item.status !== 0
        });
    }

    // return errors.length;
}

export default {
    menuitems,
    listitems,
    factory,
    datatype,
    center,
    factoryFilters,
    datatypeFilters,
    centerFilters,
    module,
    businessType,
    logType,
    log,
    moduleFilters,
    businessTypeFilters,
    logTypeFilters,
    logFilters,
    listError,
    listTotal,
    loglist,
    monitorType,
    monitorFilters,
    alarmType,
    alarmTypeFilters,
    dataGovern,
}
