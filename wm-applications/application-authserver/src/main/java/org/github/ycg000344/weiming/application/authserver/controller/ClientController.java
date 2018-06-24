/** 
 * Project Name:auth-server 
 * File Name:ClientController.java 
 * Package Name:org.github.ycg000344.weiming.authserver.controller 
 * Date:2018年5月16日下午3:43:48 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.authserver.controller;

import org.github.ycg000344.weiming.application.authserver.configuration.KeyConfiguration;
import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:ClientController <br/>
 * <br/>
 * Description: 提供鉴权客户端查询公钥、token的接口 <br/>
 * <br/>
 * Date: 2018年5月16日 下午3:43:48 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

	@Autowired
	private KeyConfiguration keyConfiguration;

	/**
	 * getUserPublicKey:查询内存中的公钥提供给client. <br/>
	 * 
	 * @author po.lu
	 * @param clientId
	 * @param secret
	 * @return
	 * @throws Exception
	 * @since JDK 1.8
	 * @see
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/userPubKey")
	@ApiOperation(value="提供公钥",notes="向client提供公钥接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="clientId",value="客户端id",required=true,dataType="String"),
		@ApiImplicitParam(name="secret",value="客户端密码",required=true,dataType="String")
	})
	public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId,
			@RequestParam("secret") String secret) throws Exception {
		log.debug("***********************client:【{}】，secret:【{}】  ****************************", clientId, secret);
		return new ObjectRestResponse<byte[]>().data(keyConfiguration.getUserPubKey());
	}

}
