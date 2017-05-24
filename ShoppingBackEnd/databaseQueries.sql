CREATE TABLE category (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);


INSERT INTO category(name,description,image_url,is_active) VALUES ('Laptop','This is description for Laptop Category','CAT_1.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES ('Television','This is description for Television Category','CAT_2.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES ('Mobile','This is description for Mobile Category','CAT_3.png',true);

CREATE TABLE user_detail(
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	dob varchar(20),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);

INSERT INTO user_detail
(first_name,last_name,dob,role,enabled,password,email,contact_number)
VALUES ('Bhayyasaheb','Koke','30/04/1993','ADMIN',true,'SBK@123','bhayyasahebkoke@gmail.com','9730586363');

INSERT INTO user_detail
(first_name,last_name,dob,role,enabled,password,email,contact_number)
VALUES ('Mohan','Lohar','25/06/1993','SUPPLIER',true,'Mohan@123','mohanlohar63@gmail.com','7387828468');

INSERT INTO user_detail
(first_name,last_name,dob,role,enabled,password,email,contact_number)
VALUES ('Mahesh','Zagade','27/11/1991','SUPPLIER',true,'Mahesh@123','maheshzagade@gmail.com','9156330909');

CREATE TABLE product(
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK1','Apple iPhone SE (Rose Gold, 64 GB)','Apple','64 GB ROM,4 inch Retina Display,12MP Primary Camera,1.2MP Front,1440 mAh Li-Ion Battery,A9 Chip with 64-bit Architecture and M9 Motion Co-processor Processor',31350,5,true,3,2);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK2','Apple iPhone 6s Plus (Rose Gold, 128 GB)','Apple','128 GB ROM,5.5 inch Retina HD Display,12MP Primary Camera,5MP Front,2750 mAh Li-Ion Battery,A9 Chip with 64-bit Architecture and M9 Motion Co-processor Processor',59000,5,true,3,2);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK3','Apple iPhone 7 (Black, 32 GB)','Apple','32 GB ROM,4.7 inch Retina HD Display,12MP Primary Camera,7MP Front,Li-Ion Battery,A10 Fusion Chip with 64-bit Architecture and Embedded M10 Motion Co-processor Processor',84000,5,true,3,2);



INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK4','SAMSUNG 139cm (55) Full HD Smart','Samsung',' Your Samsung Curved TV will give you a greater feeling of depth by applying different levels of contrast enhancement to different areas and objects on the screen, making your entertainment more immersive and enjoyable.',98999,5,true,2,3);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK5','SAMSUNG 152cm (60) Ultra HD (4K)','Samsung','Movies like Twilight have a dreamy, almost moody backdrop. To get the full feel of watching them, their print quality has to be good. It helps that you have this Samsung smart TV.',174999,5,true,2,3);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK6','SAMSUNG 138cm (55) Ultra HD (4K) Smart LED TV','Samsung','With the Samsung SUHD 4K Flat Smart TV, your daily dose of entertainment will get better. Watch movies, catch up on TV shows, and stay up-to-date on the latest happenings in better picture clarity and stunning sound quality.',213599,5,true,2,3);



INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK7','Apple MacBook Air Core i5 5th Gen 8 GB/128 GB','Apple','Intel Core i5 Processor ( 5th Gen ),8 GB RAM,Mac OS Operating System,128 GB SSD,13.3 inch Display',56990,5,true,1,2);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK8','Dell Inspiron Core i5 5th Gen - 8 GB /1 TB HDD','Dell','Intel Core i5 Processor ( 5th Gen ),8 GB DDR3 RAM,64 bit Windows 8 Operating System,1 TB HDD,15.6 inch Display',60000,5,true,1,3);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES ('SBK9','Apple Macbook Pro Core i5 - 8 GB/256 GB','Apple','Intel Core i5 Processor ( ),8 GB DDR3 RAM,64 bit Mac OS Operating System,256 GB SSD,13 inch Display',14999,5,true,1,2);


CREATE TABLE user_detail(
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
    dob varchar(20),
    address varchar(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);



INSERT INTO CART (cartitems,grandtotal,user_id,noofcartitems) VALUES (1,'15000',1,2);