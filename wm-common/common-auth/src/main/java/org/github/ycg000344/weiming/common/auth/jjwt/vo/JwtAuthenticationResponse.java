/** 
 * Project Name:auth-server 
 * File Name:JwtAuthenticationResponse.java 
 * Package Name:org.github.ycg000344.weiming.authserver.bean 
 * Date:2018年5月11日下午7:14:18 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.common.auth.jjwt.vo;

import java.io.Serializable;

import lombok.Data;

/** 
 * ClassName:JwtAuthenticationResponse <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月11日 下午7:14:18 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Data
public class JwtAuthenticationResponse implements Serializable {

	/** 
	 * serialVersionUID:
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = 4094360498025025501L;
	private String token;
	
	public JwtAuthenticationResponse(String token) {
		super();
		this.token = token;
	}
	
}
  