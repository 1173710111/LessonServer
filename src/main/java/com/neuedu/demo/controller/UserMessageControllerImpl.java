package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.service.UserMessageService;
import com.neuedu.demo.tool.Pair;
@Controller
public class UserMessageControllerImpl implements UserMessageController {
	@Autowired
	private UserMessageService service;
	public UserMessageControllerImpl(SqlSession session) {
		this.service=UserMessageService.empty(session);
	}

	@Override
	public String insertUserMessage(Long messageId,String userIdentity,Long userId) {
		Pair pair=new Pair(messageId,new Pair(userIdentity,userId));
		Long cnt=service.count();
		service.insertUserMessage(pair);
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success";
		}else{
			return "false";
		}
	}

	@Override
	public String deleteUserMessage(Long messageId,String userIdentity,Long userId) {
		Pair pair=new Pair(messageId,new Pair(userIdentity,userId));
		Long cnt=service.count();
		service.deleteUserMessage(pair);
		Long cnt_after=service.count();
		cnt--;
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public List<Long> queryUserMessages(String userIdentity,Long userId){
		Pair pair=new Pair(userIdentity,userId);
		return service.queryUserMessages(pair);
	}

	@Override
	public List<Pair> queryMessageUsersByMessageId(Long messageId){
		return service.queryMessageUsersByMessageId(messageId);
	}

}
