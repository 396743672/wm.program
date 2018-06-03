/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/3 11:19:03                            */
/*==============================================================*/


/*drop index Index_dict_id on t_base_dict;*/

drop table if exists t_base_dict;

/*drop index Index_dict_item_id on t_base_dict_item;*/

drop table if exists t_base_dict_item;

/*==============================================================*/
/* Table: t_base_dict                                           */
/*==============================================================*/
create table t_base_dict
(
   dict_id              int not null auto_increment comment '字典ID',
   dict_item_id         int comment '字典项目ID，外键',
   dict_key             varchar(50) comment '字典名',
   dict_value           int comment '字典值',
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

/*==============================================================*/
/* Table: t_base_dict_item                                      */
/*==============================================================*/
create table t_base_dict_item
(
   dict_item_id         int not null auto_increment comment '字典项目ID',
   dict_item_key        varchar(50) comment '字典项目键',
   dict_item_value      int comment '字典项目值',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   status               int default 1 comment '状态,0:禁用，1：可用',
   primary key (dict_item_id)
)
auto_increment = 1;

alter table t_base_dict_item comment '数据字典项目表';

/*==============================================================*/
/* Index: Index_dict_item_id                                    */
/*==============================================================*/
create index Index_dict_item_id on t_base_dict_item
(
   dict_item_id
);

alter table t_base_dict add constraint FK_Reference_1 foreign key (dict_item_id)
      references t_base_dict_item (dict_item_id) on delete restrict on update restrict;

