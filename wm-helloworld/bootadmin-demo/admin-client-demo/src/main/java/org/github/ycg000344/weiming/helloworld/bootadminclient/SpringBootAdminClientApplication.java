/** 
 * Project Name:admin-client-demo 
 * File Name:SpringBootAdminClientApplication.java 
 * Package Name:org.github.ycg000344.weiming.helloworld.bootadminclient 
 * Date:2018年6月5日上午10:53:27 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.helloworld.bootadminclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/** 
 * ClassName:SpringBootAdminClientApplication <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月5日 上午10:53:27 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootAdminClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminClientApplication.class, args);
	}
}
  