/** 
 * Project Name:admin-server-demo 
 * File Name:SpringBootAdminApplication.java 
 * Package Name:org.github.ycg000344.weiming.helloworld.bootadmin 
 * Date:2018年6月5日上午10:45:35 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.helloworld.bootadminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * ClassName:SpringBootAdminApplication <br/>
 * <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年6月5日 上午10:45:35 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class SpringBootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminServerApplication.class, args);
	}

}
