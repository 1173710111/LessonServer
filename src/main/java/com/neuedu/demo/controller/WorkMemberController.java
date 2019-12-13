package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Student;
import com.neuedu.demo.domain.Work;

public interface WorkMemberController {
	public static WorkMemberController empty(SqlSession session){
		WorkMemberController controller=new WorkMemberControllerImpl(session);
		return controller;
	}
	
	public String insertWork(Integer workId,Integer studentId);
	public String deleteWork(Integer workId,Integer studentId);
	public List<Student> queryStudentsByWorkId(Integer workId);
	public List<Work> queryWorksByStudentId(Integer studentId); 

}
