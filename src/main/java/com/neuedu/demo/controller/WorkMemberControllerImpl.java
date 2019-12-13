package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Student;
import com.neuedu.demo.domain.Work;

public class WorkMemberControllerImpl implements WorkMemberController {

	public WorkMemberControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertWork(Integer workId, Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteWork(Integer workId, Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> queryStudentsByWorkId(Integer workId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Work> queryWorksByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
