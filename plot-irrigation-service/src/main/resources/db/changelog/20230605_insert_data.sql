--liquibase formatted sql
--changeset Alber:20230605_insert_plot_data
INSERT INTO public.plot (id, name, area, description, created_date, modified_date, created_by,
                             modified_by, marked_as_deleted)
VALUES (nextval('plot_id_sequence'), 'Plot1', 200,'Plot1', current_date, current_date, 'admin','admin', false);

INSERT INTO public.plot (id, name, area, description, created_date, modified_date, created_by,
                         modified_by, marked_as_deleted)
VALUES (nextval('plot_id_sequence'), 'Plot2', 500,'Plot2', current_date, current_date, 'admin','admin', false);

INSERT INTO public.plot (id, name, area, description, created_date, modified_date, created_by,
                         modified_by, marked_as_deleted)
VALUES (nextval('plot_id_sequence'), 'Plot3',1000, 'Plot3', current_date, current_date, 'admin','admin', false);



--changeset Alber:20230605_insert_crop_data
INSERT INTO public.crop (id, name, description, created_date, modified_date, created_by,
                         modified_by, marked_as_deleted)
VALUES (nextval('plot_id_sequence'), 'Wheat','Wheat', current_date, current_date, 'admin','admin', false);

INSERT INTO public.crop (id, name, description, created_date, modified_date, created_by,
                         modified_by, marked_as_deleted)
VALUES (nextval('plot_id_sequence'), 'Rice','Rice', current_date, current_date, 'admin','admin', false);

INSERT INTO public.crop (id, name, description, created_date, modified_date, created_by,
                         modified_by, marked_as_deleted)
VALUES (nextval('plot_id_sequence'), 'Tomato', 'Tomato', current_date, current_date, 'admin','admin', false);