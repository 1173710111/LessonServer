package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.QuestionMapper;
import com.neuedu.demo.domain.Question;
@Service
public class QuestionServiceImpl implements QuestionService {
	private SqlSession session;
	@Autowired
    private QuestionMapper mapper=null; 
	public QuestionServiceImpl(SqlSession session) {
		this.session=session;
		mapper=session.getMapper(QuestionMapper.class);
	}

	@Override
	public long insertQuestion(Question question) {
		long i = mapper.insertQuestion(question);
		session.commit();
		return i;
	}

	@Override
	public void deleteQuestion(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteQuestion(id);
			session.commit();
		}
	}

	@Override
	public void updateQuestion(Question question) {
		if (mapper.isExistent(question.getId())>0){
			mapper.updateQuestion(question);
			session.commit();
		}
	}

	@Override
	public Question queryQuestionById(Long id) {
		Question question=null;
		if (mapper.isExistent(id)==0){
			question=new Question((long)0,(long)0,null,null,null);
		}else{
			question=mapper.queryQuestionInfoById(id);
		}
		return question;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

	@Override
	public List<Question> queryQuestionsByExampaperId(Long id) {
		List<Question> questions=mapper.queryQuestionsByExampaperId(id);
		if (questions==null||questions.size()==0){
			questions=new ArrayList<Question>();
		}
		return questions;
	}

	
}
