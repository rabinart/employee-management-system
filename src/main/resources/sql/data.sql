INSERT INTO employee (name, balance)
VALUES ('Artem', 0),
       ('Vlada', 0),
       ('Oleg', 0),
       ('Ignat', 0),
       ('Maxim', 0),
       ('Rosa', 0),
       ('Fipi', 0),
       ('Pupi', 0);

INSERT INTO personal_info (age, status, description, employee_id)
VALUES (29, 'ACTIVE', 'Ext carot art lig-epist', 1),
       (56, 'ACTIVE', 'Part adrenalectomy NEC', 2),
       (64, 'ACTIVE', 'Exten buccolabial/sulcus', 3),
       (26, 'ACTIVE', 'Revis exenter cavity NEC', 4),
       (45, 'ACTIVE', 'Revis enuc socket w grft', 5),
       (45, 'ACTIVE', 'Toe reattachment', 6),
       (44, 'ACTIVE', 'Soft tissue inject NEC', 7),
       (66, 'ACTIVE', 'Replace vag/vulv packing', 8);

INSERT INTO office (name, address)
VALUES ('Nirvana', 'Boryivojova'),
       ('SpaForMen', 'Namesti miru'),
       ('Relax', 'Andel');

INSERT INTO busyness (employee_id, office_id, busy_from, busy_till, earned, job_type)
VALUES (1, 1, '2023-02-18 10:00', '2023-02-18 12:00', 600, 'Drochka'),
       (2, 1, '2023-02-18 10:00', '2023-02-18 11:00', 600, 'Drochka'),
       (3, 1, '2023-02-18 10:00', '2023-02-18 11:30', 1000, 'Drochka s igruskami'),
       (3, 1, '2023-02-18 12:00', '2023-02-18 13:30', 1000, 'Drochka s igruskami');

UPDATE employee SET balance = 600 WHERE id in (1,2);
UPDATE employee SET balance = 2000 WHERE id = 3;

SELECT * FROM employee