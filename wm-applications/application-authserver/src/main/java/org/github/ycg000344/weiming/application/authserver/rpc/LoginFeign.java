/** 
 * Project Name:application-authserver 
 * File Name:LoginFeign.java 
 * Package Name:org.github.ycg000344.weiming.application.authserver.rpc 
 * Date:2018年6月15日下午5:02:51 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.authserver.rpc;

import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * ClassName:LoginFeign <br/><br/>  
 * Description: 基础管理远程调用client <br/><br/>  
 * Date:     2018年6月15日 下午5:02:51 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@FeignClient("wm-app-basicmanager")
@Configuration
public interface LoginFeign {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	IJWTinfo login(String loginname, String password);
}
  