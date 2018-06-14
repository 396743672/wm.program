/** 
 * Project Name:dict-manager 
 * File Name:DictManagerController.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.controller 
 * Date:2018年6月3日下午2:10:13 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import org.github.ycg000344.weiming.application.basicmanager.entity.Dict;
import org.github.ycg000344.weiming.application.basicmanager.service.DictService;
import org.github.ycg000344.weiming.common.basebusiness.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:DictManagerController <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月3日 下午2:10:13 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController<DictService, Dict> {

}
  