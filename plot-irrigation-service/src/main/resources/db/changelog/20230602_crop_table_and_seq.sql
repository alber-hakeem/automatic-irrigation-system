--liquibase formatted sql
--changeset alber:20230602_create_crop_id_seq_table_and_seq
CREATE SEQUENCE IF NOT EXISTS public.crop_id_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.crop_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE IF NOT EXISTS public.crop
(
    id bigint NOT NULL DEFAULT nextval('crop_id_sequence'::regclass),
    name VARCHAR(200) COLLATE pg_catalog."default" NOT NULL,
    description VARCHAR COLLATE pg_catalog."default",
    created_date timestamp,
    modified_date timestamp,
    created_by character varying(100),
    modified_by character varying(100),
    marked_as_deleted boolean   default false,
    CONSTRAINT crop_pkey PRIMARY KEY (id),
    CONSTRAINT unique_crop_name_constraint UNIQUE (name)
)
    TABLESPACE pg_default;

ALTER TABLE public.crop
    OWNER TO ${user_owner};

--rollback drop table public.crop
--rollback drop sequence public.crop_id_sequence
