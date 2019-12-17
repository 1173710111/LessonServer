package com.neuedu.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.LessonInfo;

@Mapper
public interface LessonMapper {
	public int insertLesson(LessonInfo lessoninfo);
	public void deleteLesson(Long id);
	public void updateLesson(LessonInfo lessoninfo);
	public LessonInfo queryLessonById(Long id);
	public Long count();
	public Integer isExistent(Long id);
}
