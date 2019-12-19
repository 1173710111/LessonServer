package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.Question;
import com.neuedu.demo.service.QuestionService;
@Controller
public class QuestionControllerImpl implements QuestionController {

	private SqlSession session;
	@Autowired
	private QuestionService service;
	public QuestionControllerImpl(SqlSession session) {
		this.service=QuestionService.empty(session);
		this.session=session;
	}
	@Override
	public String insertQuestion(Long exampaperId,String introduction,String options,String answer) {
		ExampaperController controller=ExampaperController.empty(session);
		if (controller.queryExampaperInfoById(exampaperId).getId()==0){
			return "false:cannot find Exampaper["+exampaperId+"].";
		}
		Question question=new Question((long)0,exampaperId,introduction,options,answer);
		Long cnt=service.count();
		service.insertQuestion(question);
		long id = question.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}


	@Override
	public String deleteQuestion(Long id) {
		Long cnt=service.count();
		service.deleteQuestion(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}
	@Override
	public String updateQuestion(Long id,Long exampaperId,String introduction,String options,String answer) {
		ExampaperController controller=ExampaperController.empty(session);
		if (controller.queryExampaperInfoById(exampaperId).getId()==0){
			return "false:cannot find Exampaper["+exampaperId+"].";
		}
		Question question=new Question(id,exampaperId,introduction,options,answer);
		service.updateQuestion(question);
		Question questionAfter=service.queryQuestionById(id);
		if (questionAfter.toString().equals(question.toString())){
			return "success:"+question.toString();
		}else{
			return "false:"+questionAfter.toString();
		}
	}

	

	@Override
	public Question queryQuestionInfoById(Long id) {
		Question Question=service.queryQuestionById(id);
		return Question;
	}

	@Override
	public List<Question> queryQuestionsByExampaperId(Long id) {
		List<Question> questions=service.queryQuestionsByExampaperId(id);
		return questions;
	}
}
