package com.neuedu.demo.controller;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.ActivityFile;


public interface ActivityFileController {
	public static ActivityFileController empty(SqlSession session){
		ActivityFileController controller=new ActivityFileControllerImpl(session);
		return controller;
	}
	
	public String insertActivityFile(String fileName,String url,String type,Long activityId,Long workId);
	public String deleteActivityFile(Long id);
	public String updateActivityFile(Long id,String fileName,String url,String type,Long activityId,Long workId);
	public ActivityFile queryActivityFileById(Long id);
	public List<ActivityFile> queryFilesByActivityId(Long activityId);
	public List<ActivityFile> queryFilesByWorkId(Long workId); 
}
