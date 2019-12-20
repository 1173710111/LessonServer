package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.neuedu.demo.domain.Reply;
import com.neuedu.demo.service.ReplyService;
import com.neuedu.demo.tool.Pair;
@Controller
public class ReplyControllerImpl implements ReplyController {
	private SqlSession session;
	@Autowired
	private ReplyService service;
	public ReplyControllerImpl(SqlSession session) {
		this.session=session;
		this.service=ReplyService.empty(session);
	}
	
	@Override
	public String insertReply(String userIdentity,Long userId,String time,String content,Long discussionId,Long upReplyId){
		String str=this.checkInput(userIdentity, userId, time, content, discussionId, upReplyId);
		if (!str.equals("ok")){
			return str;
		}
		Reply reply=new Reply((long)0,userIdentity,userId,time,content,discussionId,upReplyId);
		Long cnt=service.count();
		service.insertReply(reply);
		long id = reply.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteReply(Long id) {
		Long cnt=service.count();
		service.deleteReply(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateReply(Long id,String userIdentity,Long userId,String time,String content,Long discussionId,Long upReplyId){
		String str=this.checkInput(userIdentity, userId, time, content, discussionId, upReplyId);
		if (!str.equals("ok")){
			return str;
		}
		Reply reply=new Reply(id,userIdentity,userId,time,content,discussionId,upReplyId);
		service.updateReply(reply);
		Reply ReplyAfter=service.queryReplyById(id);
		if (ReplyAfter.toString().equals(reply.toString())){
			return "success:"+reply.toString();
		}else{
			return "false:"+ReplyAfter.toString();
		}
	}

	@Override
	public Reply queryReplyInfoById(Long id) {
		Reply reply=service.queryReplyById(id);
		return reply;
	}

	@Override
	public List<Reply> queryRepliesByDiscussionId(Long id){
		List<Reply> replies=service.queryRepliesByDiscussionId(id);
		return replies;
	}
	@Override
	public List<Reply> queryRepliesFollowed(Long id){
		List<Reply> replies=service.queryRepliesFollowed(id);
		return replies;
	}
	
	@Override
	public List<Reply> queryRepliesByUser(String identity, Long userId) {
		Pair user=new Pair(identity,userId);
		List<Reply> replies=service.queryRepliesByUser(user);
		return replies;
	}
	
	private String checkInput(String userIdentity,Long userId,String time,String content,Long discussionId,Long upReplyId){
		DiscussionController controller=DiscussionController.empty(session);
		if (controller.queryDiscussionInfoById(discussionId).getId()==0){
			return "false:cannot find discussion["+discussionId+"].";
		}
		if (upReplyId==null||upReplyId==0){
			upReplyId=(long)0;
		}else{
			if (this.queryReplyInfoById(upReplyId).getId()==0){
				return "false:cannot find upReply["+upReplyId+"].";
			}
		}
		switch(userIdentity){
		case "student":
			StudentController studentController=StudentController.empty(session);
			if (studentController.queryStudentInfoById(userId).getId()==0){
				return "false:cannot find student["+userId+"].";
			}
			break;
		case "teacher":
			TeacherController teacherController=TeacherController.empty(session);
			if (teacherController.queryTeacherInfoById(userId).getId()==0){
				return "false:cannot find teacher["+userId+"].";
			}
			break;
		default:break;
		}
		return "ok";
	}
}
