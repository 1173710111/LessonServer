package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.dao.WorkMemberMapper;
import com.neuedu.demo.tool.PairLongs;

public class WorkMemberServiceImpl implements WorkMemberService{
	private SqlSession session;
	 @Autowired
    private WorkMemberMapper mapper=null;     
	public WorkMemberServiceImpl(SqlSession session) {
		this.session=session;
    	mapper=session.getMapper(WorkMemberMapper.class);
	}
	@Override
	public void insertWorkMember(PairLongs pair) {
		if(mapper.isExistent(pair)>0)
			return;
		mapper.insertWorkMember(pair);
		session.commit();
	}
	@Override
	public void deleteWorkMember(PairLongs pair) {
		if(mapper.isExistent(pair)>0){
			mapper.deleteWorkMember(pair);
			session.commit();
		}
	}
	@Override
	public List<Long> queryWorksByMemberId(Long id) {
		List<Long> Works=new ArrayList<Long>();
		if (mapper.queryWorksByMemberId(id)==null||mapper.queryWorksByMemberId(id).size()==0)
			return Works;
		Works=mapper.queryWorksByMemberId(id);
		return Works;
	}
	@Override
	public List<Long> queryMembersByWorkId(Long id) {
		List<Long> members=new ArrayList<Long>();
		if (mapper.queryMembersByWorkId(id)==null||mapper.queryMembersByWorkId(id).size()==0)
			return members;
		members=mapper.queryMembersByWorkId(id);
		return members;
	}
	@Override
	public Long count() {
		return mapper.count();
	}

	
}
