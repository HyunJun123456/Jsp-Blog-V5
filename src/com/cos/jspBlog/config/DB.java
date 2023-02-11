package com.cos.jspBlog.config;

import java.sql.Connection;
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
	
	
}
