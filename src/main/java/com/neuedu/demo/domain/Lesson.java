package com.neuedu.demo.domain;

public class Lesson {
	public Lesson(int id, LessonInfo mainInfo) {
		super();
		this.id = id;
		this.mainInfo = mainInfo;
	}
	private int id;
	private LessonInfo mainInfo;
	private LessonContained contain;
	
	public long getId(){
		return this.id;
	}
	public LessonInfo getMainInfo() {
		return mainInfo;
	}
	public LessonContained getContain() {
		return contain;
	}
	
}
