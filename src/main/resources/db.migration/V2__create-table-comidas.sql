create table comidas(

                         id SERIAL not null,
                         titulo varchar(100) not null,
                         imagem varchar(500) not null,
                         preco double precision not null,

                         primary key(id)
);