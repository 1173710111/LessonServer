package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.UserDiscussion;
import com.neuedu.demo.tool.Pair;

public interface UserDiscussionService {
	public static UserDiscussionService empty(SqlSession session){
		UserDiscussionServiceImpl service=new UserDiscussionServiceImpl(session);
		return service;
	}
	public long insertUserDiscussion(UserDiscussion userDiscussion);
	public void deleteUserDiscussion(Long id);
	public void updateUserDiscussion(Pair pair);
	public UserDiscussion queryUserDiscussionById(Long id);
	public List<UserDiscussion> queryUserDiscussions(Pair user);
	public List<UserDiscussion> queryUserDiscussionsByDiscussionId(Long id);
	public Long count();
}
