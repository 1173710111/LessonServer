package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.neuedu.demo.tool.PairLongs;

public interface LessonTeacherService {
	public static LessonTeacherService empty(SqlSession session){
		LessonTeacherServiceImpl service=new LessonTeacherServiceImpl(session);
		return service;
	}
	public void insertLessonTeacher(PairLongs pair);
	public void deleteLessonTeacher(PairLongs pair);
	public List<Long> queryLessonsByTeacherId(Long id);
	public List<Long> queryTeachersByLessonId(Long id);
	public Long count();
}
