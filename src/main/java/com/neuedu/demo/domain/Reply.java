package com.neuedu.demo.domain;

import java.util.List;

public class Reply {
	private long id;
	private String userIdentity;
	private long userId;
	private String time;
	private String content;
	private long discussionId;
	private long upReplyId;
	private List<Reply> replies;
	public Reply(long id, String userIdentity, long userId, String time, String content, long discussionId,
			long upReplyId) {
		super();
		this.id = id;
		this.userIdentity = userIdentity;
		this.userId = userId;
		this.time = time;
		this.content = content;
		this.discussionId = discussionId;
		this.upReplyId = upReplyId;
	}
	public long getId() {
		return id;
	}
	public String getUserIdentity() {
		return userIdentity;
	}
	public long getUserId() {
		return userId;
	}
	public String getTime() {
		return time;
	}
	public String getContent() {
		return content;
	}
	public long getDiscussionId() {
		return discussionId;
	}
	public long getUpReplyId() {
		return upReplyId;
	}
	public List<Reply> getReplies() {
		return replies;
	}
	@Override
	public String toString() {
		return "Reply [id=" + id + ", userIdentity=" + userIdentity + ", userId=" + userId + ", time=" + time
				+ ", content=" + content + ", discussionId=" + discussionId + ", upReplyId=" + upReplyId + "]";
	}
	
	
}
