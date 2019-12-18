package com.neuedu.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.domain.Activity;
import com.neuedu.demo.domain.ActivityFile;
import com.neuedu.demo.domain.NewSession;
import com.neuedu.demo.tool.FormatString;


public class ActivityFileControllerTest {
	private SqlSession session=null;
	private ActivityFileController controller;
	private String url="C:\\Users\\admin\\Desktop\\HIT\\实验1&2.doc";
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=ActivityFileController.empty(session);
	}
	@Test
	public void insertTest1(){
		String result1=controller.insertActivityFile("实验指导书",this.url,"downFile",(long)1,null);
		System.out.print(result1);
	}
	@Test
	public void insertTest2(){
		String result1=controller.insertActivityFile("实验指导书",this.url,"downFile",(long)1,null);
		System.out.print(result1);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteActivityFile((long) 5);
		System.out.print(result);
	}
	@Test
	public void queryTest(){
		String result=controller.queryActivityFileById((long) 1).toString();
		System.out.print(result);
	}
	@Test 
	public void queryListActivityTest(){
		List<ActivityFile> files=controller.queryFilesByActivityId((long)1);
		System.out.println(files.toString());
	}
	@Test 
	public void queryListWorkTest(){
		List<ActivityFile> files=controller.queryFilesByWorkId((long)1);
		System.out.println(files.toString());
	}
	@Test
	public void updateTest(){
		String result=controller.updateActivityFile((long)2,"实验要求大纲",this.url,"downFile",(long)1,null);
		System.out.print(result);
	}
}
