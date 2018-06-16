/** 
 * Project Name:auth-server 
 * File Name:AuthService.java 
 * Package Name:org.github.ycg000344.weiming.authserver.service 
 * Date:2018年5月11日下午6:09:22 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authserver.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.github.ycg000344.weiming.application.authserver.rpc.LoginFeign;
import org.github.ycg000344.weiming.application.authserver.utils.JwtTokenUtil;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.common.auth.jjwt.vo.JwtAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:AuthService <br/><br/>  
 * Description: 关于外部登录时获取Token <br/><br/>  
 * Date:     2018年5月11日 下午6:09:22 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Slf4j
public class AuthService {
	
	@Autowired
	private LoginFeign loginFeign ;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil ;

	/**
	 * 
	 * login:登录获取token. <br/> 
	 * 
	 * @author po.lu
	 * @param authenticationRequest
	 * @return 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 * @since JDK 1.8 
	 * @see
	 */
	public String login(JwtAuthenticationRequest authenticationRequest) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO 人员进行登录，获取token
		log.info("***************** 人员：{} 进行登录，获取token *********************",authenticationRequest.getUsername());
		String token = null;
		IJWTinfo jwtInfo = loginFeign.login(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		if (null!= jwtInfo && StrUtil.isNotEmpty(jwtInfo.getId())) {
			token = jwtTokenUtil.generateToken(jwtInfo);
		}
		return token;
	}

}
  