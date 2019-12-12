package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.UserInfo;
import com.neuedu.demo.service.StudentService;

@Controller
public class StudentControllerImpl implements StudentController  {
	@Autowired
	private StudentService service;
	
	public StudentControllerImpl(SqlSession session){
		this.service=StudentService.empty(session);
	}
	
	@Override
	public String insertStudent(String username,String password,String image){
		UserInfo student=new UserInfo(username,password,0,image,"student");
		Integer cnt=service.count();
		service.insertStudent(student);
		long id = student.getId();
		Integer cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
		
	}
	@Override
	public String deleteStudent(Integer id) {
		Integer cnt=service.count();
		service.deleteStudent(id);
		cnt--;
		Integer cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}
	@Override
	public String updateStudent(Integer id, String username, String password, String image) {
		UserInfo student=new UserInfo(username,password,id,image,"student");
		service.updateStudent(student);
		UserInfo studentAfter=this.queryStudentInfoById(id);
		if (studentAfter.toString().equals(student.toString())){
			return "success:"+student.toString();
		}else{
			return "false:"+studentAfter.toString();
		}
	}
	@Override
	public UserInfo queryStudentInfoById(Integer id) {
		UserInfo student=service.queryStudentById(id);
		UserInfo newStudent=new UserInfo(student.getUsername(),student.getPassword(),student.getId(),student.getImage(),"student");
		return newStudent;
	}
}
