package com.happnic.bagunic.VO;

public class AppChatVO {
	private String email;
	private String content;
	private String day;
	
	public AppChatVO(String email, String content, String day) {
		super();
		this.email = email;
		this.content = content;
		this.day = day;
	}
	
	public AppChatVO() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getcontent() {
		return content;
	}
	public void setChat(String content) {
		this.content = content;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	@Override
	public String toString() {
		return "ChatVO [email=" + email + ", chat=" + content + ", day=" + day + "]";
	}
	
}
