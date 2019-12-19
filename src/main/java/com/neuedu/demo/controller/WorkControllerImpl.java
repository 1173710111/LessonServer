package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.StudentWork;
import com.neuedu.demo.service.WorkService;
@Controller
public class WorkControllerImpl implements WorkController {
	private SqlSession session;
	@Autowired
	private WorkService service;
	public WorkControllerImpl(SqlSession session) {
		this.service=WorkService.empty(session);
		this.session=session;
	}

	@Override
	public String insertWork(Long activityId) {
		ActivityController controller=ActivityController.empty(session);
		if (controller.queryActivityInfoById(activityId).getId()==0){
			return "false:cannot find activity["+activityId+"].";
		}
		StudentWork work=new StudentWork((long)0,activityId);
		Long cnt=service.count();
		service.insertWork(work);
		long id=work.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteWork(Long id) {
		Long cnt=service.count();
		service.deleteWork(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateWork(Long id, Long activityId) {
		ActivityController controller=ActivityController.empty(session);
		if (controller.queryActivityInfoById(activityId).getId()==0){
			return "false:cannot find activity["+activityId+"].";
		}
		StudentWork work=new StudentWork(id,activityId);
		service.updateWork(work);
		StudentWork workAfter=service.queryWorkInfoById(id);
		if (work.toString().equals(workAfter.toString())){
			return "success:"+work.toString();
		}else{
			return "false:"+workAfter.toString();
		}
	}

	@Override
	public StudentWork queryWorkInfoById(Long id) {
		StudentWork work=service.queryWorkInfoById(id);
		return work;
	}

	@Override
	public List<StudentWork> queryWorksByActivityId(Long activityId) {
		List<StudentWork> works=service.queryWorksByActivityId(activityId);
		return works;
	}

}
