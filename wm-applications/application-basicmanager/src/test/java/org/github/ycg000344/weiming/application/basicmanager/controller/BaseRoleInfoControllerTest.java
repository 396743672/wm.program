/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRoleInfoControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月21日下午9:22:07 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRoleInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * ClassName:BaseRoleInfoControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月21日 下午9:22:07 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class BaseRoleInfoControllerTest extends BasicManagerAppTest {

	@Autowired
	private BaseRoleInfoController controller ;
	@Test
	public void test() {
		BaseRoleInfo entity =null;
		// 增
//		entity = new BaseRoleInfo();
//		entity.setRoleName("add");
//		controller.add(entity);
		// 删
		entity = new BaseRoleInfo();
		entity.setRoleName("del");
		controller.add(entity);
		// 改
		entity = new BaseRoleInfo();
		entity.setRoleName("update");
		controller.add(entity);
		// 查
		entity = new BaseRoleInfo();
		entity.setRoleName("get");
		controller.add(entity);
	}

}
  