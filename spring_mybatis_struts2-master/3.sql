/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.22-log : Database - timecho
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`timecho` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `timecho`;

/*Table structure for table `timecho_block` */

DROP TABLE IF EXISTS `timecho_block`;

CREATE TABLE `timecho_block` (
  `bid` int(10) NOT NULL AUTO_INCREMENT COMMENT '版块id',
  `bowner` tinyint(10) DEFAULT NULL COMMENT '版主id(存在于用户id中)',
  `bdescription` varchar(200) DEFAULT NULL COMMENT '版块的说明',
  `bname` varchar(30) DEFAULT NULL COMMENT '版块名',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `timecho_block` */

insert  into `timecho_block`(`bid`,`bowner`,`bdescription`,`bname`) values (1,2,'跟踪校内校外各种美食，提供专业指引','校园美食'),(2,2,'为大一新生引导，你可以在这里看看学长的各种坑','新生入学'),(3,1,'xxxxxxxxxxxxxxxxxxx运动','运动'),(4,1,'xxxxxxxxxxxxxxxxxxxx生活','生活'),(5,2,'xxxxxx其他','其他');

/*Table structure for table `timecho_comments` */

DROP TABLE IF EXISTS `timecho_comments`;

CREATE TABLE `timecho_comments` (
  `coid` int(10) NOT NULL AUTO_INCREMENT COMMENT '评论id(标识唯一)',
  `author` int(10) DEFAULT NULL COMMENT '评论作者',
  `created` timestamp NULL DEFAULT NULL COMMENT '评论时间',
  `mail` varchar(200) DEFAULT NULL COMMENT '评论者邮箱',
  `url` varchar(200) DEFAULT NULL COMMENT '评论者网站',
  `cid` int(10) DEFAULT NULL COMMENT '评论所在文章id',
  `text` text COMMENT '评论内容',
  PRIMARY KEY (`coid`),
  KEY `tcomments` (`cid`),
  KEY `tcommentsUserid` (`author`),
  CONSTRAINT `tcomments` FOREIGN KEY (`cid`) REFERENCES `timecho_contents` (`cid`) ON UPDATE CASCADE,
  CONSTRAINT `tcommentsUserid` FOREIGN KEY (`author`) REFERENCES `timecho_user` (`uid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `timecho_comments` */

insert  into `timecho_comments`(`coid`,`author`,`created`,`mail`,`url`,`cid`,`text`) values (9,1,'2018-06-20 05:00:56','13467984613@qq.com','shafish.cn',2,'qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq'),(10,1,'2018-06-20 05:02:51','13467984613@qq.com','shafish.cn',2,'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww'),(11,1,'2018-06-20 05:05:06','13467984613@qq.com','shafish.cn',5,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),(12,NULL,'2018-06-20 12:00:08',NULL,NULL,NULL,NULL),(13,8,'2018-06-20 13:12:13','2874497884@qq.com','shafish.cn',2,'ssssssssssssssssssssssssssssssssssssssssssssssssssss'),(14,8,'2018-06-20 13:27:32','2874497884@qq.com','shafish.cn',2,'本人的第一次留言'),(15,8,'2018-06-20 14:31:33','2874497884@qq.com','shafish.cn',5,'额为喂喂喂喂喂喂喂喂喂嗡嗡嗡娃娃33'),(16,8,'2018-06-20 14:39:44','2874497884@qq.com','shafish.cn',1,'额威威'),(17,8,'2018-06-21 08:44:55','2874497884@qq.com','shafish.cn',13,'噢？？'),(18,8,'2018-06-21 09:10:53','2874497884@qq.com','shafish.cn',13,'那一夜'),(19,8,'2018-06-21 09:25:47','2874497884@qq.com','shafish.cn',13,'tttttt');

/*Table structure for table `timecho_contents` */

DROP TABLE IF EXISTS `timecho_contents`;

CREATE TABLE `timecho_contents` (
  `cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '文章id（标识文章唯一）',
  `title` varchar(200) DEFAULT NULL COMMENT '文章标题',
  `blockid` int(10) DEFAULT NULL COMMENT '文章所属版块',
  `created` timestamp NULL DEFAULT NULL COMMENT '文章创建时间',
  `authorid` int(10) DEFAULT NULL COMMENT '文章作者',
  `text` text COMMENT '文章内容',
  `likes` int(10) DEFAULT NULL COMMENT '文章的点赞数',
  `tag` varchar(16) DEFAULT NULL COMMENT '文章标签',
  PRIMARY KEY (`cid`),
  KEY `contentuser` (`authorid`),
  CONSTRAINT `contentuser` FOREIGN KEY (`authorid`) REFERENCES `timecho_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `timecho_contents` */

insert  into `timecho_contents`(`cid`,`title`,`blockid`,`created`,`authorid`,`text`,`likes`,`tag`) values (1,'入门第一天',1,'2018-06-05 12:45:31',1,'开心的一天hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh',3,'生活'),(2,'入门第二天',1,'2018-06-19 10:08:28',1,'开心的第二天',3,'食物'),(3,'入门第三天',1,'2018-06-19 10:10:22',2,'开心的第三天',5,'运动'),(4,'入门的第四天',1,'2018-06-19 10:10:44',1,'开心的第四天',1,'eee'),(5,'入门的第五天',1,'2018-06-19 10:11:05',1,'开心的第五天',0,'dddd'),(7,'热热热热',4,'2018-06-21 03:53:27',8,'今天好热',0,'天气'),(13,'今天很开心',4,'2018-06-21 08:37:58',8,'今天很开心今天很开心今天很开心今天很开心今天很开心',1,'生活'),(16,'tete',4,'2018-06-21 09:26:15',8,'tetete',1,NULL);

/*Table structure for table `timecho_user` */

DROP TABLE IF EXISTS `timecho_user`;

CREATE TABLE `timecho_user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id(唯一标识一个用户)',
  `name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '用户电话号码',
  `mail` varchar(200) DEFAULT NULL COMMENT '用户邮箱',
  `url` varchar(200) DEFAULT NULL COMMENT '用户的个人网站(选填)',
  `groupid` tinyint(1) DEFAULT NULL COMMENT '用户组(标记用户的身份 1-普通用户 2-版主 3-管理员)',
  `created` timestamp NULL DEFAULT NULL COMMENT '用户注册时间',
  `introduce` varchar(200) DEFAULT NULL COMMENT '一句话介绍',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `timecho_user` */

insert  into `timecho_user`(`uid`,`name`,`password`,`phone`,`mail`,`url`,`groupid`,`created`,`introduce`) values (1,'张','123456789','13467984613','13467984613@qq.com','shafish.cn',1,'2018-06-05 12:39:01','我叫XXX，来自XX，我性格开朗、为人正直、容易与人相处；平时爱好打篮球、爬山和跑步。我非常高兴也非常荣幸的加入到“XX”这个大家庭中来，这里不仅为我提供了一个成长锻炼、展示自我的良好平台，也让我有机会认识更多的新同事、新朋友。——借此，我非常感谢各位领导，谢谢您们能给我一次这么好的机会。（鞠躬）'),(2,'李四','123456789','13467984612','13467984612@qq.com','shafish.cn',2,'2018-06-05 12:39:33','本人性格热情开朗，待人友好，为人诚实谦虚。工作勤奋，认真负责，能吃苦耐劳，尽职尽责，有耐心。具有亲和力，平易近人，善于与人沟通。 '),(3,'小张','123456789','13467984611','13467984611@qq.com','shafish.cn',1,'2018-06-05 12:40:26','本人性格热情开朗，待人友好，为人诚实谦虚。工作勤奋，认真负责，能吃苦耐劳，尽职尽责，有耐心。具有亲和力，平易近人，善于与人沟通。 '),(8,'发哥','123456789','13467984615','2874497884@qq.com','shafish.cn',1,'2018-06-14 06:56:34','本人性格热情开朗，待人友好，为人诚实谦虚。工作勤奋，认真负责，能吃苦耐劳，尽职尽责，有耐心。具有亲和力，平易近人，善于与人沟通。 ');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
