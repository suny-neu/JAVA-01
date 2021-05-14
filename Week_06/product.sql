/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3316
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3316
 Source Schema         : db

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 22/03/2021 09:37:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product_1`  (
  `PRODUCT_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PRODUCT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PRODUCE_TIME` date NULL DEFAULT NULL,
  `BID` int(10) NULL DEFAULT NULL COMMENT '进价',
  `PRICE` decimal(10, 0) NULL DEFAULT NULL COMMENT '售价',
  `COUNT` int(10) NULL DEFAULT NULL COMMENT '数量',
  `DISCOUNT` decimal(10, 0) NULL DEFAULT NULL COMMENT '折扣',
  `TYPE` int(10) NULL DEFAULT NULL COMMENT '1.母婴类 2.正常',
  `SALECOUNT` bigint(10) NULL DEFAULT NULL COMMENT '销售数量',
  `STOCK` bigint(10) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `product_2`  (
  `PRODUCT_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PRODUCT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PRODUCE_TIME` date NULL DEFAULT NULL,
  `BID` int(10) NULL DEFAULT NULL COMMENT '进价',
  `PRICE` decimal(10, 0) NULL DEFAULT NULL COMMENT '售价',
  `COUNT` int(10) NULL DEFAULT NULL COMMENT '数量',
  `DISCOUNT` decimal(10, 0) NULL DEFAULT NULL COMMENT '折扣',
  `TYPE` int(10) NULL DEFAULT NULL COMMENT '1.母婴类 2.正常',
  `SALECOUNT` bigint(10) NULL DEFAULT NULL COMMENT '销售数量',
  `STOCK` bigint(10) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
