INSERT INTO academy (id, name) VALUES (1, 'La Calzada'), (2, 'El Llano');
INSERT INTO teacher (id, name) VALUES (1, 'Nadia'), (2, 'Sabrina'), (3, 'Vanessa'), (4, 'Erik');
INSERT INTO student_group (id, name) VALUES (1, 'Group A'), (2, 'Group B'), (3, 'Group C'), (4, 'Group D');

-- Insertar datos en la tabla student
INSERT INTO student (id, name, surname, level, has_attendance_issues, academy_id, teacher_id, group_id)
VALUES
(1, 'Patricia', 'Fernández Bregón', 'B2', false, 1, 1, 1),
(2, 'Ana', 'Martínez', 'C1', false, 2, 2, 2),
(3, 'Mario', 'López', 'A2', true, 2, 3, 3),
(4, 'Lucía', 'García', 'C2', false, 1, 4, 4);