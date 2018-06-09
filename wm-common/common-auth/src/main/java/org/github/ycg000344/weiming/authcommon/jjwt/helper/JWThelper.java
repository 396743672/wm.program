/** 
 * Project Name:auth-common 
 * File Name:JWThelper.java 
 * Package Name:org.github.ycg000344.weiming.authcommon.jjwt.helper 
 * Date:2018年5月11日下午5:43:14 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.authcommon.jjwt.helper;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.github.ycg000344.weiming.authcommon.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.authcommon.jjwt.bean.impl.JJWTinfo;
import org.github.ycg000344.weiming.basecommon.constants.CommonConstants;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * ClassName:JWThelper <br/>
 * <br/>
 * Description: JWT Token相关操作 <br/>
 * <br/>
 * Date: 2018年5月11日 下午5:43:14 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
public class JWThelper {

	/**
	 * 
	 * generateToken:密钥加密token. <br/>
	 * 
	 * @author po.lu
	 * @param jwtInfo
	 * @param priKeyPath 私钥文件路径
	 * @param expire token有效期(min)
	 * @return
	 * @throws InvalidKeySpecException
	 * 
	 * @throws NoSuchAlgorithmException
	 * @since JDK 1.8
	 * @see
	 */
	public static String generateToken(IJWTinfo jwtInfo, String priKeyPath, int expire)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		String compactJws = Jwts.builder().setSubject(jwtInfo.getUniqueName())
				.claim(CommonConstants.JWT_KEY_ID, jwtInfo.getId())
				.claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
				.setExpiration(DateTime.now().offset(DateField.MINUTE, expire))
				.signWith(SignatureAlgorithm.RS256, RsaKeyHelper.getInstance().getPrivateKey(priKeyPath)).compact();
		return compactJws;
	}

	/**
	 * 
	 * parserToken:公钥解析token. <br/>
	 * 
	 * @author po.lu
	 * @param token
	 * @param pubKeyPath
	 * @return
	 * @throws ExpiredJwtException
	 * @throws UnsupportedJwtException
	 * @throws MalformedJwtException
	 * @throws SignatureException
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @since JDK 1.8
	 * @see
	 */
	private static Jws<Claims> parserToken(String token, String pubKeyPath)
			throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException,
			IllegalArgumentException, NoSuchAlgorithmException, InvalidKeySpecException {
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(RsaKeyHelper.getInstance().getPublicKey(pubKeyPath))
				.parseClaimsJws(token);
		return claimsJws;
	}

	/**
	 * 
	 * getInfoFromToken:从公钥文件和token中获取封装的信息. <br/> 
	 * 
	 * @author po.lu
	 * @param token 
	 * @param pubKeyPath 公钥文件路径
	 * @return
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 * @throws IllegalArgumentException 
	 * @throws SignatureException 
	 * @throws MalformedJwtException 
	 * @throws UnsupportedJwtException 
	 * @throws ExpiredJwtException 
	 * @throws Exception 
	 * @since JDK 1.8 
	 * @see
	 */
	public static IJWTinfo getInfoFromToken(String token, String pubKeyPath) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, NoSuchAlgorithmException, InvalidKeySpecException {
		Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
		Claims body = claimsJws.getBody();
		return new JJWTinfo(body.getSubject(),
				StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_ID), ""),
				StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_NAME), ""));
	}

	/** 
	 * getInfoFromToken:公钥解析token. <br/> 
	 * 
	 * @author po.lu
	 * @param token 
	 * @param pubKeyByte 内存中的公钥
	 * @return 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws IllegalArgumentException 
	 * @throws SignatureException 
	 * @throws MalformedJwtException 
	 * @throws UnsupportedJwtException 
	 * @throws ExpiredJwtException 
	 * @since JDK 1.8 
	 * @see
	 */  
	public static IJWTinfo getInfoFromToken(String token, byte[] pubKeyByte) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, InvalidKeySpecException, NoSuchAlgorithmException {
		Jws<Claims> claimsJws = parserToken(token, pubKeyByte);
        Claims body = claimsJws.getBody();
        return new JJWTinfo(body.getSubject(),
				StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_ID), ""),
				StrUtil.nullToDefault((CharSequence) body.get(CommonConstants.JWT_KEY_NAME), ""));
	}

	/** 
	 * parserToken:公钥解析token. <br/> 
	 * 
	 * @author po.lu
	 * @param token
	 * @param pubKeyByte
	 * @return 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws IllegalArgumentException 
	 * @throws SignatureException 
	 * @throws MalformedJwtException 
	 * @throws UnsupportedJwtException 
	 * @throws ExpiredJwtException 
	 * @since JDK 1.8 
	 * @see
	 */  
	private static Jws<Claims> parserToken(String token, byte[] pubKeyByte) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, InvalidKeySpecException, NoSuchAlgorithmException {
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(RsaKeyHelper.getInstance().getPublicKey(pubKeyByte)).parseClaimsJws(token);
        return claimsJws;
	}
}
