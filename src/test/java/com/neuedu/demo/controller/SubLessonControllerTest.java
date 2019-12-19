package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class SubLessonControllerTest {
	private SqlSession session=null;
	private SubLessonController controller;
	private String name="数据类型";
	private Long lessonId1=(long)1;
	private Long lessonId2=(long)2;
	private String ppt="C:\\Users\\admin\\sts-workspace\\LessonServer";
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=SubLessonController.empty(session);
	}
	@Test
	public void insertTest(){
		controller.insertSubLesson("多维度视图", lessonId1,ppt);
		controller.insertSubLesson("数据类型", lessonId1,ppt);
		controller.insertSubLesson("二叉树遍历", lessonId2,ppt);
		controller.insertSubLesson("广度优先搜索", lessonId2,ppt);
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
		String result=controller.updateSubLesson((long)4,this.name,(long)1,ppt);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
