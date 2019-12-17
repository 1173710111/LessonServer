package com.neuedu.demo.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExamPaper {
	private long id;
	private long lessonId;
	private long sublessonId;
	private String publishedTime;
	private String lastTime;
	private Score score;
	private List<Question> questions;
	public ExamPaper(long id, long lessonId, long sublessonId, String publishedTime, String lastTime) {
		super();
		this.id = id;
		this.lessonId = lessonId;
		this.sublessonId = sublessonId;
		this.publishedTime = publishedTime;
		this.lastTime = lastTime;
		this.questions=new ArrayList<Question>();
	}
	
	public Score getScore() {
		if (this.score==null){
			return score;
		}else{
			return this.score;
		}	
	}
	public void setScore(Score score) {
		this.score = score;
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
	public String getPublishedTime() {
		return publishedTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question){
		boolean flag=true;
		for (int i=0;i<this.questions.size();i++){
			if (this.questions.get(i).getId()==question.getId()){
				flag=false;
				break;
			}
		}
		if (flag){
			this.questions.add(question);
		}
	}
	public void deleteQuestion(long questionId){
		for (int i=0;i<this.questions.size();i++){
			if (this.questions.get(i).getId()==questionId){
				this.questions.remove(i);
			}
		}
	}
	public String getFinishedTime(){
		long tmpdate=Long.parseLong(publishedTime);
		int tmplast=Integer.parseInt(lastTime)*60*1000;
		tmpdate+=tmplast;
		String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tmpdate);
		return result;
	}
	@Override
	public String toString() {
		return "ExamPaper [id=" + id + ", lessonId=" + lessonId + ", sublessonId=" + sublessonId + ", publishedTime="
				+ publishedTime + ", lastTime=" + lastTime + "]";
	}
	
}
