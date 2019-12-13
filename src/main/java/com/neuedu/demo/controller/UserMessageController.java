package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface UserMessageController {
	public static UserMessageController empty(SqlSession session){
		UserMessageController controller=new UserMessageControllerImpl(session);
		return controller;
	}
	
	public String insertUserMessage(Integer MessageId,String userIdentity,Integer userId);
	public String deleteUserMessage(String userIdentity,Integer userId,Integer MessageId);
	public List<Integer> queryUserMessages(String userIdentity,Integer userId);
	public List<Integer> queryMessageUsersByUserId(Integer MessageId); 
	
}
