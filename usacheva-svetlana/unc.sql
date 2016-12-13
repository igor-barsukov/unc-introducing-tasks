--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.4.10
-- Started on 2016-12-13 14:59:50

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
-- TOC entry 2027 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 16477)
-- Name: Company; Type: TABLE; Schema: public; Owner: sveta; Tablespace: 
--

CREATE TABLE "Company" (
    name character varying(250) NOT NULL
);


ALTER TABLE "Company" OWNER TO sveta;

--
-- TOC entry 174 (class 1259 OID 16407)
-- Name: EmpToProject; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "EmpToProject" (
    emp_id bigint NOT NULL,
    name character varying(250)
);


ALTER TABLE "EmpToProject" OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16398)
-- Name: Employee; Type: TABLE; Schema: public; Owner: sveta; Tablespace: 
--

CREATE TABLE "Employee" (
    name character varying(250),
    department character varying(250),
    empl_id integer NOT NULL
);


ALTER TABLE "Employee" OWNER TO sveta;

--
-- TOC entry 175 (class 1259 OID 16455)
-- Name: Employee_empl_id_seq; Type: SEQUENCE; Schema: public; Owner: sveta
--

CREATE SEQUENCE "Employee_empl_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Employee_empl_id_seq" OWNER TO sveta;

--
-- TOC entry 2028 (class 0 OID 0)
-- Dependencies: 175
-- Name: Employee_empl_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sveta
--

ALTER SEQUENCE "Employee_empl_id_seq" OWNED BY "Employee".empl_id;


--
-- TOC entry 176 (class 1259 OID 16466)
-- Name: Project; Type: TABLE; Schema: public; Owner: sveta; Tablespace: 
--

CREATE TABLE "Project" (
    name character varying(250) NOT NULL,
    company character varying(250),
    manager_id bigint
);


ALTER TABLE "Project" OWNER TO sveta;

--
-- TOC entry 1895 (class 2604 OID 16457)
-- Name: empl_id; Type: DEFAULT; Schema: public; Owner: sveta
--

ALTER TABLE ONLY "Employee" ALTER COLUMN empl_id SET DEFAULT nextval('"Employee_empl_id_seq"'::regclass);


--
-- TOC entry 2019 (class 0 OID 16477)
-- Dependencies: 177
-- Data for Name: Company; Type: TABLE DATA; Schema: public; Owner: sveta
--

COPY "Company" (name) FROM stdin;
Nokia
Apple
LG
Sony
\.


--
-- TOC entry 2016 (class 0 OID 16407)
-- Dependencies: 174
-- Data for Name: EmpToProject; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "EmpToProject" (emp_id, name) FROM stdin;
1	TV
1	TV
4	NokProj
1	TV
4	NokProj
1	TV
4	NokProj
\.


--
-- TOC entry 2015 (class 0 OID 16398)
-- Dependencies: 173
-- Data for Name: Employee; Type: TABLE DATA; Schema: public; Owner: sveta
--

COPY "Employee" (name, department, empl_id) FROM stdin;
John	Administration	1
Steve	Shipping	2
Mark	IT	3
Alex	Administration	4
Morgan	IT	5
Lili	Sales	6
Henry	Sales	7
Max	Sales	8
Carol	Markenting	9
Angela	IT	10
\.


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 175
-- Name: Employee_empl_id_seq; Type: SEQUENCE SET; Schema: public; Owner: sveta
--

SELECT pg_catalog.setval('"Employee_empl_id_seq"', 10, true);


--
-- TOC entry 2018 (class 0 OID 16466)
-- Dependencies: 176
-- Data for Name: Project; Type: TABLE DATA; Schema: public; Owner: sveta
--

COPY "Project" (name, company, manager_id) FROM stdin;
IPhone7	Apple	5
TV	LG	3
NokProj	Nokia	3
IPhone5	Apple	1
\.


--
-- TOC entry 1901 (class 2606 OID 16481)
-- Name: pk_company_name; Type: CONSTRAINT; Schema: public; Owner: sveta; Tablespace: 
--

ALTER TABLE ONLY "Company"
    ADD CONSTRAINT pk_company_name PRIMARY KEY (name);


--
-- TOC entry 1897 (class 2606 OID 16465)
-- Name: pk_empl_id; Type: CONSTRAINT; Schema: public; Owner: sveta; Tablespace: 
--

ALTER TABLE ONLY "Employee"
    ADD CONSTRAINT pk_empl_id PRIMARY KEY (empl_id);


--
-- TOC entry 1899 (class 2606 OID 16473)
-- Name: pk_name; Type: CONSTRAINT; Schema: public; Owner: sveta; Tablespace: 
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT pk_name PRIMARY KEY (name);


--
-- TOC entry 1904 (class 2606 OID 16497)
-- Name: fk_company; Type: FK CONSTRAINT; Schema: public; Owner: sveta
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT fk_company FOREIGN KEY (company) REFERENCES "Company"(name);


--
-- TOC entry 1902 (class 2606 OID 24612)
-- Name: fk_empl_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT fk_empl_id FOREIGN KEY (emp_id) REFERENCES "Employee"(empl_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1905 (class 2606 OID 24597)
-- Name: fk_manager_id; Type: FK CONSTRAINT; Schema: public; Owner: sveta
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT fk_manager_id FOREIGN KEY (manager_id) REFERENCES "Employee"(empl_id) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1903 (class 2606 OID 24617)
-- Name: fk_name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT fk_name FOREIGN KEY (name) REFERENCES "Project"(name);


--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-13 14:59:51

--
-- PostgreSQL database dump complete
--

