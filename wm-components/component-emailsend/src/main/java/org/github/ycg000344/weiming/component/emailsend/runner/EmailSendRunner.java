/** 
 * Project Name:emailsend-server 
 * File Name:EmailSendRunner.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.runner 
 * Date:2018年5月14日上午10:30:16 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.component.emailsend.runner;

import org.github.ycg000344.weiming.component.emailsend.thread.EmailSendThread;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:EmailSendRunner <br/><br/>  
 * Description: 应用启动后自动开启邮件发送的异步线程 <br/><br/>  
 * Date:     2018年5月14日 上午10:30:16 <br/> <br/> 
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
		log.debug("**********************应用：{} 启动成功，开启邮件发送的异步线程*************************************",name);
		EmailSendThread.getInstance().start();
		log.debug("邮件发送的异步线程状态为: {}",EmailSendThread.getInstance().getState().toString());
	
	}

}
  