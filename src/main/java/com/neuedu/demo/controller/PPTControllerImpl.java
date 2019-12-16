package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.PPT;

public class PPTControllerImpl implements PPTController {

	public PPTControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertPPT(Long lessonId, Long sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePPT(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePPT(Long id, Long lessonId, Long sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PPT queryPPTInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PPT> queryPPTsBySubLessonId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
