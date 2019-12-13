package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import javafx.util.Pair;

public class ActivityFileControllerImpl implements ActivityFileController {

	public ActivityFileControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertActivityFile(String fileName, String url, String type, Integer activityId, Integer workId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteActivityFile(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateActivityFile(Integer id, String fileName, String url, String type, Integer activityId,
			Integer workId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<String, String>> queryFilesByActivityId(Integer activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<String, String>> queryFilesByWorkId(Integer workId) {
		// TODO Auto-generated method stub
		return null;
	}

}
