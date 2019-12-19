package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class UserContained {
	private List<Message> messages=new ArrayList<Message>();
	private List<Lesson> lessons=new ArrayList<Lesson>();
	private List<String> ppts=new ArrayList<String>();
	private List<Activity> activities=new ArrayList<Activity>();
	private List<Discussion> discussions=new ArrayList<Discussion>();
	public UserContained() {
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}
	public List<String> getPpts() {
		return ppts;
	}
	public void addPPT(String ppt) {
		this.ppts.add(ppt);
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void addActivitie(Activity activity) {
		this.activities.add(activity);
	}
	public List<Discussion> getDiscussions() {
		return discussions;
	}
	public void addDiscussion(Discussion discussion) {
		this.discussions.add(discussion);
	}
}
