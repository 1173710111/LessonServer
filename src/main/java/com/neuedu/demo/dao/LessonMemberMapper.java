package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.tool.Pair;

@Mapper
public interface LessonMemberMapper {
	public void insertLessonMember(Pair pair);
	public void deleteLessonMember(Pair pair);
	public List<Long> queryLessonsByMemberId(Long id);
	public List<Long> queryMembersByLessonId(Long id);
	public Integer isExistent(Pair pair);
	public Long count();
}

