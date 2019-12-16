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
	public String insertDiscussion(Long lessonId, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDiscussion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDiscussion(Long id, Long lessonId, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion queryDiscussionInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discussion> queryDiscussionsByLessonId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
