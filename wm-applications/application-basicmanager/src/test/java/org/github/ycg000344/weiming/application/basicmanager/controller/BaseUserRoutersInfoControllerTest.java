/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserRoutersInfoControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年7月12日下午3:38:09 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import static org.junit.Assert.*;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserRoutersInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * ClassName:BaseUserRoutersInfoControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年7月12日 下午3:38:09 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class BaseUserRoutersInfoControllerTest extends BasicManagerAppTest {

	
	@Autowired
	private BaseUserRoutersInfoController controller ;
	@Test
	public void test() {
		BaseUserRoutersInfo entity = new BaseUserRoutersInfo();
		entity.setUserId(600000);
		entity.setRouterIds("7");
		entity.setRouterParentId(6);
		controller.add(entity);
	}

}
  