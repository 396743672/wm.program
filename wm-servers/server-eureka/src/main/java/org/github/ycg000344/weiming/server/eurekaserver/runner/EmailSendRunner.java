/** 
 * Project Name:eureka-server 
 * File Name:EmailSendRunner.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver.runner 
 * Date:2018年5月14日上午10:24:52 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.server.eurekaserver.runner;

import org.github.ycg000344.weiming.server.eurekaserver.thread.EmailSendthread;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:EmailSendRunner <br/><br/>  
 * Description: 应用启动后开启异步线程 <br/><br/>  
 * Date:     2018年5月14日 上午10:24:52 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Component
@Slf4j
public class EmailSendRunner implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String name;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("**********************应用：{} 启动成功，开启邮件发送的异步线程*************************************",name);
		EmailSendthread.getInstance().start();
		log.info("邮件发送的异步线程状态为: {}",EmailSendthread.getInstance().getState().toString());
	

	}

}
  