/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRouterInfoControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月23日上午10:40:32 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRouterInfo;
import org.github.ycg000344.weiming.common.base.constants.CommonConstants;
import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.common.basebusiness.vo.TableResultResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class BaseRouterInfoControllerTest extends BasicManagerAppTest {

	@Autowired
	private BaseRouterInfoController controller;

	@Test
	public void testAdd() {
		// 添加新的路由--- routers
		BaseRouterInfo entity = new BaseRouterInfo();
		entity.setPath("/routers");
		entity.setName("bascimanager_routers");
		entity.setComponent("@/views/basicmanager/routers");
		entity.setTitle("routers");
		entity.setIcon("example");
		entity.setRouterParentId(6);
		controller.add(entity);
	}

	// @Test
	public void testChildren() {
		log.debug("*******【进入BaseRouterInfoControllerTest.testChildren()】***********");
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("page", "1");
		params.put("limit", "10");
		params.put("prop", "create_time");
		params.put("order", "desc");
		params.put("routerParentId", "1");
		TableResultResponse<BaseRouterInfo> children = controller.children(params);
		log.debug("***【{}】***", children.toString());
	}

	// @Test
	public void parents() {
		log.debug("*******【进入BaseRouterInfoControllerTest.parents()】***********");
		ObjectRestResponse<List<BaseRouterInfo>> parentRouters = controller.parents();
		log.debug("***【{}】***", parentRouters.toString());
	}

	// @Test
	public void TestList() {
		log.debug("*******【进入BaseRouterInfoControllerTest.TestList()】***********");
		BaseRouterInfo entity = new BaseRouterInfo();
		entity.setRouterParentId(-1);
		ObjectRestResponse<List<BaseRouterInfo>> list = controller.list(entity);
		log.debug("***【{}】***", list.toString());
	}

	/**
	 * addRouetr:创建基础管理模块路由. <br/>
	 * 
	 * @author po.lu
	 * @since JDK 1.8
	 * @see
	 */
	// @Test
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

		/** 操作日志 */
		BaseRouterInfo routerInfo = new BaseRouterInfo();
		routerInfo.setPath("optlog");
		routerInfo.setName("bascimanager_optlog");
		routerInfo.setComponent("@/views/table/index");
		routerInfo.setTitle("optlog");
		routerInfo.setIcon("example");
		routerInfo.setRouterParentId(routerId);
		controller.add(routerInfo);

	}

	// @Test
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
