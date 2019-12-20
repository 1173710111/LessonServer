package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Score;

public interface ScoreService {
	public static ScoreService empty(SqlSession session){
		ScoreServiceImpl service=new ScoreServiceImpl(session);
		return service;
	}
	public long insertScore(Score Score);
	public void deleteScore(Long id);
	public void updateScore(Score Score);
	public Score queryScoreById(Long id);
	public List<Score> queryScoresByExampaperId(Long id);
	public Long count();
}
