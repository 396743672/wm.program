package org.github.ycg000344.weiming.application.basicmanager.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.ToString;

@Table(name = "t_base_router")
@ToString
public class BaseRouterInfo {
    /**
     * 路由id，自增主键
     */
    @Id
    @Column(name = "router_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routerId;

    /**
     * 路由请求路径
     */
    private String path;

    /**
     * 使用Layout布局
     */
    private String component;

    /**
     * 当设置 noredirect 的时候该路由不会在面包屑导航中出现
     */
    private String redirect;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面(默认 false)
     */
    private Integer hidden;

    /**
     * 当设置 true 的时候永远会显示根菜单，不设置的情况下只有当子路由个数大于一个时才会显示根菜单
     */
    @Column(name = "always_show")
    private Integer alwaysShow;

    /**
     * 设置该路由在侧边栏和面包屑中展示的名字
     */
    private String title;

    /**
     * 设置该路由的图标
     */
    private String icon;

    /**
     * 角色数组
     */
    private String roles;

    /**
     * 如果设置为true ,则不会被 <keep-alive> 缓存(默认 false)
     */
    @Column(name = "no_cache")
    private Integer noCache;

    /**
     * 父路由id
     */
    @Column(name = "router_parent_id")
    private Integer routerParentId;

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
     * 可用状态
     */
    private Integer status;

    /**
     * 获取路由id，自增主键
     *
     * @return router_id - 路由id，自增主键
     */
    public Integer getRouterId() {
        return routerId;
    }

    /**
     * 设置路由id，自增主键
     *
     * @param routerId 路由id，自增主键
     */
    public void setRouterId(Integer routerId) {
        this.routerId = routerId;
    }

    /**
     * 获取路由请求路径
     *
     * @return path - 路由请求路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置路由请求路径
     *
     * @param path 路由请求路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取使用Layout布局
     *
     * @return component - 使用Layout布局
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置使用Layout布局
     *
     * @param component 使用Layout布局
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取当设置 noredirect 的时候该路由不会在面包屑导航中出现
     *
     * @return redirect - 当设置 noredirect 的时候该路由不会在面包屑导航中出现
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * 设置当设置 noredirect 的时候该路由不会在面包屑导航中出现
     *
     * @param redirect 当设置 noredirect 的时候该路由不会在面包屑导航中出现
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    /**
     * 获取路由名称
     *
     * @return name - 路由名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置路由名称
     *
     * @param name 路由名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面(默认 false)
     *
     * @return hidden - 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面(默认 false)
     */
    public Integer getHidden() {
        return hidden;
    }

    /**
     * 设置当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面(默认 false)
     *
     * @param hidden 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面(默认 false)
     */
    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    /**
     * 获取当设置 true 的时候永远会显示根菜单，不设置的情况下只有当子路由个数大于一个时才会显示根菜单
     *
     * @return always_show - 当设置 true 的时候永远会显示根菜单，不设置的情况下只有当子路由个数大于一个时才会显示根菜单
     */
    public Integer getAlwaysShow() {
        return alwaysShow;
    }

    /**
     * 设置当设置 true 的时候永远会显示根菜单，不设置的情况下只有当子路由个数大于一个时才会显示根菜单
     *
     * @param alwaysShow 当设置 true 的时候永远会显示根菜单，不设置的情况下只有当子路由个数大于一个时才会显示根菜单
     */
    public void setAlwaysShow(Integer alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    /**
     * 获取设置该路由在侧边栏和面包屑中展示的名字
     *
     * @return title - 设置该路由在侧边栏和面包屑中展示的名字
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置设置该路由在侧边栏和面包屑中展示的名字
     *
     * @param title 设置该路由在侧边栏和面包屑中展示的名字
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取设置该路由的图标
     *
     * @return icon - 设置该路由的图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置设置该路由的图标
     *
     * @param icon 设置该路由的图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取角色数组
     *
     * @return roles - 角色数组
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置角色数组
     *
     * @param roles 角色数组
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * 获取如果设置为true ,则不会被 <keep-alive> 缓存(默认 false)
     *
     * @return no_cache - 如果设置为true ,则不会被 <keep-alive> 缓存(默认 false)
     */
    public Integer getNoCache() {
        return noCache;
    }

    /**
     * 设置如果设置为true ,则不会被 <keep-alive> 缓存(默认 false)
     *
     * @param noCache 如果设置为true ,则不会被 <keep-alive> 缓存(默认 false)
     */
    public void setNoCache(Integer noCache) {
        this.noCache = noCache;
    }

    /**
     * 获取父路由id
     *
     * @return router_parent_id - 父路由id
     */
    public Integer getRouterParentId() {
        return routerParentId;
    }

    /**
     * 设置父路由id
     *
     * @param routerParentId 父路由id
     */
    public void setRouterParentId(Integer routerParentId) {
        this.routerParentId = routerParentId;
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
     * 获取可用状态
     *
     * @return status - 可用状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置可用状态
     *
     * @param status 可用状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}