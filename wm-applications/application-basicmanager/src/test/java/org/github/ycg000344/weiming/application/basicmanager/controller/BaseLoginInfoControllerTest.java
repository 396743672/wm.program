/** 
 * Project Name:application-basicmanager 
 * File Name:BaseLoginInfoControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日下午6:03:36 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseLoginInfoControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月15日 下午6:03:36 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class BaseLoginInfoControllerTest extends BasicManagerAppTest {

	@Autowired
	private BaseLoginInfoController controller ;
	@Test
	public void test() {
		String password = "qqq123";
		String loginname = "admin";
		IJWTinfo login = controller.login(loginname, password);
		log.info("**********************【id:{},loginname:{},name:{}】******************",login.getId(),login.getUniqueName(),login.getName()	);
		
	}

}
  