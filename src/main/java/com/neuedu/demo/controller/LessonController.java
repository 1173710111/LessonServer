package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Lesson;
import com.neuedu.demo.domain.LessonInfo;

public interface LessonController {
	public static LessonController empty(SqlSession session){
		LessonController controller=new LessonControllerImpl(session);
		return controller;
	}
	
	public String insertLesson(String name,String introduction,
			String timeStart,String timeEnd,String password,String image);
	public String deleteLesson(Long id);
	public String updateLesson(Long lessonId,String name,String introduction,
			String timeStart,String timeEnd,String password,String image);
	public LessonInfo queryLessonInfoById(Long id);
}
