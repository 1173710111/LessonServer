package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
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
		System.out.println(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteLessonTeacher((long)2,(long)5);
		System.out.println(result);
	}
	@Test
	public void queryLessonsTest(){
		List<Long> lessons=controller.queryLessonsByTeacherId((long)2);
		System.out.println(lessons.toString());
	}
	@Test
	public void queryTeachersTest(){
		List<Long> lessons=controller.queryTeachersByLessonId((long)2);
		System.out.println(lessons.toString());
	}
	@After
	public void finish(){
		session.close();
	}
}
