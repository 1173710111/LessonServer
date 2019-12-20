package com.neuedu.domain;

import org.junit.Test;

import com.neuedu.demo.domain.Message;

public class MessageTest {
	@Test
	public void activityToastTest(){
		String str="finished";
		Message message=new Message((long)2,"activityToast",null,null,(long)2,(long)2,(long)0,(long)0,(long)0);
		message.setSender();
		message.makeContent();
		System.out.println(message.getSender());
		System.out.println(message.getContent());
		System.out.println(str);
	}
	@Test
	public void memberDeleteTest(){
		String str="finished";
		Message message=new Message((long)2,"memberDeleteToast",null,null,(long)2,(long)1,(long)0,(long)0,(long)0);
		message.setSender();
		message.makeContent();
		System.out.println(message.getSender());
		System.out.println(message.getContent());
		System.out.println(str);
	}
	@Test
	public void teamAddTest(){
		String str="finished";
		Message message=new Message((long)2,"teamAddToast",null,null,(long)2,(long)2,(long)1,(long)0,(long)0);
		message.setSender();
		message.makeContent();
		System.out.println(message.getSender());
		System.out.println(message.getContent());
		System.out.println(str);
	}
	@Test
	public void myDiscussionTest(){
		String str="finished";
		Message message=new Message((long)2,"myDiscussion",null,null,(long)1,(long)0,(long)0,(long)1,(long)0);
		message.setSender();
		message.makeContent();
		System.out.println(message.getSender());
		System.out.println(message.getContent());
		System.out.println(str);
	}
}

