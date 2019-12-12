package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.PPT;

public interface PPTController {
	public static PPTController empty(SqlSession session){
		PPTController controller=new PPTControllerImpl(session);
		return controller;
	}
	
	public String insertPPT(Integer lessonId,Integer sublessonId);
	public String deletePPT(Integer id);
	public String updatePPT(Integer id,Integer lessonId,Integer sublessonId);
	public PPT queryPPTInfoById(Integer id);
	public List<PPT> queryPPTsBySubLessonId(Integer id); 

}
