package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.controller.ActivityController;
import com.neuedu.demo.controller.LessonController;

public class SystemMessage extends Message {
	protected long lessonId;
	protected String lessonName;
	protected String type;
	
	public SystemMessage(String sender,long lessonId ,String type) {
		super(sender);
		this.lessonId=lessonId;
		this.type=type;
		this.lessonName=sender;
		makeContent();
	}

	public long getLessonId() {
		return lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public String getType() {
		return type;
	}
	
	private List<Activity> getLessonActivities(){
		SqlSession session=new NewSession().getSession();
		ActivityController lessonController=ActivityController.empty(session);
		List<Activity> activities=new ArrayList<Activity>();
		
	}
	
	protected void makeContent(){
		
		String content=new String();
		switch(this.type){
		case "activityToast":
			
		}
	}

}
