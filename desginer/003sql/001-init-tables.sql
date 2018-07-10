/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/23 16:43:56                           */
/*==============================================================*/


drop table if exists t_base_dict;

drop table if exists t_base_login;

drop table if exists t_base_role;

drop table if exists t_base_router;

drop table if exists t_base_user;

drop table if exists t_base_user_roles;

drop table if exists t_base_user_routers;

/*==============================================================*/
/* Table: t_base_dict                                           */
/*==============================================================*/
create table t_base_dict
(
   dict_id              int not null auto_increment comment '�ֵ�ID',
   dict_key             varchar(60) comment '�ֵ���',
   dict_value           varchar(60) comment '�ֵ�ֵ',
   dict_category_id     int comment '�ֵ����id,ȡ��dict_id�ֶ�',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '0�����ã�1������',
   primary key (dict_id)
)
auto_increment = 1;

alter table t_base_dict comment '�����ֵ��';

/*==============================================================*/
/* Table: t_base_login                                          */
/*==============================================================*/
create table t_base_login
(
   login_id             int comment '��¼id��ȡ���û���Ϣ���user_id',
   login_name           varchar(60) comment '��¼��',
   password             varchar(60) comment '��¼����',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '�Ƿ����',
   unique key AK_Key_1 (login_name)
);

alter table t_base_login comment '��¼��';

/*==============================================================*/
/* Table: t_base_role                                           */
/*==============================================================*/
create table t_base_role
(
   role_id              int not null auto_increment comment '��ɫid����������600000',
   role_name            varchar(60) comment '��ɫ����',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '״̬',
   primary key (role_id)
)
auto_increment = 600000;

alter table t_base_role comment '��ɫ��';

/*==============================================================*/
/* Table: t_base_router                                         */
/*==============================================================*/
create table t_base_router
(
   router_id            int not null auto_increment comment '·��id����������',
   path                 varchar(60) comment '·������·��',
   component            varchar(60) default 'Layout' comment 'ʹ��Layout����',
   redirect             varchar(60) comment '������ noredirect ��ʱ���·�ɲ��������м�����г���',
   name                 varchar(60) comment '·������',
   hidden               int default 0 comment '������ true ��ʱ���·�ɲ����ٲ�������� ��401��login��ҳ��(Ĭ�� false)',
   always_show          int default 0 comment '������ true ��ʱ����Զ����ʾ���˵��������õ������ֻ�е���·�ɸ�������һ��ʱ�Ż���ʾ���˵�',
   title                varchar(60) comment '���ø�·���ڲ���������м��չʾ������',
   icon                 varchar(60) comment '���ø�·�ɵ�ͼ��',
   roles                varchar(60) comment '��ɫ����',
   no_cache             int default 0 comment '�������Ϊtrue ,�򲻻ᱻ <keep-alive> ����(Ĭ�� false)',
   router_parent_id     int comment '��·��id',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '����״̬',
   primary key (router_id)
);

alter table t_base_router comment '�˵�·�ɱ�';

/*==============================================================*/
/* Table: t_base_user                                           */
/*==============================================================*/
create table t_base_user
(
   user_id              int not null auto_increment comment '�û�id',
   login_name           varchar(60) comment '��¼��',
   user_name            varchar(60) comment '�û���',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '�Ƿ����',
   primary key (user_id),
   unique key AK_Key_2 (login_name)
)
auto_increment = 600000;

alter table t_base_user comment '�û���Ϣ��';

/*==============================================================*/
/* Table: t_base_user_roles                                     */
/*==============================================================*/
create table t_base_user_roles
(
   user_id              int comment '�û�id',
   role_ids             varchar(60) comment '��ɫids��ʹ��,�ָ�',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '״̬'
);

alter table t_base_user_roles comment '�û���ɫ��';

/*==============================================================*/
/* Table: t_base_user_routers                                   */
/*==============================================================*/
create table t_base_user_routers
(
   user_id              int comment '�û�id',
   router_parent_id     int comment '��·��id',
   router_ids           varchar(60) comment '·��ids,ʹ�ã��ָ�',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '״̬'
);

alter table t_base_user_routers comment '�û��˵�·�ɱ�';

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
   menu                 varchar(60) comment '�˵�����',
   opt                  varchar(60) comment '����',
   uri                  varchar(60) comment '������Դ',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   create_user          varchar(60) comment 'user_id',
   create_name          varchar(60) comment 'user_name',
   create_host          varchar(60) comment 'host',
   primary key (log_id)
);

alter table t_base_log comment '������־��';


