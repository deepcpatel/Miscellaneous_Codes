create database Lab1;

use Lab1;

create table client_master
(
	client_number varchar(6)  	not null,
    client_name	  varchar(30) 	not null,
    address1	  varchar(30) 	,
    address2	  varchar(30) 	,
    city		  varchar(18) 	not null,
    state	  	  varchar(18)   not null,
    pincode		  numeric(6) 	not null,
    bal_due		  numeric(10,2) not null,
    primary key(client_number)
	
);

create table product_master
(
	product_number 			varchar(6)  	not null,
    description	   			varchar(30) 	,
    profit_percent	  		numeric(3,2) 	not null,
    unit_measure	  		varchar(10) 	not null,
    qty_onhand		  		numeric(4) 		not null,
    reorder_lvlnumber 		numeric(4)    	not null,
    sell_price 				numeric(6)    	not null,
    cost_price_number 		numeric(6)    	not null,
    primary key(product_number)
	
);


#Entering data in table client_master

insert into client_master (client_number,client_name,city,pincode,state,bal_due) 
value (0001,'Ivan','Bombay',400003,'Maharashtra',15000);

insert into client_master (client_number,client_name,city,pincode,state,bal_due) 
value (0002,'Vandana','Madras',780001,'Tamil Nadu',0);

insert into client_master (client_number,client_name,city,pincode,state,bal_due) 
value (0003,'Pramada','Bombay',400057,'Maharashtra',5000);

insert into client_master (client_number,client_name,city,pincode,state,bal_due) 
value (0004,'Basu','Bombay',400056,'Maharashtra',0);

insert into client_master (client_number,client_name,city,pincode,state,bal_due) 
value (0005,'Ravi','New Delhi',100001,'Delhi',2000);

insert into client_master (client_number,client_name,city,pincode,state,bal_due) 
value (0006,'Rukhmini','Bombay',400050,'Maharashtra',0);

#Updating the Pincode for a Client 

update client_master set pincode=400054 where client_number='1';


#Now Entering the data in the Table product_master

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P00001','1.44floppies',5,'piece',100,20,525,500);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P03453','Monitors',6,'piece',10,3,12000,11200);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P06734','Mouse',5,'piece',20,5,1050,500);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P07865','1.22floppies',5,'piece',100,20,525,500);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P07868','Keyboards',2,'piece',10,3,3150,3050);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P07885','CD Drive',2.5,'piece',10,3,5250,5100);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P07965','540HDD',4,'piece',10,3,8400,8000);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P07975','1.44Drive',5,'piece',10,3,1050,1000);

insert into lab1.product_master (product_number,description,profit_percent,unit_measure,qty_onhand,reorder_lvlnumber,sell_price,cost_price_number) 
value ('P08865','1.22Drive',5,'piece',2,3,1050,1000);


#Updating the Client Number in client_master table

update lab1.client_master set client_number='0001' where client_number='1';
update lab1.client_master set client_number='0002' where client_number='2';
update lab1.client_master set client_number='0003' where client_number='3';
update lab1.client_master set client_number='0004' where client_number='4';
update lab1.client_master set client_number='0005' where client_number='5';
update lab1.client_master set client_number='0006' where client_number='6';


#Queries

select client_name from lab1.client_master; 

select client_name,city from lab1.client_master; 

select product_number,description from lab1.product_master; 

select client_number,client_name from lab1.client_master where city='Bombay';

select client_number,client_name,city,state,pincode,bal_due from lab1.client_master where client_number='0001' or client_number='0002';

select * from lab1.product_master where sell_price>5000;

select client_number,client_name,city,state,pincode,bal_due from lab1.client_master where city='Bombay' or city='New Delhi' or city='Madras';

select * from lab1.product_master where sell_price>2000 and sell_price<=5000;

select client_name,city,state from lab1.client_master where state!='Maharashtra';
