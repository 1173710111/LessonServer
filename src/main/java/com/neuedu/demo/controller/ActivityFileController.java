package com.neuedu.demo.controller;

import java.util.List;
import javafx.util.*;
import org.apache.ibatis.session.SqlSession;


public interface ActivityFileController {
	public static ActivityFileController empty(SqlSession session){
		ActivityFileController controller=new ActivityFileControllerImpl(session);
		return controller;
	}
	
	public String insertActivityFile(String fileName,String url,String type,Long activityId,Long workId);
	public String deleteActivityFile(Long id);
	public String updateActivityFile(Long id,String fileName,String url,String type,Long activityId,Long workId);
	//return type Pair<fileName,fileUrl>
	public List<Pair<String,String>> queryFilesByActivityId(Long activityId);
	public List<Pair<String,String>> queryFilesByWorkId(Long workId); 
}
