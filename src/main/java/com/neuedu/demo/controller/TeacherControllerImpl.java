package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.UserInfo;
import com.neuedu.demo.service.TeacherService;
@Controller
public class TeacherControllerImpl implements TeacherController {
	@Autowired
	private TeacherService service;
	public TeacherControllerImpl(SqlSession session) {
		this.service=TeacherService.empty(session);
	}

	@Override
	public String insertTeacher(String username, String password, String image) {
		UserInfo teacher=new UserInfo(username,password,0,image,"teacher");
		Long cnt=service.count();
		service.insertTeacher(teacher);
		long id = teacher.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteTeacher(Long id) {
		Long cnt=service.count();
		service.deleteTeacher(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateTeacher(Long id, String username, String password, String image) {
		UserInfo teacher=new UserInfo(username,password,id,image,"teacher");
		service.updateTeacher(teacher);
		UserInfo teacherAfter=this.queryTeacherInfoById(id);
		if (teacherAfter.toString().equals(teacher.toString())){
			return "success:"+teacher.toString();
		}else{
			return "false:"+teacherAfter.toString();
		}
	}

	@Override
	public UserInfo queryTeacherInfoById(Long id) {
		UserInfo teacher=service.queryTeacherById(id);
		UserInfo newTeacher=new UserInfo(teacher.getUsername(),teacher.getPassword(),teacher.getId(),teacher.getImage(),"teacher");
		return newTeacher;
	}

}
