package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Discussion;

@Mapper
public interface DiscussionMapper {
	public long insertDiscussion(Discussion discussion);
	public void deleteDiscussion(Long id);
	public void updateDiscussion(Discussion discussion);
	public Discussion queryDiscussionById(Long id);
	public List<Discussion> queryDiscussionsByLessonId(Long id);
	public Long count();
	public Integer isExistent(Long id);
}
