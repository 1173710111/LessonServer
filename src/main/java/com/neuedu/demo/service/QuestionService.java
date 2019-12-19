package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Question;

public interface QuestionService {
	public static QuestionService empty(SqlSession session){
		QuestionServiceImpl service=new QuestionServiceImpl(session);
		return service;
	}
	public long insertQuestion(Question Question);
	public void deleteQuestion(Long id);
	public void updateQuestion(Question Question);
	public Question queryQuestionById(Long id);
	public Long count();
	public List<Question> queryQuestionsByExampaperId(Long id);
}
