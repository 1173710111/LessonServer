package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.tool.Pair;

@Mapper
public interface UserMessageMapper {
	public void insertUserMessage(Pair pair);
	public void deleteUserMessage(Pair pair);
	public List<Pair> queryMessageUsersByMessageId(Long messageId);
	public List<Long> queryUserMessages(Pair user);
	public int isExistent(Pair userMessage);
	public Long count();
}
