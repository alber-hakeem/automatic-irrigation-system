--liquibase formatted sql
--changeset alber:20230602_create_plot_id_seq_table_and_seq
CREATE SEQUENCE IF NOT EXISTS public.plot_id_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.plot_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE IF NOT EXISTS public.plot
(
    id bigint NOT NULL DEFAULT nextval('plot_id_sequence'::regclass),
    name VARCHAR(500) COLLATE pg_catalog."default" NOT NULL,
    area DECIMAL(10, 2) NOT NULL,
    description VARCHAR COLLATE pg_catalog."default",
    created_date timestamp,
    modified_date timestamp,
    created_by character varying(100),
    modified_by character varying(100),
    marked_as_deleted boolean   default false,
    CONSTRAINT plot_pkey PRIMARY KEY (id),
    CONSTRAINT unique_plot_name_constraint UNIQUE (name)
)
    TABLESPACE pg_default;

ALTER TABLE public.plot
    OWNER TO ${user_owner};

--rollback drop table public.plot
--rollback drop sequence public.plot_id_sequence
