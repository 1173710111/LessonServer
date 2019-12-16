package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class SubLesson {
	private long id;
	private long num;
	private String number;
	private String publishedDate;
	private List<ExamPaper> exampapers;
	private List<PPT> ppts;
	
	public SubLesson(long id, long num, String number, String publishedDate,List<PPT> ppts) {
		super();
		this.id = id;
		this.num = num;
		this.number = number;
		this.publishedDate = publishedDate;
		this.exampapers =new ArrayList<ExamPaper>();
		this.ppts = ppts;
	}

	public long getId() {
		return this.id;
	}

	public long getNum() {
		return num;
	}

	public String getNumber() {
		return number;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public List<ExamPaper> getExampapers() {
		return exampapers;
	}

	public List<PPT> getPpts() {
		return ppts;
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
}
