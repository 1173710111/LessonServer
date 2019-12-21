package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.tool.Pair;

public interface UserMessageService {
	public static UserMessageService empty(SqlSession session){
		UserMessageServiceImpl service=new UserMessageServiceImpl(session);
		return service;
	}
	public void insertUserMessage(Pair pair);
	public void deleteUserMessage(Pair pair);
	public List<Pair> queryMessageUsersByMessageId(Long messageId);
	public List<Long> queryUserMessages(Pair user);
	public Long count();
}
