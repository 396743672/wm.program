/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRouterInfoServiceTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年7月5日下午3:51:46 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.service;

import java.util.List;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.vo.RouterInfoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;

/** 
 * ClassName:BaseRouterInfoServiceTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年7月5日 下午3:51:46 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class BaseRouterInfoServiceTest extends BasicManagerAppTest {

	@Autowired
	private BaseRouterInfoService routerInfoService ;
	@Test
	public void test() {
		
		String routerIds = "1:3,4&2:5";
		List<String> list = StrUtil.split(routerIds, CharUtil.AMP);
		List<RouterInfoVO> list2 = routerInfoService.getRouterInfoVOByRouterIds(list );
		list2.forEach(i -> i.toString());
	}

}
  