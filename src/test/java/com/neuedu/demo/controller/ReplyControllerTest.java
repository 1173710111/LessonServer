package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class ReplyControllerTest {
	private SqlSession session=null;
	private ReplyController controller;
	private long time;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=ReplyController.empty(session);
		long time=System.currentTimeMillis();
		this.time=time;
	}
	@Test
	public void insertTest(){
		String result1=controller.insertReply("student",(long)1,this.time+"","秃头少女为何泪洒松花江",(long)1,(long)0);
		System.out.println(result1);
	}
	@Test
	public void insertTest2(){
		String result1=controller.insertReply("teacher",(long)2,this.time+"","以及为何授课老师总是在实验课前收作业",(long)1,(long)2);
		System.out.println(result1);
	}
	@Test
	public void insertFalseTest(){
		String result=controller.insertReply("student",(long)1,this.time+"","秃头少女为何泪洒松花江",(long)1,(long)6);
		System.out.println(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteReply((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryReplyInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest1(){
		String result=controller.queryRepliesByDiscussionId((long)1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest2(){
		String result=controller.queryRepliesByUser("student",(long)1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest3(){
		String result=controller.queryRepliesFollowed((long)2).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateReply((long)2,"student",(long)1,this.time+"","论排课老师为何总是把所有实验考试都排一起",(long)1,(long)1);
		System.out.println(result);
	}
	
	@After
	public void finish(){
		session.close();
	}
}
