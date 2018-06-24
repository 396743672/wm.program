/** 
 * Project Name:application-basicmanager 
 * File Name:UserInfo.java 
 * Package Name:org.github.ycg000344.weiming.application.basicmanager.vo 
 * Date:2018年6月22日下午3:42:56 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.vo;

import java.io.Serializable;
import java.util.List;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserInfo;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** 
 * ClassName:UserInfo <br/><br/>  
 * Description: 用户角色路由信息VO <br/><br/>  
 * Date:     2018年6月22日 下午3:42:56 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Getter
@Setter
@ToString
public class UserInfoVO implements Serializable {

	/** 
	 * serialVersionUID
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = 7374853084371966676L;

	/** 
	 * baseUserInfo:用户基本信息.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private BaseUserInfo baseUserInfo;
	
	/** 
	 * roleIds:角色ids.
	 * 600000,600001,600002,600003
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private String roleIds;
	
	/** 
	 * roles:角色名称.
	 * add,del,update,get
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private String roles;
	
	/** 
	 * routerIds:路由ids.
	 * 父:子,子&父:子,子...
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private String routerIds;
	
	
	/** 
	 * asyncRouterMap:用户路由集合.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private List<RouterInfoVO> asyncRouterMap;
	
	public List<String> getRoles() {
		return StrUtil.split(this.roles, StrUtil.C_COMMA);
	}
	
	public List<String> getRouterIds(){
		return StrUtil.split(routerIds, CharUtil.AMP);
	}
	
	
}
  