PGDMP              
        {            postgres %   12.16 (Ubuntu 12.16-0ubuntu0.20.04.1)    16.0     p           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            q           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            r           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            s           1262    13427    postgres    DATABASE     p   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C.UTF-8';
    DROP DATABASE postgres;
                postgres    false            t           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    2931                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false            u           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    6            �            1259    24576    data    TABLE     �   CREATE TABLE public.data (
    name character varying,
    begin_time character varying,
    end_time character varying,
    work_space integer,
    id integer NOT NULL
);
    DROP TABLE public.data;
       public         heap    postgres    false    6            �            1259    32768    data_id_seq    SEQUENCE     �   CREATE SEQUENCE public.data_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.data_id_seq;
       public          postgres    false    6    202            v           0    0    data_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.data_id_seq OWNED BY public.data.id;
          public          postgres    false    203            �
           2604    32770    data id    DEFAULT     b   ALTER TABLE ONLY public.data ALTER COLUMN id SET DEFAULT nextval('public.data_id_seq'::regclass);
 6   ALTER TABLE public.data ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            l          0    24576    data 
   TABLE DATA           J   COPY public.data (name, begin_time, end_time, work_space, id) FROM stdin;
    public          postgres    false    202   �       w           0    0    data_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.data_id_seq', 14, true);
          public          postgres    false    203            l      x������ � �     