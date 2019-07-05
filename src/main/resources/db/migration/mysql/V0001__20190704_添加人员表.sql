/*
 Navicat Premium Data Transfer

 Source Server         : 22
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.0.107:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 04/07/2019 17:48:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `addtime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1146610988566175746 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'xiao', 15, 'xxdd@baomidou.com', '2019-07-03 16:12:37');
INSERT INTO `user` VALUES (2, 'xiao', 18, 'xxdd@baomidou.com', '2019-07-03 16:19:53');
INSERT INTO `user` VALUES (3, 'Jack', 20, 'test2@baomidou.com', '2019-07-03 16:19:53');
INSERT INTO `user` VALUES (4, 'Tom', 28, 'test3@baomidou.com', '2019-07-03 16:19:53');
INSERT INTO `user` VALUES (5, 'Sandy', 21, 'test4@baomidou.com', '2019-07-03 16:19:53');
INSERT INTO `user` VALUES (6, 'Billie', 24, 'test5@baomidou.com', '2019-07-03 16:19:53');
INSERT INTO `user` VALUES (1146610771028541441, '东方不败', 20, 'dfbb@163.com', '2019-07-04 10:44:45');
INSERT INTO `user` VALUES (1146610988566175745, '东方不败1', 20, 'dfbb@163.com', '2019-07-04 10:45:37');

SET FOREIGN_KEY_CHECKS = 1;
