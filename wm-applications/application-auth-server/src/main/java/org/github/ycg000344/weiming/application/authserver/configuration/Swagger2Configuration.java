/** 
 * Project Name:auth-server 
 * File Name:Swagger2Configuration.java 
 * Package Name:org.github.ycg000344.weiming.authserver.configuration 
 * Date:2018年5月17日下午3:27:32 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/** 
 * ClassName:Swagger2Configuration <br/><br/>  
 * Description: Swagger2 配置类 <br/><br/>  
 * Date:     2018年5月17日 下午3:27:32 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
public class Swagger2Configuration {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.github.ycg000344.weiming.authserver.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("鉴权服务API")
				.description("鉴权服务API")
				.termsOfServiceUrl("")
				.version("1.0")
				.build();
	}
}
  