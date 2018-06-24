package org.github.ycg000344.weiming.application.basicmanager.mapper;

import java.util.Optional;

import org.github.ycg000344.weiming.application.basicmanager.entity.BaseUserInfo;
import org.github.ycg000344.weiming.application.basicmanager.vo.UserInfoVO;

import tk.mybatis.mapper.common.Mapper;

public interface BaseUserInfoMapper extends Mapper<BaseUserInfo> {

	/** 
	 * selectUserInfoVOByUserId:根据用户id查询出用户信息以及关联的角色ids和路由ids. <br/> 
	 * 
	 * @author po.lu
	 * @param userId
	 * @return 
	 * @since JDK 1.8 
	 * @see
	 */  
	Optional<UserInfoVO>  getUserInfoVOByUserId(String userId);
}