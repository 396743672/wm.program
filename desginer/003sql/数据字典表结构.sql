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
   dict_id              int not null auto_increment comment '字典ID',
   dict_key             varchar(50) comment '字典名',
   dict_value           varchar(50) comment '字典值',
   dict_category_id     int comment '字典类别id,取自dict_id字段',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '0：禁用，1：可用',
   primary key (dict_id)
)
auto_increment = 1;

alter table t_base_dict comment '数据字典表';

/*==============================================================*/
/* Index: Index_dict_id                                         */
/*==============================================================*/
create index Index_dict_id on t_base_dict
(
   dict_id
);

