package org.github.ycg000344.weiming.application.basicmanager.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.ToString;

@Table(name = "t_base_log")
@ToString
public class BaseLog {
    /**
     * id
     */
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    /**
     * 菜单名称
     */
    private String menu;

    /**
     * 操作
     */
    private String opt;

    /**
     * 请求资源
     */
    private String uri;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * user_id
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * user_name
     */
    @Column(name = "create_name")
    private String createName;

    /**
     * host
     */
    @Column(name = "create_host")
    private String createHost;

    /**
     * 获取id
     *
     * @return log_id - id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置id
     *
     * @param logId id
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 获取菜单名称
     *
     * @return menu - 菜单名称
     */
    public String getMenu() {
        return menu;
    }

    /**
     * 设置菜单名称
     *
     * @param menu 菜单名称
     */
    public void setMenu(String menu) {
        this.menu = menu;
    }

    /**
     * 获取操作
     *
     * @return opt - 操作
     */
    public String getOpt() {
        return opt;
    }

    /**
     * 设置操作
     *
     * @param opt 操作
     */
    public void setOpt(String opt) {
        this.opt = opt;
    }

    /**
     * 获取请求资源
     *
     * @return uri - 请求资源
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置请求资源
     *
     * @param uri 请求资源
     */
    public void setUri(String uri) {
        this.uri = uri;
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
     * 获取user_id
     *
     * @return create_user - user_id
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置user_id
     *
     * @param createUser user_id
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取user_name
     *
     * @return create_name - user_name
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置user_name
     *
     * @param createName user_name
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * 获取host
     *
     * @return create_host - host
     */
    public String getCreateHost() {
        return createHost;
    }

    /**
     * 设置host
     *
     * @param createHost host
     */
    public void setCreateHost(String createHost) {
        this.createHost = createHost;
    }
}