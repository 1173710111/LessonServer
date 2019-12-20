package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.domain.Discussion;
import com.neuedu.demo.service.DiscussionService;

public class DiscussionControllerImpl implements DiscussionController {

	private SqlSession session;
	@Autowired
	private DiscussionService service;
	public DiscussionControllerImpl(SqlSession session) {
		this.session=session;
		this.service=DiscussionService.empty(session);
	}
	
	@Override
	public String insertDiscussion(Long lessonId,String title,String publishedTime) {
		LessonController controller=LessonController.empty(session);
		if (controller.queryLessonInfoById(lessonId).getId()==0){
			return "false:cannot find lesson["+lessonId+"].";
		}
		Discussion discussion=new Discussion((long)0,lessonId,title,publishedTime);
		Long cnt=service.count();
		service.insertDiscussion(discussion);
		long id = discussion.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteDiscussion(Long id) {
		Long cnt=service.count();
		service.deleteDiscussion(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateDiscussion(Long id,Long lessonId,String title,String publishedTime) {
		LessonController controller=LessonController.empty(session);
		if (controller.queryLessonInfoById(lessonId).getId()==0){
			return "false:cannot find lesson["+lessonId+"].";
		}
		Discussion Discussion=new Discussion(id,lessonId,title,publishedTime);
		service.updateDiscussion(Discussion);
		Discussion discussionAfter=service.queryDiscussionById(id);
		if (discussionAfter.toString().equals(Discussion.toString())){
			return "success:"+Discussion.toString();
		}else{
			return "false:"+discussionAfter.toString();
		}
	}

	@Override
	public Discussion queryDiscussionInfoById(Long id) {
		Discussion discussion=service.queryDiscussionById(id);
		return discussion;
	}

	@Override
	public List<Discussion> queryDiscussionsByLessonId(Long id){
		List<Discussion> discussion=service.queryDiscussionsByLessonId(id);
		return discussion;
	}
}
