package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.Activity;
import com.neuedu.demo.service.ActivityService;
@Controller
public class ActivityControllerImpl implements ActivityController {
	private SqlSession session;
	@Autowired
	private ActivityService service;
	public ActivityControllerImpl(SqlSession session) {
		this.service=ActivityService.empty(session);
		this.session=session;
	}
	@Override
	public String insertActivity(Long lessonId, String title, String introduction, String publishedTime,
			String deadline, int teamVolume) {
		LessonController controller=LessonController.empty(session);
		if (controller.queryLessonInfoById(lessonId).getId()==0){
			return "false:cannot find lesson["+lessonId+"].";
		}
		Activity activity=new Activity((long)0,lessonId,title,introduction,deadline,teamVolume,publishedTime);
		Long cnt=service.count();
		service.insertActivity(activity);
		long id = activity.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}


	@Override
	public String deleteActivity(Long id) {
		Long cnt=service.count();
		service.deleteActivity(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}
	@Override
	public String updateActivity(Long id, Long lessonId, String title, String introduction, String publishedTime,
			String deadline, int teamVolume) {
		LessonController controller=LessonController.empty(session);
		if (controller.queryLessonInfoById(lessonId).getId()==0){
			return "false:cannot find lesson["+lessonId+"].";
		}
		Activity activity=new Activity(id,lessonId,title,introduction,deadline,teamVolume,publishedTime);
		service.updateActivity(activity);
		Activity activityAfter=service.queryActivityById(id);
		if (activityAfter.toString().equals(activity.toString())){
			activity.setNum(this.queryActivitiesByLessonId(lessonId));
			return "success:"+activity.toString();
		}else{
			activityAfter.setNum(this.queryActivitiesByLessonId(lessonId));
			return "false:"+activityAfter.toString();
		}
	}

	

	@Override
	public Activity queryActivityInfoById(Long id) {
		Activity activity=service.queryActivityById(id);
		activity.setNum(this.queryActivitiesByLessonId(activity.getLessonId()));
		return activity;
	}

	@Override
	public List<Activity> queryActivitiesByLessonId(Long id) {
		List<Activity> activities=service.queryActivitiesByLessonId(id);
		for (Activity activity:activities){
			activity.setNum(activities);
		}
		return activities;
	}
}
