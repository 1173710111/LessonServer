package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserInfo;

public interface StudentController {
	public static StudentController empty(SqlSession session){
		StudentController controller=new StudentControllerImpl(session);
		return controller;
	}
	
	public String insertStudent(String username,String password,String image);
	public String deleteStudent(Integer id);
	public String updateStudent(Integer id,String username,String password,String image);
	public UserInfo queryStudentInfoById(Integer id);
	
}
