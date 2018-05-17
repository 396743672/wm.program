/** 
 * Project Name:auth-client 
 * File Name:ServiceAuthFeign.java 
 * Package Name:org.github.ycg000344.weiming.authclient.feign 
 * Date:2018年5月16日下午4:07:23 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authclient.feign;

import org.github.ycg000344.weiming.common.constants.CommonConstants;
import org.github.ycg000344.weiming.common.vo.ObjectRestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * ClassName:ServiceAuthFeign <br/><br/>  
 * Description: 鉴权服务RPC <br/><br/>  
 * Date:     2018年5月16日 下午4:07:23 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@FeignClient(value = CommonConstants.AUTH_SERVER_NAME)
public interface ServiceAuthFeign {
	
	@RequestMapping(value = "/client/userPubKey",method = RequestMethod.POST)
    ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);


}
  