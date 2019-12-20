package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Discussion {
	private long id;
	private long lessonId;
	private String title;
	private String publishedTime;
	private List<Reply> replies;
	private List<UserDiscussion> userDiscussions;
	
	public Discussion(long id, long lessonId, String title,String publishedTime) {
		super();
		this.id = id;
		this.lessonId = lessonId;
		this.title = title;
		this.publishedTime=publishedTime;
		this.replies=new ArrayList<Reply>();
		this.userDiscussions=new ArrayList<UserDiscussion>();
	}

	public long getId() {
		return id;
	}
	public long getLessonId() {
		return lessonId;
	}

	public String getTitle() {
		return title;
	}
	
	public String getPublishedTime(){
		return this.publishedTime;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public List<UserDiscussion> getUserDiscussions() {
		return userDiscussions;
	}
	
	public void addReplies(Reply reply){
		this.replies.add(reply);
	}
	
	public void addUserDiscussion(UserDiscussion userDiscussion){
		boolean flag=true;
		for (int i=0;i<this.userDiscussions.size();i++){
			UserDiscussion dis=this.userDiscussions.get(i);
			if ((dis.getUserId()==userDiscussion.getUserId())&&(dis.getUserIdentity().equals(userDiscussion.getUserIdentity()))){
				flag=false;
				if (userDiscussion.getDiscussionId()==this.id){
					this.userDiscussions.set(i, userDiscussion);
				}
				break;
			}
		}
		if (flag){
			this.userDiscussions.add(userDiscussion);
		}
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", lessonId=" + lessonId + ", title=" + title + ", publishedTime="
				+ publishedTime + "]";
	}
	
}
