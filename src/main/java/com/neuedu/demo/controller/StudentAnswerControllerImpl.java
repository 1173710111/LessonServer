package com.neuedu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.StudentAnswer;
import com.neuedu.demo.service.StudentAnswerService;
@Controller
public class StudentAnswerControllerImpl implements StudentAnswerController {

	@Autowired
	private StudentAnswerService service;
	private SqlSession session=null;
	public StudentAnswerControllerImpl(SqlSession session) {
		this.session=session;
		this.service=StudentAnswerService.empty(session);
	}

	@Override
	public String insertStudentAnswer(Long questionId,Long studentId,String answer,int finishedState,int starState) {
		StudentController controller=StudentController.empty(session);
		if (controller.queryStudentInfoById(studentId).getId()==0){
			return "false:cannot find student["+studentId+"].";
		}
		QuestionController controller2=QuestionController.empty(session);
		if (controller2.queryQuestionInfoById(questionId).getId()==0){
			return "false:cannot find question["+questionId+"].";
		}
		StudentAnswer studentAnswer=new StudentAnswer((long)0,questionId,studentId,answer,finishedState,starState);
		Long cnt=service.count();
		service.insertStudentAnswer(studentAnswer);
		Long cnt_after=service.count();
		long id = studentAnswer.getId();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteStudentAnswer(Long id) {
		Long cnt=service.count();
		service.deleteStudentAnswer(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateStudentAnswer(Long id,Long questionId,Long studentId,String answer,int finishedState,int starState) {
		StudentController controller=StudentController.empty(session);
		if (controller.queryStudentInfoById(studentId).getId()==0){
			return "false:cannot find student["+studentId+"].";
		}
		QuestionController controller2=QuestionController.empty(session);
		if (controller2.queryQuestionInfoById(questionId).getId()==0){
			return "false:cannot find question["+questionId+"].";
		}
		StudentAnswer studentAnswer=new StudentAnswer(id,questionId,studentId,answer,finishedState,starState);
		service.updateStudentAnswer(studentAnswer);
		StudentAnswer StudentAnswerAfter=service.queryStudentAnswerById(id);
		if (StudentAnswerAfter.toString().equals(studentAnswer.toString())){
			return "success:"+studentAnswer.toString();
		}else{
			return "false:"+StudentAnswerAfter.toString();
		}
	}

	@Override
	public StudentAnswer queryStudentAnswerInfoById(Long id) {
		StudentAnswer StudentAnswer=service.queryStudentAnswerById(id);
		return StudentAnswer;
	}

	@Override
	public List<StudentAnswer> queryStudentAnswersByStudentId(Long studentId) {
		List<StudentAnswer> StudentAnswers=new ArrayList<StudentAnswer>(service.queryStudentAnswersByStudentId(studentId));
		return StudentAnswers;
	}

	@Override
	public List<StudentAnswer> queryStudentAnswersByQuestionId(Long questionId) {
		List<StudentAnswer> StudentAnswers=new ArrayList<StudentAnswer>(service.queryStudentAnswersByQuestionId(questionId));
		return StudentAnswers;
	}

}
