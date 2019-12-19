package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Exampaper;

public interface ExampaperController {
	public static ExampaperController empty(SqlSession session){
		ExampaperController controller=new ExampaperControllerImpl(session);
		return controller;
	}
	
	public String insertExampaper(String publishedTime,String lastTime,Long lessonId,Long sublessonId);
	public String deleteExampaper(Long id);
	public String updateExampaper(Long id,String publishedTime,String lastTime,Long lessonId,Long sublessonId);
	public Exampaper queryExampaperInfoById(Long id);
	public List<Exampaper> queryExampapersByLessonId(Long id);
	public List<Exampaper> queryExampapersBySublessonId(Long id);

	
}
