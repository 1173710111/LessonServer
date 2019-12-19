package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.StudentAnswer;

@Mapper
public interface StudentAnswerMapper {
	public long insertStudentAnswer(StudentAnswer studentAnswer);
	public void deleteStudentAnswer(Long id);
	public void updateStudentAnswer(StudentAnswer studentAnswer);
	public StudentAnswer queryStudentAnswerById(Long id);
	public List<StudentAnswer> queryStudentAnswersByStudentId(Long studentId);
	public List<StudentAnswer> queryStudentAnswersByQuestionId(Long questionId);
	public Long count();
	public Integer isExistent(Long id);
	}
