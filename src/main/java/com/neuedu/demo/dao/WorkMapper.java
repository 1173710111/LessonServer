package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.StudentWork;

@Mapper
public interface WorkMapper {
	public int insertWork(StudentWork work);
	public void deleteWork(Long id);
	public void updateWork(StudentWork work);
	public StudentWork queryWorkInfoById(Long id);
	public List<StudentWork> queryWorksByActivityId(Long activityId);
	public int isExistent(Long id);
	public long count();
}
