/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRoleInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月21日下午9:20:05 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRoleInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseRoleInfoService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:BaseRoleInfoController <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月21日 下午9:20:05 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/role")
public class BaseRoleInfoController extends BaseController<BaseRoleInfoService, BaseRoleInfo> {

}
  