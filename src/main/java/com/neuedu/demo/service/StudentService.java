package com.neuedu.demo.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserInfo;

public interface StudentService {
	public static StudentService empty(SqlSession session){
		StudentServiceImpl service=new StudentServiceImpl(session);
		return service;
	}
	
	public int insertStudent(UserInfo student);
	public void deleteStudent(Integer id);
	public void updateStudent(UserInfo student);
	public UserInfo queryStudentById(Integer id);
	public Integer count();
}
