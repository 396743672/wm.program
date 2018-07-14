/** 
 * Project Name:application-basicmanager 
 * File Name:BaseRouterInfoService.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.service 
 * Date:2018年6月21日下午9:19:01 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRouterInfo;
import org.github.ycg000344.weiming.application.basicmanager.mapper.BaseRouterInfoMapper;
import org.github.ycg000344.weiming.application.basicmanager.vo.RouterInfoVO;
import org.github.ycg000344.weiming.common.base.constants.CommonConstants;
import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.common.basebusiness.service.BaseService;
import org.github.ycg000344.weiming.common.basebusiness.util.Query;
import org.github.ycg000344.weiming.common.basebusiness.vo.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

/**
 * ClassName:BaseRouterInfoService <br/>
 * <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年6月21日 下午9:19:01 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Service
@Transactional
@Slf4j
public class BaseRouterInfoService extends BaseService<BaseRouterInfoMapper, BaseRouterInfo> {

	@Autowired
	private BaseRouterInfoMapper routerInfoMapper;

	/**
	 * getRouterInfoVOByRouterIds: 查询用户的菜单路由集合. <br/>
	 * 
	 * @author po.lu
	 * @param routerIds
	 *            父:子,子
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	public List<RouterInfoVO> getRouterInfoVOByRouterIds(List<String> routerIds) {
		log.debug("***weiming专用log***查询用户的菜单路由集合【{}】***start***", routerIds);
		List<RouterInfoVO> emptyList = new ArrayList<>();
		routerIds.parallelStream().forEachOrdered(r -> {
			getRouter(r, emptyList);
		});
		log.debug("***weiming专用log***查询用户的菜单路由集合【{}】***success***", routerIds);
		return emptyList;
	}

	/**
	 * getRouter:从DB中获取路由对象. <br/>
	 * 
	 * @author po.lu
	 * @param ids
	 * @param emptyList
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	private List<RouterInfoVO> getRouter(String ids, List<RouterInfoVO> emptyList) {
		log.debug("***weiming***专用log***从DB中获取路由对象：【{}】***start***", ids);
		String[] strings = StrUtil.split(ids, StrUtil.COLON);
		/** 父级路由DB对象 */
		Optional<BaseRouterInfo> optional = this.selectById(strings[0]);
		if (optional.isPresent()) {
			BaseRouterInfo baseRouterInfo = optional.get();
			/** 父路由VO */
			RouterInfoVO routerInfoVO = this.routerDB2VO(baseRouterInfo);
			/** 子路由VO */
			List<RouterInfoVO> infoVOs = new ArrayList<>();
			/** 子路由DB对象集合 转化为DB对象 */
			routerInfoMapper.getRouterInfoByIds(baseRouterInfo.getRouterId().toString(), strings[1]).parallelStream()
					.forEach(r -> infoVOs.add(routerDB2VO(r)));
			/** 设置完整的VO对象 */
			routerInfoVO.setChildren(infoVOs);
			emptyList.add(routerInfoVO);
		}
		log.debug("***weiming***专用log***从DB中获取路由对象：【{}】***success***", ids);
		return emptyList;
	}

	/**
	 * routerDB2VO:将路由对象进行转化为VO. <br/>
	 * 
	 * @author po.lu
	 * @param baseRouterInfo
	 * @param infoByIds
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	private RouterInfoVO routerDB2VO(BaseRouterInfo baseRouterInfo) {
		log.debug("***weiming专用log***将路由对象进行转化为VO：【{}】***start***", baseRouterInfo.toString());
		ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
		converterRegistry.putCustom(RouterInfoVO.class, RouterInfoVO.class);
		RouterInfoVO convert = converterRegistry.convert(RouterInfoVO.class, baseRouterInfo);
		log.debug("***weiming专用log***将路由对象进行转化为VO：【{}】***success***", convert.toString());
		return convert;
	}

	/**
	 * getParentRouters: 查询全部一级路由，默认按照更新时间、创建时间降序 <br/>
	 * 
	 * @author po.lu
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	@SuppressWarnings("unchecked")
	public ObjectRestResponse<List<BaseRouterInfo>> parents() {
		log.debug("***weiming专用log***查询全部一级菜单路由集合【{}】***start***");
		List<BaseRouterInfo> list = routerInfoMapper.getParentRouters(CommonConstants.ROUTER_PARENT_ID_DEFAULT);
		log.debug("***weiming专用log***查询全部一级菜单路由集合【{}】***success***");
		return new ObjectRestResponse<List<BaseRouterInfo>>().rel(true).data(list);
	}

	/**
	 * children: 根据一级路由id分页查询二级路由. <br/>
	 * 
	 * @author po.lu
	 * @param query
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	public TableResultResponse<BaseRouterInfo> children(Query query) {
		Example example = new Example(BaseRouterInfo.class);
		if (StrUtil.isNotEmpty(query.getOrder()) && StrUtil.isNotEmpty(query.getProp())) {
			log.debug("***weiming专用日志打印语句：***进行排序：字段：【{}】，方式：【{}】***", query.getProp(), query.getOrder());
			example.setOrderByClause(query.getOrderByClause());
		}
		Example.Criteria criteria = example.createCriteria();
		for (Map.Entry<String, Object> entry : query.entrySet()) {
			criteria.andEqualTo(entry.getKey(), entry.getValue().toString());
		}
		Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
		List<BaseRouterInfo> list = mapper.selectByExample(example);
		return new TableResultResponse<BaseRouterInfo>(result.getTotal(), list);
	}

}
