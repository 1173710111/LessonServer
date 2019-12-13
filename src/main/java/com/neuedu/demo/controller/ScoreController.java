package com.neuedu.demo.controller;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Score;

public interface ScoreController {
	public static ScoreController empty(SqlSession session){
		ScoreController controller=new ScoreControllerImpl(session);
		return controller;
	}
	
	public String insertScore(Integer numberAll,Integer numberWrong,Integer numberRight,Integer numberUnfinished,Integer exampaperId);
	public String deleteScore(Integer id);
	public String updateScore(Integer scoreId,Integer numberAll,Integer numberWrong,Integer numberRight,Integer numberUnfinished,Integer exampaperId);
	public Score queryScoreInfoById(Integer id);
	public Score queryScoreByExampaperId(Integer id);
}
