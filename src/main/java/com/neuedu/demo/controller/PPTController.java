package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.PPT;

public interface PPTController {
	public static PPTController empty(SqlSession session){
		PPTController controller=new PPTControllerImpl(session);
		return controller;
	}
	
	public String insertPPT(Long lessonId,Long sublessonId);
	public String deletePPT(Long id);
	public String updatePPT(Long id,Long lessonId,Long sublessonId);
	public PPT queryPPTInfoById(Long id);
	public List<PPT> queryPPTsBySubLessonId(Long id); 

}
