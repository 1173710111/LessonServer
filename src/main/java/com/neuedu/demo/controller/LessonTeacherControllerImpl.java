package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class LessonTeacherControllerImpl implements LessonTeacherController {

	public LessonTeacherControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertLessonTeacher(int lessonId, int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLessonTeacher(int lessonId, int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryLessonsByTeacherId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> queryTeachersByLessonId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



}
