/** 
 * Project Name:dict-manager 
 * File Name:DictManagerService.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.service 
 * Date:2018年6月3日下午2:54:27 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.dictmanager.service;

import java.util.concurrent.TimeUnit;

import org.github.ycg000344.dictapi.bean.DictionaryObject;
import org.github.ycg000344.weiming.dictmanager.entity.Dict;
import org.github.ycg000344.weiming.dictmanager.entity.DictItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.util.StrUtil;
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

	private String status = "status";
	private String inUsed = "1";
	private String orderBy = "update_time";
	private Integer keeped = 12;
	
	/**
	 * getDictItem: 获取数据字典项目. <br/>
	 * 1. 查redis 
	 * 2. 查库
	 * @author po.lu
	 * @param dObject
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	public DictionaryObject getDictItem(DictionaryObject dObject) {
		DictItem dictItem = null;
		if (StrUtil.isNotEmpty(dObject.getDictItemKey())) {
			String string = redisTemplate.opsForValue().get(dObject.getDictItemKey());
			if (StrUtil.isNotEmpty(string)) {
				dictItem = JSONObject.parseObject(string, DictItem.class);
			}
		}
		if (null == dictItem) {
			dictItem = dictItemService.selectById(dObject.getDictItemId());
		}
		return object2DictionaryObject(dictItem);
	}

	/** 
	 * object2DictionaryObject:对象属性转化. <br/> 
	 * 
	 * @author po.lu
	 * @param objiect
	 * @return 
	 * @since JDK 1.8 
	 * @see
	 */  
	private DictionaryObject object2DictionaryObject(Object objiect) {
		DictionaryObject dObject = new DictionaryObject();
		if (null != objiect) {
			if (objiect instanceof DictItem) {
				DictItem d = (DictItem) objiect;
				dObject.setDictItemId(d.getDictItemId());
				dObject.setDictItemCreateTime(d.getCreateTime());
				dObject.setDictItemKey(d.getDictItemKey());
				dObject.setDictItemStatus(d.getStatus());
				dObject.setDictItemUpdateTime(d.getUpdateTime());
				dObject.setDictItemValue(d.getDictItemValue());
			}
			if (objiect instanceof Dict) {
				Dict d = (Dict) objiect;
				dObject.setDictId(d.getDictId());
				dObject.setDictItemId(d.getDictItemId());
				dObject.setDictCreateTime(d.getCreateTime());
				dObject.setDictKey(d.getDictKey());
				dObject.setDictStatus(d.getStatus());
				dObject.setDictUpdateTime(d.getUpdateTime());
				dObject.setDictValue(d.getDictValue());
			}
		}
		return dObject;
	}

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
		example.selectProperties(status, inUsed);
		example.setOrderByClause(orderBy);
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
		example.selectProperties(status, inUsed);
		example.setOrderByClause(orderBy);
		dictService.selectByExample(example).parallelStream().forEach(d -> {
			redisTemplate.opsForValue().set(d.getDictKey(), JSONObject.toJSONString(d), keeped, TimeUnit.HOURS);
		});
		log.info("***************************数据字典加载redis****************************成功***");
	}

}
