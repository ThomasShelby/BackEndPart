CREATE TABLE user_card (
id bigserial NOT NULL PRIMARY KEY,
nick_name varchar(20) NOT NULL,
first_name varchar(20) DEFAULT NULL,
last_name varchar(20) DEFAULT NULL,
phone varchar(20) DEFAULT NULL,
email varchar(20) DEFAULT NULL,
skype varchar(20) DEFAULT NULL,
address_id varchar(20) DEFAULT NULL,
user_password varchar(20) DEFAULT NULL,
gender varchar(20) DEFAULT NULL,
date_of_birth varchar(20) DEFAULT NULL,
avatarUrl varchar(20) DEFAULT NULL,
creation_date timestamp DEFAULT NULL
);