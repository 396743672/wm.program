/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserRoutersInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月21日下午9:34:17 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserRoutersInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseUserRoutersInfoService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:BaseUserRoutersInfoController <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月21日 下午9:34:17 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/user-routers")
public class BaseUserRoutersInfoController extends BaseController<BaseUserRoutersInfoService, BaseUserRoutersInfo> {

}
  