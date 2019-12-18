package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Activity;

public interface ActivityController {
	public static ActivityController empty(SqlSession session){
		ActivityController controller=new ActivityControllerImpl(session);
		return controller;
	}
	
	public String insertActivity(Long lessonId,String title,String introduction,
			String publishedTime,String deadline,int teamVolumem);
	public String deleteActivity(Long id);
	public String updateActivity(Long id,Long lessonId,String title,String introduction,
			String publishedTime,String deadline,int teamVolume);
	public Activity queryActivityInfoById(Long id);
	public List<Activity> queryActivitiesByLessonId(Long id);
}
