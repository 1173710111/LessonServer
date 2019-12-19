package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public interface WorkMemberController {
	public static WorkMemberController empty(SqlSession session){
		WorkMemberController controller=new WorkMemberControllerImpl(session);
		return controller;
	}
	
	public String insertWorkMember(Long workId,Long studentId);
	public String deleteWorkMember(Long workId,Long studentId);
	public List<Long> queryStudentsByWorkId(Long workId);
	public List<Long> queryWorksByStudentId(Long studentId); 

}
