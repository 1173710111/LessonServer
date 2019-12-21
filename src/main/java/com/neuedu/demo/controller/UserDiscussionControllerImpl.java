package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.demo.domain.UserDiscussion;
import com.neuedu.demo.service.UserDiscussionService;
import com.neuedu.demo.tool.Pair;
@Controller
public class UserDiscussionControllerImpl implements UserDiscussionController {

	private SqlSession session;
	@Autowired
	private UserDiscussionService service;
	public UserDiscussionControllerImpl(SqlSession session) {
		this.session=session;
		this.service=UserDiscussionService.empty(session);
	}
	
	@Override
	public String insertUserDiscussion(Long discussionId,String userIdentity,Long userId,int starState) {
		String str=this.checkInput(discussionId, userIdentity, userId, starState);
		if (!str.equals("ok")){
			return str;
		}
		UserDiscussion userDiscussion=new UserDiscussion((long)0,userIdentity,userId,discussionId,starState);
		Long cnt=service.count();
		service.insertUserDiscussion(userDiscussion);
		long id = userDiscussion.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteUserDiscussion(Long id) {
		Long cnt=service.count();
		service.deleteUserDiscussion(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateUserDiscussionState(Long id,int state) {
		UserDiscussion userDiscussion=service.queryUserDiscussionById(id);
		service.updateUserDiscussion(new Pair(id,state));
		UserDiscussion userDiscussionAfter=service.queryUserDiscussionById(id);
		if (userDiscussionAfter.toString().equals(userDiscussion.toString())){
			return "success:"+userDiscussion.toString();
		}else{
			return "false:"+userDiscussionAfter.toString();
		}
	}

	@Override
	public UserDiscussion queryUserDiscussionById(Long id) {
		UserDiscussion UserDiscussion=service.queryUserDiscussionById(id);
		return UserDiscussion;
	}
	@Override
	public List<UserDiscussion> queryUserDiscussions(String userIdentity,Long userId){
		List<UserDiscussion> UserDiscussion=service.queryUserDiscussions(new Pair(userIdentity,userId));
		return UserDiscussion;
	}
	
	@Override
	public List<UserDiscussion> queryUserDiscussionsByDiscussionId(Long discussionId){
		List<UserDiscussion> UserDiscussion=service.queryUserDiscussionsByDiscussionId(discussionId);
		return UserDiscussion;
	}
	
	private String checkInput(Long discussionId,String userIdentity,Long userId,int starState){
		DiscussionController controller=DiscussionController.empty(session);
		if (controller.queryDiscussionInfoById(discussionId).getId()==0){
			return "false:cannot find discussion["+discussionId+"].";
		}
		switch(userIdentity){
		case "student":
			StudentController studentController=StudentController.empty(session);
			if (studentController.queryStudentInfoById(userId).getId()==0){
				return "false:cannot find student["+userId+"].";
			}
			break;
		case "teacher":
			TeacherController teacherController=TeacherController.empty(session);
			if (teacherController.queryTeacherInfoById(userId).getId()==0){
				return "false:cannot find teacher["+userId+"].";
			}
			break;
		default:break;
		}
		return "ok";
	}
}
