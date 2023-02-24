-- liquibase formatted sql

--changeset rabinart:1
CREATE TABLE IF NOT EXISTS customer
(
    id BIGSERIAL PRIMARY KEY ,
    email VARCHAR(32) UNIQUE NOT NULL ,
    password
)