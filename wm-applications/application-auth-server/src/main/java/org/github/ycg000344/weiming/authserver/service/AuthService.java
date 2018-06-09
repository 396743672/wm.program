/** 
 * Project Name:auth-server 
 * File Name:AuthService.java 
 * Package Name:org.github.ycg000344.weiming.authserver.service 
 * Date:2018年5月11日下午6:09:22 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authserver.service;

import org.github.ycg000344.weiming.common.auth.jjwt.vo.JwtAuthenticationRequest;

/** 
 * ClassName:AuthService <br/><br/>  
 * Description: 关于外部登录时获取Token <br/><br/>  
 * Date:     2018年5月11日 下午6:09:22 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public interface AuthService {

	/**
	 * 
	 * login:登录获取token. <br/> 
	 * 
	 * @author po.lu
	 * @param authenticationRequest
	 * @return 
	 * @since JDK 1.8 
	 * @see
	 */
	String login(JwtAuthenticationRequest authenticationRequest);

}
  