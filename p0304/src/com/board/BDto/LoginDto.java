package com.board.BDto;

public class LoginDto {

	public LoginDto() {}
	
	public LoginDto(String login_id, String login_pw, String login_name, String login_nickName) {
		super();
		this.login_id = login_id;
		this.login_pw = login_pw;
		this.login_name = login_name;
		this.login_nickName = login_nickName;
	}
	
	private String login_id;
	private String login_pw;
	private String login_name;
	private String login_nickName;
	
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pw() {
		return login_pw;
	}
	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_nickName() {
		return login_nickName;
	}
	public void setLogin_nickName(String login_nickName) {
		this.login_nickName = login_nickName;
	}
	
	
	
	
	
}
