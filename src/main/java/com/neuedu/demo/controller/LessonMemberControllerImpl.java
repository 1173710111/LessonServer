package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.service.LessonMemberService;
import com.neuedu.demo.tool.Pair;

public class LessonMemberControllerImpl implements LessonMemberController {
	@Autowired
	private LessonMemberService service;
	public LessonMemberControllerImpl(SqlSession session) {
		this.service=LessonMemberService.empty(session);
	}

	@Override
	public String insertLessonMember(Long lessonId, Long MemberId) {
		Pair pair=new Pair(lessonId,MemberId);
		Long cnt=service.count();
		service.insertLessonMember(pair);
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success";
		}else{
			return "false";
		}
	}

	@Override
	public String deleteLessonMember(Long lessonId, Long MemberId) {
		Pair pair=new Pair(lessonId,MemberId);
		Long cnt=service.count();
		service.deleteLessonMember(pair);
		Long cnt_after=service.count();
		cnt--;
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public List<Long> queryLessonsByMemberId(Long id) {
		return service.queryLessonsByMemberId(id);
	}

	@Override
	public List<Long> queryMembersByLessonId(Long id) {
		return service.queryMembersByLessonId(id);
	}

	
}
