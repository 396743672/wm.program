/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRouterInfoMapperTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.mapper 
 * Date:2018年6月24日下午3:23:10 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.mapper;

import java.util.List;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRouterInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseRouterInfoMapperTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月24日 下午3:23:10 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class BaseRouterInfoMapperTest extends BasicManagerAppTest {

	@Autowired
	private BaseRouterInfoMapper routerInfoMapper ;
	@Test
	public void test() {
		String routerIds = "3,4";
		String routerParnetId = "1";
		List<BaseRouterInfo> routerInfoByIds = routerInfoMapper.getRouterInfoByIds(routerParnetId, routerIds);
		routerInfoByIds.parallelStream().forEach(r->log.info(r.toString()));
	}

}
  