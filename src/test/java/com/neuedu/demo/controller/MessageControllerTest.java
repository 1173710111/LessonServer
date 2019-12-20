package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.Message;
import com.neuedu.demo.tool.NewSession;


public class MessageControllerTest {
	private SqlSession session=null;
	private MessageController controller;
	private Message message;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=MessageController.empty(session);
		Message message=new Message((long)2,"activityToast",null,null,(long)2,(long)2,(long)0,(long)0,(long)0);
		message.setSender();
		message.makeContent();
		this.message=message;
	}
	@Test
	public void insertActivityToastTest(){
		Message message=new Message((long)0,"activityToast",null,null,(long)1,(long)1,(long)0,(long)0,(long)0);
		String sender=message.setSender();
		message.makeContent();
		String content=message.getContent();
		System.out.println(sender);
		System.out.println(content);
		System.out.println("finished");
		
		String result=controller.insertMessage(message.getType(),message.getSender(),message.getContent(),
				message.getLessonId(),message.getActivityId(),message.getWorkId(),message.getDiscussionId(),message.getReplyId());
		System.out.println(result);
	}
	
	@Test
	public void insertMemberDeleteToastTest(){
		Message message=new Message((long)2,"memberDeleteToast",null,null,(long)2,(long)1,(long)0,(long)0,(long)0);
		message.setSender();
		message.makeContent();
		System.out.println(message.getSender());
		System.out.println(message.getContent());
		System.out.println("finished");
		
		String result=controller.insertMessage(message.getType(),message.getSender(),message.getContent(),
				message.getLessonId(),message.getActivityId(),message.getWorkId(),message.getDiscussionId(),message.getReplyId());
		System.out.println(result);
	}
	
	@Test
	public void insertTeamAddToastTest(){
		Message message=new Message((long)2,"teamAddToast",null,null,(long)2,(long)2,(long)1,(long)0,(long)0);
		message.setSender();
		message.makeContent();
		System.out.println(message.getSender());
		System.out.println(message.getContent());
		System.out.println("finished");
		
		String result=controller.insertMessage(message.getType(),message.getSender(),message.getContent(),
				message.getLessonId(),message.getActivityId(),message.getWorkId(),message.getDiscussionId(),message.getReplyId());
		System.out.println(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteMessage((long) 5);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryMessageInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest(){
		String result=controller.queryMessagesBylessonId((long)1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest2(){
		String result=controller.queryMessagesByType("activityToast").toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateMessage(message.getId(),message.getType(),message.getSender(),message.getContent(),
				message.getLessonId(),message.getActivityId(),message.getWorkId(),message.getDiscussionId(),message.getReplyId());
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
