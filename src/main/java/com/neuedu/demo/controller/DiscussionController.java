package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Discussion;

public interface DiscussionController {
	public static DiscussionController empty(SqlSession session){
		DiscussionController controller=new DiscussionControllerImpl(session);
		return controller;
	}
	
	public String insertDiscussion(Long lessonId,String title,String publishedTime);
	public String deleteDiscussion(Long id);
	public String updateDiscussion(Long id,Long lessonId,String title,String publishedTime);
	public Discussion queryDiscussionInfoById(Long id);
	public List<Discussion> queryDiscussionsByLessonId(Long id);
}
