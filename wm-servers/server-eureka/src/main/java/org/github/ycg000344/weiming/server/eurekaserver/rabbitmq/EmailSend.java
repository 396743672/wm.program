/** 
 * Project Name:eureka-server 
 * File Name:EmailSend.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver.rabbitmq 
 * Date:2018年5月10日下午6:24:21 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.server.eurekaserver.rabbitmq;

import java.util.Arrays;

import org.github.ycg000344.weiming.common.emailsend.bean.BaseEmailInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:EmailSend <br/><br/>  
 * Description: 邮件发送 <br/><br/>  
 * Date:     2018年5月10日 下午6:24:21 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Component
@Slf4j
public class EmailSend {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${config.rabbitmq.queue}")
	private String queue;
	
	@Value("${config.email.subject}")
	private String subject;
	
	@Value("${config.email.to}")
	private String[] to;

	
	public boolean send(BaseEmailInfo emailInfo) {
		log.info("********************准备向 rabbitmq:111.230.220.114 发送 email信息****************");
		emailInfo.setSubject(subject);
		emailInfo.setTo(to);
		log.debug("******************** email的收件人如下：{}" ,Arrays.asList(emailInfo.getTo()));
		log.debug("******************** email的主题如下：{}" ,emailInfo.getSubject());
		log.debug("******************** email具体信息如下：{}" ,emailInfo.toString());
		boolean flag =false;
		try {
			amqpTemplate.convertAndSend(queue, emailInfo);
			flag = true;
			log.debug("***************** 向 rabbitmq发送信息：发送成功 ");
		} catch (Exception ex) {
			log.error("***************** 向 rabbitmq发送信息：发送失败***,【{}】 ",ex);
		}
		
		return flag;
	}
}
  