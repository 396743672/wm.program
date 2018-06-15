/** 
 * Project Name:auth-server 
 * File Name:AuthServerApp.java 
 * Package Name:org.github.ycg000344.weiming.authserver 
 * Date:2018年5月11日下午4:32:02 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.authserver;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName:AuthServerApp <br/>
 * <br/>
 * Description: 鉴权服务 <br/>
 * <br/>
 * Date: 2018年5月11日 下午4:32:02 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class AuthServerApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AuthServerApp.class).web(WebApplicationType.SERVLET).run(args);
	}

}
