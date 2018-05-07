/** 
 * Project Name:business-base 
 * File Name:BaseResponse.java 
 * Package Name:org.github.ycg000344.weiming.businessbase.vo 
 * Date:2018年5月6日下午5:16:43 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.common.vo;

import org.springframework.http.HttpStatus;

/** 
 * ClassName:BaseResponse <br/><br/>  
 * Description: 自定义自定义基础response对象 <br/><br/>  
 * Date:     2018年5月6日 下午5:16:43 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class BaseResponse {
	
    private Integer status = HttpStatus.OK.value();
    private String message = HttpStatus.OK.getReasonPhrase();

    public BaseResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
  