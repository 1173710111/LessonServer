package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserMessageControllerImpl implements UserMessageController {

	public UserMessageControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertUserMessage(Integer MessageId, String userIdentity, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserMessage(String userIdentity, Integer userId, Integer MessageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryUserMessages(String userIdentity, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryMessageUsersByUserId(Integer MessageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
