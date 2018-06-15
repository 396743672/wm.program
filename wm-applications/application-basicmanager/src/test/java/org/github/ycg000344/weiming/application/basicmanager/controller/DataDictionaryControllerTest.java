/** 
 * Project Name:application-basicmanager 
 * File Name:DataDictionaryControllerTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.controller 
 * Date:2018年6月15日上午11:13:15 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.controller;

import java.util.HashMap;

import org.github.ycg000344.weiming.application.basicmanager.BasicManagerAppTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * ClassName:DataDictionaryControllerTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月15日 上午11:13:15 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class DataDictionaryControllerTest extends BasicManagerAppTest {

	@Autowired
	private DataDictionaryController  controller ;
	@Test
	public void test() {
		controller.list(new HashMap<>());
	}

}
  