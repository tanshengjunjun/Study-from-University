/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : atm123

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-08 14:21:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `customer_name` varchar(50) DEFAULT NULL,
  `card_number` varchar(50) NOT NULL,
  `account_number` varchar(50) DEFAULT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `balance` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (null, '1000', null, null, null);
INSERT INTO `account` VALUES (null, '2000', null, null, null);

-- ----------------------------
-- Table structure for borrower
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
  `customer_name` varchar(50) DEFAULT NULL,
  `loan_number` varchar(50) DEFAULT NULL,
  `card_number` varchar(50) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrower
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_name` varchar(50) DEFAULT NULL,
  `credit` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for depositor
-- ----------------------------
DROP TABLE IF EXISTS `depositor`;
CREATE TABLE `depositor` (
  `customer_name` varchar(50) DEFAULT NULL,
  `account_number` varchar(50) DEFAULT NULL,
  `card_number` varchar(50) DEFAULT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `balance` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depositor
-- ----------------------------
INSERT INTO `depositor` VALUES (null, null, '1000', null, null);
INSERT INTO `depositor` VALUES (null, null, '2000', null, null);

-- ----------------------------
-- Table structure for loan
-- ----------------------------
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan` (
  `customer_name` varchar(50) DEFAULT NULL,
  `loan_number` varchar(50) DEFAULT NULL,
  `card_number` varchar(50) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loan
-- ----------------------------

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `customer_name` varchar(50) NOT NULL,
  `card_style` varchar(50) NOT NULL,
  `card_number` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('张三', 'VIP', '1000', '1111');
INSERT INTO `login` VALUES ('李四', 'SVIP', '2000', '2222');
