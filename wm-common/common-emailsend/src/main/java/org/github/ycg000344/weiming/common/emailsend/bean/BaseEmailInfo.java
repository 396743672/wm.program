/** 
 * Project Name:emailsend-api 
 * File Name:EmailInfo.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.api.bean 
 * Date:2018年5月9日下午2:11:10 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.common.emailsend.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * ClassName:EmailInfo <br/>
 * <br/>
 * Description: 邮件信息基类，只有接收人、抄送人、邮件主题 <br/>
 * <br/>
 * Date: 2018年5月9日 下午2:11:10 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Getter
@Setter
public abstract class BaseEmailInfo implements Serializable {

	/** 
	 * serialVersionUID:
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = -973660148670950570L;
	/* 收件人 */
	@NonNull
	protected String[] to;
	/* 抄送 */
	protected String[] cc;
	/* 主题 */
	@NonNull
	protected String subject;
	
	
	
}
