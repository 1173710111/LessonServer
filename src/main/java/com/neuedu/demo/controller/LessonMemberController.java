package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface LessonMemberController {
	public static LessonMemberController empty(SqlSession session){
		LessonMemberController controller=new LessonMemberControllerImpl(session);
		return controller;
	}
	
	public String insertLessonMember(int lessonId,int MemberId);
	public String deleteLessonMember(int lessonId,int MemberId);
	public List<Integer> queryLessonsByMemberId(Integer id);
	public List<Integer> queryMembersByLessonId(Integer id);
	
}
