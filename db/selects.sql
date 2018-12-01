SELECT vacancy.name
FROM vacancy, company
WHERE vacancy.company_id = x
order by vacancy.name asc;

SELECT student.name
FROM student, student_course
WHERE student.id = student_course.student_id;

SELECT vacancy.name
FROM vacancy, vacancy_occupation_area
WHERE vacancy_occupation_area.vacancy_id = vacancy.id AND vacancy_occupation_area.occupation_area_id = x;

SELECT * 
FROM vacancy v, student_vacancy sv
WHERE v.id = sv.vacancy_id 
AND sv.student_id <> 7;