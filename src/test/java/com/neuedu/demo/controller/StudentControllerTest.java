package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class StudentControllerTest {
	private SqlSession session=null;
	private StudentController controller;
	private String username="拉普兰德做得到吗";
	private String password="lagouzi";
	private String image="C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png";
	
	@Before
	public void init(){
		session = NewSession.getSession();
		this.controller=StudentController.empty(session);
	}
	
	@Test
	public void insertTest(){
		String result=controller.insertStudent(username, password, image);
		System.out.println(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteStudent((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryStudentInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateStudent((long) 2,"拉普兰德做得到吗", "654321", image);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
