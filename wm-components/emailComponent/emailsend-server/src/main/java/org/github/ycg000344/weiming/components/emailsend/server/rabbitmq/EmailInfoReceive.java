/** 
 * Project Name:emailsend-server 
 * File Name:EmailInfoReceive.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.rabbitmq 
 * Date:2018年5月11日上午9:32:33 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.components.emailsend.server.rabbitmq;

import org.github.ycg000344.weiming.common.emailsend.bean.BaseEmailInfo;
import org.github.ycg000344.weiming.components.emailsend.server.function.EmailSendFunction;
import org.github.ycg000344.weiming.components.emailsend.server.thread.EmailSendThread;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:EmailInfoReceive <br/><br/>  
 * Description: 接收rabbitmq发来的信息 <br/><br/>  
 * Date:     2018年5月11日 上午9:32:33 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Component
@Slf4j
@RabbitListener(queues = "email")
public class EmailInfoReceive {
	
	@Autowired
	private EmailSendFunction emailSendFunction;
	
	@RabbitHandler
    public void process(BaseEmailInfo emailInfo) {
		log.info("********************接收到rabbitmq：111.230.220.114的消息：{}", emailInfo.toString());
		EmailSendThread.getInstance().setEmailSendFunction(emailSendFunction);
		EmailSendThread.getInstance().offerEmailInfo(emailInfo);
    }

}
  