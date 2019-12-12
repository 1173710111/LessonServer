package com.neuedu.demo.domain;

public class Banji {
	public Banji(Integer classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
	public Banji() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer classId;
	private String className;
	
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "banji [classId=" + classId + ", className=" + className + "]";
	}
	
	
}
