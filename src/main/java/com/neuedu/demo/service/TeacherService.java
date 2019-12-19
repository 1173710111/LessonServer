package com.neuedu.demo.service;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserInfo;

public interface TeacherService {
	public static TeacherService empty(SqlSession session){
		TeacherServiceImpl service=new TeacherServiceImpl(session);
		return service;
	}
	
	public long insertTeacher(UserInfo teacher);
	public void deleteTeacher(Long id);
	public void updateTeacher(UserInfo teacher);
	public UserInfo queryTeacherById(Long id);
	public Long count();
}
