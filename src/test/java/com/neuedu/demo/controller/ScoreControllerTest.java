package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class ScoreControllerTest {
	private SqlSession session=null;
	private ScoreController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=ScoreController.empty(session);
	}
	@Test
	public void insertTest(){
		String result1=controller.insertScore((long)12,(long)5, (long)6, (long)1, (long)1);
		System.out.println(result1);
		String result2=controller.insertScore((long)12,(long)6, (long)2, (long)4, (long)10);
		System.out.println(result2);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteScore((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryScoreInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void queryTest2(){
		String result=controller.queryScoresByExampaperId((long)1).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateScore((long)2, (long)15, (long)3, (long)10, (long)2, (long)4);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
