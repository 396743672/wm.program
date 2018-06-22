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

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;

/** 
 * ClassName:UserInfo <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月22日 下午3:42:56 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Getter
@Setter
public class UserInfoVO implements Serializable {

	/** 
	 * serialVersionUID
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = 7374853084371966676L;

	private BaseUserInfo baseUserInfo;
	
	private String role_ids;
	
	private String roles;
	
	private String router_ids;
	
	public List<String> getRoles() {
		return StrUtil.split(this.roles, StrUtil.C_COMMA);
	}
	
	public List<String> getRouterIds(){
		return StrUtil.split(router_ids, StrUtil.C_COMMA);
	}
	
	
}
  