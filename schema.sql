GRANT ALL PRIVILEGES ON ctbrg.* TO 'ctbrg'@'localhost' IDENTIFIED BY 'ctbrgctbrg2';

create database ctbrg character set utf8;

create table tb_chat_message (
	seq INT AUTO_INCREMENT,
	created_time DATETIME not null,
	user_seq INT not null,
	message VARCHAR(1000) not null,
	PRIMARY KEY (seq)
);

create table tb_user (
	seq INT AUTO_INCREMENT,
	user_id VARCHAR(100) not null,
	password VARCHAR(100) not null,
	nickname VARCHAR(100) not null,
	image MEDIUMBLOB,
	join_date DATETIME not null,
	del_yn INT,
	PRIMARY KEY (seq),
	UNIQUE KEY (user_id),
	UNIQUE KEY (nickname)
);

alter table tb_user add column image MEDIUMBLOB;

alter table tb_user add column role VARCHAR(10) DEFAULT 'user';

insert into tb_user (user_id, password, nickname, join_date) values ('izeye@naver.com', '1234', 'izeye', now());
insert into tb_user (user_id, password, nickname, join_date) values ('icpu@naver.com', '1234', 'icpu', now());
insert into tb_user (user_id, password, nickname, join_date) values ('toujour19@gmail.com', '1234', 'toujour19', now());
insert into tb_user (user_id, password, nickname, join_date) values ('514193717@qq.com', '1234', 'grace', now());
insert into tb_user (user_id, password, nickname, join_date) values ('j.x.tic@hotmail.com', '1234', 'Heidi', now());
insert into tb_user (user_id, password, nickname, join_date) values ('huiyuan989@msn.cn', '1234', 'kelly', now());
insert into tb_user (user_id, password, nickname, join_date) values ('Minjw0@nate.com', '1234', 'min ji won', now());
insert into tb_user (user_id, password, nickname, join_date) values ('mateushenriquebrum@gmail.com', '1234', 'mateusbrum', now());
insert into tb_user (user_id, password, nickname, join_date) values ('enosent7@gmail.com', '1234', 'enosent7', now());
insert into tb_user (user_id, password, nickname, join_date) values ('oasishun@gmail.com', '1234', 'oasishun', now());
insert into tb_user (user_id, password, nickname, join_date) values ('eliza@eliza.com', '1234', 'Eliza', now());

update tb_user set role='staff' where nickname in ('izeye', 'icpu', 'toujour19', 'enosent7', 'oasishun');

create table tb_visit_log (
	seq INT AUTO_INCREMENT,
	visit_date DATETIME not null,
	ip VARCHAR(100) not null,
	uri VARCHAR(100) not null,
	referer VARCHAR(1000),
	user_agent VARCHAR(1000) not null,
	PRIMARY KEY (seq)
);