/** 
 * Project Name:application-basicmanager 
 * File Name:BaseUserInfoMapperTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.mapper 
 * Date:2018年6月22日下午4:42:00 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.mapper;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.vo.UserInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseUserInfoMapperTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月22日 下午4:42:00 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class BaseUserInfoMapperTest extends BasicManagerAppTest {

	@Autowired
	private BaseUserInfoMapper mapper;
	
	
	@Test
	public void test() {
		String userId = "600000";
		UserInfoVO UserInfoVO = mapper.getUserInfoVOByUserId(userId );
		log.debug(UserInfoVO.toString());
	}
}
  