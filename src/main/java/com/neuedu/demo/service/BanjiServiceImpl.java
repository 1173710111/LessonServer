package com.neuedu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.BanjiMapper;
@Service
public class BanjiServiceImpl implements BanjiService{
	@Autowired
	private BanjiMapper mapper;
	
	@Override
	public void delete(Integer bid) {
		// TODO Auto-generated method stub
		mapper.deleteBanji(bid);
	}
	
}
