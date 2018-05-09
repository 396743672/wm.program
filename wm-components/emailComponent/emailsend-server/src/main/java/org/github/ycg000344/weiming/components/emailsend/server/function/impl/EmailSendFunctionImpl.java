/** 
 * Project Name:emailsend-server 
 * File Name:EmailSendFunctionImpl.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.function.impl 
 * Date:2018年5月9日下午2:08:10 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.components.emailsend.server.function.impl;

import org.github.ycg000344.weiming.components.emailsend.api.bean.EmailInfo;
import org.github.ycg000344.weiming.components.emailsend.server.function.EmailSendFunction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:EmailSendFunctionImpl <br/>
 * <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年5月9日 下午2:08:10 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Slf4j
@Component
public class EmailSendFunctionImpl implements EmailSendFunction {

	@Autowired
	private JavaMailSender javaMailSender;
	private SimpleMailMessage simpleMailMessage;
	/** 发件人 **/
	@Value("${Spring.mail.username}")
	private String defalutFrom;

	@Override
	public boolean send(EmailInfo emailInfo) {
		log.info("**********准备发送邮件**********");
		log.info("邮件信息：\r\n接收人：{},\r\n主题：{}\r\n");
		boolean flag = false;
		try {
			BeanUtils.copyProperties(emailInfo, simpleMailMessage);
			simpleMailMessage.setFrom(defalutFrom);
			javaMailSender.send(simpleMailMessage);
			flag = true;
			log.info("********邮件发送结果：成功********");
		} catch (Exception e) {
			log.error("********邮件发送结果：失败********");
			e.printStackTrace();
		}
		return flag;
	}
}
