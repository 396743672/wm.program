/** 
 * Project Name:dict-manager 
 * File Name:DictManagerRunning.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.runner 
 * Date:2018年6月3日下午3:17:38 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.dictmanager.runner;

import java.util.concurrent.TimeUnit;

import org.github.ycg000344.weiming.dictmanager.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName:DictManagerRunning <br/><br/>  
 * Description: 将数据字典加载进入redis,有效期为12小时 <br/><br/>  
 * Date:     2018年6月3日 下午3:17:38 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Component
@Slf4j
public class DictManagerRunning implements CommandLineRunner {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private DictService dictService;
	
	@Value("${spring.application.name}")
	private String applicationName;
	@Override
	public void run(String... args) throws Exception {
		try {
			log.info("*****************项目：【{}】成功启动，操作redis****************开始***",applicationName);
			dictionary2redis();
			log.info("*****************项目：【{}】成功启动，操作redis****************成功***");
		} catch (Exception e) {
			log.error("*****************项目：【{}】操作redis失败******************************************",applicationName);
			e.printStackTrace();
		}
	}
	
	/** 
	 * dictionary2redis:. <br/> 
	 * 
	 * @author po.lu 
	 * @since JDK 1.8 
	 * @see
	 */
	private void dictionary2redis() {
		
		log.info("***************************数据字典加载redis****************************开始***");
		dictService.selectListAll().parallelStream().forEach(d->{
			redisTemplate.opsForValue().set(d.getDictKey(), d.getDictValue().toString(), 12, TimeUnit.HOURS);
		});
		log.info("***************************数据字典加载redis****************************成功***");
	}

}
  