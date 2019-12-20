package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.ReplyMapper;
import com.neuedu.demo.domain.Reply;
import com.neuedu.demo.tool.Pair;
@Service
public class ReplyServiceImpl implements ReplyService {
	private SqlSession session;
	 @Autowired
    private ReplyMapper mapper=null; 
	public ReplyServiceImpl(SqlSession session){
	   	this.session=session;
	   	mapper=session.getMapper(ReplyMapper.class);
    }
	  
	@Override
	public long insertReply(Reply Reply) {
		long i = mapper.insertReply(Reply);
		session.commit();
		return i;
	}

	@Override
	public void deleteReply(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteReply(id);
			session.commit();
		}
	}

	@Override
	public void updateReply(Reply Reply) {
		if (mapper.isExistent(Reply.getId())>0){
			mapper.updateReply(Reply);
			session.commit();
		}
	}

	@Override
	public Reply queryReplyById(Long id) {
		Reply Reply=null;
		if (mapper.isExistent(id)==0){
			Reply=new Reply((long)0,null,(long)0,null,null,(long)0,(long)0);
		}else{
			Reply=mapper.queryReplyById(id);
		}
		return Reply;
	}

	@Override
	public List<Reply> queryRepliesByDiscussionId(Long id) {
		List<Reply> reply=null;
		if (mapper.isExistent(id)==0){
			reply=new ArrayList<Reply>();
		}else{
			reply=mapper.queryRepliesByDiscussionId(id);
		}
		return reply;
	}
	@Override
	public List<Reply> queryRepliesByUser(Pair pair) {
		List<Reply> replies=null;
		replies=mapper.queryRepliesByUser(pair);
		if (replies==null||replies.size()==0){
			replies=new ArrayList<Reply>();
		}
		return replies;
	}

	@Override
	public List<Reply> queryRepliesFollowed(Long id) {
		if (mapper.isExistent(id)==0)
			return new ArrayList<Reply>();
		List<Reply> replies=mapper.queryRepliesFollowed(id);
		if (replies==null||replies.size()==0){
			replies=new ArrayList<Reply>();
		}
		return replies;
	}
	@Override
	public Long count() {
		return mapper.count();
	}	
}



