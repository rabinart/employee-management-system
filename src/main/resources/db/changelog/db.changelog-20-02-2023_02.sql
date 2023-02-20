-- liquibase formatted sql

--changeset rabinart:1
ALTER TABLE busyness
    ADD COLUMN created_at TIMESTAMP;
--rollback ALTER TABLE busyness DROP COLUMN created_at;

--changeset rabinart:2
ALTER TABLE busyness
    ADD COLUMN modified_at TIMESTAMP;
--rollback ALTER TABLE busyness DROP COLUMN modified_at;

--changeset rabinart:3
ALTER TABLE busyness
    ADD COLUMN created_by VARCHAR(32);
--rollback ALTER TABLE busyness DROP COLUMN created_by;

--changeset rabinart:4
ALTER TABLE busyness
    ADD COLUMN modified_by VARCHAR(32);
--rollback ALTER TABLE busyness DROP COLUMN modified_bt;

--changeset rabinart:5
CREATE TABLE IF NOT EXISTS revision
(
    id SERIAL PRIMARY KEY ,
    timestamp BIGINT NOT NULL
);
--rollback DROP TABLE revision

--changeset rabinart:6
CREATE TABLE IF NOT EXISTS busyness_aud
(
    id BIGINT,
    rev INT REFERENCES revision (id),
    revtype SMALLINT ,
    employee_id INT NOT NULL REFERENCES employee,
    office_id INT NOT NULL REFERENCES office,
    busy_from timestamp NOT NULL ,
    busy_till timestamp NOT NULL ,
    earned INT NOT NULL ,
    job_type VARCHAR(32) NOT NULL
);
--rollback DROP TABLE users_aud
