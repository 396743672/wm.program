/** 
 * Project Name:dict-manager 
 * File Name:DictService.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.service 
 * Date:2018年6月3日下午1:48:30 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.dictmanager.service;

import org.github.ycg000344.weiming.businessbase.service.BaseService;
import org.github.ycg000344.weiming.dictmanager.entity.Dict;
import org.github.ycg000344.weiming.dictmanager.mapper.DictMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * ClassName:DictService <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月3日 下午1:48:30 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictService extends BaseService<DictMapper, Dict> {

}
  