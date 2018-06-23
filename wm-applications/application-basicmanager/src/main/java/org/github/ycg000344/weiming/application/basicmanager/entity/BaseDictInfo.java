package org.github.ycg000344.weiming.application.basicmanager.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_base_dict")
public class BaseDictInfo {
    /**
     * 字典ID
     */
    @Id
    @Column(name = "dict_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dictId;

    /**
     * 字典名
     */
    @Column(name = "dict_key")
    private String dictKey;

    /**
     * 字典值
     */
    @Column(name = "dict_value")
    private String dictValue;

    /**
     * 字典类别id,取自dict_id字段
     */
    @Column(name = "dict_category_id")
    private Integer dictCategoryId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 0：禁用，1：可用
     */
    private Integer status;

    /**
     * 获取字典ID
     *
     * @return dict_id - 字典ID
     */
    public Integer getDictId() {
        return dictId;
    }

    /**
     * 设置字典ID
     *
     * @param dictId 字典ID
     */
    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取字典名
     *
     * @return dict_key - 字典名
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * 设置字典名
     *
     * @param dictKey 字典名
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * 获取字典值
     *
     * @return dict_value - 字典值
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置字典值
     *
     * @param dictValue 字典值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取字典类别id,取自dict_id字段
     *
     * @return dict_category_id - 字典类别id,取自dict_id字段
     */
    public Integer getDictCategoryId() {
        return dictCategoryId;
    }

    /**
     * 设置字典类别id,取自dict_id字段
     *
     * @param dictCategoryId 字典类别id,取自dict_id字段
     */
    public void setDictCategoryId(Integer dictCategoryId) {
        this.dictCategoryId = dictCategoryId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取0：禁用，1：可用
     *
     * @return status - 0：禁用，1：可用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0：禁用，1：可用
     *
     * @param status 0：禁用，1：可用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}