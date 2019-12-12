package com.neuedu.demo.domain;

public class Student extends User {

	public Student(String username, String password, long id, String image) {
		super(username, password, id, image, "student");
	}
	
}
