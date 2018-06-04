package com.surfilter.ps.config.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages= {"com.xxl.job.admin.dao","com.surfilter.ps.mapper"})
public class MybatisConfig {

}
