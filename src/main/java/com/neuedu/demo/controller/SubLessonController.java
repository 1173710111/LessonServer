package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.SubLesson;
import com.neuedu.demo.domain.UserInfo;

public interface SubLessonController {
	public static SubLessonController empty(SqlSession session){
		SubLessonController controller=new SubLessonControllerImpl(session);
		return controller;
	}
	
	public String insertSubLesson(String name,Integer lessonId);
	public String deleteSubLesson(Integer id);
	public String updateSubLesson(Integer id,String name,int lessonId);
	public SubLesson querySubLessonInfoById(Integer id);
	public List<SubLesson> querySubLessonsByLessonId(Integer lessonId);
}