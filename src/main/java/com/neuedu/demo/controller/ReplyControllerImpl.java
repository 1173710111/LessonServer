package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Reply;

public class ReplyControllerImpl implements ReplyController {

	public ReplyControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertReply(String userIdentity, Long userId, String userName, String time, String content,
			Long discussionId, Long upReplyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteReply(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateReply(Long id, String userIdentity, Long userId, String userName, String time,
			String content, Long discussionId, Long upReplyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reply queryReplyInfoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> queryReplysByDiscussionId(Long discussionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> queryReplysByUser(String identity, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
