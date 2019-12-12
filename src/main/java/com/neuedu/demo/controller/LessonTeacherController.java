package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface LessonTeacherController {
	public static LessonTeacherController empty(SqlSession session){
		LessonTeacherController controller=new LessonTeacherControllerImpl(session);
		return controller;
	}
	
	public String insertLessonTeacher(int lessonId,int teacherId);
	public String deleteLessonTeacher(int lessonId,int teacherId);
	public List<Integer> queryLessonsByTeacherId(Integer id);
	public List<Integer> queryTeachersByLessonId(Integer id);
	
}
