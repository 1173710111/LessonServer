package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class UserDiscussionControllerTest {
	private SqlSession session=null;
	private UserDiscussionController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=UserDiscussionController.empty(session);
	}
	@Test
	public void insertTest(){
		String result1=controller.insertUserDiscussion((long)2,"student",(long)2,0);
		System.out.println(result1);
		String result2=controller.insertUserDiscussion((long)8,"student",(long)5,0);
		System.out.println(result2);
		String result3=controller.insertUserDiscussion((long)2,"student",(long)20,0);
		System.out.println(result3);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteUserDiscussion((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryUserDiscussionById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest(){
		String result=controller.queryUserDiscussionsByDiscussionId((long)2).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateUserDiscussionState((long)2,1);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
