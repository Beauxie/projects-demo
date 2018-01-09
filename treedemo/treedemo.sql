CREATE DATABASE treedemo;
USE treedemo;

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : treedemo

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` varchar(32) NOT NULL,
  `pid` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(32) ,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('0a22ff1186f24a6b9189ae0bccc37528', '9ebd264055aa4f5b9112db58c338e94e', '广告部1','dept');
INSERT INTO `dept` VALUES ('2c9153620f6344bda08ed1b238a4cdf0', 'e99e1e819fce4dac8054d8c42e4854ab', '业务部','dept');
INSERT INTO `dept` VALUES ('2f83c97cb5464890bba8291b51bd61a8', 'e99e1e819fce4dac8054d8c42e4854ab', '研发部','dept');
INSERT INTO `dept` VALUES ('33f0fbc0243743cfa615714b1764fcf7', 'da7b002944dd41d0bf7c00120b94bb48', '财务部','dept');
INSERT INTO `dept` VALUES ('3b70590f02e1486a967b2eb3463d024c', '779df9d28040485781768a08ead27567', '活动部','dept');
INSERT INTO `dept` VALUES ('779df9d28040485781768a08ead27567', 'e99e1e819fce4dac8054d8c42e4854ab', '企划部','dept');
INSERT INTO `dept` VALUES ('7ac8139930fb4a5fb4fd5412e2aa87bf', 'e99e1e819fce4dac8054d8c42e4854ab', '销售部','dept');
INSERT INTO `dept` VALUES ('9ebd264055aa4f5b9112db58c338e94e', 'df6253b3095c4d2c8083ef9cd4074b40', '广告部','dept');
INSERT INTO `dept` VALUES ('b7091fb6a38149079d07911d4b5a9537', '9ebd264055aa4f5b9112db58c338e94e', '广告部2','dept');
INSERT INTO `dept` VALUES ('da7b002944dd41d0bf7c00120b94bb48', 'e99e1e819fce4dac8054d8c42e4854ab', '运营部','dept');
INSERT INTO `dept` VALUES ('df6253b3095c4d2c8083ef9cd4074b40', '33f0fbc0243743cfa615714b1764fcf7', '策划部','dept');
INSERT INTO `dept` VALUES ('e99e1e819fce4dac8054d8c42e4854ab', '00000000000000000000000000000000', '示例单位','unit');



