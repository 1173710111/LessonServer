package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.ActivityFile;

public interface ActivityFileService {
	public static ActivityFileService empty(SqlSession session){
		ActivityFileService service=new ActivityFileServiceImpl(session);
		return service;
	}
	public int insertActivityFile(ActivityFile file);
	public void deleteActivityFile(Long id);
	public void updateActivityFile(ActivityFile file);
	public ActivityFile queryActivityFileById(Long id);
	public List<ActivityFile> queryFilesByActivityId(Long id);
	public List<ActivityFile> queryFilesByWorkId(Long id);
	public Long count();
	
}
