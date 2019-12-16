package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.StudentWork;

public interface WorkController {
	public static WorkController empty(SqlSession session){
		WorkController controller=new WorkControllerImpl(session);
		return controller;
	}
	
	public String insertWork(Long activityId);
	public String deleteWork(Long id);
	public String updateWork(Long id,Long activityId);
	public StudentWork queryWorkInfoById(Long id);
	public List<StudentWork> queryWorksByActivityId(Long activityId); 

}
