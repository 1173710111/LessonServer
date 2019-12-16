package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.StudentWork;

public class WorkControllerImpl implements WorkController {

	public WorkControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertWork(Long activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteWork(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateWork(Long id, Long activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentWork queryWorkInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentWork> queryWorksByActivityId(Long activityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
