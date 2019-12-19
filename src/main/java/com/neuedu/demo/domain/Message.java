package com.neuedu.demo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.demo.controller.ActivityController;
import com.neuedu.demo.controller.DiscussionController;
import com.neuedu.demo.controller.ReplyController;
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

	
	public long getId(){
		return this.id;
	}
	public String getType(){
		return this.type;
	}
	public String getSender(){
		return this.sender;
	}
	
	public String makeContent(){
		String content=new String("");
		SqlSession session=NewSession.getSession();
		if (!this.content.equals("null")){
			return this.content;
		}
		switch (this.type){
		case "activityToast":
			content=makeActivityToast(session, content);
			this.content=content;
			session.close();
			return content;
		case "memberDeleteToast":
			content=makeMemberDeleteToast(session, content);
			this.content=content;
			session.close();
		case "teamAddToast":
			content=makeTeamAddToast(session, content);
			this.content=content;
			session.close();
		case "myReply":
			content=makeMyReply(session, content);
			this.content=content;
			session.close();
		case "myDiscussion":
			content=makeMyDiscussion(session, content);
			this.content=content;
			session.close();
		default:break;
		}
		return this.content;
	}
	private String makeActivityToast(SqlSession session,String content){
		content.concat("同学，你有一项活动[活动");
		ActivityController activityController=ActivityController.empty(session);
		Activity activity=activityController.queryActivityInfoById(this.activityId);
		content.concat(activity.getNum()+":");
		content.concat(activity.getTitle());
		content.concat("]待完成，");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
        @SuppressWarnings("deprecation")
		String ddl = sdf.format(new Date(activity.getDeadline()));   // 时间戳转换成时间
        content.concat(ddl);
		content.concat("截止，请尽快完成。");
		return content;
	}
	
	private String makeMemberDeleteToast(SqlSession session,String content){
		content.concat("你已被移出课程【");
		content.concat(sender);
		content.concat("】。");
		return content;
	}
	
	private String makeTeamAddToast(SqlSession session,String content){
		content=content+"用户 ["+this.sender+"]邀请您加入他的队伍，共同完成活动 [活动";
		ActivityController activityController=ActivityController.empty(session);
		Activity activity=activityController.queryActivityInfoById(this.activityId);
		content=content+activity.getNum()+":"+activity.getTitle()+"]";
		content=content+",是否同意加入？";
		return content;
	}
	
	private String makeMyReply(SqlSession session,String content){
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
	
	private String makeMyDiscussion(SqlSession session,String content){
		content=content+"您在【"+this.sender+"】课程发布的讨论帖【";
		DiscussionController controller=DiscussionController.empty(session);
		Discussion discussion=controller.queryDiscussionInfoById(this.discussionId);
		String disTitle=discussion.getTitle();
		content=content+disTitle+"】中有一条新评论：\n";
		Reply newReply=discussion.getReplies().get(discussion.getReplies().size()-1);
		content=content+"@"+newReply.getUser().getMainInfo().getId()+"："+newReply.getContent();
		return content;
	}
	
	public String getContent(){
		return this.content;
	}
}
