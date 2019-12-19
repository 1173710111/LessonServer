package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.SubLesson;

public interface SubLessonService {
	public static SubLessonService empty(SqlSession session){
		SubLessonServiceImpl service=new SubLessonServiceImpl(session);
		return service;
	}
	public long insertSubLesson(SubLesson sublesson);
	public void deleteSubLesson(Long id);
	public void updateSubLesson(SubLesson sublesson);
	public SubLesson querySubLessonById(Long id);
	public List<SubLesson> querySubLessonsByLessonId(Long lessonId);
	public Long count();
}
