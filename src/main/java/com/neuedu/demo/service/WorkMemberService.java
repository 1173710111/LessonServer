package com.neuedu.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.tool.PairLongs;

public interface WorkMemberService {
	public static WorkMemberService empty(SqlSession session){
		WorkMemberServiceImpl service=new WorkMemberServiceImpl(session);
		return service;
	}
	public void insertWorkMember(PairLongs pair);
	public void deleteWorkMember(PairLongs pair);
	public List<Long> queryWorksByMemberId(Long id);
	public List<Long> queryMembersByWorkId(Long id);
	public Long count();
}
