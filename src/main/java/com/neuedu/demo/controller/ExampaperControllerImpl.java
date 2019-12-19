package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.Exampaper;
import com.neuedu.demo.domain.SubLesson;
import com.neuedu.demo.service.ExampaperService;
@Controller
public class ExampaperControllerImpl implements ExampaperController {
	private SqlSession session;
	@Autowired
	private ExampaperService service;
	public ExampaperControllerImpl(SqlSession session) {
		this.service=ExampaperService.empty(session);
		this.session=session;
	}
	@Override
	public String insertExampaper(String publishedTime,String lastTime,Long lessonId,Long sublessonId) {
		LessonController controller=LessonController.empty(session);
		if (controller.queryLessonInfoById(lessonId).getId()==0){
			return "false:cannot find lesson["+lessonId+"].";
		}
		SubLessonController controller2=SubLessonController.empty(session);
		SubLesson sublesson=controller2.querySubLessonInfoById(sublessonId);
		if (sublesson.getId()==0){
			return "false:cannot find sublesson["+sublessonId+"].";
		}
		if(sublesson.getLessonId()!=lessonId){
			return "false:cannot find lesson["+lessonId+"].";
		}
		Exampaper exampaper=new Exampaper((long)0,publishedTime,lastTime,lessonId,sublessonId);
		Long cnt=service.count();
		service.insertExampaper(exampaper);
		long id = exampaper.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}


	@Override
	public String deleteExampaper(Long id) {
		Long cnt=service.count();
		service.deleteExampaper(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}
	@Override
	public String updateExampaper(Long id,String publishedTime,String lastTime,Long lessonId,Long sublessonId) {
		LessonController controller=LessonController.empty(session);
		if (controller.queryLessonInfoById(lessonId).getId()==0){
			return "false:cannot find lesson["+lessonId+"].";
		}
		SubLessonController controller2=SubLessonController.empty(session);
		SubLesson sublesson=controller2.querySubLessonInfoById(sublessonId);
		if (sublesson.getId()==0){
			return "false:cannot find sublesson["+sublessonId+"].";
		}
		if(sublesson.getLessonId()!=lessonId){
			return "false:cannot find lesson["+lessonId+"].";
		}
		Exampaper exampaper=new Exampaper(id,publishedTime,lastTime,lessonId,sublessonId);
		service.updateExampaper(exampaper);
		Exampaper ExampaperAfter=service.queryExampaperById(id);
		if (ExampaperAfter.toString().equals(exampaper.toString())){
			return "success:"+exampaper.toString();
		}else{
			return "false:"+ExampaperAfter.toString();
		}
	}
	@Override
	public Exampaper queryExampaperInfoById(Long id) {
		Exampaper Exampaper=service.queryExampaperById(id);
		return Exampaper;
	}

	@Override
	public List<Exampaper> queryExampapersBySublessonId(Long id) {
		List<Exampaper> exampapers=service.queryExampapersBySublessonId(id);
		return exampapers;
	}
	@Override
	public List<Exampaper> queryExampapersByLessonId(Long id) {
		List<Exampaper> exampapers=service.queryExampapersByLessonId(id);
		return exampapers;
	}
}
