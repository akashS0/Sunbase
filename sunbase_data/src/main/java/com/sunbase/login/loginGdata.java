package com.sunbase.login;

public class loginGdata {
	
	private String login_id;
	private String password;
	
	
	public loginGdata(String login_id, String password) {
		super();
		this.login_id = login_id;
		this.password = password;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
