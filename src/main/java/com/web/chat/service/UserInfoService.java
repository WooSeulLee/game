package com.web.chat.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.chat.mapper.UserInfoMapper;
import com.web.chat.vo.UserInfoVO;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoMapper uiMapper;
	public UserInfoVO selectUserForLogin(UserInfoVO user,HttpSession session ) {
		UserInfoVO loginUser = uiMapper.selectUserForLogin(user);
		//세션에 저장을 해야함 이건 서비스에서 해줘야함.
		if(loginUser!= null) {
			session.setAttribute("user", loginUser);
		}
		return loginUser;
	}
	public int insertUser(UserInfoVO user) {
		return uiMapper.insertUser(user);
	}
	public int updateScore(UserInfoVO user) {
		return uiMapper.updateScore(user);
	}
}
