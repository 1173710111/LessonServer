package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface LessonMemberController {
	public static LessonMemberController empty(SqlSession session){
		LessonMemberController controller=new LessonMemberControllerImpl(session);
		return controller;
	}
	
	public String insertLessonMember(Long lessonId,Long MemberId);
	public String deleteLessonMember(Long lessonId,Long MemberId);
	public List<Long> queryLessonsByMemberId(Long id);
	public List<Long> queryMembersByLessonId(Long id);
	
}
