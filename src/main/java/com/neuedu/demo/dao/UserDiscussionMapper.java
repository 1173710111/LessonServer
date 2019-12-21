package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.UserDiscussion;
import com.neuedu.demo.tool.Pair;

@Mapper
public interface UserDiscussionMapper {
	public long insertUserDiscussion(UserDiscussion userDiscussion);
	public void deleteUserDiscussion(Long id);
	public void updateUserDiscussionState(Pair pair);
	public UserDiscussion queryUserDiscussionById(Long id);
	public List<UserDiscussion> queryUserDiscussions(Pair user);
	public List<UserDiscussion> queryUserDiscussionsByDiscussionId(Long id);
	public Long count();
	public int isExistent(long id);
}
