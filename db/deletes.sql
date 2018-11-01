--Exclusão de uma vaga oferecida por uma empresa
DELETE FROM vacancy
WHERE company_id = x

-- Exclusão de uma empresa
DELETE FROM company
Where id = x;

-- Exclusão do número de telefone de um estudante
DELETE FROM student_telephone
WHERE student_id = x;

-- Exclusão de uma rede social de um estudante
DELETE FROM student_social
WHERE student_id = x;

-- Exclusão de um curso de um estudante
DELETE FROM student_course
WHERE student_id = x;

-- Exclusão de uma vaga de estudante
DELETE FROM student_vacancy
WHERE student_id = x;

-- Exclusão de um estudante
DELETE FROM student
WHERE id = x;
