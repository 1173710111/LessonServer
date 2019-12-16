package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Score;

public class ScoreControllerImpl implements ScoreController {

	public ScoreControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertScore(Long numberAll, Long numberWrong, Long numberRight, Long numberUnfinished,
			Long exampaperId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteScore(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateScore(Long scoreId,Long numberAll, Long numberWrong, Long numberRight, Long numberUnfinished,
			Long exampaperId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score queryScoreInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score queryScoreByExampaperId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
