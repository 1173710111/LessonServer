/*
SQLyog Ultimate v9.62 
MySQL - 5.5.27 : Database - lessonsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lessonsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lessonsystem`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_bin NOT NULL,
  `introduction` varchar(255) COLLATE utf8_bin NOT NULL,
  `deadline` varchar(20) COLLATE utf8_bin NOT NULL,
  `team_volume` int(4) DEFAULT NULL,
  `published_time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonIdActivity` (`lesson_id`),
  CONSTRAINT `lessonIdActivity` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `activity` */

LOCK TABLES `activity` WRITE;

insert  into `activity`(`id`,`lesson_id`,`title`,`introduction`,`deadline`,`team_volume`,`published_time`) values (1,1,'完成实验一','周末实验课上验收','1576894653084',3,'1576654653084'),(2,2,'完成实验二','实验课上验收','1576897407841',3,'1576657407841'),(4,1,'完成实验二','下周日之前提交实验报告','1577186192768',3,'1576946192768'),(5,2,'完成实验三','实验课上验收','1576983080657',3,'1576743080657'),(6,2,'完成实验三','实验课上验收','1577186105798',3,'1576946105798'),(7,2,'完成实验三','实验课上验收','1577186192833',3,'1576946192833');

UNLOCK TABLES;

/*Table structure for table `activity_file` */

DROP TABLE IF EXISTS `activity_file`;

CREATE TABLE `activity_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(100) COLLATE utf8_bin NOT NULL,
  `type` varchar(10) COLLATE utf8_bin NOT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  `work_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `activityIdFile` (`activity_id`),
  KEY `workIdFile` (`work_id`),
  CONSTRAINT `activityIdFile` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`),
  CONSTRAINT `workIdFile` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `activity_file` */

LOCK TABLES `activity_file` WRITE;

insert  into `activity_file`(`id`,`file_name`,`url`,`type`,`activity_id`,`work_id`) values (1,'实验指导书','C:\\Users\\admin\\Desktop\\HIT\\实验1&2.doc','downFile',1,NULL),(2,'实验要求大纲','C:\\Users\\admin\\Desktop\\HIT\\实验1&2.doc','downFile',1,NULL),(3,'第三组实验报告','C:\\Users\\admin\\Desktop\\HIT\\实验1&2.doc','upFile',1,2),(4,'实验指导书','C:\\Users\\admin\\Desktop\\HIT\\实验1&2.doc','downFile',1,NULL),(6,'实验指导书','C:\\Users\\admin\\Desktop\\HIT\\实验1&2.doc','downFile',1,NULL),(7,'第三组实验报告','C:\\Users\\admin\\Desktop\\HIT\\实验1&2.doc','upFile',1,2);

UNLOCK TABLES;

/*Table structure for table `discussion` */

DROP TABLE IF EXISTS `discussion`;

CREATE TABLE `discussion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `published_time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonIdDiscussion` (`lesson_id`),
  CONSTRAINT `lessonIdDiscussion` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `discussion` */

LOCK TABLES `discussion` WRITE;

insert  into `discussion`(`id`,`lesson_id`,`title`,`published_time`) values (1,1,'这周末实验课什么时间开始？','1576863841551'),(2,2,'期末考试重点考哪些','1576946190736'),(4,1,'这周末实验课什么时间开始？','1576863858917'),(5,1,'这周末实验课什么时间开始？','1576946103943'),(6,1,'这周末实验课什么时间开始？','1576946190789');

UNLOCK TABLES;

/*Table structure for table `exampaper` */

DROP TABLE IF EXISTS `exampaper`;

CREATE TABLE `exampaper` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `published_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `last_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `lesson_id` int(11) NOT NULL,
  `sublesson_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonIdExampaper` (`lesson_id`),
  KEY `sublessonIdExampaper` (`sublesson_id`),
  CONSTRAINT `lessonIdExampaper` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `sublessonIdExampaper` FOREIGN KEY (`sublesson_id`) REFERENCES `sublesson` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `exampaper` */

LOCK TABLES `exampaper` WRITE;

insert  into `exampaper`(`id`,`published_time`,`last_time`,`lesson_id`,`sublesson_id`) values (1,'1576777696613','2400',1,1),(2,'1576946193167','2400',1,2),(4,'1576777702321','2400',2,10),(5,'1576946106193','2400',1,1),(6,'1576946193239','2400',1,1);

UNLOCK TABLES;

/*Table structure for table `lesson` */

DROP TABLE IF EXISTS `lesson`;

CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `introduction` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `time_start` varchar(20) COLLATE utf8_bin NOT NULL,
  `time_end` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `image` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `lesson` */

LOCK TABLES `lesson` WRITE;

insert  into `lesson`(`id`,`name`,`introduction`,`time_start`,`time_end`,`password`,`image`) values (1,'软件构造','这是一门对你未来的职业生涯有着深远影响的课程。','1576590763288','1576590863288','software','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(2,'数据结构','这是一门对你未来的职业生涯有着深远影响的课程。','1576591187519','1576591287519','date','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(4,'计算机网络','应用层-传输层-网络层-数据链路层-物理层','1576946193587','1576946293587','date','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(5,'软件构造','这是一门对你未来的职业生涯有着深远影响的课程。','1576946106522','1576946206522','software','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(6,'软件构造','这是一门对你未来的职业生涯有着深远影响的课程。','1576946193676','1576946293676','software','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png');

UNLOCK TABLES;

/*Table structure for table `lesson_member` */

DROP TABLE IF EXISTS `lesson_member`;

CREATE TABLE `lesson_member` (
  `lesson_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  KEY `studentId` (`student_id`),
  KEY `lessonIdStu` (`lesson_id`),
  CONSTRAINT `lessonIdStu` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `studentId` FOREIGN KEY (`student_id`) REFERENCES `user_stu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lesson_member` */

LOCK TABLES `lesson_member` WRITE;

insert  into `lesson_member`(`lesson_id`,`student_id`) values (2,2),(4,2),(1,2),(2,4);

UNLOCK TABLES;

/*Table structure for table `lesson_teacher` */

DROP TABLE IF EXISTS `lesson_teacher`;

CREATE TABLE `lesson_teacher` (
  `lesson_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  KEY `teacherId` (`teacher_id`),
  KEY `lessonIdTeacher` (`lesson_id`),
  CONSTRAINT `lessonIdTeacher` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `teacherId` FOREIGN KEY (`teacher_id`) REFERENCES `user_tea` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `lesson_teacher` */

LOCK TABLES `lesson_teacher` WRITE;

insert  into `lesson_teacher`(`lesson_id`,`teacher_id`) values (1,2),(1,5),(2,2),(4,2);

UNLOCK TABLES;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) COLLATE utf8_bin NOT NULL,
  `sender` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  `work_id` bigint(20) DEFAULT NULL,
  `discussion_id` bigint(20) DEFAULT NULL,
  `reply_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonIdMessage` (`lesson_id`),
  KEY `activityIdMessage` (`activity_id`),
  KEY `workIdMessage` (`work_id`),
  KEY `discussionIdMessage` (`discussion_id`),
  KEY `replyIdMessage` (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `message` */

LOCK TABLES `message` WRITE;

insert  into `message`(`id`,`type`,`sender`,`content`,`lesson_id`,`activity_id`,`work_id`,`discussion_id`,`reply_id`) values (1,'activityToast','软件构造','同学，你有一项活动[活动1:完成实验一]待完成，2019-12-21 10:17:33截止，请尽快完成。',1,1,0,0,0),(2,'activityToast','数据结构','同学，你有一项活动[活动1:完成实验二]待完成，2019-12-21 11:03:27截止，请尽快完成。',2,2,0,0,0),(3,'memberDeleteToast','数据结构','你已被移出课程【数据结构】。',2,1,0,0,0),(4,'memberDeleteToast','数据结构','你已被移出课程【数据结构】。',2,1,0,0,0),(6,'teamAddToast','拉普兰德做得到吗','用户 [拉普兰德做得到吗]邀请您加入他的队伍，共同完成活动 [活动1:完成实验二],是否同意加入？',2,2,1,0,0),(7,'activityToast','软件构造','同学，你有一项活动[活动1:完成实验一]待完成，2019-12-21 10:17:33截止，请尽快完成。',1,1,0,0,0),(8,'memberDeleteToast','数据结构','你已被移出课程【数据结构】。',2,1,0,0,0),(9,'teamAddToast','拉普兰德做得到吗','用户 [拉普兰德做得到吗]邀请您加入他的队伍，共同完成活动 [活动1:完成实验二],是否同意加入？',2,2,1,0,0),(10,'activityToast','软件构造','同学，你有一项活动[活动1:完成实验一]待完成，2019-12-21 10:17:33截止，请尽快完成。',1,1,0,0,0),(11,'memberDeleteToast','数据结构','你已被移出课程【数据结构】。',2,1,0,0,0);

UNLOCK TABLES;

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exampaper_id` bigint(11) NOT NULL,
  `introduction` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `options` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `answer` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exampaperIdQuestion` (`exampaper_id`),
  CONSTRAINT `exampaperIdQuestion` FOREIGN KEY (`exampaper_id`) REFERENCES `exampaper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `question` */

LOCK TABLES `question` WRITE;

insert  into `question`(`id`,`exampaper_id`,`introduction`,`options`,`answer`) values (1,1,'软件构造过程中有哪几种视图？','A.xxx\nB.yyy\nC.zzz\nD.uuu','A'),(2,4,'卡农','A.aaa\nB.bbb\nC.ccc\nD.ddd','A'),(4,1,'卡农','A.aaa\nB.bbb\nC.ccc\nD.ddd','A'),(5,1,'软件构造过程中有哪几种视图？','A.xxx\nB.yyy\nC.zzz\nD.uuu','A'),(6,1,'卡农','A.aaa\nB.bbb\nC.ccc\nD.ddd','A'),(7,1,'软件构造过程中有哪几种视图？','A.xxx\nB.yyy\nC.zzz\nD.uuu','A'),(8,1,'卡农','A.aaa\nB.bbb\nC.ccc\nD.ddd','A');

UNLOCK TABLES;

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_identity` varchar(10) COLLATE utf8_bin NOT NULL,
  `user_id` int(11) NOT NULL,
  `time` varchar(20) COLLATE utf8_bin NOT NULL,
  `content` varchar(255) COLLATE utf8_bin NOT NULL,
  `discussion_id` bigint(20) NOT NULL,
  `up_reply_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `upReplyIdReply` (`up_reply_id`),
  KEY `discussionIdReply` (`discussion_id`),
  CONSTRAINT `discussionIdReply` FOREIGN KEY (`discussion_id`) REFERENCES `discussion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `reply` */

LOCK TABLES `reply` WRITE;

insert  into `reply`(`id`,`user_identity`,`user_id`,`time`,`content`,`discussion_id`,`up_reply_id`) values (1,'student',1,'1576874502240','秃头少女为何泪洒松花江',1,0),(2,'student',1,'1576946194421','论排课老师为何总是把所有实验考试都排一起',1,1),(4,'teacher',2,'1576874603612','熬最深的夜，敷最贵的面膜',1,2),(5,'teacher',2,'1576874927108','以及为何授课老师总是在实验课前收作业',1,2),(6,'teacher',2,'1576946107410','以及为何授课老师总是在实验课前收作业',1,2),(7,'student',1,'1576946107484','秃头少女为何泪洒松花江',1,6),(8,'student',1,'1576946107564','秃头少女为何泪洒松花江',1,0),(9,'teacher',2,'1576946194497','以及为何授课老师总是在实验课前收作业',1,2),(10,'student',1,'1576946194587','秃头少女为何泪洒松花江',1,6),(11,'student',1,'1576946194646','秃头少女为何泪洒松花江',1,0);

UNLOCK TABLES;

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `number_all` int(11) DEFAULT NULL,
  `number_wrong` int(11) DEFAULT NULL,
  `number_right` int(11) DEFAULT NULL,
  `number_unfinished` int(11) DEFAULT NULL,
  `exampaper_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `exampaperIdScore` (`exampaper_id`),
  CONSTRAINT `exampaperIdScore` FOREIGN KEY (`exampaper_id`) REFERENCES `exampaper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `score` */

LOCK TABLES `score` WRITE;

insert  into `score`(`id`,`number_all`,`number_wrong`,`number_right`,`number_unfinished`,`exampaper_id`) values (1,12,5,6,1,1),(2,15,3,10,2,4),(4,12,5,6,1,1),(5,12,5,6,1,1),(6,12,5,6,1,1);

UNLOCK TABLES;

/*Table structure for table `student_answer` */

DROP TABLE IF EXISTS `student_answer`;

CREATE TABLE `student_answer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `answer` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `finished_state` int(11) NOT NULL,
  `star_state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `studentIdAnswer` (`student_id`),
  KEY `questionIdAnswer` (`question_id`),
  CONSTRAINT `studentIdAnswer` FOREIGN KEY (`student_id`) REFERENCES `user_stu` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `student_answer` */

LOCK TABLES `student_answer` WRITE;

insert  into `student_answer`(`id`,`question_id`,`student_id`,`answer`,`finished_state`,`star_state`) values (1,1,1,'B',1,0),(2,2,1,'B',1,0),(4,2,1,'B',1,1),(5,1,1,'B',1,0),(6,1,1,'B',1,0);

UNLOCK TABLES;

/*Table structure for table `sublesson` */

DROP TABLE IF EXISTS `sublesson`;

CREATE TABLE `sublesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_bin NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `ppt_url` varchar(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subLesson` (`lesson_id`),
  CONSTRAINT `subLesson` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sublesson` */

LOCK TABLES `sublesson` WRITE;

insert  into `sublesson`(`id`,`name`,`lesson_id`,`ppt_url`) values (1,'敏捷开发',1,'C:'),(2,'瀑布模型',1,'C:'),(4,'数据类型',1,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(5,'二叉树遍历',2,'E:'),(6,'广度优先搜索',2,'F:'),(7,'多维度视图',1,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(8,'数据类型',1,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(9,'二叉树遍历',2,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(10,'广度优先搜索',2,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(11,'多维度视图',1,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(12,'数据类型',1,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(13,'二叉树遍历',2,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(14,'广度优先搜索',2,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(15,'多维度视图',1,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(16,'数据类型',1,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(17,'二叉树遍历',2,'C:\\Users\\admin\\sts-workspace\\LessonServer'),(18,'广度优先搜索',2,'C:\\Users\\admin\\sts-workspace\\LessonServer');

UNLOCK TABLES;

/*Table structure for table `user_discussion` */

DROP TABLE IF EXISTS `user_discussion`;

CREATE TABLE `user_discussion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discussion_id` bigint(20) NOT NULL,
  `user_identity` varchar(10) COLLATE utf8_bin NOT NULL,
  `user_id` int(11) NOT NULL,
  `star_state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `discussionIdUser` (`discussion_id`),
  CONSTRAINT `discussionIdUser` FOREIGN KEY (`discussion_id`) REFERENCES `discussion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_discussion` */

LOCK TABLES `user_discussion` WRITE;

insert  into `user_discussion`(`id`,`discussion_id`,`user_identity`,`user_id`,`star_state`) values (1,2,'student',2,0),(2,2,'student',2,1),(4,2,'student',2,0),(5,2,'student',2,0),(6,2,'student',2,0);

UNLOCK TABLES;

/*Table structure for table `user_message` */

DROP TABLE IF EXISTS `user_message`;

CREATE TABLE `user_message` (
  `message_id` bigint(20) DEFAULT NULL,
  `user_id` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `user_identity` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  KEY `messageIdUser` (`message_id`),
  CONSTRAINT `messageIdUser` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_message` */

LOCK TABLES `user_message` WRITE;

insert  into `user_message`(`message_id`,`user_id`,`user_identity`) values (1,'1','student'),(1,'2','student');

UNLOCK TABLES;

/*Table structure for table `user_stu` */

DROP TABLE IF EXISTS `user_stu`;

CREATE TABLE `user_stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_stu` */

LOCK TABLES `user_stu` WRITE;

insert  into `user_stu`(`id`,`name`,`password`,`image`) values (1,'得克萨斯做得到吗','123456','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(2,'拉普兰德做得到吗','654321','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(4,'拉普兰德做得到吗','lagouzi','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(5,'拉普兰德做得到吗','lagouzi','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png'),(6,'拉普兰德做得到吗','lagouzi','C:\\Users\\admin\\Desktop\\HIT\\images\\logo.png');

UNLOCK TABLES;

/*Table structure for table `user_tea` */

DROP TABLE IF EXISTS `user_tea`;

CREATE TABLE `user_tea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `password` varchar(40) COLLATE utf8_bin NOT NULL,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_tea` */

LOCK TABLES `user_tea` WRITE;

insert  into `user_tea`(`id`,`name`,`password`,`image`) values (2,'yyy','654321','C:\\Users\\admin\\Desktop\\HIT\\images\\logo2.png'),(5,'啊普路派','nengtianshi','C:\\Users\\admin\\Desktop\\HIT\\images\\logo2.png'),(6,'啊普路派','nengtianshi','C:\\Users\\admin\\Desktop\\HIT\\images\\logo2.png'),(7,'啊普路派','nengtianshi','C:\\Users\\admin\\Desktop\\HIT\\images\\logo2.png');

UNLOCK TABLES;

/*Table structure for table `work` */

DROP TABLE IF EXISTS `work`;

CREATE TABLE `work` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `activityIdWork` (`activity_id`),
  CONSTRAINT `activityIdWork` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `work` */

LOCK TABLES `work` WRITE;

insert  into `work`(`id`,`activity_id`) values (1,1),(2,2),(3,2),(4,2),(5,2);

UNLOCK TABLES;

/*Table structure for table `work_member` */

DROP TABLE IF EXISTS `work_member`;

CREATE TABLE `work_member` (
  `work_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  KEY `work_id` (`work_id`),
  KEY `studentIdMember` (`student_id`),
  CONSTRAINT `studentIdMember` FOREIGN KEY (`student_id`) REFERENCES `user_stu` (`id`),
  CONSTRAINT `workIdMember` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `work_member` */

LOCK TABLES `work_member` WRITE;

insert  into `work_member`(`work_id`,`student_id`) values (1,2),(2,2),(3,2),(2,4);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
