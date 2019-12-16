package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Question;

public interface QuestionController {
	public static QuestionController empty(SqlSession session){
		QuestionController controller=new QuestionControllerImpl(session);
		return controller;
	}
	
	public String insertQuestion(Long exampaperId,String introduction,String options,String answer);
	public String deleteQuestion(Long id);
	public String updateQuestion(Long id,Long exampaperId,String introduction,String options,String answer);
	public Question queryQuestionInfoById(Long id);
	public List<Question> queryQuestionsByExampaperId(Long id); 
}

