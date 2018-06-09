/** 
 * Project Name:gateway-zuul 
 * File Name:GetawayZuulApp.java 
 * Package Name:org.github.ycg000344.weiming.gateway.zuul 
 * Date:2018年5月16日下午5:13:49 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.server.gateway.zuul;

import org.github.ycg000344.weiming.authclient.EnableAuthClient;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/** 
 * ClassName:GetawayZuulApp <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月16日 下午5:13:49 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAuthClient
@EnableZuulProxy
public class GetawayZuulApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GetawayZuulApp.class).web(WebApplicationType.SERVLET).run(args);
	}

}
  