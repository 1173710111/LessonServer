package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Work;

public class WorkControllerImpl implements WorkController {

	public WorkControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertWork(Integer activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteWork(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateWork(Integer id, Integer activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Work queryWorkInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Work> queryWorksByActivityId(Integer activityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
