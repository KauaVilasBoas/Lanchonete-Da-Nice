ALTER TABLE comidas
    ADD COLUMN ativo boolean not null default true;

ALTER TABLE clientes
    ADD COLUMN ativo boolean not null default true;

ALTER TABLE pedidos
    ADD COLUMN ativo boolean not null default true;