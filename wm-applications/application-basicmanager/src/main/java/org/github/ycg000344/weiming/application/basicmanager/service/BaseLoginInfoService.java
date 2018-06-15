/** 
 * Project Name:application-basicmanager 
 * File Name:BaseLoginInfoService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月15日下午3:02:03 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseLoginInfo;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseLoginInfoMapper;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * ClassName:BaseLoginInfoService <br/><br/>  
 * Description: 登录 <br/><br/>  
 * Date:     2018年6月15日 下午3:02:03 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional
public class BaseLoginInfoService extends BaseService<BaseLoginInfoMapper, BaseLoginInfo> {

}
  