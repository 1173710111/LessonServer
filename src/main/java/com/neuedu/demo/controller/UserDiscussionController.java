package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserDiscussion;


public interface UserDiscussionController {
	public static UserDiscussionController empty(SqlSession session){
		UserDiscussionController controller=new UserDiscussionControllerImpl(session);
		return controller;
	}
	
	public String insertUserDiscussion(Long discussionId,String userIdentity,Long userId,int starState);
	public String deleteUserDiscussion(String userIdentity,Long userId,Long discussionId);
	public String updateUserDiscussionState(String userIdentity,Long userId,Long discussionId,int starState);
	public List<UserDiscussion> queryUserDiscussions(String userIdentity,Long userId);
	public List<UserDiscussion> queryDiscussionUsersByUserId(Long discussionId); 
	
}
