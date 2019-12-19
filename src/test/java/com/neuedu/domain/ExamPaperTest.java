package com.neuedu.domain;

import org.junit.Test;

import com.neuedu.demo.domain.Exampaper;

public class ExamPaperTest {
	@Test
	public void GetFinishedTimeTest(){
		long timeStamp = System.currentTimeMillis();
		Exampaper paper=new Exampaper((long)1,timeStamp+"","5",(long)2,(long)3);
		//System.out.println(paper.toString());
		System.out.print(paper.getFinishedTime());
	}
}
