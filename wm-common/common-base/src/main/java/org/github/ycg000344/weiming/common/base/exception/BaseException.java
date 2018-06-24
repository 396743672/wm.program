/** 
 * Project Name:wm-common 
 * File Name:BaseException.java 
 * Package Name:org.github.ycg000344.weiming.common.exception 
 * Date:2018年5月6日下午5:48:14 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.common.base.exception;

/**
 * ClassName:BaseException <br/>
 * <br/>
 * Description: 自定义基础异常类 <br/>
 * <br/>
 * Date: 2018年5月6日 下午5:48:14 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
public class BaseException extends RuntimeException {

	/**
	 * serialVersionUID:TODO.
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 500447966994982256L;
	protected Integer errorCode;
	protected String errorMessage;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

	public BaseException(Integer errorCode) {
		super();
		this.errorCode = errorCode;
	}
	

	public BaseException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public BaseException(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
