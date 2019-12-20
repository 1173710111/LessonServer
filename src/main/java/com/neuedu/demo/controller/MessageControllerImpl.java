package com.neuedu.demo.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.demo.domain.Message;
import com.neuedu.demo.service.MessageService;

public class MessageControllerImpl implements MessageController {
	private SqlSession session;
	@Autowired
	private MessageService service;
	public MessageControllerImpl(SqlSession session) {
		this.session=session;
		this.service=MessageService.empty(session);
	}
	
	@Override
	public String insertMessage(String type,String sender,String content,
			Long lessonId,Long activityId,Long workId,Long discussionId,Long replyId) {
		String str=checkInputType(type, sender, content, lessonId, activityId, workId, discussionId, replyId);	
		if (!str.equals("ok")){
			return str;
		}
		Message Message=new Message((long)0,type,sender,content,lessonId,activityId,workId,discussionId,replyId);
		Long cnt=service.count();
		service.insertMessage(Message);
		long id = Message.getId();
		Long cnt_after=service.count();
		cnt++;
		if (cnt==cnt_after){
			return "success:id="+id;
		}else{
			return "false";
		}
	}

	@Override
	public String deleteMessage(Long id) {
		Long cnt=service.count();
		service.deleteMessage(id);
		cnt--;
		Long cnt_after=service.count();
		if (cnt==cnt_after){
			return "success:cnt="+cnt;
		}else {
			return "false:cnt="+cnt_after;
		}
	}

	@Override
	public String updateMessage(Long id,String type,String sender,String content,
			Long lessonId,Long activityId,Long workId,Long discussionId,Long replyId) {
		String str=checkInputType(type, sender, content, lessonId, activityId, workId, discussionId, replyId);	
		if (!str.equals("ok")){
			return str;
		}
		Message message=new Message(id,type,sender,content,lessonId,activityId,workId,discussionId,replyId);
		service.updateMessage(message);
		Message messageAfter=service.queryMessageById(id);
		if (messageAfter.toString().equals(message.toString())){
			return "success:"+message.toString();
		}else{
			return "false:"+messageAfter.toString();
		}
	}

	@Override
	public Message queryMessageInfoById(Long id) {
		Message message=service.queryMessageById(id);
		return message;
	}

	@Override
	public List<Message> queryMessagesBylessonId(Long id){
		List<Message> Message=service.queryMessagesByLessonId(id);
		return Message;
	}
	@Override
	public List<Message> queryMessagesByType(String type){
		List<Message> Message=service.queryMessagesByType(type);
		return Message;
	}
	
	private String checkInputType(String type,String sender,String content,
			Long lessonId,Long activityId,Long workId,Long discussionId,Long replyId){
		
		switch (type){
		case "activityToast":
			if (activityId==null||activityId==0){
				return "false:activiyId cannot be null or 0.";
			}
			ActivityController activityController=ActivityController.empty(session);
			if (activityController.queryActivityInfoById(activityId).getId()==0){
				return "false:cannot find activity["+activityId+"].";
			}
			break;
		case "teamAddToast":
			if (activityId==null||activityId==0){
				return "false:activiyId cannot be null or 0.";
			}
			if (workId==null||workId==0){
				return "false:workId cannot be null or 0.";
			}
			ActivityController activityController2=ActivityController.empty(session);
			if (activityController2.queryActivityInfoById(activityId).getId()==0){
				return "false:cannot find activity["+activityId+"].";
			}
			WorkController workController=WorkController.empty(session);
			if (workController.queryWorkInfoById(workId).getId()==0){
				return "false:cannot find work["+workId+"].";
			}
			break;
		case "memberDeleteToast":
			if (lessonId==null||lessonId==0){
				return "false:lessonId cannot be null or 0.";
			}
			LessonController lessonController=LessonController.empty(session);
			if (lessonController.queryLessonInfoById(lessonId).getId()==0){
				return "false:cannot find lesson["+lessonId+"].";
			}
			break;
		case "myReply":
			if (lessonId==null||lessonId==0){
				return "false:lessonId cannot be null or 0.";
			}
			if (discussionId==null||discussionId==0){
				return "false:discussionId cannot be null or 0.";
			}
			if (replyId==null||replyId==0){
				return "false:replyId cannot be null or 0.";
			}
			LessonController lessonController2=LessonController.empty(session);
			if (lessonController2.queryLessonInfoById(lessonId).getId()==0){
				return "false:cannot find lesson["+lessonId+"].";
			}
			DiscussionController discussionController=DiscussionController.empty(session);
			if (discussionController.queryDiscussionInfoById(discussionId).getId()==0){
				return "false:cannot find discussion["+discussionId+"].";
			}
			ReplyController replyController=ReplyController.empty(session);
			if (replyController.queryReplyInfoById(replyId).getId()==0){
				return "false:cannot find Reply["+replyId+"].";
			}
			break;
		case "myDiscussionToast":
			if (lessonId==null||lessonId==0){
				return "false:lessonId cannot be null or 0.";
			}
			LessonController lessonController3=LessonController.empty(session);
			if (lessonController3.queryLessonInfoById(lessonId).getId()==0){
				return "false:cannot find lesson["+lessonId+"].";
			}
			DiscussionController discussionController2=DiscussionController.empty(session);
			if (discussionController2.queryDiscussionInfoById(discussionId).getId()==0){
				return "false:cannot find discussion["+discussionId+"].";
			}
			break;
		default:return "false:cannot find the message type.";
		}
		return "ok";
	}
}
