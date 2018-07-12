package com.surfilter.ps.config.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

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

    @Bean(name = "SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setAutoStartup(true);
        factory.setStartupDelay(20);
        factory.setOverwriteExistingJobs(true);
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        factory.setConfigLocation(new ClassPathResource("/config/quartz.properties"));
        return factory;
    }

//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public XxlJobDynamicScheduler getXxlJobDynamicScheduler(@Qualifier("SchedulerFactory") Scheduler scheduler) {
//        XxlJobDynamicScheduler bean = new XxlJobDynamicScheduler();
//        bean.setScheduler(scheduler);
//        return bean;
//    }

//    @Bean
//    public AdminBiz adminBiz() {
//    	return new AdminBizImpl();
//    }
//    @Bean
//    public XxlJobService xxlJobService() {
//    	return new XxlJobServiceImpl();
//    }


}
