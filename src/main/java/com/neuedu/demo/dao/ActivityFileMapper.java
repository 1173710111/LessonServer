package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.ActivityFile;

@Mapper
public interface ActivityFileMapper {
	public long insertUpFile(ActivityFile file);
	public long insertDownFile(ActivityFile file);
	
	public void deleteActivityFile(Long id);
	
	public void updateUpFile(ActivityFile file);
	public void updateDownFile(ActivityFile file);
	
	public ActivityFile queryActivityFileById(Long id);
	
	public List<ActivityFile> queryFilesByActivityId(Long id);
	public List<ActivityFile> queryFilesByWorkId(Long id);
	
	public Long count();
	public Integer isExistent(Long id);
}
