package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.tool.PairLongs;

@Mapper
public interface LessonTeacherMapper {
	public void insertLessonTeacher(PairLongs pair);
	public void deleteLessonTeacher(PairLongs pair);
	public List<Long> queryLessonsByTeacherId(Long id);
	public List<Long> queryTeachersByLessonId(Long id);
	public Integer isExistent(PairLongs pair);
	public Long count();
}

