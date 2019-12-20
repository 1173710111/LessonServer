package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.DiscussionMapper;
import com.neuedu.demo.domain.Discussion;
import com.neuedu.demo.domain.Question;
@Service
public class DiscussionServiceImpl implements DiscussionService {
	private SqlSession session;
	 @Autowired
    private DiscussionMapper mapper=null; 
	public DiscussionServiceImpl(SqlSession session){
	   	this.session=session;
	   	mapper=session.getMapper(DiscussionMapper.class);
    }
	  
	@Override
	public long insertDiscussion(Discussion discussion) {
		long i = mapper.insertDiscussion(discussion);
		session.commit();
		return i;
	}

	@Override
	public void deleteDiscussion(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteDiscussion(id);
			session.commit();
		}
	}

	@Override
	public void updateDiscussion(Discussion discussion) {
		if (mapper.isExistent(discussion.getId())>0){
			mapper.updateDiscussion(discussion);
			session.commit();
		}
	}

	@Override
	public Discussion queryDiscussionById(Long id) {
		Discussion discussion=null;
		if (mapper.isExistent(id)==0){
			discussion=new Discussion((long)0,(long)0,null,null);
		}else{
			discussion=mapper.queryDiscussionById(id);
		}
		return discussion;
	}

	@Override
	public List<Discussion> queryDiscussionsByLessonId(Long id) {
		List<Discussion> discussions=mapper.queryDiscussionsByLessonId(id);
		if (discussions==null||discussions.size()==0){
			discussions=new ArrayList<Discussion>();
		}
		return discussions;
	}
	
	@Override
	public Long count() {
		return mapper.count();
	}
}
