/** 
 * Project Name:wm-common 
 * File Name:CommonConstants.java 
 * Package Name:org.github.ycg000344.weiming.common.constants 
 * Date:2018年5月6日下午6:03:55 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.common.base.constants;  
/** 
 * ClassName:CommonConstants <br/><br/>  
 * Description: 公用常量类 <br/><br/>  
 * Date:     2018年5月6日 下午6:03:55 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class CommonConstants {

    public static final Integer EX_OTHER_CODE = 50000;
    
    
    
    
    /** jjwt */
    /** 
     * JWT_KEY_ID:TODO . 
     * @since JDK 1.8 
     */  
    public static final String JWT_KEY_ID = "id";
    /** 
     * JWT_KEY_NAME:TODO . 
     * @since JDK 1.8 
     */  
    public static final String JWT_KEY_NAME = "name";
    
    /** 
     * JWT_KEY_UNIQUENAME:TODO . 
     * @since JDK 1.8 
     */  
    public static final String JWT_KEY_UNIQUENAME = "uniqueName";
    
    /** 鉴权服务 */
    /** 
     * AUTH_SERVER_NAME:鉴权服务应用名称</br>
     * <p>spring.application.name.</p> 
     * @since JDK 1.8 
     */  
    public static final String AUTH_SERVER_NAME = "wm-app-authserver";
    
    /** 
     * AUTH_USER_TOKEN: user token header. 
     * @since JDK 1.8 
     */  
    public static final String AUTH_USER_TOKEN = "X-USER-AUTHORIZATION";
}
  