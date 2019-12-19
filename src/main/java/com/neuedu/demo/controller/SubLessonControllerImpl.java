package com.neuedu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.SubLesson;
import com.neuedu.demo.service.SubLessonService;
@Controller
public class SubLessonControllerImpl implements SubLessonController {
	@Autowired
	private SubLessonService service;
	public SubLessonControllerImpl(SqlSession session) {
		this.service=SubLessonService.empty(session);
	}

	@Override
	public String insertSubLesson(String name, Long lessonId,String pptUrl) {
		SubLesson sublesson=new SubLesson((long)0,lessonId,name,pptUrl);
		Long cnt=service.count();
		service.insertSubLesson(sublesson);
		Long cnt_after=service.count();
		long id = sublesson.getId();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteSubLesson(Long id) {
		Long cnt=service.count();
		service.deleteSubLesson(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateSubLesson(Long id, String name, Long lessonId,String pptUrl) {
		SubLesson sublesson=new SubLesson(id,lessonId,name,pptUrl);
		service.updateSubLesson(sublesson);
		SubLesson sublessonAfter=service.querySubLessonById(id);
		if (sublessonAfter.toString().equals(sublesson.toString())){
			return "success:"+sublesson.toString();
		}else{
			return "false:"+sublessonAfter.toString();
		}
	}

	@Override
	public SubLesson querySubLessonInfoById(Long id) {
		SubLesson sublesson=service.querySubLessonById(id);
		return sublesson;
	}

	@Override
	public List<SubLesson> querySubLessonsByLessonId(Long lessonId) {
		List<SubLesson> sublessons=new ArrayList<SubLesson>(service.querySubLessonsByLessonId(lessonId));
		return sublessons;
	}

	

}
