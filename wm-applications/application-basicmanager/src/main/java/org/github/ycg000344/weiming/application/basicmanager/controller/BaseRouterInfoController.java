/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRouterInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月21日下午9:20:52 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager.controller;

import java.util.List;
import java.util.Map;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRouterInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseRouterInfoService;
import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.github.ycg000344.weiming.common.basebusiness.util.Query;
import org.github.ycg000344.weiming.common.basebusiness.vo.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName:BaseRouterInfoController <br/>
 * <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年6月21日 下午9:20:52 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/router")
public class BaseRouterInfoController extends BaseController<BaseRouterInfoService, BaseRouterInfo> {

	@Autowired
	private BaseRouterInfoService routerInfoService;

	@GetMapping("/parents")
	@ApiOperation(value = "查询全部一级路由", notes = "查询全部一级路由，默认按照更新时间、创建时间降序")
	public ObjectRestResponse<List<BaseRouterInfo>> parents() {
		return routerInfoService.parents();
	}

	@GetMapping("/children")
	@ApiOperation(value = "分页查询二级路由", notes = "根据一级路由id分页查询二级路由")
	public TableResultResponse<BaseRouterInfo> children(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		return routerInfoService.children(query);
	}

}
