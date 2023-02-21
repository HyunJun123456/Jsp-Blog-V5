package com.cos.jspBlog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

// 자바스크립트에서는 import의 개념이 없고 window 객체가 다 들고 있음
public class Script {
	public static void back(HttpServletResponse response, String msg) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("history.back();"); // window가 들고 있는 객체
			out.println("</script>");
			out.flush(); // 버퍼 비우기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
