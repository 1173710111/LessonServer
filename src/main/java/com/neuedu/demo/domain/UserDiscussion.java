package com.neuedu.demo.domain;

public class UserDiscussion {
	private long id;
	private long discussionId;
	private long userId;
	private String userIdentity;
	//0-unstared 1-stared
	private int starState;
	
	
	public UserDiscussion(long id, String userIdentity,  long userId,long discussionId, int starState) {
		super();
		this.id = id;
		this.discussionId = discussionId;
		this.userId = userId;
		this.userIdentity = userIdentity;
		this.starState = starState;
	}

	public long getId() {
		return id;
	}

	public long getDiscussionId() {
		return discussionId;
	}
	
	public long getUserId() {
		return userId;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public int getStarState() {
		return starState;
	}
	
	public void changeStarState(int state){
		this.starState=state;
	}

	@Override
	public String toString() {
		return "UserDiscussion [id=" + id + ", discussionId=" + discussionId + ", userId=" + userId + ", userIdentity="
				+ userIdentity + ", starState=" + starState + "]";
	}
	
}
