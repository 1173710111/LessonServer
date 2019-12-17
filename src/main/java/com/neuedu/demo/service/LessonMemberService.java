package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.LessonInfo;
import com.neuedu.demo.tool.Pair;

public interface LessonMemberService {
	public static LessonMemberService empty(SqlSession session){
		LessonMemberServiceImpl service=new LessonMemberServiceImpl(session);
		return service;
	}
	public void insertLessonMember(Pair pair);
	public void deleteLessonMember(Pair pair);
	public List<Long> queryLessonsByMemberId(Long id);
	public List<Long> queryMembersByLessonId(Long id);
	public Long count();
}
