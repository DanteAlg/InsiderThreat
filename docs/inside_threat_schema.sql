--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.0
-- Dumped by pg_dump version 9.6.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: devices; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE devices (
    id integer NOT NULL,
    pc_id character varying(240),
    user_id character varying(240),
    date timestamp without time zone NOT NULL,
    activity character varying(240) NOT NULL,
    device_id character varying(200)
);


--
-- Name: devices_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE devices_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: devices_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE devices_id_seq OWNED BY devices.id;


--
-- Name: http; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE http (
    id integer NOT NULL,
    pc_id character varying(240),
    user_id character varying(240),
    date timestamp without time zone NOT NULL,
    activity character varying(240) NOT NULL,
    http_id character varying(200) NOT NULL
);


--
-- Name: http_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE http_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: http_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE http_id_seq OWNED BY http.id;


--
-- Name: logon; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE logon (
    id integer NOT NULL,
    pc_id character varying(240),
    user_id character varying(240),
    date timestamp without time zone NOT NULL,
    activity character varying(240) NOT NULL,
    logon_id character varying(200) NOT NULL
);


--
-- Name: logon_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE logon_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: logon_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE logon_id_seq OWNED BY logon.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE users (
    id integer NOT NULL,
    user_id character varying(240) NOT NULL,
    name character varying(240) NOT NULL,
    email character varying(240) NOT NULL,
    role character varying(100) NOT NULL,
    domain character varying(100)
);


--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: devices id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY devices ALTER COLUMN id SET DEFAULT nextval('devices_id_seq'::regclass);


--
-- Name: http id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY http ALTER COLUMN id SET DEFAULT nextval('http_id_seq'::regclass);


--
-- Name: logon id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY logon ALTER COLUMN id SET DEFAULT nextval('logon_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Name: devices devices_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY devices
    ADD CONSTRAINT devices_pkey PRIMARY KEY (id);


--
-- Name: http http_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY http
    ADD CONSTRAINT http_pkey PRIMARY KEY (id);


--
-- Name: logon logon_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY logon
    ADD CONSTRAINT logon_pkey PRIMARY KEY (id);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users users_user_id_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_user_id_key UNIQUE (user_id);


--
-- PostgreSQL database dump complete
--

