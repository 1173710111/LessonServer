package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.SubLesson;

public class SubLessonControllerImpl implements SubLessonController {

	public SubLessonControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertSubLesson(String name, Integer lessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubLesson(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateSubLesson(Integer id, String name, int lessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubLesson querySubLessonInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubLesson> querySubLessonsByLessonId(Integer lessonId) {
		// TODO Auto-generated method stub
		return null;
	}

}
