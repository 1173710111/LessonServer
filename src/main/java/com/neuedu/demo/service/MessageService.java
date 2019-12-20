package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Message;

public interface MessageService {
	public static MessageService empty(SqlSession session){
		MessageServiceImpl service=new MessageServiceImpl(session);
		return service;
	}
	public long insertMessage(Message Message);
	public void deleteMessage(Long id);
	public void updateMessage(Message Message);
	public Message queryMessageById(Long id);
	public List<Message> queryMessagesByLessonId(Long id);
	public List<Message> queryMessagesByType(String type);
	public Long count();
}
