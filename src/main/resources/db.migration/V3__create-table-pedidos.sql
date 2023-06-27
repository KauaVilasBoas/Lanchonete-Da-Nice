create table pedidos(

                        id SERIAL not null,
                        cliente bigint not null,
                        comida bigint not null,
                        data_hora timestamp without time zone not null,

                        primary key(id)
);