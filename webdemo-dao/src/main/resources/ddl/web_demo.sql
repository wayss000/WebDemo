/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50634
Source Host           : 127.0.0.1:3306
Source Database       : web_demo

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2018-12-14 00:50:53
*/

/*
SET FOREIGN_KEY_CHECKS=0;取消外键约束

Mysql中如果表和表之间建立的外键约束，则无法删除表及修改表结构。

解决方法是在Mysql中取消外键约束:  SET FOREIGN_KEY_CHECKS=0;

然后将原来表的数据导出到sql语句，重新创建此表后，再把数据使用sql导入，

然后再设置外键约束: SET FOREIGN_KEY_CHECKS=1;
 */
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Create Dababase
-- ----------------------------
CREATE DATABASE web_demo;

USE web_demo;

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `height` float DEFAULT NULL COMMENT '身高',
  `weight` float DEFAULT NULL COMMENT '体重',
  `interests` varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员表';

-- ----------------------------
-- Table structure for user_auth
-- ----------------------------
DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE `user_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';
