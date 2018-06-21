/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRouterInfoService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月21日下午9:19:01 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRouterInfo;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseRouterInfoMapper;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseRouterInfoService <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月21日 下午9:19:01 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional
@Slf4j
public class BaseRouterInfoService extends BaseService<BaseRouterInfoMapper, BaseRouterInfo> {

}
  