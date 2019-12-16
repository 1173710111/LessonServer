package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserMessageControllerImpl implements UserMessageController {

	public UserMessageControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertUserMessage(Long MessageId, String userIdentity, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserMessage(String userIdentity, Long userId, Long MessageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryUserMessages(String userIdentity, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryMessageUsersByUserId(Long MessageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
