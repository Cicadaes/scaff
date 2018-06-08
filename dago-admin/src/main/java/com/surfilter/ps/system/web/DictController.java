package com.surfilter.ps.system.web;

import java.util.HashMap;
import java.util.Map;

import org.ehcache.xml.model.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.surfilter.gacenter.entity.system.dict.MacDict;
import com.surfilter.gacenter.entity.system.dict.MacDictQuery;
import com.surfilter.gacenter.entity.system.dict.ProtocolWordBook;
import com.surfilter.gacenter.entity.system.dict.ProtocolWordBookQuery;
import com.surfilter.gacenter.entity.system.dict.SecurityFactory;
import com.surfilter.gacenter.entity.system.dict.SecurityFactoryQuery;
import com.surfilter.gacenter.service.system.dict.DictService;
import com.surfilter.ps.core.entity.PageResult;
import com.surfilter.ps.system.entity.Dict;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;
/**
 * 
* <p>Title: SystemDictController.java</p>  
* <p>Description: 字典管理controller</p>  
* <p>Company: surfilter.com</p>  
* @author xuxiaolong 
* @date 2018年4月16日
 */
@Api(tags = "系统管理/常用信息/字典管理")
@RestController
@RequestMapping(value = "/api/system/dict")
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	  /** 
     * 系统管理/常用信息/字典管理/基础数据列表查询
     * @param request
     * @return String
    */
    @ApiOperation(value = "系统管理/常用信息/字典管理/基础数据", notes = "系统管理/常用信息/字典管理/基础数据列表查询接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "dictType", value = "字典类型", required = false, paramType = "query", dataType = "string"),
        @ApiImplicitParam(name = "start", value = "每页开始记录", required = true, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query", dataType = "int")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的字典列表", response = Dict.class, responseContainer = "List")})
    @RequestMapping(value = "baseDictList", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getBaseDictList(String dictType,Integer start, Integer size){
		long t = System.currentTimeMillis();
		Dict query =  new Dict();
		query.setType(dictType);
		query.setSize(size == null ? 20 : size);
    	query.setStart(start == null ? 0 : start);
		PageResult pr = dictService.getBaseDictList(query);
		pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
	}
    
    
    /**
     * 
     * Title: getAllBaseDictTypes 
     * Description:加载字典基础类型下拉框   
     * @return
     */
    @ApiOperation(value = "系统管理/常用信息/字典管理/基础数据", notes = "系统管理/常用信息/字典管理/基础数据列表查询接口", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的字典列表", response = PageResult.class)})
    @RequestMapping(value = "getAllDictTypes", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllBaseDictTypes(){
    	long t = System.currentTimeMillis();
    	PageResult pr = new PageResult();
    	Map<String,Object> body = new HashMap<String,Object>();
		body.put("data", dictService.getAllBaseDictType());
		pr.setBody(body);
		pr.setMsg("加载数据成功");
		pr.setStatus(1);
		pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
    }
	
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/字典新增或修改", notes = "系统管理/常用信息/字典管理/字典新增或修改接口", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共JSON", response = PageResult.class)})
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "如果id为空，表示新增，不为空表示修改",paramType = "form", required = false,  dataType = "Long"),
    	@ApiImplicitParam(name = "name", value = "字典名称", required = true, paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "type", value = "字典类型", required = true,paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "value", value = "字典值", required = true,paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "desc", value = "字典描述", required = true, paramType = "form", dataType = "string")
    })
    @RequestMapping(value = "baseDictSave", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addDict(@ApiIgnore Dict dict){
    	long t = System.currentTimeMillis();
		PageResult pr =  dictService.saveOrUpdateDict(dict);
		pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
	}
    
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/字典值唯一性校验", notes = "系统管理/常用信息/字典管理/字典值唯一性校验接口", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共JSON,status为1表示校验通过，2表示不通过", response = PageResult.class)})
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "如果id为空，表示新增，不为空表示修改",paramType = "form", required = false,  dataType = "Long"),
    	@ApiImplicitParam(name = "type", value = "字典类型", required = true,paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "value", value = "字典值", required = true,paramType = "form", dataType = "string"),
    })
    @RequestMapping(value = "checkValueUnique", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
	public String checkValueUnique(String value,Long id,String type){
    	long t = System.currentTimeMillis();
		PageResult pr =  dictService.checkValueUnique(value, id, type);
		pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
	}
    
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/字典编码（名称）唯一性校验", notes = "系统管理/常用信息/字典管理/字典编码（名称）唯一性校验接口", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共JSON,status为1表示校验通过，2表示不通过", response = PageResult.class)})
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "如果id为空，表示新增，不为空表示修改",paramType = "form", required = false,  dataType = "Long"),
    	@ApiImplicitParam(name = "type", value = "字典类型", required = true,paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "name", value = "字典名称", required = true,paramType = "form", dataType = "string"),
    })
    @RequestMapping(value = "checkNameUnique", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
	public String checkNameUnique(String name,Long id,String type){
    	long t = System.currentTimeMillis();
		PageResult pr =  dictService.checkNameUnique(name, id, type);
		pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
	}
    
    /** 
     * 系统管理/常用信息/字典管理/删除
     * @param id 字典id
     * @return String
    */
    @ApiOperation(value = "系统管理/常用信息/字典管理/删除字典", notes = "系统管理/常用信息/字典管理/删除字典接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "字典ID", required = true, paramType = "query", dataType = "Integer")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回 JSON 格式的公共返回类", response = PageResult.class)})
    @RequestMapping(value = "baseDictDelete", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteDict(Integer id){
    	long t = System.currentTimeMillis();
		PageResult pr = dictService.deleteDict(id);
		pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
	}
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/查看字典基础数据详情", notes = "系统管理/常用信息/字典管理/查看字典基础数据详情接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "字典基础数据id", required = true, paramType = "query", dataType = "Integer")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "baseDictDetail", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDictById(Integer id){
    	long t = System.currentTimeMillis();
    	PageResult pr = dictService.getDictById(id);
    	pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
    }
    
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/协议类型列表查询", notes = "系统管理/常用信息/字典管理/协议类型列表查询接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "协议名称", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "code", value = "协议编码", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "use_status", value = "是否可用", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "filter_status", value = "是否过滤", required = false, paramType = "query", dataType = "string"),
        @ApiImplicitParam(name = "start", value = "每页开始记录", required = true, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query", dataType = "int")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的协议列表", response = ProtocolWordBook.class, responseContainer = "List")})
    @RequestMapping(value = "protocolList", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProtocolList(ProtocolWordBookQuery protocol){
    	long t = System.currentTimeMillis();
    	if(protocol == null){
    		protocol = new ProtocolWordBookQuery();
    		protocol.setSize(20);
    		protocol.setStart(0);
    	}
    	PageResult pr = protocolWordBookService.getProtocolList(protocol);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    /**
     * 
     * <p>Title: saveProtocol</p>  
     * <p>Description: 协议类型新增或修改</p>  
     * @param protocol
     * @return
     */
    @ApiOperation(value = "系统管理/常用信息/字典管理/协议类型新增或修改", notes = "系统管理/常用信息/字典管理/协议类型新增或修改接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "如果id为空，表示新增，不为空表示修改",paramType = "form", required = false,  dataType = "Long"),
    	@ApiImplicitParam(name = "name", value = "协议名称", required = true, paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "code", value = "协议编码", required = true,paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "use_status", value = "是否可用", required = true,paramType = "form", dataType = "string"),
    	@ApiImplicitParam(name = "filter_status", value = "是否过滤", required = true, paramType = "form", dataType = "string")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "protocolSave", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveProtocol(@ApiIgnore ProtocolWordBook protocol){
    	long t = System.currentTimeMillis();
    	PageResult pr = null;
    	try{
    		pr = protocolWordBookService.saveProtocol(protocol);
    	}catch(Exception e){
    		pr = new PageResult();
    		pr.setBody(null);
    		pr.setMsg("协议类型保存失败");
    		pr.setStatus(2);
    	}
    	pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
    }
    

    @ApiOperation(value = "系统管理/常用信息/字典管理/协议类型删除", notes = "系统管理/常用信息/字典管理/协议类型删除接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "协议类型id", required = true, paramType = "query",  dataType = "long")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "protocolDelete", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteProtocol(Long id){
    	long t = System.currentTimeMillis();
    	PageResult pr = null;
    	try{
    		pr = protocolWordBookService.deleteProtocol(id);
    	}catch(Exception e){
    		pr =  new PageResult();
    		pr.setStatus(2);
    		pr.setBody(null);
    		pr.setMsg("删除协议类型失败");
    	} 
    	pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/查看协议类型详情", notes = "系统管理/常用信息/字典管理/协议类型删除接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "协议类型id", required = true,paramType = "query",  dataType = "long")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "protocolDetail", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProtocolById(Long id){
    	long t = System.currentTimeMillis();
    	PageResult pr = protocolWordBookService.getProtocolById(id);
    	pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
    }
    
    /** 
     * 系统管理/常用信息/字典管理/接入数据厂商列表查询
     * @param request
     * @return String
    */
    @ApiOperation(value = "系统管理/常用信息/字典管理/接入数据厂商列表查询", notes = "系统管理/常用信息/字典管理/接入数据厂商列表查询接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "org_code", value = "厂商组织机构代码", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "factory_name", value = "接入数据厂商名称", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "auto_trans", value = "数据前端自动传输", required = false, paramType = "query", dataType = "string"),
        @ApiImplicitParam(name = "start", value = "每页开始记录", required = true, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query", dataType = "int")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的字典列表", response = SecurityFactory.class, responseContainer = "List")})
    @RequestMapping(value = "securityFactoryList", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSecurityFactoryList(@ApiIgnore SecurityFactoryQuery query){
    	long t = System.currentTimeMillis();
    	PageResult pr = securityFactoryService.getSecurityFactoryList(query);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    /**
     * 
     * <p>Title: saveSecurityFactory</p>  
     * <p>Description: 接入数据厂商新增或修改</p>  
     * @param factory
     * @return
     */
    @ApiOperation(value = "系统管理/常用信息/字典管理/接入数据厂商新增或修改", notes = "系统管理/常用信息/字典管理/接入数据厂商新增或修改接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "如果id为空，表示新增，不为空表示修改", required = false,  dataType = "Long",paramType = "query"),
    	@ApiImplicitParam(name = "org_code", value = "厂商组织机构代码", required = true, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "factory_name", value = "接入数据厂商名称", required = true, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "factory_address", value = "厂商地址", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "auto_trans", value = "数据前端自动传输", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "link_man", value = "联系人名称", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "link_tel", value = "联系人电话", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "link_email", value = "联系人邮件", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query", dataType = "string")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "securityFactorySave", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveSecurityFactory(@ApiIgnore SecurityFactory factory){
    	long t = System.currentTimeMillis();
    	PageResult pr = securityFactoryService.saveSecurityFactory(factory);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/查看接入数据厂商详情", notes = "系统管理/常用信息/字典管理/查看接入数据厂商详情接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "接入数据厂商id", required = true,  dataType = "Long",paramType = "query")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "securityFactoryDetail", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String securityFactoryDetail(Long id){
    	long t = System.currentTimeMillis();
    	PageResult pr = securityFactoryService.getSecurityFactoryById(id);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    /**
     * <p>Title: deleteSecurityFactory</p>  
     * <p>Description:删除接入数据厂商 </p>  
     * @param id
     * @return
     */
    @ApiOperation(value = "系统管理/常用信息/字典管理/接入数据厂商删除", notes = "系统管理/常用信息/字典管理/删除接入数据厂商删除接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "接入数据厂商id", required = true,  dataType = "Long",paramType = "query")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "securityFactoryDelete", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteSecurityFactory(Long id){
    	long t = System.currentTimeMillis();
    	PageResult pr = securityFactoryService.deleteSecurityFactory(id);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/mac厂商列表查询", notes = "系统管理/常用信息/字典管理/mac厂商列表查询接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "mac", value = "mac", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "factory_name", value = "硬件厂商简称", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "hardware_factory_name", value = "硬件厂商名称", required = false, paramType = "query", dataType = "string"),
        @ApiImplicitParam(name = "start", value = "每页开始记录", required = true, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query", dataType = "int")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的mac厂商列表", response = MacDict.class, responseContainer = "List")})
    @RequestMapping(value = "macDictList", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMacDictList(@ApiIgnore MacDictQuery query){
    	long t = System.currentTimeMillis();
    	PageResult pr = macDictService.getMacDictList(query);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/mac厂商新增或保存", notes = "系统管理/常用信息/字典管理/mac厂商新增或保存接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "如果id为空，表示新增，不为空表示修改",paramType = "query", required = false,  dataType = "Long"),
    	@ApiImplicitParam(name = "mac", value = "mac", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "factory_name", value = "硬件厂商简称", required = false, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "hardware_factory_name", value = "硬件厂商名称", required = false, paramType = "query", dataType = "string"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的mac厂商列表", response = PageResult.class)})
    @RequestMapping(value = "macDictSave", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveMacDict(@ApiIgnore MacDict dict){
    	long t = System.currentTimeMillis();
    	PageResult pr = macDictService.saveMacDict(dict);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/mac厂商删除", notes = "系统管理/常用信息/字典管理/删除mac厂商接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "mac厂商id", required = true,  dataType = "Long",paramType = "query")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "macDict/delete", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteMacDict(Long id){
    	long t = System.currentTimeMillis();
    	PageResult pr = macDictService.deleteMacDict(id);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/场所类型列表查询", notes = "系统管理/常用信息/字典管理/场所类型列表查询接口", response = String.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "start", value = "每页开始记录", required = true, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query", dataType = "int")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的mac厂商列表", response = ServiceType.class, responseContainer = "List")})
    @RequestMapping(value = "serviceTypeList", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getServiceTypeList(Integer start,Integer size){
    	long t = System.currentTimeMillis();
    	ServiceType serviceType = new ServiceType();
    	serviceType.setStart(start);
    	serviceType.setSize(size);
    	PageResult pr = serviceTypeService.getServiceTypeList(serviceType);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/场所类型新增或修改", notes = "系统管理/常用信息/字典管理/场所类型新增或修改接口", response = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "如果id为空，表示新增，不为空表示修改", required = false,  dataType = "Long", paramType = "query"),
    	@ApiImplicitParam(name = "typeNo", value = "场所类型编号", required = true, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "typeName", value = "场所类型名称", required = true, paramType = "query", dataType = "string"),
    	@ApiImplicitParam(name = "orderNum", value = "排序编号", required = true, paramType = "query", dataType = "long"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "serviceTypeSave", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveServiceType(@ApiIgnore ServiceType serviceType){
    	long t = System.currentTimeMillis();
    	PageResult pr = serviceTypeService.saveServiceType(serviceType);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    @ApiOperation(value = "系统管理/常用信息/字典管理/场所类型删除", notes = "系统管理/常用信息/字典管理/删除场所类型接口", response = String.class)
    @ApiImplicitParam(name = "id", value = "场所类型id", required = true,  dataType = "Long", paramType = "query")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回公共 JSON", response = PageResult.class)})
    @RequestMapping(value = "serviceTypeDelete", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteServiceType(Long id){
    	long t = System.currentTimeMillis();
    	PageResult pr = serviceTypeService.deleteServiceType(id);
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.toJson(pr);
    }
    
    /**
     * 系统管理/常用信息/字典管理/搜索协议类型列表查询
     * <p>Title: serarchTypeDictList</p>  
     * <p>Description: </p>  
     * @param start
     * @param size
     * @return
     */
    @ApiOperation(value = "系统管理/常用信息/字典管理/搜索协议类型列表查询", notes = "系统管理/常用信息/字典管理/搜索协议类型列表查询接口", response = String.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "start", value = "每页开始记录", required = true, paramType = "query", dataType = "Integer"),
        @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query", dataType = "Integer")
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的字典列表", response = Dict.class, responseContainer = "List")})
    @RequestMapping(value = "serarchTypeDictList", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String serarchTypeDictList(Integer start, Integer size){
    	long t = System.currentTimeMillis();
		Dict query =  new Dict();
		String dictType = "r_search_protocol_type";//搜索协议类型
		query.setSize(size == null ? 20 : size);
    	query.setStart(start == null ? 0 : start);
    	query.setType(dictType);
		PageResult pr = dictService.getBaseDictList(query);
		pr.setTime(System.currentTimeMillis()-t);
		return jm.toJson(pr);
    }
    
    /**
     * 系统管理/常用信息/字典管理/搜索协议类型列表查询
     * <p>Title: serarchTypeDictList</p>  
     * <p>Description: </p>  
     * @param start
     * @param size
     * @return
     */
    @ApiOperation(value = "系统管理/常用信息/字典管理/协议结构树查询", notes = "系统管理/常用信息/字典管理/协议结构树查询接口", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功返回多个 JSON 格式的协议列表", response = PageResult.class)})
    @RequestMapping(value = "protocolTree", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public  String getProtocolTree(){
    	long t = System.currentTimeMillis();
    	PageResult pr = protocolWordBookService.getProtocolTree();
    	pr.setTime(System.currentTimeMillis()-t);
    	return jm.nonNullMapper().toJson(pr);
    }
        
}
