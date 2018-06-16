/** 
 * Project Name:auth-client 
 * File Name:UserTokenException.java 
 * Package Name:org.github.ycg000344.weiming.authclient.exception 
 * Date:2018年5月16日下午4:31:56 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authclient.exception;

import org.github.ycg000344.weiming.common.base.exception.BaseException;

/** 
 * ClassName:UserTokenException <br/><br/>  
 * Description: 用户token异常 <br/><br/>  
 * Date:     2018年5月16日 下午4:31:56 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class UserTokenException extends BaseException {
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = 7875525590362146071L;

	public UserTokenException(String errorMessage) {
		super(errorMessage);
	}
}
  