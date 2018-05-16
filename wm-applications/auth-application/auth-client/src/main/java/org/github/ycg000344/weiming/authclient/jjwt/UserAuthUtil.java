/** 
 * Project Name:auth-client 
 * File Name:UserAuthUtil.java 
 * Package Name:org.github.ycg000344.weiming.authclient.jjwt 
 * Date:2018年5月16日下午4:21:10 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.authclient.jjwt;

import org.github.ycg000344.weiming.authclient.config.UserAuthConfig;
import org.github.ycg000344.weiming.authclient.exception.UserTokenException;
import org.github.ycg000344.weiming.authcommon.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.authcommon.jjwt.helper.JWThelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

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

	public IJWTinfo getInfoFromToken(String token) throws Exception {
		try {
			return JWThelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
		} catch (ExpiredJwtException ex) {
			throw new UserTokenException("User token expired!");
		} catch (SignatureException ex) {
			throw new UserTokenException("User token signature error!");
		} catch (IllegalArgumentException ex) {
			throw new UserTokenException("User token is null or empty!");
		}
	}
}
