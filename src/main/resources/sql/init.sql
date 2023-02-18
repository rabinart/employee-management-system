CREATE TABLE IF NOT EXISTS office
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(32) UNIQUE NOT NULL ,
    address VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS personal_info
(
  id SERIAL PRIMARY KEY ,
  age INT NOT NULL ,
  status VARCHAR(16) ,
  description VARCHAR
);

CREATE TABLE IF NOT EXISTS employee
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(32) NOT NULL ,
    balance int NOT NULL ,
    personal_info_id INT REFERENCES personal_info
);


CREATE TABLE IF NOT EXISTS busyness
(
    id BIGSERIAL PRIMARY KEY ,
    employee_id INT NOT NULL REFERENCES employee,
    office_id INT NOT NULL REFERENCES office,
    busy_from timestamp ,
    busy_till timestamp ,
    earned INT ,
    job_type VARCHAR(32)
);
