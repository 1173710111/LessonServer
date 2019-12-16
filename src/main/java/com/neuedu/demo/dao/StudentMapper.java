package com.neuedu.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.UserInfo;

@Mapper
public interface StudentMapper {
	public int insertStudent(UserInfo userinfo);
	public void deleteStudent(Long id);
	public void updateStudent(UserInfo userinfo);
	public UserInfo queryStudentById(Long id);
	public Long count();
	public Integer isExistent(Long id);
}
