/** 
 * Project Name:emailsend-server 
 * File Name:EmailSendFunctionImpl.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.function.impl 
 * Date:2018年5月9日下午2:08:10 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.component.emailsend.function.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.github.ycg000344.weiming.common.emailsend.bean.BaseEmailInfo;
import org.github.ycg000344.weiming.component.emailsend.function.EmailSendFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
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
	@SuppressWarnings("unused")
	private static SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	
	private MimeMessage mimeMessage;
	private MimeMessageHelper mimeMessageHelper ;
	private Map<String, Object> model = new HashMap<>();
	
	@Autowired
	private Configuration configuration;
	private Template template ;

	/** 发件人 **/
	@Value("${spring.mail.username}")
	private String defalutFrom;

	@Override
	public boolean send(BaseEmailInfo emailInfo) {
		log.debug("**********准备发送邮件**********");
		log.debug("邮件信息：\r\n接收人：{},\r\n主题：{}\r\n", emailInfo.getTo(), emailInfo.getSubject());
		boolean flag = false;
		mimeMessage = javaMailSender.createMimeMessage();
		try {
			
			/** simpleMailMessage  */
//			BeanUtils.copyProperties(emailInfo, simpleMailMessage);
//			simpleMailMessage.setFrom(defalutFrom);
//			javaMailSender.send(simpleMailMessage);
			
			/** MimeMessage  */
			template = configuration.getTemplate("eurekainstancecanceled.ftl");
		    String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		    
			mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom(defalutFrom);
			mimeMessageHelper.setSubject(emailInfo.getSubject());
			mimeMessageHelper.setTo(emailInfo.getTo());
			mimeMessageHelper.setText(content, true);
			
			//javaMailSender.send(mimeMessage);
			flag = true;
			log.debug("********邮件发送结果：成功********");
		} catch (Exception e) {
			log.error("********邮件发送结果：失败********【{}】***",e);
		}
		return flag;
	}
}
