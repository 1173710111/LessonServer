package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Reply;

public interface ReplyController {
	public static ReplyController empty(SqlSession session){
		ReplyController controller=new ReplyControllerImpl(session);
		return controller;
	}
	
	public String insertReply(String userIdentity,Long userId,String time,String content,Long discussionId,Long upReplyId);
	public String deleteReply(Long id);
	public String updateReply(Long id,String userIdentity,Long userId,String time,String content,Long discussionId,Long upReplyId);
	public Reply queryReplyInfoById(Long id);
	public List<Reply> queryRepliesByDiscussionId(Long discussionId); 
	public List<Reply> queryRepliesByUser(String identity,Long userId);
	public List<Reply> queryRepliesFollowed(Long id);
}
