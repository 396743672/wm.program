-- 创建用户
insert into t_base_user(login_name,user_name) values('admin','管理员');

-- 创建登录密码
insert into t_base_login(login_name,password) values('admin','931bd0e1cc9baae10e9ff6ca7002e834');

-- 创建角色
insert into t_base_role(role_name) values('add');
insert into t_base_role(role_name) values('del');
insert into t_base_role(role_name) values('update');
insert into t_base_role(role_name) values('get');

-- 创建用户角色
insert into t_base_user_roles(user_id,roles_ids) values(600000,'600000,600001,600002,600003');

-- 提交
commit;