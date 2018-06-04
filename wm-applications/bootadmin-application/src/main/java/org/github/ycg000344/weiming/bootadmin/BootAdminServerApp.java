/** 
 * Project Name:bootadmin-application 
 * File Name:BootAdminServerApp.java 
 * Package Name:org.github.ycg000344.weiming.bootadmin 
 * Date:2018年6月4日下午7:03:53 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.bootadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/** 
 * ClassName:BootAdminServerApp <br/><br/>  
 * Description: spring- boot- admin <br/><br/>  
 * Date:     2018年6月4日 下午7:03:53 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@SpringBootApplication
@EnableAdminServer
@EnableEurekaClient
public class BootAdminServerApp {
	public static void main(String[] args) {
		SpringApplication.run(BootAdminServerApp.class, args);
	}

}
  