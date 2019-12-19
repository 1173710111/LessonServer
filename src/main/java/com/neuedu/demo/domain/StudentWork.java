package com.neuedu.demo.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.controller.ActivityController;
import com.neuedu.demo.tool.NewSession;

public class StudentWork {
	private long id;
	private long activityId;
	private List<Student> teamMembers;
	private List<String> upFiles;
	private int teamVolume;
	public StudentWork(long id, long activityId) {
		super();
		this.id = id;
		this.activityId = activityId;
		setTeamVolume();
	}
	
	private void setTeamVolume(){
		SqlSession session=NewSession.getSession();
		ActivityController controller=ActivityController.empty(session);
		int volume=controller.queryActivityInfoById(this.activityId).getTeamVolume();
		this.teamVolume=volume;
		session.close();
	}
	public long getId() {
		return id;
	}
	public long getActivityId() {
		return activityId;
	}
	public List<Student> getTeamMembers() {
		return teamMembers;
	}
	public List<String> getUpFiles() {
		return upFiles;
	}
	public int getTeamVolume() {
		return teamVolume;
	}
	
	public void addMember(Student student){
		this.teamMembers.add(student);
	}
	public void deleteMember(Student student){
		if (this.teamMembers.contains(student)){
			this.teamMembers.remove(student);
		}
	}
	public void addFile(String fileurl){
		this.upFiles.add(fileurl);
	}
	public void deleteFile(String fileurl){
		if (this.upFiles.contains(fileurl)){
			this.upFiles.remove(fileurl);
		}
	}

	@Override
	public String toString() {
		return "StudentWork [id=" + id + ", activityId=" + activityId + ", teamMembers=" + teamMembers + ", upFiles="
				+ upFiles + ", teamVolume=" + teamVolume + "]";
	}
	
}
