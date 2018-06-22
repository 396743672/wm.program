/** 
 * Project Name:auth-client 
 * File Name:UserAuthUtil.java 
 * Package Name:org.github.ycg000344.weiming.authclient.jjwt 
 * Date:2018年5月16日下午4:21:10 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.authclient.jjwt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.github.ycg000344.weiming.application.authclient.config.UserAuthConfig;
import org.github.ycg000344.weiming.common.auth.exception.AuthException;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.common.auth.jjwt.helper.JWThelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * ClassName:UserAuthUtil <br/>
 * <br/>
 * Description: 解析token封装的用户信息工具类 <br/>
 * <br/>
 * Date: 2018年5月16日 下午4:21:10 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Component
public class UserAuthUtil {
	@Autowired
	private UserAuthConfig userAuthConfig;

	public IJWTinfo getInfoFromToken(String token) {
		try {
			return JWThelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
		} catch (ExpiredJwtException ex) {
			throw new AuthException("User token ExpiredJwtException!");
		} catch (SignatureException ex) {
			throw new AuthException("User token SignatureException!");
		} catch (IllegalArgumentException ex) {
			throw new AuthException("User token IllegalArgumentException!");
		} catch (UnsupportedJwtException e) {
			throw new AuthException("User token UnsupportedJwtException!");
		} catch (MalformedJwtException e) {
			throw new AuthException("User token MalformedJwtException!");
		} catch (InvalidKeySpecException e) {
			throw new AuthException("User token InvalidKeySpecException!");
		} catch (NoSuchAlgorithmException e) {
			throw new AuthException("User token NoSuchAlgorithmException!");
		}
	}
}
