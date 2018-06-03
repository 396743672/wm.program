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
	 * serialVersionUID.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private static final long serialVersionUID = -6157015173324684354L;
	
	/** 
	 * dictItemId: 字典项目id.
	 * 
	 * @author po.lu
	 * @version 1.0.0
	 * @since JDK 1.8
	 */  
	private Integer dictItemId;
    /** 
     * dictItemKey: 字典项目key.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private String dictItemKey;
    /** 
     * dictItemValue: 字典项目value.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Integer dictItemValue;
    /** 
     * dictItemCreateTime: 字典项目创建时间.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Date dictItemCreateTime;
    /** 
     * dictItemUpdateTime: 字典项目更新时间.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Date dictItemUpdateTime;
    /** 
     * dictStatus: 字典项目状态.
     * 0：禁用；1：可用
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Integer dictItemStatus;
    /** 
     * dictId: 字典id.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Integer dictId;
    /** 
     * dictKey: 字典key.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private String dictKey;
    /** 
     * dictValue: 字典value.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Integer dictValue;
    /** 
     * dictCreateTime: 字典创建时间.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Date dictCreateTime;
    /** 
     * dictUpdateTime: 字典更新时间.
     * 
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Date dictUpdateTime;
    /** 
     * dictStatus: 字典状态.
     * 0：禁用；1：可用
     * @author po.lu
     * @version 1.0.0
     * @since JDK 1.8
     */  
    private Integer dictStatus;
    

}
  