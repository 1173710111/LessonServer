package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.ExamPaper;

public interface ExampaperController {
	public static ExampaperController empty(SqlSession session){
		ExampaperController controller=new ExampaperControllerImpl(session);
		return controller;
	}
	
	public String insertExampaper(String publishedTime,String lastTime,Integer lessonId,Integer sublessonId);
	public String deleteExampaper(Integer id);
	public String updateExampaper(long id,String publishedTime,String lastTime,Integer lessonId,Integer sublessonId);
	public ExamPaper queryExampaperInfoById(Integer id);
	public List<ExamPaper> queryExampapersBySublessonId(Integer id);
}
