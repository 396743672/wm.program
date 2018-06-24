/** 
 * Project Name:application-basicmanager 
 * File Name:MyJunitTest.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager 
 * Date:2018年6月24日下午4:31:34 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:MyJunitTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月24日 下午4:31:34 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Slf4j
public class MyJunitTest {

	@Test
	public void test() {
		List<String> emptyList = Collections.emptyList();
		emptyList.add("123");
		log.info(emptyList.size()+"");
	}

}
  