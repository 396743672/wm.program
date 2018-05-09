/** 
 * Project Name:emailsend-api 
 * File Name:EmailInfo.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.api.bean 
 * Date:2018年5月9日下午2:11:10 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.components.emailsend.api.bean;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;

/** 
 * ClassName:EmailInfo <br/><br/>  
 * Description: 邮件信息实体 <br/><br/>  
 * Date:     2018年5月9日 下午2:11:10 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Data
public class EmailInfo implements Serializable {

	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = 692636637918749253L;
	
	/*收件人*/
	@NonNull
	private String[] to;
	/*抄送*/
	private String[] cc;
	/*主题*/
	@NonNull
	private String subject;
	/*内容*/
	@NonNull
	private String text;
	public EmailInfo(String subject, String text ,String... to) {
		super();
		this.subject = subject;
		this.text = text;
		this.to = to;
	}
	
	
	
}
  