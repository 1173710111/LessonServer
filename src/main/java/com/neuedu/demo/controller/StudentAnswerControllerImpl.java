package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.StudentAnswer;

public class StudentAnswerControllerImpl implements StudentAnswerController {

	public StudentAnswerControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertStudentAnswer(Integer questionId, Integer StudentId, String answer, int finishedState,
			int starState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudentAnswer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudentAnswer(Integer id, Integer questionId, Integer StudentId, String answer,
			int finishedState, int starState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentAnswer queryStudentAnswerInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentAnswer> queryStudentAnswersByStudentId(Integer studentID) {
		// TODO Auto-generated method stub
		return null;
	}

}
