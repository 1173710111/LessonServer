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
	public String deleteUserDiscussion(Long id);
	public String updateUserDiscussionState(Long id,int starState);
	public UserDiscussion queryUserDiscussionById(Long id);
	public List<UserDiscussion> queryUserDiscussions(String userIdentity,Long userId);
	public List<UserDiscussion> queryUserDiscussionsByDiscussionId(Long discussionId); 
	
}
