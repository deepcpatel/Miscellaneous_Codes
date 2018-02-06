create database acad;

use acad;

#drop database acad;

#Creating the Tables/Schema

create table Program
(
	ProgID 		varchar(2) 		primary key	,
	ProgName 	varchar(20)
);

create table Student
(
	StudentID 		varchar(9) 	primary key	, 
	SName 			varchar(30)				, 
	ProgID 			varchar(2)				, 
	Batch 			numeric(4)				,	
	CPI 			numeric(3,2)			,
	
    FOREIGN KEY(ProgID) references Program(ProgId)
);

create table Course
(
	CourseNo 		varchar(5) 	primary key	, 
	CourseName 		varchar(35)				, 
	Credit 			numeric(4,2)
);

create table Instructor
(
	InstructorID 	varchar(5) primary key	, 
	InstructorName 	varchar(30)
);

create table Offers
(
	AcadYear 		integer					,
	Semester 		varchar(6)				,
	CourseNo 		varchar(5) 	REFERENCES Course(CourseNo), 
	InstructorID 	varchar(5) 	REFERENCES Instructor(InstructorID), 
	
    primary key(AcadYear, Semester, CourseNo)
);

create table Registers
(
	StudentID 		varchar(9) 	REFERENCES Student(StudentID), 
	AcadYear 		integer					,
	Semester 		varchar(6)				,
	CourseNo 		varchar(5) 	REFERENCES Course(CourseNo), 
	grade 			varchar(2)				, 
	
    primary key(StudentID, AcadYear, Semester, CourseNo),
	
    FOREIGN KEY(AcadYear, Semester, CourseNo) references Offers(AcadYear, Semester, CourseNo)
);

create table Result
(
	StudentID 		varchar(9) 	REFERENCES Student(StudentID), 
	Semester 		varchar(6)				,
	spi 			numeric(3,2)			, 
	
    primary key(StudentID,Semester)
);

#Entering the data into the tables

insert into Program Values('01','Btech(CS)');
insert into Program Values('02','Btech(EC)');
insert into Program Values('11','M.Tech');
#------------------------------------------------------------------------------------------------------------------------------------------------------

insert into Student Values('200711001','Charu Chawla','11','2007','6.12');
insert into Student Values('200711002','Amit Khanna','11','2007','7.12');
insert into Student Values('200711003','Kamla Kiran','11','2007','7.50');
insert into Student Values('200711004','Raj Kumar','11','2007','4.00');
insert into Student Values('200711005','Raj Tiwari','11','2007','5.56');

insert into Student Values('200811001','Rama Kant','11','2008','8.12');
insert into Student Values('200811002','Akshya Gupta','11','2008','9.22');
insert into Student Values('200811003','Unnati Gupta','11','2008','5.52');
insert into Student Values('200811004','Mridula Singh','11','2008','4.25');
insert into Student Values('200811005','Amit Ajaad','11','2008','6.56');

insert into Student(StudentID,SName,ProgID,Batch) Values('200911001','M Nussair','11','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200911002','Rama Kaushik','11','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200911003','Shiva Keda','11','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200911004','Ram Vilas Gupta','11','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200911005','Sumit Sharma','11','2009');

insert into Student Values('200702001','Sumit Sharma','02','2007','6.12');
insert into Student Values('200702002','Amit Kumar','02','2007','7.12');
insert into Student Values('200702003','Shobha Kiran','02','2007','7.5');
insert into Student Values('200702004','Raj Gupta','02','2007','4.00');
insert into Student Values('200702005','Amit Tiwari','02','2007','5.56');

insert into Student Values('200802001','Ram Kant','02','2008','8.12');
insert into Student Values('200802002','Akshya Singh','02','2008','7.22');
insert into Student Values('200802003','Shobha Gupta','02','2008','5.52');
insert into Student Values('200802004','Shikha Singh','02','2008','4.25');
insert into Student Values('200802005','Ashish Jain','02','2008','5.56');

insert into Student(StudentID,SName,ProgID,Batch) Values('200902001','Mukesh Tiwari','02','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200902002','Sumit Joshi','02','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200902003','Shiva Suman','02','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200902004','Ram Prakash Gupta','02','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200902005','Sumit Agarwal','02','2009');

insert into Student Values('200701001','Sumit Sharma','01','2007','6.12');
insert into Student Values('200701002','Amit Kumar','01','2007','7.12');
insert into Student Values('200701003','Shobha Kiran','01','2007','7.5');
insert into Student Values('200701004','Raj Gupta','01','2007','4.00');
insert into Student Values('200701005','Amit Tiwari','01','2007','5.56');

insert into Student Values('200801001','Ram Kant','01','2008','8.12');
insert into Student Values('200801002','Akshya Singh','01','2008','7.22');
insert into Student Values('200801003','Shobha Gupta','01','2008','5.52');
insert into Student Values('200801004','Shikha Singh','01','2008','4.25');
insert into Student Values('200801005','Ashish Jain','01','2008','5.56');

insert into Student(StudentID,SName,ProgID,Batch) Values('200901001','Mukesh Tiwari','01','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200901002','Sumit Joshi','01','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200901003','Shiva Suman','01','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200901004','Ram Prakash Gupta','01','2009');
insert into Student(StudentID,SName,ProgID,Batch) Values('200901005','Sumit Agarwal','01','2009');
#-----------------------------------------------------------------------------------------------------------

insert into Course Values('CS101','C Programming','04');
insert into Course Values('CS102','Algorithm','04');
insert into Course Values('CS103','Basic Computers','03');
insert into Course Values('CS104','Probability','03');
insert into Course Values('CS105','Calculus','03');

insert into Course Values('EC101','Signal System','04');
insert into Course Values('EC102','Network Theory','04');
insert into Course Values('EC103','Basic Electrical','03');
insert into Course Values('EC104','Basic Electonics','03');
insert into Course Values('EC105','Physics','03');

insert into Course Values('MT101','Signal System','04');
insert into Course Values('MT102','Computer Networks','04');
insert into Course Values('MT103','Linear Algebra','03');
insert into Course Values('MT104','Probability','03');
insert into Course Values('MT105','VLSI','03');

insert into Course Values('CS201','Data Structures','04');
insert into Course Values('CS202','Design Algorithm & Analysis','04');
insert into Course Values('CS203','Computer Organisation-I','03');
insert into Course Values('CS204','Software Engineering','03');
insert into Course Values('CS205','Linear Algebra','03');

insert into Course Values('EC201','Graph Theory','04');
insert into Course Values('EC202','Network Theory','04');
insert into Course Values('EC203','Advance Electrical','03');
insert into Course Values('EC204','Advance Electonics','03');
insert into Course Values('EC205','Fourier Analysis','03');

insert into Course Values('MT201','Pattern Recognition','04');
insert into Course Values('MT202','Adhoc Network','04');
insert into Course Values('MT203','Statistical Coding','04');
insert into Course Values('MT204','','04');
insert into Course Values('MT205','Simulation & Modelling','03');
insert into Course Values('MT206','Web Services','03');
insert into Course Values('MT207','VLSI Subsystem','03');
insert into Course Values('MT208','Watermarking','03');

insert into Course Values('CS301','Java Programming','04');
insert into Course Values('CS302','Computer Organisation-II','04');
insert into Course Values('CS303','Numerical Analysis','03');
insert into Course Values('CS304','Optimisation','03');
insert into Course Values('CS305','Micro Economics','03');

insert into Course Values('EC301','VLSI','04');
insert into Course Values('EC302','Micro Processor','04');
insert into Course Values('EC303','Radar System','03');
insert into Course Values('EC304','Optimisation','03');
insert into Course Values('EC305','Micro Economics','03');

insert into Course Values('MT301','Computer Vision','04');
insert into Course Values('MT302','Optimisation','04');
insert into Course Values('MT303','Optical Communication','04');
insert into Course Values('MT304','Dynamic Networks','04');
insert into Course Values('MT305','VLSI Testing','03');
insert into Course Values('MT306','Speech Recognition','03');

insert into Course Values('CS401','Game Theory','04');
insert into Course Values('CS402','Computer Architecture','04');
insert into Course Values('CS403','Digital Image Processing','03');
insert into Course Values('CS404','Robot Vision','03');
insert into Course Values('CS405','Complier Design','03');

insert into Course Values('EC401','VLSI Testing','04');
insert into Course Values('EC402','Computer Networks','04');
insert into Course Values('EC403','Settelite Communication','03');
insert into Course Values('EC404','Advance R F Communication','03');
insert into Course Values('EC405','Quantum Theory','03');

insert into Course Values('MT401','Research-1','09');
#--------------------------------------------------------------------------------------------------------------------------------------------------------

insert into instructor Values('I0001','Mehul Raval');
insert into instructor Values('I0002','M V Joshi');
insert into instructor Values('I0003','Aseem Benerji');
insert into instructor Values('I0004','Suman K Mitra');
insert into instructor Values('I0005','P M Jaat');
insert into instructor Values('I0006','V Sunita');
insert into instructor Values('I0007','Sanjay Srivastava');
insert into instructor Values('I0008','Vijay Kumar Chakka');
insert into instructor Values('I0009','Manish Gupta');
insert into instructor Values('I0010','Sharad Joshi');
#-------------------------------------------------------------------------------------------------------------------------------------------------------------

insert into result(StudentID,Semester,spi) Values('200711001','1','6.5');
insert into result(StudentID,Semester,spi) Values('200711001','2','5.5');
insert into result(StudentID,Semester,spi) Values('200711001','3','6.5');
insert into result(StudentID,Semester,spi) Values('200711001','4','7.5');

insert into result(StudentID,Semester,spi) Values('200711002','1','7.0');
insert into result(StudentID,Semester,spi) Values('200711002','2','6.0');
insert into result(StudentID,Semester,spi) Values('200711002','3','6.0');
insert into result(StudentID,Semester,spi) Values('200711002','4','5.0');

insert into result Values('200711003','1','8.0');
insert into result Values('200711003','2','7.5');
insert into result Values('200711003','3','5.5');
insert into result Values('200711003','4','6.6');

insert into result Values('200711004','1','4.5');
insert into result Values('200711004','2','6.5');
insert into result Values('200711004','3','7.0');
insert into result Values('200711004','4','8.0');

insert into result Values('200711005','1','5.5');
insert into result Values('200711005','2','6.6');
insert into result Values('200711005','3','5.9');
insert into result Values('200711005','4','7.0');


insert into result Values('200811001','1','6.5');
insert into result Values('200811001','2','5.5');
insert into result Values('200811001','3','6.5');
insert into result Values('200811001','4','7.5');

insert into result Values('200811002','1','7.0');
insert into result Values('200811002','2','6.0');
insert into result Values('200811002','3','6.0');
insert into result Values('200811002','4','5.0');

insert into result Values('200811003','1','8.0');
insert into result Values('200811003','2','7.5');
insert into result Values('200811003','3','5.5');
insert into result Values('200811003','4','6.6');

insert into result Values('200811004','1','4.5');
insert into result Values('200811004','2','6.5');
insert into result Values('200811004','3','7.0');
insert into result Values('200811004','4','8.0');

insert into result Values('200811005','1','5.5');
insert into result Values('200811005','2','6.6');
insert into result Values('200811005','3','5.9');
insert into result Values('200811005','4','7.0');

insert into result Values('200911001','1','6.5');
insert into result Values('200911001','2','5.5');
insert into result Values('200911001','3','6.5');
insert into result Values('200911001','4','7.5');

insert into result Values('200911002','1','7.0');
insert into result Values('200911002','2','6.0');
insert into result Values('200911002','3','6.0');
insert into result Values('200911002','4','5.0');

insert into result Values('200911003','1','8.0');
insert into result Values('200911003','2','7.5');
insert into result Values('200911003','3','5.5');
insert into result Values('200911003','4','6.6');

insert into result Values('200911004','1','4.5');
insert into result Values('200911004','2','6.5');
insert into result Values('200911004','3','7.0');
insert into result Values('200911004','4','8.0');

insert into result Values('200911005','1','5.5');
insert into result Values('200911005','2','6.6');
insert into result Values('200911005','3','5.9');
insert into result Values('200911005','4','7.0');

insert into result Values('200701001','1','6.5');
insert into result Values('200701001','2','6.5');
insert into result Values('200701001','3','6.5');
insert into result Values('200701001','4','7.5');

insert into result Values('200701002','1','7.0');
insert into result Values('200701002','2','6.0');
insert into result Values('200701002','3','6.0');
insert into result Values('200701002','4','5.0');

insert into result Values('200701003','1','8.0');
insert into result Values('200701003','2','7.5');
insert into result Values('200701003','3','5.5');
insert into result Values('200701003','4','6.6');

insert into result Values('200701004','1','4.5');
insert into result Values('200701004','2','6.5');
insert into result Values('200701004','3','7.0');
insert into result Values('200701004','4','8.0');

insert into result Values('200701005','1','5.5');
insert into result Values('200701005','2','6.6');
insert into result Values('200701005','3','5.9');
insert into result Values('200701005','4','7.0');

insert into result Values('200801001','1','6.5');
insert into result Values('200801001','2','5.5');
insert into result Values('200801001','3','6.5');
insert into result Values('200801001','4','7.5');

insert into result Values('200801002','1','7.0');
insert into result Values('200801002','2','6.0');
insert into result Values('200801002','3','6.0');
insert into result Values('200801002','4','5.0');

insert into result Values('200801003','1','8.0');
insert into result Values('200801003','2','7.5');
insert into result Values('200801003','3','5.5');
insert into result Values('200801003','4','6.6');

insert into result Values('200801004','1','4.5');
insert into result Values('200801004','2','6.5');
insert into result Values('200801004','3','7.0');
insert into result Values('200801004','4','8.0');

insert into result Values('200801005','1','5.5');
insert into result Values('200801005','2','6.6');
insert into result Values('200801005','3','5.9');
insert into result Values('200801005','4','7.0');

insert into result Values('200901001','1','6.5');
insert into result Values('200901001','2','5.5');
insert into result Values('200901001','3','6.5');
insert into result Values('200901001','4','7.5');

insert into result Values('200901002','1','7.0');
insert into result Values('200901002','2','6.0');
insert into result Values('200901002','3','6.0');
insert into result Values('200901002','4','5.0');

insert into result Values('200901003','1','8.0');
insert into result Values('200901003','2','7.5');
insert into result Values('200901003','3','5.5');
insert into result Values('200901003','4','6.6');

insert into result Values('200901004','1','4.5');
insert into result Values('200901004','2','6.5');
insert into result Values('200901004','3','7.0');
insert into result Values('200901004','4','8.0');

insert into result Values('200901005','1','5.5');
insert into result Values('200901005','2','6.6');
insert into result Values('200901005','3','5.9');
insert into result Values('200901005','4','7.0');

insert into result Values('200702001','1','6.5');
insert into result Values('200702001','2','5.5');
insert into result Values('200702001','3','6.5');
insert into result Values('200702001','4','7.5');

insert into result Values('200702002','1','7.0');
insert into result Values('200702002','2','6.0');
insert into result Values('200702002','3','6.0');
insert into result Values('200702002','4','5.0');

insert into result Values('200702003','1','8.0');
insert into result Values('200702003','2','7.5');
insert into result Values('200702003','3','5.5');
insert into result Values('200702003','4','6.6');

insert into result Values('200702004','1','4.5');
insert into result Values('200702004','2','6.5');
insert into result Values('200702004','3','7.0');
insert into result Values('200702004','4','8.0');

insert into result Values('200702005','1','5.5');
insert into result Values('200702005','2','6.6');
insert into result Values('200702005','3','5.9');
insert into result Values('200702005','4','7.0');

insert into result Values('200802001','1','6.5');
insert into result Values('200802001','2','5.5');
insert into result Values('200802001','3','6.5');
insert into result Values('200802001','4','7.5');

insert into result Values('200802002','1','7.0');
insert into result Values('200802002','2','6.0');
insert into result Values('200802002','3','6.0');
insert into result Values('200802002','4','5.0');

insert into result Values('200802003','1','8.0');
insert into result Values('200802003','2','7.5');
insert into result Values('200802003','3','5.5');
insert into result Values('200802003','4','6.6');

insert into result Values('200802004','1','4.5');
insert into result Values('200802004','2','6.5');
insert into result Values('200802004','3','7.0');
insert into result Values('200802004','4','8.0');

insert into result Values('200802005','1','5.5');
insert into result Values('200802005','2','6.6');
insert into result Values('200802005','3','5.9');
insert into result Values('200802005','4','7.0');

insert into result Values('200902001','1','6.5');
insert into result Values('200902001','2','5.5');
insert into result Values('200902001','3','6.5');
insert into result Values('200902001','4','7.5');

insert into result Values('200902002','1','7.0');
insert into result Values('200902002','2','6.0');
insert into result Values('200902002','3','6.0');
insert into result Values('200902002','4','5.0');

insert into result Values('200902003','1','8.0');
insert into result Values('200902003','2','7.5');
insert into result Values('200902003','3','5.5');
insert into result Values('200902003','4','6.6');

insert into result Values('200902004','1','4.5');
insert into result Values('200902004','2','6.5');
insert into result Values('200902004','3','7.0');
insert into result Values('200902004','4','8.0');

insert into result Values('200902005','1','5.5');
insert into result Values('200902005','2','6.6');
insert into result Values('200902005','3','5.9');
insert into result Values('200902005','4','7.0');
#-----------------------------------------------------------------------------------------------------------------

insert into offers Values('200711001','1','MT101','I0001');
insert into offers Values('200711001','2','MT102','I0002');
insert into offers Values('200711001','3','MT103','I0003');
insert into offers Values('200711001','4','MT104','I0004');

insert into offers Values('200711001','2','MT201','I0001');
insert into offers Values('200711001','2','MT202','I0005');

insert into offers Values('200711001','3','MT301','I0006');

insert into offers Values('200711001','4','MT401','I0001');


insert into offers Values('200711002','1','MT101','I0001');
insert into offers Values('200711002','1','MT102','I0002');
insert into offers Values('200711002','1','MT103','I0003');
insert into offers Values('200711002','1','MT105','I0001');

insert into offers Values('200711002','2','MT201','I0001');
insert into offers Values('200711002','2','MT203','I0006');

insert into offers Values('200711002','3','MT301','I0006');

insert into offers Values('200711002','4','MT401','I0001');


insert into offers Values('200711003','1','MT101','I0001');
insert into offers Values('200711003','1','MT102','I0002');
insert into offers Values('200711003','1','MT103','I0003');
insert into offers Values('200711003','1','MT105','I0001');

insert into offers Values('200711003','2','MT201','I0001');
insert into offers Values('200711003','2','MT203','I0006');

insert into offers Values('200711003','3','MT301','I0006');

insert into offers Values('200711003','4','MT401','I0001');


insert into offers Values('200711004','1','MT101','I0001');
insert into offers Values('200711004','1','MT102','I0002');
insert into offers Values('200711004','1','MT103','I0003');
insert into offers Values('200711004','1','MT105','I0001');

insert into offers Values('200711004','2','MT201','I0001');
insert into offers Values('200711004','2','MT203','I0006');

insert into offers Values('200711004','3','MT301','I0006');

insert into offers Values('200711004','4','MT401','I0001');

insert into offers Values('200711005','1','MT101','I0001');
insert into offers Values('200711005','1','MT102','I0002');
insert into offers Values('200711005','1','MT103','I0003');
insert into offers Values('200711005','1','MT104','I0004');

insert into offers Values('200711005','2','MT201','I0001');
insert into offers Values('200711005','2','MT203','I0006');

insert into offers Values('200711005','3','MT302','I0007');

insert into offers Values('200711005','4','MT401','I0001');


insert into offers Values('200811001','1','MT101','I0001');
insert into offers Values('200811001','1','MT102','I0002');
insert into offers Values('200811001','1','MT103','I0003');
insert into offers Values('200811001','1','MT104','I0004');

insert into offers Values('200811001','2','MT201','I0001');
insert into offers Values('200811001','2','MT202','I0005');

insert into offers Values('200811001','3','MT301','I0006');

insert into offers Values('200811001','4','MT401','I0001');


insert into offers Values('200811002','1','MT101','I0001');
insert into offers Values('200811002','1','MT102','I0002');
insert into offers Values('200811002','1','MT103','I0003');
insert into offers Values('200811002','1','MT105','I0001');

insert into offers Values('200811002','2','MT201','I0001');
insert into offers Values('200811002','2','MT203','I0006');

insert into offers Values('200811002','3','MT301','I0006');

insert into offers Values('200811002','4','MT401','I0001');


insert into offers Values('200811003','1','MT101','I0001');
insert into offers Values('200811003','1','MT102','I0002');
insert into offers Values('200811003','1','MT103','I0003');
insert into offers Values('200811003','1','MT105','I0001');

insert into offers Values('200811003','2','MT201','I0001');
insert into offers Values('200811003','2','MT203','I0006');

insert into offers Values('200811003','3','MT301','I0006');

insert into offers Values('200811003','4','MT401','I0001');


insert into offers Values('200811004','1','MT101','I0001');
insert into offers Values('200811004','1','MT102','I0002');
insert into offers Values('200811004','1','MT103','I0003');
insert into offers Values('200811004','1','MT105','I0001');

insert into offers Values('200811004','2','MT201','I0001');
insert into offers Values('200811004','2','MT203','I0006');

insert into offers Values('200811004','3','MT301','I0006');

insert into offers Values('200811004','4','MT401','I0001');

insert into offers Values('200811005','1','MT101','I0001');
insert into offers Values('200811005','1','MT102','I0002');
insert into offers Values('200811005','1','MT103','I0003');
insert into offers Values('200811005','1','MT104','I0004');

insert into offers Values('200811005','2','MT201','I0001');
insert into offers Values('200811005','2','MT203','I0006');

insert into offers Values('200811005','3','MT302','I0007');

insert into offers Values('200811005','4','MT401','I0001');
#---------------------------------------------------------------------------------------

insert into registers Values('200711001','200711001','1','MT101','AA');
insert into registers Values('200711001','200711001','2','MT102','BB');
insert into registers Values('200711001','200711001','3','MT103','CC');
insert into registers Values('200711001','200711001','4','MT104','FF');

insert into registers Values('200711001','200711001','2','MT201','AA');
insert into registers Values('200711001','200711001','2','MT202','BB');

insert into registers Values('200711001','200711001','3','MT301','AA');

insert into registers Values('200711001','200711001','4','MT401','SS');


insert into registers Values('200711002','200711002','1','MT101','BB');
insert into registers Values('200711002','200711002','1','MT102','AA');
insert into registers Values('200711002','200711002','1','MT103','DD');
insert into registers Values('200711002','200711002','1','MT105','CC');

insert into registers Values('200711002','200711002','2','MT201','AA');
insert into registers Values('200711002','200711002','2','MT203','BB');

insert into registers Values('200711002','200711002','3','MT301','AA');

insert into registers Values('200711002','200711002','4','MT401','SS');


insert into registers Values('200711003','200711003','1','MT101','AA');
insert into registers Values('200711003','200711003','1','MT102','BB');
insert into registers Values('200711003','200711003','1','MT103','CC');
insert into registers Values('200711003','200711003','1','MT105','FF');

insert into registers Values('200711003','200711003','2','MT201','AA');
insert into registers Values('200711003','200711003','2','MT203','BB');

insert into registers Values('200711003','200711003','3','MT301','AA');

insert into registers Values('200711003','200711003','4','MT401','SS');


insert into registers Values('200711004','200711004','1','MT101','cc');
insert into registers Values('200711004','200711004','1','MT102','BB');
insert into registers Values('200711004','200711004','1','MT103','FF');
insert into registers Values('200711004','200711004','1','MT105','FF');

insert into registers Values('200711004','200711004','2','MT201','FF');
insert into registers Values('200711004','200711004','2','MT203','BB');

insert into registers Values('200711004','200711004','3','MT301','AA');

insert into registers Values('200711004','200711004','4','MT401','SS');

insert into registers Values('200711005','200711005','1','MT101','cc');
insert into registers Values('200711005','200711005','1','MT102','BB');
insert into registers Values('200711005','200711005','1','MT103','AA');
insert into registers Values('200711005','200711005','1','MT104','BB');

insert into registers Values('200711005','200711005','2','MT201','CC');
insert into registers Values('200711005','200711005','2','MT203','BB');

insert into registers Values('200711005','200711005','3','MT302','AA');

insert into registers Values('200711005','200711005','4','MT401','SS');


insert into registers Values('200811001','200811001','1','MT101','AA');
insert into registers Values('200811001','200811001','1','MT102','BB');
insert into registers Values('200811001','200811001','1','MT103','FF');
insert into registers Values('200811001','200811001','1','MT104','FF');

insert into registers Values('200811001','200811001','2','MT201','AA');
insert into registers Values('200811001','200811001','2','MT202','FF');

insert into registers Values('200811001','200811001','3','MT301','AA');

insert into registers Values('200811001','200811001','4','MT401','SS');


insert into registers Values('200811002','200811002','1','MT101','BB');
insert into registers Values('200811002','200811002','1','MT102','AA');
insert into registers Values('200811002','200811002','1','MT103','FF');
insert into registers Values('200811002','200811002','1','MT105','CC');

insert into registers Values('200811002','200811002','2','MT201','AA');
insert into registers Values('200811002','200811002','2','MT203','FF');

insert into registers Values('200811002','200811002','3','MT301','AA');

insert into registers Values('200811002','200811002','4','MT401','SS');


insert into registers Values('200811003','200811003','1','MT101','AA');
insert into registers Values('200811003','200811003','1','MT102','BB');
insert into registers Values('200811003','200811003','1','MT103','CC');
insert into registers Values('200811003','200811003','1','MT105','CC');

insert into registers Values('200811003','200811003','2','MT201','AA');
insert into registers Values('200811003','200811003','2','MT203','BB');

insert into registers Values('200811003','200811003','3','MT301','AA');

insert into registers Values('200811003','200811003','4','MT401','SS');


insert into registers Values('200811004','200811004','1','MT101','cc');
insert into registers Values('200811004','200811004','1','MT102','BB');
insert into registers Values('200811004','200811004','1','MT103','AA');
insert into registers Values('200811004','200811004','1','MT105','AA');

insert into registers Values('200811004','200811004','2','MT201','AA');
insert into registers Values('200811004','200811004','2','MT203','BB');

insert into registers Values('200811004','200811004','3','MT301','AA');

insert into registers Values('200811004','200811004','4','MT401','SS');

insert into registers Values('200811005','200811005','1','MT101','cc');
insert into registers Values('200811005','200811005','1','MT102','BB');
insert into registers Values('200811005','200811005','1','MT103','AA');
insert into registers Values('200811005','200811005','1','MT104','BB');

insert into registers Values('200811005','200811005','2','MT201','CC');
insert into registers Values('200811005','200811005','2','MT203','BB');

insert into registers Values('200811005','200811005','3','MT302','AA');

insert into registers Values('200811005','200811005','4','MT401','SS');

#-------------------------------------------------------------------------------------
#Queries 

#1
select * from student where cpi>='7.0' and batch='2007' and ProgID=(select ProgID from program where ProgName='Btech(CS)') ;

#2
select * from (student join registers on (student.StudentID=registers.StudentID)) WHERE CourseNo='MT101' and Batch='2008';

#3
select CourseNo from (select CourseNo,InstructorID,AcadYear from offers where Semester=2 or Semester=4) as a where a.InstructorID=(select InstructorID from instructor where InstructorName='P M Jaat') and AcadYear='200811001';