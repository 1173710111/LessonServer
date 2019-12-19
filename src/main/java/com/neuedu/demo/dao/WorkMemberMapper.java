package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.tool.PairLongs;

@Mapper
public interface WorkMemberMapper {
	public void insertWorkMember(PairLongs pair);
	public void deleteWorkMember(PairLongs pair);
	public List<Long> queryWorksByMemberId(Long id);
	public List<Long> queryMembersByWorkId(Long id);
	public Integer isExistent(PairLongs pair);
	public Long count();
}

