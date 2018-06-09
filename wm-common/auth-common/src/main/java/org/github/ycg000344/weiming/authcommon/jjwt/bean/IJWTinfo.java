/** 
 * Project Name:auth-common 
 * File Name:IJWTinfo.java 
 * Package Name:org.github.ycg000344.weiming.authcommon.jjwt.bean 
 * Date:2018年5月11日下午4:58:53 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authcommon.jjwt.bean;  
/** 
 * ClassName:IJWTinfo <br/><br/>  
 * Description: 获取封装信息的jjwt <br/><br/>  
 * Date:     2018年5月11日 下午4:58:53 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public interface IJWTinfo {

	/**
	 * 
	 * getId:获取标识ID. <br/> 
	 * 
	 * @author po.lu
	 * @return 
	 * @since JDK 1.8 
	 * @see
	 */
	 String getId();
	 
	 /**
	  * 
	  * getUniqueName:获取标识名称. <br/> 
	  * 
	  * @author po.lu
	  * @return 
	  * @since JDK 1.8 
	  * @see
	  */
	 String getUniqueName();
	 
	 /**
	  * 
	  * getName:获取名称. <br/> 
	  * 
	  * @author po.lu
	  * @return 
	  * @since JDK 1.8 
	  * @see
	  */
	 String getName();
}
  