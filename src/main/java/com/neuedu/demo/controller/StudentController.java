package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserInfo;

public interface StudentController {
	public static StudentController empty(SqlSession session){
		StudentController controller=new StudentControllerImpl(session);
		return controller;
	}
	
	public String insertStudent(String username,String password,String image);
	public String deleteStudent(Long id);
	public String updateStudent(Long id,String username,String password,String image);
	public UserInfo queryStudentInfoById(Long id);
	public UserInfo queryStudentInfoByName(String name);
	
}
