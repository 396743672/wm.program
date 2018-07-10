/** 
 * Project Name:server-gateway 
 * File Name:LogRunner.java 
 * Package Name:org.github.ycg000344.weiming.server.gateway.zuul.runner 
 * Date:2018年7月10日下午5:21:50 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.server.gateway.zuul.runner;

import org.github.ycg000344.weiming.server.gateway.zuul.thread.LogThread;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:LogRunner <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年7月10日 下午5:21:50 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
@Slf4j
public class LogRunner implements CommandLineRunner {

	@Value("spring.application.name")
	private String applicationName;
	@Override
	public void run(String... args) throws Exception {
		log.debug("***weiming专用log***应用【{}】启动成功，准备获取启动异步线程处理操作日志***", applicationName);
		LogThread.getInstance().start();
		log.debug("**weiming专用log***操作日志异步线程状态为：【{}】***",LogThread.getInstance().getState().toString());
	}

}
  