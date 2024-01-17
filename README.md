# PGSQL
CREATE TABLE data(
  "id" SERIAL NOT NULL,
  "start_time" VARCHAR(100),
  "end_time" VARCHAR(100),
  "year" VARCHAR(100),
  "work_space" INTEGER,
  "start_break" VARCHAR(100),
  "end_break" VARCHAR(100),
  PRIMARY KEY ("id"));

AttendanceManageTest
CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    username character varying(255) COLLATE pg_catalog."default",
    password_hash character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    created_at time(6) without time zone,
    updated_at time(6) without time zone,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
