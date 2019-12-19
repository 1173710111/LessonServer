package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.NewSession;


public class SubLessonControllerTest {
	private SqlSession session=null;
	private SubLessonController controller;
	private String name="数据类型";
	private Long lessonId1=(long)1;
	private Long lessonId2=(long)2;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=SubLessonController.empty(session);
	}
	@Test
	public void insertTest(){
		controller.insertSubLesson("多维度视图", lessonId1);
		controller.insertSubLesson("数据类型", lessonId1);
		controller.insertSubLesson("二叉树遍历", lessonId2);
		controller.insertSubLesson("广度优先搜索", lessonId2);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteSubLesson((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.querySubLessonInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test
	public void queryListTest(){
		String result=controller.querySubLessonsByLessonId((long)1).toString();
		System.out.println(result);
	}
	@Test
	public void updateTest(){
		String result=controller.updateSubLesson((long)4,this.name,1);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
