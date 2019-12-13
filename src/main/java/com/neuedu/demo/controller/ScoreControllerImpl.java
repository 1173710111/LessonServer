package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Score;

public class ScoreControllerImpl implements ScoreController {

	public ScoreControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertScore(Integer numberAll, Integer numberWrong, Integer numberRight, Integer numberUnfinished,
			Integer exampaperId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteScore(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateScore(Integer scoreId,Integer numberAll, Integer numberWrong, Integer numberRight, Integer numberUnfinished,
			Integer exampaperId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score queryScoreInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score queryScoreByExampaperId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
