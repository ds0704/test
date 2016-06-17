package com.study.spring.domain;

public class MemberVO {
	private String user_id;
	private String pw;
	private String user_name;
	private String email;
	private long regdate;
	private long lastupdate;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getRegdate() {
		return regdate;
	}
	public void setRegdate(long regdate) {
		this.regdate = regdate;
	}
	public long getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(long lastupdate) {
		this.lastupdate = lastupdate;
	}
}
