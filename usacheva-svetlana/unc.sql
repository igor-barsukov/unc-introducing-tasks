--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.4.10
-- Started on 2017-01-06 10:55:49

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
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 175 (class 1259 OID 32786)
-- Name: Company; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Company" (
    "Name" character varying(250) NOT NULL
);


ALTER TABLE "Company" OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 32789)
-- Name: EmpToProject; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "EmpToProject" (
    "EmpID" integer NOT NULL,
    "Name" character varying(250)
);


ALTER TABLE "EmpToProject" OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 32804)
-- Name: EmpToProject_EmpID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "EmpToProject_EmpID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "EmpToProject_EmpID_seq" OWNER TO postgres;

--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 178
-- Name: EmpToProject_EmpID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "EmpToProject_EmpID_seq" OWNED BY "EmpToProject"."EmpID";


--
-- TOC entry 173 (class 1259 OID 32780)
-- Name: Employee; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Employee" (
    "EmpID" integer NOT NULL,
    "Name" character varying(250),
    "Department" character varying(250)
);


ALTER TABLE "Employee" OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 32792)
-- Name: Employee_EmpID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Employee_EmpID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Employee_EmpID_seq" OWNER TO postgres;

--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 177
-- Name: Employee_EmpID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Employee_EmpID_seq" OWNED BY "Employee"."EmpID";


--
-- TOC entry 174 (class 1259 OID 32783)
-- Name: Project; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Project" (
    "Name" character varying(250) NOT NULL,
    "Company" character varying(250),
    "ManagerID" integer NOT NULL
);


ALTER TABLE "Project" OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 32810)
-- Name: Project_ManagerID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Project_ManagerID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Project_ManagerID_seq" OWNER TO postgres;

--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 179
-- Name: Project_ManagerID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Project_ManagerID_seq" OWNED BY "Project"."ManagerID";


--
-- TOC entry 1901 (class 2604 OID 32806)
-- Name: EmpID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject" ALTER COLUMN "EmpID" SET DEFAULT nextval('"EmpToProject_EmpID_seq"'::regclass);


--
-- TOC entry 1899 (class 2604 OID 32794)
-- Name: EmpID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Employee" ALTER COLUMN "EmpID" SET DEFAULT nextval('"Employee_EmpID_seq"'::regclass);


--
-- TOC entry 1900 (class 2604 OID 32812)
-- Name: ManagerID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project" ALTER COLUMN "ManagerID" SET DEFAULT nextval('"Project_ManagerID_seq"'::regclass);


--
-- TOC entry 2029 (class 0 OID 32786)
-- Dependencies: 175
-- Data for Name: Company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Company" ("Name") FROM stdin;
LG
Nokia
Philips
Polaris
Samsung
Sony
JBL
\.


--
-- TOC entry 2030 (class 0 OID 32789)
-- Dependencies: 176
-- Data for Name: EmpToProject; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "EmpToProject" ("EmpID", "Name") FROM stdin;
2	4Project
5	ThirdProject
\.


--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 178
-- Name: EmpToProject_EmpID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"EmpToProject_EmpID_seq"', 1, false);


--
-- TOC entry 2027 (class 0 OID 32780)
-- Dependencies: 173
-- Data for Name: Employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Employee" ("EmpID", "Name", "Department") FROM stdin;
1	John	manager
2	Alex	it
4	Kate	manager
5	Lili	hr
6	Henry	it
\.


--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 177
-- Name: Employee_EmpID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Employee_EmpID_seq"', 12, true);


--
-- TOC entry 2028 (class 0 OID 32783)
-- Dependencies: 174
-- Data for Name: Project; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Project" ("Name", "Company", "ManagerID") FROM stdin;
ThirdProject	Polaris	5
4Project	LG	2
\.


--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 179
-- Name: Project_ManagerID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Project_ManagerID_seq"', 1, false);


--
-- TOC entry 1909 (class 2606 OID 32834)
-- Name: pk_compName; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Company"
    ADD CONSTRAINT "pk_compName" PRIMARY KEY ("Name");


--
-- TOC entry 1903 (class 2606 OID 32824)
-- Name: pk_empID; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Employee"
    ADD CONSTRAINT "pk_empID" PRIMARY KEY ("EmpID");


--
-- TOC entry 1913 (class 2606 OID 41009)
-- Name: pk_emptoproj; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT pk_emptoproj PRIMARY KEY ("EmpID");


--
-- TOC entry 1907 (class 2606 OID 32832)
-- Name: pk_projName; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT "pk_projName" PRIMARY KEY ("Name");


--
-- TOC entry 1904 (class 1259 OID 41001)
-- Name: fki_companyName; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "fki_companyName" ON "Project" USING btree ("Company");


--
-- TOC entry 1910 (class 1259 OID 40995)
-- Name: fki_empID; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "fki_empID" ON "EmpToProject" USING btree ("EmpID");


--
-- TOC entry 1905 (class 1259 OID 41007)
-- Name: fki_managerID; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "fki_managerID" ON "Project" USING btree ("ManagerID");


--
-- TOC entry 1911 (class 1259 OID 40989)
-- Name: fki_projName; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "fki_projName" ON "EmpToProject" USING btree ("Name");


--
-- TOC entry 1914 (class 2606 OID 40996)
-- Name: fk_companyName; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT "fk_companyName" FOREIGN KEY ("Company") REFERENCES "Company"("Name") ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1917 (class 2606 OID 40990)
-- Name: fk_empID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT "fk_empID" FOREIGN KEY ("EmpID") REFERENCES "Employee"("EmpID") ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1915 (class 2606 OID 41002)
-- Name: fk_managerID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT "fk_managerID" FOREIGN KEY ("ManagerID") REFERENCES "Employee"("EmpID") ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1916 (class 2606 OID 40984)
-- Name: fk_projName; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT "fk_projName" FOREIGN KEY ("Name") REFERENCES "Project"("Name") ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-01-06 10:55:50

--
-- PostgreSQL database dump complete
--

