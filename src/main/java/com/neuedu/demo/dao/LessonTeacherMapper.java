package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.tool.Pair;

@Mapper
public interface LessonTeacherMapper {
	public void insertLessonTeacher(Pair pair);
	public void deleteLessonTeacher(Pair pair);
	public List<Long> queryLessonsByTeacherId(Long id);
	public List<Long> queryTeachersByLessonId(Long id);
	public Integer isExistent(Pair pair);
	public Long count();
}

