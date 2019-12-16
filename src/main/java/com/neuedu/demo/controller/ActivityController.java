package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Activity;

public interface ActivityController {
	public static ActivityController empty(SqlSession session){
		ActivityController controller=new ActivityControllerImpl(session);
		return controller;
	}
	
	public String insertActivity(Integer lessonId,String title,String introduction,String deadline,int teamVolume);
	public String deleteActivity(Long id);
	public String updateActivity(Integer lessonId,String title,String introduction,String deadline,int teamVolume);
	public Activity queryActivityInfoById(Long id);
	public List<Activity> queryActivitysByLessonId(Long id);
}
