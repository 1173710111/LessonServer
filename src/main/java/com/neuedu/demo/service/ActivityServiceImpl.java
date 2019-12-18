package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.ActivityMapper;
import com.neuedu.demo.domain.Activity;
import com.neuedu.demo.domain.Activity;
@Service
public class ActivityServiceImpl implements ActivityService {
	private SqlSession session;
	@Autowired
    private ActivityMapper mapper=null; 
	public ActivityServiceImpl(SqlSession session) {
		this.session=session;
		mapper=session.getMapper(ActivityMapper.class);
	}

	@Override
	public int insertActivity(Activity Activity) {
		int i = mapper.insertActivity(Activity);
		session.commit();
		return i;
	}

	@Override
	public void deleteActivity(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteActivity(id);
			session.commit();
		}
	}

	@Override
	public void updateActivity(Activity Activity) {
		if (mapper.isExistent(Activity.getId())>0){
			mapper.updateActivity(Activity);
			session.commit();
		}
	}

	@Override
	public Activity queryActivityById(Long id) {
		Activity Activity=null;
		if (mapper.isExistent(id)==0){
			Activity=new Activity((long)0,(long)0,null,null,null,0,null);
		}else{
			Activity=mapper.queryActivityById(id);
		}
		return Activity;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

	@Override
	public List<Activity> queryActivitiesByLessonId(Long id) {
		List<Activity> activities=mapper.queryActivitiesByLessonId(id);
		if (activities==null||activities.size()==0){
			activities=new ArrayList<Activity>();
		}
		return activities;
	}

}
