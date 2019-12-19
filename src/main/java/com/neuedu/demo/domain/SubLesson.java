package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class SubLesson {
	private long id;
	private long lessonId;
	private String name;
	private String pptUrl;
	private List<ExamPaper> exampapers=new ArrayList<ExamPaper>();
	
	public SubLesson(long id, long lessonId, String name, String pptUrl) {
		super();
		this.id = id;
		this.lessonId = lessonId;
		this.name = name;
		this.pptUrl=pptUrl;
	}

	public long getId() {
		return this.id;
	}

	public long getLessonId() {
		return lessonId;
	}

	public String getName() {
		return name;
	}

	public List<ExamPaper> getExampapers() {
		return exampapers;
	}
	
	public String getPptUrl() {
		return pptUrl;
	}

	public void addExamPaper(ExamPaper paper){
		this.exampapers.add(paper);
	}
	
	public ExamPaper getLastExamPaper(){
		long lastTime=Long.parseLong(this.exampapers.get(0).getPublishedTime());
		ExamPaper paper=this.exampapers.get(0);
		for(int i=0;i<this.exampapers.size();i++){
			long thisTime=Long.parseLong(this.exampapers.get(i).getPublishedTime());
			if (thisTime>lastTime){
				lastTime=thisTime;
				paper=this.exampapers.get(i);
			}
		}
		return paper;
	}

	@Override
	public String toString() {
		return "SubLesson [id=" + id + ", lessonId=" + lessonId + ", name=" + name + ", pptUrl=" + pptUrl + "]";
	}


	
}
