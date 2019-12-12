package com.neuedu.demo.domain;

public class Teacher extends User {

	public Teacher(String username, String password, long id, String image) {
		super(username, password, id, image, "teacher");
	}

}
