package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.service.LessonService;
import com.neuedu.demo.service.LessonTeacherService;
import com.neuedu.demo.tool.PairLongs;

public class LessonTeacherControllerImpl implements LessonTeacherController {
	@Autowired
	private LessonTeacherService service;
	public LessonTeacherControllerImpl(SqlSession session) {
		this.service=LessonTeacherService.empty(session);
	}

	@Override
	public String insertLessonTeacher(Long lessonId, Long teacherId) {
		PairLongs pair=new PairLongs(lessonId,teacherId);
		Long cnt=service.count();
		service.insertLessonTeacher(pair);
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success";
		}else{
			return "false";
		}
	}

	@Override
	public String deleteLessonTeacher(Long lessonId, Long teacherId) {
		PairLongs pair=new PairLongs(lessonId,teacherId);
		Long cnt=service.count();
		service.deleteLessonTeacher(pair);
		Long cnt_after=service.count();
		cnt--;
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public List<Long> queryLessonsByTeacherId(Long id) {
		return service.queryLessonsByTeacherId(id);
	}

	@Override
	public List<Long> queryTeachersByLessonId(Long id) {
		return service.queryTeachersByLessonId(id);
	}

	
}
