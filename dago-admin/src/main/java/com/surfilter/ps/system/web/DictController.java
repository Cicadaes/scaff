package com.surfilter.ps.system.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surfilter.ps.system.service.DictService;

import io.swagger.annotations.Api;

/**
 * 
 * <p>
 * Title: SystemDictController.java
 * </p>
 * <p>
 * Description: 字典管理controller
 * </p>
 * <p>
 * Company: surfilter.com
 * </p>
 * 
 * @author xuxiaolong
 * @date 2018年4月16日
 */
@Api(tags = "系统管理/常用信息/字典管理")
@RestController
@RequestMapping(value = "/api/system/dict")
public class DictController {

	@Autowired
	private DictService dictService;

}
