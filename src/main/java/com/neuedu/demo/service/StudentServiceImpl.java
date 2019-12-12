package com.neuedu.demo.service;

import com.neuedu.demo.domain.UserInfo;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.StudentMapper;
@Service
public class StudentServiceImpl implements StudentService {
	 private static SqlSession session;
	 @Autowired
     private static StudentMapper mapper=null;     
 
    public StudentServiceImpl(SqlSession session){
    	this.session=session;
    	mapper=session.getMapper(StudentMapper.class);
    }
  
	@Override
	public int insertStudent(UserInfo student) {
		int i = mapper.insertStudent(student);
		session.commit();
		return i;
	}

	@Override
	public void deleteStudent(Integer id) {
		mapper.deleteStudent(id);
		session.commit();
	}

	@Override
	public void updateStudent(UserInfo student) {
		mapper.updateStudent(student);
		session.commit();
	}

	@Override
	public UserInfo queryStudentById(Integer id) {
		UserInfo student=mapper.queryStudentById(id);
		session.commit();
		return student;
	}
	
	@Override 
	public Integer count(){
		return mapper.count();
	}

}
