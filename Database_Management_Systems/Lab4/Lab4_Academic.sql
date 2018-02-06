use acad;

#Query

#1

select InstructorID, CourseNo,Semester, count(distinct CourseNo) from offers where Semester=1 and CourseNo in (select distinct CourseNo from course) group by (InstructorID) having count(distinct offers.CourseNo)>1 ;

#2
select student.StudentID, SName, sum(Credit) from (student join registers on (student.StudentID=registers.StudentID)) join course on (registers.CourseNo=course.CourseNo) where Batch=2007 and AcadYear like '2007%' and Semester=2 and ProgID=11 group by(student.StudentID);

#3
select student.StudentID, SName, sum(Credit) from ((student join registers on (student.StudentID=registers.StudentID)) join course on (registers.CourseNo=course.CourseNo)) where ProgID=(select ProgID from acad.program where ProgName='Btech(CS)') and Batch=2007 and Semester=4 group by(student.StudentID) having (sum(course.Credit)<10 or sum(course.Credit)>20);

#4
select student.StudentID, SName, count(grade) from (student join registers on (student.StudentID=registers.StudentID)) where grade='FF'group by(student.StudentID) having count(Grade)>3;