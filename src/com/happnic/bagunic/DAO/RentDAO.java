package com.happnic.bagunic.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.happnic.bagunic.VO.RentVO;
import com.happnic.bagunic.VO.UserVO;

public class RentDAO {
	
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	UserVO vo = null;
	int cnt = 0;
	
	public void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "happynic";
			String dbpw = "1213";
			con = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//대여!
	public int rent(String basket_id, String email) {

		connection();

		try {
			String sql = "insert into rental(basket_ren_number,basket_id,rental_s_time,user_email) values(RENT_SEQ.nextval,?, sysdate,?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, basket_id);
			psmt.setString(2, email);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;	
	}
	
	public ArrayList<RentVO> reservation_info(String email) {
	      
		RentVO vo = null;
	      ArrayList<RentVO> user_info = new ArrayList<RentVO>();
	      connection();
	      String sql = " select m.member_name, r.basket_ren_number, r.basket_id, "
	            + " r.rental_hours, to_char(r.rental_date,'YYYY/MM/DD'), r.rental_area "
	            + " from member m , rental r "
	            + " where m.member_email = ? and m.member_email = r.user_email ";
	      
	      try {
	         psmt = con.prepareStatement(sql);
	         psmt.setString(1,email);
	         rs = psmt.executeQuery();
	         
	         while(rs.next()) {
	            String name = rs.getString(1);
	            String bas_ren_num = rs.getString(2);
	            String bas_id = rs.getString(3);
	            String ren_hours = rs.getString(4);
	            String ren_date = rs.getString(5);
	            String ren_area = rs.getString(6);
	            vo = new RentVO(name, bas_ren_num, bas_id, ren_hours, ren_date,ren_area);
	            user_info.add(vo);            
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return user_info;
	}
}
