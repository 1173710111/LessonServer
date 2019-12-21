package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;
import com.neuedu.demo.tool.Pair;


public class UserMessageControllerTest {
	private SqlSession session=null;
	private UserMessageController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=UserMessageController.empty(session);
	}
	@Test
	public void insertTest(){
		String result=controller.insertUserMessage((long)1,"student",(long)1);
		System.out.println(result);
	}
	@Test
	public void insertTest2(){
		String result=controller.insertUserMessage((long)1,"student",(long)2);
		System.out.println(result);
	}
	@Test
	public void insertTest3(){
		String result=controller.insertUserMessage((long)2,"student",(long)2);
		System.out.println(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteUserMessage((long)2,"student",(long)2);
		System.out.println(result);
	}
	@Test
	public void queryListTest1(){
		List<Long> messages=controller.queryUserMessages("student", (long)2);
		System.out.println(messages.toString());
	}
	@Test
	public void queryListTest2(){
		List<Pair> users=controller.queryMessageUsersByMessageId((long)1);
		System.out.println(users.toString());
	}
	
	@After
	public void finish(){
		session.close();
	}
}
