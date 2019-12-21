package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.UserDiscussionMapper;
import com.neuedu.demo.domain.UserDiscussion;
import com.neuedu.demo.tool.Pair;
@Service
public class UserDiscussionServiceImpl implements UserDiscussionService {
	private SqlSession session;
	 @Autowired
    private UserDiscussionMapper mapper=null; 
	public UserDiscussionServiceImpl(SqlSession session){
	   	this.session=session;
	   	mapper=session.getMapper(UserDiscussionMapper.class);
    }
	  
	@Override
	public long insertUserDiscussion(UserDiscussion UserDiscussion) {
		long i = mapper.insertUserDiscussion(UserDiscussion);
		session.commit();
		return i;
	}

	@Override
	public void deleteUserDiscussion(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteUserDiscussion(id);
			session.commit();
		}
	}

	@Override
	public void updateUserDiscussion(Pair pair) {
		if (mapper.isExistent((long)pair.getValue1())>0){
			mapper.updateUserDiscussionState(pair);
			session.commit();
		}
	}

	@Override
	public UserDiscussion queryUserDiscussionById(Long id) {
		UserDiscussion userDis=mapper.queryUserDiscussionById(id);
		if (userDis==null) userDis=new UserDiscussion((long)0,null,(long)0,(long)0,0);
		return userDis;
	}

	@Override
	public List<UserDiscussion> queryUserDiscussions(Pair user) {
		List<UserDiscussion> UserDiscussions=mapper.queryUserDiscussions(user);
		if (UserDiscussions==null||UserDiscussions.size()==0){
			UserDiscussions=new ArrayList<UserDiscussion>();
		}
		return UserDiscussions;
	}
	@Override
	public List<UserDiscussion> queryUserDiscussionsByDiscussionId(Long id) {
		List<UserDiscussion> UserDiscussions=mapper.queryUserDiscussionsByDiscussionId(id);
		if (UserDiscussions==null||UserDiscussions.size()==0){
			UserDiscussions=new ArrayList<UserDiscussion>();
		}
		return UserDiscussions;
	}
	
	@Override
	public Long count() {
		return mapper.count();
	}
}
