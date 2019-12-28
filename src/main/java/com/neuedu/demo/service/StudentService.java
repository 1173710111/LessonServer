package com.neuedu.demo.service;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserInfo;

public interface StudentService {
	public static StudentService empty(SqlSession session){
		StudentServiceImpl service=new StudentServiceImpl(session);
		return service;
	}
	
	public long insertStudent(UserInfo student);
	public void deleteStudent(Long id);
	public void updateStudent(UserInfo student);
	public UserInfo queryStudentById(Long id);
	public Long count();
	public UserInfo queryStudentByName(String name);
	
}
