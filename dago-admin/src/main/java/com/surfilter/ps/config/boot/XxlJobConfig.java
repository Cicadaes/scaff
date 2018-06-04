package com.surfilter.ps.config.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.admin.service.impl.AdminBizImpl;
import com.xxl.job.admin.service.impl.XxlJobServiceImpl;
import com.xxl.job.core.biz.AdminBiz;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: XxlJobConfig
 * @Package com.surfilter.ps.config.boot
 * @Description:
 * @author: Alex
 * @date: 2018-05-30 下午10:34
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
public class XxlJobConfig {

    private Logger logger = LoggerFactory.getLogger(XxlConfConfig.class);
    
    @Bean
    public AdminBiz adminBiz() {
    	return new AdminBizImpl();
    }
    @Bean
    public XxlJobService xxlJobService() {
    	return new XxlJobServiceImpl();
    }


}
