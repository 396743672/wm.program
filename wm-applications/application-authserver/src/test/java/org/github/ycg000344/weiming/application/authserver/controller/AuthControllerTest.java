/** 
 * Project Name:application-authserver 
 * File Name:AuthControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.authserver.controller 
 * Date:2018年6月16日下午3:42:44 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authserver.controller;

import org.github.ycg000344.weiming.authserver.AuthServerAppTest;
import org.github.ycg000344.weiming.common.auth.jjwt.vo.JwtAuthenticationRequest;
import org.github.ycg000344.weiming.common.auth.jjwt.vo.JwtAuthenticationResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:AuthControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月16日 下午3:42:44 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class AuthControllerTest extends AuthServerAppTest {

	@Autowired
	private AuthController controller ;
	@Test
	public void test() {
		JwtAuthenticationRequest authenticationRequest = new JwtAuthenticationRequest();
		authenticationRequest.setLoginname("admin");
		authenticationRequest.setPassword("qqq123");
		try {
			ResponseEntity<JwtAuthenticationResponse> responseEntity = controller.createAuthenticationToken(authenticationRequest );
			String token = responseEntity.getBody().getToken();
			log.info("************token:【{}】************",token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
  