package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.mysql.cj.protocol.Message;

public class MessageControllerImpl implements MessageController {

	public MessageControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertActivityToastMessage(String sender, String content, int lessonId, long activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertMemberDeleteMessage(String sender, String content, int lessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertTeamAddMessage(String sender, String content, int lessonId, long activityId, long workId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertDiscussionMessage(String type, String sender, String content, int lessonId, long discussionId,
			long replyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message queryMessageInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
