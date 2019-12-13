package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Reply;

public class ReplyControllerImpl implements ReplyController {

	public ReplyControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertReply(String userIdentity, Integer userId, String userName, String time, String content,
			Integer discussionId, Integer upReplyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteReply(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateReply(Integer id, String userIdentity, Integer userId, String userName, String time,
			String content, Integer discussionId, Integer upReplyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reply queryReplyInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> queryReplysByDiscussionId(Integer discussionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> queryReplysByUser(String identity, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
