package org.github.ycg000344.weiming.dictmanager.entity;

import java.util.Date;
import javax.persistence.*;

/** 
 * ClassName: DictItem <br/> 
 * Description: 数据字典项目类 <br/><br/>  
 * Date: 2018年6月3日 下午2:41:36 <br/><br/>  
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */  
@Table(name = "t_base_dict_item")
public class DictItem {
    @Id
    @Column(name = "dict_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "myql")
    private Integer dictItemId;

    @Column(name = "dict_item_key")
    private String dictItemKey;

    @Column(name = "dict_item_value")
    private Integer dictItemValue;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * ??,0:
     */
    private Integer status;

    /**
     * @return dict_item_id
     */
    public Integer getDictItemId() {
        return dictItemId;
    }

    /**
     * @param dictItemId
     */
    public void setDictItemId(Integer dictItemId) {
        this.dictItemId = dictItemId;
    }

    /**
     * @return dict_item_key
     */
    public String getDictItemKey() {
        return dictItemKey;
    }

    /**
     * @param dictItemKey
     */
    public void setDictItemKey(String dictItemKey) {
        this.dictItemKey = dictItemKey;
    }

    /**
     * @return dict_item_value
     */
    public Integer getDictItemValue() {
        return dictItemValue;
    }

    /**
     * @param dictItemValue
     */
    public void setDictItemValue(Integer dictItemValue) {
        this.dictItemValue = dictItemValue;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * ��ȡ??,0:
     *
     * @return status - ??,0:
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * ����??,0:
     *
     * @param status ??,0:
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}