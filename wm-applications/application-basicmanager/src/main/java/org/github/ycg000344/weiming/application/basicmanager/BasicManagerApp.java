/** 
 * Project Name:application-basicmanager 
 * File Name:BasicManagerApp.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager 
 * Date:2018年6月14日下午6:13:39 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName:BasicManagerApp <br/>
 * <br/>
 * Description: 基础管理模块 <br/>
 * <br/>
 * Date: 2018年6月14日 下午6:13:39 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "org.github.ycg000344.weiming.application.basicmanager.mapper")
public class BasicManagerApp {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(BasicManagerApp.class).web(WebApplicationType.SERVLET).run(args);
	}
}
