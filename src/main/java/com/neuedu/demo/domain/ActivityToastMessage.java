package com.neuedu.demo.domain;

import org.apache.ibatis.session.SqlSession;

public class ActivityToastMessage extends SystemMessage {
	
	public ActivityToastMessage(String sender, long lessonId, String type,long activityNum,String timeLeft) {
		super(sender, lessonId, type);
		this.activityNum=activityNum;
		this.timeLeft=timeLeft;
	}
	private long activityNum;
	private String timeLeft;

	@Override
	protected void makeContent(){
		String content=new String();
		content.concat("同学，你有一项活动[");
		content.concat()
	}
}
