/** 
 * Project Name:business-base 
 * File Name:ObjectRestResponse.java 
 * Package Name:org.github.ycg000344.weiming.businessbase.vo 
 * Date:2018年5月6日下午5:37:33 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.businessbase.vo;

import org.github.ycg000344.weiming.common.vo.BaseResponse;

/** 
 * ClassName:ObjectRestResponse <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月6日 下午5:37:33 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@SuppressWarnings("rawtypes")
public class ObjectRestResponse<T> extends BaseResponse {

	T data;
    boolean rel;

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }


    
	public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
  