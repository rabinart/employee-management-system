INSERT INTO personal_info (age, status, description)
VALUES (29, 'ACTIVE', 'Ext carot art lig-epist'),
       (56, 'ACTIVE', 'Part adrenalectomy NEC'),
       (64, 'ACTIVE', 'Exten buccolabial/sulcus'),
       (26, 'ACTIVE', 'Revis exenter cavity NEC'),
       (45, 'ACTIVE', 'Revis enuc socket w grft'),
       (45, 'ACTIVE', 'Toe reattachment'),
       (44, 'ACTIVE', 'Soft tissue inject NEC'),
       (66, 'ACTIVE', 'Replace vag/vulv packing');

INSERT INTO employee (name, balance, email, info_id)
VALUES ('Artem', 0, 'Artem@ba.ba', 1),
       ('Vlada', 0, 'Vlada@ba.ba', 2),
       ('Oleg', 0, 'Oleg@ba.ba',3),
       ('Ignat', 0, 'Ignat@ba.ba',4),
       ('Maxim', 0, 'Maxim@ba.ba',5),
       ('Rosa', 0, 'Rosa@ba.ba',6),
       ('Fipi', 0, 'Fipi@ba.ba',7),
       ('Pupi', 0, 'Pupi@ba.ba',8);

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

