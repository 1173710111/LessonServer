package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserDiscussionControllerImpl implements UserDiscussionController {

	public UserDiscussionControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertUserDiscussion(Long discussionId, String userIdentity, Long userId, int starState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserDiscussion(String userIdentity, Long userId, Long discussionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserDiscussionState(String userIdentity, Long userId, Long discussionId, int starState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryUserDiscussions(String userIdentity, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryDiscussionUsersByUserId(Long discussionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
