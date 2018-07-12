/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRouterInfoControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月23日上午10:40:32 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRouterInfo;
import org.github.ycg000344.weiming.common.base.constants.CommonConstants;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName:BaseRouterInfoControllerTest <br/>
 * <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年6月23日 上午10:40:32 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
public class BaseRouterInfoControllerTest extends BasicManagerAppTest {

	@Autowired
	private BaseRouterInfoController controller;

	/** 
	 * addRouetr:创建基础管理模块路由. <br/> 
	 * 
	 * @author po.lu 
	 * @since JDK 1.8 
	 * @see
	 */  
	@Test
	public void addRouetr() {
		/** 基础管理 */
		BaseRouterInfo entity = new BaseRouterInfo();
		entity.setPath("/bascimanager");
		entity.setName("bascimanager");
		entity.setTitle("bascimanager");
		entity.setIcon("example");
		entity.setRouterParentId(CommonConstants.ROUTER_PARENT_ID_DEFAULT);
		controller.add(entity);
		
		// 子路由
		Integer routerId = entity.getRouterId();
		
		/** 操作日志*/
		BaseRouterInfo routerInfo = new BaseRouterInfo();
		routerInfo.setPath("optlog");
		routerInfo.setName("optlog");
		routerInfo.setComponent("@/views/table/index");
		routerInfo.setTitle("optlog");
		routerInfo.setIcon("table");
		routerInfo.setRouterParentId(routerId);
		controller.add(routerInfo);

	}

	@Test
	public void test() {

		/**
		 * 1. 创建父级路由需要的参数： 1.1 path 必填 1.2 component 数据库已设置默认值 1.3 name 必填 1.4 title 必填
		 * 1.5 icon 必填 1.6 roles 选填 1.7 router_parent_id:-1 默认值
		 * 
		 * 
		 * 2. 创建子路由需要的参数 2.1 path 必填 2.2 name 必填 2.3 component 必填 2.4 title 必填 2.5 icon
		 * 必填 2.6 roles 选填 2.7 router_parent_id 必填
		 */

		// 父级路由

		// Example
		BaseRouterInfo entity = new BaseRouterInfo();
		entity.setPath("/example");
		entity.setName("Example");
		entity.setTitle("Example");
		entity.setIcon("example");
		entity.setRouterParentId(CommonConstants.ROUTER_PARENT_ID_DEFAULT);
		controller.add(entity);
		// Form
		BaseRouterInfo routerInfo3 = new BaseRouterInfo();
		routerInfo3.setPath("/form");
		routerInfo3.setName("Form");
		routerInfo3.setTitle("Form");
		routerInfo3.setIcon("form");
		routerInfo3.setRouterParentId(CommonConstants.ROUTER_PARENT_ID_DEFAULT);
		controller.add(routerInfo3);

		// 子路由
		Integer routerId = entity.getRouterId();

		// Table
		BaseRouterInfo routerInfo = new BaseRouterInfo();
		routerInfo.setPath("table");
		routerInfo.setName("Table");
		routerInfo.setComponent("@/views/table/index");
		routerInfo.setTitle("Table");
		routerInfo.setIcon("table");
		routerInfo.setRouterParentId(routerId);
		controller.add(routerInfo);

		// Tree
		BaseRouterInfo routerInfo2 = new BaseRouterInfo();
		routerInfo2.setPath("tree");
		routerInfo2.setName("Tree");
		routerInfo2.setComponent("@/views/tree/index");
		routerInfo2.setTitle("Tree");
		routerInfo2.setIcon("tree");
		routerInfo2.setRoles("600000,600001,600002,600003");
		routerInfo2.setRouterParentId(routerId);
		controller.add(routerInfo2);

		// 子路由
		Integer routerId2 = routerInfo3.getRouterId();
		// form
		BaseRouterInfo routerInfo4 = new BaseRouterInfo();
		routerInfo4.setPath("index");
		routerInfo4.setName("Form");
		routerInfo4.setComponent("@/views/form/index");
		routerInfo4.setTitle("Form");
		routerInfo4.setIcon("form");
		routerInfo4.setRouterParentId(routerId2);
		controller.add(routerInfo4);

	}

}
