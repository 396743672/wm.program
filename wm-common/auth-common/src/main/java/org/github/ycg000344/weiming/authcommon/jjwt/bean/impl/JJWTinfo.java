/** 
 * Project Name:auth-common 
 * File Name:JJWTinfo.java 
 * Package Name:org.github.ycg000344.weiming.authcommon.jjwt.bean.impl 
 * Date:2018年5月11日下午5:01:49 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authcommon.jjwt.bean.impl;

import org.github.ycg000344.weiming.authcommon.jjwt.bean.IJWTinfo;

/** 
 * ClassName:JJWTinfo <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月11日 下午5:01:49 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see IJWTinfo       
 */
public class JJWTinfo implements IJWTinfo {
	
	private String id;
	private String uniqueName;
	private String name;

    public JJWTinfo(String uniqueName,String id,  String name) {
        this.uniqueName = uniqueName;
        this.id = id;
        this.name = name;
    }

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getUniqueName() {
		return uniqueName;
	}

	@Override
	public String getName() {
		return name;
	}

}
  