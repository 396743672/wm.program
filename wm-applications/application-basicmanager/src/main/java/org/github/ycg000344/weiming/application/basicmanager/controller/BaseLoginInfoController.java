/** 
 * Project Name:application-basicmanager 
 * File Name:BaseLoginInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日下午3:03:36 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseLoginInfo;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseLoginInfoService;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseUserInfoService;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.impl.JJWTinfo;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:BaseLoginInfoController <br/>
 * <br/>
 * Description: 登录操作 <br/>
 * <br/>
 * Date: 2018年6月15日 下午3:03:36 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class BaseLoginInfoController extends BaseController<BaseLoginInfoService, BaseLoginInfo> {

	@Autowired
	private BaseLoginInfoService loginInfoService;
	@Autowired
	private BaseUserInfoService userInfoService ;

	@PostMapping("/validate")
	@ApiOperation(value = "用户登录", notes = "供鉴权服务进行调用，验证用户账户、密码，进而生成token")
	@ApiImplicitParams({
		@ApiImplicitParam(value = "账户", required = true, dataType = "String", name = "loginname"),
		@ApiImplicitParam(value = "密码", required = true, dataType = "String", name = "password")
	})
	public IJWTinfo login(@RequestParam("loginname")String loginname,@RequestParam("password") String password) {
		BaseLoginInfo entity = new BaseLoginInfo();
		entity.setLoginName(loginname);
		entity = loginInfoService.selectOne(entity);
		if (null != entity && entity.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			BaseUserInfo userInfo = userInfoService.selectById(entity.getLoginId());
			IJWTinfo iTinfo = new JJWTinfo(entity.getLoginName(), String.valueOf(entity.getLoginId()), userInfo.getUserName());
			log.info("***********************用户：【{}】校验密码成功*********************************************************",loginname);
			return iTinfo;
		}
		return null;
	}

}
