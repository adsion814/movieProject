/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : movieproject

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-20 13:25:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sensitiveword`
-- ----------------------------
DROP TABLE IF EXISTS `sensitiveword`;
CREATE TABLE `sensitiveword` (
  `word` varchar(255) NOT NULL,
  PRIMARY KEY (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sensitiveword
-- ----------------------------

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `uuid` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(16) NOT NULL,
  `identity` int(4) NOT NULL DEFAULT '2',
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `videobarrage`
-- ----------------------------
DROP TABLE IF EXISTS `videobarrage`;
CREATE TABLE `videobarrage` (
  `videouuid` varchar(255) NOT NULL,
  `barrage` varchar(255) NOT NULL,
  `useruuid` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  KEY `videouuid` (`videouuid`),
  KEY `useruuid` (`useruuid`),
  CONSTRAINT `videobarrage_ibfk_1` FOREIGN KEY (`videouuid`) REFERENCES `videoinfo` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `videobarrage_ibfk_2` FOREIGN KEY (`useruuid`) REFERENCES `userinfo` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videobarrage
-- ----------------------------

-- ----------------------------
-- Table structure for `videocomment`
-- ----------------------------
DROP TABLE IF EXISTS `videocomment`;
CREATE TABLE `videocomment` (
  `videouuid` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `useruuid` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  KEY `videouuid` (`videouuid`),
  KEY `useruuid` (`useruuid`),
  CONSTRAINT `videocomment_ibfk_1` FOREIGN KEY (`videouuid`) REFERENCES `videoinfo` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `videocomment_ibfk_2` FOREIGN KEY (`useruuid`) REFERENCES `userinfo` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videocomment
-- ----------------------------

-- ----------------------------
-- Table structure for `videoinfo`
-- ----------------------------
DROP TABLE IF EXISTS `videoinfo`;
CREATE TABLE `videoinfo` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `duration` varchar(255) NOT NULL,
  `hot` int(11) DEFAULT '0',
  `uploadTime` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `uploadUser` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `check` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videoinfo
-- ----------------------------
INSERT INTO `videoinfo` VALUES ('gjkshgksrhgos', 'test.mp4', 'videosource/test.mp4', '1:34', '0', '2017/11/20 10:59', '其他', '林皖敏', '测试视频', '0');
