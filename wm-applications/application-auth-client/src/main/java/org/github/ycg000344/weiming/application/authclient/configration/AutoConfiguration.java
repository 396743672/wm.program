/** 
 * Project Name:auth-client 
 * File Name:AutoConfiguration.java 
 * Package Name:org.github.ycg000344.weiming.authclient.configration 
 * Date:2018年5月16日下午3:59:02 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authclient.configration;

import org.github.ycg000344.weiming.application.authclient.config.UserAuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
 * ClassName:AutoConfiguration <br/><br/>  
 * Description: 自动实例化配置 <br/><br/>  
 * Date:     2018年5月16日 下午3:59:02 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
public class AutoConfiguration {

	@Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }
	
}
  