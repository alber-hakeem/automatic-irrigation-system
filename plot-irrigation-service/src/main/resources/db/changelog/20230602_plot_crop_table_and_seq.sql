--liquibase formatted sql
--changeset alber:20230602_create_plot_crop_id_seq_table_and_seq
CREATE SEQUENCE IF NOT EXISTS public.plot_crop_id_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.plot_crop_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE IF NOT EXISTS public.plot_crop
(
    id bigint NOT NULL DEFAULT nextval('plot_crop_id_sequence'::regclass),
    plot_id   bigint  NOT NULL,
    crop_id   bigint  NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    cultivated_area DECIMAL(10, 2) NOT NULL,
    created_date timestamp,
    modified_date timestamp,
    created_by character varying(100),
    modified_by character varying(100),
    marked_as_deleted boolean   default false,
    CONSTRAINT plot_crop_pkey PRIMARY KEY (id),
    CONSTRAINT plot_crop_plot_fk FOREIGN KEY (plot_id) REFERENCES public.plot (id),
    CONSTRAINT plot_crop_crop_fk FOREIGN KEY (crop_id) REFERENCES public.crop (id)
    )
    TABLESPACE pg_default;

ALTER TABLE public.plot_crop
    OWNER TO ${user_owner};

--rollback drop table public.plot_crop
--rollback drop sequence public.plot_crop_id_sequence
