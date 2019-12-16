package com.neuedu.domain;

import org.junit.Test;

import com.neuedu.demo.domain.ExamPaper;

public class ExamPaperTest {
	@Test
	public void GetFinishedTimeTest(){
		long timeStamp = System.currentTimeMillis();
		ExamPaper paper=new ExamPaper((long)1,(long)2,(long)3,timeStamp+"","5");
		//System.out.println(paper.toString());
		System.out.print(paper.getFinishedTime());
	}
}
