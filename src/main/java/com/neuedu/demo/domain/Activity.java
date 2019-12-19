package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;


public class Activity {
	private long id;
	private long lessonId;
	private long num;
	private String title;
	private String introduction;
	private String publishedTime;
	private String deadline;
	private int teamVolume;
	private List<String> downFiles=new ArrayList<String>();
	private List<StudentWork> studentworks=new ArrayList<StudentWork>();
	/*public Activity(long id,long lessonId, String type, String title, String introduction,String publishedTime, String deadline,
			int teamVolume ,List<String> downFiles) {
		super();
		this.id = id;
		this.lessonId=id;
		this.title = title;
		this.introduction = introduction;
		this.publishedTime=publishedTime;
		this.deadline = deadline;
		this.downFiles = downFiles;
		this.teamVolume = teamVolume;
		setNum();
	}
	*/

	public Activity(long id, long lessonId, String title, String introduction, String deadline,
			Integer teamVolume, String publishedTime) {
		this.id = id;
		this.lessonId = lessonId;
		this.title = title;
		this.introduction = introduction;
		this.deadline = deadline;
		this.teamVolume = teamVolume;
		this.publishedTime = publishedTime;
	}


	public void setNum(List<Activity> activities){
		int num=-1;
		for (int i=0;i<activities.size();i++){
			Activity activity=activities.get(i);
			if (activity.getId()==this.id){
				num=i+1;
				break;
			}
		}
		if (num==-1) 
			num=activities.size();
		this.num=num;
	}
	public long getNum(){
		return this.num;
	}
	public long getLessonId() {
		return lessonId;
	}
	public List<String> getDownFiles() {
		return downFiles;
	}
	public void addDownFile(String downFile) {
		this.downFiles.add(downFile);
	}
	public List<StudentWork> getStudentworks() {
		return studentworks;
	}
	public void addStudentwork(StudentWork studentwork) {
		this.studentworks.add(studentwork);
	}
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getIntroduction() {
		return introduction;
	}
	
	
	public String getPublishedTime() {
		return publishedTime;
	}

	public String getDeadline() {
		return deadline;
	}
	public int getTeamVolume() {
		return teamVolume;
	}


	@Override
	public String toString() {
		return "Activity [id=" + id + ", lessonId=" + lessonId + ", num=" + num + ", title=" + title + ", introduction="
				+ introduction + ", publishedTime=" + publishedTime + ", deadline=" + deadline + ", teamVolume="
				+ teamVolume + "]";
	}
	
}
