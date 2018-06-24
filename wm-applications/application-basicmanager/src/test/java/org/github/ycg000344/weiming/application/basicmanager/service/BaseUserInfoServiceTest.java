/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserInfoServiceTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月24日下午4:51:08 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import java.util.List;
import java.util.Optional;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.vo.RouterInfoVO;
import org.github.ycg000344.weiming.application.basicmanager.vo.UserInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseUserInfoServiceTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月24日 下午4:51:08 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class BaseUserInfoServiceTest extends BasicManagerAppTest {

	@Autowired
	private BaseUserInfoService userInfoService ;
	
	@Autowired
	private BaseRouterInfoService routerInfoService ;
	
	
	@Test
	public void test() {
		String userId = "600000";
		Optional<UserInfoVO> optional = userInfoService.getUserInfoVOByUserId(userId );
		if (optional.isPresent()) {
			UserInfoVO userInfoVO = optional.get();
			log.info(userInfoVO.toString());
			List<RouterInfoVO> routerIds = routerInfoService.getRouterInfoVOByRouterIds(userInfoVO.getRouterIds());
			routerIds.forEach(r-> log.info(r.toString()));
		}
	}

}
  