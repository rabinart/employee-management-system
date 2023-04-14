
INSERT INTO personal_info (id, age, status, description)
VALUES (1 ,29, 'ACTIVE', 'Ext carot art lig-epist'),
       (2,56, 'ACTIVE', 'Part adrenalectomy NEC'),
       (3,64, 'ACTIVE', 'Exten buccolabial/sulcus'),
       (4,26, 'ACTIVE', 'Revis exenter cavity NEC'),
       (5,45, 'ACTIVE', 'Revis enuc socket w grft'),
       (6,45, 'ACTIVE', 'Toe reattachment'),
       (7,44, 'ACTIVE', 'Soft tissue inject NEC'),
       (8,66, 'ACTIVE', 'Replace vag/vulv packing');
SELECT SETVAL('personal_info_id_seq', (SELECT max(id) FROM personal_info));

INSERT INTO employee (id, name, balance, email, info_id)
VALUES (1, 'Artem', 0, 'Artem@ba.ba', 1),
       (2,'Vlada', 0, 'Vlada@ba.ba', 2),
       (3,'Oleg', 0, 'Oleg@ba.ba',3),
       (4,'Ignat', 0, 'Ignat@ba.ba',4),
       (5, 'Maxim', 0, 'Maxim@ba.ba',5),
       (6, 'Rosa', 0, 'Rosa@ba.ba',6),
       (7, 'Fipi', 0, 'Fipi@ba.ba',7),
       (8, 'Pupi', 0, 'Pupi@ba.ba', 8);
SELECT SETVAL('employee_id_seq', (SELECT max(id) FROM employee));


INSERT INTO office (id, name, address)
VALUES (1, 'Nirvana', 'Boryivojova'),
       (2, 'SpaForMen', 'Namesti miru'),
       (3, 'Relax', 'Andel');
SELECT SETVAL('office_id_seq', (SELECT max(id) FROM office));


INSERT INTO busyness (id, employee_id, office_id, busy_from, busy_till, earned, job_type)
VALUES (1, 1, 1, '2023-02-18 10:00', '2023-02-18 12:00', 600, 'Basic Phone Repair'),
       (2, 2, 1, '2023-02-18 10:00', '2023-02-18 11:00', 600, 'Basic Phone Repair'),
       (3, 3, 1, '2023-02-18 10:00', '2023-02-18 11:30', 1000, 'Professional screen repair'),
       (4, 1, 1, '2023-02-19 10:00', '2023-02-19 11:30', 1000, 'Professional screen repair'),
       (5, 3, 1, '2023-02-18 12:00', '2023-02-18 13:30', 1000, 'Professional screen repair');
SELECT SETVAL('busyness_id_seq', (SELECT max(id) FROM busyness));


UPDATE employee SET balance = 600 WHERE id in (1,2);
UPDATE employee SET balance = 2000 WHERE id = 3;


