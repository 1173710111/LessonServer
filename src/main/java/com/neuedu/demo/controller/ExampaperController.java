package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.ExamPaper;

public interface ExampaperController {
	public static ExampaperController empty(SqlSession session){
		ExampaperController controller=new ExampaperControllerImpl(session);
		return controller;
	}
	
	public String insertExampaper(String publishedTime,String lastTime,Long lessonId,Long sublessonId);
	public String deleteExampaper(Long id);
	public String updateExampaper(Long id,String publishedTime,String lastTime,Long lessonId,Long sublessonId);
	public ExamPaper queryExampaperInfoById(Long id);
	public List<ExamPaper> queryExampapersBySublessonId(Long id);
}
