package com.web.chat.mapper;

import java.util.List;

import com.web.chat.vo.UserInfoVO;

public interface UserInfoMapper {
	public UserInfoVO selectUserForLogin(UserInfoVO user);
	public List<UserInfoVO> checkId(String uiId);
	public int insertUser(UserInfoVO user);
	public int updateScore(UserInfoVO user);
}
