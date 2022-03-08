package com.happnic.bagunic.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.happnic.bagunic.Controller.MyAuthentication;
import com.happnic.bagunic.VO.UserVO;

//사용자의 계정 생성/삭제 및 조회
public class UserDAO {
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	UserVO vo = null;
	int cnt = 0;

	// 데이터베이스 연결
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

	// 사용했던 변수 close
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

	// 일반 회원 가입
	public int join(String email, String pw, String name, String phone) {

		connection();

		try {
			String sql = "insert into MEMBER values(?,?,?,?,sysdate)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, phone);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 이메일 중복 체크: 사용 가능 true, 사용 불가 false
	public boolean emailCheck(String email) {

		boolean check = false;
		connection();

		try {
			String sql = "select * from MEMBER where MEMBER_EMAIL = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			if (rs.next()) {// �˻��� �̸����� �ִ� ��� ����� �Ұ��� = false
				check = false;
			} else {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}

	// 일반 회원 로그인
	public UserVO Login(String email, String pw) {

		connection();

		try {
			String sql = "select * from MEMBER where MEMBER_EMAIL = ? and MEMBER_PW = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				String user_email = rs.getString(1);
				String user_pw = rs.getString(2);
				String user_name = rs.getString(3);
				String user_phone = rs.getString(4);
				String user_joindate = rs.getString(5);

				vo = new UserVO(user_email, user_pw, user_name, user_phone, user_joindate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 인코드 이메일로 발송
	public String[] findPw(String name, String email) {
		connection();
		String ran_number = "";
		String user_email = "";
		String user_pw = "";
		String[] arr = new String[2];

		String sql = "select * from member where MEMBER_EMAIL = ? and MEMBER_NAME = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, name);

			rs = psmt.executeQuery();
			if (rs.next()) {
				user_email = rs.getString(1);
				user_pw = rs.getString(3);

				int ran = (int) (Math.random() * (99999 - 10000 + 1)) + 10000;
				ran_number = String.valueOf(ran);

				arr[0] = ran_number;
				arr[1] = user_pw;
				Properties p = System.getProperties();
				p.put("mail.smtp.starttls.enable", "true");  // gmail은 true 고정
				p.put("mail.smtp.host", "smtp.gmail.com"); // smtp 서버 주소
				p.put("mail.smtp.auth", "true"); // gmail은 true 고정
				p.put("mail.smtp.port", "465");  // 네이버 포트
				p.put("mail.smtp.port", "587");  // 네이버 포트
				p.put("mail.smtp.ssl.protocols", "TLSv1.2");
				Authenticator auth = new MyAuthentication();
				// session 생성 및 MimeMessage생성
				Session session = Session.getDefaultInstance(p, auth);
				MimeMessage msg = new MimeMessage(session);

				try {
					// ���������ð�
					msg.setSentDate(new Date());
					InternetAddress from = new InternetAddress();
					from = new InternetAddress("bagunic21@gmail.com"); // 발신자 아이디
					// 이메일 발신자
					msg.setFrom(from);
					// 이메일 수신자
					InternetAddress to = new InternetAddress(user_email);
					msg.setRecipient(Message.RecipientType.TO, to);
					// 이메일 제목
					msg.setSubject("바구닉인증코드", "UTF-8");
					// 이메일 내용
					msg.setText(ran_number, "UTF-8");
					// 이메일 헤더
					msg.setHeader("content-Type", "text/html");
					// 메일보내기
					javax.mail.Transport.send(msg, msg.getAllRecipients());

				} catch (Exception email_e) {
					email_e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return arr;
	}

	//카카오톡으로 첫로그인시 이메일정보를 저장합니다.
	public int kakaoJoin(String email, String nick) {
	      connection();

	      String sql = "insert INTO member(member_email,member_name,member_joindate) VALUES(?,?,sysdate)";
	      try {
	         psmt = con.prepareStatement(sql);
	         psmt.setString(1, email);
	         psmt.setString(2, nick);
	         cnt = psmt.executeUpdate();
	         
	      } catch (SQLException e) {   
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return cnt;
	}
	
}
