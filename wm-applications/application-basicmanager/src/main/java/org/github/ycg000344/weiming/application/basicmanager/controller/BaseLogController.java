/** 
 * Project Name:application-basicmanager 
 * File Name:BaseLogController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年7月10日下午4:46:29 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseLog;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseLogService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:BaseLogController <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年7月10日 下午4:46:29 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/log")
public class BaseLogController extends BaseController<BaseLogService, BaseLog> {

}
  