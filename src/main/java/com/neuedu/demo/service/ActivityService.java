package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Activity;

public interface ActivityService {
	public static ActivityService empty(SqlSession session){
		ActivityServiceImpl service=new ActivityServiceImpl(session);
		return service;
	}
	public long insertActivity(Activity Activity);
	public void deleteActivity(Long id);
	public void updateActivity(Activity Activity);
	public Activity queryActivityById(Long id);
	public Long count();
	public List<Activity> queryActivitiesByLessonId(Long id);
}
