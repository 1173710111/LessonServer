package com.neuedu.demo.controller;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.Question;
import com.neuedu.demo.tool.NewSession;


public class QuestionControllerTest {
	private SqlSession session=null;
	private QuestionController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=QuestionController.empty(session);
	}

	@Test
	public void insertTest(){
		String result1=controller.insertQuestion((long)1,"软件构造过程中有哪几种视图？","A.xxx\nB.yyy\nC.zzz\nD.uuu","A");
		System.out.println(result1);
		String result2=controller.insertQuestion((long)1,"卡农","A.aaa\nB.bbb\nC.ccc\nD.ddd","A");
		System.out.println(result2);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteQuestion((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryQuestionInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test 
	public void queryListTest(){
		List<Question> activities=controller.queryQuestionsByExampaperId((long)1);
		System.out.println(activities.toString());
	}
	@Test
	public void updateTest(){
		String result=controller.updateQuestion((long)2,(long)4,"卡农","A.aaa\nB.bbb\nC.ccc\nD.ddd","A");
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
