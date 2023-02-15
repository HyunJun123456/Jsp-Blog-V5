package com.cos.jspBlog.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.jspBlog.domain.user.dto.JoinReqDto;
import com.cos.jspBlog.domain.user.dto.LoginReqDto;
import com.cos.jspBlog.service.UserService;

// http://localhost:8080/jspBlog/user
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// http://localhost:8080/jspBlog/user?cmd=머시기
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		UserService userService = new UserService();
		// http://localhost:8080/jspBlog/user?cmd=loginForm
		if(cmd.equals("loginForm")) {
			// 아이디 기억 (나중에 추가)
			response.sendRedirect("user/loginForm.jsp");
		}else if(cmd.equals("login")) {
			// 서비스 호출
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			LoginReqDto dto = new LoginReqDto();
			dto.setUsername(username);
			dto.setPassword(password);
			// 가공은 컨트롤러에서 해서 가져오면 됨
			userService.login(dto);
		}else if(cmd.equals("joinForm")) {
			response.sendRedirect("user/joinForm.jsp");
		}else if(cmd.equals("join")) {
			// 서비스 호출
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			JoinReqDto dto = new JoinReqDto();
			dto.setUsername(username);
			dto.setPassword(password);
			dto.setEmail(email);
			dto.setAddress(address);
			System.out.println("회원가입: "+dto);
			int result = userService.join(dto);
			if(result == 1) {
				response.sendRedirect("index.jsp");
			}else {
				// Script.back();
			}
		}
		
	}
	
	
}
/*
 * Web - 컨트롤러
 * service - 서비스
 * Repository - 저장소
 * 
 * 사용자 -> (요청) -> 컨트롤러
 * 응답을 HTML(정적으로)으로 바로 줄 수 있음
 * 데이터가 필요하면 Service로 간다
 * Service는 Repository에게 요청함
 * DAO(Data Access Object): DB가 달라붙어 있음
 * 네트워크면 통신과 관련 (다른 웹서버 컨트롤러에 요청하는 경우)
 * 예시) 공공데이터
 * 웹에서는 return을 HTML로 앱은 JSON으로 보통 사용
*/
