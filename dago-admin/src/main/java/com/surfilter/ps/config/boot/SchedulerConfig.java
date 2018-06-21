package com.surfilter.ps.config.boot;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.xxl.job.admin.core.schedule.XxlJobDynamicScheduler;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: SchedulerConfig
 * @Package com.surfilter.ps.config.boot
 * @Description:
 * @author: Alex
 * @date: 2018-05-30 下午9:48
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 *             注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
public class SchedulerConfig {

	@Autowired
	DataSource dataSource;

	@Bean(name = "SchedulerFactory")
	public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setQuartzProperties(quartzProperties());
		return factory;
	}

	@Bean
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/config/quartz.properties"));
		// 在quartz.properties中的属性被读取并注入后再初始化对象
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	/*
	 * quartz初始化监听器
	 */
	@Bean
	public QuartzInitializerListener executorListener() {
		return new QuartzInitializerListener();
	}

	/*
	 * 通过SchedulerFactoryBean获取Scheduler的实例
	 */
	@Bean(name = "Scheduler")
	public Scheduler scheduler() throws IOException {
		return schedulerFactoryBean().getScheduler();
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public XxlJobDynamicScheduler xxlJobDynamicScheduler() throws IOException {
		XxlJobDynamicScheduler xxlJobDynamicScheduler = new com.xxl.job.admin.core.schedule.XxlJobDynamicScheduler();
		xxlJobDynamicScheduler.setScheduler(schedulerFactoryBean().getScheduler());
		xxlJobDynamicScheduler.setAccessToken("");
		return xxlJobDynamicScheduler;
	}
}
