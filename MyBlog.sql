-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

--java Web项目 博客数据库设计与实现


--创建数据库
CREATE DATABASE myblog;
--使用
USER myblog;

--删除myblog数据库
--Drop database myblog;

--删除Users表
--Drop table Users

--删除Users表内全部数据
--Delete from Users;

--用户信息表Users
Create table Users(
	User_id BIGINT(50) AUTO_INCREMENT NOT NULL COMMENT '用户表主键id自增非空',
	User_accountNumber VARCHAR(18) UNIQUE NOT NULL COMMENT '账号唯一非空',
	User_password VARCHAR(3000) NOT NULL DEFAULT '123456' COMMENT '密码非空',
	User_nickname VARCHAR(50) COMMENT '昵称',
	User_headPortrait VARCHAR(300) COMMENT '头像',
	User_jurisdiction Integer DEFAULT 0 NOT NULL COMMENT '用户权限：0普通用户，1会员，2管理员，3最高管理',
	User_autograph VARCHAR(100) DEFAULT '这个人很懒，尚未写签名。' COMMENT '签名',
	User_state INTEGER DEFAULT 1 COMMENT '状态:0离线，1在线，2勿扰',
	User_phone BIGINT(30) COMMENT '手机',
	User_weChatid VARCHAR(30) COMMENT '微信',
  User_mailBox VARCHAR(50) COMMENT '邮箱',
	User_birth DATETIME COMMENT '出生年月日',
	User_realName VARCHAR(50) COMMENT '真实姓名',
	User_idNumber BIGINT(18) COMMENT '身份证号',
	User_register DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '注册时间',
	PRIMARY KEY (User_id)
);

--Users添加一条数据
insert into Users(User_accountNumber) values('张三');

--查找Users表内所有内容
select * from Users;


--系统权限表
create table SystemPermissions(
	Sp_id BIGINT(30) AUTO_INCREMENT NOT NULL COMMENT '系统表主键id',
	Sp_name VARCHAR(50) NOT NULL COMMENT '系统名称',
	Sp_mainRoute VARCHAR(50) NOT NULL COMMENT '系统路径',
	Sp_smallTwo VARCHAR(50) COMMENT '系统二级目录',
	Sp_smallTwoRoute VARCHAR(50) COMMENT '系统二级路径',
	Sp_Basepath VARCHAR(100) NOT NULL COMMENT '系统根目录：http://localhost:8080..',
	Sp_status INTEGER DEFAULT 1 NOT NULL COMMENT '系统状态:0隐藏 1显示',
	Sp_description VARCHAR(50) COMMENT '系统描述',
	Sp_icon VARCHAR(100) NOT NULL COMMENT '样式图标',
	Sp_jurisdiction INTEGER DEFAULT 0 NOT NULL COMMENT '系统权限：0用户等级 1会员等级 2管理等级 3超管等级',
	Sp_order INTEGER DEFAULT 0 COMMENT '系统排序',
	Sp_ctime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
	PRIMARY KEY (Sp_id)
);

















