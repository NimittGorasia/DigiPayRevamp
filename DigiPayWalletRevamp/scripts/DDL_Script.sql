CREATE TABLE gen_users (
	users_id numeric (16) PRIMARY KEY,
	first_name VARCHAR ( 100 ) NOT NULL,
	last_name VARCHAR ( 100 ),
	password VARCHAR ( 50 ) NOT NULL,
	phone numeric (10) NOT NULL,
	email VARCHAR ( 255 ),
	created_on TIMESTAMP NOT NULL,
	isActive VARCHAR ( 1 ) NOT NULL, 
    last_login TIMESTAMP 
);