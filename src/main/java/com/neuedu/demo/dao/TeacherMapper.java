package com.neuedu.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.UserInfo;

@Mapper
public interface TeacherMapper {
	public long insertTeacher(UserInfo userinfo);
	public void deleteTeacher(Long id);
	public void updateTeacher(UserInfo userinfo);
	public UserInfo queryTeacherById(Long id);
	public Long count();
	public Integer isExistent(Long id);
	public UserInfo queryTeacherByName(String name);
}
