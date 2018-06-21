/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRoleInfoService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月21日下午9:18:18 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRoleInfo;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseRoleInfoMapper;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseRoleInfoService <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月21日 下午9:18:18 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional
@Slf4j
public class BaseRoleInfoService extends BaseService<BaseRoleInfoMapper, BaseRoleInfo> {

}
  