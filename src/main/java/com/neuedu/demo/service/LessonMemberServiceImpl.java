package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.dao.LessonMemberMapper;
import com.neuedu.demo.tool.PairLongs;

public class LessonMemberServiceImpl implements LessonMemberService{
	private SqlSession session;
	 @Autowired
    private LessonMemberMapper mapper=null;     
	public LessonMemberServiceImpl(SqlSession session) {
		this.session=session;
    	mapper=session.getMapper(LessonMemberMapper.class);
	}
	@Override
	public void insertLessonMember(PairLongs pair) {
		if(mapper.isExistent(pair)>0)
			return;
		mapper.insertLessonMember(pair);
		session.commit();
	}
	@Override
	public void deleteLessonMember(PairLongs pair) {
		if(mapper.isExistent(pair)>0){
			mapper.deleteLessonMember(pair);
			session.commit();
		}
	}
	@Override
	public List<Long> queryLessonsByMemberId(Long id) {
		List<Long> lessons=new ArrayList<Long>();
		if (mapper.queryLessonsByMemberId(id)==null||mapper.queryLessonsByMemberId(id).size()==0)
			return lessons;
		lessons=mapper.queryLessonsByMemberId(id);
		return lessons;
	}
	@Override
	public List<Long> queryMembersByLessonId(Long id) {
		List<Long> members=new ArrayList<Long>();
		if (mapper.queryMembersByLessonId(id)==null||mapper.queryMembersByLessonId(id).size()==0)
			return members;
		members=mapper.queryMembersByLessonId(id);
		return members;
	}
	@Override
	public Long count() {
		return mapper.count();
	}

	
}
