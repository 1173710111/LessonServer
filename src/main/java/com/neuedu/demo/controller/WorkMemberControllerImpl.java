package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.domain.Student;
import com.neuedu.demo.domain.StudentWork;

public class WorkMemberControllerImpl implements WorkMemberController {

	public WorkMemberControllerImpl(SqlSession session) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insertWork(Long workId, Long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteWork(Long workId, Long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> queryStudentsByWorkId(Long workId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentWork> queryWorksByStudentId(Long studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
