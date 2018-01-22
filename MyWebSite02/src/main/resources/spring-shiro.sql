/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50131
Source Host           : localhost:3306
Source Database       : spring-shiro

Target Server Type    : MYSQL
Target Server Version : 50131
File Encoding         : 65001

Date: 2018-01-22 22:39:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `permission` varchar(255) NOT NULL COMMENT '权限标识',
  `href` varchar(255) NOT NULL COMMENT '跳转连接',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '2018-01-22 12:24:57', '2018-01-22 12:24:59', 'user:base:view', '/success', '测试权限');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '2018-01-10 11:04:13', '2018-01-10 11:04:16');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(32) NOT NULL,
  `menu_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `FK_jhsm9r7fe3sqewprqnbkqo2dq` (`menu_id`),
  CONSTRAINT `FK_jhsm9r7fe3sqewprqnbkqo2dq` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `FK_mgkho4k9qv9oskd8uq5agwxc9` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(100) NOT NULL COMMENT '登陆名',
  `password` varchar(100) NOT NULL,
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆ip',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_status` bit(1) DEFAULT b'1' COMMENT '是否可登陆,1可以,0不可以',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '信息备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('297ef57d60de38560160de38d4b90000', 'admin', '$2a$08$Xfy6dDar3VJdA5UVgeN5NOkzQucC8CJI7zCmeXRbbZa/Ou7zgwciq', null, null, '\0', '2018-01-10 11:59:14', '2018-01-10 11:59:14', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_fxu3td9m5o7qov1kbdvmn0g0x` (`role_id`),
  CONSTRAINT `FK_fethvr269t6stivlddbo5pxry` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FK_fxu3td9m5o7qov1kbdvmn0g0x` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('297ef57d60de38560160de38d4b90000', '1');
