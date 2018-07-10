/** 
 * Project Name:application-basicmanager 
 * File Name:BaseLogService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年7月10日下午4:38:23 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseLog;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseLogMapper;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * ClassName:BaseLogService <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年7月10日 下午4:38:23 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional
public class BaseLogService extends BaseService<BaseLogMapper, BaseLog> {

}
  