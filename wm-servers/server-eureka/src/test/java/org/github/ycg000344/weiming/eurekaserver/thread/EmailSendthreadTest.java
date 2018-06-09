/** 
 * Project Name:eureka-server 
 * File Name:EmailSendthreadTest.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver.thread 
 * Date:2018年5月11日上午11:03:28 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.eurekaserver.thread;

import org.github.ycg000344.weiming.eurekaserver.EurekaServerAppTest;
import org.github.ycg000344.weiming.server.eurekaserver.rabbitmq.EmailSend;
import org.github.ycg000344.weiming.server.eurekaserver.thread.EmailSendthread;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * ClassName:EmailSendthreadTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月11日 上午11:03:28 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class EmailSendthreadTest extends EurekaServerAppTest{
	
	@Autowired
	private EmailSend emailSend ;

	@Test
	public void test() {
		EmailSendthread instance = EmailSendthread.getInstance();
		/** Junit中必须手动start */
		instance.start();
		instance.setEmailSend(emailSend);
		for (int i = 0; i < 3; i++) {
			instance.offerInstance(null );
		}
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
  