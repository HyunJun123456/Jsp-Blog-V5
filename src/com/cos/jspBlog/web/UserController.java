package com.cos.jspBlog.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.jspBlog.domain.user.User;
import com.cos.jspBlog.domain.user.dto.JoinReqDto;
import com.cos.jspBlog.domain.user.dto.LoginReqDto;
import com.cos.jspBlog.service.UserService;
import com.cos.jspBlog.util.Script;

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
			User userEntity = userService.login(dto);
			if(userEntity != null) {
				HttpSession session = request.getSession();
				session.setAttribute("principal", userEntity); // 인증주체
				response.sendRedirect("index.jsp");
			}else {
				Script.back(response, "로그인실패");
			}
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
				 Script.back(response, "회원가입 실패");
			}
		}else if(cmd.equals("usernameCheck")) {
			// request.getParameter("username"); 이걸로 못 읽음
			BufferedReader br = request.getReader();
			String username = br.readLine();
			System.out.println(username);
			int result = userService.duplicateCheck(username);
			PrintWriter out = response.getWriter();
			if(result == 1) {
				out.print("ok"); // ln붙이면 안됨
			}else {
				out.print("fail");
			}
			out.flush();
		}else if(cmd.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
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
 * 
 * 정의
 * Asynchronous JacaScript and XML
 * 자바스크립트를 통해서 서버에 데이터를 요청하고 json을 응답받는다.
 * 응답을 화면에 그리는 놈!!
 * 응답에 대해서 먼가 분기나 프로그래밍은 못함
 * 기본적인 웹
 * 1. 요청 -> 응답(html) -> 브라우저는 그림 그리기
 * (AJAX)
 * 2. 요청 -> 응답(data) -> data에 따라서 어떻게 그려질지 프로그래밍을 하고 싶을 때
 * 
 * JavaScript XML 객체 (기본) - 원형
 * JQuery 라이브러리 - Ajax 함수
 * fetch() 함수
 * axios() 함수 (라이브러리)
 * 
 * 
 * 
 * 
 * 
*/
