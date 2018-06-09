/** 
 * Project Name:auth-server 
 * File Name:AuthServiceImpl.java 
 * Package Name:org.github.ycg000344.weiming.authserver.service.impl 
 * Date:2018年5月11日下午6:09:57 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authserver.service.impl;

import org.github.ycg000344.weiming.application.authserver.service.AuthService;
import org.github.ycg000344.weiming.common.auth.jjwt.vo.JwtAuthenticationRequest;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:AuthServiceImpl <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月11日 下午6:09:57 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService  {

	@Override
	public String login(JwtAuthenticationRequest authenticationRequest) {
		// TODO 人员进行登录，获取token
		log.info("***************** 人员：{} 进行登录，获取token *********************",authenticationRequest.getUsername());
		return null;
	}
	
	

}
  