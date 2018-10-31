CREATE TABLE  company (
    id SERIAL,
    email VARCHAR(65) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL,
    cnpj VARCHAR(15) NOT NULL,
    razao_social VARCHAR(255),
    street VARCHAR(255) NOT NULL,
    number INTEGER NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    city VARCHAR(20) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE student (
    id SERIAL,
    email VARCHAR(65) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL,
    name VARCHAR(255) NOT NULL,
    birthday date NOT NULL,
    street VARCHAR(255) NOT NULL,
    number INTEGER NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    city VARCHAR(20) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    url_lattes VARCHAR(255),
    cpf VARCHAR(15) UNIQUE NOT NULL,
    rg VARCHAR(10) UNIQUE NOT NULL,
    birth_place VARCHAR(20) NOT NULL,
    citizenship VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE vacancy (
	id SERIAL,
	company_id INTEGER,
	name VARCHAR(255) NOT NULL,
	scholarship DOUBLE PRECISION NOT NULL,
	workload INTEGER NOT NULL,
	description VARCHAR(255) NOT NULL,
	street VARCHAR(255) NOT NULL,
    number INTEGER NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    city VARCHAR(20) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (company_id)
        REFERENCES company (id),
);

CREATE TABLE student_course (
	id SERIAL,
    student_id INTEGER,
    institution VARCHAR(100),
    name VARCHAR(255) NOT NULL,
    reference_period INTEGER NOT NULL,
    ingress_period VARCHAR(6) NOT NULL,
    ingress_way VARCHAR(10) NOT NULL,
    conclusion_year VARCHAR(6) NOT NULL,
    IRA DOUBLE PRECISION NOT NULL,
    shift VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id)
        REFERENCES student(id),
);	

CREATE TABLE student_telephone (
    id SERIAL,
    student_id INTEGER,
    telephone_number VARCHAR(15) UNIQUE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id)
        references student(id)
);

CREATE TABLE student_social (
    id SERIAL,
    student_id INTEGER,
    name VARCHAR(20) NOT NULL,
    url_profile VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id)
        REFERENCES student(id)
);

CREATE TABLE requirement (
    id SERIAL,
    requirement VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE vacancy_requirement (
    vacancy_id INTEGER,
    requirement_id INTEGER,
    FOREIGN KEY (vacancy_id)
        REFERENCES vacancy(id),
    FOREIGN KEY (requirement_id)
        REFERENCES requirement(id)
);

CREATE TABLE student_vacancy (
    student_id INTEGER,
    vacancy_id INTEGER,
    FOREIGN KEY (student_id)
        REFERENCES student(id),
    FOREIGN KEY (vacancy_id)
        REFERENCES vacancy(id)
);

CREATE TABLE occupation_area (
    id SERIAL,
    occupation_area VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE student_occupation_area (
    student_id INTEGER,
    occupation_area_id INTEGER,
    FOREIGN KEY (student_id)
        REFERENCES student(id),
    FOREIGN KEY (occupation_area_id)
        REFERENCES occupation_area(id)
);

CREATE TABLE vacancy_occupation_area (
    vacancy_id INTEGER,
    occupation_area_id INTEGER,
    FOREIGN KEY (vacancy_id)
        REFERENCES vacancy(id),
    FOREIGN KEY (occupation_area_id)
        REFERENCES occupation_area(id)
);

