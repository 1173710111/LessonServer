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


public class LessonTeacherControllerTest {
	private SqlSession session=null;
	private LessonTeacherController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=LessonTeacherController.empty(session);
	}
	@Test
	public void insertTest(){
		String result=controller.insertLessonTeacher((long)1,(long)2);
		controller.insertLessonTeacher((long)1, (long)5);
		controller.insertLessonTeacher((long)2, (long)2);
		controller.insertLessonTeacher((long)4, (long)2);
		controller.insertLessonTeacher((long)2, (long)5);
		System.out.print(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteLessonTeacher((long)2,(long)5);
		System.out.print(result);
	}
	@Test
	public void queryLessonsTest(){
		List<Long> lessons=controller.queryLessonsByTeacherId((long)2);
		System.out.print(lessons.toString());
	}
	@Test
	public void queryTeachersTest(){
		List<Long> lessons=controller.queryTeachersByLessonId((long)2);
		System.out.print(lessons.toString());
	}
}
