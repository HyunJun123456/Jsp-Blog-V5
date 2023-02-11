package com.cos.jspBlog.domain.user.dto;

import lombok.Data;

@Data
public class JoinReqDto { // user와 board를 join 했을 때 받는 것이 DTO(Data Transfer Object)
	private String username;
	private String password;
	private String email;
	private String address;
	
}
