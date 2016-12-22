--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

-- Started on 2016-12-06 14:49:45 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12655)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2418 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16402)
-- Name: Company; Type: TABLE; Schema: public; Owner: artem
--

CREATE TABLE "Company" (
    "Name" character varying(100) NOT NULL
);


ALTER TABLE "Company" OWNER TO artem;

--
-- TOC entry 188 (class 1259 OID 16436)
-- Name: EmpToProject; Type: TABLE; Schema: public; Owner: artem
--

CREATE TABLE "EmpToProject" (
    "EmpID" integer,
    "Name" character varying(100)
);


ALTER TABLE "EmpToProject" OWNER TO artem;

--
-- TOC entry 185 (class 1259 OID 16392)
-- Name: Employee; Type: TABLE; Schema: public; Owner: artem
--

CREATE TABLE "Employee" (
    "EmpID" integer NOT NULL,
    "Name" character(15) NOT NULL,
    "Department" character(100)
);


ALTER TABLE "Employee" OWNER TO artem;

--
-- TOC entry 187 (class 1259 OID 16415)
-- Name: Project; Type: TABLE; Schema: public; Owner: artem
--

CREATE TABLE "Project" (
    "Name" character varying(100) NOT NULL,
    "Company" character varying(100) NOT NULL,
    "ManagerID" integer NOT NULL
);


ALTER TABLE "Project" OWNER TO artem;

--
-- TOC entry 2409 (class 0 OID 16402)
-- Dependencies: 186
-- Data for Name: Company; Type: TABLE DATA; Schema: public; Owner: artem
--

INSERT INTO "Company" VALUES ('Выбор');
INSERT INTO "Company" VALUES ('СК Вавилон');
INSERT INTO "Company" VALUES ('Квартал');
INSERT INTO "Company" VALUES ('ОАО ДСК');
INSERT INTO "Company" VALUES ('Камелот');
INSERT INTO "Company" VALUES ('Деловые Линии');
INSERT INTO "Company" VALUES ('Инстеп');
INSERT INTO "Company" VALUES ('Экспресс');
INSERT INTO "Company" VALUES ('Газпром Межрегионгаз Воронеж');
INSERT INTO "Company" VALUES ('NEC Corporation');
INSERT INTO "Company" VALUES ('Megafon');
INSERT INTO "Company" VALUES ('Ukos');
INSERT INTO "Company" VALUES ('Microsoft');
INSERT INTO "Company" VALUES ('Netcracker');
INSERT INTO "Company" VALUES ('Times');
INSERT INTO "Company" VALUES ('Oracle');
INSERT INTO "Company" VALUES ('Sun');


--
-- TOC entry 2411 (class 0 OID 16436)
-- Dependencies: 188
-- Data for Name: EmpToProject; Type: TABLE DATA; Schema: public; Owner: artem
--

INSERT INTO "EmpToProject" VALUES (3, '4G');
INSERT INTO "EmpToProject" VALUES (4, '4G');
INSERT INTO "EmpToProject" VALUES (3, 'Dos');
INSERT INTO "EmpToProject" VALUES (7, 'HTC mobile');
INSERT INTO "EmpToProject" VALUES (8, 'Dos');
INSERT INTO "EmpToProject" VALUES (1, 'Dos');
INSERT INTO "EmpToProject" VALUES (8, 'Kursovoi');
INSERT INTO "EmpToProject" VALUES (9, 'Kursovoi');
INSERT INTO "EmpToProject" VALUES (9, 'Windows 300');
INSERT INTO "EmpToProject" VALUES (10, 'MacOS');


--
-- TOC entry 2408 (class 0 OID 16392)
-- Dependencies: 185
-- Data for Name: Employee; Type: TABLE DATA; Schema: public; Owner: artem
--

INSERT INTO "Employee" VALUES (1, 'Ivanov         ', 'Designer                                                                                            ');
INSERT INTO "Employee" VALUES (2, 'Petrov         ', 'Developer                                                                                           ');
INSERT INTO "Employee" VALUES (3, 'Sidorov        ', 'Manager                                                                                             ');
INSERT INTO "Employee" VALUES (4, 'Minakov        ', 'Analyst                                                                                             ');
INSERT INTO "Employee" VALUES (5, 'Studenov       ', 'Financier                                                                                           ');
INSERT INTO "Employee" VALUES (6, 'Sviridin       ', 'Designer                                                                                            ');
INSERT INTO "Employee" VALUES (7, 'Finberg        ', 'Developer                                                                                           ');
INSERT INTO "Employee" VALUES (8, 'Bill Geits     ', 'Manager                                                                                             ');
INSERT INTO "Employee" VALUES (9, 'Tsukenberg     ', 'Analyst                                                                                             ');
INSERT INTO "Employee" VALUES (10, 'Jobs           ', 'Financier                                                                                           ');


--
-- TOC entry 2410 (class 0 OID 16415)
-- Dependencies: 187
-- Data for Name: Project; Type: TABLE DATA; Schema: public; Owner: artem
--

INSERT INTO "Project" VALUES ('4G', 'NEC Corporation', 3);
INSERT INTO "Project" VALUES ('Dos', 'Megafon', 3);
INSERT INTO "Project" VALUES ('HTC mobile', 'Ukos', 3);
INSERT INTO "Project" VALUES ('Kursovoi', 'Microsoft', 3);
INSERT INTO "Project" VALUES ('Facebook', 'Netcracker', 3);
INSERT INTO "Project" VALUES ('Windows 300', 'Microsoft', 8);
INSERT INTO "Project" VALUES ('DWDM', 'Times', 8);
INSERT INTO "Project" VALUES ('vk.com', 'Netcracker', 8);
INSERT INTO "Project" VALUES ('MacOS', 'Oracle', 8);


--
-- TOC entry 2280 (class 2606 OID 16450)
-- Name: Company Company_Name_key; Type: CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "Company"
    ADD CONSTRAINT "Company_Name_key" UNIQUE ("Name");


--
-- TOC entry 2282 (class 2606 OID 16423)
-- Name: Company Company_pkey; Type: CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "Company"
    ADD CONSTRAINT "Company_pkey" PRIMARY KEY ("Name");


--
-- TOC entry 2286 (class 2606 OID 16419)
-- Name: Project pk_proj; Type: CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT pk_proj PRIMARY KEY ("Name");


--
-- TOC entry 2278 (class 2606 OID 16401)
-- Name: Employee pl_emp; Type: CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "Employee"
    ADD CONSTRAINT pl_emp PRIMARY KEY ("EmpID");


--
-- TOC entry 2283 (class 1259 OID 16429)
-- Name: fki_company_name; Type: INDEX; Schema: public; Owner: artem
--

CREATE INDEX fki_company_name ON "Project" USING btree ("Company");


--
-- TOC entry 2284 (class 1259 OID 16435)
-- Name: fki_manager_employee; Type: INDEX; Schema: public; Owner: artem
--

CREATE INDEX fki_manager_employee ON "Project" USING btree ("ManagerID");


--
-- TOC entry 2287 (class 2606 OID 16424)
-- Name: Project fk_company_name; Type: FK CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT fk_company_name FOREIGN KEY ("Company") REFERENCES "Company"("Name");


--
-- TOC entry 2289 (class 2606 OID 16439)
-- Name: EmpToProject fk_empid_employee; Type: FK CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT fk_empid_employee FOREIGN KEY ("EmpID") REFERENCES "Employee"("EmpID");


--
-- TOC entry 2288 (class 2606 OID 16430)
-- Name: Project fk_manager_employee; Type: FK CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "Project"
    ADD CONSTRAINT fk_manager_employee FOREIGN KEY ("ManagerID") REFERENCES "Employee"("EmpID");


--
-- TOC entry 2290 (class 2606 OID 16444)
-- Name: EmpToProject fk_project_name; Type: FK CONSTRAINT; Schema: public; Owner: artem
--

ALTER TABLE ONLY "EmpToProject"
    ADD CONSTRAINT fk_project_name FOREIGN KEY ("Name") REFERENCES "Project"("Name");


-- Completed on 2016-12-06 14:49:46 MSK

--
-- PostgreSQL database dump complete
--

