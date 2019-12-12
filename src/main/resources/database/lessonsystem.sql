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
  PRIMARY KEY (`id`),
  KEY `lessonIdActivity` (`lesson_id`),
  CONSTRAINT `lessonIdActivity` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `activity` */

LOCK TABLES `activity` WRITE;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `activity_file` */

LOCK TABLES `activity_file` WRITE;

UNLOCK TABLES;

/*Table structure for table `discussion` */

DROP TABLE IF EXISTS `discussion`;

CREATE TABLE `discussion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonIdDiscussion` (`lesson_id`),
  CONSTRAINT `lessonIdDiscussion` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `discussion` */

LOCK TABLES `discussion` WRITE;

UNLOCK TABLES;

/*Table structure for table `exampaper` */

DROP TABLE IF EXISTS `exampaper`;

CREATE TABLE `exampaper` (
  `id` bigint(11) NOT NULL,
  `published_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `last_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `lesson_id` int(11) NOT NULL,
  `sublesson_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonIdExampaper` (`lesson_id`),
  KEY `sublessonIdExampaper` (`sublesson_id`),
  CONSTRAINT `lessonIdExampaper` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `sublessonIdExampaper` FOREIGN KEY (`sublesson_id`) REFERENCES `sublesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `exampaper` */

LOCK TABLES `exampaper` WRITE;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `lesson` */

LOCK TABLES `lesson` WRITE;

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

UNLOCK TABLES;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
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
  KEY `replyIdMessage` (`reply_id`),
  CONSTRAINT `lessonIdMessage` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `activityIdMessage` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`),
  CONSTRAINT `workIdMessage` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `discussionIdMessage` FOREIGN KEY (`discussion_id`) REFERENCES `discussion` (`id`),
  CONSTRAINT `replyIdMessage` FOREIGN KEY (`reply_id`) REFERENCES `reply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `message` */

LOCK TABLES `message` WRITE;

UNLOCK TABLES;

/*Table structure for table `ppt` */

DROP TABLE IF EXISTS `ppt`;

CREATE TABLE `ppt` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `sublesson_id` int(11) NOT NULL,
  `url` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonIdPPT` (`lesson_id`),
  KEY `sublessonIdPPT` (`sublesson_id`),
  CONSTRAINT `lessonIdPPT` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  CONSTRAINT `sublessonIdPPT` FOREIGN KEY (`sublesson_id`) REFERENCES `sublesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ppt` */

LOCK TABLES `ppt` WRITE;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `question` */

LOCK TABLES `question` WRITE;

UNLOCK TABLES;

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_identity` varchar(10) COLLATE utf8_bin NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(20) COLLATE utf8_bin NOT NULL,
  `discussion_id` bigint(20) NOT NULL,
  `up_reply_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `upReplyIdReply` (`up_reply_id`),
  KEY `discussionIdReply` (`discussion_id`),
  CONSTRAINT `discussionIdReply` FOREIGN KEY (`discussion_id`) REFERENCES `discussion` (`id`),
  CONSTRAINT `upReplyIdReply` FOREIGN KEY (`up_reply_id`) REFERENCES `reply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `reply` */

LOCK TABLES `reply` WRITE;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `score` */

LOCK TABLES `score` WRITE;

UNLOCK TABLES;

/*Table structure for table `student_answer` */

DROP TABLE IF EXISTS `student_answer`;

CREATE TABLE `student_answer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `quetion_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `answer` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `finished_state` int(11) NOT NULL,
  `star_state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `studentIdAnswer` (`student_id`),
  KEY `questionIdAnswer` (`quetion_id`),
  CONSTRAINT `questionIdAnswer` FOREIGN KEY (`quetion_id`) REFERENCES `question` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `studentIdAnswer` FOREIGN KEY (`student_id`) REFERENCES `user_stu` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `student_answer` */

LOCK TABLES `student_answer` WRITE;

UNLOCK TABLES;

/*Table structure for table `sublesson` */

DROP TABLE IF EXISTS `sublesson`;

CREATE TABLE `sublesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_bin NOT NULL,
  `lesson_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subLesson` (`lesson_id`),
  CONSTRAINT `subLesson` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sublesson` */

LOCK TABLES `sublesson` WRITE;

UNLOCK TABLES;

/*Table structure for table `user_discussion` */

DROP TABLE IF EXISTS `user_discussion`;

CREATE TABLE `user_discussion` (
  `discussion_id` bigint(20) DEFAULT NULL,
  `user_identity` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `star_state` int(11) DEFAULT NULL,
  KEY `discussionIdUser` (`discussion_id`),
  CONSTRAINT `discussionIdUser` FOREIGN KEY (`discussion_id`) REFERENCES `discussion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_discussion` */

LOCK TABLES `user_discussion` WRITE;

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

UNLOCK TABLES;

/*Table structure for table `user_stu` */

DROP TABLE IF EXISTS `user_stu`;

CREATE TABLE `user_stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_stu` */

LOCK TABLES `user_stu` WRITE;

UNLOCK TABLES;

/*Table structure for table `user_tea` */

DROP TABLE IF EXISTS `user_tea`;

CREATE TABLE `user_tea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(40) COLLATE utf8_bin NOT NULL,
  `password` char(20) COLLATE utf8_bin NOT NULL,
  `image` char(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_tea` */

LOCK TABLES `user_tea` WRITE;

UNLOCK TABLES;

/*Table structure for table `work` */

DROP TABLE IF EXISTS `work`;

CREATE TABLE `work` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `activityIdWork` (`activity_id`),
  CONSTRAINT `activityIdWork` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `work` */

LOCK TABLES `work` WRITE;

UNLOCK TABLES;

/*Table structure for table `work_member` */

DROP TABLE IF EXISTS `work_member`;

CREATE TABLE `work_member` (
  `work_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  KEY `work_id` (`work_id`),
  KEY `studentIdMember` (`student_id`),
  CONSTRAINT `workIdMember` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`),
  CONSTRAINT `studentIdMember` FOREIGN KEY (`student_id`) REFERENCES `user_stu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `work_member` */

LOCK TABLES `work_member` WRITE;

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
