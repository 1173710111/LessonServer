package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.StudentAnswer;

public interface StudentAnswerController {
	public static StudentAnswerController empty(SqlSession session){
		StudentAnswerController controller=new StudentAnswerControllerImpl(session);
		return controller;
	}
	
	public String insertStudentAnswer(Integer questionId,Integer StudentId,String answer,int finishedState,int starState);
	public String deleteStudentAnswer(Integer id);
	public String updateStudentAnswer(Integer id,Integer questionId,Integer StudentId,String answer,int finishedState,int starState);
	public StudentAnswer queryStudentAnswerInfoById(Integer id);
	public List<StudentAnswer> queryStudentAnswersByStudentId(Integer studentID);
}
