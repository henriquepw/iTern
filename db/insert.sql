INSERT INTO company VALUES
    ('email', 'password', 'cnpj', 'razão_social', 'street', number, 'neighborhood', 'city', 'postal_code', 'state')
    ('datacenter@email.com', '1111', '00.000.000/0001-00', 'Data Center', 'Rua de cima', 1, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    ('provedor@email.com', '1111', '00.000.000/0001-01', 'Provedor de Internet', 'Rua de baixo', 2, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    ('lojaeletronica@email.com', '1111', '00.000.000/0001-02', 'Loja de Eletronicos', 'Rua do lado', 3, 'centro', 'Campina Grande', '58135000', 'paraíba');

INSERT INTO student VALUES
    ('email', 'password', 'name', 'birthday', 'street', number, 'neighborhood', 'city', 'postal_code', 'state', 'url_lattes', 'cpf', 'rg', 'birth_place', 'citizenship')
    ('felipe@email.com', '2222', 'Felipe Ferreira', '20/05/1996', 'Rua do Cemiterio', 229, 'Centro', 'Esperança', '58135000', 'Paraiba', 'url_lattes.com/curriculo_felipe', '100.267.364-03', '3.017.280', 'joão pessoa', 'brasileiro'),
    ('henrique@email.com', '2222', 'Henrique Martins', '17/01/2000', 'Unica Rua de Montadas', 229, 'Centro', 'Montadas', '58135000', 'Paraiba', 'url_lattes.com/curriculo_henrique', '000.000.000-01', '0.000.001', 'Esperança', 'brasileiro'),
    ('danillo@email.com', '2222', 'Danillo Cavalcante', '05/05/1996', 'Rua Riachuelo', 229, 'Centro', 'Campina Grande', '58135000', 'Paraiba', 'url_lattes.com/curriculo_danillo', '000.000.000-02', '0.000.002', 'Campina Grande', 'brasileiro');

INSERT INTO vacancy VALUES
    (company_id, 'name', workload, 'description', 'street', number, 'neighborhood', 'city', 'postal_code', 'state')
    (1, 'Assistente de tecnico em redes', 6, 'Ajudar o tecnico em redes a estruturar e dar assistencia tecnica a rede de computadores', 'Rua de cima', 1, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    (2, 'Assistente de tecnico em campo', 4, 'Prestar assistencia ao tecnico em visitas', 'Rua de baixo', 2, 'centro', 'Campina Grande', '58135000', 'paraíba'),
    (3, 'Manutenção dos computadores e impressoras', 6, 'Manter os equipamentos da loja funcionando', 'Rua do lado', 3, 'centro', 'Campina Grande', '58135000', 'paraíba');

INSERT INTO student_course VALUES
    (student_id, 'institution', 'name', reference_period, 'ingress_period', 'ingress_way', 'conclusion_year', IRA, 'shift')
    (1, 'IFPB', 'Telematica', 3, '2', '2017', 'enem', '2019', 8.2, 'manhã'),
    (2, 'IFPB', 'Telematica', 3, '2', '2017', 'enem', '2019', 8.9, 'manhã'),
    (3, 'IFPB', 'Eng. Computação', 2, '2', '2014', 'enem', '2019', 7.9, 'manhã');

INSERT INTO student_telephone VALUES
    (student_id, '(NN) NNNNN-NNNN')
    (1, '(83) 99603-9682'),
    (2, '(83) 99999-9999'),
    (3, '(83) 88888-8888');

INSERT INTO student_social VALUES
    (student_id, 'name', 'url_profile')
    (1, 'Instagram', 'www.instagram.com/felipef.bs/'),
    (2, 'Instagram', 'www.instagram.com/h3nry.ns/'),
    (3, 'Instagram', 'www.instagram.com/danillocavalcante/')

INSERT INTO requirement VALUES
    ('requirement')
    ('CCNA'),
    ('CNH tipo B'),
    ('estar cursando na area de TI');

INSERT INTO vacancy_requirement VALUES
    (vacancy_id, requirement_id)
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO student_vacancy VALUES
    (student_id, vacancy_id)
    (1,2),
    (2,3),
    (3,1);

INSERT INTO occupation_area VALUES
    (occupation_area)
    ('Redes de computadores'),
    ('Telecomunicações'),
    ('Assistencia tecnica');

INSERT INTO student_occupation_area VALUES
    (student_id, occupation_area_id)
    (1,1),
    (2,2),
    (3,3);

INSERT INTO vacancy_occupation_area VALUES
    (vacancy_id, occupation_area_id)
    (1,1),
    (2,2),
    (3,3);
