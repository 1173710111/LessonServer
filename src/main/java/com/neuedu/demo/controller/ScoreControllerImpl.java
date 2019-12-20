package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.neuedu.demo.domain.Score;
import com.neuedu.demo.service.ScoreService;
@Controller
public class ScoreControllerImpl implements ScoreController {
	private SqlSession session;
	@Autowired
	private ScoreService service;
	public ScoreControllerImpl(SqlSession session) {
		this.session=session;
		this.service=ScoreService.empty(session);
	}
	
	@Override
	public String insertScore(Long numberAll,Long numberWrong,
			Long numberRight,Long numberUnfinished,Long exampaperId) {
		ExampaperController controller=ExampaperController.empty(session);
		if (controller.queryExampaperInfoById(exampaperId).getId()==0){
			return "false:cannot find exampaper["+exampaperId+"].";
		}
		Score Score=new Score((long)0,numberAll,numberWrong,numberRight,numberUnfinished,exampaperId);
		Long cnt=service.count();
		service.insertScore(Score);
		long id = Score.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteScore(Long id) {
		Long cnt=service.count();
		service.deleteScore(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateScore(Long scoreId,Long numberAll,Long numberWrong,
			Long numberRight,Long numberUnfinished,Long exampaperId) {
		ExampaperController controller=ExampaperController.empty(session);
		if (controller.queryExampaperInfoById(exampaperId).getId()==0){
			return "false:cannot find exampaper["+exampaperId+"].";
		}
		Score Score=new Score(scoreId,numberAll,numberWrong,numberRight,numberUnfinished,exampaperId);
		service.updateScore(Score);
		Score ScoreAfter=service.queryScoreById(scoreId);
		if (ScoreAfter.toString().equals(Score.toString())){
			return "success:"+Score.toString();
		}else{
			return "false:"+ScoreAfter.toString();
		}
	}

	@Override
	public Score queryScoreInfoById(Long id) {
		Score Score=service.queryScoreById(id);
		return Score;
	}

	@Override
	public List<Score> queryScoresByExampaperId(Long id){
		List<Score> score=service.queryScoresByExampaperId(id);
		return score;
	}
}
