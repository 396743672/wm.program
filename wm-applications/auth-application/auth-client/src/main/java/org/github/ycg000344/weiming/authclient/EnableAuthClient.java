/** 
 * Project Name:auth-client 
 * File Name:EnableAuthClient.java 
 * Package Name:org.github.ycg000344.weiming.authclient 
 * Date:2018年5月16日下午3:58:14 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authclient;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.github.ycg000344.weiming.authclient.configration.AutoConfiguration;
import org.springframework.context.annotation.Import;

/** 
 * ClassName:EnableAuthClient <br/><br/>  
 * Description: 鉴权服务客户端标识 <br/><br/>  
 * Date:     2018年5月16日 下午3:58:14 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableAuthClient {

}
  