package com.jin.pojo;

public class Account {
	
	private Integer uid;
	private String username;
	private String userpasswd;
	
	public Account() {}
	
	public Account(int uid,String acc,String pwd) {
		this.uid=uid;
		this.username=acc;
		this.userpasswd=pwd;
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}
	
	

}
