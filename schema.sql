GRANT ALL PRIVILEGES ON db_ctb.* TO 'ctb'@'localhost' IDENTIFIED BY 'cTb0409';

create database db_ctb;

create table tb_chat_message (
	id INT AUTO_INCREMENT,
	created_time DATETIME,
	user_id VARCHAR(100),
	message VARCHAR(1000),
	PRIMARY KEY (id)
);