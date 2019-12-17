package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.NewSession;


public class TeacherControllerTest {
	private SqlSession session;
	private TeacherController controller;
	private String username="啊普路派";
	private String password="nengtianshi";
	private String image="C:\\Users\\admin\\Desktop\\HIT\\images\\logo2.png";
	
	@Before
	public void init(){
		session=NewSession.getSession();
		this.controller=TeacherController.empty(session);
	}
	
	@Test
	public void insertTest(){
		String result=controller.insertTeacher(username, password, image);
		System.out.print(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteTeacher((long) 1);
		System.out.print(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryTeacherInfoById((long) 5).toString();
		System.out.print(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateTeacher((long) 2,"yyy", "654321", image);
		System.out.print(result);
	}
}
