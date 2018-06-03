/** 
 * Project Name:dict-api 
 * File Name:DictionaryObject.java 
 * Package Name:org.github.ycg000344.dictapi.bean 
 * Date:2018年6月3日下午2:46:18 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.dictapi.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/** 
 * ClassName:DictionaryObject <br/><br/>  
 * Description: 数据字典VO <br/><br/>  
 * Date:     2018年6月3日 下午2:46:18 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Getter
@Setter
public class DictionaryObject implements Serializable {
	
    /** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private static final long serialVersionUID = -6157015173324684354L;
	private Integer dictItemId;
    private String dictItemKey;
    private Integer dictItemValue;
    private Date dictItemCreateTime;
    private Date dictItemUpdateTime;
    private Integer dictItemStatus;

    private Integer dictId;
    private String dictKey;
    private Integer dictValue;
    private Date dictCreateTime;
    private Date dictUpdateTime;
    private Integer dictStatus;
    

}
  