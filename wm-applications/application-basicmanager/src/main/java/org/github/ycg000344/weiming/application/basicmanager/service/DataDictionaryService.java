/** 
 * Project Name:application-basicmanager 
 * File Name:DataDictionaryService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月15日上午11:05:17 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import org.github.ycg000344.weiming.application.basicmanager.entity.DataDictionary;
import org.github.ycg000344.weiming.application.basicmanager.mapper.DataDictionaryMapper;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * ClassName:DataDictionaryService <br/><br/>  
 * Description: 数据字典 <br/><br/>  
 * Date:     2018年6月15日 上午11:05:17 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional
public class DataDictionaryService extends BaseService<DataDictionaryMapper, DataDictionary> {

}
  