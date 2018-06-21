/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserRolesInfoControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月21日下午9:35:04 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserRolesInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * ClassName:BaseUserRolesInfoControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月21日 下午9:35:04 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class BaseUserRolesInfoControllerTest extends BasicManagerAppTest {

	@Autowired
	private BaseUserRolesInfoController controller ;
	@Test
	public void test() {
		BaseUserRolesInfo entity = null;
		entity = new BaseUserRolesInfo();
		entity.setUserId(600000);
		entity.setRoleIds("600000,600001,600002,600003");
		controller.add(entity);
	}

}
  