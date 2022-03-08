package com.happnic.bagunic.VO;

//����� ��ü
public class UserVO {
	private String email;
	private String pw;
	private String name;
	private String phone;
	private String joindate;

	//ȸ�� ���� ��ȸ�� ���
	public UserVO(String email, String pw, String name, String phone, String joindate) {
		super();
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.joindate = joindate;
	}
	
	//ȸ�� ���Կ� ���
	public UserVO(String email, String pw, String name, String phone) {
		super();
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.joindate = joindate;
	}

	public UserVO() {}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPh(String phone) {
		this.phone = phone;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "userVo [email=" + email + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", joindate=" + joindate + "]";
	}
}
