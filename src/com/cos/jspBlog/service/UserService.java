package com.cos.jspBlog.service;

import com.cos.jspBlog.domain.user.User;
import com.cos.jspBlog.domain.user.dto.JoinReqDto;
import com.cos.jspBlog.domain.user.dto.LoginReqDto;
import com.cos.jspBlog.domain.user.dto.UpdateReqDto;

public class UserService {
	// 회원가입, 회원수정, 로그인, 로그아웃, 아이디 중복 체크
	
	public int join(JoinReqDto dto) {
		
		return -1; // update, insert니 실패했는지 성공했는지 int 값을 받으면 됨
	}
	
	// select * from user where username=? and password=?
	public User login(LoginReqDto dto) {// 조인해서 같이 들고 온 값은 user에서 사용을 못함 (board도 사용하는 경우)
		// 로그인하고 세션을 만들꺼니깐 select해서 행을 리턴하게 됨
		
		return null;
	}
	
	public int update(UpdateReqDto dto) {
		
		return -1; // 행의 개수를 리턴받음
	}
	
	//public void logout() {} // 서비스단까지 request를 처리하는게 아님
		
	public int duplicateCheck(String username) {
		
		return -1;
	}
	
}
