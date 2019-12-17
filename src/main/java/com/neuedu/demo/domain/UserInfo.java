package com.neuedu.demo.domain;

public class UserInfo {
	private String username=new String();
	private String password=new String();
	private long id;
	private String image=new String();
	private String identity=new String();
	public UserInfo(String username, String password, long id, String image, String identity) {
		this.username = username;
		this.password = password;
		this.id = id;
		this.image = image;
		this.identity = identity;
	}
	
	public UserInfo(String username, String password, long id, String image) {
		this.username = username;
		this.password = password;
		this.id = id;
		this.image = image;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIdentity() {
		return identity;
	}
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + ", id=" + id + ", image=" + image
				+ ", identity=" + identity + "]";
	}	
	
}
