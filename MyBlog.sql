-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

--java Web项目 博客数据库设计与实现


--创建数据库
CREATE DATABASE myblog;
--使用数据
USER myblog;

--删除数据库
--Drop database myblog;

--用户信息表
Create table Users(
	User_Id BIGINT(20) AUTO_INCREMENT NOT NULL COMMENT '用户表主键id',
	User_Name VARCHAR(30) NOT NULL COMMENT '账号\昵称',
	User_Pwd VARCHAR(18)  NOT NULL DEFAULT '123456' COMMENT '密码',
	User_Autograph VARCHAR(30) DEFAULT '这个人很懒，尚未写签名。' COMMENT '签名',
	User_State VARCHAR(30) COMMENT '状态',
	User_Phone BIGINT(11) COMMENT '手机号',
	User_RealName VARCHAR(50) COMMENT '真实姓名',
	User_Birth DATE COMMENT '出生年月日',
	User_Register DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
	
	PRIMARY KEY (User_Id)
);

--删除Users表
--Drop table Users

--删除表内全部数据
Delete from Users;

--添加一条数据
insert into Users(User_Name) values('测试cs1');

--查找Users表内所有内容
select * from Users;