create schema myfacebook;

use myfacebook;

#Creating Schema

create table user 
(

	uid 		int(6)			,
    usrname 	varchar(15)		,
    email 		varchar(30)		,
    joindate 	date			,
    city 		varchar(15) 	references city(cityname)	,
    
    primary key(uid)

);


create table city 
(
	
    cityname 	varchar(15)		,
    country 	varchar(15)		, 
    
    primary key(cityname)

);

create table friend 
(

	id 				int(6) 			references user(uid)		,
    fid 			int(6) 			references user(uid)		,
    since 			date			,
    messages_in 	int				,
    messages_out 	int				,
    
    primary key(id,fid)

);

#Inserting into Table

insert into city values ('Mumbai','India');
insert into city values ('Ahmedabad','India');
insert into city values ('New Delhi','India');
insert into city values ('Shanghai','China');
insert into city values ('Tokyo','Japan');
insert into city values ('Bangalore','India');

insert into user  values (12345,'Keyur','keyur.patel@gmail.com',str_to_date('11-10-1997', '%m-%d-%Y'),'Mumbai');
insert into user  values (12346,'Umang','umang.patel@gmail.com',str_to_date('1-5-1996', '%m-%d-%Y'),'Bangalore');
insert into user  values (12347,'Raj','raj.patel@gmail.com',str_to_date('1-9-1996', '%m-%d-%Y'),'Mumbai');
insert into user  values (12348,'Abhi','abhi.patel@gmail.com',str_to_date('4-12-1997', '%m-%d-%Y'),'Mumbai');
insert into user  values (12349,'Yash','yash.patel@gmail.com',str_to_date('7-2-1995', '%m-%d-%Y'),'Tokyo');
insert into user  values (12350,'Jay','jay.patel@gmail.com',str_to_date('12-6-1997', '%m-%d-%Y'),'Mumbai');
insert into user  values (12351,'Falgun','falgun.prajapati@gmail.com',str_to_date('9-10-1997', '%m-%d-%Y'),'Mumbai');
insert into user  values (12352,'Het','het.patel@gmail.com',str_to_date('3-5-1996', '%m-%d-%Y'),'Mumbai');
insert into user  values (23456,'Lalit','lalit.prajapati@gmail.com',str_to_date('1-2-1995', '%m-%d-%Y'),'Mumbai');
insert into user  values (23451,'Bhargav','bhargav.vyas@gmail.com',str_to_date('7-5-1996', '%m-%d-%Y'),'Bangalore');
insert into user  values (23455,'Kaushal','kaushal.vyas@gmail.com',str_to_date('8-9-1996', '%m-%d-%Y'),'Mumbai');


insert into friend values (12345,12346,str_to_date('4-10-2003', '%m-%d-%Y'),2,1);
insert into friend values (12345,12347,str_to_date('4-10-2004', '%m-%d-%Y'),2,4);
insert into friend values (12345,12348,str_to_date('4-10-2005', '%m-%d-%Y'),3,0);
insert into friend values (12345,12349,str_to_date('4-10-2006', '%m-%d-%Y'),1,2);
insert into friend values (12345,12350,str_to_date('4-10-2007', '%m-%d-%Y'),0,6);

insert into friend values (12346,12345,str_to_date('1-10-2003', '%m-%d-%Y'),1,1);
insert into friend values (12346,12347,str_to_date('1-10-2004', '%m-%d-%Y'),2,2);
insert into friend values (12346,12348,str_to_date('1-10-2005', '%m-%d-%Y'),2,7);
insert into friend values (12346,12349,str_to_date('1-10-2006', '%m-%d-%Y'),3,0);
insert into friend values (12346,12350,str_to_date('1-10-2007', '%m-%d-%Y'),2,1);

insert into friend values (12347,12345,str_to_date('2-2-2001', '%m-%d-%Y'),2,1);
insert into friend values (12347,12346,str_to_date('2-2-2002', '%m-%d-%Y'),2,1);
insert into friend values (12347,12348,str_to_date('2-2-2003', '%m-%d-%Y'),0,1);
insert into friend values (12347,12349,str_to_date('2-2-2004', '%m-%d-%Y'),2,1);
insert into friend values (12347,12350,str_to_date('2-2-2005', '%m-%d-%Y'),0,1);

insert into friend values (12348,12351,str_to_date('7-10-2010', '%m-%d-%Y'),2,1);
insert into friend values (12348,12352,str_to_date('7-10-2009', '%m-%d-%Y'),2,1);
insert into friend values (12348,12353,str_to_date('9-10-2008', '%m-%d-%Y'),4,1);
insert into friend values (12348,12354,str_to_date('1-10-2007', '%m-%d-%Y'),2,1);
insert into friend values (12348,12355,str_to_date('3-10-2011', '%m-%d-%Y'),2,1);

insert into friend values (23456,12347,str_to_date('7-12-2010', '%m-%d-%Y'),2,1);
insert into friend values (23456,12348,str_to_date('6-23-2009', '%m-%d-%Y'),2,1);
insert into friend values (23456,12349,str_to_date('8-1-2008', '%m-%d-%Y'),2,4);
insert into friend values (23456,12350,str_to_date('1-24-2007', '%m-%d-%Y'),2,1);
insert into friend values (23456,12351,str_to_date('2-13-2011', '%m-%d-%Y'),2,1);


#Queries

#1
select usrname,email from (user join ((select fid,since from friend where id=12345 and (DATEDIFF(now(),since) > 365)) as a) on (user.uid=a.fid));

#2
select * from user where uid in (select fid from friend where id=12345 and friend.fid in (select fid from friend where id=23456));

#3
select distinct uid,usrname,email from friend join user on (friend.id=user.uid) where fid in (select fid from friend where id=12345);

#4
select uid,usrname,email from user where uid in (select distinct fid from friend where id=12345 and ((messages_in = 0 or messages_out = 0)));
#select distinct uid,usrname,email from friend join user on (friend.id=user.uid) where (fid =12345 and (messages_in = 0 or messages_out = 0));

#5
select * from user join city on (user.city=city.cityname) where (uid in (select fid from friend where id in (select fid from friend where id=12345))) and country=(select country from  user join city on (user.city=city.cityname) where uid=12345);

#6
select * from user join city on (user.city=city.cityname) where (uid in (select fid from friend where id in (select fid from friend where id=12345))) and country!=(select country from  user join city on (user.city=city.cityname) where uid=12345);

#7
select distinct uid,usrname,email from (user join friend on (user.uid=friend.id)) join city on (city=city.cityname) where country in (select country from user join city on (city=city.cityname) where uid=fid);

