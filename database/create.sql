DROP TABLE IF EXISTS user_types ;
DROP TABLE IF EXISTS users ;
DROP TABLE IF EXISTS customers ;

CREATE TABLE user_types (
	user_type_id int,
	user_type varchar(20) NOT NULL,
	PRIMARY KEY (user_type_id)
);

CREATE INDEX idx_user_types_user_type ON user_types(user_type); 

CREATE TABLE users (
	user_id bigint unsigned AUTO_INCREMENT,
	username varchar(20),
	password varchar(20) NOT NULL,  
	user_type_id int NOT NULL, 
	PRIMARY KEY (user_id),
	FOREIGN KEY (user_type_id) REFERENCES user_types(user_type_id) ON UPDATE CASCADE
);

CREATE INDEX idx_users_username ON users(username);

CREATE TABLE customers (
	customer_id int NOT NULL,
	customer_name varchar(40) NOT NULL UNIQUE,
	description varchar(400),
	PRIMARY KEY (customer_id)
); 
