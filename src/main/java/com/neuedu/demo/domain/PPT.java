package com.neuedu.demo.domain;

import org.apache.ibatis.session.SqlSession;

public class PPT {
	private long id;
	private long lessonId;
	private long sublessonId;
	private String fileUrl;
	public PPT(long id, long lessonId, long sublessonId, String fileUrl) {
		super();
		this.id = id;
		this.lessonId = lessonId;
		this.sublessonId = sublessonId;
		this.fileUrl = fileUrl;
	}
	public long getId() {
		return id;
	}
	public long getLessonId() {
		return lessonId;
	}
	public long getSublessonId() {
		return sublessonId;
	}
	public String getFileUrl() {
		return fileUrl;
	}
}
