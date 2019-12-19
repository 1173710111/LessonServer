package com.neuedu.demo.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.Exampaper;
import com.neuedu.demo.tool.FormatString;
import com.neuedu.demo.tool.NewSession;


public class ExampaperControllerTest {
	private SqlSession session=null;
	private ExampaperController controller;
	private long timeStart;
	private long timelast=2400;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=ExampaperController.empty(session);
		long time=System.currentTimeMillis();
		this.timeStart=time;
	}
	@Test
	public void timeTest(){
		System.out.println(new SimpleDateFormat(FormatString.dateFormat).format(this.timeStart));
		System.out.println(new SimpleDateFormat(FormatString.dateFormat).format(this.timelast));
	}
	@Test
	public void insertTest(){
		String result1=controller.insertExampaper(this.timeStart+"",""+timelast,(long)1,(long)1);
		System.out.println(result1);
		String result2=controller.insertExampaper(this.timeStart+"",""+timelast,(long)10,(long)1);
		System.out.println(result2);
		String result3=controller.insertExampaper(this.timeStart+"",""+timelast,(long)2,(long)20);
		System.out.println(result3);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteExampaper((long) 3);
		System.out.println(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryExampaperInfoById((long) 1).toString();
		System.out.println(result);
	}
	@Test 
	public void queryListTest1(){
		List<Exampaper> exampapers=controller.queryExampapersBySublessonId((long)1);
		System.out.println(exampapers.toString());
	}
	@Test 
	public void queryListTest2(){
		List<Exampaper> exampapers=controller.queryExampapersByLessonId((long)1);
		System.out.println(exampapers.toString());
	}
	@Test
	public void updateTest(){
		String result=controller.updateExampaper((long)2,this.timeStart+"",""+timelast,(long)1,(long)2);
		System.out.println(result);
	}
	@After
	public void finish(){
		session.close();
	}
}
