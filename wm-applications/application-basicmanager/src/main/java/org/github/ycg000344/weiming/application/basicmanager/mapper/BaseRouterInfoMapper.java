package org.github.ycg000344.weiming.application.basicmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.github.ycg000344.weiming.application.basicmanager.entity.BaseRouterInfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * ClassName: BaseRouterInfoMapper <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年6月24日 下午3:06:38 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */
public interface BaseRouterInfoMapper extends Mapper<BaseRouterInfo> {


	/** 
	 * getRouterInfoByIds: 根据router_ids和router_id查询子路由集合. <br/> 
	 * 
	 * @author po.lu
	 * @param routerParnetId
	 * @param routerIds
	 * @return 
	 * @since JDK 1.8 
	 * @see
	 */  
	List<BaseRouterInfo> getRouterInfoByIds(@Param("routerParnetId") String routerParnetId, @Param("routerIds") String routerIds);
}