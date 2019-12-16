package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface UserMessageController {
	public static UserMessageController empty(SqlSession session){
		UserMessageController controller=new UserMessageControllerImpl(session);
		return controller;
	}
	
	public String insertUserMessage(Long MessageId,String userIdentity,Long userId);
	public String deleteUserMessage(String userIdentity,Long userId,Long MessageId);
	public List<Long> queryUserMessages(String userIdentity,Long userId);
	public List<Long> queryMessageUsersByUserId(Long MessageId); 
	
}
