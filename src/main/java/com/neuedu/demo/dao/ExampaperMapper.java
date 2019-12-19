package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Exampaper;

@Mapper
public interface ExampaperMapper {
	public long insertExampaper(Exampaper exampaper);
	public void deleteExampaper(Long id);
	public void updateExampaper(Exampaper exampaper);
	public Exampaper queryExampaperById(Long id);
	public List<Exampaper> queryExampapersByLessonId(Long id);
	public List<Exampaper> queryExampapersBySublessonId(Long id);
	public Long count();
	public Integer isExistent(Long id);
}
