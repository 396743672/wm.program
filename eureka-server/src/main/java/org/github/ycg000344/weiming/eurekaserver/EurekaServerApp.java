/** 
 * Project Name:eureka-server 
 * File Name:EurekaServerApp.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver 
 * Date:2018年5月8日下午2:15:16 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.eurekaserver;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/** 
 * ClassName:EurekaServerApp <br/><br/>  
 * Description: 服务注册中心 <br/><br/>  
 * Date:     2018年5月8日 下午2:15:16 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServerApp.class).web(WebApplicationType.SERVLET).run(args);
	}
}
  