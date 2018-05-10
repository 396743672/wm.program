/** 
 * Project Name:eureka-server 
 * File Name:EmailSendTest.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver.rabbitmq 
 * Date:2018年5月10日下午6:31:21 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.eurekaserver.rabbitmq;

import static org.junit.Assert.*;

import java.util.Date;

import org.github.ycg000344.weiming.components.emailsend.api.bean.EmailInfo;
import org.github.ycg000344.weiming.eurekaserver.EurekaServerAppTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hutool.core.date.DateUtil;

/** 
 * ClassName:EmailSendTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月10日 下午6:31:21 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class EmailSendTest extends EurekaServerAppTest {

	@Autowired
	private EmailSend emailSend;
	
	@Test
	public void testSend() {
		String text2 = "junit-text";
		String subject2 = "junit-subject" + DateUtil.formatDate(new Date());
		String to2 = "lupo.f@outlook.com";
		EmailInfo emailInfo = new EmailInfo(subject2, text2, to2);
		boolean send = emailSend.send(emailInfo);
		Assert.assertTrue(send);
	}

}
  