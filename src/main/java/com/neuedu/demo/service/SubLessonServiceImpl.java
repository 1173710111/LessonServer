package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.SubLessonMapper;
import com.neuedu.demo.domain.SubLesson;
@Service
public class SubLessonServiceImpl implements SubLessonService {
	private SqlSession session;
	 @Autowired
    private SubLessonMapper mapper=null; 
	public SubLessonServiceImpl(SqlSession session) {
		this.session=session;
		mapper=session.getMapper(SubLessonMapper.class);
	}

	@Override
	public long insertSubLesson(SubLesson sublesson) {
		long i = mapper.insertSubLesson(sublesson);
		session.commit();
		return i;
	}

	@Override
	public void deleteSubLesson(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteSubLesson(id);
			session.commit();
		}
	}

	@Override
	public void updateSubLesson(SubLesson sublesson) {
		if (mapper.isExistent(sublesson.getId())>0){
			mapper.updateSubLesson(sublesson);
			session.commit();
		}
	}

	@Override
	public SubLesson querySubLessonById(Long id) {
		SubLesson sublesson=null;
		if (mapper.isExistent(id)==0){
			sublesson=new SubLesson((long)0,(long)0,null,null);
		}else{
			sublesson=mapper.querySubLessonById(id);
		}
		return sublesson;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

	@Override
	public List<SubLesson> querySubLessonsByLessonId(Long lessonId) {
		List<SubLesson> sublessons=mapper.querySubLessonsByLessonId(lessonId);
		if (sublessons==null||sublessons.size()==0){
			return new ArrayList<SubLesson>();
		}else{
			return mapper.querySubLessonsByLessonId(lessonId);
		}
	}

}
