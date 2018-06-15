/** 
 * Project Name:application-basicmanager 
 * File Name:DataDictionaryController.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日上午11:06:50 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.DataDictionary;
import org.github.ycg000344.weiming.application.basicmanager.service.DataDictionaryService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:DataDictionaryController <br/><br/>  
 * Description: 数据字典 <br/><br/>  
 * Date:     2018年6月15日 上午11:06:50 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/dict")
public class DataDictionaryController extends BaseController<DataDictionaryService, DataDictionary> {

}
  