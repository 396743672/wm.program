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
   login_id             int comment '��¼id��ȡ���û���Ϣ���user_id',
   login_name           varchar(60) comment '��¼���ƣ�ȡ���û���Ϣ���login_name',
   password             varchar(60) comment '��¼����',
   create_date          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_date          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '�Ƿ����'
);

alter table t_base_login comment '��¼��';

/*==============================================================*/
/* Table: t_base_user                                           */
/*==============================================================*/
create table t_base_user
(
   user_id              int not null auto_increment comment '�û�id',
   login_name           varchar(60) not null comment '��¼��',
   user_name            varchar(60) comment '�û���',
   create_date          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '�Ƿ����',
   primary key (user_id, login_name)
)
auto_increment = 600000;

alter table t_base_user comment '�û���Ϣ��';

alter table t_base_login add constraint FK_Reference_1 foreign key (login_id, login_name)
      references t_base_user (user_id, login_name) on delete restrict on update restrict;

