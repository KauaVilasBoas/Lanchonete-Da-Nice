create table pedidos(

                        id SERIAL not null,
                        client bigint not null,
                        food bigint not null,
                        data_hora timestamp without time zone not null,

                        primary key(id)
);