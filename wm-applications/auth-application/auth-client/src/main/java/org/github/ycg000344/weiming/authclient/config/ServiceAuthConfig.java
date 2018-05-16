/** 
 * Project Name:auth-client 
 * File Name:ServiceAuthConfig.java 
 * Package Name:org.github.ycg000344.weiming.authclient.config 
 * Date:2018年5月16日下午4:13:51 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.authclient.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

/**
 * ClassName:ServiceAuthConfig <br/>
 * <br/>
 * Description: 封装鉴权客户端的信息 <br/>
 * <br/>
 * Date: 2018年5月16日 下午4:13:51 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
public class ServiceAuthConfig {

	private byte[] pubKeyByte;
	@Value("${auth.client.id:null}")
	private String clientId;
	@Value("${auth.client.secret}")
	private String clientSecret;
	@Value("${auth.client.token-header}")
	private String tokenHeader;
	@Value("${spring.application.name}")
	private String applicationName;

	public String getTokenHeader() {
		return tokenHeader;
	}

	public void setTokenHeader(String tokenHeader) {
		this.tokenHeader = tokenHeader;
	}

	public String getClientId() {
		return "null".equals(clientId) ? applicationName : clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getToken(HttpServletRequest request) {
		return request.getHeader(this.getTokenHeader());
	}

	public byte[] getPubKeyByte() {
		return pubKeyByte;
	}

	public void setPubKeyByte(byte[] pubKeyByte) {
		this.pubKeyByte = pubKeyByte;
	}

}
