package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class LessonContained {
	private List<Student> members;
	private List<SubLesson> subLessons;
	private List<Activity> activities;
	private List<Discussion> discussions;
	public List<Student> getMembers() {
		return members;
	}
	public List<SubLesson> getSubLessons() {
		return subLessons;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public List<Discussion> getDiscussions() {
		return discussions;
	}
	
	public List<String> getStudentsName(){
		List<String> names=new ArrayList<String>();
		for (int i=0;i<this.members.size();i++){
			names.add(this.members.get(i).getMainInfo().getUsername());
		}
		return names;
	}
	public void addStudent(Student student){
		this.members.add(student);
	}
	public void deleteStudent(long studentId){
		for(int i=0;i<this.members.size();i++){
			if (this.members.get(i).getMainInfo().getId()==studentId){
				this.members.remove(i);
			}
		}
	}
	public SubLesson getLastSubLesson(){
		long lastId=this.subLessons.get(0).getId();
		SubLesson lastSubLesson=this.subLessons.get(0);
		for (int i=1;i<this.subLessons.size();i++){
			long thisId=this.subLessons.get(i).getId();
			if (lastId<thisId){
				lastId=thisId;
				lastSubLesson=this.subLessons.get(i);
			}
		}
		return lastSubLesson;
	}
	public void addSubLesson(SubLesson subLesson){
		this.subLessons.add(subLesson);
	}
	public Discussion getLastDiscussion(){
		long lastTime=Long.parseLong(this.discussions.get(0).getPublishedTime());
		Discussion lastDiscussion=this.discussions.get(0);
		for (int i=1;i<this.discussions.size();i++){
			long thisTime=Long.parseLong(this.discussions.get(i).getPublishedTime());
			if (thisTime>lastTime){
				lastTime=thisTime;
				lastDiscussion=this.discussions.get(i);
			}
		}
		return lastDiscussion;
	}
	public void addDiscussion(Discussion discussion){
		this.discussions.add(discussion);
	}
	public Activity getLastActivity(){
		long lastTime=Long.parseLong(this.activities.get(0).getDeadline());
		Activity lastActivity=this.activities.get(0);
		for (int i=1;i<this.activities.size();i++){
			long thisTime=Long.parseLong(this.activities.get(i).getPublishedTime());
			if (thisTime>lastTime){
				lastTime=thisTime;
				lastActivity=this.activities.get(i);
			}
		}
		return lastActivity;
	}
	public void addActivity(Activity Activity){
		this.activities.add(Activity);
	}
}
