package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Discussion;

public interface DiscussionController {
	public static DiscussionController empty(SqlSession session){
		DiscussionController controller=new DiscussionControllerImpl(session);
		return controller;
	}
	
	public String insertDiscussion(int lessonId,String title);
	public String deleteDiscussion(Integer id);
	public String updateDiscussion(long id,int lessonId,String title);
	public Discussion queryDiscussionInfoById(Integer id);
	public List<Discussion> queryDiscussionsByLessonId(Integer id);
}
