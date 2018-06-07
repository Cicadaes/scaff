package com.surfilter.ps.config.boot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ConditionalOnProperty(prefix = "springfox", value = "enable", matchIfMissing = true)
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.xxl.job.admin.controller"))
                .apis(RequestHandlerSelectors.basePackage("com.surfilter.ps.web"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(false);
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("dago数据治理平台")
                .description("dago数据治理平台,平台页面 Restful 接口说明.")
                .version("4.0")
        		.build();
    }
	
}
