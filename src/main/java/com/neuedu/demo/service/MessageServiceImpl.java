

package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.MessageMapper;
import com.neuedu.demo.domain.Message;
@Service
public class MessageServiceImpl implements MessageService {
	private SqlSession session;
	 @Autowired
    private MessageMapper mapper=null; 
	public MessageServiceImpl(SqlSession session){
	   	this.session=session;
	   	mapper=session.getMapper(MessageMapper.class);
    }
	  
	@Override
	public long insertMessage(Message Message) {
		long i = mapper.insertMessage(Message);
		session.commit();
		return i;
	}

	@Override
	public void deleteMessage(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteMessage(id);
			session.commit();
		}
	}

	@Override
	public void updateMessage(Message Message) {
		if (mapper.isExistent(Message.getId())>0){
			mapper.updateMessage(Message);
			session.commit();
		}
	}

	@Override
	public Message queryMessageById(Long id) {
		Message message=null;
		if (mapper.isExistent(id)==0){
			message=new Message((long)0,null,null,null,(long)0,(long)0,(long)0,(long)0,(long)0);
		}else{
			message=mapper.queryMessageById(id);
			message.setSender();
			message.makeContent();
		}
		
		return message;
	}

	@Override
	public List<Message> queryMessagesByLessonId(Long id) {
		List<Message> messages=mapper.queryMessagesByLessonId(id);;
		if (messages==null||messages.size()==0){
			messages=new ArrayList<Message>();
		}else{
			for (Message m:messages){
				m.setSender();
				m.makeContent();
			}
		}
		return messages;
	}
	@Override
	public List<Message> queryMessagesByType(String type) {
		List<Message> messages=mapper.queryMessagesByType(type);
		if (messages==null||messages.size()==0){
			messages=new ArrayList<Message>();
		}else{
			for (Message m:messages){
				m.setSender();
				m.makeContent();
			}
		}
		return messages;
	}
	
	@Override
	public Long count() {
		return mapper.count();
	}
}
