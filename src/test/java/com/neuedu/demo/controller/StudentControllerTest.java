package com.neuedu.demo.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


public class StudentControllerTest {
	private SqlSession session=null;
	private StudentController controller;
	private String username="拉普兰德做得到吗";
	private String password="123456";
	private String image="C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png";
	
	@Before
	public void init(){
		String resource = "mybatis-config.xml";
    	InputStream inputStream = null;
    	SqlSessionFactory sqlSessionFactory=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		this.controller=StudentController.empty(session);
	}
	
	@Test
	public void insertTest(){
		String result=controller.insertStudent(username, password, image);
		System.out.print(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteStudent(3);
		System.out.print(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryStudentInfoById(1).toString();
		System.out.print(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateStudent(2,"拉普兰德做得到吗", "654321", image);
		System.out.print(result);
	}
}
