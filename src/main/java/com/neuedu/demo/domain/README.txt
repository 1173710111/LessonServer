publishedTime:
String类型，保存以毫秒为单位的long型数字，表示从1970-1-1 00:00:00 UTC到该日期字符串所表示日期的毫秒数

StudentAnswer,UserDiscussion:
//0-unfinished 1-right 2-wrong
private int finishedState;
//0-unstared 1-stared
private int starState;

Activity.type:
“homework” “activity”

UserInfo.type:
“student”  “teacher” 

SystemMessage.type:
（1）“activityToast”:活动提交提示。模板：“同学，你有一项活动[作业/活动i：xxxxxxxx]待完成，还剩y小时截止，请尽快完成。”
（2）“memberDeleteToast”：移出课程提示。模板：“你已被移出课程【xxx】。”
（3）“teamAddToast”：队伍邀请提示。模板：“用户[aaa]邀请您加入他的队伍，共同完成活动[作业/活动i:xxxxxxx]，是否同意加入？”+两个button“是”和“否”

DiscussionMessage.type：
(1)“myReply”：
模板：您在【xxx】课程的讨论帖【yyyyyy】中的评论“zzzzzzzz”有一条新回复：\n@bbb：aaaaaaaaaa
（2）“myDiscussion”：
模板：您在【xxx】课程发布的讨论帖【yyyyyy】中有一条新评论：\n@bbb：aaaaaaaaaa