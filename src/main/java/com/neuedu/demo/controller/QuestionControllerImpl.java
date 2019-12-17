package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.test.util.TestPropertyValues.Pair;

import com.neuedu.demo.domain.Question;

public class QuestionControllerImpl implements QuestionController {

	public QuestionControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertQuestion(Long exampaperId, String introduction, String options, String answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateQuestion(Long id, Long exampaperId, String introduction, String options, String answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question queryQuestionInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> queryQuestionsByExampaperId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
