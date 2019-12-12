package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Question;

public class QuestionControllerImpl implements QuestionController {

	public QuestionControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertQuestion(Integer exampaperId, String introduction, String options, String answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuestion(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateQuestion(Integer id, Integer exampaperId, String introduction, String options, String answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question queryQuestionInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> queryQuestionsByExampaperId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
