package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Student;
import com.neuedu.demo.domain.StudentWork;

public interface WorkMemberController {
	public static WorkMemberController empty(SqlSession session){
		WorkMemberController controller=new WorkMemberControllerImpl(session);
		return controller;
	}
	
	public String insertWork(Long workId,Long studentId);
	public String deleteWork(Long workId,Long studentId);
	public List<Student> queryStudentsByWorkId(Long workId);
	public List<StudentWork> queryWorksByStudentId(Long studentId); 

}
