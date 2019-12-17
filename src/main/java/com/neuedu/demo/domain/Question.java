package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.controller.LessonController;
import com.neuedu.demo.controller.LessonMemberController;

public class Question {
	private long id;
	private long lessonId;
	private long sublessonId;
	private String indroduction;
	private List<String> options;
	private String answer;
	private List<StudentAnswer> studentAnswers;
	public Question(long id, long lessonId, long sublessonId, String indroduction, List<String> options,
			String answer) {
		super();
		this.id = id;
		this.lessonId = lessonId;
		this.sublessonId = sublessonId;
		this.indroduction = indroduction;
		this.options = options;
		this.answer = answer;
		this.studentAnswers=new ArrayList<StudentAnswer>();
		initStudentAnswers();
	}
	public long getId() {
		return id;
	}
	public long getLessonId() {
		return lessonId;
	}
	public long getSublessonId() {
		return sublessonId;
	}
	public String getIndroduction() {
		return indroduction;
	}
	public List<String> getOptions() {
		return options;
	}
	public String getAnswer() {
		return answer;
	}
	public void changeStudentAnswer(long studentId,StudentAnswer studentAnswer){
		for (int i=0;i<this.studentAnswers.size();i++){
			StudentAnswer stdAns=this.studentAnswers.get(i);
			if (stdAns.getStudentId()==studentAnswer.getStudentId()){
				this.studentAnswers.set(i, studentAnswer);
				break;
			}
		}
	}
	private void initStudentAnswers(){
		SqlSession session=NewSession.getSession();
		LessonMemberController controller=LessonMemberController.empty(session);
		List<Long> memberIds=controller.queryMembersByLessonId(this.lessonId);
		int num=memberIds.size();
		for (int i=0;i<num;i++){
			StudentAnswer newStdAns=new StudentAnswer(memberIds.get(i),
					"",0,0,this.id);
			this.studentAnswers.add(newStdAns);
		}
		session.close();
	}
	public StudentAnswer getStudentAnswerById(long studentId){
		StudentAnswer studentAnswer=null;
		for (int i=0;i<this.studentAnswers.size();i++){
			if (this.studentAnswers.get(i).getStudentId()==studentId){
				studentAnswer=this.studentAnswers.get(i);
				break;
			}
		}
		return studentAnswer;
	}
}
