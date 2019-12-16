package com.neuedu.demo.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.controller.ActivityController;
import com.neuedu.demo.controller.LessonController;

public class Activity {
	private long id;
	private long lessonId;
	private long num;
	private String title;
	private String introduction;
	private String publishedTime;
	private String deadline;
	private int teamVolume;
	private List<String> downFiles;
	private List<StudentWork> studentworks;
	public Activity(long id,long lessonId, String type, String title, String introduction,String publishedTime, String deadline,
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

	private void setNum(){
		SqlSession session=NewSession.getSession();
		ActivityController controller=ActivityController.empty(session);
		List<Activity> activities=controller.queryActivitysByLessonId(this.lessonId);
		int num=-1;
		for (int i=0;i<activities.size();i++){
			Activity activity=activities.get(i);
			if (activity.getId()==this.id){
				num=i;
				break;
			}
		}
		if (num==-1) 
			num=activities.size();
		this.num=num;
		session.close();
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
	
}
