package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.SubLesson;

public interface SubLessonController {
	public static SubLessonController empty(SqlSession session){
		SubLessonController controller=new SubLessonControllerImpl(session);
		return controller;
	}
	
	public String insertSubLesson(String name,Long lessonId);
	public String deleteSubLesson(Long id);
	public String updateSubLesson(Long id,String name,int lessonId);
	public SubLesson querySubLessonInfoById(Long id);
	public List<SubLesson> querySubLessonsByLessonId(Long lessonId);
}