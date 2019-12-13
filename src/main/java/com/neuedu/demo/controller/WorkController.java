package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Work;

public interface WorkController {
	public static WorkController empty(SqlSession session){
		WorkController controller=new WorkControllerImpl(session);
		return controller;
	}
	
	public String insertWork(Integer activityId);
	public String deleteWork(Integer id);
	public String updateWork(Integer id,Integer activityId);
	public Work queryWorkInfoById(Integer id);
	public List<Work> queryWorksByActivityId(Integer activityId); 

}
