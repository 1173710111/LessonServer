package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class LessonInfo {
	private String name;
	private String introduction;
	private String timeStart;
	private String timeEnd;
	private String password;
	private String image;
	private List<Teacher> teachers;
	public LessonInfo(String name, String introduction, String timeStart, String timeEnd, String password, String image,
			List<Teacher> teachers) {
		super();
		this.name = name;
		this.introduction = introduction;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.password = password;
		this.image = image;
		this.teachers = teachers;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public String getPassword() {
		return password;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public List<String> getTeachersName(){
		List<String> names=new ArrayList<String>();
		for (int i=0;i<this.teachers.size();i++){
			names.add(this.teachers.get(i).getMainInfo().getUsername());
		}
		return names;
	}
}
