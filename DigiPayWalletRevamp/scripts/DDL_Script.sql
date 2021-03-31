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

create table add_to_wallet_details(
	gen_payment_details_id numeric (16) PRIMARY KEY,
	user_id numeric (16) NOT NULL,
	payment_id VARCHAR ( 50 ) NOT NULL,
	payer_id  VARCHAR ( 50 ) NOT NULL,
	receipient_name VARCHAR ( 100 ) NOT NULL,
	purchasing_amount numeric (16,2) NOT NULL,
	transaction_fee numeric (16,2) NOT NULL,
	merchant_email_id VARCHAR ( 100 ) NOT NULL,
	merchant_id VARCHAR ( 50 ) NOT NULL,
	payment_status VARCHAR ( 10 ) NOT NULL,
	created_on TIMESTAMP NOT NULL
)

CREATE SEQUENCE gen_payment_details_seq
INCREMENT 1
START 1000;

CREATE TABLE transaction_history (
	transaction_history_id numeric (16) PRIMARY KEY,
	amount numeric (16,2) NOT NULL,
	credit_debit VARCHAR ( 1 ) NOT NULL,
	payment_time TIMESTAMP NOT NULL,
	paid_to VARCHAR ( 100 ),
	received_from VARCHAR ( 100 ),
	status VARCHAR (10),
	created_on TIMESTAMP NOT NULL
);

CREATE SEQUENCE transaction_history_seq
INCREMENT 1
START 1000;

alter table transaction_history add column user_id numeric (16)
ALTER TABLE transaction_history ADD CONSTRAINT fk_transaction_history
      FOREIGN KEY(user_id) 
	  REFERENCES gen_users(users_id)
	  
alter table gen_users add column balance numeric (16,2);
