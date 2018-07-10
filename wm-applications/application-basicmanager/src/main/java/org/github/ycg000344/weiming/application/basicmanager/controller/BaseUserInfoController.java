/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日下午3:04:01 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager.controller;

import java.util.List;
import java.util.Optional;

import org.github.ycg000344.weiming.application.authclient.jjwt.UserAuthUtil;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseRouterInfoService;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseUserInfoService;
import org.github.ycg000344.weiming.application.basicmanager.vo.UserInfoVO;
import org.github.ycg000344.weiming.common.auth.exception.AuthException;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName:BaseUserInfoController <br/>
 * <br/>
 * Description: 用户信息请求操作 <br/>
 * <br/>
 * Date: 2018年6月15日 下午3:04:01 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/user")
public class BaseUserInfoController extends BaseController<BaseUserInfoService, BaseUserInfo> {

	@Autowired
	private UserAuthUtil userAuthUtil;

	@Autowired
	private BaseUserInfoService userInfoService;

	@Autowired
	private BaseRouterInfoService routerInfoService;

	/**
	 * getUserInfoByToken: 从token中获取用户基本信息、角色、菜单路由集合. <br/>
	 * 
	 * @author po.lu
	 * @param token
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/info")
	@ApiOperation(value = "获取用户信息", notes = "从token中获取用户基本信息、角色、菜单路由集合")
	@ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String")
	public ObjectRestResponse<UserInfoVO> getUserInfoByToken(@RequestParam("token") String token) {
		UserInfoVO userInfoVO = null;
		IJWTinfo ijwTinfo = userAuthUtil.getInfoFromToken(token);
		/** 查询用户角色路由信息 */
		Optional<UserInfoVO> optional = userInfoService.getUserInfoVOByUserId(ijwTinfo.getId());
		if (optional.isPresent()) {
			userInfoVO = optional.get();
			/** 格式：	父:子,子  */
			List<String> routerIds = userInfoVO.getRouterIds();
			userInfoVO.setAsyncRouterMap(routerInfoService.getRouterInfoVOByRouterIds(routerIds));
		} else {
			throw new AuthException("user is not exists.");
		}
		return new ObjectRestResponse<UserInfoVO>().data(userInfoVO);
	}

}
