/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserInfoControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日下午3:46:23 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserInfo;
import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseUserInfoControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月15日 下午3:46:23 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class BaseUserInfoControllerTest extends BasicManagerAppTest {

	@Autowired
	private BaseUserInfoController  userInfoController ;
	@Test
	public void test() {
		BaseUserInfo entity = new BaseUserInfo();
		entity.setUserName("管理员");
		entity.setLoginName("admin");
		ObjectRestResponse<BaseUserInfo> response = userInfoController.add(entity);
		log.info(response.toString());
	}

}
  