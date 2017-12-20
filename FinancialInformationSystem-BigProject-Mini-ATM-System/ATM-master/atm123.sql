/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : atm123

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-19 14:06:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_number` varchar(50) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `balance` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('204', '地大支行', '110.0');
INSERT INTO `account` VALUES ('212', '地大支行', '190.0');
INSERT INTO `account` VALUES ('217', '地大支行', '300');

-- ----------------------------
-- Table structure for borrower
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
  `customer_name` varchar(50) DEFAULT NULL,
  `loan_number` varchar(50) DEFAULT NULL,
  `card_number` int(50) NOT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrower
-- ----------------------------
INSERT INTO `borrower` VALUES ('谭1', '376', '10011');
INSERT INTO `borrower` VALUES ('谭2', '392', '10055');
INSERT INTO `borrower` VALUES ('谭3', '332', '10084');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_name` varchar(50) NOT NULL,
  `customer_street` varchar(50) DEFAULT NULL,
  `customer_city` varchar(50) DEFAULT NULL,
  `credit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('谭1', '小谷围1', '广州1', '0');
INSERT INTO `customer` VALUES ('谭2', '小谷围2', '广州2', '1');
INSERT INTO `customer` VALUES ('谭3', '小谷围3', '广州3', '2');

-- ----------------------------
-- Table structure for depositor
-- ----------------------------
DROP TABLE IF EXISTS `depositor`;
CREATE TABLE `depositor` (
  `customer_name` varchar(50) DEFAULT NULL,
  `account_number` varchar(50) DEFAULT NULL,
  `card_number` int(50) NOT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depositor
-- ----------------------------
INSERT INTO `depositor` VALUES ('谭1', '204', '10011');
INSERT INTO `depositor` VALUES ('谭2', '212', '10055');
INSERT INTO `depositor` VALUES ('谭3', '217', '10084');

-- ----------------------------
-- Table structure for loan
-- ----------------------------
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan` (
  `loan_number` varchar(50) NOT NULL,
  `branch_name` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`loan_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loan
-- ----------------------------
INSERT INTO `loan` VALUES ('332', '地大支行', '0');
INSERT INTO `loan` VALUES ('376', '地大支行', '0');
INSERT INTO `loan` VALUES ('392', '地大支行', '0');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `customer_name` varchar(50) NOT NULL,
  `card_style` varchar(50) NOT NULL,
  `card_number` int(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('谭1', '农行信用卡', '10011', '111111');
INSERT INTO `login` VALUES ('谭2', '中行信用卡', '10055', '222222');
INSERT INTO `login` VALUES ('谭3', '建设信用卡', '10084', '333333');
