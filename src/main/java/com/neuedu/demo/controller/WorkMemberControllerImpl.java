package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.service.WorkMemberService;
import com.neuedu.demo.tool.PairLongs;

public class WorkMemberControllerImpl implements WorkMemberController {

	@Autowired
	private WorkMemberService service;
	public WorkMemberControllerImpl(SqlSession session) {
		this.service=WorkMemberService.empty(session);
	}

	@Override
	public String insertWorkMember(Long workId, Long studentId) {
		PairLongs pair=new PairLongs(workId,studentId);
		Long cnt=service.count();
		service.insertWorkMember(pair);
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success";
		}else{
			return "false";
		}
	}

	@Override
	public String deleteWorkMember(Long workId, Long studentId) {
		PairLongs pair=new PairLongs(workId,studentId);
		Long cnt=service.count();
		service.deleteWorkMember(pair);
		Long cnt_after=service.count();
		cnt--;
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public List<Long> queryWorksByStudentId(Long id) {
		return service.queryWorksByMemberId(id);
	}

	@Override
	public List<Long> queryStudentsByWorkId(Long id) {
		return service.queryMembersByWorkId(id);
	}
}
