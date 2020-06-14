CREATE DATABASE if not exists `demo-spring-boot-jdbc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE `demo-spring-boot-jdbc`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- user
-- id
-- 用户名
-- 密码
-- 昵称
-- 性别
-- 生日
-- 城市
-- 个性签名
-- 创建时间
-- 修改时间
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar (64) NOT NULL,
  `username` varchar (64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar (255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;