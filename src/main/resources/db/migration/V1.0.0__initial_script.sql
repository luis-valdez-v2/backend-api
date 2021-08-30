CREATE TABLE IF NOT EXISTS afiliado
(
    id SERIAL PRIMARY KEY,
    nombre text COLLATE pg_catalog."default" NOT NULL,
    dob date,
    calle text COLLATE pg_catalog."default",
    extnum smallint,
    intnum smallint,
    colonia text COLLATE pg_catalog."default",
    cod_post integer,
    geo_lat double precision,
    geo_lng double precision,
    tipo smallint,
    email text COLLATE pg_catalog."default",
    phone text COLLATE pg_catalog."default"
);

CREATE TABLE IF NOT EXISTS ubicacion
(
    id SERIAL PRIMARY KEY,
    fecha date,
    geo_lat double precision,
    geo_lng double precision,
    id_afiliado integer,
    CONSTRAINT ubicacion_afiliado_fk FOREIGN KEY (id_afiliado)
        REFERENCES afiliado (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS solicitud
(
    id SERIAL PRIMARY KEY,
    fecha_rec date,
    fecha_serv date,
    hora time with time zone,
    estado smallint,
    id_afiliado integer NOT NULL,
    CONSTRAINT afiliado_fk FOREIGN KEY (id_afiliado)
        REFERENCES afiliado (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS servicio
(
    id SERIAL PRIMARY KEY,
    fecha date,
    observacion text COLLATE pg_catalog."default",
    cod_material smallint,
    cantidad integer,
    puntos_afiliado integer,
    puntos_recolector integer,
    id_recolector integer NOT NULL,
    solicitud_id integer NOT NULL,
    CONSTRAINT recolector_fk FOREIGN KEY (id_recolector)
        REFERENCES afiliado (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT solicitud_fk FOREIGN KEY (solicitud_id)
        REFERENCES solicitud (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

