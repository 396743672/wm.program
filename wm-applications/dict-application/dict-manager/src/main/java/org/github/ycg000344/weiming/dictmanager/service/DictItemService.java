/** 
 * Project Name:dict-manager 
 * File Name:DictItemService.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.service 
 * Date:2018年6月3日下午2:05:31 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.dictmanager.service;

import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.github.ycg000344.weiming.dictmanager.entity.DictItem;
import org.github.ycg000344.weiming.dictmanager.mapper.DictItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * ClassName:DictItemService <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月3日 下午2:05:31 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictItemService extends BaseService<DictItemMapper, DictItem> {

}
  