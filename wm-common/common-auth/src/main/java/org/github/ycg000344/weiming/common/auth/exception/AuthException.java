/** 
 * Project Name:common-auth 
 * File Name:AuthException.java 
 * Package Name:org.github.ycg000344.common.auth.exception 
 * Date:2018年6月16日下午4:59:46 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.common.auth.exception;

import org.github.ycg000344.weiming.common.base.constants.CommonConstants;
import org.github.ycg000344.weiming.common.base.exception.BaseException;

import lombok.ToString;

/** 
 * ClassName:AuthException <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月16日 下午4:59:46 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@ToString
public class AuthException extends BaseException {

	/** 
	 * serialVersionUID
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private static final long serialVersionUID = -7972113496138216114L;

	public AuthException(String errorMessage) {
		super( CommonConstants.AUTH_EXCEPTION_CODE,errorMessage);
	}
}
  