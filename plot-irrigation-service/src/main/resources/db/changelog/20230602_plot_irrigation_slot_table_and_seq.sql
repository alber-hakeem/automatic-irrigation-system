--liquibase formatted sql
--changeset alber:20230602_create_plot_irrigation_slot_id_seq_table_and_seq
CREATE SEQUENCE IF NOT EXISTS public.plot_irrigation_slot_id_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.plot_irrigation_slot_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE IF NOT EXISTS public.plot_irrigation_slot
(
    id bigint NOT NULL DEFAULT nextval('plot_irrigation_slot_id_sequence'::regclass),
    plot_crop_id           bigint                               NOT NULL,
    irrigation_date DATE NOT NULL,
    irrigation_start_time TIME NOT NULL,
    irrigation_end_time TIME NOT NULL,
    amount_of_water DECIMAL(10, 2) NOT NULL,
    irrigation_status VARCHAR(30) COLLATE pg_catalog."default",
    created_date timestamp,
    modified_date timestamp,
    created_by character varying(100),
    modified_by character varying(100),
    marked_as_deleted boolean   default false,
    CONSTRAINT plot_irrigation_slot_pkey PRIMARY KEY (id),
    CONSTRAINT plot_irrigation_slot_plot_fk FOREIGN KEY (plot_crop_id) REFERENCES public.plot_crop (id)
    )
    TABLESPACE pg_default;

ALTER TABLE public.plot_irrigation_slot
    OWNER TO ${user_owner};

--rollback drop table public.plot_irrigation_slot
--rollback drop sequence public.plot_irrigation_slot_id_sequence
