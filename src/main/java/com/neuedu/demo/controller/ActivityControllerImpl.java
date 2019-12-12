package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Activity;

public class ActivityControllerImpl implements ActivityController {


	public ActivityControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertActivity(long lessonId, String title, String introduction, String deadline, int teamVolume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteActivity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateActivity(long lessonId, String title, String introduction, String deadline, int teamVolume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activity queryActivityInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> queryActivitysByLessonId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
