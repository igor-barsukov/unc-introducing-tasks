--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.4.10
-- Started on 2016-12-26 14:34:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2030 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 175 (class 1259 OID 16645)
-- Name: company; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE company (
    name character varying(50) NOT NULL
);


ALTER TABLE company OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16604)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employees (
    empid integer NOT NULL,
    name character varying(50),
    department character varying(50),
    CONSTRAINT cheklngth CHECK ((char_length((name)::text) > 3))
);


ALTER TABLE employees OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16602)
-- Name: employees_empid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE employees_empid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employees_empid_seq OWNER TO postgres;

--
-- TOC entry 2031 (class 0 OID 0)
-- Dependencies: 173
-- Name: employees_empid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE employees_empid_seq OWNED BY employees.empid;


--
-- TOC entry 178 (class 1259 OID 16722)
-- Name: emptoproject; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE emptoproject (
    empid integer NOT NULL,
    name character varying(50)
);


ALTER TABLE emptoproject OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16720)
-- Name: emptoproject_empid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE emptoproject_empid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE emptoproject_empid_seq OWNER TO postgres;

--
-- TOC entry 2032 (class 0 OID 0)
-- Dependencies: 177
-- Name: emptoproject_empid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE emptoproject_empid_seq OWNED BY emptoproject.empid;


--
-- TOC entry 176 (class 1259 OID 16705)
-- Name: projects; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE projects (
    name character varying(50) NOT NULL,
    company character varying(50),
    managerid integer
);


ALTER TABLE projects OWNER TO postgres;

--
-- TOC entry 1895 (class 2604 OID 16607)
-- Name: empid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees ALTER COLUMN empid SET DEFAULT nextval('employees_empid_seq'::regclass);


--
-- TOC entry 1897 (class 2604 OID 16725)
-- Name: empid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY emptoproject ALTER COLUMN empid SET DEFAULT nextval('emptoproject_empid_seq'::regclass);


--
-- TOC entry 2019 (class 0 OID 16645)
-- Dependencies: 175
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO company VALUES ('microsoft');
INSERT INTO company VALUES ('netCracker');
INSERT INTO company VALUES ('nec');


--
-- TOC entry 2018 (class 0 OID 16604)
-- Dependencies: 174
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO employees VALUES (1, 'Petya', 'Sale');
INSERT INTO employees VALUES (2, 'Vasya', 'Sale');
INSERT INTO employees VALUES (3, 'Lesha', 'Development');
INSERT INTO employees VALUES (4, 'Dima', 'Development');
INSERT INTO employees VALUES (5, 'Zina', 'HR');
INSERT INTO employees VALUES (6, 'Katya', 'HR');
INSERT INTO employees VALUES (7, 'Stepa', 'Development');


--
-- TOC entry 2033 (class 0 OID 0)
-- Dependencies: 173
-- Name: employees_empid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('employees_empid_seq', 7, true);


--
-- TOC entry 2022 (class 0 OID 16722)
-- Dependencies: 178
-- Data for Name: emptoproject; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO emptoproject VALUES (7, 'QWE');
INSERT INTO emptoproject VALUES (4, 'AVG');
INSERT INTO emptoproject VALUES (3, '4g');
INSERT INTO emptoproject VALUES (7, 'AVG');


--
-- TOC entry 2034 (class 0 OID 0)
-- Dependencies: 177
-- Name: emptoproject_empid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('emptoproject_empid_seq', 1, false);


--
-- TOC entry 2020 (class 0 OID 16705)
-- Dependencies: 176
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO projects VALUES ('4g', 'nec', 3);
INSERT INTO projects VALUES ('AVG', 'netCracker', 4);
INSERT INTO projects VALUES ('QWE', 'nec', 7);


--
-- TOC entry 1901 (class 2606 OID 16649)
-- Name: company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY company
    ADD CONSTRAINT company_pkey PRIMARY KEY (name);


--
-- TOC entry 1899 (class 2606 OID 16609)
-- Name: employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (empid);


--
-- TOC entry 1903 (class 2606 OID 16709)
-- Name: projects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (name);


--
-- TOC entry 1906 (class 2606 OID 16726)
-- Name: emptoproject_empid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY emptoproject
    ADD CONSTRAINT emptoproject_empid_fkey FOREIGN KEY (empid) REFERENCES employees(empid);


--
-- TOC entry 1907 (class 2606 OID 16731)
-- Name: emptoproject_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY emptoproject
    ADD CONSTRAINT emptoproject_name_fkey FOREIGN KEY (name) REFERENCES projects(name);


--
-- TOC entry 1904 (class 2606 OID 16710)
-- Name: projects_company_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT projects_company_fkey FOREIGN KEY (company) REFERENCES company(name);


--
-- TOC entry 1905 (class 2606 OID 16715)
-- Name: projects_managerid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY projects
    ADD CONSTRAINT projects_managerid_fkey FOREIGN KEY (managerid) REFERENCES employees(empid);


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-26 14:34:21

--
-- PostgreSQL database dump complete
--

