use cinemapds;

## Inserts
insert into admin (admin_login, admin_pass) values ("admin", "admin");
Insert into filme (filme_nome) values ("Jonh Wick"), ("Gato de botas"), ("Mario");

insert into sala (sala_nome, sala_horario, filme_idfilme) values ("A1", "10:00", 1);
insert into sala (sala_nome, sala_horario, filme_idfilme) values ("A2", "20:00", 1);

insert into sala (sala_nome, sala_horario, filme_idfilme) values ("B1", "08:00", 2);
insert into sala (sala_nome, sala_horario, filme_idfilme) values ("B2", "12:20", 2);

insert into sala (sala_nome, sala_horario, filme_idfilme) values ("C1", "06:50", 3);
insert into sala (sala_nome, sala_horario, filme_idfilme) values ("C2", "23:20", 3);

INSERT INTO FUNCIONARIO (cpf_funcionario, nome_funcionario, funcionario_valor_vendas) VALUES ("66666666666", "banco", "100.90");

## Selects 
select * from admin;
SELECT * FROM assento;
SELECT * FROM cliente;
SELECT * FROM filme;
SELECT * FROM funcionario;
select * from sala;
select * from venda;

## Deletes
delete  from admin;
delete FROM assento;
delete FROM cliente;
delete FROM filme;
delete FROM funcionario;
delete from sala;
delete from venda;
