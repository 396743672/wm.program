CREATE VIEW `v_user_roles_routers` AS SELECT
	t3.user_id AS user_id,
	t3.login_name AS login_name,
	t3.user_name AS user_name,
	t3.create_time AS create_time,
	t3.update_time AS update_time,
	t3.status AS status,
	IFNULL(t4.role_ids,'') AS role_ids,
	IFNULL((SELECT group_concat( t1.role_name SEPARATOR ',' ) FROM t_base_role t1 WHERE FIND_IN_SET(t1.role_id,t4.role_ids)),'') AS roles, -- 将角色名称使用,进行连接
	IFNULL(t3.router_ids,'') AS router_ids
FROM
	(
	(
	(
SELECT
	t1.user_id AS user_id,
	t1.login_name AS login_name,
	t1.user_name AS user_name,
	t1.create_time AS create_time,
	t1.update_time AS update_time,
	t1.status AS status,
	group_concat( concat( t2.router_parent_id, ':', t2.router_ids ) SEPARATOR '&' ) AS router_ids -- 子路由之间使用，相连，将父路由id与子路由id使用连接，将多个父子配套的路由使用&连接
FROM
	(
	t_base_user t1
	LEFT JOIN t_base_user_routers t2 ON ( ( ( t1.user_id = t2.user_id ) AND ( t2.status = 1 ) ) )
	)
GROUP BY
	t1.user_id
	)
	) t3
	LEFT JOIN t_base_user_roles t4 ON ( ( ( t3.user_id = t4.user_id ) AND ( t4.status = 1 ) ) )
	)