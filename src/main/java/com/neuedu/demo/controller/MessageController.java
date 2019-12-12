package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.mysql.cj.protocol.Message;


public interface MessageController {
	public static MessageController empty(SqlSession session){
		MessageController controller=new MessageControllerImpl(session);
		return controller;
	}
	public String insertActivityToastMessage(String sender,String content,int lessonId,long activityId);
	public String insertMemberDeleteMessage(String sender,String content,int lessonId);
	public String insertTeamAddMessage(String sender,String content,int lessonId,long activityId,long workId);
	public String insertDiscussionMessage(String type,String sender,String content,int lessonId,long discussionId,long replyId);
	public String deleteMessage(Integer id);
	public String updateMessage(Message message);
	public Message queryMessageInfoById(Integer id);
}
