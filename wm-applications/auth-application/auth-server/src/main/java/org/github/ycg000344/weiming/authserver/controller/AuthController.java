/** 
 * Project Name:auth-server 
 * File Name:AuthController.java 
 * Package Name:org.github.ycg000344.weiming.authserver.controller 
 * Date:2018年5月11日下午6:04:58 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authserver.controller;

import org.github.ycg000344.weiming.authcommon.jjwt.vo.JwtAuthenticationRequest;
import org.github.ycg000344.weiming.authcommon.jjwt.vo.JwtAuthenticationResponse;
import org.github.ycg000344.weiming.authserver.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:AuthController <br/><br/>  
 * Description: 关于外部登录时获取Token <br/><br/>  
 * Date:     2018年5月11日 下午6:04:58 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/jjwt")
@Slf4j
public class AuthController {
	
	@Autowired
    private AuthService authService;

	
	@PostMapping("/token")
	@ApiOperation(value="获取token",notes="登录获取token")
	@ApiImplicitParam(value="封装登录请求对象",required=true, dataType = "JwtAuthenticationRequest", name = "authenticationRequest")
	public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        log.info(authenticationRequest.getUsername()+" require logging...");
        final String token = authService.login(authenticationRequest);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
}
  