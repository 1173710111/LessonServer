package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.StudentAnswerMapper;
import com.neuedu.demo.domain.StudentAnswer;
@Service
public class StudentAnswerServiceImpl implements StudentAnswerService {
	private SqlSession session;
	 @Autowired
    private StudentAnswerMapper mapper=null; 
	public StudentAnswerServiceImpl(SqlSession session) {
		this.session=session;
		mapper=session.getMapper(StudentAnswerMapper.class);
	}

	@Override
	public long insertStudentAnswer(StudentAnswer studentAnswer) {
		long i = mapper.insertStudentAnswer(studentAnswer);
		session.commit();
		return i;
	}

	@Override
	public void deleteStudentAnswer(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteStudentAnswer(id);
			session.commit();
		}
	}

	@Override
	public void updateStudentAnswer(StudentAnswer studentAnswer) {
		if (mapper.isExistent(studentAnswer.getId())>0){
			mapper.updateStudentAnswer(studentAnswer);
			session.commit();
		}
	}

	@Override
	public StudentAnswer queryStudentAnswerById(Long id) {
		StudentAnswer StudentAnswer=null;
		if (mapper.isExistent(id)==0){
			StudentAnswer=new StudentAnswer((long)0,(long)0,(long)0,null,0,0);
		}else{
			StudentAnswer=mapper.queryStudentAnswerById(id);
		}
		return StudentAnswer;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

	@Override
	public List<StudentAnswer> queryStudentAnswersByStudentId(Long studentId) {
		List<StudentAnswer> answers=mapper.queryStudentAnswersByStudentId(studentId);
		if (answers==null||answers.size()==0){
			return new ArrayList<StudentAnswer>();
		}else{
			return answers;
		}
	}

	@Override
	public List<StudentAnswer> queryStudentAnswersByQuestionId(Long questionId) {
		if (mapper.queryStudentAnswersByQuestionId(questionId)==null||mapper.queryStudentAnswersByQuestionId(questionId).size()==0){
			return new ArrayList<StudentAnswer>();
		}else{
			return mapper.queryStudentAnswersByQuestionId(questionId);
		}
	}

}
