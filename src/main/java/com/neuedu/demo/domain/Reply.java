package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Reply {
	private long id;
	private User user;
	private String time;
	private String content;
	private List<Reply> replies;
	public Reply(long id, User user, String time, String content) {
		super();
		this.id = id;
		this.user = user;
		this.time = time;
		this.content = content;
		this.replies=new ArrayList<Reply>();
	}
	public long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public String getTime() {
		return time;
	}
	public String getContent() {
		return content;
	}
	public List<Reply> getReplies() {
		return replies;
	}
}
