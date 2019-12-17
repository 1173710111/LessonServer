package com.neuedu.demo.service;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.LessonInfo;

public interface LessonService {
	public static LessonService empty(SqlSession session){
		LessonServiceImpl service=new LessonServiceImpl(session);
		return service;
	}
	public int insertLesson(LessonInfo Lesson);
	public void deleteLesson(Long id);
	public void updateLesson(LessonInfo Lesson);
	public LessonInfo queryLessonById(Long id);
	public Long count();
}
