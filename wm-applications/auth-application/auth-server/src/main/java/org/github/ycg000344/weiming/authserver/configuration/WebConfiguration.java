/** 
 * Project Name:auth-server 
 * File Name:WebConfiguration.java 
 * Package Name:org.github.ycg000344.weiming.authserver.configuration 
 * Date:2018年5月14日下午5:25:11 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authserver.configuration;

import org.github.ycg000344.weiming.common.handle.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 
 * ClassName:WebConfiguration <br/><br/>  
 * Description: 配置自定义拦截器 <br/><br/>  
 * Date:     2018年5月14日 下午5:25:11 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 /*增加拦截器*/
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	/*全局异常*/
	@Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
  