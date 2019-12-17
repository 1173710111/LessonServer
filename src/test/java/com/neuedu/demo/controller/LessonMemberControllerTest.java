package com.neuedu.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.AccessException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.NewSession;


public class LessonMemberControllerTest {
	private SqlSession session=null;
	private LessonMemberController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=LessonMemberController.empty(session);
	}
	@Test
	public void insertTest(){
		String result=controller.insertLessonMember((long)1,(long)2);
		controller.insertLessonMember((long)1, (long)3);
		controller.insertLessonMember((long)2, (long)2);
		controller.insertLessonMember((long)4, (long)2);
		controller.insertLessonMember((long)2, (long)4);
		System.out.print(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteLessonMember((long)1,(long)3);
		System.out.print(result);
	}
	@Test
	public void queryLessonsTest(){
		List<Long> lessons=controller.queryLessonsByMemberId((long)2);
		System.out.print(lessons.toString());
	}
	@Test
	public void queryMembersTest(){
		List<Long> lessons=controller.queryMembersByLessonId((long)2);
		System.out.print(lessons.toString());
	}
}
