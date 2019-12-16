package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.StudentAnswer;

public interface StudentAnswerController {
	public static StudentAnswerController empty(SqlSession session){
		StudentAnswerController controller=new StudentAnswerControllerImpl(session);
		return controller;
	}
	
	public String insertStudentAnswer(Long questionId,Long StudentId,String answer,int finishedState,int starState);
	public String deleteStudentAnswer(Long id);
	public String updateStudentAnswer(Long id,Long questionId,Long StudentId,String answer,int finishedState,int starState);
	public StudentAnswer queryStudentAnswerInfoById(Long id);
	public List<StudentAnswer> queryStudentAnswersByStudentId(Long studentID);
}
