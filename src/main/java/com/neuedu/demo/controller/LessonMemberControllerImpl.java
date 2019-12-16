package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class LessonMemberControllerImpl implements LessonMemberController {

	public LessonMemberControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertLessonMember(Long lessonId, Long MemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLessonMember(Long lessonId, Long MemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryLessonsByMemberId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryMembersByLessonId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
