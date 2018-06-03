/** 
 * Project Name:dict-manager 
 * File Name:DictManagerService.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.service 
 * Date:2018年6月3日下午2:54:27 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.dictmanager.service;

import java.util.List;

import org.github.ycg000344.dictapi.bean.DictionaryObject;
import org.github.ycg000344.weiming.dictmanager.entity.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/** 
 * ClassName:DictManagerService <br/><br/>  
 * Description: 数据字典管理业务 <br/><br/>  
 * Date:     2018年6月3日 下午2:54:27 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
public class DictManagerService {
	
	@Autowired
	private DictService dictService;
	@Autowired
	private DictItemService dictItemService;
	
	
}
  