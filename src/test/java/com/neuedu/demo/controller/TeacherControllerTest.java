package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


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
		System.out.println(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteTeacher((long) 1);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryTeacherInfoById((long) 5).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateTeacher((long) 2,"yyy", "654321", image);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
