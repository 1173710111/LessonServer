package com.neuedu.demo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.controller.ActivityController;
import com.neuedu.demo.controller.DiscussionController;
import com.neuedu.demo.controller.LessonController;
import com.neuedu.demo.controller.ReplyController;
import com.neuedu.demo.controller.StudentController;
import com.neuedu.demo.controller.WorkMemberController;
import com.neuedu.demo.tool.NewSession;

public class Message {
	private long id;
	private String type;
	private String sender;
	private String content=new String("null");
	private long lessonId;
	private long activityId;
	private long workId;
	private long discussionId;
	private long replyId;
	public Message(long id, String type, String sender, String content, long lessonId, long activityId, long workId,
			long discussionId, long replyId) {
		super();
		this.id = id;
		this.type = type;
		this.sender = sender;
		this.content = content;
		this.lessonId = lessonId;
		this.activityId = activityId;
		this.workId = workId;
		this.discussionId = discussionId;
		this.replyId = replyId;
	}
		
	public String setSender() {
		String sender=new String("");
		SqlSession session=NewSession.getSession();
		switch(type){
		case "activityToast":
			LessonController controller=LessonController.empty(session);
			sender=controller.queryLessonInfoById(this.lessonId).getName();
			this.sender=sender;
			return this.sender;
		case "memberDeleteToast":
			LessonController controller2=LessonController.empty(session);
			sender=controller2.queryLessonInfoById(this.lessonId).getName();
			this.sender=sender;
			return this.sender;
		case "teamAddToast":
			WorkMemberController controller3=WorkMemberController.empty(session);
			Long userId=controller3.queryStudentsByWorkId(this.workId).get(0);
			StudentController controller4=StudentController.empty(session);
			sender=controller4.queryStudentInfoById(userId).getUsername();
			this.sender=sender;
			return this.sender;
		case "myReply":
			LessonController controller5=LessonController.empty(session);
			sender=controller5.queryLessonInfoById(this.lessonId).getName();
			this.sender=sender;
			return this.sender;
		case "myDiscussion":
			LessonController controller6=LessonController.empty(session);
			sender=controller6.queryLessonInfoById(this.lessonId).getName();
			this.sender=sender;
			return this.sender;
		default: return this.sender;
		}		
	}
	public long getId() {
		return id;
	}


	public String getType() {
		return type;
	}


	public String getSender() {
		return sender;
	}


	public long getLessonId() {
		return lessonId;
	}


	public long getActivityId() {
		return activityId;
	}


	public long getWorkId() {
		return workId;
	}


	public long getDiscussionId() {
		return discussionId;
	}


	public long getReplyId() {
		return replyId;
	}

	

	public String getContent() {
		return this.content;
	}

	public String makeContent(){
		String content=new String("");
		SqlSession session=NewSession.getSession();
		switch (this.type){
		case "activityToast":
			content=makeActivityToast(session);
			this.content=content;
			session.close();
			return content;
		case "memberDeleteToast":
			content=makeMemberDeleteToast(session);
			this.content=content;
			session.close();
			return content;
		case "teamAddToast":
			content=makeTeamAddToast(session);
			this.content=content;
			session.close();
			return content;
		case "myReply":
			content=makeMyReply(session);
			this.content=content;
			session.close();
			return content;
		case "myDiscussion":
			content=makeMyDiscussion(session);
			this.content=content;
			session.close();
			return content;
		default:break;
		}
		return this.content;
	}
	private String makeActivityToast(SqlSession session){
		String content=new String("");
		content+="同学，你有一项活动[活动";
		ActivityController activityController=ActivityController.empty(session);
		Activity activity=activityController.queryActivityInfoById(this.activityId);
		content+=activity.getNum()+":";
		content+=activity.getTitle();
		content+="]待完成，";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
		String ddl = sdf.format(new Date(Long.parseLong(activity.getDeadline())));   // 时间戳转换成时间
        content+=ddl;
		content+="截止，请尽快完成。";
		return content;
	}
	
	private String makeMemberDeleteToast(SqlSession session){
		String content=new String("");
		content+="你已被移出课程【";
		content+=sender;
		content+="】。";
		return content;
	}
	
	private String makeTeamAddToast(SqlSession session){
		String content=new String("");
		content=content+"用户 ["+this.sender+"]邀请您加入他的队伍，共同完成活动 [活动";
		ActivityController activityController=ActivityController.empty(session);
		Activity activity=activityController.queryActivityInfoById(this.activityId);
		content=content+activity.getNum()+":"+activity.getTitle()+"]";
		content=content+",是否同意加入？";
		return content;
	}
	
	private String makeMyReply(SqlSession session){
		String content=new String("");
		content=content+"您在【"+this.sender+"】课程的讨论帖【" ;
		DiscussionController controller=DiscussionController.empty(session);
		String disTitle=controller.queryDiscussionInfoById(this.discussionId).getTitle();
		content=content+disTitle+"】中的评论“";
		ReplyController controller2=ReplyController.empty(session);
		Reply myReply=controller2.queryReplyInfoById(this.replyId);
		content=content+myReply.getContent()+"”有一条新回复：\n";
		Reply newReply=myReply.getReplies().get(myReply.getReplies().size()-1);
		content=content+"@"+newReply.getUser().getMainInfo().getId()+"："+newReply.getContent();
		return content;
	}
	
	private String makeMyDiscussion(SqlSession session){
		String content=new String("");
		content=content+"您在【"+this.sender+"】课程发布的讨论帖【";
		DiscussionController controller=DiscussionController.empty(session);
		Discussion discussion=controller.queryDiscussionInfoById(this.discussionId);
		String disTitle=discussion.getTitle();
		content=content+disTitle+"】中有一条新评论：\n";
		Reply newReply=discussion.getReplies().get(discussion.getReplies().size()-1);
		content=content+"@"+newReply.getUser().getMainInfo().getId()+"："+newReply.getContent();
		return content;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", type=" + type + ", sender=" + sender + ", content=" + content + ", lessonId="
				+ lessonId + ", activityId=" + activityId + ", workId=" + workId + ", discussionId=" + discussionId
				+ ", replyId=" + replyId + "]";
	}
	
	
}
