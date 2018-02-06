create database company;

use company;

#Creating the Table

CREATE TABLE employee 
(
	fname 			VARCHAR(20)		,
	minit 			CHAR(1)			,
	lname 			VARCHAR(20)		,
	ssn 			DECIMAL(9,0)	,
	bdate 			DATE			,
	address 		VARCHAR(30)		,
	sex 			CHAR(1)			,
	salary 			DECIMAL(10,0)	,
	superssn 		DECIMAL(9,0)	,
	dno 			SMALLINT		,
	
    PRIMARY KEY (ssn)				,
    
	FOREIGN KEY (superssn) REFERENCES employee(ssn)
	ON DELETE CASCADE 
    ON UPDATE CASCADE
);

CREATE TABLE department
(
	dname 			VARCHAR(20)		,
	dno 			SMALLINT		,
	mgrssn 			DECIMAL(9,0)	,
	mgrstartdate	DATE			,
	
    PRIMARY KEY (dno)				,
    
	FOREIGN KEY (mgrssn) REFERENCES employee(ssn)
    ON DELETE CASCADE 
    ON UPDATE CASCADE				
);
	
CREATE TABLE dept_locations
(
	dno 		SMALLINT		,
	dlocation 	VARCHAR(20)		,
    
    FOREIGN KEY (dno) REFERENCES department(dno) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE			,
    
	PRIMARY KEY (dno,dlocation)
);

CREATE TABLE project
(
	pname 		VARCHAR(20)		,
	pno 		SMALLINT		,
	plocation 	VARCHAR(20)		,
	dno 		SMALLINT		,

	PRIMARY KEY (pno)			,
	
    FOREIGN KEY (dno) REFERENCES department(dno)
    ON DELETE CASCADE 
    ON UPDATE CASCADE
);

CREATE TABLE works_on
(
	essn 		DECIMAL(9,0)	,
	pno 		SMALLINT		,	
	hours 		DECIMAL(5,1)	,

	FOREIGN KEY (essn) REFERENCES employee(ssn)
	ON DELETE CASCADE 
    ON UPDATE CASCADE			,
    
	FOREIGN KEY (pno) REFERENCES project(pno)
	ON DELETE CASCADE 
    ON UPDATE CASCADE			,
    
	PRIMARY KEY (essn,pno)
);

CREATE TABLE dependent
(
	essn 			DECIMAL(9,0)	,
	dependent_name 	VARCHAR(20)		,
	sex 			CHAR(1)			,
	bdate 			DATE			,
	relationship 	VARCHAR(20)		,

	FOREIGN KEY (essn) REFERENCES employee(ssn)
	ON DELETE CASCADE 
    ON UPDATE CASCADE				,
	
    PRIMARY KEY (essn,dependent_name)
);

ALTER TABLE employee ADD FOREIGN KEY (dno) REFERENCES department(dno);

#Entering the Data in the table

INSERT INTO department(dname,dno,mgrssn,mgrstartdate) VALUES ('Headquater',1,null,str_to_date('06-19-1971','%m-%d-%Y'));
INSERT INTO department(dname,dno,mgrssn,mgrstartdate) VALUES ('Research',5,null,str_to_date('05-22-1978','%m-%d-%Y'));
INSERT INTO department(dname,dno,mgrssn,mgrstartdate) VALUES ('Administration',4,null,str_to_date('01-01-1985','%m-%d-%Y'));

INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('James','E','Borg',888665555, STR_TO_DATE('11-10-1927', '%m-%d-%Y'),'450 Stone, Houston, TX','M',55000,null,1);
INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('Franklin','T','Wong',333445555,STR_TO_DATE('12-08-1945','%m-%d-%Y'),'638 Voss, Houston, TX','M',40000,888665555,5);
INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('Jennifer','S','Wallace',987654321,STR_TO_DATE('06-20-1931','%m-%d-%Y'),'291 Berry, Bellaire, TX','F',43000,888665555,4);
INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('John','B','Smith',123456789,STR_TO_DATE('01-09-1955','%m-%d-%Y'),'731 Fondren, Houston, TX','M',30000,333445555,5);
INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('Alicia','J','Zelaya',999887777,STR_TO_DATE('07-19-1958','%m-%d-%Y'),'3321 Castle, Spring, TX','F',25000,987654321,4);
INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('Ramesh','K','Narayan',666884444,STR_TO_DATE('09-15-1952','%m-%d-%Y'),'975 Fire Oak, Humble, TX','M',38000,333445555,5);
INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('Joyce','A','English',453453453,STR_TO_DATE('07-31-1962','%m-%d-%Y'),'5631 Rice, Houston, TX','F',25000,333445555,5);
INSERT INTO employee(fname,minit,lname,ssn,bdate,address,sex,salary,superssn,dno) VALUES 
('Ahmad','V','Jabbar',987987987,STR_TO_DATE('03-29-1959','%m-%d-%Y'),'980 Dallas, Houston, TX','M',25000,987654321,4);

UPDATE department set mgrssn = 888665555 WHERE dno = 1;
UPDATE department set mgrssn = 333445555 WHERE dno = 5;
UPDATE department set mgrssn = 987654321 WHERE dno = 4;

INSERT INTO dept_locations(dno,dlocation) VALUES (1,'Houston');
INSERT INTO dept_locations(dno,dlocation) VALUES (4,'Stafford');
INSERT INTO dept_locations(dno,dlocation) VALUES (5,'Bellaire');
INSERT INTO dept_locations(dno,dlocation) VALUES (5,'Sugarland');
INSERT INTO dept_locations(dno,dlocation) VALUES (5,'Houston');

INSERT INTO project(pname,pno,plocation,dno) VALUES ('ProductX',1,'Bellaire',5);
INSERT INTO project(pname,pno,plocation,dno) VALUES ('ProductY',2,'Sugarland',5);
INSERT INTO project(pname,pno,plocation,dno) VALUES ('ProductZ',3,'Houston',5);
INSERT INTO project(pname,pno,plocation,dno) VALUES ('Computerization',10,'Stafford',4);
INSERT INTO project(pname,pno,plocation,dno) VALUES ('Reorganization',20,'Houston',1);
INSERT INTO project(pname,pno,plocation,dno) VALUES ('Newbenifits',30,'Stafford',4);

INSERT INTO works_on(essn,pno,hours) VALUES (123456789,1,32.5);
INSERT INTO works_on(essn,pno,hours) VALUES (123456789,2,7.5);
INSERT INTO works_on(essn,pno,hours) VALUES (666884444,3,40.0);
INSERT INTO works_on(essn,pno,hours) VALUES (453453453,1,20.0);
INSERT INTO works_on(essn,pno,hours) VALUES (453453453,2,20.0);
INSERT INTO works_on(essn,pno,hours) VALUES (333445555,2,10.0);
INSERT INTO works_on(essn,pno,hours) VALUES (333445555,3,10.0);
INSERT INTO works_on(essn,pno,hours) VALUES (333445555,10,10.0);
INSERT INTO works_on(essn,pno,hours) VALUES (333445555,20,10.0);
INSERT INTO works_on(essn,pno,hours) VALUES (333445555,1,32.5);
INSERT INTO works_on(essn,pno,hours) VALUES (999887777,30,30.0);
INSERT INTO works_on(essn,pno,hours) VALUES (999887777,10,10.0);
INSERT INTO works_on(essn,pno,hours) VALUES (987987987,10,35.0);
INSERT INTO works_on(essn,pno,hours) VALUES (987987987,30,5.0);
INSERT INTO works_on(essn,pno,hours) VALUES (987654321,30,20.0);
INSERT INTO works_on(essn,pno,hours) VALUES (987654321,20,15.0);
INSERT INTO works_on(essn,pno,hours) VALUES (888665555,20,null);

INSERT INTO dependent(essn,dependent_name,sex,bdate,relationship) VALUES (333445555,'Alice','F',STR_TO_DATE('04-05-1976','%m-%d-%Y'),'DAUGHTER');
INSERT INTO dependent(essn,dependent_name,sex,bdate,relationship) VALUES (333445555,'Theodore','M',STR_TO_DATE('10-25-1973','%m-%d-%Y'),'SON');
INSERT INTO dependent(essn,dependent_name,sex,bdate,relationship) VALUES (333445555,'Joy','F',STR_TO_DATE('05-03-1948','%m-%d-%Y'),'SPOUSE');
INSERT INTO dependent(essn,dependent_name,sex,bdate,relationship) VALUES (987654321,'Abner','M',STR_TO_DATE('02-29-1932','%m-%d-%Y'),'SPOUSE');
INSERT INTO dependent(essn,dependent_name,sex,bdate,relationship) VALUES (123456789,'Michael','M',STR_TO_DATE('01-01-1978','%m-%d-%Y'),'SON');
INSERT INTO dependent(essn,dependent_name,sex,bdate,relationship) VALUES (123456789,'Alice','F',STR_TO_DATE('12-31-1978','%m-%d-%Y'),'DAUGHTER');
INSERT INTO dependent(essn,dependent_name,sex,bdate,relationship) VALUES (123456789,'Elizabeth','F',STR_TO_DATE('05-05-1957','%m-%d-%Y'),'SPOUSE');

UPDATE department SET dname='Headquarter' WHERE mgrssn=888665555;

#Queries

#1
SELECT * FROM employee WHERE dno=1;
#2
SELECT * FROM employee WHERE ssn=(SELECT mgrssn FROM department WHERE dname='Headquarter');
#3
SELECT dname,fname FROM department JOIN employee WHERE department.mgrssn=employee.ssn;
#4
SELECT * FROM employee WHERE superssn=(SELECT ssn FROM employee WHERE fname='Franklin');
#5
SELECT fname FROM (employee join works_on ON (employee.ssn=works_on.essn)) join project ON (works_on.pno=project.pno) WHERE (hours>=10 and pname='ProductX');
