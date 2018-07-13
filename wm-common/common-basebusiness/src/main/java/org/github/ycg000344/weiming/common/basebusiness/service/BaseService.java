/** 
 * Project Name:business-base 
 * File Name:BaseBiz.java 
 * Package Name:org.github.ycg000344.weiming.businessbase.biz 
 * Date:2018年5月6日下午4:48:02 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.common.basebusiness.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.common.basebusiness.util.Query;
import org.github.ycg000344.weiming.common.basebusiness.vo.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * ClassName:BaseBiz <br/>
 * <br/>
 * Description: 基础业务类，提供基本的CRUD,以及分页查询功能 <br/>
 * <br/>
 * Date: 2018年5月6日 下午4:48:02 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Slf4j
public abstract class BaseService<M extends Mapper<T>, T> {

	@Autowired
	protected M mapper;

	public void setMapper(M mapper) {
		this.mapper = mapper;
	}

	public Optional<T> selectOne(T entity) {
		return Optional.ofNullable(mapper.selectOne(entity));
	}

	public Optional<T> selectById(Object id) {
		return Optional.ofNullable(mapper.selectByPrimaryKey(id));
	}

	@SuppressWarnings("unchecked")
	public ObjectRestResponse<List<T>> selectList(T entity) {
		return new ObjectRestResponse<List<T>>().rel(true).data(mapper.select(entity));
	}

	@SuppressWarnings("unchecked")
	public ObjectRestResponse<List<T>> selectListAll(@RequestParam Map<String, Object> params) {
		return new ObjectRestResponse<List<T>>().rel(true).data(mapper.selectAll());
	}

	public Long selectCount(T entity) {
		return new Long(mapper.selectCount(entity));
	}

	public void insert(T entity) {
		mapper.insert(entity);
	}

	public void insertSelective(T entity) {
		mapper.insertSelective(entity);
	}

	public void delete(T entity) {
		mapper.delete(entity);
	}

	public void deleteById(Object id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void updateById(T entity) {
		mapper.updateByPrimaryKey(entity);
	}

	public void updateSelectiveById(T entity) {
		mapper.updateByPrimaryKeySelective(entity);

	}

	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	public int selectCountByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	@SuppressWarnings("unchecked")
	public TableResultResponse<T> selectByQuery(Query query) {
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		Example example = new Example(clazz);
		if (StrUtil.isNotEmpty(query.getOrder()) && StrUtil.isNotEmpty(query.getProp())) {
			log.debug("***weiming专用日志打印语句：***进行排序：字段：【{}】，方式：【{}】***", query.getProp(), query.getOrder());
			example.setOrderByClause(query.getOrderByClause());
		}
		Example.Criteria criteria = example.createCriteria();
		for (Map.Entry<String, Object> entry : query.entrySet()) {
			criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
		}
		Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
		List<T> list = mapper.selectByExample(example);
		return new TableResultResponse<T>(result.getTotal(), list);
	}

}
