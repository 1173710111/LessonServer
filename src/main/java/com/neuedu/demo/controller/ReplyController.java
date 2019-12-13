package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Reply;

public interface ReplyController {
	public static ReplyController empty(SqlSession session){
		ReplyController controller=new ReplyControllerImpl(session);
		return controller;
	}
	
	public String insertReply(String userIdentity,Integer userId,String userName,String time,String content,Integer discussionId,Integer upReplyId);
	public String deleteReply(Integer id);
	public String updateReply(Integer id,String userIdentity,Integer userId,String userName,String time,String content,Integer discussionId,Integer upReplyId);
	public Reply queryReplyInfoById(Integer id);
	public List<Reply> queryReplysByDiscussionId(Integer discussionId); 
	public List<Reply> queryReplysByUser(String identity,Integer userId);
}
