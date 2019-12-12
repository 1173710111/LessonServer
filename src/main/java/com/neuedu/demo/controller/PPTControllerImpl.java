package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.PPT;

public class PPTControllerImpl implements PPTController {

	public PPTControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertPPT(Integer lessonId, Integer sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePPT(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePPT(Integer id, Integer lessonId, Integer sublessonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PPT queryPPTInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PPT> queryPPTsBySubLessonId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
