package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserDiscussionControllerImpl implements UserDiscussionController {

	public UserDiscussionControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertUserDiscussion(Integer discussionId, String userIdentity, Integer userId, int starState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserDiscussion(String userIdentity, Integer userId, Integer discussionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserDiscussionState(String userIdentity, Integer userId, Integer discussionId, int starState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryUserDiscussions(String userIdentity, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryDiscussionUsersByUserId(Integer discussionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
