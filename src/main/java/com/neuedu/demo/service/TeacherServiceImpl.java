package com.neuedu.demo.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.dao.StudentMapper;
import com.neuedu.demo.dao.TeacherMapper;
import com.neuedu.demo.domain.UserInfo;

public class TeacherServiceImpl implements TeacherService {
	private SqlSession session;
	@Autowired
    private TeacherMapper mapper=null;   
	
	public TeacherServiceImpl(SqlSession session) {
		this.session = session;
		mapper=session.getMapper(TeacherMapper.class);
	}

	@Override
	public int insertTeacher(UserInfo teacher) {
		int i = mapper.insertTeacher(teacher);
		session.commit();
		return i;
	}

	@Override
	public void deleteTeacher(Long id) {
		mapper.deleteTeacher(id);
		session.commit();
	}

	@Override
	public void updateTeacher(UserInfo teacher) {
		mapper.updateTeacher(teacher);
		session.commit();
	}

	@Override
	public UserInfo queryTeacherById(Long id) {
		UserInfo teacher=null;
		if (mapper.isExistent(id)==0){
			System.out.println("not find");
			teacher=new UserInfo(null,null,0,null,null);
		}else{
			teacher=mapper.queryTeacherById(id);
		}
		return teacher;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

}
