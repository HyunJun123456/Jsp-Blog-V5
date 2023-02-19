package com.cos.jspBlog.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	// context가 한 번 실행 될 때
	public static Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB"); // 오라클: jdbc/myoracle
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			//System.out.println("DB연결 실패: "+e.getMessage());
			e.printStackTrace();
		} 
		return null;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close(); // 즉각적으로 연결 제거해줌
		} catch (Exception e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
	}
	// 오버로딩
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close(); // 즉각적으로 연결 제거해줌
			rs.close();
		} catch (Exception e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
	}
	
}
