/** 
 * Project Name:auth-server 
 * File Name:JwtAuthenticationRequest.java 
 * Package Name:org.github.ycg000344.weiming.authserver.bean 
 * Date:2018年5月11日下午7:06:26 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.common.auth.jjwt.vo;

import java.io.Serializable;

import lombok.Data;

/** 
 * ClassName:JwtAuthenticationRequest <br/><br/>  
 * Description: 登录提交的form对象 <br/><br/>  
 * Date:     2018年5月11日 下午7:06:26 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Data
public class JwtAuthenticationRequest implements Serializable {
    /** 
	 * serialVersionUID:
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = 8707163730220576650L;
	private String username;
    private String password;
}
  