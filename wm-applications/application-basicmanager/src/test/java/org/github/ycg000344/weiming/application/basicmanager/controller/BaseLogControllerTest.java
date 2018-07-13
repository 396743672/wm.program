/** 
 * Project Name:application-basicmanager 
 * File Name:BaseLogControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年7月13日下午1:49:33 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseLog;
import org.github.ycg000344.weiming.common.basebusiness.vo.TableResultResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:BaseLogControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年7月13日 下午1:49:33 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class BaseLogControllerTest extends BasicManagerAppTest {

	@Autowired
	private BaseLogController controller ;
	@Test
	public void test() {
		log.debug("*******【进入BaseLogControllerTest.test()】***********");
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("page", "1");
		params.put("limit", "10");
		params.put("prop", "create_time");
		params.put("order", "desc");
		TableResultResponse<BaseLog> page = controller.page(params);
		log.debug("***【{}】***",page.toString());
	}

}
  