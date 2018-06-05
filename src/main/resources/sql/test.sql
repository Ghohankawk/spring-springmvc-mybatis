#创建测试数据库
CREATE DATABASE IF NOT EXISTS 'test';
#创建表
CREATE TABLE `h_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `h_key` varchar(255) DEFAULT NULL,
  `h_value` varchar(2500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#插入测试数据
INSERT INTO `h_map` (`h_key`, `h_value`) VALUES ('hello', 'world');