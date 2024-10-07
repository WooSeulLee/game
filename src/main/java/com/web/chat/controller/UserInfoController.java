package com.web.chat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.chat.service.UserInfoService;
import com.web.chat.vo.UserInfoVO;

@RestController
public class UserInfoController {
	
	@Autowired
	private UserInfoService uiService;
	

	@PostMapping("/login")
	public UserInfoVO selectUserForLogin(@RequestBody UserInfoVO user,HttpSession session) {
		return uiService.selectUserForLogin(user,session);
	} 
	
	@PutMapping("/user")
	public int updateScore(UserInfoVO user){
		return uiService.updateScore(user);
	}
	
	@PostMapping("/user")
	public int insertUser(UserInfoVO user){
		return uiService.insertUser(user);
	}
	
}
