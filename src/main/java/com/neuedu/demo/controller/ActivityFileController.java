package com.neuedu.demo.controller;

import java.util.List;
import javafx.util.*;
import org.apache.ibatis.session.SqlSession;


public interface ActivityFileController {
	public static ActivityFileController empty(SqlSession session){
		ActivityFileController controller=new ActivityFileControllerImpl(session);
		return controller;
	}
	
	public String insertActivityFile(String fileName,String url,String type,Integer activityId,Integer workId);
	public String deleteActivityFile(Integer id);
	public String updateActivityFile(Integer id,String fileName,String url,String type,Integer activityId,Integer workId);
	//return type Pair<fileName,fileUrl>
	public List<Pair<String,String>> queryFilesByActivityId(Integer activityId);
	public List<Pair<String,String>> queryFilesByWorkId(Integer workId); 
}
