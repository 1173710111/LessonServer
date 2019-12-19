package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.StudentWork;
import com.neuedu.demo.tool.NewSession;


public class WorkControllerTest {
	private SqlSession session=null;
	private WorkController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=WorkController.empty(session);
	}

	@Test
	public void insertTest1(){
		String result1=controller.insertWork((long)2);
		System.out.println(result1);
	}
	@Test
	public void insertTest2(){
		String result2=controller.insertWork((long)10);
		System.out.println(result2);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteWork((long) 7);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryWorkInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test 
	public void queryListTest(){
		List<StudentWork> activities=controller.queryWorksByActivityId((long)1);
		System.out.println(activities.toString());
	}
	@Test
	public void updateTest(){
		String result=controller.updateWork((long)2,(long)2);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
