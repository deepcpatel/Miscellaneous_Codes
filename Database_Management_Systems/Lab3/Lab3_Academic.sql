use acad;

#1
select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where registers.CourseNo=('MT101' or 'MT104');

#2
select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where registers.CourseNo='MT101' in (registers.CourseNo='MT104');

#3
select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where registers.CourseNo='MT101' and student.StudentID not in (select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where registers.CourseNo='MT104');

#4
select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where registers.CourseNo='MT104' and student.StudentID not in (select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where registers.CourseNo='MT101');

#5
select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where registers.CourseNo='MT101' in (registers.CourseNo='MT104') and student.Batch='2007';

#6
use company;
select fname,dname from (works_on right join (employee join department on (employee.dno=department.dno)) on (works_on.essn=ssn)) where pno is null;

#7
use acad;
select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where grade='AA' and ((semester=1 and batch='2008') or (semester=3 and batch='2007')) ;

#8
select distinct student.StudentId from (student join registers on (student.StudentId=registers.StudentId)) where (grade='AA' or grade='AB') and ((semester=1 and batch='2008') or (semester=3 and batch='2007')) ;

#9
select distinct CourseNo from instructor join offers on (instructor.InstructorID=offers.InstructorID) where InstructorName='P M Jaat';

#10
select distinct student.StudentID from student join (registers join offers on (registers.CourseNo=offers.CourseNo)) on (student.StudentID=registers.StudentID) where InstructorID=(select InstructorID from instructor where InstructorName='P M Jaat');

#11
select distinct student.StudentID from student join result on (student.StudentID=result.StudentID) where ProgID=(select ProgID from program where ProgName='Btech(CS)') and batch=2007 and spi>=6;

#12
select * from student join ((select StudentID from registers where grade!='FF')as a) on (student.StudentID=a.StudentID) where ProgID=(select ProgID from program where ProgName='Btech(CS)') and batch=2007;
