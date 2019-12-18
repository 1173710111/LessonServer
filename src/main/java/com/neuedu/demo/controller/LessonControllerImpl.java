package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.LessonInfo;
import com.neuedu.demo.service.LessonService;
@Controller
public class LessonControllerImpl implements LessonController {
	@Autowired
	private LessonService service;
	public LessonControllerImpl(SqlSession session) {
		this.service=LessonService.empty(session);
	}

	@Override
	public String insertLesson(String name, String introduction, String timeStart, 
			String timeEnd, String password,String image) {
		LessonInfo lesson=new LessonInfo(0,name,introduction,timeStart,timeEnd,password,image,null);
		Long cnt=service.count();
		service.insertLesson(lesson);
		long id = lesson.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteLesson(Long id) {
		Long cnt=service.count();
		service.deleteLesson(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateLesson(Long lessonId,String name, String introduction, String timeStart, String timeEnd, String password,
			String image) {
		LessonInfo lesson=new LessonInfo(lessonId,name,introduction,timeStart,timeEnd,password,image,null);
		service.updateLesson(lesson);
		LessonInfo lessonAfter=service.queryLessonById(lessonId);
		if (lessonAfter.toString().equals(lesson.toString())){
			return "success:"+lesson.toString();
		}else{
			return "false:"+lessonAfter.toString();
		}
	}

	@Override
	public LessonInfo queryLessonInfoById(Long id) {
		LessonInfo lesson=service.queryLessonById(id);
		return lesson;
	}

	
}
