package com.neuedu.demo.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.Activity;
import com.neuedu.demo.domain.NewSession;
import com.neuedu.demo.tool.FormatString;


public class ActivityControllerTest {
	private SqlSession session=null;
	private ActivityController controller;
	private long timeStart;
	private long timeEnd;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=ActivityController.empty(session);
		long time=System.currentTimeMillis();
		this.timeStart=time;
		time+=240000000;
		this.timeEnd=time;
	}
	@Test
	public void timeTest(){
		System.out.println(new SimpleDateFormat(FormatString.dateFormat).format(this.timeStart));
		System.out.println(new SimpleDateFormat(FormatString.dateFormat).format(this.timeEnd));
	}
	@Test
	public void insertTest(){
		String result1=controller.insertActivity((long)2,"完成实验三", "实验课上验收", ""+this.timeStart,""+this.timeEnd, 3);
		System.out.println(result1);
		String result2=controller.insertActivity((long)10,"完成实验三", "实验课上验收", ""+this.timeStart,""+this.timeEnd, 3);
		System.out.println(result2);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteActivity((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryActivityInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test 
	public void queryListTest(){
		List<Activity> activities=controller.queryActivitiesByLessonId((long)1);
		System.out.println(activities.toString());
	}
	@Test
	public void updateTest(){
		String result=controller.updateActivity((long)4,(long)1,"完成实验二", "下周日之前提交实验报告", ""+this.timeStart,""+this.timeEnd, 3);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
