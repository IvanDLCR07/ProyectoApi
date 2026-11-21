-- ============================================================
--  Trabajo Evaluación 1 · Optativa · API REST de proyectos
--  Script de base de datos (solo esquema, sin datos)
--  Motor: MySQL 8.x
-- ============================================================
--  Uso:   mysql -u root -p < proyectos_schema.sql
--  (o ejecutarlo desde MySQL Workbench / DBeaver)
-- ============================================================

CREATE DATABASE IF NOT EXISTS proyectosdb
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE proyectosdb;

-- ------------------------------------------------------------
--  Tablas independientes
-- ------------------------------------------------------------

-- Estado de un proyecto (p. ej. "En desarrollo", "Finalizado")
CREATE TABLE IF NOT EXISTS status (
    status_id   INT          NOT NULL AUTO_INCREMENT,
    status_name VARCHAR(25)  NOT NULL,
    PRIMARY KEY (status_id)
) ENGINE = InnoDB;

-- Tecnologías usadas en los proyectos (p. ej. "Java", "Spring Boot")
CREATE TABLE IF NOT EXISTS technologies (
    tech_id   INT          NOT NULL AUTO_INCREMENT,
    tech_name VARCHAR(45)  NOT NULL,
    PRIMARY KEY (tech_id)
) ENGINE = InnoDB;

-- Programadores
CREATE TABLE IF NOT EXISTS developers (
    dev_id       INT           NOT NULL AUTO_INCREMENT,
    dev_name     VARCHAR(45)   NOT NULL,
    dev_surname  VARCHAR(45)   NOT NULL,
    email        VARCHAR(255),
    linkedin_url VARCHAR(255),
    github_url   VARCHAR(255),
    PRIMARY KEY (dev_id)
) ENGINE = InnoDB;

-- ------------------------------------------------------------
--  Proyectos
--  Relación 1:n con status: un estado tiene muchos proyectos y
--  cada proyecto tiene un único estado (clave foránea status_id).
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS projects (
    project_id     INT           NOT NULL AUTO_INCREMENT,
    project_name   VARCHAR(45)   NOT NULL,
    description    LONGTEXT,
    start_date     DATE,
    end_date       DATE,
    repository_url VARCHAR(255),
    demo_url       VARCHAR(255),
    picture        VARCHAR(255),
    status_id      INT,
    PRIMARY KEY (project_id),
    CONSTRAINT fk_projects_status
        FOREIGN KEY (status_id) REFERENCES status (status_id)
) ENGINE = InnoDB;

-- ------------------------------------------------------------
--  Tablas intermedias de las relaciones n:m
--  Solo contienen las dos claves foráneas (clave primaria compuesta).
--  No llevan ON DELETE CASCADE a propósito: al borrar un programador
--  o una tecnología que ya está asignado a un proyecto, MySQL
--  rechazará el borrado y la API debe controlar ese caso.
-- ------------------------------------------------------------

-- projects n:m technologies
CREATE TABLE IF NOT EXISTS technologies_used_in_projects (
    technologies_tech_id INT NOT NULL,
    projects_project_id  INT NOT NULL,
    PRIMARY KEY (technologies_tech_id, projects_project_id),
    CONSTRAINT fk_tup_technology
        FOREIGN KEY (technologies_tech_id) REFERENCES technologies (tech_id),
    CONSTRAINT fk_tup_project
        FOREIGN KEY (projects_project_id)  REFERENCES projects (project_id)
) ENGINE = InnoDB;

-- projects n:m developers
CREATE TABLE IF NOT EXISTS developers_worked_on_projects (
    developers_dev_id   INT NOT NULL,
    projects_project_id INT NOT NULL,
    PRIMARY KEY (developers_dev_id, projects_project_id),
    CONSTRAINT fk_dwp_developer
        FOREIGN KEY (developers_dev_id)   REFERENCES developers (dev_id),
    CONSTRAINT fk_dwp_project
        FOREIGN KEY (projects_project_id) REFERENCES projects (project_id)
) ENGINE = InnoDB;