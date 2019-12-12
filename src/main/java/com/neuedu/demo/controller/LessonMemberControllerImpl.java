package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class LessonMemberControllerImpl implements LessonMemberController {

	public LessonMemberControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertLessonMember(int lessonId, int MemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLessonMember(int lessonId, int MemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryLessonsByMemberId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryMembersByLessonId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
