create schema TradingComp;

use TradingComp;

#Create_Schema

create table Customer
(
	CustNo					int(10)			, 
    CustName				varchar(20)		,
    
    primary key(CustNo)

);

create table Item
(
	ItemCode				int(10)			, 
    ItemName				varchar(20)		, 
    Category				varchar(20)		,
	SalePrice				int(10)			, 
    Stock					int(10)			, 
    ReOrderLevel 			int(10)			,
	AveragePurchasePrice	int(10)			,
    
    primary key(ItemCode)

);

create table Sales
(
	InvNo 					int(6)			,
    InvDate 				Date			,
    CustomerNo				int(10)	references Customer(CustNo)		,
    
    primary key(InvNo)
);

create table SalesDetails
(
	InvNo					int(6)	references Sales(InvNo)			, 
    ItemCode				int(10)	references Item(ItemCode)		, 
    Qty						int(10)			, 
    Rate					int(10)			,
    
    primary key(InvNo, ItemCode)

);

#Inserting Data

insert into Customer values(1234567890,'Varad Bhogayata');
insert into Customer values(1234567891,'Deep Patel');
insert into Customer values(1234567892,'Shreyas Patel');
insert into Customer values(1234567893,'Maunil Vyas');
insert into Customer values(1234567894,'Jay Dangar');
insert into Customer values(1234567895,'Rajat Barot');
insert into Customer values(1234567896,'Parth Shah');
insert into Customer values(1234567897,'Jay Joshi');
insert into Customer values(1234567898,'Prerak Raja');
insert into Customer values(1234567899,'Nand Parikh');

insert into Sales value (88888,str_to_date('07-13-2015', '%m-%d-%Y'),1234567890);
insert into Sales value (99999,str_to_date('09-27-2015', '%m-%d-%Y'),1234567891);
insert into Sales value (10101,str_to_date('10-20-2015', '%m-%d-%Y'),1234567892);
insert into Sales value (11111,str_to_date('11-22-2015', '%m-%d-%Y'),1234567893);
insert into Sales value (22222,str_to_date('12-12-2015', '%m-%d-%Y'),1234567894);
insert into Sales value (33333,str_to_date('01-05-2016', '%m-%d-%Y'),1234567890);
insert into Sales value (44444,str_to_date('01-15-2016', '%m-%d-%Y'),1234567891);
insert into Sales value (55555,str_to_date('01-22-2016', '%m-%d-%Y'),1234567892);
insert into Sales value (66666,str_to_date('02-01-2016', '%m-%d-%Y'),1234567893);
insert into Sales value (77777,str_to_date('02-02-2016', '%m-%d-%Y'),1234567895);
insert into Sales value (12121,str_to_date('02-03-2016', '%m-%d-%Y'),1234567896);
insert into Sales value (13131,str_to_date('02-04-2016', '%m-%d-%Y'),1234567897);
insert into Sales value (14141,str_to_date('02-05-2016', '%m-%d-%Y'),1234567898);
insert into Sales value (15151,str_to_date('02-06-2016', '%m-%d-%Y'),1234567899);
insert into Sales value (34343,str_to_date('02-03-2016', '%m-%d-%Y'),1234567891);

insert into Item values("12345","Ball","Cricket","50","100","50","40");   
insert into Item values("23456","Bat","Cricket","1000","50","90","900");   
insert into Item values("34567","Stump","Cricket","450"," 10","50","350");   
insert into Item values("45678","Goggles","Accessories","500","100","150","400");   
insert into Item values("56789","Helmet","Cricket","5000","10","5","4980");
insert into Item values("11111","Pent","Cloths","500","1000","540","440");   
insert into Item values("22222","T-shirt","Cloths","200","5000","590","140");   
insert into Item values("33333","Titan","Watch","6000","10","5","5580");   
insert into Item values("44444","Fastrack","Watch","3000","15","5","2500");   
insert into Item values("55555","Rado","Watch","13000","10","5","12200");   
insert into Item values("66666","Rolex","Watch","25000","6","5","24100");   

Insert into SalesDetails value (11111,12345,12,50);
Insert into SalesDetails value (22222,23456,5,1000);
Insert into SalesDetails value (33333,34567,10,450);
Insert into SalesDetails value (44444,45678,5,500);
Insert into SalesDetails value (55555,56789,6,5000);
Insert into SalesDetails value (66666,11111,7,500);
Insert into SalesDetails value (77777,22222,20,200);
Insert into SalesDetails value (34343,19216,40,1000);
Insert into SalesDetails value (88888,33333,6,6000);
Insert into SalesDetails value (99999,44444,3,3000);
Insert into SalesDetails value (10101,55555,3,13000);
Insert into SalesDetails value (12121,66666,6,25000);

#Queries

#1
select ItemCode,ItemName from item where Stock < ReOrderLevel;

#2
select InvDate,sum(Rate*Qty) from sales join salesdetails on (sales.InvNo=salesdetails.InvNo) where InvDate='2016-02-03';

#3
select ItemName,Category,ItemCode from item where SalePrice>=(1.3*AveragePurchasePrice);

#4
select CustomerNo,(Rate*Qty-AveragePurchasePrice*Qty),sales.InvDate from ((sales join salesdetails on (sales.InvNo=salesdetails.InvNo)) join item on (salesdetails.ItemCode=item.ItemCode)) where year(InvDate)=2016 group by sales.CustomerNo order by -(Rate*Qty-AveragePurchasePrice*Qty) limit 1;

#5
select item.ItemCode,item.ItemName,salesdetails.Qty from ((sales join salesdetails on (sales.InvNo=salesdetails.InvNo)) join item on (salesdetails.ItemCode=item.ItemCode)) where year(InvDate)=2016 order by -Qty;

#6
select item.ItemCode,item.ItemName,(Rate*Qty-AveragePurchasePrice*Qty) from ((sales join salesdetails on (sales.InvNo=salesdetails.InvNo)) join item on (salesdetails.ItemCode=item.ItemCode)) where year(InvDate)=2016 order by -(Rate*Qty-AveragePurchasePrice*Qty);
