package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Discussion;
import com.neuedu.demo.domain.UserInfo;

public class DiscussionControllerImpl implements DiscussionController {

	public DiscussionControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertDiscussion(int lessonId, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDiscussion(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDiscussion(long id, int lessonId, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion queryDiscussionInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discussion> queryDiscussionsByLessonId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
