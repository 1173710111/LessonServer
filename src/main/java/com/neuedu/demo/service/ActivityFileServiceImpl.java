package com.neuedu.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.demo.dao.ActivityFileMapper;
import com.neuedu.demo.domain.ActivityFile;
@Service
public class ActivityFileServiceImpl implements ActivityFileService {
	private SqlSession session;
	@Autowired
    private ActivityFileMapper mapper=null; 
	public ActivityFileServiceImpl(SqlSession session) {
		this.session=session;
		mapper=session.getMapper(ActivityFileMapper.class);
	}

	@Override
	public long insertActivityFile(ActivityFile file) {
		long i=0;
		if (file.getType().equals("upFile")){
			i = mapper.insertUpFile(file);
		}else{
			if (file.getType().equals("downFile")){
				i = mapper.insertDownFile(file);
			}
		}
		session.commit();
		return i;
	}

	@Override
	public void deleteActivityFile(Long id) {
		if (mapper.isExistent(id)>0){
			mapper.deleteActivityFile(id);
			session.commit();
		}
	}

	@Override
	public void updateActivityFile(ActivityFile file) {
		if (mapper.isExistent(file.getId())>0){
			if (file.getType().equals("upFile")){
				mapper.updateUpFile(file);
			}else{
				if (file.getType().equals("downFile")){
					mapper.updateDownFile(file);
				}
			}
			session.commit();
		}
	}

	@Override
	public ActivityFile queryActivityFileById(Long id) {
		ActivityFile file=null;
		if (mapper.isExistent(id)==0){
			file=new ActivityFile((long)0,null,null,(long)0,"downFile");
		}else{
			file=mapper.queryActivityFileById(id);
		}
		return file;
	}

	@Override
	public List<ActivityFile> queryFilesByActivityId(Long id) {
		List<ActivityFile> files=mapper.queryFilesByActivityId(id);
		if (files==null||files.size()==0){
			files=new ArrayList<ActivityFile>();
		}
		return files;
	}

	@Override
	public List<ActivityFile> queryFilesByWorkId(Long id) {
		List<ActivityFile> files=mapper.queryFilesByWorkId(id);
		if (files==null||files.size()==0){
			files=new ArrayList<ActivityFile>();
		}
		return files;
	}

	@Override
	public Long count() {
		return mapper.count();
	}

}
