INSERT INTO clients (name) VALUES('martin');
INSERT INTO clients (name) VALUES('edith');

INSERT INTO orders (code_number,  creation_date, status, client_id) VALUES('C01', NOW(), 'CREATED', 1);
INSERT INTO orders (code_number,  creation_date, status, client_id) VALUES('C02', NOW(), 'CREATED', 1);
INSERT INTO orders (code_number, creation_date, status, client_id) VALUES('C03',  NOW(), 'CREATED', 2);
