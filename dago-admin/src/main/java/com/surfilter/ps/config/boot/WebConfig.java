package com.surfilter.ps.config.boot;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

//	@Autowired
//	private PermissionInterceptor permissionInterceptor;
//	@Autowired
//	private EnvInterceptor envInterceptor;
//	@Autowired
//	private CookieInterceptor cookieInterceptor;

	// @Override
	// @Bean
	// public RequestMappingHandlerMapping requestMappingHandlerMapping() {
	// RequestMappingHandlerMapping handlerMapping = new
	// CustomRequestMappingHandlerMapping();
	// handlerMapping.setOrder(0);
	// handlerMapping.setInterceptors(getInterceptors());
	// return handlerMapping;
	// }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("swagger.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		// 方位resources中static中的静态资源
		 registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	//增加规律器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(permissionInterceptor).addPathPatterns("/**");
//		registry.addInterceptor(envInterceptor).addPathPatterns("/**");
//		registry.addInterceptor(cookieInterceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	/**
	 * 配置servlet处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
