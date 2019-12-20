package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.ScoreMapper;
import com.neuedu.demo.domain.Score;
@Service
public class ScoreServiceImpl implements ScoreService {
	private SqlSession session;
	 @Autowired
    private ScoreMapper mapper=null; 
	public ScoreServiceImpl(SqlSession session){
	   	this.session=session;
	   	mapper=session.getMapper(ScoreMapper.class);
    }
	  
	@Override
	public long insertScore(Score Score) {
		long i = mapper.insertScore(Score);
		session.commit();
		return i;
	}

	@Override
	public void deleteScore(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteScore(id);
			session.commit();
		}
	}

	@Override
	public void updateScore(Score Score) {
		if (mapper.isExistent(Score.getId())>0){
			mapper.updateScore(Score);
			session.commit();
		}
	}

	@Override
	public Score queryScoreById(Long id) {
		Score Score=null;
		if (mapper.isExistent(id)==0){
			Score=new Score((long)0,(long)0,(long)0,(long)0,(long)0,(long)0);
		}else{
			Score=mapper.queryScoreById(id);
		}
		return Score;
	}

	@Override
	public List<Score> queryScoresByExampaperId(Long id) {
		List<Score> score=mapper.queryScoresByExampaperId(id);
		if (score==null) score=new ArrayList<Score>();
		return score;
	}
	
	@Override
	public Long count() {
		return mapper.count();
	}
}