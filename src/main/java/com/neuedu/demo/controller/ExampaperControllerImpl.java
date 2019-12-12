package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.ExamPaper;

public class ExampaperControllerImpl implements ExampaperController {

	public ExampaperControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertExampaper(String publishedTime, String lastTime, Integer lessonId, Integer sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteExampaper(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateExampaper(long id, String publishedTime, String lastTime, Integer lessonId,
			Integer sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamPaper queryExampaperInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPaper> queryExampapersBySublessonId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
