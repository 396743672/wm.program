package org.github.ycg000344.weiming.application.basicmanager.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_base_login")
public class BaseLoginInfo {
    /**
     * 登录id，取自用户信息表的user_id
     */
    @Column(name = "login_id")
    private Integer loginId;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

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
     * 是否可用
     */
    private Integer status;

    /**
     * 获取登录id，取自用户信息表的user_id
     *
     * @return login_id - 登录id，取自用户信息表的user_id
     */
    public Integer getLoginId() {
        return loginId;
    }

    /**
     * 设置登录id，取自用户信息表的user_id
     *
     * @param loginId 登录id，取自用户信息表的user_id
     */
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 获取是否可用
     *
     * @return status - 是否可用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否可用
     *
     * @param status 是否可用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}