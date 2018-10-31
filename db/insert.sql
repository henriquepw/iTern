INSERT INTO company
    (email, password, cnpj, razao_social, street, number, neighborhood, city, postal_code, state)
 VALUES
    ('datacenter@email.com', '1111', '00000000000100', 'Data Center', 'Rua de cima', 1, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    ('provedor@email.com', '1111', '00000000000101', 'Provedor de Internet', 'Rua de baixo', 2, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    ('lojaeletronica@email.com', '1111', '00000000000102', 'Loja de Eletronicos', 'Rua do lado', 3, 'centro', 'Campina Grande', '58135000', 'paraíba');

INSERT INTO student
    (email, password, name, birthday, street, number, neighborhood, city, postal_code, state, url_lattes, cpf, rg, birth_place, citizenship)
VALUES
    ('felipe@email.com', '2222', 'Felipe Ferreira', '20/05/1996', 'Rua do Cemiterio', 229, 'Centro', 'Esperança', '58135000', 'Paraiba', 'url_lattes.com/curriculo_felipe', '100.267.364-03', '3.017.280', 'joão pessoa', 'brasileiro'),
    ('henrique@email.com', '2222', 'Henrique Martins', '17/01/2000', 'Unica Rua de Montadas', 229, 'Centro', 'Montadas', '58135000', 'Paraiba', 'url_lattes.com/curriculo_henrique', '000.000.000-01', '0.000.001', 'Esperança', 'brasileiro'),
    ('danillo@email.com', '2222', 'Danillo Cavalcante', '05/05/1996', 'Rua Riachuelo', 229, 'Centro', 'Campina Grande', '58135000', 'Paraiba', 'url_lattes.com/curriculo_danillo', '000.000.000-02', '0.000.002', 'Campina Grande', 'brasileiro');

INSERT INTO vacancy
    (company_id, name, scholarship, workload, description, street, number, neighborhood, city, postal_code, state)
VALUES
    (20, 'Assistente de tecnico em redes', 600.0, 6, 'Ajudar o tecnico em redes a estruturar e dar assistencia tecnica a rede de computadores', 'Rua de cima', 1, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    (18, 'Assistente de tecnico em campo', 200, 4, 'Prestar assistencia ao tecnico em visitas', 'Rua de baixo', 2, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    (19, 'Manutenção dos computadores e impressoras', 900, 6, 'Manter os equipamentos da loja funcionando', 'Rua do lado', 3, 'centro', 'Campina Grande', '58135000', 'paraíba');

INSERT INTO student_course
    (student_id, institution, name, reference_period, ingress_period, ingress_way, conclusion_year, IRA, shift)
VALUES
    (17, 'IFPB', 'Telematica', 3, '2017.2', 'enem', '2019', 8.2, 'manhã'),
    (16, 'IFPB', 'Telematica', 3, '2017.2', 'enem', '2019', 8.9, 'manhã'),
    (18, 'IFPB', 'Eng. Computação', 2, '2014.1', 'enem', '2019', 7.9, 'manhã');

INSERT INTO student_telephone
    (student_id, telephone_number)
VALUES
    (17, '(83) 99603-9682'),
    (16, '(83) 99999-9999'),
    (18, '(83) 88888-8888');

INSERT INTO student_social
    (student_id, name, url_profile)
VALUES
    (16, 'Instagram', 'www.instagram.com/felipef.bs/'),
    (17, 'Instagram', 'www.instagram.com/h3nry.ns/'),
    (18, 'Instagram', 'www.instagram.com/danillocavalcante/');

INSERT INTO requirement
    (requirement)
VALUES
    ('CCNA'),
    ('CNH tipo B'),
    ('estar cursando na area de TI');

INSERT INTO occupation_area
    (occupation_area)
VALUES
    ('Redes de computadores'),
    ('Telecomunicações'),
    ('Assistencia tecnica');

INSERT INTO vacancy_requirement
    (vacancy_id, requirement_id)
VALUES
    (21, 1),
    (19, 2),
    (20, 3);

INSERT INTO student_vacancy
    (student_id, vacancy_id)
VALUES
    (17,21),
    (16,19),
    (18,20);

INSERT INTO student_occupation_area
    (student_id, occupation_area_id)
VALUES
    (17,1),
    (16,2),
    (18,3);

INSERT INTO vacancy_occupation_area
    (vacancy_id, occupation_area_id)
VALUES
    (21,1),
    (19,2),
    (20,3);

