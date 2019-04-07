/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/23 16:43:56                           */
/*==============================================================*/


drop table if exists t_base_dict;

drop table if exists t_base_login;

drop table if exists t_base_role;

drop table if exists t_base_router;

drop table if exists t_base_user_roles;

drop table if exists t_base_user_routers;

drop table if exists t_base_user;


/*==============================================================*/
/* Table: t_base_dict                                           */
/*==============================================================*/
create table t_base_dict
(
   dict_id              int not null auto_increment comment '字典ID',
   dict_key             varchar(60) comment '字典名',
   dict_value           varchar(60) comment '字典值',
   dict_category_id     int comment '字典类别id,取自dict_id字段',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '0：禁用，1：可用',
   primary key (dict_id)
)
auto_increment = 1;

alter table t_base_dict comment '数据字典表';

/*==============================================================*/
/* Table: t_base_login                                          */
/*==============================================================*/
create table t_base_login
(
   login_id             int comment '登录id，取自用户信息表的user_id',
   login_name           varchar(60) comment '登录名',
   password             varchar(60) comment '登录密码',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '是否可用',
   unique key AK_Key_1 (login_name)
);

alter table t_base_login comment '登录表';

/*==============================================================*/
/* Table: t_base_role                                           */
/*==============================================================*/
create table t_base_role
(
   role_id              int not null auto_increment comment '角色id，自增，从600000',
   role_name            varchar(60) comment '角色名称',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '状态',
   primary key (role_id)
)
auto_increment = 600000;

alter table t_base_role comment '角色表';

/*==============================================================*/
/* Table: t_base_router                                         */
/*==============================================================*/
create table t_base_router
(
   router_id            int not null auto_increment comment '路由id，自增主键',
   path                 varchar(60) comment '路由请求路径',
   component            varchar(60) default 'Layout' comment '使用Layout布局',
   redirect             varchar(60) comment '当设置 noredirect 的时候该路由不会在面包屑导航中出现',
   name                 varchar(60) comment '路由名称',
   hidden               int default 0 comment '当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面(默认 false)',
   always_show          int default 0 comment '当设置 true 的时候永远会显示根菜单，不设置的情况下只有当子路由个数大于一个时才会显示根菜单',
   title                varchar(60) comment '设置该路由在侧边栏和面包屑中展示的名字',
   icon                 varchar(60) comment '设置该路由的图标',
   roles                varchar(60) comment '角色数组',
   no_cache             int default 0 comment '如果设置为true ,则不会被 <keep-alive> 缓存(默认 false)',
   router_parent_id     int comment '父路由id',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '可用状态',
   primary key (router_id)
);

alter table t_base_router comment '菜单路由表';

/*==============================================================*/
/* Table: t_base_user                                           */
/*==============================================================*/
create table t_base_user
(
   user_id              int not null auto_increment comment '用户id',
   login_name           varchar(60) comment '登录名',
   user_name            varchar(60) comment '用户名',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '是否可用',
   primary key (user_id),
   unique key AK_Key_2 (login_name)
)
auto_increment = 600000;

alter table t_base_user comment '用户信息表';

/*==============================================================*/
/* Table: t_base_user_roles                                     */
/*==============================================================*/
create table t_base_user_roles
(
   user_id              int comment '用户id',
   role_ids             varchar(60) comment '角色ids，使用,分割',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '状态'
);

alter table t_base_user_roles comment '用户角色表';

/*==============================================================*/
/* Table: t_base_user_routers                                   */
/*==============================================================*/
create table t_base_user_routers
(
   user_id              int comment '用户id',
   router_parent_id     int comment '父路由id',
   router_ids           varchar(60) comment '路由ids,使用，分割',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '状态'
);

alter table t_base_user_routers comment '用户菜单路由表';

alter table t_base_login add constraint FK_Reference_1 foreign key (login_id)
      references t_base_user (user_id) on delete restrict on update restrict;

alter table t_base_user_roles add constraint FK_Reference_3 foreign key (user_id)
      references t_base_user (user_id) on delete restrict on update restrict;

alter table t_base_user_routers add constraint FK_Reference_2 foreign key (user_id)
      references t_base_user (user_id) on delete restrict on update restrict;




/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/10 14:45:41                           */
/*==============================================================*/


drop table if exists t_base_log;

/*==============================================================*/
/* Table: t_base_log                                            */
/*==============================================================*/
create table t_base_log
(
   log_id               int not null auto_increment comment 'id',
   menu                 varchar(60) comment '菜单名称',
   opt                  varchar(60) comment '操作',
   uri                  varchar(60) comment '请求资源',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   create_user          varchar(60) comment 'user_id',
   create_name          varchar(60) comment 'user_name',
   create_host          varchar(60) comment 'host',
   primary key (log_id)
);

alter table t_base_log comment '操作日志表';


