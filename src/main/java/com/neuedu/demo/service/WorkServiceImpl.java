package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.neuedu.demo.dao.WorkMapper;
import com.neuedu.demo.domain.StudentWork;

public class WorkServiceImpl implements WorkService {
	private SqlSession session;
	@Autowired
    private WorkMapper mapper=null; 
	public WorkServiceImpl(SqlSession session) {
		this.session=session;
		mapper=session.getMapper(WorkMapper.class);
	}

	@Override
	public int insertWork(StudentWork work) {
		int i=mapper.insertWork(work);
		session.commit();
		return i;
	}

	@Override
	public void deleteWork(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteWork(id);
			session.commit();
		}
	}

	@Override
	public void updateWork(StudentWork work) {
		if (mapper.isExistent(work.getId())>0){
			mapper.updateWork(work);
			session.commit();
		}
	}

	@Override
	public StudentWork queryWorkInfoById(Long id) {
		StudentWork work=null;
		if (mapper.isExistent(id)==0){
			work=new StudentWork((long)0,id);
		}else{
			work=mapper.queryWorkInfoById(id);
		}
		return work;
	}

	@Override
	public List<StudentWork> queryWorksByActivityId(Long activityId) {
		List<StudentWork> works=mapper.queryWorksByActivityId(activityId);
		if(works==null||works.size()==0){
			works=new ArrayList<StudentWork>();
		}
		return works;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

}
