--VAGAS  EM ORDEM ALFABETICA
SELECT DISTINCT vacancy.*
FROM vacancy, company
WHERE vacancy.company_id = 1
order by vacancy.name asc;

--ALUNOS FORMADOS EM ORDEM ALFABETICA
SELECT student.*
FROM student, student_course
WHERE student.id = student_course.student_id;
order by student.name asc;

--VAGAS POR AREA
SELECT vacancy.name
FROM vacancy, vacancy_occupation_area
WHERE vacancy_occupation_area.vacancy_id = vacancy.id AND vacancy_occupation_area.occupation_area_id = x;

--TODAS AS EMPRESAS
SELECT *
FROM company;

--TODAS AS VAGAS
SELECT *
FROM vacancy;

--COMPANHIAS E SUAS RESPECTIVAS VAGAS
SELECT *
FROM company
left join vacancy
    on company.id = vacancy.company_id;

--ESTUDANTES E SEUS RESPECTIVOS CURSOS
SELECT *
FROM student
left join student_course
    on student_course.student_id = student.id;

--VAGAS E SUAS RESPECTIVAS AREAS
SELECT *
FROM vacancy
join vacancy_occupation_area 
	on vacancy.id = vacancy_occupation_area.vacancy_id
join occupation_area
	on vacancy_occupation_area.occupation_area_id = occupation_area.id

--ESTUDANTES E AS VAGAS ESCOLHIDAS
SELECT *
FROM student
join student_vacancy 
	on student_vacancy.student_id = student.id
join vacancy
	on vacancy.id = student_vacancy.vacancy_id 
 
SELECT * 
FROM vacancy v, student_vacancy sv
WHERE v.id = sv.vacancy_id 
AND sv.student_id <> 7;