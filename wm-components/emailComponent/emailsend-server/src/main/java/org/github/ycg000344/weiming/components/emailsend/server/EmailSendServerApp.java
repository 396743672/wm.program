/** 
 * Project Name:emailsend-server 
 * File Name:EmailSendServerApp.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server 
 * Date:2018年5月9日下午2:05:01 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.components.emailsend.server;

import org.github.ycg000344.weiming.components.emailsend.server.thread.EmailSendThread;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:EmailSendServerApp <br/>
 * <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年5月9日 下午2:05:01 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@SpringBootApplication
@Slf4j
public class EmailSendServerApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EmailSendServerApp.class).web(WebApplicationType.SERVLET).run(args);
		EmailSendThread.getInstance().start();
		log.info("***********************EmailSendThread.state:{}*******************",EmailSendThread.getInstance().getState().toString());
		
	}

}
