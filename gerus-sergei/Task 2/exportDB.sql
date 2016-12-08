--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.5.5

-- Started on 2016-12-08 23:16:07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2024 (class 1262 OID 16393)
-- Name: CompanyBD; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "CompanyBD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE "CompanyBD" OWNER TO postgres;

\connect "CompanyBD"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

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
-- TOC entry 177 (class 1259 OID 16428)
-- Name: Company; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Company" (
    "Name" character varying(30) NOT NULL
);


ALTER TABLE "Company" OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16422)
-- Name: EmpToProject; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "EmpToProject" (
    "EmpID" integer NOT NULL,
    "Name" text NOT NULL
);


ALTER TABLE "EmpToProject" OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16396)
-- Name: Employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Employee" (
    "EmpID" integer NOT NULL,
    "Name" character varying(10) NOT NULL,
    "Department" character varying(10)
);


ALTER TABLE "Employee" OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16403)
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
-- TOC entry 2028 (class 0 OID 0)
-- Dependencies: 174
-- Name: Employee_EmpID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Employee_EmpID_seq" OWNED BY "Employee"."EmpID";


--
-- TOC entry 175 (class 1259 OID 16414)
-- Name: Project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Project" (
    "Name" character varying(10) NOT NULL,
    "Company" character varying(30),
    "ManagerID" integer
);


ALTER TABLE "Project" OWNER TO postgres;

--
-- TOC entry 1894 (class 2604 OID 16405)
-- Name: EmpID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Employee" ALTER COLUMN "EmpID" SET DEFAULT nextval('"Employee_EmpID_seq"'::regclass);


--
-- TOC entry 2019 (class 0 OID 16428)
-- Dependencies: 177
-- Data for Name: Company; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Company" ("Name") VALUES ('Microsoft');
INSERT INTO "Company" ("Name") VALUES ('NEC');
INSERT INTO "Company" ("Name") VALUES ('Samsung');
INSERT INTO "Company" ("Name") VALUES ('LG');
INSERT INTO "Company" ("Name") VALUES ('Sony');


--
-- TOC entry 2018 (class 0 OID 16422)
-- Dependencies: 176
-- Data for Name: EmpToProject; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "EmpToProject" ("EmpID", "Name") VALUES (2, 'Project 1');
INSERT INTO "EmpToProject" ("EmpID", "Name") VALUES (2, 'Project 2');
INSERT INTO "EmpToProject" ("EmpID", "Name") VALUES (1, 'Project 5');
INSERT INTO "EmpToProject" ("EmpID", "Name") VALUES (3, 'Project 3');


--
-- TOC entry 2015 (class 0 OID 16396)
-- Dependencies: 173
-- Data for Name: Employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Employee" ("EmpID", "Name", "Department") VALUES (2, 'Петров', 'Developer');
INSERT INTO "Employee" ("EmpID", "Name", "Department") VALUES (3, 'Сидоров', 'Manager');
INSERT INTO "Employee" ("EmpID", "Name", "Department") VALUES (5, 'Павлов', 'Top manage');
INSERT INTO "Employee" ("EmpID", "Name", "Department") VALUES (1, 'Иванов', 'Clerk');


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 174
-- Name: Employee_EmpID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Employee_EmpID_seq"', 5, true);


--
-- TOC entry 2017 (class 0 OID 16414)
-- Dependencies: 175
-- Data for Name: Project; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Project" ("Name", "Company", "ManagerID") VALUES ('Project 1', 'NEC', 1);
INSERT INTO "Project" ("Name", "Company", "ManagerID") VALUES ('Project 2', 'LG', 3);
INSERT INTO "Project" ("Name", "Company", "ManagerID") VALUES ('Project 3', 'NEC', 2);
INSERT INTO "Project" ("Name", "Company", "ManagerID") VALUES ('Project 5', 'Samsung', 1);
INSERT INTO "Project" ("Name", "Company", "ManagerID") VALUES ('Project 4', NULL, 3);


--
-- TOC entry 1896 (class 2606 OID 16413)
-- Name: EmpID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Employee"
    ADD CONSTRAINT "EmpID" PRIMARY KEY ("EmpID");


--
-- TOC entry 1898 (class 2606 OID 16496)
-- Name: Name; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT "Name" PRIMARY KEY ("Name");


--
-- TOC entry 1901 (class 2606 OID 16483)
-- Name: company_name_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Company"
    ADD CONSTRAINT company_name_pk PRIMARY KEY ("Name");


--
-- TOC entry 1899 (class 1259 OID 16484)
-- Name: Company_Name_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX "Company_Name_uindex" ON "Company" USING btree ("Name");


--
-- TOC entry 1904 (class 2606 OID 16437)
-- Name: emptoproject_employee_empid_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT emptoproject_employee_empid_fk FOREIGN KEY ("EmpID") REFERENCES "Employee"("EmpID");


--
-- TOC entry 1905 (class 2606 OID 16497)
-- Name: emptoproject_project_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT emptoproject_project_name_fk FOREIGN KEY ("Name") REFERENCES "Project"("Name");


--
-- TOC entry 1903 (class 2606 OID 16518)
-- Name: project_company_name_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT project_company_name_fk FOREIGN KEY ("Company") REFERENCES "Company"("Name");


--
-- TOC entry 1902 (class 2606 OID 16452)
-- Name: project_employee_empid_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT project_employee_empid_fk FOREIGN KEY ("ManagerID") REFERENCES "Employee"("EmpID");


--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-08 23:16:08

--
-- PostgreSQL database dump complete
--

