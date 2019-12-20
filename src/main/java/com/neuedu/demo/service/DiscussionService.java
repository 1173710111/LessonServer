package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Discussion;

public interface DiscussionService {
	public static DiscussionService empty(SqlSession session){
		DiscussionServiceImpl service=new DiscussionServiceImpl(session);
		return service;
	}
	public long insertDiscussion(Discussion discussion);
	public void deleteDiscussion(Long id);
	public void updateDiscussion(Discussion discussion);
	public Discussion queryDiscussionById(Long id);
	public List<Discussion> queryDiscussionsByLessonId(Long id);
	public Long count();
}
