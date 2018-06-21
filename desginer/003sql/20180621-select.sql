SELECT
	t1.*,t2.role_ids,t3.router_ids ,
	(SELECT GROUP_CONCAT(t4.role_name) FROM t_base_role t4 WHERE EXISTS (SELECT t5.role_ids from t_base_user_roles t5 WHERE t5.user_id = 600000 )) as roles
FROM
	t_base_user t1
	LEFT JOIN t_base_user_roles t2 ON t1.user_id = t2.user_id 
	AND t2.`status` = 1
	LEFT JOIN t_base_user_routers t3 ON t1.user_id = t3.user_id 
	AND t3.`status` = 1
	WHERE t1.user_id = 600000;