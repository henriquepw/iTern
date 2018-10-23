CREATE TABLE  company (
    id integer,
    email varchar(65) unique not null,
    password varchar(30) not null,
    cnpj integer not null,
    razao_social varchar(255) not null,
    street varchar(255) not null,
    num integer not null,
    neighborhood varchar(255) not null,
    city varchar(20) not null,
    postal_code varchar(20) not null,
    state varchar(20) not null,
    country varchar(20) not null,
    primary key (id)
);

CREATE TABLE student (
    id integer,
    email varchar(65) unique not null,
    password varchar(30) not null,
    name varchar(255) not null,
    birthday date not null,
    street varchar(255) not null,
    number integer not null,
    neighborhood varchar(255) not null,
    city varchar(20) not null,
    postal_code varchar(20) not null,
    state varchar(20) not null,
    url_lattes varchar(255) not null,
    cpf integer unique not null,
    rg integer unique not null,
    birth_place varchar(20) not null,
    citizenship varchar(20) not null,
	primary key (id)
);

CREATE TABLE vacancy (
	id integer,
	company_id integer,
	name varchar(255) not null,
	occupation_area varchar(20) not null,
	scholarship double precision not null,
	description varchar(255) not null,
	street varchar(255) not null,
    number integer not null,
    neighborhood varchar(255) not null,
    city varchar(20) not null,
    postal_code varchar(20) not null,
    state varchar(20) not null,
    primary key (id),
    foreign key (company_id)
    references company (id)
);

CREATE TABLE institution (
    id integer,
    name varchar(40) unique not null,
    acronym varchar(10) unique not null,
    state varchar(20) not null,
    campus varchar(20) not null,
    primary key (id)
);

CREATE TABLE student_course (
	id integer,
    student_id integer,
    institution_id integer,
    name varchar(255) not null,
    reference_period varchar(6) not null,
    ingress_period varchar(6) not null,
    ingress_way varchar(10) not null,
    conclusion_year  varchar(6) not null,
    IRA double precision not null,
    shift varchar(10) not null,
    primary key (id),
    foreign key (student_id)
    references student(id),
    foreign key (institution_id)
    references institution(id)
);	

CREATE TABLE student_telephone (
    id integer,
    student_id integer,
    telephone_number integer unique not null,
    primary key (id),
    foreign key (student_id)
    references student(id)
);

CREATE TABLE student_social (
    id integer,
    student_id integer,
    name varchar(20) not null,
    url_profile varchar(255) not null,
    primary key (id),
    foreign key (student_id)
    references student(id)
);

CREATE TABLE requirement(
    id integer,
    requirement varchar(100),
    primary key (id)
);
	
CREATE TABLE student_vacancy(
    student_id integer,
    vacancy_id integer,
    foreign key (student_id)
    references student(id),
    foreign key (vacancy_id)
    references vacancy(id)
);

CREATE TABLE occupation_area(
    id integer,
    occupation_area varchar(100),
    primary key (id)
);

CREATE TABLE student_occupation_area(
    student_id integer,
    occupation_area_id integer,
    foreign key (student_id)
    references student(id),
    foreign key (occupation_area_id)
    references occupation_area(id)
);

CREATE TABLE vacancy_occupation_area(
    vacancy_id integer,
    occupation_area_id integer,
    foreign key (vacancy_id)
    references vacancy(id),
    foreign key (occupation_area_id)
    references occupation_area(id)
);

CREATE TABLE vacancy_requirement(
    vacancy_id integer,
    requirement_id integer,
    foreign key (vacancy_id)
    references vacancy(id),
    foreign key (requirement_id)
    references requirement(id)
);
