package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Reply;
import com.neuedu.demo.tool.Pair;

@Mapper
public interface ReplyMapper {
	public long insertReply(Reply reply);
	public void deleteReply(Long id);
	public void updateReply(Reply reply);
	public Reply queryReplyById(Long id);
	public List<Reply> queryRepliesByDiscussionId(Long discussionId); 
	public List<Reply> queryRepliesByUser(Pair pair);
	public List<Reply> queryRepliesFollowed(Long id);
	public Long count();
	public Integer isExistent(Long id);
}
