/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserRolesInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月21日下午9:33:20 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserRolesInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseUserRolesInfoService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:BaseUserRolesInfoController <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月21日 下午9:33:20 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/user-roles")
public class BaseUserRolesInfoController extends BaseController<BaseUserRolesInfoService, BaseUserRolesInfo> {

}
  