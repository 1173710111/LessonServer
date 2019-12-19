package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class StudentAnswerControllerTest {
	private SqlSession session=null;
	private StudentAnswerController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=StudentAnswerController.empty(session);
	}
	@Test
	public void insertTest(){
		String result1=controller.insertStudentAnswer((long)1, (long)1,"B", 1, 0);
		System.out.println(result1);
		String result2=controller.insertStudentAnswer((long)10, (long)1,"B", 1, 0);
		System.out.println(result2);
		String result3=controller.insertStudentAnswer((long)1, (long)10,"B", 1, 0);
		System.out.println(result3);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteStudentAnswer((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryStudentAnswerInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest1(){
		String result=controller.queryStudentAnswersByStudentId((long)1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest2(){
		String result=controller.queryStudentAnswersByQuestionId((long)1).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateStudentAnswer((long)4,(long)2, (long)1,"B", 1, 1);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
