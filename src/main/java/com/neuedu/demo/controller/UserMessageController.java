package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.tool.Pair;

public interface UserMessageController {
	public static UserMessageController empty(SqlSession session){
		UserMessageController controller=new UserMessageControllerImpl(session);
		return controller;
	}
	
	public String insertUserMessage(Long messageId,String userIdentity,Long userId);
	public String deleteUserMessage(Long messageId,String userIdentity,Long userId);
	public List<Long> queryUserMessages(String userIdentity,Long userId);
	public List<Pair> queryMessageUsersByMessageId(Long messageId); 
	
}
