GRANT ALL PRIVILEGES ON db_ctb.* TO 'ctb'@'localhost' IDENTIFIED BY 'cTb0409';

create database db_ctb;

create table tb_chat_message (
	seq INT AUTO_INCREMENT,
	created_time DATETIME,
	user_seq INT,
	message VARCHAR(1000),
	PRIMARY KEY (seq)
);

create table tb_user (
	seq INT AUTO_INCREMENT,
	user_id VARCHAR(100),
	password VARCHAR(100),
	nickname VARCHAR(100),
	join_date DATETIME,
	del_yn INT,
	PRIMARY KEY (seq),
	UNIQUE KEY (user_id),
	UNIQUE KEY (nickname)
);

insert into tb_user (user_id, password, nickname, join_date) values ('izeye@naver.com', '1234', 'izeye', now());
insert into tb_user (user_id, password, nickname, join_date) values ('icpu@naver.com', '1234', 'icpu', now());
insert into tb_user (user_id, password, nickname, join_date) values ('toujour19@gmail.com', '1234', 'toujour19', now());
insert into tb_user (user_id, password, nickname, join_date) values ('514193717@qq.com', '1234', 'grace', now());
insert into tb_user (user_id, password, nickname, join_date) values ('j.x.tic@hotmail.com', '1234', 'Heidi', now());
insert into tb_user (user_id, password, nickname, join_date) values ('huiyuan989@msn.cn', '1234', 'kelly', now());
insert into tb_user (user_id, password, nickname, join_date) values ('Minjw0@nate.com', '1234', 'min ji won', now());
insert into tb_user (user_id, password, nickname, join_date) values ('mateushenriquebrum@gmail.com', '1234', 'mateusbrum', now());
