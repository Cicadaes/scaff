package com.surfilter.ps.config.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.surfilter.ps.config.web.CustomRequestMappingHandlerMapping;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport{
	
	@Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//方位resources中static中的静态资源
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
	
	/**
     * 配置servlet处理
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	

}
