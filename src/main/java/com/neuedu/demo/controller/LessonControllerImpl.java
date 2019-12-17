package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Lesson;

public class LessonControllerImpl implements LessonController {

	public LessonControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertLesson(String name, String introduction, String timeStart, String timeEnd, String password,
			String image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLesson(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateLesson(Long LessonId,String name, String introduction, String timeStart, String timeEnd, String password,
			String image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson queryLessonInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
