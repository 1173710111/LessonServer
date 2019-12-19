package com.neuedu.demo.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.LessonMapper;
import com.neuedu.demo.domain.LessonInfo;
@Service
public class LessonServiceImpl implements LessonService {
	private SqlSession session;
	 @Autowired
    private LessonMapper mapper=null; 
	public LessonServiceImpl(SqlSession session){
	   	this.session=session;
	   	mapper=session.getMapper(LessonMapper.class);
    }
	  
	@Override
	public long insertLesson(LessonInfo lesson) {
		long i = mapper.insertLesson(lesson);
		session.commit();
		return i;
	}

	@Override
	public void deleteLesson(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteLesson(id);
			session.commit();
		}
	}

	@Override
	public void updateLesson(LessonInfo lesson) {
		if (mapper.isExistent(lesson.getId())>0){
			mapper.updateLesson(lesson);
			session.commit();
		}
	}

	@Override
	public LessonInfo queryLessonById(Long id) {
		LessonInfo lesson=null;
		if (mapper.isExistent(id)==0){
			lesson=new LessonInfo((long)0,null,null,null,null,null,null,null);
		}else{
			lesson=mapper.queryLessonById(id);
		}
		return lesson;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

}
