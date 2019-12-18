package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.dao.LessonTeacherMapper;
import com.neuedu.demo.tool.PairLongs;

public class LessonTeacherServiceImpl implements LessonTeacherService{
	private SqlSession session;
	 @Autowired
    private LessonTeacherMapper mapper=null;     
	public LessonTeacherServiceImpl(SqlSession session) {
		this.session=session;
    	mapper=session.getMapper(LessonTeacherMapper.class);
	}
	@Override
	public void insertLessonTeacher(PairLongs pair) {
		if(mapper.isExistent(pair)>0)
			return;
		mapper.insertLessonTeacher(pair);
		session.commit();
	}
	@Override
	public void deleteLessonTeacher(PairLongs pair) {
		if(mapper.isExistent(pair)>0){
			mapper.deleteLessonTeacher(pair);
			session.commit();
		}
	}
	@Override
	public List<Long> queryLessonsByTeacherId(Long id) {
		List<Long> lessons=new ArrayList<Long>();
		if (mapper.queryLessonsByTeacherId(id)==null||mapper.queryLessonsByTeacherId(id).size()==0)
			return lessons;
		lessons=mapper.queryLessonsByTeacherId(id);
		return lessons;
	}
	@Override
	public List<Long> queryTeachersByLessonId(Long id) {
		List<Long> teachers=new ArrayList<Long>();
		if (mapper.queryTeachersByLessonId(id)==null||mapper.queryTeachersByLessonId(id).size()==0)
			return teachers;
		teachers=mapper.queryTeachersByLessonId(id);
		return teachers;
	}
	@Override
	public Long count() {
		return mapper.count();
	}

	
}
