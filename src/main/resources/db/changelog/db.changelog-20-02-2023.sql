-- liquibase formatted sql

--changeset rabinart:1
CREATE TABLE IF NOT EXISTS office
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(32) UNIQUE NOT NULL ,
    address VARCHAR(64) UNIQUE NOT NULL
);
-- rollback DROP TABLE office;

--changeset rabinart:2
CREATE TABLE IF NOT EXISTS personal_info
(
    id SERIAL PRIMARY KEY ,
    age INT NOT NULL ,
    status VARCHAR(16) NOT NULL ,
    description VARCHAR
);
-- rollback DROP TABLE personal_info;

--changeset rabinart:3
CREATE TABLE IF NOT EXISTS employee
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(32) NOT NULL ,
    email VARCHAR(32) UNIQUE NOT NULL ,
    balance int NOT NULL ,
    info_id INT REFERENCES personal_info UNIQUE
);
-- rollback DROP TABLE employee;

--changeset rabinart:4
CREATE TABLE IF NOT EXISTS busyness
(
    id BIGSERIAL PRIMARY KEY ,
    employee_id INT NOT NULL REFERENCES employee,
    office_id INT NOT NULL REFERENCES office,
    busy_from timestamp NOT NULL ,
    busy_till timestamp NOT NULL ,
    earned INT NOT NULL ,
    job_type VARCHAR(32) NOT NULL
);
-- rollback DROP TABLE busyness;
