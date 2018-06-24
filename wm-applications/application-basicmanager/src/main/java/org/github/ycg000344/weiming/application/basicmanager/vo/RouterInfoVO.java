/** 
 * Project Name:application-basicmanager 
 * File Name:RouetrInfoVO.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.vo 
 * Date:2018年6月24日下午1:48:45 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.basicmanager.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;

import cn.hutool.core.convert.Converter;
import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * ClassName:RouetrInfoVO <br/>
 * <br/>
 * Description: 路由信息VO <br/>
 * <br/>
 * Date: 2018年6月24日 下午1:48:45 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Data
public class RouterInfoVO implements Serializable,Converter<RouterInfoVO> {

	/** 
	 * serialVersionUID:.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private static final long serialVersionUID = -1199230323660711153L;

	/**
	 * path: 路由请求路径.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */
	private String path;

	/**
	 * component:父路由使用Layout布局.子路由指定具体的组件
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */
	private String component;

	/**
	 * name:路由名称.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */
	private String name;

	private Meta meta;

	private List<RouterInfoVO> children;

	@Override
	public RouterInfoVO convert(Object value, RouterInfoVO defaultValue) throws IllegalArgumentException {
		RouterInfoVO infoVO = new RouterInfoVO();
		BeanUtils.copyProperties(value, infoVO);
		Meta meta = new Meta();
		BeanUtils.copyProperties(value, meta);
		infoVO.setMeta(meta);
		return infoVO;
	}
}


/** 
 * ClassName: Meta <br/> 
 * Description: meta <br/><br/>  
 * Date: 2018年6月24日 下午5:30:03 <br/><br/>  
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */  
@Data
class Meta implements Serializable{
	/** 
	 * serialVersionUID:.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private static final long serialVersionUID = 8749813149644205740L;
	private String title;
	private String icon;
	private String roles;
	private Integer noCache;

	public List<String> getRoles() {
		return StrUtil.split(this.roles, StrUtil.C_COMMA);
	}

	public Boolean getNoCache() {
		return this.noCache == 1 ? true : false;
	}
}
