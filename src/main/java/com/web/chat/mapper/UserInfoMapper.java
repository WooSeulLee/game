package com.web.chat.mapper;

import com.web.chat.vo.UserInfoVO;

public interface UserInfoMapper {
	public UserInfoVO selectUserForLogin(UserInfoVO user);
	public int insertUser(UserInfoVO user);
	public int updateScore(UserInfoVO user);
}
