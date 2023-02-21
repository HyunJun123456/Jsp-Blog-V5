package com.cos.jspBlog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.jspBlog.config.DB;
import com.cos.jspBlog.domain.user.dto.JoinReqDto;
import com.cos.jspBlog.domain.user.dto.LoginReqDto;

public class UserDao {
	public int save(JoinReqDto dto) { // 회원가입
		String sql = "INSERT INTO user(username, password, email, address, userRole, createDate) VALUES(?, ?, ?, ?, 'USER', now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getAddress());
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //  무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public void update() { // 회원수정
		
	}
	
	public void usernameCheck() { // 아이디 중복 체크
		
	}
	
	public void findById() { // 회원정보보기
		
	}

	public int findByUsername(String username) {
		String sql = "SELECT username FROM USER WHERE username = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);			
			rs = pstmt.executeQuery(); // update나 insert와 다름
			// int result = pstmt.executeUpdate(); 
			if(rs.next()) {
				return 1; // 있어
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //  무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return -1; // 없어
	}

	public User findByUsernameAndPassword(LoginReqDto dto) {
		String sql = "SELECT id, username, email, address FROM USER WHERE username = ? AND password=?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername());			
			pstmt.setString(2, dto.getPassword());			
			rs = pstmt.executeQuery(); // update나 insert와 다름
			
			// Persistence API가 대신해줌
			if(rs.next()) {
				User user = User.builder()
									.id(rs.getInt("id"))
									.username(rs.getString("username"))
									.email(rs.getString("email"))
									.address(rs.getString("address"))
									.build();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //  무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	
}
