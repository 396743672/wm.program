/** 
 * Project Name:application-authserver 
 * File Name:JwtTokenUtil.java 
 * Package Name:org.github.ycg000344.weiming.application.authserver.rpc 
 * Date:2018年6月16日下午4:33:37 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authserver.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.github.ycg000344.weiming.application.authserver.configuration.KeyConfiguration;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.common.auth.jjwt.helper.JWThelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/** 
 * ClassName:JwtTokenUtil <br/><br/>  
 * Description: jwttoken <br/><br/>  
 * Date:     2018年6月16日 下午4:33:37 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Component
public class JwtTokenUtil {

	@Value("${authserver.jwt.expire}")
	private Integer expire; 
	
    @Autowired
    private KeyConfiguration keyConfiguration;
    
    
    public String generateToken(IJWTinfo jwtInfo) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return JWThelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(),expire);
    }

    public IJWTinfo getInfoFromToken(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, InvalidKeySpecException, NoSuchAlgorithmException {
        return JWThelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
    }
}
  