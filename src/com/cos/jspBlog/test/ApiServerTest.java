package com.cos.jspBlog.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// localhost:8080/jspBlog/test (GET, POST)
@WebServlet("/test")
public class ApiServerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApiServerTest() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); //get으로 올때 post로 받는법
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String mime = request.getContentType();
//		// html을 주는거면 웹브라우저가 어차피 html을 읽을 수 있어서 상관 없는데
//		// json으로 주는거면 mime type을 적어줘야한다.
//		System.out.println(mime);
//		request.setCharacterEncoding("UTF-8");
//		if(mime.equals("application/json")) {
//			BufferedReader br = request.getReader();
//			String input;
//			StringBuffer buffer = new StringBuffer();
//			while((input = br.readLine()) != null) {
//				buffer.append(input); // input에다가 계속 채울 수 있게
//			}
//			System.out.println(buffer.toString());
//		}else {
//			
//			String food = request.getParameter("food");
//			String method = request.getParameter("method");
//			System.out.println(food);
//			System.out.println(method);
//		}
		
		
		// DB에 insert 하고 끝
		
		int result = 1; // 정상
		//response.sendRedirect("index.jsp");
		
		
//		out.println(1);
//		out.flush();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8"); // 저장하고 response.getWriter()를 실행해야 값이 저장됨
		PrintWriter out  = response.getWriter();
		//response.sendRedirect("index.jsp"); //파일이라서 바로 인식하는 것으로 보임
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>안녕</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
	
	/*
	 * 요청할 때는 content type이 중요하지 않음
	 * api 약속을 정하면 되니깐
	 * 근데 응답할 때는 웹 브라우저가 받기 때문에
	 * 어떻게 해석해야할지 알려줘야함
	 * 파일을 응답하는 경우는 괜찮음
	 * */

}

/*
 * 음식레시피를 응답해주는 서버 
 * 
 * 음식레시피를 저장 (POST)
 * (GET)은 찾는거
 * 
 * 요청 주소
 * localhost:8080/jspBlog/test
 * 
 * 요청메서드
 * POST
 * 
 * 요청데이터
 * 키 food
 * 값 (마음대로)
 * 키 method
 * 값 (음식레시피)
 * 
 * 요청데이터의 Content-Type : x-www-from-urlencoded
 * 
 * 응답데이터
 * text/html; charset=utf-8
 * application/json
 * 응답결과 DB에 insert된 레코드
 * (food, method)
 * {"error" : "fail"}
 * {"food" : , "method" : }
 * 
 * text/plain (평문)
 * 응답결과 1 정상
 * 				2 실패
 * */