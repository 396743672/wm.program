/** 
 * Project Name:auth-server 
 * File Name:KeyConfiguration.java 
 * Package Name:org.github.ycg000344.weiming.authserver.configuration 
 * Date:2018年5月14日下午6:13:45 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.authserver.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName:KeyConfiguration <br/>
 * <br/>
 * Description: 公钥、私钥相关 <br/>
 * <br/>
 * Date: 2018年5月14日 下午6:13:45 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Configuration
@Getter
@Setter
public class KeyConfiguration {

	/** 用来生成公钥、密钥的密码 */
	@Value("${authserver.jwt.rsa-secret}")
	private String userSecret;
	/** 存储于内存中的公钥 */
	private byte[] userPubKey;
	/** 存储于内存中的私钥 */
	private byte[] userPriKey;

}
