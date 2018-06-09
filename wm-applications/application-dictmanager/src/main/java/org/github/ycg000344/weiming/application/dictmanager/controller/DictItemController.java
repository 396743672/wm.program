/** 
 * Project Name:dict-manager 
 * File Name:DictItemController.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.controller 
 * Date:2018年6月3日下午2:12:27 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.dictmanager.controller;

import org.github.ycg000344.weiming.application.dictmanager.entity.DictItem;
import org.github.ycg000344.weiming.application.dictmanager.service.DictItemService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:DictItemController <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月3日 下午2:12:27 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/dictitem")
public class DictItemController extends BaseController<DictItemService, DictItem> {

}
  