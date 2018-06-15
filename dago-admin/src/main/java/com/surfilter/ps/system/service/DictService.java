package com.surfilter.gacenter.service.system.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.surfilter.ps.system.mapper.DictMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.LoggerFactory;

import com.surfilter.gacenter.entity.PageResult;
import com.surfilter.gacenter.entity.system.dict.Dict;
import com.surfilter.gacenter.repository.system.dict.DictDao;

/**
 * 
* @ClassName: DictService  
* @Description:系统字典管理业务方法  
* Company: surfilter.com 
* @author xuxiaolong 
* @date 2018年4月16日
 */
@Component
public class DictService {
	
	@Autowired
	private DictMapper dictMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(DictService.class);
	
	/**
	 * 
	 * <p>Title: getBaseDictList</p>  
	 * <p>Description:查询字典基础数据列表 </p>  
	 * @param dictType
	 * @return
	 */
	public PageResult getBaseDictList(Dict query){
		PageResult pr = new PageResult();
		try{
			Map<String,String> dictTypeMap = new HashMap<String,String>();
			List<Map<String,String>> dictTypeList = this.getAllBaseDictType();
			for(Map<String,String> map : dictTypeList){
				dictTypeMap.put(map.get("value"), map.get("name"));
			}
			Map<String,Object> body = new HashMap<String,Object>();
			List<Dict> list = dictDao.list(query);
			for(Dict dict : list){
				dict.setType(dictTypeMap.get(dict.getType()));
			}
			long count = dictDao.listCount(query);
			body.put("data", list);
			body.put("count", count);
			pr.setBody(body);
			pr.setMsg("查询基础数据列表成功");
			pr.setStatus(1);
		}catch(Exception e){
			logger.error("查询字典基础数据列表失败", e);
			pr.setBody(null);
			pr.setStatus(2);
			pr.setMsg("查询字典基础数据列表失败");
		}
		return pr;
	}
	
	/**
	 * 
	 * <p>Title: saveOrUpdateDict</p>  
	 * <p>Description:新增或修改字典信息 </p>  
	 * @param dict
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public PageResult saveOrUpdateDict(Dict dict){
		PageResult pr = new PageResult();
		String operateType= null;
		if(dict.getId() == null){
			operateType = "新增";
		}else{
			operateType = "修改";
		}
		try{
			if(dict.getId() == null){
				if(dict.getOrder()==null){
					dict.setOrder(0L);
				}
				dictDao.save(dict);			
			}else{
				dictDao.update(dict);
			}
			pr.setMsg("字典"+operateType+"成功");
			pr.setStatus(1);
		}catch(Exception e){
			logger.error("字典"+operateType+"失败", e);
			pr.setMsg("字典"+operateType+"失败");
			pr.setStatus(2);
		}
		return pr;
	}
	
	/**
	 * 
	 * <p>Title: deleteDict</p>  
	 * <p>Description: 删除字典</p>  
	 * @param dictId 字典ID
	 * @return
	 */
	public PageResult deleteDict(Integer dictId){
		PageResult pr = new PageResult();
		try{
			dictDao.delete(dictId);
			pr.setMsg("字典删除成功");
			pr.setStatus(1);
		}catch(Exception e){
			logger.error("字典删除失败", e);
			pr.setMsg("字典删除失败");
			pr.setStatus(2);
		}
		return pr;
	}
	
	/**
	 * 
	 * Title: getAllBaseDictType 
	 * Description: 加载基础数据类型  
	 * @return
	 */
	public List<Map<String,String>> getAllBaseDictType(){

		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "APP服务类型");
		map.put("value", "app_service_type");
		list.add(map);
		
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("name", "接入数据类型");
		map1.put("value", "input_data_type");
		list.add(map1);
		
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("name", "接入服务商");
		map2.put("value", "network_access");
		list.add(map2);
		
		Map<String,String> map3 = new HashMap<String,String>();
		map3.put("name", "接入方式");
		map3.put("value", "access_type");
		list.add(map3);
		
		Map<String,String> map4 = new HashMap<String,String>();
		map4.put("name", "设备类型");
		map4.put("value", "capture_equipment_type");
		list.add(map4);
		
		Map<String,String> map5 = new HashMap<String,String>();
		map5.put("name", "场所服务状态");
		map5.put("value", "workplace_service_type");
		list.add(map5);
		
		Map<String,String> map6 = new HashMap<String,String>();
		map6.put("name", "场所经营性质");
		map6.put("value", "workplace_business_nature");
		list.add(map6);
		
		Map<String,String> map7 = new HashMap<String,String>();
		map7.put("name", "设备型号");
		map7.put("value", "equipment_model");
		list.add(map7);
		
		Map<String,String> map8 = new HashMap<String,String>();
		map8.put("name", "认证类型");
		map8.put("value", "auth_type");
		list.add(map8);
		
		Map<String,String> map9 = new HashMap<String,String>();
		map9.put("name", "信道压制");
		map9.put("value", "channel_suppress");
		list.add(map9);
		
//		Map<String,String> map10 = new HashMap<String,String>();
//		map10.put("name", "第三方授权认证");
//		map10.put("value", "interface_access_token");
//		list.add(map10);
		
//		Map<String,String> mapa = new HashMap<String,String>();
//		mapa.put("name", "伪基站短信转发过滤");
//		mapa.put("value", "sms_content");
//		list.add(mapa);
		
		Map<String,String> mapb = new HashMap<String,String>();
		mapb.put("name", "采集系统来源");
		mapb.put("value", "collection_system_source");
		list.add(mapb);
		
		Map<String,String> mapc = new HashMap<String,String>();
		mapc.put("name", "信号强度范围");
		mapc.put("value", "signal_power_range");
		list.add(mapc);
		
		Map<String,String> mapd = new HashMap<String,String>();
		mapd.put("name", "采集系统来源-子类");
		mapd.put("value", "sys_source_sub_type");
		list.add(mapd);
		
//		Map<String,String> mape = new HashMap<String,String>();
//		mape.put("name", "重点人员类型");
//		mape.put("value", "zpperson_type");
//		list.add(mape);
//		
//		Map<String,String> mapf = new HashMap<String,String>();
//		mapf.put("name", "重点人员类型-子类");
//		mapf.put("value", "zpperson_sub_type");
//		list.add(mapf);
		
		Map<String,String> mapg = new HashMap<String,String>();
		mapg.put("name", "重点人员提供部门");
		mapg.put("value", "zpperson_type_department");
		list.add(mapg);
		
		/*Map<String,String> maph = new HashMap<String,String>();
		maph.put("name", "警情信息案别");
		maph.put("value", "AB_JZ_ASJ_B_ASJ_JQ");
		list.add(maph);
		
		Map<String,String> mapi = new HashMap<String,String>();
		mapi.put("name", "警情信息类别");
		mapi.put("value", "JQLB_JZ_ASJ_B_ASJ_JQ");
		list.add(mapi);
		
		Map<String,String> mapj = new HashMap<String,String>();
		mapj.put("name", "警情信息接警单位");
		mapj.put("value", "SLJJDW_JZ_ASJ_B_ASJ_JQ");
		list.add(mapj);
		
		Map<String,String> mapk = new HashMap<String,String>();
		mapk.put("name", "案件类型");
		mapk.put("value", "AJLXDM-JZ_ASJ_B_ASJ_AJ_NEW");
		list.add(mapk);
		
		Map<String,String> mapl = new HashMap<String,String>();
		mapl.put("name", "案件类别");
		mapl.put("value", "JQLB_JZ_ASJ_B_ASJ_JQ");
		list.add(mapl);*/
		
//		Map<String,String> mapm = new HashMap<String,String>();
//		mapm.put("name", "下级中心");
//		mapm.put("value", "servicedata_lower_center");
//		list.add(mapm);
		
//		Map<String,String> mapn = new HashMap<String,String>();
//		mapn.put("name", "访问中心");
//		mapn.put("value", "servicedata_access_token");
//		list.add(mapn);
		
		Map<String,String> mapo = new HashMap<String,String>();
		mapo.put("name", "场所采集类型");
		mapo.put("value", "collection_cap_type");
		list.add(mapo);
		
		Map<String,String> mapp = new HashMap<String,String>();
		mapp.put("name", "业务类型");
		mapp.put("value", "business_type");
		list.add(mapp);
		
		Map<String,String> mapq = new HashMap<String,String>();
		mapq.put("name", "日志类型");
		mapq.put("value", "log_type");
		list.add(mapq);
		
		Map<String,String> mapr = new HashMap<String,String>();
		mapr.put("name", "日志代码");
		mapr.put("value", "log_code");
		list.add(mapr);
		

		return list;
	}
	
	/**
	 * <p>Title: getDictById</p>  
	 * <p>Description: 根据ID查询字典详情</p>  
	 * @param dictId
	 * @return
	 */
	public PageResult getDictById(Integer dictId){
		PageResult pr = new PageResult();
		Map<String,Object> body = new HashMap<String,Object>();
		try{
			body.put("data", dictDao.findOne(dictId));
			pr.setBody(body);
			pr.setMsg("查询字典详情成功");
			pr.setStatus(1);
		}catch(Exception e){
			logger.error("查询字典详情失败", e);
			pr.setBody(null);
			pr.setMsg("查询字典详情失败");
			pr.setStatus(2);
		}
		return pr;
	}
	
	/**
	 * 校验字典编码唯一性
	 * <p>Title: checkNameUnique</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @param id
	 * @param type
	 * @return
	 */
	public PageResult checkNameUnique(String name,Long id,String type){
		PageResult pr = new PageResult();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("type", type);
		queryMap.put("name", name);
		queryMap.put("id", id);
		try{
			Dict dict = dictDao.getByTypeAndName(queryMap);
			if(dict != null){
				pr.setMsg("字典编码已存在");
				pr.setStatus(2);
			}else{
				pr.setMsg("字典编码校验通过");
				pr.setStatus(1);
			}
			
		}catch(Exception e){
			logger.error("字典编码校验失败", e);
			pr.setBody(null);
			pr.setMsg("字典编码校验失败");
			pr.setStatus(2);
		}
		return pr;
	}
	
	
	/**
	 * 校验字典值唯一性
	 * <p>Title: checkValueUnique</p>  
	 * <p>Description: </p>  
	 * @param value
	 * @param id
	 * @param type
	 * @return
	 */
	public PageResult checkValueUnique(String value,Long id,String type){
		PageResult pr = new PageResult();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("type", type);
		queryMap.put("value", value);
		queryMap.put("id", id);
		try{
			Dict dict = dictDao.getByTypeAndValue(queryMap);
			if(dict != null){
				pr.setMsg("字典值已存在");
				pr.setStatus(2);
			}else{
				pr.setMsg("字典值校验通过");
				pr.setStatus(1);
			}
			
		}catch(Exception e){
			logger.error("字典值校验失败", e);
			pr.setBody(null);
			pr.setMsg("字典值校验失败");
			pr.setStatus(2);
		}
		return pr;
	}
	

}
