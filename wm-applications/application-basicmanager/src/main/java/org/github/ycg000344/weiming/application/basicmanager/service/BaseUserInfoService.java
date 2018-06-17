/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserInfoService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月15日下午3:02:30 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseLoginInfo;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserInfo;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseLoginInfoMapper;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseUserInfoMapper;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseUserInfoService <br/><br/>  
 * Description: 用户信息 <br/><br/>  
 * Date:     2018年6月15日 下午3:02:30 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Service
@Transactional
@Slf4j
public class BaseUserInfoService extends BaseService<BaseUserInfoMapper, BaseUserInfo> {

	@Value("${basicmanager.defaultpwd}")
	private String defaultPwd;
	@Autowired
	private BaseLoginInfoMapper  loginInfoMapper ;
	/** 
	 * 创建用户的时候自动新增登录记录，登录密码使用默认值并加密. 
	 * @see org.github.ycg000344.weiming.common.basebusiness.service.BaseService#insert(java.lang.Object) 
	 */ 
	@Override
	public void insertSelective(BaseUserInfo entity) {
		/**保存用户信息*/ 
		log.info("***************创建新用户，用户名:{}************************开始***", entity.getUserName());
		super.insertSelective(entity);
		BaseLoginInfo loginInfo = new BaseLoginInfo();
		loginInfo.setLoginId(entity.getUserId());
		loginInfo.setLoginName(entity.getLoginName());
		loginInfo.setPassword(DigestUtils.md5DigestAsHex(defaultPwd.getBytes()));
		loginInfoMapper.insertSelective(loginInfo);
		log.info("***************创建新用户，用户名:{}************************完成***", entity.getUserName());
	}
	
	
	

}
  