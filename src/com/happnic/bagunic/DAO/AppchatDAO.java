package com.happnic.bagunic.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.happnic.bagunic.VO.AppChatVO;

public class AppchatDAO {
	
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "happynic";
			String dbpw = "1213";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public int ChatInput(String email, String content) {

		int cnt = 0;

		connect();
		
		try {
			String sql = "insert into appchat VALUES(?,?,sysdate)";
			psmt = conn.prepareStatement(sql);
			psmt.setNString(1, email);
			psmt.setNString(2, content);
	

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public ArrayList<AppChatVO> chatList() {
		
		ArrayList<AppChatVO> list = new ArrayList<AppChatVO>();
		connect();
		
		try {
			String sql = "select * from appchat";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString(1);
				String content = rs.getString(2);
				String day = rs.getString(3);

				list.add(new AppChatVO(email, content, day));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

}
