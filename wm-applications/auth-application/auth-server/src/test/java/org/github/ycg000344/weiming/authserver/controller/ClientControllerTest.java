/** 

 * Project Name:auth-server 
 * File Name:ClientControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.authserver.controller 
 * Date:2018年5月16日下午4:45:31 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authserver.controller;

import static org.junit.Assert.*;

import org.github.ycg000344.weiming.authserver.AuthServerAppTest;
import org.github.ycg000344.weiming.common.vo.ObjectRestResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:ClientControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月16日 下午4:45:31 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class ClientControllerTest extends AuthServerAppTest {

	@Autowired
	private ClientController clientController ;
	
	
	@Test
	public void test() {
		String secret = "secret";
		String clientId = "clientId";
		try {
			ObjectRestResponse<byte[]> userPublicKey = clientController.getUserPublicKey(clientId, secret);
			log.info("*********************userPublicKey:【{}】******************",userPublicKey.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
  