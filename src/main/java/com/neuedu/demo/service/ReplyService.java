package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Reply;
import com.neuedu.demo.tool.Pair;

public interface ReplyService {
	public static ReplyService empty(SqlSession session){
		ReplyServiceImpl service=new ReplyServiceImpl(session);
		return service;
	}
	public long insertReply(Reply reply);
	public void deleteReply(Long id);
	public void updateReply(Reply reply);
	public Reply queryReplyById(Long id);
	public List<Reply> queryRepliesByDiscussionId(Long discussionId); 
	public List<Reply> queryRepliesByUser(Pair pair);
	public List<Reply> queryRepliesFollowed(Long id);
	public Long count();
}
