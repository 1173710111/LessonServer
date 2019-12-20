package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Message;

public interface MessageController {
	public static MessageController empty(SqlSession session){
		MessageController controller=new MessageControllerImpl(session);
		return controller;
	}
	public String insertMessage(String type,String sender,String content,
			Long lessonId,Long activityId,Long workId,Long discussionId,Long replyId);
	public String deleteMessage(Long id);
	public String updateMessage(Long id,String type,String sender,String content,
			Long lessonId,Long activityId,Long workId,Long discussionId,Long replyId);
	public Message queryMessageInfoById(Long id);
	public List<Message> queryMessagesBylessonId(Long id);
	public List<Message> queryMessagesByType(String type);
}
