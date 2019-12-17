package com.neuedu.demo.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.NewSession;


public class LessonControllerTest {
	private SqlSession session=null;
	private LessonController controller;
	private String name="软件构造";
	private String introduction="这是一门对你未来的职业生涯有着深远影响的课程。";
	private String timeStart;
	private String timeEnd;
	private String password="software";
	private String image="C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png";
	
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=LessonController.empty(session);
		long time=System.currentTimeMillis();
		this.timeStart=time+"";
		time+=100000;
		this.timeEnd=time+"";
	}
	@Test
	public void timeTest(){
		System.out.println(this.timeStart);
		System.out.println(this.timeEnd);
	}
	@Test
	public void insertTest(){
		String result=controller.insertLesson(this.name,introduction,timeStart,timeEnd,password,image);
		System.out.print(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteLesson((long) 3);
		System.out.print(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryLessonInfoById((long) 1).toString();
		System.out.print(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateLesson((long)4,"计算机网络","应用层-传输层-网络层-数据链路层-物理层",timeStart,timeEnd,"date",image);
		System.out.print(result);
	}
}
