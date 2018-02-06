create database supplyparts;

use supplyparts;

#Creating Schema

create table suppliers
(
	sid 	int4		primary key	,
	sname 	varchar(20)				, 
	city 	varchar(20)
);

create table parts
(
	pid 	int4 		primary key	,
	pname 	varchar(20)				,
	color 	varchar(10)
);

create table supplies
(
	sid 	int4 		references suppliers	,
	pid 	int4 		references parts		,
	cost 	int4					,
	
    primary key(sid, pid)
);

#Inserting into Tables

INSERT INTO parts (pid, pname, color) VALUES (1, 'PART-1', 'RED');
INSERT INTO parts (pid, pname, color) VALUES (2, 'PART-2', 'GREEN');
INSERT INTO parts (pid, pname, color) VALUES (3, 'PART-3', 'RED');
INSERT INTO parts (pid, pname, color) VALUES (4, 'PART-4', 'BLUE');
INSERT INTO parts (pid, pname, color) VALUES (5, 'PART-5', 'GREEN');


INSERT INTO suppliers (sid, sname, city) VALUES (101, 'ABC', 'Mumbai');
INSERT INTO suppliers (sid, sname, city) VALUES (102, 'PQR', 'Delhi');
INSERT INTO suppliers (sid, sname, city) VALUES (103, 'XYZ', 'Ahmedabad');


INSERT INTO supplies (sid, pid, cost) VALUES (101, 1, 100);
INSERT INTO supplies (sid, pid, cost) VALUES (102, 1, 120);
INSERT INTO supplies (sid, pid, cost) VALUES (101, 3, 160);
INSERT INTO supplies (sid, pid, cost) VALUES (103, 2, 210);
INSERT INTO supplies (sid, pid, cost) VALUES (102, 2, 220);

#Inserting the queries

#1
select sname from ((select sid from (supplies join parts on(supplies.pid=parts.pid)) where color='RED')as a) join suppliers where a.sid=suppliers.sid;

#2
select sid from (supplies join parts on(supplies.pid=parts.pid)) where color='RED' or color='GREEN';

#3
select suppliers.sid from ((select sid from (supplies join parts on(supplies.pid=parts.pid)) where color='RED')as a) join suppliers where a.sid=suppliers.sid or city='Delhi';
