package com.neuedu.demo.domain;

public class User {
	private UserContained contain;
	private UserInfo mainInfo;
	public User(String username,String password,long id,String image,String identity) {
		this.mainInfo=new UserInfo(username,password,id,image,identity);
		this.contain=new UserContained();
	}
	public UserContained getContain() {
		return contain;
	}
	public UserInfo getMainInfo() {
		return mainInfo;
	}
}
