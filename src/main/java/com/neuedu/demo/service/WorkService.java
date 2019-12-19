package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.StudentWork;

public interface WorkService {
	public static WorkService empty(SqlSession session){
		WorkService service=new WorkServiceImpl(session);
		return service;
	}
	public long insertWork(StudentWork work);
	public void deleteWork(Long id);
	public void updateWork(StudentWork work);
	public StudentWork queryWorkInfoById(Long id);
	public List<StudentWork> queryWorksByActivityId(Long activityId);
	public Long count();
	
}
