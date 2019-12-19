package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Exampaper;

public interface ExampaperService {
	public static ExampaperService empty(SqlSession session){
		ExampaperServiceImpl service=new ExampaperServiceImpl(session);
		return service;
	}
	public long insertExampaper(Exampaper exampaper);
	public void deleteExampaper(Long id);
	public void updateExampaper(Exampaper exampaper);
	public Exampaper queryExampaperById(Long id);
	public List<Exampaper> queryExampapersByLessonId(Long id);
	public List<Exampaper> queryExampapersBySublessonId(Long id);
	public Long count();
	
}
