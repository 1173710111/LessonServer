package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.tool.PairLongs;

@Mapper
public interface LessonMemberMapper {
	public void insertLessonMember(PairLongs pair);
	public void deleteLessonMember(PairLongs pair);
	public List<Long> queryLessonsByMemberId(Long id);
	public List<Long> queryMembersByLessonId(Long id);
	public Integer isExistent(PairLongs pair);
	public Long count();
}

