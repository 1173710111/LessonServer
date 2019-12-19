package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Question;

@Mapper
public interface QuestionMapper {
	public long insertQuestion(Question question);
	public void deleteQuestion(Long id);
	public void updateQuestion(Question question);
	public Question queryQuestionById(Long id);
	public Long count();
	public Integer isExistent(Long id);
	public List<Question> queryActivitiesByLessonId(Long id);
}
