/** 
 * Project Name:dict-manager 
 * File Name:DictManagerApp.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager 
 * Date:2018年6月3日下午1:30:59 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.dictmanager;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

/** 
 * ClassName:DictManagerApp <br/><br/>  
 * Description: 数据字典管理 <br/><br/>  
 * Date:     2018年6月3日 下午1:30:59 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan(basePackages = "org.github.ycg000344.weiming.dictmanager.mapper")
@EnableCaching
public class DictManagerApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DictManagerApp.class).web(WebApplicationType.SERVLET).run(args);
	}

}
  