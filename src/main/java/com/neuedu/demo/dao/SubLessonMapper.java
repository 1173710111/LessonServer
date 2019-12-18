package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.SubLesson;

@Mapper
public interface SubLessonMapper {
	public int insertSubLesson(SubLesson sublesson);
	public void deleteSubLesson(Long id);
	public void updateSubLesson(SubLesson sublesson);
	public SubLesson querySubLessonById(Long id);
	public Long count();
	public Integer isExistent(Long id);
	public List<SubLesson> querySubLessonsByLessonId(Long lessonId);
}
