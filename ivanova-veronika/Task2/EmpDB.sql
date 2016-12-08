--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.4.10
-- Started on 2016-12-08 00:30:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2024 (class 1262 OID 16393)
-- Name: EmployeesDB; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "EmployeesDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE "EmployeesDB" OWNER TO postgres;

\connect "EmployeesDB"

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
-- TOC entry 174 (class 1259 OID 16427)
-- Name: Company; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Company" (
    "Name" character varying(100) NOT NULL
);


ALTER TABLE "Company" OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16437)
-- Name: EmpToProject; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "EmpToProject" (
    "Name" character varying(100) NOT NULL,
    "EmpID" bigint NOT NULL
);


ALTER TABLE "EmpToProject" OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16421)
-- Name: Employee; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Employee" (
    "Name" character varying(100) NOT NULL,
    "Department" character varying(100) NOT NULL,
    "EmpID" integer NOT NULL
);


ALTER TABLE "Employee" OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16442)
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
-- Dependencies: 177
-- Name: Employee_EmpID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Employee_EmpID_seq" OWNED BY "Employee"."EmpID";


--
-- TOC entry 175 (class 1259 OID 16432)
-- Name: Project; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Project" (
    "Name" character varying(100) NOT NULL,
    "Company" character varying(100),
    "Manager" bigint
);


ALTER TABLE "Project" OWNER TO postgres;

--
-- TOC entry 1893 (class 2604 OID 16444)
-- Name: EmpID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Employee" ALTER COLUMN "EmpID" SET DEFAULT nextval('"Employee_EmpID_seq"'::regclass);


--
-- TOC entry 2016 (class 0 OID 16427)
-- Dependencies: 174
-- Data for Name: Company; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Company" ("Name") VALUES ('MyFirstCompany');
INSERT INTO "Company" ("Name") VALUES ('MySecondCompany');
INSERT INTO "Company" ("Name") VALUES ('NewCompany');
INSERT INTO "Company" ("Name") VALUES ('Hello World Company');
INSERT INTO "Company" ("Name") VALUES ('SomeCompany');


--
-- TOC entry 2018 (class 0 OID 16437)
-- Dependencies: 176
-- Data for Name: EmpToProject; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('BestProject', 3);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('BestProject', 4);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('BestProject', 5);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('First Project', 1);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('First Project', 2);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Second', 4);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Second', 2);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Second', 3);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Hello World', 2);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Hello World', 5);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Hello World', 6);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Task', 6);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Task', 4);
INSERT INTO "EmpToProject" ("Name", "EmpID") VALUES ('Task', 3);


--
-- TOC entry 2015 (class 0 OID 16421)
-- Dependencies: 173
-- Data for Name: Employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Employee" ("Name", "Department", "EmpID") VALUES ('Petrov', 'Dep1', 2);
INSERT INTO "Employee" ("Name", "Department", "EmpID") VALUES ('Benghezal', 'CoolDep', 3);
INSERT INTO "Employee" ("Name", "Department", "EmpID") VALUES ('Ivanova', 'CoolDep', 4);
INSERT INTO "Employee" ("Name", "Department", "EmpID") VALUES ('Sidorov', 'Dep2', 5);
INSERT INTO "Employee" ("Name", "Department", "EmpID") VALUES ('NewEmployee', 'NewDep', 7);
INSERT INTO "Employee" ("Name", "Department", "EmpID") VALUES ('Ivanov', 'DepNew', 1);
INSERT INTO "Employee" ("Name", "Department", "EmpID") VALUES ('Kozlov', 'DepNew', 6);


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 177
-- Name: Employee_EmpID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Employee_EmpID_seq"', 7, true);


--
-- TOC entry 2017 (class 0 OID 16432)
-- Dependencies: 175
-- Data for Name: Project; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "Project" ("Name", "Company", "Manager") VALUES ('First Project', 'MyFirstCompany', 1);
INSERT INTO "Project" ("Name", "Company", "Manager") VALUES ('Second', 'MySecondCompany', 4);
INSERT INTO "Project" ("Name", "Company", "Manager") VALUES ('Task', 'SomeCompany', 4);
INSERT INTO "Project" ("Name", "Company", "Manager") VALUES ('Hello World', 'Hello World Company', 2);
INSERT INTO "Project" ("Name", "Company", "Manager") VALUES ('BestProject', 'SomeCompany', 3);


--
-- TOC entry 1897 (class 2606 OID 16431)
-- Name: PK_Comp_Name; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Company"
    ADD CONSTRAINT "PK_Comp_Name" PRIMARY KEY ("Name");


--
-- TOC entry 1895 (class 2606 OID 16449)
-- Name: PK_Emp; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Employee"
    ADD CONSTRAINT "PK_Emp" PRIMARY KEY ("EmpID");


--
-- TOC entry 1901 (class 2606 OID 16441)
-- Name: PK_Emp_Project; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT "PK_Emp_Project" PRIMARY KEY ("Name", "EmpID");


--
-- TOC entry 1899 (class 2606 OID 16436)
-- Name: PK_Project_Name; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT "PK_Project_Name" PRIMARY KEY ("Name");


--
-- TOC entry 1902 (class 2606 OID 16460)
-- Name: FK_Comp_Name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT "FK_Comp_Name" FOREIGN KEY ("Company") REFERENCES "Company"("Name");


--
-- TOC entry 1904 (class 2606 OID 16450)
-- Name: FK_EmpID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT "FK_EmpID" FOREIGN KEY ("EmpID") REFERENCES "Employee"("EmpID");


--
-- TOC entry 1903 (class 2606 OID 16465)
-- Name: FK_ManagerID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT "FK_ManagerID" FOREIGN KEY ("Manager") REFERENCES "Employee"("EmpID");


--
-- TOC entry 1905 (class 2606 OID 16455)
-- Name: FK_Project_Name; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT "FK_Project_Name" FOREIGN KEY ("Name") REFERENCES "Project"("Name");


--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-08 00:30:44

--
-- PostgreSQL database dump complete
--

