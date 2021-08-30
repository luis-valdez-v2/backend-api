CREATE TABLE IF NOT EXISTS app_user
(
    id          SERIAL PRIMARY KEY,
    username    TEXT    NOT NULL UNIQUE,
    password    TEXT    NOT NULL,
    is_active   BOOLEAN NOT NULL,
    roles       TEXT    NOT NULL,
    id_afiliado INTEGER NOT NULL,

    CONSTRAINT user_afiliado_fk FOREIGN KEY (id_afiliado)
        REFERENCES afiliado (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);