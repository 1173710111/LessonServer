package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Message;

@Mapper
public interface MessageMapper {
	public long insertMessage(Message Message);
	public void deleteMessage(Long id);
	public void updateMessage(Message Message);
	public Message queryMessageById(Long id);
	public List<Message> queryMessagesByLessonId(Long id);
	public List<Message> queryMessagesByType(String type);
	public Long count();
	public Integer isExistent(Long id);
}
