--VAGAS EM ORDEM ALFABETICA
SELECT DISTINCT vacancy.*
FROM vacancy, company
WHERE vacancy.company_id = 1
ORDER BY vacancy.name asc;

--ALUNOS FORMADOS EM ORDEM ALFABETICA
SELECT student.*
FROM student, student_course
WHERE student.id = student_course.student_id
ORDER BY student.name asc;

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
iNNER JOIN vacancy
    ON company.id = vacancy.company_id;

--ESTUDANTES E SEUS RESPECTIVOS CURSOS
SELECT *
FROM student
iNNER JOIN student_course
    ON student_course.student_id = student.id;

--VAGAS E SUAS RESPECTIVAS AREAS
SELECT *
FROM vacancy
iNNER JOIN vacancy_occupation_area 
	ON vacancy.id = vacancy_occupation_area.vacancy_id
iNNER JOIN occupation_area
	ON vacancy_occupation_area.occupation_area_id = occupation_area.id

--ESTUDANTES E AS VAGAS ESCOLHIDAS
SELECT *
FROM student
iNNER JOIN student_vacancy 
	ON student_vacancy.student_id = student.id
iNNER JOIN vacancy
	ON vacancy.id = student_vacancy.vacancy_id 
 
SELECT * 
FROM vacancy v, student_vacancy sv
WHERE id IN (
    SELECT DISTINCT vacancy_id
    FROM student_vacancy
    WHERE student_id = studentId);