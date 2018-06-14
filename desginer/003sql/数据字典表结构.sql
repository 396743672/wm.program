/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/14 20:12:27                           */
/*==============================================================*/


drop index Index_dict_id on t_base_dict;

drop table if exists t_base_dict;

/*==============================================================*/
/* Table: t_base_dict                                           */
/*==============================================================*/
create table t_base_dict
(
   dict_id              int not null auto_increment comment '�ֵ�ID',
   dict_key             varchar(50) comment '�ֵ���',
   dict_value           varchar(50) comment '�ֵ�ֵ',
   dict_category_id     int comment '�ֵ����id,ȡ��dict_id�ֶ�',
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

