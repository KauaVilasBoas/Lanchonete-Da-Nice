create table clientes(

                        id SERIAL not null,
                        nome varchar(100) not null,
                        email varchar(100) not null unique,
                        telefone varchar(150) not null,
                        cpf varchar(14) not null,

                        primary key(id)
);