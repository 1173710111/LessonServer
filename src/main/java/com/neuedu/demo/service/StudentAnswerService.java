package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.StudentAnswer;

public interface StudentAnswerService {
	public static StudentAnswerService empty(SqlSession session){
		StudentAnswerServiceImpl service=new StudentAnswerServiceImpl(session);
		return service;
	}
	public long insertStudentAnswer(StudentAnswer studentAnswer);
	public void deleteStudentAnswer(Long id);
	public void updateStudentAnswer(StudentAnswer studentAnswer);
	public StudentAnswer queryStudentAnswerById(Long id);
	public List<StudentAnswer> queryStudentAnswersByStudentId(Long studentId);
	public List<StudentAnswer> queryStudentAnswersByQuestionId(Long questionId);
	public Long count();
}
