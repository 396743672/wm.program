/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/3 11:19:03                            */
/*==============================================================*/


drop index Index_dict_id on t_base_dict;

drop table if exists t_base_dict;

drop index Index_dict_item_id on t_base_dict_item;

drop table if exists t_base_dict_item;

/*==============================================================*/
/* Table: t_base_dict                                           */
/*==============================================================*/
create table t_base_dict
(
   dict_id              int not null auto_increment comment '�ֵ�ID',
   dict_item_id         int comment '�ֵ���ĿID�����',
   dict_key             varchar(50) comment '�ֵ���',
   dict_value           int comment '�ֵ�ֵ',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '0�����ã�1������',
   primary key (dict_id)
)
auto_increment = 1;

alter table t_base_dict comment '�����ֵ��';

/*==============================================================*/
/* Index: Index_dict_id                                         */
/*==============================================================*/
create index Index_dict_id on t_base_dict
(
   dict_id
);

/*==============================================================*/
/* Table: t_base_dict_item                                      */
/*==============================================================*/
create table t_base_dict_item
(
   dict_item_id         int not null auto_increment comment '�ֵ���ĿID',
   dict_item_key        varchar(50) comment '�ֵ���Ŀ��',
   dict_item_value      int comment '�ֵ���Ŀֵ',
   create_time          datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����ʱ��',
   status               int default 1 comment '״̬,0:���ã�1������',
   primary key (dict_item_id)
)
auto_increment = 1;

alter table t_base_dict_item comment '�����ֵ���Ŀ��';

/*==============================================================*/
/* Index: Index_dict_item_id                                    */
/*==============================================================*/
create index Index_dict_item_id on t_base_dict_item
(
   dict_item_id
);

alter table t_base_dict add constraint FK_Reference_1 foreign key (dict_item_id)
      references t_base_dict_item (dict_item_id) on delete restrict on update restrict;

