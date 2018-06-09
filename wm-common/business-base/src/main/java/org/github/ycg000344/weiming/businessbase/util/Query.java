/** 
 * Project Name:business-base 
 * File Name:Query.java 
 * Package Name:org.github.ycg000344.weiming.businessbase.util 
 * Date:2018年5月6日下午4:52:06 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.businessbase.util;

import java.util.LinkedHashMap;
import java.util.Map;

/** 
 * ClassName:Query <br/><br/>  
 * Description: 查询参数 <br/><br/>  
 * Date:     2018年5月6日 下午4:52:06 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public class Query extends LinkedHashMap<String, Object> {

	/** 
	 * serialVersionUID:TODO
	 * @since JDK 1.8 
	 */  
	private static final long serialVersionUID = -6827965245996758850L;

	/**当前页码 offset*/ 
    private int page = 1;
    /**每页条数*/
    private int limit = 10;
    
    private String pageStr = "page";
    private String limitStr = "limit";

    public Query(Map<String, Object> params){
        this.putAll(params);
        /*分页参数*/
        if(params.get(pageStr)!=null) {
        	this.page = Integer.parseInt(params.get(pageStr).toString());
        }
            
        if(params.get(limitStr)!=null) {
        	this.limit = Integer.parseInt(params.get(limitStr).toString());
        }
            
        this.remove(pageStr);
        this.remove(limitStr);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
  