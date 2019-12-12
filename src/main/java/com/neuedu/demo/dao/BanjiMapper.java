package com.neuedu.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.demo.domain.Banji;

@Mapper
public interface BanjiMapper {
	public void insertBanji(Banji bj);
	//public List<Banji> queryBanji();
	//public List<Banji> queryBanjiById(Integer cid);
	public List<Banji> queryBanjiByAny(Banji bj);
	public void deleteBanji(Integer cid);
	public void updateBanji(Banji bj);
}
