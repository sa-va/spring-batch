drop table products if exists;

create table products (
	id BIGINT IDENTITY NOT NULL PRIMARY KEY,
	product_id BIGINT,
	name VARCHAR(50),
	condition VARCHAR(50),
	state VARCHAR(50),
	price DECIMAL(10,2)	
);