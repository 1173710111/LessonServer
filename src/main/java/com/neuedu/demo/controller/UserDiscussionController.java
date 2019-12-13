package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public interface UserDiscussionController {
	public static UserDiscussionController empty(SqlSession session){
		UserDiscussionController controller=new UserDiscussionControllerImpl(session);
		return controller;
	}
	
	public String insertUserDiscussion(Integer discussionId,String userIdentity,Integer userId,int starState);
	public String deleteUserDiscussion(String userIdentity,Integer userId,Integer discussionId);
	public String updateUserDiscussionState(String userIdentity,Integer userId,Integer discussionId,int starState);
	public List<Integer> queryUserDiscussions(String userIdentity,Integer userId);
	public List<Integer> queryDiscussionUsersByUserId(Integer discussionId); 
	
}
