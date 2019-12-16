package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.ExamPaper;

public class ExampaperControllerImpl implements ExampaperController {

	public ExampaperControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertExampaper(String publishedTime, String lastTime, Long lessonId, Long sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteExampaper(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateExampaper(Long id, String publishedTime, String lastTime, Long lessonId, Long sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamPaper queryExampaperInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPaper> queryExampapersBySublessonId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
