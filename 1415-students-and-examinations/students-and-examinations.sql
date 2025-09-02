# Write your MySQL query statement below
select S.student_id ,S.student_name,sb.subject_name ,count(e.student_id) 
as attended_exams
from Students  S cross join Subjects sb left join Examinations e  on  e.student_id =S.student_id 
and e.subject_name=sb.subject_name  
group by subject_name,student_name,student_id
order by student_id,subject_name