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
import org.github.ycg000344.weiming.application.basicmanager.service.BaseLoginInfoService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:BaseLoginInfoController <br/><br/>  
 * Description: 登录操作 <br/><br/>  
 * Date:     2018年6月15日 下午3:03:36 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/login")
public class BaseLoginInfoController extends BaseController<BaseLoginInfoService, BaseLoginInfo> {

}
  