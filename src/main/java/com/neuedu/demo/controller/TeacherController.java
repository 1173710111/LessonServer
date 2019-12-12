package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserInfo;

public interface TeacherController {
	public static TeacherController empty(SqlSession session){
		TeacherController controller=new TeacherControllerImpl(session);
		return controller;
	}
	
	public String insertTeacher(String username,String password,String image);
	public String deleteTeacher(Integer id);
	public String updateTeacher(Integer id,String username,String password,String image);
	public UserInfo queryTeacherInfoById(Integer id);
}
