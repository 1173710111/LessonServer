package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.ActivityFile;
import com.neuedu.demo.service.ActivityFileService;

@Controller
public class ActivityFileControllerImpl implements ActivityFileController {
	private SqlSession session;
	@Autowired
	private ActivityFileService service;
	public ActivityFileControllerImpl(SqlSession session) {
		this.service=ActivityFileService.empty(session);
		this.session=session;
	}

	@Override
	public String insertActivityFile(String fileName, String url, String type, Long activityId, Long workId) {
		ActivityController activityController=ActivityController.empty(session);
		if (activityController.queryActivityInfoById(activityId).getId()==0){
			return "false:cannot find activity["+activityId+"].";
		}
		ActivityFile file=null;
		if (type.equals("upFile")){
			WorkController workController=WorkController.empty(session);
			if (workController.queryWorkInfoById(workId).getId()==0){
				return "false:cannot find work["+workId+"].";
			}
			file=new ActivityFile((long)0,fileName,url,activityId,type,workId);
		}else{
			file=new ActivityFile((long)0,fileName,url,activityId,type);
		}
		Long cnt=service.count();
		service.insertActivityFile(file);
		long id = file.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteActivityFile(Long id) {
		Long cnt=service.count();
		service.deleteActivityFile(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateActivityFile(Long id, String fileName, String url, String type, Long activityId, Long workId) {
		ActivityController activityController=ActivityController.empty(session);
		if (activityController.queryActivityInfoById(activityId).getId()==0){
			return "false:cannot find activity["+activityId+"].";
		}
		ActivityFile file=null;
		if (type.equals("upFile")){
			WorkController workController=WorkController.empty(session);
			if (workController.queryWorkInfoById(workId).getId()==0){
				return "false:cannot find work["+workId+"].";
			}
			file=new ActivityFile(id,fileName,url,activityId,type,workId);
		}else{
			file=new ActivityFile(id,fileName,url,activityId,type);
		}
		service.updateActivityFile(file);
		ActivityFile fileAfter=service.queryActivityFileById(id);
		if (fileAfter.toString().equals(file.toString())){
			return "success:"+file.toString();
		}else{
			return "false:"+fileAfter.toString();
		}
	}

	@Override
	public ActivityFile queryActivityFileById(Long id) {
		ActivityFile file=service.queryActivityFileById(id);
		return file;
	}

	@Override
	public List<ActivityFile> queryFilesByActivityId(Long activityId) {
		List<ActivityFile> files=service.queryFilesByActivityId(activityId);
		return files;
	}

	@Override
	public List<ActivityFile> queryFilesByWorkId(Long workId) {
		List<ActivityFile> files=service.queryFilesByWorkId(workId);
		return files;
	}

	

}
