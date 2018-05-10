/** 
 * Project Name:emailsend-server 
 * File Name:EmailSendFunctionTest.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.function 
 * Date:2018年5月9日下午3:36:35 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.components.emailsend.server.function;

import java.util.Date;

import org.github.ycg000344.weiming.components.emailsend.api.bean.EmailInfo;
import org.github.ycg000344.weiming.components.emailsend.server.EmailSendServerAppTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hutool.core.date.DateUtil;

/** 
 * ClassName:EmailSendFunctionTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月9日 下午3:36:35 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class EmailSendFunctionTest extends EmailSendServerAppTest {
	
	@Autowired
	private EmailSendFunction emailSendFunction;
	
	@Test
	public void test() {
		String text = "junit-text";
		String subject = "junit-subject" + DateUtil.formatDate(new Date());
		String to = "lupo.f@outlook.com";
		EmailInfo emailInfo = new EmailInfo( subject, text ,to);
		boolean send = emailSendFunction.send(emailInfo);
		Assert.assertTrue(send);
	}
	

 }
  