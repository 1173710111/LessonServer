package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Activity;

@Mapper
public interface ActivityMapper {
	public long insertActivity(Activity Activityinfo);
	public void deleteActivity(Long id);
	public void updateActivity(Activity Activityinfo);
	public Activity queryActivityById(Long id);
	public Long count();
	public Integer isExistent(Long id);
	public List<Activity> queryActivitiesByLessonId(Long id);
}
