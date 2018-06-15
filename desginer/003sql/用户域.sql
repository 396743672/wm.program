/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/15 14:52:24                           */
/*==============================================================*/


drop table if exists t_base_login;

drop table if exists t_base_user;

/*==============================================================*/
/* Table: t_base_login                                          */
/*==============================================================*/
create table t_base_login
(
   login_id             int comment '登录id，取自用户信息表的user_id',
   login_name           varchar(60) comment '登录名称，取自用户信息表的login_name',
   password             varchar(60) comment '登录密码',
   create_date          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_date          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '是否可用'
);

alter table t_base_login comment '登录表';

/*==============================================================*/
/* Table: t_base_user                                           */
/*==============================================================*/
create table t_base_user
(
   user_id              int not null auto_increment comment '用户id',
   login_name           varchar(60) not null comment '登录名',
   user_name            varchar(60) comment '用户名',
   create_date          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '是否可用',
   primary key (user_id, login_name)
)
auto_increment = 600000;

alter table t_base_user comment '用户信息表';

alter table t_base_login add constraint FK_Reference_1 foreign key (login_id, login_name)
      references t_base_user (user_id, login_name) on delete restrict on update restrict;

