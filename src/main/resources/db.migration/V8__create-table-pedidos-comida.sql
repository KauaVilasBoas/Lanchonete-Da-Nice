CREATE TABLE pedidos_comida
(

    id         SERIAL not null,
    id_cliente bigint not null,
    id_comida  bigint not null,

    primary key (id)

);