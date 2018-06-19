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
	@Autowired
	private DictMapper dictMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(DictService.class);

}
