package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserInfo;

public class TeacherControllerImpl implements TeacherController {

	public TeacherControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertTeacher(String username, String password, String image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTeacher(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTeacher(Integer id, String username, String password, String image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo queryTeacherInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
