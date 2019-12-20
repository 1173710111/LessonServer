package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Score;

@Mapper
public interface ScoreMapper {
	public long insertScore(Score Score);
	public void deleteScore(Long id);
	public void updateScore(Score Score);
	public Score queryScoreById(Long id);
	public List<Score> queryScoresByExampaperId(Long id);
	public Long count();
	public Integer isExistent(Long id);
}
