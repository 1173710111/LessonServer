package com.neuedu.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.UserInfo;

@Mapper
public interface StudentMapper {
	public int insertStudent(UserInfo userinfo);
	public void deleteStudent(Integer id);
	public void updateStudent(UserInfo userinfo);
	public UserInfo queryStudentById(Integer id);
	public Integer count();
}
