package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class DiscussionControllerTest {
	private SqlSession session=null;
	private DiscussionController controller;
	private String time;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=DiscussionController.empty(session);
		long time=System.currentTimeMillis();
		this.time=time+"";
	}
	@Test
	public void insertTest(){
		String result1=controller.insertDiscussion((long)1,"这周末实验课什么时间开始？",this.time);
		System.out.println(result1);
		String result2=controller.insertDiscussion((long)10,"这周末实验课什么时间开始？",this.time);
		System.out.println(result2);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteDiscussion((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryDiscussionInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest(){
		String result=controller.queryDiscussionsByLessonId((long)1).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateDiscussion((long)2,(long)2,"期末考试重点考哪些",this.time);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
