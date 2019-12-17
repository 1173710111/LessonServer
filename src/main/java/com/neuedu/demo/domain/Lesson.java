package com.neuedu.demo.domain;

public class Lesson {
	public Lesson(LessonInfo mainInfo,LessonContained contain) {
		super();
		this.mainInfo = mainInfo;
		this.contain=contain;
	}
	private LessonInfo mainInfo;
	private LessonContained contain;
	
	public LessonInfo getMainInfo() {
		return mainInfo;
	}
	public LessonContained getContain() {
		return contain;
	}
	
}
