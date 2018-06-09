/** 
 * Project Name:bootadmin-server 
 * File Name:BootAdminServerApp.java 
 * Package Name:org.github.ycg000344.weiming.bootadminserver 
 * Date:2018年6月7日下午7:03:40 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.server.sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/** 
 * ClassName: SBAApplication <br/><br/>  
 * Description: SBA监控中心 <br/><br/>  
 * Date:     2018年6月7日 下午7:03:40 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class SBAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBAApplication.class, args);
	}

}
  