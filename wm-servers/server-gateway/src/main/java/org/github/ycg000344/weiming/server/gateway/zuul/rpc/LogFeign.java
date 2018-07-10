/** 
 * Project Name:server-gateway 
 * File Name:LogFeign.java 
 * Package Name:org.github.ycg000344.weiming.server.gateway.zuul.rpc 
 * Date:2018年7月10日下午5:09:48 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.server.gateway.zuul.rpc;

import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.server.gateway.zuul.vo.BaseLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * ClassName:LogFeign <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年7月10日 下午5:09:48 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@FeignClient(name = "wm-app-basicmanager")
public interface LogFeign {

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	ObjectRestResponse<BaseLog> add(@RequestBody BaseLog entity);
}
  