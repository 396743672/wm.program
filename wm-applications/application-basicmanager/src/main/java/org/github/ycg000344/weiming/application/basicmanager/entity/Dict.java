package org.github.ycg000344.weiming.application.basicmanager.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_base_dict")
public class Dict {
    @Id
    @Column(name = "dict_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "myql")
    private Integer dictId;

    @Column(name = "dict_item_id")
    private Integer dictItemId;

    @Column(name = "dict_key")
    private String dictKey;

    @Column(name = "dict_value")
    private Integer dictValue;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 0
     */
    private Integer status;

    /**
     * @return dict_id
     */
    public Integer getDictId() {
        return dictId;
    }

    /**
     * @param dictId
     */
    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

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
     * @return dict_key
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * @param dictKey
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * @return dict_value
     */
    public Integer getDictValue() {
        return dictValue;
    }

    /**
     * @param dictValue
     */
    public void setDictValue(Integer dictValue) {
        this.dictValue = dictValue;
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
     * ªÒ»°0
     *
     * @return status - 0
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * …Ë÷√0
     *
     * @param status 0
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}