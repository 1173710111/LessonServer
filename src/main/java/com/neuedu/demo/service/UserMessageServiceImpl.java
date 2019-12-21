package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.dao.UserMessageMapper;
import com.neuedu.demo.tool.Pair;

public class UserMessageServiceImpl implements UserMessageService{
	private SqlSession session;
	 @Autowired
    private UserMessageMapper mapper=null;     
	public UserMessageServiceImpl(SqlSession session) {
		this.session=session;
    	mapper=session.getMapper(UserMessageMapper.class);
	}
	@Override
	public void insertUserMessage(Pair pair) {
		if(mapper.isExistent(pair)>0)
			return;
		mapper.insertUserMessage(pair);
		session.commit();
	}
	@Override
	public void deleteUserMessage(Pair pair) {
		if(mapper.isExistent(pair)>0){
			mapper.deleteUserMessage(pair);
			session.commit();
		}
	}
	@Override
	public List<Pair> queryMessageUsersByMessageId(Long messageId) {
		List<Pair> users=mapper.queryMessageUsersByMessageId(messageId);
		if (users==null||users.size()==0){
			return new ArrayList<Pair>();
		}else return users;
	}
	@Override
	public List<Long> queryUserMessages(Pair user) {
		List<Long> messages=mapper.queryUserMessages(user);
		if (messages==null||messages.size()==0){
			return new ArrayList<Long>();
		}else return messages;
	}
	@Override
	public Long count() {
		return mapper.count();
	}

	
}
