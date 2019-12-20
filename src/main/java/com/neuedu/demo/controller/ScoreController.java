package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Score;

public interface ScoreController {
	public static ScoreController empty(SqlSession session){
		ScoreController controller=new ScoreControllerImpl(session);
		return controller;
	}
	
	public String insertScore(Long numberAll,Long numberWrong,Long numberRight,Long numberUnfinished,Long exampaperId);
	public String deleteScore(Long id);
	public String updateScore(Long scoreId,Long numberAll,Long numberWrong,Long numberRight,Long numberUnfinished,Long exampaperId);
	public Score queryScoreInfoById(Long id);
	public List<Score> queryScoresByExampaperId(Long id);
}
