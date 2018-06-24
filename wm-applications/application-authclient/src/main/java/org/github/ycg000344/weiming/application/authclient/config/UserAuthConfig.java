/** 
 * Project Name:auth-client 
 * File Name:UserAuthConfig.java 
 * Package Name:org.github.ycg000344.weiming.authclient.configration.config 
 * Date:2018年5月16日下午3:59:52 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authclient.config;

import org.github.ycg000344.weiming.common.base.constants.CommonConstants;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** 
 * ClassName:UserAuthConfig <br/><br/>  
 * Description: token-header、公钥 <br/><br/>  
 * Date:     2018年5月16日 下午3:59:52 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Setter
@Getter
@Component
@ToString
public class UserAuthConfig {

    private byte[] pubKeyByte;

	public String getTokenHeader() {
		return CommonConstants.AUTH_USER_TOKEN;
	}
    
    

}
  