package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.demo.tool.NewSession;


public class WorkMemberControllerTest {
	private SqlSession session=null;
	private WorkMemberController controller;
	@Before
	public void init(){
		this.session=NewSession.getSession();
		this.controller=WorkMemberController.empty(session);
	}
	@Test
	public void insertTest(){
		String result=controller.insertWorkMember((long)1,(long)2);
		controller.insertWorkMember((long)2, (long)2);
		controller.insertWorkMember((long)3, (long)2);
		controller.insertWorkMember((long)2, (long)4);
		System.out.println(result);
	}
	@Test
	public void deleteTest(){
		String result=controller.deleteWorkMember((long)1,(long)3);
		System.out.println(result);
	}
	@Test
	public void queryWorksTest(){
		List<Long> Works=controller.queryWorksByStudentId((long)2);
		System.out.println(Works.toString());
	}
	@Test
	public void queryMembersTest(){
		List<Long> Works=controller.queryStudentsByWorkId((long)2);
		System.out.println(Works.toString());
	}
	@After
	public void finish(){
		session.close();
	}
}
