package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class LessonTeacherControllerImpl implements LessonTeacherController {

	public LessonTeacherControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertLessonTeacher(Long lessonId, Long teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteLessonTeacher(Long lessonId, Long teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryLessonsByTeacherId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> queryTeachersByLessonId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
