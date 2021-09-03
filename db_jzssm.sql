/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : db_jzssm

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 03/09/2021 08:35:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_info
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号\r\n',
  `postcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `companyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
  `tel1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办公电话1',
  `tel2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办公电话2',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  `admin_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `admin_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员性别',
  `admin_createtime` datetime NULL DEFAULT NULL COMMENT '管理员创建时间',
  `admin_updatetime` datetime NULL DEFAULT NULL COMMENT '管理员更新信息时间',
  `admin_role` int(255) NULL DEFAULT NULL COMMENT '角色 1为管理员 2为用户 3为导游从业者',
  `admin_telnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员手机号',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (58716763, 'admin', '202cb962ac59075b964b07152d234b70', NULL, '2021-01-17 12:39:03', '2021-01-17 12:39:03', 1, '13095986139');
INSERT INTO `tb_admin` VALUES (70506881, 'admin', '202cb962ac59075b964b07152d234b70', NULL, '2021-01-17 12:56:37', '2021-01-17 12:56:37', 1, '123456789');

-- ----------------------------
-- Table structure for tb_employer
-- ----------------------------
DROP TABLE IF EXISTS `tb_employer`;
CREATE TABLE `tb_employer`  (
  `employer_id` int(11) NOT NULL COMMENT '从业者ID',
  `employer_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者姓名',
  `employer_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `employer_age` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者年龄',
  `employer_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者身份证号',
  `employer_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者家庭地址',
  `employer_telnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者联系电话',
  `employer_postname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者职称类型',
  `employer_field` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者擅长领域',
  `employer_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从业者个人描述',
  `employer_role` int(255) NULL DEFAULT NULL COMMENT '从业者角色 1为管理员 2为用户 3为导游从业者',
  PRIMARY KEY (`employer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_employer
-- ----------------------------
INSERT INTO `tb_employer` VALUES (1185304, '欧阳锋', '202cb962ac59075b964b07152d234b70', '30', '1302658974561231123156', '郑州', '123456789', '1', '1', '11111', 2);
INSERT INTO `tb_employer` VALUES (20022867, '天上童姥', '202cb962ac59075b964b07152d234b70', '30', '546551323216546231987456', '郑州', '13095986139', '4', '3', '差不多', 2);
INSERT INTO `tb_employer` VALUES (23333865, '四大恶人', '202cb962ac59075b964b07152d234b70', '30', '546551323216546231987456', '郑州', '13095986137', '2', '4', '也还好', 2);
INSERT INTO `tb_employer` VALUES (23859466, 'sss', '202cb962ac59075b964b07152d234b70', '18', NULL, NULL, '123456', '2', '1', NULL, 2);
INSERT INTO `tb_employer` VALUES (43765997, '赵灵儿', '202cb962ac59075b964b07152d234b70', '30', '12323465453432', '郑州', '13095986136', '5', '4', '差不多', 2);
INSERT INTO `tb_employer` VALUES (47858515, '飞天小女警', '202cb962ac59075b964b07152d234b70', '18', NULL, 'sasas', '123456', '1', '1', 'zhenh', 2);
INSERT INTO `tb_employer` VALUES (52793760, '无崖子', '202cb962ac59075b964b07152d234b70', '30', '546551323216546231987456', '郑州', '13095986135', '5', '5', '头牌', 2);
INSERT INTO `tb_employer` VALUES (58500829, '212121', '202cb962ac59075b964b07152d234b70', '18', NULL, NULL, '11111111111111111', '1', '2', NULL, 2);
INSERT INTO `tb_employer` VALUES (97672387, '慕容复', '202cb962ac59075b964b07152d234b70', '30', '546551323216546231987456', '郑州', '13095986134', '4', '1', '优质', 2);

-- ----------------------------
-- Table structure for tb_msg
-- ----------------------------
DROP TABLE IF EXISTS `tb_msg`;
CREATE TABLE `tb_msg`  (
  `msg_id` int(11) NOT NULL COMMENT '编号',
  `msg_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '留言人',
  `msg_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '留言内容',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建时间',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '留言人',
  `user_role` int(11) NULL DEFAULT NULL COMMENT '留言人角色',
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_msg
-- ----------------------------
INSERT INTO `tb_msg` VALUES (605749, 'admin', '爱撒谎说', '2021-04-18 15:08:01', 'admin', 3);
INSERT INTO `tb_msg` VALUES (14150193, '我得', '爱的芬芳', '2021-04-18 09:34:16', 'admin', 1);
INSERT INTO `tb_msg` VALUES (25833553, 'admin', '11111111111111111111111111111111', '2021-04-18 15:29:48', 'admin', 3);
INSERT INTO `tb_msg` VALUES (30404691, '飒飒', '阿萨', '2021-04-17 22:13:58', '一灯大师', 3);
INSERT INTO `tb_msg` VALUES (33715580, '阿萨', '分分分', '2021-04-17 22:15:28', '一灯大师', 3);
INSERT INTO `tb_msg` VALUES (38386233, '飒飒', '撒', '2021-04-17 22:08:16', '一灯大师', 3);
INSERT INTO `tb_msg` VALUES (49112899, '阿萨金刚砂看', '飒飒金沙江看过', '2021-04-18 14:51:57', '一灯大师', 3);
INSERT INTO `tb_msg` VALUES (63592461, '飒飒撒', '啊飒飒', '2021-04-18 09:33:40', '欧阳锋', 2);
INSERT INTO `tb_msg` VALUES (64522369, 'admin', '12131321321', '2021-04-18 15:08:40', 'admin', 3);
INSERT INTO `tb_msg` VALUES (99555841, '啊飒飒', '啊飒飒', '2021-04-17 22:07:38', '一灯大师', 3);

-- ----------------------------
-- Table structure for tb_msg_response
-- ----------------------------
DROP TABLE IF EXISTS `tb_msg_response`;
CREATE TABLE `tb_msg_response`  (
  `res_id` int(11) NOT NULL,
  `res_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '留言回复内容',
  `res_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '回复人',
  `res_time` datetime NULL DEFAULT NULL COMMENT '回复时间',
  `msg_id` int(11) NULL DEFAULT NULL COMMENT '留言编号',
  `res_user_id` int(11) NULL DEFAULT NULL COMMENT '留言人id',
  PRIMARY KEY (`res_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_msg_response
-- ----------------------------
INSERT INTO `tb_msg_response` VALUES (5935230, '啊飒飒', '3', '2021-04-17 22:09:17', 38386233, 43082257);
INSERT INTO `tb_msg_response` VALUES (33805193, '的人发士大夫地方', '1', '2021-04-18 15:08:56', 605749, 70506881);
INSERT INTO `tb_msg_response` VALUES (39761416, '飒飒', '3', '2021-04-17 21:43:53', 58265095, 43082257);
INSERT INTO `tb_msg_response` VALUES (43516953, '说的啥', '1', '2021-04-18 09:37:35', 25833553, 70506881);
INSERT INTO `tb_msg_response` VALUES (44341327, '你干啥呢', '1', '2021-04-17 19:35:37', 67456221, 70506881);
INSERT INTO `tb_msg_response` VALUES (45636072, '飒飒', '3', '2021-04-17 22:11:42', 38386233, 43082257);
INSERT INTO `tb_msg_response` VALUES (60089679, '阿萨数据库和嘎就开始了哈高科就是', '3', '2021-04-18 14:52:07', 33715580, 43082257);
INSERT INTO `tb_msg_response` VALUES (78487990, '飒飒撒', '3', '2021-04-17 22:11:17', 99555841, 43082257);
INSERT INTO `tb_msg_response` VALUES (83524748, '啊啊飒飒', '2', '2021-04-18 14:55:41', 14150193, 1185304);
INSERT INTO `tb_msg_response` VALUES (88769060, '啊实打实打算', '2', '2021-04-18 09:41:34', 14150193, 1185304);
INSERT INTO `tb_msg_response` VALUES (91098111, '这是啊哈', '3', '2021-04-17 22:15:46', 33715580, 43082257);
INSERT INTO `tb_msg_response` VALUES (98540460, '呆着呢', '1', '2021-04-17 17:28:49', 67456221, 70506881);

-- ----------------------------
-- Table structure for tb_pkstar
-- ----------------------------
DROP TABLE IF EXISTS `tb_pkstar`;
CREATE TABLE `tb_pkstar`  (
  `pk_id` int(11) NOT NULL,
  `pk_star_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '星数量',
  `pk_emp_namer` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职工姓名',
  `pk_emp_id` int(11) NULL DEFAULT NULL COMMENT '职工id',
  `pk_update_time` datetime NULL DEFAULT NULL COMMENT '评星时间',
  `pk_give_star_role` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '评星人角色',
  `pk_give_star_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '评星人姓名',
  `pk_give_star_id` int(11) NULL DEFAULT NULL COMMENT '评星人id',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_pkstar
-- ----------------------------
INSERT INTO `tb_pkstar` VALUES (19868911, '5', '212121', 58500829, '2021-05-08 21:43:47', '1', 'admin', 58716763);
INSERT INTO `tb_pkstar` VALUES (41264970, '1', '欧阳锋', 1185304, '2021-05-08 22:23:38', '1', 'admin', 58716763);
INSERT INTO `tb_pkstar` VALUES (42093400, '3', '飞天小女警', 47858515, '2021-04-17 19:40:13', '1', 'admin', 70506881);
INSERT INTO `tb_pkstar` VALUES (58762560, '3', '赵灵儿', 43765997, '2021-04-17 18:07:54', '1', 'admin', 70506881);
INSERT INTO `tb_pkstar` VALUES (85854713, '5', '天上童姥', 20022867, '2021-04-17 20:47:21', '3', '一灯大师', 43082257);
INSERT INTO `tb_pkstar` VALUES (90325392, '4', '无崖子', 52793760, '2021-04-18 15:10:06', '1', 'admin', 70506881);

-- ----------------------------
-- Table structure for tb_require_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_require_user`;
CREATE TABLE `tb_require_user`  (
  `req_id` int(11) NOT NULL COMMENT '需求编号',
  `req_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '需求类型',
  `req_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '需求描述',
  `req_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '需求创建时间',
  `req_check_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '需求审核时间',
  `req_check_role` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '审核人角色',
  `req_check_role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '审核人ID',
  `req_do_emp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职工姓名',
  `req_do_emp_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职工ID',
  `req_do_emp_postname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职工星数',
  `req_user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `req_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`req_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_require_user
-- ----------------------------
INSERT INTO `tb_require_user` VALUES (20326648, '1', 'z对人体地方yuck', '2021-04-18 14:48:02', NULL, NULL, NULL, '天上童姥', '20022867', '5', 43082257, '一灯大师');
INSERT INTO `tb_require_user` VALUES (22728830, '1', '点啥的上的水', '2021-04-18 14:48:54', NULL, NULL, NULL, '欧阳锋', '1185304', '5', 43082257, '一灯大师');
INSERT INTO `tb_require_user` VALUES (39506496, '3', 'dsfdf幸福', '2021-04-17 22:38:58', 'admin', '1', '70506881', '欧阳锋', '1185304', '5', 43082257, '一灯大师');
INSERT INTO `tb_require_user` VALUES (45257730, '4', 'lkljlkj', '2021-05-08 22:36:30', NULL, NULL, NULL, '四大恶人', '23333865', '2', 37499798, '段克制');
INSERT INTO `tb_require_user` VALUES (62831917, '1', 'ssss', '2021-05-08 21:11:22', NULL, NULL, NULL, '无崖子', '52793760', '4', 37499798, '段克制');
INSERT INTO `tb_require_user` VALUES (63610188, '1', '啊是大', '2021-04-17 22:38:48', 'admin', '1', '70506881', '欧阳锋', '1185304', '5', 43082257, '一灯大师');
INSERT INTO `tb_require_user` VALUES (67366589, '1', '飒飒', '2021-05-08 21:23:51', NULL, NULL, NULL, '慕容复', '97672387', '', 37499798, '段克制');
INSERT INTO `tb_require_user` VALUES (69282441, '1', 'ssss', '2021-05-08 21:11:00', NULL, NULL, NULL, '天上童姥', '20022867', '5', 37499798, '段克制');
INSERT INTO `tb_require_user` VALUES (90268237, '3', '大苏打实打实的', '2021-04-18 14:48:30', NULL, NULL, NULL, '天上童姥', '20022867', '3', 43082257, '一灯大师');
INSERT INTO `tb_require_user` VALUES (99233592, '1', 'sss', '2021-05-08 21:11:07', NULL, NULL, NULL, '飞天小女警', '47858515', '3', 37499798, '段克制');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_telnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `user_demand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户需求',
  `user_urgent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否加急',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `user_dispatch_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户派遣地址',
  `user_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户角色 1为管理员 2为用户 3为导游从业者',
  `user_other_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户其他描述',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (16275724, '爱习学习', '14e1b600b1fd579f47433b88e8d85291', '12345678', '2', '1', '案件看哈客户', '撒大苏打', '3', '所有丢失月底速度');
INSERT INTO `tb_user` VALUES (17338134, 'we', '202cb962ac59075b964b07152d234b70', '1212323', NULL, NULL, NULL, NULL, '3', NULL);
INSERT INTO `tb_user` VALUES (21966562, '1212', '202cb962ac59075b964b07152d234b70', '1212', NULL, NULL, NULL, NULL, '3', NULL);
INSERT INTO `tb_user` VALUES (25909364, '张三', '14e1b600b1fd579f47433b88e8d85291', '12345', NULL, NULL, '阿萨飒飒', '啊飒飒', '3', 'ghgjhg');
INSERT INTO `tb_user` VALUES (37499798, '段克制', '202cb962ac59075b964b07152d234b70', '13095986139', '5', '2', '河南省郑州市', '河南省郑州市', '3', '公积金韩国');
INSERT INTO `tb_user` VALUES (43082257, '一灯大师', '202cb962ac59075b964b07152d234b70', '123456789', NULL, NULL, '河南省郑州市', '河南省开封市', '3', '1我是一灯大师');
INSERT INTO `tb_user` VALUES (54906664, 'as', '49a4cf478dc45c75a37d85027642e517', '789', NULL, NULL, '12332342', '12132', '3', '去问驱蚊器');
INSERT INTO `tb_user` VALUES (57529701, '想啊想啊想', '202cb962ac59075b964b07152d234b70', '1234544444444', NULL, NULL, NULL, NULL, '3', NULL);
INSERT INTO `tb_user` VALUES (66402151, 'we', '202cb962ac59075b964b07152d234b70', '23242342423', NULL, NULL, NULL, NULL, '3', NULL);
INSERT INTO `tb_user` VALUES (76314594, '啊飒飒', 'e10adc3949ba59abbe56e057f20f883e', '12333', '2', '1', '啊倒萨大苏打', '是的是的', '3', '点啥的');
INSERT INTO `tb_user` VALUES (97600461, 'eww', '202cb962ac59075b964b07152d234b70', '122321313', NULL, NULL, NULL, NULL, '3', NULL);

-- ----------------------------
-- Table structure for tb_work
-- ----------------------------
DROP TABLE IF EXISTS `tb_work`;
CREATE TABLE `tb_work`  (
  `work_id` int(11) NOT NULL,
  `work_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `work_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `work_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`work_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of tb_work
-- ----------------------------
INSERT INTO `tb_work` VALUES (1, '保安', '1', '负责安保等相关工作');
INSERT INTO `tb_work` VALUES (8112106, '护工', '4', 'v方法得到高分如违反v操作');
INSERT INTO `tb_work` VALUES (9631209, '保镖', '3', '抢沙发的吗');
INSERT INTO `tb_work` VALUES (89456800, '保洁', '2', '；；');

SET FOREIGN_KEY_CHECKS = 1;
