/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日下午3:04:01 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseUserInfoService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:BaseUserInfoController <br/><br/>  
 * Description: 用户信息请求操作 <br/><br/>  
 * Date:     2018年6月15日 下午3:04:01 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/user")
public class BaseUserInfoController extends BaseController<BaseUserInfoService, BaseUserInfo> {

}
  