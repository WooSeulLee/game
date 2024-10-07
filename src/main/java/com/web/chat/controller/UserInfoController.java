package com.web.chat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam String uiId) {
	    List<UserInfoVO> users = uiService.checkId(uiId); // 아이디로 사용자 검색
	    if (!users.isEmpty()) {
	        return "아이디가 이미 존재합니다.";
	    } else {
	        return "사용 가능한 아이디입니다.";
	    }
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
