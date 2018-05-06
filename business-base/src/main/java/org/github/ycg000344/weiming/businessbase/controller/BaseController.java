/** 
 * Project Name:business-base 
 * File Name:BaseController.java 
 * Package Name:org.github.ycg000344.weiming.businessbase.controller 
 * Date:2018年5月6日下午5:22:37 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.businessbase.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.github.ycg000344.weiming.businessbase.biz.BaseBiz;
import org.github.ycg000344.weiming.businessbase.util.Query;
import org.github.ycg000344.weiming.businessbase.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.businessbase.vo.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:BaseController <br/>
 * <br/>
 * Description: 基础控制类，提供基本的CRUD的URL,以及分页查询功能 <br/>
 * <br/>
 * Date: 2018年5月6日 下午5:22:37 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseController<Biz extends BaseBiz, Entity> {

	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected Biz baseBiz;

	@PostMapping("")
	public ObjectRestResponse<Entity> add(@RequestBody Entity entity) {
		baseBiz.insertSelective(entity);
		return new ObjectRestResponse<Entity>();
	}

	@GetMapping("/{id}")
	public ObjectRestResponse<Entity> get(@PathVariable int id) {
		return new ObjectRestResponse<Entity>().rel(true).data(baseBiz.selectById(id));
	}

	@PutMapping("/{id}")
	public ObjectRestResponse<Entity> update(@RequestBody Entity entity) {
		baseBiz.updateSelectiveById(entity);
		return new ObjectRestResponse<Entity>();
	}

	@DeleteMapping("/{id}")
	public ObjectRestResponse<Entity> remove(@PathVariable int id) {
		baseBiz.deleteById(id);
		return new ObjectRestResponse<Entity>();
	}

	@GetMapping("/all")
	public List<Entity> all() {
		return baseBiz.selectListAll();
	}

	@GetMapping("/page")
	public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		return baseBiz.selectByQuery(query);
	}

}
