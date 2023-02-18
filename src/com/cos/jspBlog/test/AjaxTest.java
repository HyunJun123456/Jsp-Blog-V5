package com.cos.jspBlog.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// localhost:8080/jspBlog/test (GET, POST)
@WebServlet("/ajax")
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxTest() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); //get으로 올때 post로 받는법
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax 호출됨");
		// 데이터 응답
		PrintWriter out = response.getWriter();
		out.println("ok");
		out.flush();
	}
	
}
