/** 
 * Project Name:application-basicmanager 
 * File Name:BaseDictInfoService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月15日下午3:01:25 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseDictInfo;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseDictInfoMapper;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * ClassName:BaseDictInfoService <br/><br/>  
 * Description: 数据字典 <br/><br/>  
 * Date:     2018年6月15日 下午3:01:25 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional
public class BaseDictInfoService extends BaseService<BaseDictInfoMapper, BaseDictInfo> {

}
  