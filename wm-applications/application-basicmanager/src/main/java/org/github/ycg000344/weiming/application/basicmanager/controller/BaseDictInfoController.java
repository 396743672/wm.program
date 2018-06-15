/** 
 * Project Name:application-basicmanager 
 * File Name:BaseDictInfoController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日下午3:03:08 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseDictInfo;
import org.github.ycg000344.weiming.application.basicmanager.service.BaseDictInfoService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:BaseDictInfoController <br/><br/>  
 * Description: 数据字典请求操作 <br/><br/>  
 * Date:     2018年6月15日 下午3:03:08 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/dict")
public class BaseDictInfoController extends BaseController<BaseDictInfoService, BaseDictInfo> {

}
  