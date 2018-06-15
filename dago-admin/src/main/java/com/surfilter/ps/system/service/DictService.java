package com.surfilter.ps.system.service;

import com.surfilter.ps.system.mapper.DictMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surfilter.ps.system.mapper.DictMapper;

/**
 * 
 * @ClassName: DictService
 * @Description:系统字典管理业务方法 Company: surfilter.com
 * @author xuxiaolong
 * @date 2018年4月16日
 */
@Service
public class DictService {
<<<<<<< HEAD
	
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
=======
>>>>>>> 6a2d76dfb6aafb752789b1908ff1a26d4f06803f

	@Autowired
	private DictMapper dictMapper;

	private static final Logger logger = LoggerFactory.getLogger(DictService.class);

}
