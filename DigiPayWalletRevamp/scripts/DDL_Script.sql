DROP TABLE gen_users;


CREATE TABLE gen_users (
	users_id numeric (16) PRIMARY KEY,
	first_name VARCHAR ( 100 ) NOT NULL,
	last_name VARCHAR ( 100 ) NOT NULL,
	password VARCHAR ( 70 ) NOT NULL,
	phone numeric (10) NOT NULL UNIQUE,
	email VARCHAR ( 255 ) NOT NULL,
	created_on TIMESTAMP NOT NULL,
	isActive VARCHAR ( 1 ) NOT NULL, 
    last_login TIMESTAMP 
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