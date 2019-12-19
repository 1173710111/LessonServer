package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.ExampaperMapper;
import com.neuedu.demo.domain.Exampaper;
@Service
public class ExampaperServiceImpl implements ExampaperService {
	private SqlSession session;
	@Autowired
    private ExampaperMapper mapper=null; 
	public ExampaperServiceImpl(SqlSession session) {
		this.session=session;
		mapper=session.getMapper(ExampaperMapper.class);
	}

	@Override
	public long insertExampaper(Exampaper exampaper) {
		long i = mapper.insertExampaper(exampaper);
		session.commit();
		return i;
	}

	@Override
	public void deleteExampaper(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteExampaper(id);
			session.commit();
		}
	}

	@Override
	public void updateExampaper(Exampaper exampaper) {
		if (mapper.isExistent(exampaper.getId())>0){
			mapper.updateExampaper(exampaper);
			session.commit();
		}
	}

	@Override
	public Exampaper queryExampaperById(Long id) {
		Exampaper exampaper=null;
		if (mapper.isExistent(id)==0){
			exampaper=new Exampaper((long)0,null,null,(long)0,(long)0);
		}else{
			exampaper=mapper.queryExampaperById(id);
		}
		return exampaper;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

	@Override
	public List<Exampaper> queryExampapersBySublessonId(Long id) {
		List<Exampaper> exampapers=mapper.queryExampapersBySublessonId(id);
		if (exampapers==null||exampapers.size()==0){
			exampapers=new ArrayList<Exampaper>();
		}
		return exampapers;
	}

	@Override
	public List<Exampaper> queryExampapersByLessonId(Long id) {
		List<Exampaper> exampapers=mapper.queryExampapersByLessonId(id);
		if (exampapers==null||exampapers.size()==0){
			exampapers=new ArrayList<Exampaper>();
		}
		return exampapers;
	}

}
