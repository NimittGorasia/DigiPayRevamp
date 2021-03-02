DROP TABLE gen_users;


CREATE TABLE gen_users (
	book_id numeric (16) PRIMARY KEY,
	title VARCHAR ( 100 ) NOT NULL,
	description VARCHAR ( 1000 ) NOT NULL,
	image VARCHAR ( 100 ) NOT NULL,
	price numeric (16,2) NOT NULL,
	author VARCHAR ( 100 ) NOT NULL,
	genre VARCHAR ( 100 ) NOT NULL,
	created_on TIMESTAMP NOT NULL
);

alter table gen_users alter column password type character varying(70);

truncate gen_users;

ALTER TABLE gen_users 
ADD COLUMN first_name character varying(100);

ALTER TABLE gen_users 
RENAME COLUMN user_name 
TO last_name;

ALTER TABLE public.gen_users DROP COLUMN phone;

ALTER TABLE public.gen_users
    ADD COLUMN phone numeric(10,0) NOT NULL unique;


ALTER TABLE gen_users
ALTER COLUMN email SET NOT NULL;

ALTER TABLE gen_users
ALTER COLUMN first_name SET NOT NULL;


CREATE TABLE book_details (
	book_id numeric (16) PRIMARY KEY,
	title VARCHAR ( 100 ) NOT NULL,
	description VARCHAR ( 1000 ) NOT NULL,
	image VARCHAR ( 100 ) NOT NULL,
	price numeric (16,2) NOT NULL,
	author VARCHAR ( 100 ) NOT NULL,
	genre VARCHAR ( 100 ) NOT NULL,
	created_on TIMESTAMP NOT NULL
);


CREATE SEQUENCE book_details_seq
INCREMENT 1
START 1000;