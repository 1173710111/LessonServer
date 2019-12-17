package com.neuedu.demo.service;

import com.neuedu.demo.domain.UserInfo;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.StudentMapper;
@Service
public class StudentServiceImpl implements StudentService {
	 private SqlSession session;
	 @Autowired
     private StudentMapper mapper=null;     
 
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
	public void deleteStudent(Long id) {
		if(mapper.isExistent(id)>0){
			mapper.deleteStudent(id);
			session.commit();
		}
	}

	@Override
	public void updateStudent(UserInfo student) {
		if(mapper.isExistent(student.getId())>0){
			mapper.updateStudent(student);
			session.commit();
		}
	}

	@Override
	public UserInfo queryStudentById(Long id) {
		UserInfo student=null;
		if (mapper.isExistent(id)==0){
			student=new UserInfo(null,null,0,null,null);
		}else{
			student=mapper.queryStudentById(id);
		}
		return student;
	}
	
	@Override 
	public Long count(){
		return mapper.count();
	}

}
