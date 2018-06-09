/** 
 * Project Name:dict-manager 
 * File Name:DictManagerService.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.service 
 * Date:2018年6月3日下午2:54:27 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.dictmanager.service;

import java.util.concurrent.TimeUnit;

import org.github.ycg000344.weiming.application.dictmanager.entity.Dict;
import org.github.ycg000344.weiming.application.dictmanager.entity.DictItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

/**
 * ClassName:DictManagerService <br/>
 * <br/>
 * Description: 数据字典管理业务 <br/>
 * <br/>
 * Date: 2018年6月3日 下午2:54:27 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Service
@Slf4j
public class DictManagerService {

	@Autowired
	private DictService dictService;
	@Autowired
	private DictItemService dictItemService;
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Value("${weiming.dictmanager.redis.keeped}")
	private Integer keeped;
	
	/**
	 * dictionaryItem2Redis:数据字典项目加载进入内存. <br/>
	 * 有效时间为12小时
	 * 
	 * @author po.lu
	 * @since JDK 1.8
	 * @see
	 */
	public void dictionaryItem2Redis() {
		log.info("***************************数据字典项目加载redis****************************开始***");
		Example example = new Example(DictItem.class);
		example.createCriteria().andEqualTo("status", 1);
		example.setOrderByClause("update_time");
		dictItemService.selectByExample(example).parallelStream().forEach(d -> {
			redisTemplate.opsForValue().set(d.getDictItemKey(), JSONObject.toJSONString(d), keeped, TimeUnit.HOURS);
		});
		log.info("***************************数据字典项目加载redis****************************成功***");
	}

	/**
	 * dictionary2redis: 数据字典加载进redis. <br/>
	 * 有效时间为12小时
	 * 
	 * @author po.lu
	 * @since JDK 1.8
	 * @see
	 */
	public void dictionary2redis() {
		log.info("***************************数据字典加载redis****************************开始***");
		Example example = new Example(Dict.class);
		example.createCriteria().andEqualTo("status", 1);
		example.setOrderByClause("update_time");
		dictService.selectByExample(example).parallelStream().forEach(d -> {
			redisTemplate.opsForValue().set(d.getDictKey(), JSONObject.toJSONString(d), keeped, TimeUnit.HOURS);
		});
		log.info("***************************数据字典加载redis****************************成功***");
	}

}
