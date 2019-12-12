package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Question;

public interface QuestionController {
	public static QuestionController empty(SqlSession session){
		QuestionController controller=new QuestionControllerImpl(session);
		return controller;
	}
	
	public String insertQuestion(Integer exampaperId,String introduction,String options,String answer);
	public String deleteQuestion(Integer id);
	public String updateQuestion(Integer id,Integer exampaperId,String introduction,String options,String answer);
	public Question queryQuestionInfoById(Integer id);
	public List<Question> queryQuestionsByExampaperId(Integer id); 
}

