package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface LessonTeacherController {
	public static LessonTeacherController empty(SqlSession session){
		LessonTeacherController controller=new LessonTeacherControllerImpl(session);
		return controller;
	}
	
	public String insertLessonTeacher(Long lessonId,Long teacherId);
	public String deleteLessonTeacher(Long lessonId,Long teacherId);
	public List<Long> queryLessonsByTeacherId(Long id);
	public List<Long> queryTeachersByLessonId(Long id);
	
}
